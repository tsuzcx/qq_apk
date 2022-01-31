package com.tencent.ttpic.openapi.filter;

import android.graphics.PointF;
import android.opengl.GLES20;
import com.tencent.aekit.openrender.internal.AEChainI;
import com.tencent.aekit.openrender.internal.AEFilterI;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.openrender.internal.VideoFilterBase;
import com.tencent.aekit.openrender.util.GlUtil;
import com.tencent.ttpic.baseutils.fps.BenchUtil;
import com.tencent.ttpic.model.SizeI;
import com.tencent.ttpic.openapi.initializer.RapidNetGenderSwitchInitializer;
import com.tencent.ttpic.openapi.manager.FeatureManager.Features;
import com.tencent.ttpic.openapi.model.FaceStyleItem;
import com.tencent.ttpic.openapi.util.VideoMaterialUtil;
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
    int i = (int)AlgoUtils.getDistance(localPointF2, localPointF3);
    i = (int)AlgoUtils.getDistance(localPointF2, localPointF1);
    this.texCoords = new float[] { localPointF2.x / paramInt1, localPointF2.y / paramInt2, localPointF1.x / paramInt1, localPointF1.y / paramInt2, paramList.x / paramInt1, paramList.y / paramInt2, localPointF3.x / paramInt1, localPointF3.y / paramInt2 };
    this.position = new float[] { localPointF2.x / paramInt1 * 2.0F - 1.0F, localPointF2.y / paramInt2 * 2.0F - 1.0F, localPointF1.x / paramInt1 * 2.0F - 1.0F, localPointF1.y / paramInt2 * 2.0F - 1.0F, paramList.x / paramInt1 * 2.0F - 1.0F, paramList.y / paramInt2 * 2.0F - 1.0F, localPointF3.x / paramInt1 * 2.0F - 1.0F, localPointF3.y / paramInt2 * 2.0F - 1.0F };
  }
  
  public static double norm(PointF paramPointF)
  {
    return Math.sqrt(paramPointF.x * paramPointF.x + paramPointF.y * paramPointF.y);
  }
  
  public static void scale(List<PointF> paramList, double paramDouble)
  {
    if (paramList == null) {}
    for (;;)
    {
      return;
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        PointF localPointF = (PointF)paramList.next();
        localPointF.x = ((float)(localPointF.x * paramDouble));
        localPointF.y = ((float)(localPointF.y * paramDouble));
      }
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
    ((List)localObject).add(paramList.get(0));
    ((List)localObject).add(paramList.get(18));
    paramList = new PointF();
    float f1 = ((PointF)((List)localObject).get(2)).x;
    float f2 = ((PointF)((List)localObject).get(3)).x;
    float f3 = ((PointF)((List)localObject).get(0)).x;
    paramList.x = (0.5F * (f2 + f1) - (((PointF)((List)localObject).get(1)).x + f3) * 0.5F);
    f1 = ((PointF)((List)localObject).get(2)).y;
    f2 = ((PointF)((List)localObject).get(3)).y;
    f3 = ((PointF)((List)localObject).get(0)).y;
    paramList.y = (0.5F * (f2 + f1) - (((PointF)((List)localObject).get(1)).y + f3) * 0.5F);
    f1 = paramList.y;
    f2 = paramList.x;
    f3 = (float)(1.0D / norm(paramList));
    f1 *= f3;
    f2 = f3 * f2;
    f3 = (float)norm(new PointF(((PointF)((List)localObject).get(5)).x - ((PointF)((List)localObject).get(6)).x, ((PointF)((List)localObject).get(5)).y - ((PointF)((List)localObject).get(6)).y));
    paramList = new PointF();
    float f4 = ((PointF)((List)localObject).get(0)).x;
    float f5 = ((PointF)((List)localObject).get(1)).x;
    float f6 = ((PointF)((List)localObject).get(2)).x;
    float f7 = ((PointF)((List)localObject).get(3)).x;
    paramList.x = ((float)((((PointF)((List)localObject).get(4)).x + (f4 + f5 + f6 + f7)) * 0.2D));
    f4 = ((PointF)((List)localObject).get(0)).y;
    f5 = ((PointF)((List)localObject).get(1)).y;
    f6 = ((PointF)((List)localObject).get(2)).y;
    f7 = ((PointF)((List)localObject).get(3)).y;
    paramList.y = ((float)((((PointF)((List)localObject).get(4)).y + (f4 + f5 + f6 + f7)) * 0.2D));
    f4 = 2.315F * f3 / this.NET_SIZE.width;
    f5 = 0.5F * 2.315F * f3;
    f3 = 2.315F * 0.5F * f3;
    localObject = new float[6];
    localObject[0] = (f2 * f4);
    localObject[1] = (-f1 * f4);
    localObject[2] = (paramList.x - (f2 * f5 - f1 * f3));
    localObject[3] = (f1 * f4);
    localObject[4] = (f4 * f2);
    localObject[5] = (paramList.y - (f3 * f2 + f1 * f5));
    this.texCoords[0] = localObject[2];
    this.texCoords[1] = localObject[5];
    this.texCoords[2] = (this.NET_SIZE.width * localObject[1] + localObject[2]);
    this.texCoords[3] = (this.NET_SIZE.width * localObject[4] + localObject[5]);
    this.texCoords[4] = (this.NET_SIZE.width * localObject[0] + this.NET_SIZE.width * localObject[1] + localObject[2]);
    this.texCoords[5] = (this.NET_SIZE.width * localObject[3] + this.NET_SIZE.width * localObject[4] + localObject[5]);
    this.texCoords[6] = (this.NET_SIZE.width * localObject[0] + localObject[2]);
    this.texCoords[7] = (this.NET_SIZE.width * localObject[3] + localObject[5]);
    int i = 0;
    while (i < 8)
    {
      this.texCoords[i] /= paramInt1;
      this.texCoords[(i + 1)] /= paramInt2;
      i += 2;
    }
    paramInt1 = 0;
    while (paramInt1 < this.texCoords.length)
    {
      this.position[paramInt1] = (this.texCoords[paramInt1] * 2.0F - 1.0F);
      paramInt1 += 1;
    }
  }
  
  public void destroy()
  {
    this.cropFilter.clearGLSLSelf();
    this.fillFilter.clearGLSLSelf();
    this.copyFilter.clearGLSLSelf();
    this.cropFrame.clear();
    this.fillFrame.clear();
    GLES20.glDeleteTextures(this.tex.length, this.tex, 0);
  }
  
  public void init()
  {
    this.cropFilter.ApplyGLSLFilter();
    this.fillFilter.ApplyGLSLFilter();
    this.copyFilter.ApplyGLSLFilter();
    GLES20.glGenTextures(this.tex.length, this.tex, 0);
  }
  
  public Frame render(Frame paramFrame)
  {
    return this.fillFrame;
  }
  
  public void setImageNetSize(int paramInt1, int paramInt2)
  {
    this.NET_SIZE.width = paramInt1;
    this.NET_SIZE.height = paramInt2;
  }
  
  public void updateAndRender(Frame paramFrame, List<PointF> paramList, double paramDouble)
  {
    int i = paramFrame.getTextureId();
    int j = paramFrame.width;
    int k = paramFrame.height;
    paramFrame = VideoMaterialUtil.copyList(paramList);
    scale(paramFrame, 1.0D / paramDouble);
    FaceOffUtil.getFullCoords(paramFrame, 2.5F);
    calCropCoordsV2(paramFrame, j, k);
    this.cropFilter.setTexCords(this.texCoords);
    this.cropFilter.RenderProcess(i, this.NET_SIZE.width, this.NET_SIZE.height, -1, 0.0D, this.cropFrame);
    BenchUtil.benchStart(BenchUtil.SHOWPREVIEW_BENCH_TAG + "[updateAndRender] saveTexture");
    paramFrame = GlUtil.saveTexture(this.cropFrame);
    BenchUtil.benchEnd(BenchUtil.SHOWPREVIEW_BENCH_TAG + "[updateAndRender] saveTexture");
    BenchUtil.benchStart(BenchUtil.SHOWPREVIEW_BENCH_TAG + "[updateAndRender] forward");
    paramFrame = FeatureManager.Features.RAPID_NET_GENDER_SWITCH.forward(paramFrame, 0, 0);
    BenchUtil.benchEnd(BenchUtil.SHOWPREVIEW_BENCH_TAG + "[updateAndRender] forward");
    BenchUtil.benchStart(BenchUtil.SHOWPREVIEW_BENCH_TAG + "[updateAndRender] loadTexture");
    GlUtil.loadTexture(this.tex[0], paramFrame);
    BenchUtil.benchEnd(BenchUtil.SHOWPREVIEW_BENCH_TAG + "[updateAndRender] loadTexture");
    this.copyFilter.RenderProcess(i, j, k, -1, 0.0D, this.fillFrame);
    this.fillFilter.setPositions(this.position);
    GlUtil.setBlendMode(true);
    this.fillFilter.RenderProcess(this.tex[0], j, k, -1, 0.0D, this.fillFrame);
    GlUtil.setBlendMode(false);
  }
  
  public void updatePreview(Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.RapidNetFilter
 * JD-Core Version:    0.7.0.1
 */