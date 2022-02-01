package com.tencent.ttpic.openapi.initializer;

import android.graphics.Bitmap;
import com.tencent.ttpic.baseutils.io.FileUtils;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.openapi.manager.FeatureManager.Features;
import com.tencent.youtu.rapidnet.library.TNNSegHuman;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TNNHumanSegGpuInitializer
  extends Feature
{
  private static final String TAG = "TNNHumanSegGpuInitializer";
  public static final SharedLibraryInfo[] sharedLibraries = { new SharedLibraryInfo("c++_shared"), new SharedLibraryInfo("opencv_world"), new SharedLibraryInfo("TNN"), new SharedLibraryInfo("tnn_common"), new SharedLibraryInfo("tnn_seg_human") };
  private RapidnetModelManager modelManager = new RapidnetModelManager();
  private final TNNSegHuman rapidnetGPUSegmentationHuman = new TNNSegHuman();
  
  private boolean isHumanSegModelLoaded()
  {
    return this.modelManager.isModelLoaded(4);
  }
  
  private boolean unloadRapidNetModelImpl(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    LogUtils.i("TNNHumanSegGpuInitializer", "unloadRapidNetModelImpl");
    paramBoolean = false;
    if (paramInt2 == 4) {
      synchronized (this.rapidnetGPUSegmentationHuman)
      {
        paramInt1 = this.rapidnetGPUSegmentationHuman.deinit();
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
    if (FeatureManager.Features.RAPID_NET_HUMAN_SEG_GPU.isFunctionReady()) {
      destroyImpl();
    }
  }
  
  protected boolean destroyImpl()
  {
    synchronized (this.rapidnetGPUSegmentationHuman)
    {
      this.rapidnetGPUSegmentationHuman.deinit();
      return true;
    }
  }
  
  public Bitmap forward(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    return forward(paramBitmap, paramInt1, false, false, paramInt2);
  }
  
  public Bitmap forward(Bitmap paramBitmap, int paramInt1, boolean paramBoolean1, boolean paramBoolean2, int paramInt2)
  {
    if ((isHumanSegModelLoaded()) && (paramInt1 == 4)) {
      synchronized (this.rapidnetGPUSegmentationHuman)
      {
        if (isHumanSegModelLoaded())
        {
          paramBitmap = this.rapidnetGPUSegmentationHuman.forwardWithAngle(paramBitmap, 0);
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
    return "TNNHumanSegGpuInitializer";
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
  
  public boolean loadRapidModelFrom(String arg1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, int paramInt3)
  {
    for (;;)
    {
      try
      {
        LogUtils.i("TNNHumanSegGpuInitializer", "loadRapidNetModelImpl");
        paramBoolean1 = isFunctionReady();
        if (!paramBoolean1) {
          return false;
        }
        paramBoolean1 = unloadRapidNetModelImpl(false, paramInt1, paramInt3);
        if (!paramBoolean1) {
          return false;
        }
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString2);
        ((StringBuilder)localObject).append(".rapidmodel.wmc");
        localObject = RapidnetModelManager.copyIfInAssets(???, ((StringBuilder)localObject).toString(), FeatureManager.Features.RAPID_NET_SEG_GPU.getFinalResourcesDir());
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString2);
        localStringBuilder.append(".rapidproto.wmc");
        paramString2 = RapidnetModelManager.copyIfInAssets(???, localStringBuilder.toString(), FeatureManager.Features.RAPID_NET_SEG_GPU.getFinalResourcesDir());
        new File((String)localObject);
        new File(paramString2);
        if ((FileUtils.isFileExist((String)localObject)) && (FileUtils.isFileExist(paramString2)))
        {
          if (paramInt3 != 4) {
            break label285;
          }
          synchronized (this.rapidnetGPUSegmentationHuman)
          {
            paramInt1 = this.rapidnetGPUSegmentationHuman.init(paramString2, (String)localObject, "OPENCL");
          }
          if (paramInt1 != 0)
          {
            ??? = new StringBuilder();
            ???.append("RapidnetLib init failed ret =");
            ???.append(paramInt1);
            LogUtils.d("TNNHumanSegGpuInitializer", ???.toString());
          }
          else
          {
            ??? = new StringBuilder();
            ???.append("RapidnetLib init success. ret =");
            ???.append(paramInt1);
            LogUtils.d("TNNHumanSegGpuInitializer", ???.toString());
            this.modelManager.toggleRapidModel(paramInt3, true);
            return true;
          }
        }
        return false;
      }
      finally {}
      label285:
      paramInt1 = -1;
    }
  }
  
  public void setMode(int paramInt)
  {
    if (isHumanSegModelLoaded()) {
      synchronized (this.rapidnetGPUSegmentationHuman)
      {
        if (isHumanSegModelLoaded()) {
          this.rapidnetGPUSegmentationHuman.setMode(paramInt);
        }
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.openapi.initializer.TNNHumanSegGpuInitializer
 * JD-Core Version:    0.7.0.1
 */