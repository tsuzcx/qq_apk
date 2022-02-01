package com.tencent.ttpic.openapi.initializer;

import android.graphics.Bitmap;
import com.tencent.ttpic.baseutils.io.FileUtils;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.openapi.manager.FeatureManager.Features;
import com.tencent.youtu.rapidnet.library.TNNRGBDepth;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TNNRGBDepthInitializer
  extends Feature
{
  private static final String TAG = "TNNRGBDepthInitializer";
  public static final SharedLibraryInfo[] sharedLibraries = { new SharedLibraryInfo("c++_shared"), new SharedLibraryInfo("opencv_world"), new SharedLibraryInfo("TNN"), new SharedLibraryInfo("tnn_common"), new SharedLibraryInfo("tnn_rgb_depth") };
  private RapidnetModelManager modelManager = new RapidnetModelManager();
  private final TNNRGBDepth rapidnetRGBDepth = new TNNRGBDepth();
  
  private boolean isHairSkyGenderModelLoaded()
  {
    return this.modelManager.isModelLoaded(7);
  }
  
  private boolean unloadRapidNetModelImpl(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    LogUtils.i("TNNRGBDepthInitializer", "unloadRapidNetModelImpl");
    paramBoolean = false;
    if (paramInt2 == 7) {
      synchronized (this.rapidnetRGBDepth)
      {
        paramInt1 = this.rapidnetRGBDepth.deinit();
      }
    }
    paramInt1 = 0;
    if (paramInt1 == 0) {
      paramBoolean = true;
    }
    return paramBoolean;
  }
  
  public void deInitAll()
  {
    if (FeatureManager.Features.RAPID_NET_RGB_DEPTH.isFunctionReady()) {
      destroyImpl();
    }
  }
  
  protected boolean destroyImpl()
  {
    synchronized (this.rapidnetRGBDepth)
    {
      this.rapidnetRGBDepth.deinit();
      return true;
    }
  }
  
  public Bitmap forward(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    return forward(paramBitmap, paramInt1, false, false, paramInt2);
  }
  
  public Bitmap forward(Bitmap paramBitmap, int paramInt1, boolean paramBoolean1, boolean paramBoolean2, int paramInt2)
  {
    if ((isHairSkyGenderModelLoaded()) && (paramInt1 == 7)) {
      synchronized (this.rapidnetRGBDepth)
      {
        if (this.modelManager.isModelLoaded(7))
        {
          paramBitmap = this.rapidnetRGBDepth.forwardWithAngle(paramBitmap, paramInt2);
          return paramBitmap;
        }
        return paramBitmap;
      }
    }
    return paramBitmap;
  }
  
  public List<ModelInfo> getModelInfos()
  {
    return new ArrayList();
  }
  
  public String getName()
  {
    return "TNNRGBDepthInitializer";
  }
  
  public List<SharedLibraryInfo> getSharedLibraries()
  {
    return Arrays.asList(sharedLibraries);
  }
  
  protected boolean initImpl()
  {
    return loadAllSoFiles();
  }
  
  public boolean isModelLoaded(int paramInt)
  {
    return this.modelManager.isModelLoaded(paramInt);
  }
  
  public boolean loadRapidModelFrom(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, int paramInt3)
  {
    for (;;)
    {
      try
      {
        LogUtils.i("TNNRGBDepthInitializer", "loadRapidNetModelImpl");
        paramBoolean1 = isFunctionReady();
        if (!paramBoolean1) {
          return false;
        }
        paramBoolean1 = unloadRapidNetModelImpl(false, paramInt1, paramInt3);
        if (!paramBoolean1) {
          return false;
        }
        Object localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(paramString2);
        ((StringBuilder)localObject1).append(".tnnm.wmc");
        localObject1 = RapidnetModelManager.copyIfInAssets(paramString1, ((StringBuilder)localObject1).toString(), FeatureManager.Features.RAPID_NET_RGB_DEPTH.getFinalResourcesDir());
        ??? = new StringBuilder();
        ((StringBuilder)???).append(paramString2);
        ((StringBuilder)???).append(".tnnp.wmc");
        paramString2 = RapidnetModelManager.copyIfInAssets(paramString1, ((StringBuilder)???).toString(), FeatureManager.Features.RAPID_NET_RGB_DEPTH.getFinalResourcesDir());
        if ((FileUtils.isFileExist((String)localObject1)) && (FileUtils.isFileExist(paramString2)))
        {
          if (paramInt3 != 7) {
            break label287;
          }
          if (paramInt2 != 0) {
            break label281;
          }
          paramString1 = "ARM";
          synchronized (this.rapidnetRGBDepth)
          {
            paramInt1 = this.rapidnetRGBDepth.init(paramString2, (String)localObject1, paramString1);
          }
          if (paramInt1 != 0)
          {
            paramString1 = new StringBuilder();
            paramString1.append("RapidnetLib init failed ret =");
            paramString1.append(paramInt1);
            LogUtils.d("TNNRGBDepthInitializer", paramString1.toString());
          }
          else
          {
            paramString1 = new StringBuilder();
            paramString1.append("RapidnetLib init success. ret =");
            paramString1.append(paramInt1);
            LogUtils.d("TNNRGBDepthInitializer", paramString1.toString());
            this.modelManager.toggleRapidModel(paramInt3, true);
            return true;
          }
        }
        return false;
      }
      finally {}
      label281:
      paramString1 = "OPENCL";
      continue;
      label287:
      paramInt1 = -1;
    }
  }
  
  public void setMode(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 7) {
      synchronized (this.rapidnetRGBDepth)
      {
        if (this.modelManager.isModelLoaded(7)) {
          this.rapidnetRGBDepth.setMode(paramInt2);
        }
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.openapi.initializer.TNNRGBDepthInitializer
 * JD-Core Version:    0.7.0.1
 */