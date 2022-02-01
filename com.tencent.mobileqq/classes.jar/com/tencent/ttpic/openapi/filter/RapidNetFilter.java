package com.tencent.ttpic.openapi.filter;

import android.graphics.PointF;
import android.opengl.GLES20;
import com.tencent.aekit.openrender.internal.AEChainI;
import com.tencent.aekit.openrender.internal.AEFilterI;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.openrender.internal.VideoFilterBase;
import com.tencent.aekit.openrender.util.GlUtil;
import com.tencent.ttpic.model.SizeI;
import com.tencent.ttpic.openapi.initializer.TNNGenderSwitchInitializer;
import com.tencent.ttpic.openapi.manager.FeatureManager.Features;
import com.tencent.ttpic.openapi.model.FaceStyleItem;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import com.tencent.ttpic.util.AlgoUtils;
import com.tencent.ttpic.util.FaceOffUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RapidNetFilter
  extends AEChainI
  implements AEFilterI
{
  private static final boolean DEBUG = false;
  private static final String TAG = "RapidNetFilter";
  private SizeI NET_SIZE = new SizeI(320, 320);
  private VideoFilterBase copyFilter = new VideoFilterBase("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
  private Frame copyFrame = new Frame();
  private VideoFilterBase cropFilter = new VideoFilterBase("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
  private Frame cropFrame = new Frame();
  private String dataPath;
  private VideoFilterBase fillFilter = new VideoFilterBase("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
  private Frame fillFrame = new Frame();
  private String modelName;
  private float[] position = new float[8];
  private int[] tex = new int[2];
  private float[] texCoords = new float[8];
  
  public RapidNetFilter(FaceStyleItem paramFaceStyleItem)
  {
    setImageNetSize(paramFaceStyleItem.imageSize[0], paramFaceStyleItem.imageSize[1]);
    this.dataPath = paramFaceStyleItem.dataPath;
    this.modelName = paramFaceStyleItem.modelName;
    init();
  }
  
  private void calCropCoordsV1(List<PointF> paramList, int paramInt1, int paramInt2)
  {
    PointF localPointF1 = (PointF)paramList.get(101);
    PointF localPointF2 = (PointF)paramList.get(99);
    PointF localPointF3 = (PointF)paramList.get(105);
    paramList = (PointF)paramList.get(103);
    AlgoUtils.getDistance(localPointF2, localPointF3);
    AlgoUtils.getDistance(localPointF2, localPointF1);
    float f2 = localPointF2.x;
    float f1 = paramInt1;
    f2 /= f1;
    float f3 = localPointF2.y;
    float f4 = paramInt2;
    this.texCoords = new float[] { f2, f3 / f4, localPointF1.x / f1, localPointF1.y / f4, paramList.x / f1, paramList.y / f4, localPointF3.x / f1, localPointF3.y / f4 };
    this.position = new float[] { localPointF2.x / f1 * 2.0F - 1.0F, localPointF2.y / f4 * 2.0F - 1.0F, localPointF1.x / f1 * 2.0F - 1.0F, localPointF1.y / f4 * 2.0F - 1.0F, paramList.x / f1 * 2.0F - 1.0F, paramList.y / f4 * 2.0F - 1.0F, localPointF3.x / f1 * 2.0F - 1.0F, localPointF3.y / f4 * 2.0F - 1.0F };
  }
  
  public static double norm(PointF paramPointF)
  {
    return Math.sqrt(paramPointF.x * paramPointF.x + paramPointF.y * paramPointF.y);
  }
  
  public static void scale(List<PointF> paramList, double paramDouble)
  {
    if (paramList == null) {
      return;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      PointF localPointF = (PointF)paramList.next();
      double d = localPointF.x;
      Double.isNaN(d);
      localPointF.x = ((float)(d * paramDouble));
      d = localPointF.y;
      Double.isNaN(d);
      localPointF.y = ((float)(d * paramDouble));
    }
  }
  
  public Frame RenderProcess(Frame paramFrame)
  {
    return render(paramFrame);
  }
  
  public void calCropCoordsV2(List<PointF> paramList, int paramInt1, int paramInt2)
  {
    Object localObject = new ArrayList();
    ((List)localObject).add(paramList.get(35));
    ((List)localObject).add(paramList.get(39));
    ((List)localObject).add(paramList.get(45));
    ((List)localObject).add(paramList.get(49));
    ((List)localObject).add(paramList.get(64));
    int k = 0;
    ((List)localObject).add(paramList.get(0));
    ((List)localObject).add(paramList.get(18));
    paramList = new PointF();
    paramList.x = ((((PointF)((List)localObject).get(2)).x + ((PointF)((List)localObject).get(3)).x) * 0.5F - (((PointF)((List)localObject).get(0)).x + ((PointF)((List)localObject).get(1)).x) * 0.5F);
    paramList.y = ((((PointF)((List)localObject).get(2)).y + ((PointF)((List)localObject).get(3)).y) * 0.5F - (((PointF)((List)localObject).get(0)).y + ((PointF)((List)localObject).get(1)).y) * 0.5F);
    float f1 = paramList.y;
    float f2 = paramList.x;
    float f3 = (float)(1.0D / norm(paramList));
    f1 *= f3;
    float f5 = f2 * f3;
    f3 = (float)norm(new PointF(((PointF)((List)localObject).get(5)).x - ((PointF)((List)localObject).get(6)).x, ((PointF)((List)localObject).get(5)).y - ((PointF)((List)localObject).get(6)).y));
    paramList = new PointF();
    double d = ((PointF)((List)localObject).get(0)).x + ((PointF)((List)localObject).get(1)).x + ((PointF)((List)localObject).get(2)).x + ((PointF)((List)localObject).get(3)).x + ((PointF)((List)localObject).get(4)).x;
    Double.isNaN(d);
    paramList.x = ((float)(d * 0.2D));
    d = ((PointF)((List)localObject).get(0)).y + ((PointF)((List)localObject).get(1)).y + ((PointF)((List)localObject).get(2)).y + ((PointF)((List)localObject).get(3)).y + ((PointF)((List)localObject).get(4)).y;
    Double.isNaN(d);
    paramList.y = ((float)(d * 0.2D));
    f2 = 2.315F * f3 / this.NET_SIZE.width;
    float f6 = 1.1575F * f3;
    localObject = new float[6];
    f3 = f5 * f2;
    localObject[0] = f3;
    localObject[1] = (-f1 * f2);
    float f4 = paramList.x;
    f5 *= f6;
    f6 *= f1;
    localObject[2] = (f4 - (f5 - f6));
    localObject[3] = (f1 * f2);
    localObject[4] = f3;
    localObject[5] = (paramList.y - (f6 + f5));
    paramList = this.texCoords;
    paramList[0] = localObject[2];
    paramList[1] = localObject[5];
    paramList[2] = (this.NET_SIZE.width * localObject[1] + localObject[2]);
    this.texCoords[3] = (this.NET_SIZE.width * localObject[4] + localObject[5]);
    this.texCoords[4] = (this.NET_SIZE.width * localObject[0] + this.NET_SIZE.width * localObject[1] + localObject[2]);
    this.texCoords[5] = (this.NET_SIZE.width * localObject[3] + this.NET_SIZE.width * localObject[4] + localObject[5]);
    this.texCoords[6] = (this.NET_SIZE.width * localObject[0] + localObject[2]);
    this.texCoords[7] = (this.NET_SIZE.width * localObject[3] + localObject[5]);
    int i = 0;
    int j;
    for (;;)
    {
      j = k;
      if (i >= 8) {
        break;
      }
      paramList = this.texCoords;
      paramList[i] /= paramInt1;
      j = i + 1;
      paramList[j] /= paramInt2;
      i += 2;
    }
    for (;;)
    {
      paramList = this.texCoords;
      if (j >= paramList.length) {
        break;
      }
      this.position[j] = (paramList[j] * 2.0F - 1.0F);
      j += 1;
    }
  }
  
  public void destroy()
  {
    this.cropFilter.clearGLSLSelf();
    this.fillFilter.clearGLSLSelf();
    this.copyFilter.clearGLSLSelf();
    this.cropFrame.clear();
    this.fillFrame.clear();
    int[] arrayOfInt = this.tex;
    GLES20.glDeleteTextures(arrayOfInt.length, arrayOfInt, 0);
  }
  
  public void init()
  {
    this.cropFilter.ApplyGLSLFilter();
    this.fillFilter.ApplyGLSLFilter();
    this.copyFilter.ApplyGLSLFilter();
    int[] arrayOfInt = this.tex;
    GLES20.glGenTextures(arrayOfInt.length, arrayOfInt, 0);
  }
  
  public Frame render(Frame paramFrame)
  {
    return this.fillFrame;
  }
  
  public void setImageNetSize(int paramInt1, int paramInt2)
  {
    SizeI localSizeI = this.NET_SIZE;
    localSizeI.width = paramInt1;
    localSizeI.height = paramInt2;
  }
  
  public void updateAndRender(Frame paramFrame, List<PointF> paramList, double paramDouble)
  {
    int i = paramFrame.getTextureId();
    int j = paramFrame.width;
    int k = paramFrame.height;
    paramFrame = VideoMaterial.copyList(paramList);
    scale(paramFrame, 1.0D / paramDouble);
    FaceOffUtil.getFullCoords(paramFrame, 2.5F);
    calCropCoordsV2(paramFrame, j, k);
    this.cropFilter.setTexCords(this.texCoords);
    this.cropFilter.RenderProcess(i, this.NET_SIZE.width, this.NET_SIZE.height, -1, 0.0D, this.cropFrame);
    paramFrame = GlUtil.saveTexture(this.cropFrame);
    paramFrame = FeatureManager.Features.RAPID_NET_GENDER_SWITCH.forward(paramFrame, 0, 0);
    GlUtil.loadTexture(this.tex[0], paramFrame);
    this.copyFilter.RenderProcess(i, j, k, -1, 0.0D, this.fillFrame);
    this.fillFilter.setPositions(this.position);
    GlUtil.setBlendMode(true);
    this.fillFilter.RenderProcess(this.tex[0], j, k, -1, 0.0D, this.fillFrame);
    GlUtil.setBlendMode(false);
  }
  
  public void updatePreview(Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.RapidNetFilter
 * JD-Core Version:    0.7.0.1
 */