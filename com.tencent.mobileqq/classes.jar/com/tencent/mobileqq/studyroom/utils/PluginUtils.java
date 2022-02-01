package com.tencent.mobileqq.studyroom.utils;

import android.content.Context;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SingleFileThreadExecutor;
import com.tencent.mobileqq.studyroom.shadow.IVPluginManager;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class PluginUtils
{
  private static IVPluginManager a;
  
  public static Future<?> a(Context paramContext, Bundle paramBundle, boolean paramBoolean, PluginUtils.PluginCallback paramPluginCallback)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    paramBundle.putString("qqVersion", "8.5.5");
    paramBundle.putString("bizType", "StudyRoom");
    paramBundle.putString("plugin_id", "StudyRoom");
    paramBundle.putString("appid", "101854111");
    paramBundle.putInt("authtype", 1);
    paramBundle.putInt("isGroupCode", 1);
    paramBundle.putInt("roomCodeType", 1);
    paramBundle.putString("uin", localQQAppInterface.getCurrentUin());
    paramBundle.putBoolean("preload", paramBoolean);
    paramBundle.putString("fromId", "1");
    paramBundle.putLong("ts_click_millisecond", System.currentTimeMillis());
    paramBundle.putBoolean("show_status_bar", true);
    return SingleFileThreadExecutor.a().submit(new PluginUtils.1(paramContext, paramBundle, paramPluginCallback));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.studyroom.utils.PluginUtils
 * JD-Core Version:    0.7.0.1
 */