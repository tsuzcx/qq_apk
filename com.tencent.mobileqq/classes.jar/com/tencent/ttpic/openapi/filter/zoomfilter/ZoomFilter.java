package com.tencent.ttpic.openapi.filter.zoomfilter;

import android.graphics.PointF;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.ttpic.filter.RotateScaleFilter;
import com.tencent.ttpic.openapi.PTDetectInfo;
import com.tencent.ttpic.openapi.PTFaceAttr;
import com.tencent.ttpic.openapi.model.StickerItem;
import com.tencent.ttpic.trigger.ZoomTriggerCtrlItem.ZoomModel;
import com.tencent.ttpic.util.FrameUtil;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class ZoomFilter
  extends RotateScaleFilter
{
  private static final String FRAGMENT_SHADER = "precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nuniform float alpha;\n\nvoid main() \n{\n    vec4 color = texture2D (inputImageTexture, textureCoordinate);\n    gl_FragColor = vec4 (color.rgb * color.a * alpha, color.a * alpha);\n}";
  private static final String VERTEX_SHADER = "precision highp float;\nattribute vec4 position;\nattribute vec2 inputTextureCoordinate;\nvarying vec2 textureCoordinate;\n\nuniform float texScale;\nuniform float texRotate;\nuniform vec2 anchor;\nuniform vec2 translate;\nuniform vec2 canvasSize;\n\nconst float PI = 3.14159;\n\nmat4 texMatScale = mat4(1.0, 0.0, 0.0, 0.0,\n                        0.0, 1.0, 0.0, 0.0,\n                        0.0, 0.0, 1.0, 0.0,\n                        0.0, 0.0, 0.0, 1.0);\n\nmat4 texMatRotate = mat4(1.0, 0.0, 0.0, 0.0,\n                         0.0, 1.0, 0.0, 0.0,\n                         0.0, 0.0, 1.0, 0.0,\n                         0.0, 0.0, 0.0, 1.0);\n\nmat4 mat4RotationYXZ(mat4 m, float xRadians, float yRadians, float zRadians) {\n    /*\n     |  cycz + sxsysz   czsxsy - cysz   cxsy  0 |\n M = |  cxsz            cxcz           -sx    0 |\n     |  cysxsz - czsy   cyczsx + sysz   cxcy  0 |\n     |  0               0               0     1 |\n\n     where cA = cos(A), sA = sin(A) for A = x,y,z\n     */\n\n    float cx = cos(xRadians);\n    float sx = sin(xRadians);\n    float cy = cos(yRadians);\n    float sy = sin(yRadians);\n    float cz = cos(zRadians);\n    float sz = sin(zRadians);\n\n    m[0][0] = (cy * cz) + (sx * sy * sz);\n    m[0][1] = cx * sz;\n    m[0][2] = (cy * sx * sz) - (cz * sy);\n    m[0][3] = 0.0;\n\n    m[1][0] = (cz * sx * sy) - (cy * sz);\n    m[1][1] = cx * cz;\n    m[1][2] = (cy * cz * sx) + (sy * sz);\n    m[1][3] = 0.0;\n\n    m[2][0] = cx * sy;\n    m[2][1] = -sx;\n    m[2][2] = cx * cy;\n    m[2][3] = 0.0;\n\n    m[3][0] = 0.0;\n    m[3][1] = 0.0;\n    m[3][2] = 0.0;\n    m[3][3] = 1.0;\n\n    return m;\n}\n\nvoid main(){\n    vec4 framePos = position;\n\n\n    texMatScale[0][0] = texScale;\n    texMatScale[1][1] = texScale;\n    texMatRotate[3][0] = -anchor.x;\n    texMatRotate[3][1] = -anchor.y;\n\n\n    framePos = texMatScale * texMatRotate * framePos;\n\n\n\n    gl_Position = framePos;\n    textureCoordinate = inputTextureCoordinate;\n}";
  protected final String TAG = "ZoomFilter";
  private PointF TRANSLATE = new PointF(0.0F, 0.0F);
  private String effectZoomId;
  private PointF mCanvans = new PointF();
  protected Frame mRotateScaleFrame = new Frame();
  protected TransScaleInfo mTransScaleInfo = new TransScaleInfo();
  protected HashMap<String, ZoomInfo> mZoomMap;
  private ZoomTriggerCtrlItem.ZoomModel zoomModel;
  
  public ZoomFilter()
  {
    super("precision highp float;\nattribute vec4 position;\nattribute vec2 inputTextureCoordinate;\nvarying vec2 textureCoordinate;\n\nuniform float texScale;\nuniform float texRotate;\nuniform vec2 anchor;\nuniform vec2 translate;\nuniform vec2 canvasSize;\n\nconst float PI = 3.14159;\n\nmat4 texMatScale = mat4(1.0, 0.0, 0.0, 0.0,\n                        0.0, 1.0, 0.0, 0.0,\n                        0.0, 0.0, 1.0, 0.0,\n                        0.0, 0.0, 0.0, 1.0);\n\nmat4 texMatRotate = mat4(1.0, 0.0, 0.0, 0.0,\n                         0.0, 1.0, 0.0, 0.0,\n                         0.0, 0.0, 1.0, 0.0,\n                         0.0, 0.0, 0.0, 1.0);\n\nmat4 mat4RotationYXZ(mat4 m, float xRadians, float yRadians, float zRadians) {\n    /*\n     |  cycz + sxsysz   czsxsy - cysz   cxsy  0 |\n M = |  cxsz            cxcz           -sx    0 |\n     |  cysxsz - czsy   cyczsx + sysz   cxcy  0 |\n     |  0               0               0     1 |\n\n     where cA = cos(A), sA = sin(A) for A = x,y,z\n     */\n\n    float cx = cos(xRadians);\n    float sx = sin(xRadians);\n    float cy = cos(yRadians);\n    float sy = sin(yRadians);\n    float cz = cos(zRadians);\n    float sz = sin(zRadians);\n\n    m[0][0] = (cy * cz) + (sx * sy * sz);\n    m[0][1] = cx * sz;\n    m[0][2] = (cy * sx * sz) - (cz * sy);\n    m[0][3] = 0.0;\n\n    m[1][0] = (cz * sx * sy) - (cy * sz);\n    m[1][1] = cx * cz;\n    m[1][2] = (cy * cz * sx) + (sy * sz);\n    m[1][3] = 0.0;\n\n    m[2][0] = cx * sy;\n    m[2][1] = -sx;\n    m[2][2] = cx * cy;\n    m[2][3] = 0.0;\n\n    m[3][0] = 0.0;\n    m[3][1] = 0.0;\n    m[3][2] = 0.0;\n    m[3][3] = 1.0;\n\n    return m;\n}\n\nvoid main(){\n    vec4 framePos = position;\n\n\n    texMatScale[0][0] = texScale;\n    texMatScale[1][1] = texScale;\n    texMatRotate[3][0] = -anchor.x;\n    texMatRotate[3][1] = -anchor.y;\n\n\n    framePos = texMatScale * texMatRotate * framePos;\n\n\n\n    gl_Position = framePos;\n    textureCoordinate = inputTextureCoordinate;\n}", "precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nuniform float alpha;\n\nvoid main() \n{\n    vec4 color = texture2D (inputImageTexture, textureCoordinate);\n    gl_FragColor = vec4 (color.rgb * color.a * alpha, color.a * alpha);\n}");
  }
  
  private boolean notNeedZoomProcess()
  {
    return (this.mTransScaleInfo.anchorPoint.x == 0.0F) && (this.mTransScaleInfo.anchorPoint.y == 0.0F) && (this.mTransScaleInfo.scaleValue == 1.0F);
  }
  
  public Frame RenderProcess(Frame paramFrame)
  {
    if ((this.effectZoomId == null) || (paramFrame == null) || (notNeedZoomProcess())) {
      return paramFrame;
    }
    this.mCanvans.x = paramFrame.width;
    this.mCanvans.y = paramFrame.height;
    updateParams(this.mTransScaleInfo.scaleValue, 0.0F, 1.0F, this.mTransScaleInfo.anchorPoint, this.TRANSLATE, this.mCanvans);
    FrameUtil.clearFrame(this.mRotateScaleFrame, 0.0F, 0.0F, 0.0F, 0.0F, paramFrame.width, paramFrame.height);
    RenderProcess(paramFrame.getTextureId(), paramFrame.width, paramFrame.height, -1, 0.0D, this.mRotateScaleFrame);
    return this.mRotateScaleFrame;
  }
  
  public void addItem(StickerItem paramStickerItem)
  {
    if (paramStickerItem == null) {
      return;
    }
    if (this.mZoomMap == null) {
      this.mZoomMap = new HashMap();
    }
    this.mZoomMap.put(paramStickerItem.id, new ZoomInfo(paramStickerItem));
  }
  
  public void clear()
  {
    super.clearGLSLSelf();
    reset();
    if (this.mZoomMap != null) {
      this.mZoomMap.clear();
    }
    this.mRotateScaleFrame.clear();
  }
  
  public void reset()
  {
    if (this.mZoomMap != null)
    {
      Iterator localIterator = this.mZoomMap.values().iterator();
      while (localIterator.hasNext()) {
        ((ZoomInfo)localIterator.next()).reset();
      }
    }
    this.effectZoomId = null;
    this.zoomModel = null;
  }
  
  public void setZoomModel(ZoomTriggerCtrlItem.ZoomModel paramZoomModel)
  {
    this.zoomModel = paramZoomModel;
  }
  
  public void updateZoomParams(PTFaceAttr paramPTFaceAttr, PTDetectInfo paramPTDetectInfo, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((this.zoomModel == null) || (this.zoomModel.zoomId == null))
    {
      this.effectZoomId = null;
      return;
    }
    if ((!this.zoomModel.zoomId.equals(this.effectZoomId)) && (this.effectZoomId != null))
    {
      ((ZoomInfo)this.mZoomMap.get(this.effectZoomId)).reset();
      this.mTransScaleInfo.reset();
    }
    this.effectZoomId = this.zoomModel.zoomId;
    paramPTDetectInfo = (ZoomInfo)this.mZoomMap.get(this.effectZoomId);
    paramPTDetectInfo.reset();
    paramPTDetectInfo.updateZoomInfo(paramPTFaceAttr, paramInt1, paramInt2, this.zoomModel.frameIndex, this.mTransScaleInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.zoomfilter.ZoomFilter
 * JD-Core Version:    0.7.0.1
 */