package com.tencent.mobileqq.profilecard.base.report;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.utils.ProfilePAUtils;
import com.tencent.mobileqq.profilecard.utils.ProfileUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

public class ProfileCardReport
{
  private static final String TAG = "ProfileCardReport";
  
  public static void reportAddFriendClick(AppInterface paramAppInterface, ProfileCardInfo paramProfileCardInfo)
  {
    ReportController.b(paramAppInterface, "dc00898", "", paramProfileCardInfo.allInOne.uin, "0X800B0B2", "0X800B0B2", 0, 0, "", "", "", "");
  }
  
  public static void reportChatClick(AppInterface paramAppInterface, ProfileCardInfo paramProfileCardInfo)
  {
    String str = paramProfileCardInfo.allInOne.uin;
    if (ProfileUtils.isFriend(paramAppInterface, str)) {
      paramProfileCardInfo = "1";
    } else {
      paramProfileCardInfo = "2";
    }
    ReportController.b(paramAppInterface, "dc00898", "", str, "0X800B0B1", "0X800B0B1", 0, 0, paramProfileCardInfo, "", "", "");
  }
  
  public static void reportGivePresentClick(AppInterface paramAppInterface, ProfileCardInfo paramProfileCardInfo)
  {
    String str = paramProfileCardInfo.allInOne.uin;
    if (ProfileUtils.isFriend(paramAppInterface, str)) {
      paramProfileCardInfo = "1";
    } else {
      paramProfileCardInfo = "2";
    }
    ReportController.b(paramAppInterface, "dc00898", "", str, "0X800A1C5", "0X800A1C5", 0, 0, paramProfileCardInfo, "", "", "");
  }
  
  public static void reportMiniAppClick(AppInterface paramAppInterface, ProfileCardInfo paramProfileCardInfo)
  {
    String str = paramProfileCardInfo.allInOne.uin;
    int i;
    if (paramProfileCardInfo.allInOne.pa == 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      paramProfileCardInfo = "1";
    } else {
      paramProfileCardInfo = "2";
    }
    ReportController.b(paramAppInterface, "dc00898", "", str, "0X800B0B5", "0X800B0B5", 0, 0, paramProfileCardInfo, "", "", "");
  }
  
  public static void reportPresentClick(AppInterface paramAppInterface, ProfileCardInfo paramProfileCardInfo)
  {
    String str = paramProfileCardInfo.allInOne.uin;
    int i;
    if (paramProfileCardInfo.allInOne.pa == 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      paramProfileCardInfo = "1";
    } else {
      paramProfileCardInfo = "2";
    }
    ReportController.b(paramAppInterface, "dc00898", "", str, "0X800B0BC", "0X800B0BC", 0, 0, paramProfileCardInfo, "", "", "");
  }
  
  public static void reportProfileEditClick(AppInterface paramAppInterface, ProfileCardInfo paramProfileCardInfo)
  {
    ReportController.b(paramAppInterface, "dc00898", "", paramProfileCardInfo.allInOne.uin, "0X8007EB6", "0X8007EB6", 0, 0, "", "", "", "");
  }
  
