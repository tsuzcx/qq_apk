package com.tencent.mobileqq.intervideo.huayang;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.hydevteam.pluginframework.installedplugin.InstalledPlugin;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.intervideo.IVPluginInfo;
import com.tencent.mobileqq.intervideo.LoginKeyHelper;
import com.tencent.mobileqq.intervideo.LoginKeyHelper.AccountInfo;
import com.tencent.mobileqq.intervideo.LoginKeyHelper.GetLoginKeyListener;
import com.tencent.mobileqq.intervideo.groupvideo.IVPluginDataReporter;
import com.tencent.mobileqq.intervideo.od.ODProxy;
import com.tencent.qphone.base.util.QLog;

class HuayangDowanloadHelper$GetLoginKeyDataListener
  implements LoginKeyHelper.GetLoginKeyListener
{
  private final long jdField_a_of_type_Long;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private final InstalledPlugin jdField_a_of_type_ComTencentHydevteamPluginframeworkInstalledpluginInstalledPlugin;
  private final IVPluginInfo jdField_a_of_type_ComTencentMobileqqIntervideoIVPluginInfo;
  private final String jdField_a_of_type_JavaLangString;
  private final boolean jdField_a_of_type_Boolean;
  private volatile boolean b;
  
  public HuayangDowanloadHelper$GetLoginKeyDataListener(HuayangDowanloadHelper paramHuayangDowanloadHelper, String paramString, IVPluginInfo paramIVPluginInfo, InstalledPlugin paramInstalledPlugin, boolean paramBoolean, long paramLong)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentMobileqqIntervideoIVPluginInfo = paramIVPluginInfo;
    this.jdField_a_of_type_ComTencentHydevteamPluginframeworkInstalledpluginInstalledPlugin = paramInstalledPlugin;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Long = paramLong;
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (!paramBoolean2))
    {
      HuayangDowanloadHelper.a(this.jdField_a_of_type_ComTencentMobileqqIntervideoHuayangHuayangDowanloadHelper).a(5, new Object[] { "" });
      return;
    }
    if (paramBoolean1) {}
    for (long l = 0L;; l = 2000L)
    {
      if (!this.b) {
        break label66;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("HuayangPluginNewDownloader", 2, "需要stop");
      return;
    }
    label66:
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new HuayangDowanloadHelper.GetLoginKeyDataListener.1(this, paramBoolean1, paramBoolean2), l);
  }
  
  public void a()
  {
    this.b = true;
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
  }
  
  public void onGetKeyComplete(String paramString, boolean paramBoolean, int paramInt)
  {
    int j = 1;
    long l1;
    label99:
    String str;
    if (paramBoolean) {
      if (this.jdField_a_of_type_ComTencentMobileqqIntervideoIVPluginInfo.jdField_a_of_type_Int == 1)
      {
        this.jdField_a_of_type_ComTencentMobileqqIntervideoIVPluginInfo.jdField_a_of_type_AndroidOsBundle = HuayangDowanloadHelper.a(this.jdField_a_of_type_ComTencentMobileqqIntervideoHuayangHuayangDowanloadHelper).a().a.getExtras();
        if ("Hy".equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqIntervideoIVPluginInfo.jdField_a_of_type_JavaLangString)) {
          Monitor.a("2653752");
        }
        a(this.jdField_a_of_type_Boolean, paramBoolean);
        long l2 = System.currentTimeMillis();
        if (!"Hy".equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqIntervideoIVPluginInfo.jdField_a_of_type_JavaLangString)) {
          break label421;
        }
        l1 = HuayangDowanloadHelper.a(this.jdField_a_of_type_ComTencentMobileqqIntervideoHuayangHuayangDowanloadHelper);
        l1 = l2 - l1;
        if (QLog.isColorLevel()) {
          QLog.d("HuayangPluginNewDownloader", 2, "拉取票据完成 耗时：" + l1 + "appId = " + paramString + " isSuccess =  " + paramBoolean + " code = " + paramInt);
        }
        if (!Monitor.jdField_a_of_type_Boolean) {
          break label433;
        }
        str = "huayang";
        label175:
        if (!paramBoolean) {
          break label440;
        }
        i = 1;
        label182:
        StoryReportor.a(str, "getLoginKey", i, (int)l1, new String[] { HuayangDowanloadHelper.c(this.jdField_a_of_type_ComTencentMobileqqIntervideoHuayangHuayangDowanloadHelper), paramInt + "", paramString, "8.5.5" });
        paramString = HuayangDowanloadHelper.a(this.jdField_a_of_type_ComTencentMobileqqIntervideoHuayangHuayangDowanloadHelper).opName(HuayangDowanloadHelper.a(this.jdField_a_of_type_ComTencentMobileqqIntervideoHuayangHuayangDowanloadHelper)).opType("getLoginKey");
        if (!paramBoolean) {
          break label446;
        }
      }
    }
    label421:
    label433:
    label440:
    label446:
    for (int i = j;; i = 0)
    {
      paramString.opIn(i).opResult(paramInt).report();
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqIntervideoIVPluginInfo.jdField_a_of_type_Int != 2) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqIntervideoIVPluginInfo.jdField_a_of_type_AndroidOsBundle = ODProxy.a(this.jdField_a_of_type_ComTencentMobileqqIntervideoIVPluginInfo, HuayangDowanloadHelper.a(this.jdField_a_of_type_ComTencentMobileqqIntervideoHuayangHuayangDowanloadHelper));
      if (!"Od".equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqIntervideoIVPluginInfo.jdField_a_of_type_JavaLangString)) {
        break;
      }
      Monitor.a("2691711");
      break;
      if ("Hy".equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqIntervideoIVPluginInfo.jdField_a_of_type_JavaLangString)) {
        Monitor.a("2653753");
      }
      for (;;)
      {
        Toast.makeText(HuayangDowanloadHelper.a(this.jdField_a_of_type_ComTencentMobileqqIntervideoHuayangHuayangDowanloadHelper), HardCodeUtil.a(2131705654) + paramInt, 0).show();
        break;
        if ("Od".equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqIntervideoIVPluginInfo.jdField_a_of_type_JavaLangString)) {
          Monitor.a("2691712");
        }
      }
      l1 = HuayangDowanloadHelper.b(this.jdField_a_of_type_ComTencentMobileqqIntervideoHuayangHuayangDowanloadHelper);
      break label99;
      str = "group_video";
      break label175;
      i = 0;
      break label182;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.huayang.HuayangDowanloadHelper.GetLoginKeyDataListener
 * JD-Core Version:    0.7.0.1
 */