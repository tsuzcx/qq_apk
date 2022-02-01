package com.tencent.ttpic.openapi.initializer;

import android.graphics.Bitmap;
import com.tencent.ttpic.baseutils.io.FileUtils;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.openapi.manager.FeatureManager.Features;
import com.tencent.youtu.rapidnet.library.TNNSeg;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TNNSegGpuInitializer
  extends Feature
{
  private static final String TAG = "TNNSegGpuInitializer";
  public static final SharedLibraryInfo[] sharedLibraries = { new SharedLibraryInfo("c++_shared"), new SharedLibraryInfo("opencv_world"), new SharedLibraryInfo("TNN"), new SharedLibraryInfo("tnn_common"), new SharedLibraryInfo("tnn_seg") };
  private RapidnetModelManager modelManager = new RapidnetModelManager();
  private final TNNSeg rapidnetGPUSegmentationHair = new TNNSeg();
  private final TNNSeg rapidnetGPUSegmentationSky = new TNNSeg();
  
  private boolean isHairSkyGenderModelLoaded()
  {
    RapidnetModelManager localRapidnetModelManager = this.modelManager;
    boolean bool = false;
    if ((localRapidnetModelManager.isModelLoaded(0)) || (this.modelManager.isModelLoaded(1)) || (this.modelManager.isModelLoaded(2))) {
      bool = true;
    }
    return bool;
  }
  
  private boolean unloadRapidNetModelImpl(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    LogUtils.i("TNNSegGpuInitializer", "unloadRapidNetModelImpl");
    if (paramInt2 == 1) {
      synchronized (this.rapidnetGPUSegmentationHair)
      {
        paramInt1 = this.rapidnetGPUSegmentationHair.deinit();
      }
    }
    if (paramInt2 == 2) {
      synchronized (this.rapidnetGPUSegmentationSky)
      {
        paramInt1 = this.rapidnetGPUSegmentationSky.deinit();
      }
    }
    paramInt1 = 0;
    return paramInt1 == 0;
  }
  
  public void deInitAll()
  {
    if (FeatureManager.Features.RAPID_NET_SEG_GPU.isFunctionReady()) {
      destroyImpl();
    }
  }
  
  protected boolean destroyImpl()
  {
    synchronized (this.rapidnetGPUSegmentationHair)
    {
      this.rapidnetGPUSegmentationHair.deinit();
      synchronized (this.rapidnetGPUSegmentationSky)
      {
        this.rapidnetGPUSegmentationSky.deinit();
        return true;
      }
    }
  }
  
  public Bitmap forward(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    return forward(paramBitmap, paramInt1, false, false, paramInt2);
  }
  
  public Bitmap forward(Bitmap paramBitmap, int paramInt1, boolean paramBoolean1, boolean paramBoolean2, int paramInt2)
  {
    if (isHairSkyGenderModelLoaded())
    {
      if (paramInt1 == 1) {
        synchronized (this.rapidnetGPUSegmentationHair)
        {
          if (this.modelManager.isModelLoaded(1))
          {
            paramBitmap = this.rapidnetGPUSegmentationHair.forwardWithAngle(paramBitmap, paramInt2);
            return paramBitmap;
          }
          return paramBitmap;
        }
      }
      if (paramInt1 == 2) {
        synchronized (this.rapidnetGPUSegmentationSky)
        {
          if (this.modelManager.isModelLoaded(2))
          {
            paramBitmap = this.rapidnetGPUSegmentationSky.forwardWithAngle(paramBitmap, paramInt2);
            return paramBitmap;
          }
          return paramBitmap;
        }
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
    return "TNNSegGpuInitializer";
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
  
  public boolean loadRapidModelFrom(String paramString1, String arg2, boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, int paramInt3)
  {
    for (;;)
    {
      try
      {
        LogUtils.i("TNNSegGpuInitializer", "loadRapidNetModelImpl");
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
        localObject = RapidnetModelManager.copyIfInAssets(paramString1, ((StringBuilder)localObject).toString(), FeatureManager.Features.RAPID_NET_SEG_GPU.getFinalResourcesDir());
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(???);
        localStringBuilder.append(".rapidproto.wmc");
        paramString1 = RapidnetModelManager.copyIfInAssets(paramString1, localStringBuilder.toString(), FeatureManager.Features.RAPID_NET_SEG_GPU.getFinalResourcesDir());
        new File((String)localObject);
        new File(paramString1);
        if ((FileUtils.isFileExist((String)localObject)) && (FileUtils.isFileExist(paramString1)))
        {
          if (paramInt3 == 1) {
            synchronized (this.rapidnetGPUSegmentationHair)
            {
              paramInt1 = this.rapidnetGPUSegmentationHair.init(paramString1, (String)localObject, "OPENCL");
            }
          }
          if (paramInt3 != 2) {
            break label322;
          }
          synchronized (this.rapidnetGPUSegmentationSky)
          {
            paramInt1 = this.rapidnetGPUSegmentationSky.init(paramString1, (String)localObject, "OPENCL");
          }
          if (paramInt1 != 0)
          {
            paramString1 = new StringBuilder();
            paramString1.append("RapidnetLib init failed ret =");
            paramString1.append(paramInt1);
            LogUtils.d("TNNSegGpuInitializer", paramString1.toString());
          }
          else
          {
            paramString1 = new StringBuilder();
            paramString1.append("RapidnetLib init success. ret =");
            paramString1.append(paramInt1);
            LogUtils.d("TNNSegGpuInitializer", paramString1.toString());
            this.modelManager.toggleRapidModel(paramInt3, true);
            return true;
          }
        }
        return false;
      }
      finally {}
      label322:
      paramInt1 = -1;
    }
  }
  
  public void setMode(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 1) {
      synchronized (this.rapidnetGPUSegmentationHair)
      {
        if (this.modelManager.isModelLoaded(1)) {
          this.rapidnetGPUSegmentationHair.setMode(paramInt2);
        }
        return;
      }
    }
    if (paramInt1 == 2) {
      synchronized (this.rapidnetGPUSegmentationSky)
      {
        if (this.modelManager.isModelLoaded(2)) {
          this.rapidnetGPUSegmentationSky.setMode(paramInt2);
        }
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.openapi.initializer.TNNSegGpuInitializer
 * JD-Core Version:    0.7.0.1
 */