  public static void reportProfileEntry(AppInterface paramAppInterface, ProfileCardInfo paramProfileCardInfo)
  {
    int j = paramProfileCardInfo.allInOne.pa;
    int i = paramProfileCardInfo.allInOne.profileEntryType;
    if (j == 0) {
      j = 1;
    } else {
      j = 0;
    }
    if (j != 0)
    {
      if (i == 8) {
        break label99;
      }
      if (i == 1) {
        break label109;
      }
      if (i == 107) {
        break label120;
      }
      if (i == 106) {
        break label131;
      }
      if (i == 7) {
        break label142;
      }
      if (i == 98)
      {
        i = 9;
        break label190;
      }
    }
    label99:
    label109:
    label120:
    do
    {
      i = 15;
      break label190;
      if (i == 61)
      {
        i = 1;
        break label190;
      }
      if (i == 1)
      {
        i = 2;
        break label190;
      }
      if (i == 107)
      {
        i = 3;
        break label190;
      }
      if (i == 106)
      {
        i = 5;
        break label190;
      }
      if (i == 109)
      {
        i = 6;
        break label190;
      }
      if (i == 59)
      {
        i = 7;
        break label190;
      }
      if (i == 98) {
        break;
      }
      if (i == 88)
      {
        i = 10;
        break label190;
      }
    } while (i != 7);
    label131:
    label142:
    i = 11;
    label190:
    if (j != 0)
    {
      ReportController.b(paramAppInterface, "dc00898", "", "", "0X8007EB3", "0X8007EB3", i, 0, "", "", "", "");
      return;
    }
    String str2 = paramProfileCardInfo.allInOne.uin;
    String str1;
    if (ProfileUtils.isFriend(paramAppInterface, str2)) {
      str1 = "1";
    } else {
      str1 = "2";
    }
    if (ProfilePAUtils.isPaTypeFriend(paramProfileCardInfo.allInOne)) {
      paramProfileCardInfo = "2";
    } else {
      paramProfileCardInfo = "1";
    }
    ReportController.b(paramAppInterface, "dc00898", "", str2, "0X8007EB4", "0X8007EB4", i, 0, str1, "", paramProfileCardInfo, "");
  }
  
  public static void reportQQCircleClick(AppInterface paramAppInterface, ProfileCardInfo paramProfileCardInfo)
  {
    String str = paramProfileCardInfo.allInOne.uin;
    int i;
    if (paramProfileCardInfo.allInOne.pa == 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      paramProfileCardInfo = "1";
    } else {
      paramProfileCardInfo = "2";
    }
    ReportController.b(paramAppInterface, "dc00898", "", str, "0X800B0B9", "0X800B0B9", 0, 0, paramProfileCardInfo, "", "", "");
  }
  
  public static void reportTemplateClick(AppInterface paramAppInterface, ProfileCardInfo paramProfileCardInfo)
  {
    ReportController.b(paramAppInterface, "dc00898", "", paramProfileCardInfo.allInOne.uin, "0X800B0B3", "0X800B0B3", 0, 0, "", "", "", "");
  }
  
  public static void reportTroopLevelClick(AppInterface paramAppInterface, ProfileCardInfo paramProfileCardInfo)
  {
    String str = paramProfileCardInfo.allInOne.uin;
    int i;
    if (paramProfileCardInfo.allInOne.pa == 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      paramProfileCardInfo = "1";
    } else {
      paramProfileCardInfo = "2";
    }
    ReportController.b(paramAppInterface, "dc00898", "", str, "0X800B0B7", "0X800B0B7", 0, 0, paramProfileCardInfo, "", "", "");
  }
  
  public static void reportTroopProfileCardGivePresentClick(AppInterface paramAppInterface, ProfileCardInfo paramProfileCardInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileCardReport", 2, "reportTroopProfileCardGivePresentClick");
    }
    String str = paramProfileCardInfo.allInOne.uin;
    if (ProfileUtils.isFriend(paramAppInterface, str)) {
      paramProfileCardInfo = "1";
    } else {
      paramProfileCardInfo = "2";
    }
    ReportController.b(paramAppInterface, "dc00898", "", str, "0X800B102", "0X800B102", 0, 0, paramProfileCardInfo, "", "", "");
  }
  
  public static void reportVideoCallClick(AppInterface paramAppInterface, ProfileCardInfo paramProfileCardInfo)
  {
    ReportController.b(paramAppInterface, "dc00898", "", paramProfileCardInfo.allInOne.uin, "0X8008404", "0X8008404", 0, 0, "", "", "", "");
  }
  
  public static void reportWeiShiClick(AppInterface paramAppInterface, ProfileCardInfo paramProfileCardInfo)
  {
    String str = paramProfileCardInfo.allInOne.uin;
    int i;
    if (paramProfileCardInfo.allInOne.pa == 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      paramProfileCardInfo = "1";
    } else {
      paramProfileCardInfo = "2";
    }
    ReportController.b(paramAppInterface, "dc00898", "", str, "0X800B0BB", "0X800B0BB", 0, 0, paramProfileCardInfo, "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.base.report.ProfileCardReport
 * JD-Core Version:    0.7.0.1
 */