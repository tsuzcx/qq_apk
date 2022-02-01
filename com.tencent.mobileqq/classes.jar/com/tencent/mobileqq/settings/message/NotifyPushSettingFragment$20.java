package com.tencent.mobileqq.settings.message;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.utils.FriendsStatusUtil;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import mqq.app.AppRuntime;

final class NotifyPushSettingFragment$20
  implements Runnable
{
  public void run()
  {
    int j = 1;
    if (QLog.isDevelopLevel()) {
      QLog.i("ReportController", 4, "reportSettingStatusDaily run");
    }
    HashMap localHashMap = new HashMap();
    int i;
    label44:
    label69:
    label75:
    label100:
    label106:
    Object localObject;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getALLGeneralSettingVibrate() == 1)
    {
      i = 1;
      if (i == 0) {
        break label437;
      }
      i = 1;
      localHashMap.put("Clk_notice_shake", Integer.valueOf(i));
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getTroopGeneralSettingVibrate() != 1) {
        break label442;
      }
      i = 1;
      if (i == 0) {
        break label447;
      }
      i = 1;
      localHashMap.put("Clk_notice_grpshake", Integer.valueOf(i));
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getALLGeneralSettingRing() != 1) {
        break label452;
      }
      i = 1;
      if (i == 0) {
        break label457;
      }
      i = 1;
      localHashMap.put("Clk_notice_sound", Integer.valueOf(i));
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getTroopGeneralSettingRing() != 1) {
        break label462;
      }
      i = 1;
      label131:
      if (i == 0) {
        break label467;
      }
      i = 1;
      label137:
      localHashMap.put("Clk_notice_gupsound", Integer.valueOf(i));
      if (!FriendsStatusUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp())) {
        break label472;
      }
      i = 1;
      label164:
      localHashMap.put("Clk_night_mode", Integer.valueOf(i));
      if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isShowMsgContent()) {
        break label477;
      }
      i = 1;
      label188:
      localHashMap.put("Clk_hide_text", Integer.valueOf(i));
      if (!SettingCloneUtil.readValue(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131718680), "qqsetting_notify_blncontrol_key", true)) {
        break label482;
      }
      i = 1;
      label234:
      localHashMap.put("Led_blinking", Integer.valueOf(i));
      if (!SettingCloneUtil.readValue(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131718678), "qqsetting_notify_myfeedpush_key", true)) {
        break label487;
      }
      i = j;
      label280:
      localHashMap.put("Clk_about_me", Integer.valueOf(i));
      localObject = localHashMap.keySet();
      try
      {
        localObject = ((Set)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str2 = (String)((Iterator)localObject).next();
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliStatus", "", "", "Setting_tab", str2, 0, 0, String.valueOf(localHashMap.get(str2)), "", "", "");
        }
        boolean bool;
        str1 = "1";
      }
      catch (Exception localException)
      {
        bool = SettingCloneUtil.readValue(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), null, "qqsetting_pcactive_key", false);
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        if (!bool) {}
      }
    }
    for (;;)
    {
      ReportController.b((AppRuntime)localObject, "CliStatus", "", "", "0X8004971", "0X8004971", 0, 0, str1, "", "", "");
      return;
      i = 0;
      break;
      label437:
      i = 0;
      break label44;
      label442:
      i = 0;
      break label69;
      label447:
      i = 0;
      break label75;
      label452:
      i = 0;
      break label100;
      label457:
      i = 0;
      break label106;
      label462:
      i = 0;
      break label131;
      label467:
      i = 0;
      break label137;
      label472:
      i = 0;
      break label164;
      label477:
      i = 0;
      break label188;
      label482:
      i = 0;
      break label234;
      label487:
      i = 0;
      break label280;
      String str1 = "0";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.settings.message.NotifyPushSettingFragment.20
 * JD-Core Version:    0.7.0.1
 */