package com.tencent.mobileqq.intervideo.now.dynamic;

import android.os.Bundle;
import com.tencent.biz.now.NowRecordInfo;
import com.tencent.biz.now.NowRecordInfo.GetRecordCallBack;
import com.tencent.mobileqq.intervideo.now.NowDataReporter;
import com.tencent.qqinterface.CommonCallback;

class PluginManagerInterfaceImpl$3
  implements NowRecordInfo.GetRecordCallBack
{
  PluginManagerInterfaceImpl$3(PluginManagerInterfaceImpl paramPluginManagerInterfaceImpl, NowRecordInfo paramNowRecordInfo, CommonCallback paramCommonCallback) {}
  
  public void a(boolean paramBoolean, String paramString1, String paramString2, long paramLong, String paramString3)
  {
    this.c.a.a(this.a.a(), this.a.b(), paramLong, 0);
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("isOnline", paramBoolean);
    localBundle.putString("videoUrl", paramString1);
    localBundle.putString("vid", paramString2);
    localBundle.putLong("timeConsume", paramLong);
    localBundle.putString("mqqApi", paramString3);
    this.b.onResult(localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.now.dynamic.PluginManagerInterfaceImpl.3
 * JD-Core Version:    0.7.0.1
 */