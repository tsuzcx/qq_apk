package com.tencent.mobileqq.intervideo.huayang;

import android.content.Intent;
import com.tencent.mobileqq.qroute.QRoute;

class HuayangLoadbackgroudActivity$2
  implements IHuayangPluginLauncher.HuayangPluginLauncherListener
{
  HuayangLoadbackgroudActivity$2(HuayangLoadbackgroudActivity paramHuayangLoadbackgroudActivity) {}
  
  public void a(int paramInt)
  {
    Intent localIntent = new Intent(((IHuayangJsPlugin)QRoute.api(IHuayangJsPlugin.class)).getLauncherNotifyAction(HuayangLoadbackgroudActivity.a(this.a)));
    localIntent.putExtra("key_state", 4);
    localIntent.putExtra("key_progress", paramInt);
    localIntent.putExtra("key_totalSize", 100L);
    this.a.sendBroadcast(localIntent);
  }
  
  public void a(boolean paramBoolean, Throwable paramThrowable)
  {
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.huayang.HuayangLoadbackgroudActivity.2
 * JD-Core Version:    0.7.0.1
 */