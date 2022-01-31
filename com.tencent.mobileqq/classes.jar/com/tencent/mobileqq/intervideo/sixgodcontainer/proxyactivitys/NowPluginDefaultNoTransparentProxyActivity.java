package com.tencent.mobileqq.intervideo.sixgodcontainer.proxyactivitys;

import android.app.Activity;
import android.os.Bundle;
import android.os.Process;
import com.tencent.qphone.base.util.QLog;

public class NowPluginDefaultNoTransparentProxyActivity
  extends Activity
{
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    QLog.i("NowPluginManager", 2, "异常分支：自动重启Now插件Activity的场景，finish不做任何处理 ");
    finish();
    Process.killProcess(Process.myPid());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.sixgodcontainer.proxyactivitys.NowPluginDefaultNoTransparentProxyActivity
 * JD-Core Version:    0.7.0.1
 */