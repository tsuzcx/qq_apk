package com.tencent.mobileqq.intervideo.huayang;

import android.content.Intent;

class HuayangLoadbackgroudActivity$2
  implements HuayangPluginLauncher.HuayangPluginLauncherListener
{
  HuayangLoadbackgroudActivity$2(HuayangLoadbackgroudActivity paramHuayangLoadbackgroudActivity) {}
  
  public void a(int paramInt)
  {
    Intent localIntent = new Intent(HuayangJsPlugin.d(HuayangLoadbackgroudActivity.a(this.a)));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.huayang.HuayangLoadbackgroudActivity.2
 * JD-Core Version:    0.7.0.1
 */