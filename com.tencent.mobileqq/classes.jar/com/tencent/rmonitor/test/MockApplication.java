package com.tencent.rmonitor.test;

import android.app.Application;
import com.tencent.rmonitor.base.db.DBHandler;
import com.tencent.rmonitor.base.db.DBHelper;
import com.tencent.rmonitor.base.meta.BaseInfo;
import com.tencent.rmonitor.common.logger.Logger;

public class MockApplication
  extends Application
{
  private static Application mApplication;
  
  public static Application getInstance()
  {
    return mApplication;
  }
  
  public static void initBaseInfo()
  {
    if (BaseInfo.dbHelper != null)
    {
      BaseInfo.dbHelper.a().b();
      BaseInfo.dbHelper.close();
    }
    Logger.b.i(new String[] { "start initBaseInfo" });
    BaseInfo.app = getInstance();
    BaseInfo.urlMeta.rmonitorDomain = "https://rmonitor.qq.com";
    BaseInfo.userMeta.appId = "1024";
    BaseInfo.userMeta.appKey = "33e15431";
    BaseInfo.userMeta.uin = "11223344";
    BaseInfo.initInfo();
    BaseInfo.initUrl();
    Logger.b.i(new String[] { "end initBaseInfo" });
  }
  
  public void onCreate()
  {
    super.onCreate();
    mApplication = this;
    UnitTestLog.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.test.MockApplication
 * JD-Core Version:    0.7.0.1
 */