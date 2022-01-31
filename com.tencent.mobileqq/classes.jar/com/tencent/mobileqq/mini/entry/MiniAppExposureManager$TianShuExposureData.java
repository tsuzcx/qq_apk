package com.tencent.mobileqq.mini.entry;

import android.util.Log;
import biam;
import bian;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class MiniAppExposureManager$TianShuExposureData
  extends MiniAppExposureManager.BaseExposureReport
{
  private int actionId;
  private String appId;
  private String itemId;
  private String pageId;
  
  public MiniAppExposureManager$TianShuExposureData(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    this.appId = paramString1;
    this.pageId = paramString2;
    this.itemId = paramString3;
    this.actionId = paramInt;
  }
  
  public void report()
  {
    try
    {
      bian localbian = new bian();
      AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
      String str = "";
      if (localAppRuntime != null) {
        str = localAppRuntime.getAccount();
      }
      long l = NetConnInfoCenter.getServerTimeMillis() / 1000L;
      localbian.b = (str + "_" + l);
      localbian.jdField_a_of_type_Int = 1;
      localbian.jdField_e_of_type_JavaLangString = this.appId;
      localbian.f = this.pageId;
      localbian.g = this.itemId;
      localbian.d = this.actionId;
      localbian.jdField_e_of_type_Int = 1;
      localbian.jdField_a_of_type_Long = l;
      biam.a().a(localbian);
      if (QLog.isColorLevel()) {
        QLog.i("MiniAppExposureManager", 2, "TianShuExposureData, report itemId: " + this.itemId);
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("MiniAppExposureManager", 1, "TianShuExposureData, report exception: " + Log.getStackTraceString(localException));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.MiniAppExposureManager.TianShuExposureData
 * JD-Core Version:    0.7.0.1
 */