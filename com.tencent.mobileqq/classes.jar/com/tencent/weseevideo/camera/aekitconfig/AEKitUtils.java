package com.tencent.weseevideo.camera.aekitconfig;

import android.content.Context;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.aekit.api.standard.AEModuleConfig;
import com.tencent.aekit.api.standard.AEModuleConfig.Builder;
import com.tencent.aekit.openrender.util.GlUtil;
import com.tencent.oscar.app.GlobalContext;
import com.tencent.ttpic.openapi.initializer.ImageAlgoInitializer;
import com.tencent.ttpic.openapi.manager.FeatureManager;
import com.tencent.ttpic.openapi.manager.FeatureManager.Features;

public class AEKitUtils
{
  private static final String TAG = "AEKitUtils";
  private boolean mIsLoadAekitSo = false;
  
  public static AEKitUtils g()
  {
    return AEKitUtils.SINGLETON.getInstance();
  }
  
  public void initAEKit(Context paramContext)
  {
    AEModule.initialize(paramContext, AEModuleConfig.newBuilder().build());
    loadAekitSoAndSetting();
  }
  
  public void loadAekitSoAndSetting()
  {
    if (this.mIsLoadAekitSo) {
      return;
    }
    GlUtil.setEnableLog(false);
    if (AEModule.getContext() == null) {
      AEModule.setContext(GlobalContext.getContext());
    }
    FeatureManager.loadBasicFeatures();
    FeatureManager.Features.IMAGE_ALGO.init();
    this.mIsLoadAekitSo = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.weseevideo.camera.aekitconfig.AEKitUtils
 * JD-Core Version:    0.7.0.1
 */