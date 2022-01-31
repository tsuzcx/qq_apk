package com.tencent.ttpic.filter;

import android.graphics.PointF;
import com.tencent.aekit.openrender.AEOpenRenderConfig.DRAW_MODE;
import com.tencent.aekit.openrender.internal.VideoFilterBase;
import com.tencent.aekit.openrender.util.GlUtil;
import com.tencent.filter.BaseFilter;
import com.tencent.ttpic.model.FaceMoveItem;
import com.tencent.ttpic.openapi.PTDetectInfo;
import com.tencent.ttpic.openapi.PTFaceAttr.PTExpression;
import com.tencent.ttpic.openapi.model.StickerItem;
import com.tencent.ttpic.openapi.util.VideoFilterUtil;
import com.tencent.ttpic.openapi.util.VideoMaterialUtil;
import com.tencent.ttpic.util.FaceMoveUtil;
import java.util.List;
import java.util.Set;

public class FaceMoveFilter
  extends VideoFilterBase
{
  private static final String FRAGMENT_SHADER = " precision highp float;\n varying vec2 textureCoordinate;\n uniform sampler2D inputImageTexture;\n \n void main(void) {\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n }".replace("\n", "");
  private static final String TAG = FaceMoveFilter.class.getSimpleName();
  private static final String VERTEX_SHADER = "precision mediump float;\nattribute vec4 position;\nattribute vec2 inputTextureCoordinate;\nvarying vec2 textureCoordinate;\n\nvoid main(){\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate;\n}".replace("\n", "");
  private PointF[] dstPoints = new PointF[107];
  private int[] faceMoveTriangles;
  private List<FaceMoveItem> items;
  private float[] posVertices = new float[1092];
  private PointF[] srcPoints = new PointF[107];
  private List<StickerItem> stickerItems;
  private float[] texVertices = new float[1092];
  
  public FaceMoveFilter(List<FaceMoveItem> paramList, List<StickerItem> paramList1, int[] paramArrayOfInt)
  {
    super(BaseFilter.nativeDecrypt(VERTEX_SHADER), BaseFilter.nativeDecrypt(FRAGMENT_SHADER));
    this.items = paramList;
    this.stickerItems = paramList1;
    this.faceMoveTriangles = paramArrayOfInt;
    int i = 0;
    while (i < this.srcPoints.length)
    {
      this.srcPoints[i] = new PointF();
      this.dstPoints[i] = new PointF();
      i += 1;
    }
    initParams();
  }
  
  public void ApplyGLSLFilter()
  {
    super.ApplyGLSLFilter();
    setDrawMode(AEOpenRenderConfig.DRAW_MODE.TRIANGLES);
  }
  
  public void initParams() {}
  
  public void updatePreview(Object paramObject)
  {
    if ((paramObject instanceof PTDetectInfo))
    {
      paramObject = (PTDetectInfo)paramObject;
      if ((this.stickerItems != null) && (this.stickerItems.size() != 0)) {
        break label69;
      }
    }
    label69:
    for (boolean bool = paramObject.triggeredExpression.contains(Integer.valueOf(PTFaceAttr.PTExpression.FACE_DETECT.value)); !bool; bool = VideoFilterUtil.actionTriggered(paramObject.facePoints, this.stickerItems, paramObject.triggeredExpression))
    {
      setPositions(GlUtil.EMPTY_POSITIONS);
      setCoordNum(4);
      return;
    }
    VideoMaterialUtil.copyListToArray(paramObject.facePoints, this.srcPoints);
    FaceMoveUtil.genFullCoords(this.srcPoints);
    FaceMoveUtil.adjustCoords(this.srcPoints, this.dstPoints, this.items);
    setPositions(FaceMoveUtil.initFacePositions(this.dstPoints, (int)(this.width * this.mFaceDetScale), (int)(this.height * this.mFaceDetScale), this.posVertices, this.faceMoveTriangles));
    setTexCords(FaceMoveUtil.initMaterialFaceTexCoords(this.srcPoints, (int)(this.width * this.mFaceDetScale), (int)(this.height * this.mFaceDetScale), this.texVertices, this.faceMoveTriangles));
    if (this.faceMoveTriangles == null) {}
    for (int i = 546;; i = this.faceMoveTriangles.length)
    {
      setCoordNum(i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.filter.FaceMoveFilter
 * JD-Core Version:    0.7.0.1
 */