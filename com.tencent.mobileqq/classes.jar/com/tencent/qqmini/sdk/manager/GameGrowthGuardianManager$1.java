package com.tencent.qqmini.sdk.manager;

import android.content.Context;
import bgwl;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

public final class GameGrowthGuardianManager$1
  implements Runnable
{
  public GameGrowthGuardianManager$1(MiniAppInfo paramMiniAppInfo, Context paramContext) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.gameAdsTotalTime = 0;
    bgwl.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo, 11);
    bgwl.a(System.currentTimeMillis());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.manager.GameGrowthGuardianManager.1
 * JD-Core Version:    0.7.0.1
 */