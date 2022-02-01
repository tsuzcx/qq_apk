package com.tencent.ttpic.openapi.initializer;

import android.graphics.Bitmap;
import android.graphics.PointF;
import com.tencent.ttpic.baseutils.encrypt.MD5Util;
import com.tencent.ttpic.baseutils.io.FileUtils;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.openapi.manager.FeatureManager.Features;
import com.tencent.youtu.rapidnet.library.TNNStyleChild;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TNNStyleChildInitializer
  extends Feature
{
  private static final String TAG = "TNNStyleChildInitializer";
  public static final SharedLibraryInfo[] sharedLibraries = { new SharedLibraryInfo("c++_shared"), new SharedLibraryInfo("opencv_world"), new SharedLibraryInfo("TNN"), new SharedLibraryInfo("tnn_common"), new SharedLibraryInfo("tnn_stylechild") };
  private RapidnetModelManager modelManager = new RapidnetModelManager();
  private String modelMd5;
  private String protoMd5;
  private final TNNStyleChild tnnGenderSwitch = new TNNStyleChild();
  
  private boolean isHairSkyGenderModelLoaded()
  {
    return this.modelManager.isModelLoaded(6);
  }
  
  private boolean unloadRapidNetModelImpl(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    LogUtils.i("TNNStyleChildInitializer", "unloadRapidNetModelImpl");
    paramBoolean = false;
    if (paramInt1 == 6) {
      synchronized (this.tnnGenderSwitch)
      {
        this.modelManager.clear();
        paramInt1 = this.tnnGenderSwitch.deinit();
      }
    }
    paramInt1 = 0;
    if (paramInt1 == 0) {
      paramBoolean = true;
    }
    return paramBoolean;
  }
  
  public int addInitMat(int paramInt, Bitmap paramBitmap, boolean paramBoolean)
  {
    if ((isHairSkyGenderModelLoaded()) && (paramInt == 6)) {
      synchronized (this.tnnGenderSwitch)
      {
        if (this.modelManager.isModelLoaded(6))
        {
          paramInt = this.tnnGenderSwitch.addInitMat(paramBitmap, paramBoolean);
          return paramInt;
        }
      }
    }
    return -1;
  }
  
  public int addPostMat(int paramInt, Bitmap paramBitmap, boolean paramBoolean)
  {
    if ((isHairSkyGenderModelLoaded()) && (paramInt == 6)) {
      synchronized (this.tnnGenderSwitch)
      {
        if (this.modelManager.isModelLoaded(6))
        {
          paramInt = this.tnnGenderSwitch.addPostMat(paramBitmap, paramBoolean);
          return paramInt;
        }
      }
    }
    return -1;
  }
  
  public int addPreMat(int paramInt, Bitmap paramBitmap, boolean paramBoolean)
  {
    if ((isHairSkyGenderModelLoaded()) && (paramInt == 6)) {
      synchronized (this.tnnGenderSwitch)
      {
        if (this.modelManager.isModelLoaded(6))
        {
          paramInt = this.tnnGenderSwitch.addPreMat(paramBitmap, paramBoolean);
          return paramInt;
        }
      }
    }
    return -1;
  }
  
  public float[] averageFaceColorUsingFacePoints(Bitmap paramBitmap, List<PointF> paramList)
  {
    float[] arrayOfFloat1 = new float[paramList.size()];
    float[] arrayOfFloat2 = new float[paramList.size()];
    int i = 0;
    while (i < paramList.size())
    {
      arrayOfFloat1[i] = ((PointF)paramList.get(i)).x;
      arrayOfFloat2[i] = ((PointF)paramList.get(i)).y;
      i += 1;
    }
    return this.tnnGenderSwitch.averageFaceColorUsingFacePoints(paramBitmap, arrayOfFloat1, arrayOfFloat2);
  }
  
  public float[] computeFaceCropTransform(List<PointF> paramList, int paramInt1, float paramFloat, float[] paramArrayOfFloat1, int paramInt2, int paramInt3, float[] paramArrayOfFloat2)
  {
    float[] arrayOfFloat1 = new float[paramList.size()];
    float[] arrayOfFloat2 = new float[paramList.size()];
    int i = 0;
    while (i < paramList.size())
    {
      arrayOfFloat1[i] = ((PointF)paramList.get(i)).x;
      arrayOfFloat2[i] = ((PointF)paramList.get(i)).y;
      i += 1;
    }
    return this.tnnGenderSwitch.computeFaceCropTransform(arrayOfFloat1, arrayOfFloat2, paramInt1, paramFloat, paramArrayOfFloat1, paramInt2, paramInt3, paramArrayOfFloat2);
  }
  
  public int convertBitmapToFloat(int paramInt, Bitmap paramBitmap, float[] paramArrayOfFloat)
  {
    if ((isHairSkyGenderModelLoaded()) && (paramInt == 6)) {
      synchronized (this.tnnGenderSwitch)
      {
        if (this.modelManager.isModelLoaded(6))
        {
          paramInt = this.tnnGenderSwitch.convertBitmapToFloat(paramBitmap, paramArrayOfFloat);
          return paramInt;
        }
      }
    }
    return -1;
  }
  
  public Bitmap convertFloatToBitmap(int paramInt, float[] paramArrayOfFloat)
  {
    if ((isHairSkyGenderModelLoaded()) && (paramInt == 6)) {
      synchronized (this.tnnGenderSwitch)
      {
        if (this.modelManager.isModelLoaded(6))
        {
          paramArrayOfFloat = this.tnnGenderSwitch.convertFloatToBitmap(paramArrayOfFloat);
          return paramArrayOfFloat;
        }
      }
    }
    return null;
  }
  
  public void deInitAll()
  {
    if (FeatureManager.Features.TNN_STYLE_CHILD_INITIALIZER.isFunctionReady()) {
      destroyImpl();
    }
  }
  
  protected boolean destroyImpl()
  {
    synchronized (this.tnnGenderSwitch)
    {
      this.modelManager.clear();
      this.tnnGenderSwitch.deinit();
      return true;
    }
  }
  
  public int forward(int paramInt1, int paramInt2)
  {
    return forward(paramInt1, false, false, paramInt2);
  }
  
  public int forward(int paramInt1, boolean paramBoolean1, boolean paramBoolean2, int paramInt2)
  {
    if ((isHairSkyGenderModelLoaded()) && (paramInt1 == 6)) {
      synchronized (this.tnnGenderSwitch)
      {
        if (this.modelManager.isModelLoaded(6))
        {
          paramInt1 = this.tnnGenderSwitch.forwardTwoOutput();
          return paramInt1;
        }
      }
    }
    return -1;
  }
  
  public List<ModelInfo> getModelInfos()
  {
    return new ArrayList();
  }
  
  public String getModelMd5()
  {
    return this.modelMd5;
  }
  
  public String getName()
  {
    return "TNNStyleChildInitializer";
  }
  
  public String getProtoMd5()
  {
    return this.protoMd5;
  }
  
  public List<SharedLibraryInfo> getSharedLibraries()
  {
    return Arrays.asList(sharedLibraries);
  }
  
  protected boolean initImpl()
  {
    return loadAllSoFiles();
  }
  
  public int initProcess(int paramInt)
  {
    if ((isHairSkyGenderModelLoaded()) && (paramInt == 6)) {
      synchronized (this.tnnGenderSwitch)
      {
        if (this.modelManager.isModelLoaded(6))
        {
          paramInt = this.tnnGenderSwitch.initProcess();
          return paramInt;
        }
      }
    }
    return -1;
  }
  
  public boolean isModelLoaded(int paramInt)
  {
    return this.modelManager.isModelLoaded(paramInt);
  }
  
  public boolean loadRapidModelFrom(String paramString1, String arg2, boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      LogUtils.i("TNNStyleChildInitializer", "loadRapidNetModelImpl");
      paramBoolean1 = isFunctionReady();
      if (!paramBoolean1) {
        return false;
      }
      paramBoolean1 = unloadRapidNetModelImpl(false, paramInt1, paramInt3);
      if (!paramBoolean1) {
        return false;
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(???);
      ((StringBuilder)localObject).append(".rapidmodel.wmc");
      localObject = RapidnetModelManager.copyIfInAssets(paramString1, ((StringBuilder)localObject).toString(), FeatureManager.Features.TNN_STYLE_CHILD_INITIALIZER.getFinalResourcesDir());
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(???);
      localStringBuilder.append(".rapidproto.wmc");
      paramString1 = RapidnetModelManager.copyIfInAssets(paramString1, localStringBuilder.toString(), FeatureManager.Features.TNN_STYLE_CHILD_INITIALIZER.getFinalResourcesDir());
      ??? = new File((String)localObject);
      this.protoMd5 = MD5Util.getFileMD5(new File(paramString1));
      this.modelMd5 = MD5Util.getFileMD5(???);
      if ((FileUtils.isFileExist((String)localObject)) && (FileUtils.isFileExist(paramString1))) {
        synchronized (this.tnnGenderSwitch)
        {
          paramInt1 = this.tnnGenderSwitch.init(paramString1, (String)localObject, "OPENCL");
          if (paramInt1 != 0)
          {
            paramString1 = new StringBuilder();
            paramString1.append("RapidnetLib init failed ret =");
            paramString1.append(paramInt1);
            LogUtils.d("TNNStyleChildInitializer", paramString1.toString());
          }
          else
          {
            paramString1 = new StringBuilder();
            paramString1.append("RapidnetLib init success. ret =");
            paramString1.append(paramInt1);
            LogUtils.d("TNNStyleChildInitializer", paramString1.toString());
            this.modelManager.toggleRapidModel(paramInt3, true);
            return true;
          }
        }
      }
      return false;
    }
    finally {}
  }
  
  public float[] pixelLUT(Bitmap paramBitmap, float[] paramArrayOfFloat, float paramFloat, boolean paramBoolean)
  {
    return this.tnnGenderSwitch.pixelLUT(paramBitmap, paramArrayOfFloat, paramFloat, paramBoolean);
  }
  
  public int setParams(int paramInt1, String paramString1, int paramInt2, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, float[] paramArrayOfFloat3, float[] paramArrayOfFloat4, float[] paramArrayOfFloat5, float[] paramArrayOfFloat6)
  {
    if ((isHairSkyGenderModelLoaded()) && (paramInt1 == 6)) {
      synchronized (this.tnnGenderSwitch)
      {
        if (this.modelManager.isModelLoaded(6))
        {
          paramInt1 = this.tnnGenderSwitch.setParams(paramString1, paramInt2, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, paramArrayOfFloat1, paramArrayOfFloat2, paramArrayOfFloat3, paramArrayOfFloat4, paramArrayOfFloat5, paramArrayOfFloat6);
          return paramInt1;
        }
      }
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.openapi.initializer.TNNStyleChildInitializer
 * JD-Core Version:    0.7.0.1
 */