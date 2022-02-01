package com.tencent.qqperf;

import android.app.Application;
import android.content.SharedPreferences;
import com.tencent.qqperf.config.APMConfig;
import com.tencent.qqperf.config.Config;
import com.tencent.qqperf.repoter.DBHandler;
import java.util.ArrayList;
import mqq.app.MobileQQ;

class MagnifierSDK$RunSDKRunnable
  implements Runnable
{
  private Application a;
  
  public MagnifierSDK$RunSDKRunnable(MagnifierSDK paramMagnifierSDK, Application paramApplication)
  {
    this.a = paramApplication;
  }
  
  public void run()
  {
    MagnifierSDK.jdField_a_of_type_AndroidContentSharedPreferences = MagnifierSDK.a(this.a);
    MagnifierSDK.jdField_a_of_type_AndroidContentSharedPreferences$Editor = MagnifierSDK.jdField_a_of_type_AndroidContentSharedPreferences.edit();
    MagnifierSDK.jdField_a_of_type_ComTencentQqperfRepoterDBHandler = DBHandler.a(this.a.getApplicationContext());
    this.this$0.jdField_a_of_type_ComTencentQqperfConfigConfig.loadLocalConfigs();
    ArrayList localArrayList = new ArrayList();
    if (MobileQQ.sProcessId == 1) {
      localArrayList.add(MagnifierSDK.a().b());
    }
    if ((MobileQQ.sProcessId == 1) || (MobileQQ.sProcessId == 2) || (MobileQQ.sProcessId == 7)) {
      localArrayList.add(MagnifierSDK.a().a());
    }
    if ((MobileQQ.sProcessId == 1) || (MobileQQ.sProcessId == 2)) {
      localArrayList.add(MagnifierSDK.a().a());
    }
    if (MobileQQ.sProcessId != 4) {
      localArrayList.add(MagnifierSDK.a().a());
    }
    localArrayList.add(MagnifierSDK.a().a());
    if ((MobileQQ.sProcessId == 1) || (MobileQQ.sProcessId == 2) || (MobileQQ.sProcessId == 5) || (MobileQQ.sProcessId == 7) || (MobileQQ.sProcessId == 9) || (MobileQQ.sProcessId == 11) || (MobileQQ.sProcessId == 10))
    {
      localArrayList.add(MagnifierSDK.a().a());
      localArrayList.add(MagnifierSDK.a().a());
    }
    int i = MobileQQ.sProcessId;
    MagnifierSDK.a(MagnifierSDK.a(), localArrayList);
    if (!MagnifierSDK.a().a().runIo) {
      boolean bool = MagnifierSDK.a().a().runDb;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqperf.MagnifierSDK.RunSDKRunnable
 * JD-Core Version:    0.7.0.1
 */