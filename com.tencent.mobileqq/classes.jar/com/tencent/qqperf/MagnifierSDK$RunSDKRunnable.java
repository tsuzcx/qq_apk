package com.tencent.qqperf;

import android.app.Application;
import android.content.SharedPreferences;
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
    MagnifierSDK.c = MagnifierSDK.a(this.a);
    MagnifierSDK.d = MagnifierSDK.c.edit();
    MagnifierSDK.e = DBHandler.a(this.a.getApplicationContext());
    this.this$0.h.loadLocalConfigs();
    ArrayList localArrayList = new ArrayList();
    if (MobileQQ.sProcessId == 1) {
      localArrayList.add(MagnifierSDK.b().h());
    }
    if ((MobileQQ.sProcessId == 1) || (MobileQQ.sProcessId == 2) || (MobileQQ.sProcessId == 7)) {
      localArrayList.add(MagnifierSDK.b().g());
    }
    if ((MobileQQ.sProcessId == 1) || (MobileQQ.sProcessId == 2)) {
      localArrayList.add(MagnifierSDK.b().f());
    }
    if (MobileQQ.sProcessId != 4) {
      localArrayList.add(MagnifierSDK.b().c());
    }
    localArrayList.add(MagnifierSDK.b().i());
    if ((MobileQQ.sProcessId == 1) || (MobileQQ.sProcessId == 2) || (MobileQQ.sProcessId == 5) || (MobileQQ.sProcessId == 7) || (MobileQQ.sProcessId == 9) || (MobileQQ.sProcessId == 11) || (MobileQQ.sProcessId == 10))
    {
      localArrayList.add(MagnifierSDK.b().e());
      localArrayList.add(MagnifierSDK.b().d());
    }
    int i = MobileQQ.sProcessId;
    MagnifierSDK.a(MagnifierSDK.b(), localArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqperf.MagnifierSDK.RunSDKRunnable
 * JD-Core Version:    0.7.0.1
 */