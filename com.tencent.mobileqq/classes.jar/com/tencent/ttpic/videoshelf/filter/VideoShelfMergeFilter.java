package com.tencent.ttpic.videoshelf.filter;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import com.tencent.aekit.openrender.AEOpenRenderConfig.DRAW_MODE;
import com.tencent.aekit.openrender.AttributeParam;
import com.tencent.aekit.openrender.UniformParam.IntParam;
import com.tencent.aekit.openrender.UniformParam.TextureParam;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.openrender.internal.VideoFilterBase;
import com.tencent.aekit.openrender.util.GlUtil;
import com.tencent.filter.BaseFilter;
import com.tencent.ttpic.videoshelf.model.edit.NodeGroup;
import com.tencent.ttpic.videoshelf.model.edit.NodeItem;
import com.tencent.ttpic.videoshelf.model.template.FrameNodeItem;
import com.tencent.ttpic.videoshelf.model.template.MaskBlock;
import com.tencent.ttpic.videoshelf.model.template.MaskRectPoint;
import com.tencent.ttpic.videoshelf.model.template.NodeRectPoint;
import com.tencent.ttpic.videoshelf.model.template.VideoFrameItem;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class VideoShelfMergeFilter
  extends VideoFilterBase
{
  private static final String FRAGMENT_SHADER = "precision highp float;\nvarying highp vec2 textureCoordinate;\nvarying highp vec3 textureCoordinate2;\nuniform sampler2D inputImageTexture;\nuniform sampler2D inputImageTexture2;\nuniform int renderBackgroud;\nuniform int blendMode;\nhighp vec4 blendColor(in highp vec4 texColor, in highp vec4 canvasColor)\n{\n    highp vec3 vOne = vec3(1.0, 1.0, 1.0);\n    highp vec3 vZero = vec3(0.0, 0.0, 0.0);\n    highp vec3 resultFore = texColor.rgb;\n    if (blendMode <= 1 || blendMode > 14){ //default, since used most, put on top\n    } else if (blendMode == 2) {  //multiply\n        resultFore = canvasColor.rgb * texColor.rgb;\n    } else if (blendMode == 3){    //screen\n        resultFore = vOne - (vOne - canvasColor.rgb) * (vOne - texColor.rgb);\n    } else if (blendMode == 4){    //overlay\n        resultFore = 2.0 * canvasColor.rgb * texColor.rgb;\n        if (canvasColor.r >= 0.5) {\n            resultFore.r = 1.0 - 2.0 * (1.0 - canvasColor.r) * (1.0 - texColor.r);\n        }\n        if (canvasColor.g >= 0.5) {\n            resultFore.g = 1.0 - 2.0 * (1.0 - canvasColor.g) * (1.0 - texColor.g);\n        }\n        if (canvasColor.b >= 0.5) {\n            resultFore.b = 1.0 - 2.0 * (1.0 - canvasColor.b) * (1.0 - texColor.b);\n        }\n    } else if (blendMode == 5){    //hardlight\n        resultFore = 2.0 * canvasColor.rgb * texColor.rgb;\n        if (texColor.r >= 0.5) {\n            resultFore.r = 1.0 - 2.0 * (1.0 - canvasColor.r) * (1.0 - texColor.r);\n        }\n        if (texColor.g >= 0.5) {\n            resultFore.g = 1.0 - 2.0 * (1.0 - canvasColor.g) * (1.0 - texColor.g);\n        }\n        if (texColor.b >= 0.5) {\n            resultFore.b = 1.0 - 2.0 * (1.0 - canvasColor.b) * (1.0 - texColor.b);\n        }\n    } else if (blendMode == 6){    //softlight\n        resultFore = 2.0 * canvasColor.rgb * texColor.rgb + canvasColor.rgb * canvasColor.rgb * (vOne - 2.0 * texColor.rgb);\n        if (texColor.r >= 0.5) {\n            resultFore.r = 2.0 * canvasColor.r * (1.0 - texColor.r) + (2.0 * texColor.r - 1.0) * sqrt(canvasColor.r);\n        }\n        if (texColor.g >= 0.5) {\n            resultFore.g = 2.0 * canvasColor.g * (1.0 - texColor.g) + (2.0 * texColor.g - 1.0) * sqrt(canvasColor.g);\n        }\n        if (texColor.b >= 0.5) {\n            resultFore.b = 2.0 * canvasColor.b * (1.0 - texColor.b) + (2.0 * texColor.b - 1.0) * sqrt(canvasColor.b);\n        }\n    } else if (blendMode == 7){    //divide\n        resultFore = vOne;\n        if (texColor.r > 0.0) {\n            resultFore.r = canvasColor.r / texColor.r;\n        }\n        if (texColor.g > 0.0) {\n            resultFore.g = canvasColor.g / texColor.g;\n        }\n        if (texColor.b > 0.0) {\n            resultFore.b = canvasColor.b / texColor.b;\n        }\n        resultFore = min(vOne, resultFore);\n    } else if (blendMode == 8){    //add\n        resultFore = canvasColor.rgb + texColor.rgb;\n        resultFore = min(vOne, resultFore);\n    } else if (blendMode == 9){    //substract\n        resultFore = canvasColor.rgb - texColor.rgb;\n        resultFore = max(vZero, resultFore);\n    } else if (blendMode == 10){   //diff\n        resultFore = abs(canvasColor.rgb - texColor.rgb);\n    } else if (blendMode == 11){   //darken\n        resultFore = min(canvasColor.rgb, texColor.rgb);\n    } else if (blendMode == 12){   //lighten\n        resultFore = max(canvasColor.rgb, texColor.rgb);\n    }\n    highp vec4 resultColor = mix(canvasColor.rgba, vec4(resultFore.rgb, texColor.a), texColor.a);\n    return resultColor;\n}\nvoid main()\n{\n    highp vec4 textureColor = texture2D(inputImageTexture2, textureCoordinate2.xy/textureCoordinate2.z);\n    highp vec4 outputColor = texture2D(inputImageTexture, textureCoordinate);\n    highp vec4 temp = vec4(1.0, 1.0, 1.0, 0.0);\n    if (renderBackgroud == 1) {\n        temp = blendColor(textureColor, outputColor);\n        outputColor = temp; // mix(temp, outputColor, outputColor.a);\n    } else {\n        temp = blendColor(outputColor, textureColor);\n        outputColor = temp; // mix(temp, outputColor, outputColor.a);\n    }\n    //if(outputColor.a != 1.0) {\n    //    outputColor = vec4(1.0, 0, 0, 1.0);\n    //}\n    gl_FragColor = outputColor;\n}\n";
  public static final int IMAGE_INDEX = 10000;
  private static final String VERTEX_SHADER = "attribute vec4 position;\nattribute vec2 inputTextureCoordinate;\nattribute vec3 inputTextureCoordinate2;\nvarying vec2 textureCoordinate;\nvarying vec3 textureCoordinate2;\nvoid main() {\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate;\n    textureCoordinate2 = inputTextureCoordinate2;\n}\n";
  private int inBmpTexture;
  private float[] initFloats = { 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.0F, 1.0F, 1.0F };
  private int mBlendMode = 1;
  private BaseFilter mCopyFilter = new BaseFilter("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
  private Frame[] mCopyFrame = new Frame[2];
  private int mFrameCount = 0;
  private VideoFrameItem mFrameItem = new VideoFrameItem();
  private List<FrameNodeItem> mFrameNodeItemList = new ArrayList();
  List<NodeGroup> mNodeGroupList = new ArrayList();
  private Frame mRenderFrame = new Frame();
  private List<VideoFrameItem> mVideoFrameItemList;
  private float q0;
  private float q1;
  private float q2;
  private float q3;
  private boolean rendered = false;
  
  public VideoShelfMergeFilter(List<VideoFrameItem> paramList, List<NodeGroup> paramList1)
  {
    super("attribute vec4 position;\nattribute vec2 inputTextureCoordinate;\nattribute vec3 inputTextureCoordinate2;\nvarying vec2 textureCoordinate;\nvarying vec3 textureCoordinate2;\nvoid main() {\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate;\n    textureCoordinate2 = inputTextureCoordinate2;\n}\n", "precision highp float;\nvarying highp vec2 textureCoordinate;\nvarying highp vec3 textureCoordinate2;\nuniform sampler2D inputImageTexture;\nuniform sampler2D inputImageTexture2;\nuniform int renderBackgroud;\nuniform int blendMode;\nhighp vec4 blendColor(in highp vec4 texColor, in highp vec4 canvasColor)\n{\n    highp vec3 vOne = vec3(1.0, 1.0, 1.0);\n    highp vec3 vZero = vec3(0.0, 0.0, 0.0);\n    highp vec3 resultFore = texColor.rgb;\n    if (blendMode <= 1 || blendMode > 14){ //default, since used most, put on top\n    } else if (blendMode == 2) {  //multiply\n        resultFore = canvasColor.rgb * texColor.rgb;\n    } else if (blendMode == 3){    //screen\n        resultFore = vOne - (vOne - canvasColor.rgb) * (vOne - texColor.rgb);\n    } else if (blendMode == 4){    //overlay\n        resultFore = 2.0 * canvasColor.rgb * texColor.rgb;\n        if (canvasColor.r >= 0.5) {\n            resultFore.r = 1.0 - 2.0 * (1.0 - canvasColor.r) * (1.0 - texColor.r);\n        }\n        if (canvasColor.g >= 0.5) {\n            resultFore.g = 1.0 - 2.0 * (1.0 - canvasColor.g) * (1.0 - texColor.g);\n        }\n        if (canvasColor.b >= 0.5) {\n            resultFore.b = 1.0 - 2.0 * (1.0 - canvasColor.b) * (1.0 - texColor.b);\n        }\n    } else if (blendMode == 5){    //hardlight\n        resultFore = 2.0 * canvasColor.rgb * texColor.rgb;\n        if (texColor.r >= 0.5) {\n            resultFore.r = 1.0 - 2.0 * (1.0 - canvasColor.r) * (1.0 - texColor.r);\n        }\n        if (texColor.g >= 0.5) {\n            resultFore.g = 1.0 - 2.0 * (1.0 - canvasColor.g) * (1.0 - texColor.g);\n        }\n        if (texColor.b >= 0.5) {\n            resultFore.b = 1.0 - 2.0 * (1.0 - canvasColor.b) * (1.0 - texColor.b);\n        }\n    } else if (blendMode == 6){    //softlight\n        resultFore = 2.0 * canvasColor.rgb * texColor.rgb + canvasColor.rgb * canvasColor.rgb * (vOne - 2.0 * texColor.rgb);\n        if (texColor.r >= 0.5) {\n            resultFore.r = 2.0 * canvasColor.r * (1.0 - texColor.r) + (2.0 * texColor.r - 1.0) * sqrt(canvasColor.r);\n        }\n        if (texColor.g >= 0.5) {\n            resultFore.g = 2.0 * canvasColor.g * (1.0 - texColor.g) + (2.0 * texColor.g - 1.0) * sqrt(canvasColor.g);\n        }\n        if (texColor.b >= 0.5) {\n            resultFore.b = 2.0 * canvasColor.b * (1.0 - texColor.b) + (2.0 * texColor.b - 1.0) * sqrt(canvasColor.b);\n        }\n    } else if (blendMode == 7){    //divide\n        resultFore = vOne;\n        if (texColor.r > 0.0) {\n            resultFore.r = canvasColor.r / texColor.r;\n        }\n        if (texColor.g > 0.0) {\n            resultFore.g = canvasColor.g / texColor.g;\n        }\n        if (texColor.b > 0.0) {\n            resultFore.b = canvasColor.b / texColor.b;\n        }\n        resultFore = min(vOne, resultFore);\n    } else if (blendMode == 8){    //add\n        resultFore = canvasColor.rgb + texColor.rgb;\n        resultFore = min(vOne, resultFore);\n    } else if (blendMode == 9){    //substract\n        resultFore = canvasColor.rgb - texColor.rgb;\n        resultFore = max(vZero, resultFore);\n    } else if (blendMode == 10){   //diff\n        resultFore = abs(canvasColor.rgb - texColor.rgb);\n    } else if (blendMode == 11){   //darken\n        resultFore = min(canvasColor.rgb, texColor.rgb);\n    } else if (blendMode == 12){   //lighten\n        resultFore = max(canvasColor.rgb, texColor.rgb);\n    }\n    highp vec4 resultColor = mix(canvasColor.rgba, vec4(resultFore.rgb, texColor.a), texColor.a);\n    return resultColor;\n}\nvoid main()\n{\n    highp vec4 textureColor = texture2D(inputImageTexture2, textureCoordinate2.xy/textureCoordinate2.z);\n    highp vec4 outputColor = texture2D(inputImageTexture, textureCoordinate);\n    highp vec4 temp = vec4(1.0, 1.0, 1.0, 0.0);\n    if (renderBackgroud == 1) {\n        temp = blendColor(textureColor, outputColor);\n        outputColor = temp; // mix(temp, outputColor, outputColor.a);\n    } else {\n        temp = blendColor(outputColor, textureColor);\n        outputColor = temp; // mix(temp, outputColor, outputColor.a);\n    }\n    //if(outputColor.a != 1.0) {\n    //    outputColor = vec4(1.0, 0, 0, 1.0);\n    //}\n    gl_FragColor = outputColor;\n}\n");
    this.mVideoFrameItemList = paramList;
    this.mNodeGroupList = paramList1;
    setDrawMode(AEOpenRenderConfig.DRAW_MODE.TRIANGLES);
    initParams();
  }
  
  private float[] convertMaskToTexCoord(MaskRectPoint[] paramArrayOfMaskRectPoint)
  {
    float[] arrayOfFloat = new float[12];
    if (paramArrayOfMaskRectPoint.length >= 4)
    {
      MaskRectPoint localMaskRectPoint1 = paramArrayOfMaskRectPoint[0];
      MaskRectPoint localMaskRectPoint2 = paramArrayOfMaskRectPoint[1];
      MaskRectPoint localMaskRectPoint3 = paramArrayOfMaskRectPoint[2];
      paramArrayOfMaskRectPoint = paramArrayOfMaskRectPoint[3];
      arrayOfFloat[0] = paramArrayOfMaskRectPoint.x;
      arrayOfFloat[1] = paramArrayOfMaskRectPoint.y;
      arrayOfFloat[2] = localMaskRectPoint3.x;
      arrayOfFloat[3] = localMaskRectPoint3.y;
      arrayOfFloat[4] = localMaskRectPoint1.x;
      arrayOfFloat[5] = localMaskRectPoint1.y;
      arrayOfFloat[6] = localMaskRectPoint3.x;
      arrayOfFloat[7] = localMaskRectPoint3.y;
      arrayOfFloat[8] = localMaskRectPoint2.x;
      arrayOfFloat[9] = localMaskRectPoint2.y;
      arrayOfFloat[10] = localMaskRectPoint1.x;
      arrayOfFloat[11] = localMaskRectPoint1.y;
    }
    return arrayOfFloat;
  }
  
  private float[] convertTexCoord(NodeRectPoint[] paramArrayOfNodeRectPoint)
  {
    float[] arrayOfFloat = new float[12];
    if (paramArrayOfNodeRectPoint.length >= 4)
    {
      NodeRectPoint localNodeRectPoint1 = paramArrayOfNodeRectPoint[0];
      NodeRectPoint localNodeRectPoint2 = paramArrayOfNodeRectPoint[1];
      NodeRectPoint localNodeRectPoint3 = paramArrayOfNodeRectPoint[2];
      paramArrayOfNodeRectPoint = paramArrayOfNodeRectPoint[3];
      arrayOfFloat[0] = paramArrayOfNodeRectPoint.x;
      arrayOfFloat[1] = paramArrayOfNodeRectPoint.y;
      arrayOfFloat[2] = localNodeRectPoint3.x;
      arrayOfFloat[3] = localNodeRectPoint3.y;
      arrayOfFloat[4] = localNodeRectPoint1.x;
      arrayOfFloat[5] = localNodeRectPoint1.y;
      arrayOfFloat[6] = localNodeRectPoint3.x;
      arrayOfFloat[7] = localNodeRectPoint3.y;
      arrayOfFloat[8] = localNodeRectPoint2.x;
      arrayOfFloat[9] = localNodeRectPoint2.y;
      arrayOfFloat[10] = localNodeRectPoint1.x;
      arrayOfFloat[11] = localNodeRectPoint1.y;
    }
    return arrayOfFloat;
  }
  
  private float[] convertTexCoordNoAffi(NodeRectPoint[] paramArrayOfNodeRectPoint)
  {
    float[] arrayOfFloat = new float[18];
    if (paramArrayOfNodeRectPoint.length >= 4)
    {
      NodeRectPoint localNodeRectPoint1 = paramArrayOfNodeRectPoint[0];
      NodeRectPoint localNodeRectPoint2 = paramArrayOfNodeRectPoint[1];
      NodeRectPoint localNodeRectPoint3 = paramArrayOfNodeRectPoint[2];
      paramArrayOfNodeRectPoint = paramArrayOfNodeRectPoint[3];
      if (!this.rendered)
      {
        this.q0 = 1.0F;
        this.q2 = 1.0F;
        this.q3 = 1.0F;
        this.q1 = 1.0F;
      }
      arrayOfFloat[0] = (paramArrayOfNodeRectPoint.x * this.q3);
      arrayOfFloat[1] = (paramArrayOfNodeRectPoint.y * this.q3);
      arrayOfFloat[2] = this.q3;
      arrayOfFloat[3] = (localNodeRectPoint3.x * this.q2);
      arrayOfFloat[4] = (localNodeRectPoint3.y * this.q2);
      arrayOfFloat[5] = this.q2;
      arrayOfFloat[6] = (localNodeRectPoint1.x * this.q0);
      arrayOfFloat[7] = (localNodeRectPoint1.y * this.q0);
      arrayOfFloat[8] = this.q0;
      arrayOfFloat[9] = (localNodeRectPoint3.x * this.q2);
      arrayOfFloat[10] = (localNodeRectPoint3.y * this.q2);
      arrayOfFloat[11] = this.q2;
      arrayOfFloat[12] = (localNodeRectPoint2.x * this.q1);
      arrayOfFloat[13] = (localNodeRectPoint2.y * this.q1);
      arrayOfFloat[14] = this.q1;
      arrayOfFloat[15] = (localNodeRectPoint1.x * this.q0);
      arrayOfFloat[16] = (localNodeRectPoint1.y * this.q0);
      arrayOfFloat[17] = this.q0;
    }
    return arrayOfFloat;
  }
  
  private float[] convertVertex(MaskRectPoint[] paramArrayOfMaskRectPoint)
  {
    float[] arrayOfFloat = new float[12];
    if (paramArrayOfMaskRectPoint.length >= 4)
    {
      MaskRectPoint localMaskRectPoint1 = paramArrayOfMaskRectPoint[0];
      MaskRectPoint localMaskRectPoint2 = paramArrayOfMaskRectPoint[1];
      MaskRectPoint localMaskRectPoint3 = paramArrayOfMaskRectPoint[2];
      paramArrayOfMaskRectPoint = paramArrayOfMaskRectPoint[3];
      drawNonAffine(localMaskRectPoint1.x, localMaskRectPoint1.y, localMaskRectPoint2.x, localMaskRectPoint2.y, localMaskRectPoint3.x, localMaskRectPoint3.y, paramArrayOfMaskRectPoint.x, paramArrayOfMaskRectPoint.y);
      arrayOfFloat[0] = (paramArrayOfMaskRectPoint.x * 2.0F - 1.0F);
      arrayOfFloat[1] = (paramArrayOfMaskRectPoint.y * 2.0F - 1.0F);
      arrayOfFloat[2] = (localMaskRectPoint3.x * 2.0F - 1.0F);
      arrayOfFloat[3] = (localMaskRectPoint3.y * 2.0F - 1.0F);
      arrayOfFloat[4] = (localMaskRectPoint1.x * 2.0F - 1.0F);
      arrayOfFloat[5] = (localMaskRectPoint1.y * 2.0F - 1.0F);
      arrayOfFloat[6] = (localMaskRectPoint3.x * 2.0F - 1.0F);
      arrayOfFloat[7] = (localMaskRectPoint3.y * 2.0F - 1.0F);
      arrayOfFloat[8] = (localMaskRectPoint2.x * 2.0F - 1.0F);
      arrayOfFloat[9] = (localMaskRectPoint2.y * 2.0F - 1.0F);
      arrayOfFloat[10] = (localMaskRectPoint1.x * 2.0F - 1.0F);
      arrayOfFloat[11] = (localMaskRectPoint1.y * 2.0F - 1.0F);
    }
    return arrayOfFloat;
  }
  
  private Bitmap getBitmapFromNodeGroupList(int paramInt)
  {
    int i = 0;
    while (i < this.mNodeGroupList.size())
    {
      List localList = ((NodeGroup)this.mNodeGroupList.get(i)).nodeItemList;
      int j = 0;
      while (j < localList.size())
      {
        if (((NodeItem)localList.get(j)).nodeID == paramInt)
        {
          if (((NodeItem)localList.get(j)).cropBitmap != null) {
            return ((NodeItem)localList.get(j)).cropBitmap;
          }
          return ((NodeItem)localList.get(j)).bitmap;
        }
        j += 1;
      }
      i += 1;
    }
    return null;
  }
  
  private Frame getSpaceFrame(int paramInt)
  {
    if ((this.mCopyFrame[0] != null) && (paramInt == this.mCopyFrame[0].getTextureId())) {
      return this.mCopyFrame[1];
    }
    return this.mCopyFrame[0];
  }
  
  private void sortFrameNodeItem(List<FrameNodeItem> paramList)
  {
    if ((paramList == null) || (paramList.size() <= 1)) {
      return;
    }
    Collections.sort(paramList, new VideoShelfMergeFilter.1FrameNodeItemComparetor(this));
  }
  
  private void sortMaskBlocksList(List<MaskBlock> paramList)
  {
    if ((paramList == null) || (paramList.size() <= 1)) {
      return;
    }
    Collections.sort(paramList, new VideoShelfMergeFilter.1MaskBlockComparetor(this));
  }
  
  public void ApplyGLSLFilter()
  {
    super.ApplyGLSLFilter();
    int i = 0;
    while (i < this.mCopyFrame.length)
    {
      this.mCopyFrame[i] = new Frame();
      i += 1;
    }
    int[] arrayOfInt = new int[1];
    GlUtil.glGenTextures(arrayOfInt.length, arrayOfInt, 0);
    this.inBmpTexture = arrayOfInt[0];
  }
  
  public void clearGLSLSelf()
  {
    super.clearGLSLSelf();
    this.mCopyFilter.clearGLSL();
    this.mRenderFrame.clear();
    int i = 0;
    while (i < this.mCopyFrame.length)
    {
      this.mCopyFrame[i].clear();
      i += 1;
    }
    int[] arrayOfInt = new int[1];
    arrayOfInt[0] = this.inBmpTexture;
    GLES20.glDeleteBuffers(arrayOfInt.length, arrayOfInt, 0);
  }
  
  public void drawNonAffine(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8)
  {
    paramFloat5 -= paramFloat1;
    paramFloat6 -= paramFloat2;
    paramFloat7 -= paramFloat3;
    paramFloat8 -= paramFloat4;
    float f = paramFloat5 * paramFloat8 - paramFloat6 * paramFloat7;
    if (f != 0.0F)
    {
      paramFloat2 -= paramFloat4;
      paramFloat1 -= paramFloat3;
      paramFloat3 = (paramFloat5 * paramFloat2 - paramFloat6 * paramFloat1) / f;
      if ((paramFloat3 > 0.0F) && (paramFloat3 < 1.0F))
      {
        paramFloat1 = (paramFloat7 * paramFloat2 - paramFloat8 * paramFloat1) / f;
        if ((paramFloat1 > 0.0F) && (paramFloat1 < 1.0F))
        {
          this.q0 = (1.0F / (1.0F - paramFloat1));
          this.q1 = (1.0F / (1.0F - paramFloat3));
          this.q2 = (1.0F / paramFloat1);
          this.q3 = (1.0F / paramFloat3);
          this.rendered = true;
        }
      }
    }
  }
  
  public void initAttribParams()
  {
    super.initAttribParams();
    addAttribParam("inputTextureCoordinate2", this.initFloats, false);
  }
  
  public void initParams()
  {
    addParam(new UniformParam.TextureParam("inputImageTexture2", 0, 33986));
    addParam(new UniformParam.IntParam("renderBackgroud", 0));
    addParam(new UniformParam.IntParam("blendMode", 0));
    this.mCopyFilter.apply();
  }
  
  public void update(int paramInt)
  {
    if (paramInt >= this.mVideoFrameItemList.size()) {
      return;
    }
    this.mFrameCount = paramInt;
    paramInt = 0;
    for (;;)
    {
      if (paramInt < this.mVideoFrameItemList.size())
      {
        if (this.mFrameCount == ((VideoFrameItem)this.mVideoFrameItemList.get(paramInt)).getFrameID()) {
          this.mFrameItem = ((VideoFrameItem)this.mVideoFrameItemList.get(paramInt));
        }
      }
      else
      {
        this.mFrameNodeItemList = this.mFrameItem.getNodeList();
        sortFrameNodeItem(this.mFrameNodeItemList);
        return;
      }
      paramInt += 1;
    }
  }
  
  public Frame updateAndRender(int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject1 = null;
    int j = 0;
    int i = paramInt1;
    paramInt1 = j;
    while (paramInt1 < this.mFrameNodeItemList.size())
    {
      j = ((FrameNodeItem)this.mFrameNodeItemList.get(paramInt1)).getNodeID();
      int k = ((FrameNodeItem)this.mFrameNodeItemList.get(paramInt1)).getZIndex();
      int m = ((FrameNodeItem)this.mFrameNodeItemList.get(paramInt1)).getBlendMode();
      List localList = ((FrameNodeItem)this.mFrameNodeItemList.get(paramInt1)).getMaskBlockList();
      sortMaskBlocksList(localList);
      Object localObject2 = getBitmapFromNodeGroupList(j);
      GlUtil.loadTexture(this.inBmpTexture, (Bitmap)localObject2);
      addParam(new UniformParam.TextureParam("inputImageTexture2", this.inBmpTexture, 33986));
      addParam(new UniformParam.IntParam("blendMode", m));
      if (k >= 10000) {
        addParam(new UniformParam.IntParam("renderBackgroud", 1));
      }
      for (;;)
      {
        j = 0;
        while (j < localList.size())
        {
          localObject2 = ((MaskBlock)localList.get(j)).getMaskRect();
          Object localObject3 = ((MaskBlock)localList.get(j)).getNodeRect();
          localObject1 = convertVertex((MaskRectPoint[])localObject2);
          localObject3 = convertTexCoordNoAffi((NodeRectPoint[])localObject3);
          localObject2 = convertMaskToTexCoord((MaskRectPoint[])localObject2);
          setPositions((float[])localObject1);
          setCoordNum(6);
          setTexCords((float[])localObject2);
          addAttribParam(new AttributeParam("inputTextureCoordinate2", (float[])localObject3, 3, false));
          localObject1 = getSpaceFrame(i);
          this.mCopyFilter.RenderProcess(i, paramInt2 * 2, paramInt3 * 2, -1, 0.0D, (Frame)localObject1);
          OnDrawFrameGLSL();
          renderTexture(i, paramInt2, paramInt3);
          i = ((Frame)localObject1).getTextureId();
          j += 1;
        }
        addParam(new UniformParam.IntParam("renderBackgroud", 0));
      }
      paramInt1 += 1;
    }
    if (localObject1 != null) {
      this.mCopyFilter.RenderProcess(((Frame)localObject1).getTextureId(), paramInt2, paramInt3, -1, 0.0D, this.mRenderFrame);
    }
    return this.mRenderFrame;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.videoshelf.filter.VideoShelfMergeFilter
 * JD-Core Version:    0.7.0.1
 */