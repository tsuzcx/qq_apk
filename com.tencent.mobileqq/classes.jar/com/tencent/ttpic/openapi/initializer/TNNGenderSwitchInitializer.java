package com.tencent.ttpic.openapi.initializer;

import android.graphics.Bitmap;
import com.tencent.aekit.openrender.util.AEProfiler;
import com.tencent.ttpic.baseutils.io.FileUtils;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.openapi.manager.FeatureManager.Features;
import com.tencent.youtu.rapidnet.library.TNNGenderSwitch;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TNNGenderSwitchInitializer
  extends Feature
{
  private static final String TAG = "RapidNetGenderSwitchInitializer";
  public static final SharedLibraryInfo[] sharedLibraries = { new SharedLibraryInfo("c++_shared"), new SharedLibraryInfo("opencv_world"), new SharedLibraryInfo("TNN"), new SharedLibraryInfo("tnn_common"), new SharedLibraryInfo("tnn_genderswitch") };
  private RapidnetModelManager modelManager = new RapidnetModelManager();
  private final TNNGenderSwitch rapidnetGPUGenderSwitch = new TNNGenderSwitch();
  
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
    LogUtils.i("RapidNetGenderSwitchInitializer", "unloadRapidNetModelImpl");
    if (paramInt1 == 1) {
      synchronized (this.rapidnetGPUGenderSwitch)
      {
        paramInt1 = this.rapidnetGPUGenderSwitch.deinit();
      }
    }
    paramInt1 = 0;
    return paramInt1 == 0;
  }
  
  public void deInitAll()
  {
    if (FeatureManager.Features.RAPID_NET_GENDER_SWITCH.isFunctionReady()) {
      destroyImpl();
    }
  }
  
  protected boolean destroyImpl()
  {
    synchronized (this.rapidnetGPUGenderSwitch)
    {
      this.rapidnetGPUGenderSwitch.deinit();
      return true;
    }
  }
  
  public Bitmap forward(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    return forward(paramBitmap, paramInt1, false, false, paramInt2);
  }
  
  public Bitmap forward(Bitmap paramBitmap, int paramInt1, boolean paramBoolean1, boolean paramBoolean2, int paramInt2)
  {
    if ((isHairSkyGenderModelLoaded()) && (paramInt1 == 0)) {
      synchronized (this.rapidnetGPUGenderSwitch)
      {
        if (this.modelManager.isModelLoaded(0))
        {
          AEProfiler.getInstance().start("GenderSwitch");
          paramBitmap = this.rapidnetGPUGenderSwitch.forwardWithAngle(paramBitmap, paramInt2);
          long l = AEProfiler.getInstance().end("GenderSwitch");
          AEProfiler.getInstance().add(1, "GenderSwitch", l);
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
    return "RapidNetGenderSwitchInitializer";
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
    try
    {
      LogUtils.i("RapidNetGenderSwitchInitializer", "loadRapidNetModelImpl");
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
      localObject = RapidnetModelManager.copyIfInAssets(???, ((StringBuilder)localObject).toString(), FeatureManager.Features.RAPID_NET_GENDER_SWITCH.getFinalResourcesDir());
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString2);
      localStringBuilder.append(".rapidproto.wmc");
      paramString2 = RapidnetModelManager.copyIfInAssets(???, localStringBuilder.toString(), FeatureManager.Features.RAPID_NET_GENDER_SWITCH.getFinalResourcesDir());
      new File((String)localObject);
      new File(paramString2);
      if ((FileUtils.isFileExist((String)localObject)) && (FileUtils.isFileExist(paramString2))) {
        synchronized (this.rapidnetGPUGenderSwitch)
        {
          paramInt1 = this.rapidnetGPUGenderSwitch.init(paramString2, (String)localObject, "OPENCL");
          if (paramInt1 != 0)
          {
            ??? = new StringBuilder();
            ???.append("RapidnetLib init failed ret =");
            ???.append(paramInt1);
            LogUtils.d("RapidNetGenderSwitchInitializer", ???.toString());
          }
          else
          {
            ??? = new StringBuilder();
            ???.append("RapidnetLib init success. ret =");
            ???.append(paramInt1);
            LogUtils.d("RapidNetGenderSwitchInitializer", ???.toString());
            this.modelManager.toggleRapidModel(paramInt3, true);
            return true;
          }
        }
      }
      return false;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.openapi.initializer.TNNGenderSwitchInitializer
 * JD-Core Version:    0.7.0.1
 */