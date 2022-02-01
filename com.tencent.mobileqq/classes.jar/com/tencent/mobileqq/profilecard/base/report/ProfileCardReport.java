package com.tencent.mobileqq.profilecard.base.report;

import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.base.utils.ProfileCardUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

public class ProfileCardReport
{
  private static final String TAG = "ProfileCardReport";
  
  public static void reportAddFriendClick(QQAppInterface paramQQAppInterface, ProfileCardInfo paramProfileCardInfo)
  {
    ReportController.b(paramQQAppInterface, "dc00898", "", paramProfileCardInfo.a.jdField_a_of_type_JavaLangString, "0X800B0B2", "0X800B0B2", 0, 0, "", "", "", "");
  }
  
  public static void reportChatClick(QQAppInterface paramQQAppInterface, ProfileCardInfo paramProfileCardInfo)
  {
    String str = paramProfileCardInfo.a.jdField_a_of_type_JavaLangString;
    if (ProfileCardUtils.isFriend(paramQQAppInterface, str)) {}
    for (paramProfileCardInfo = "1";; paramProfileCardInfo = "2")
    {
      ReportController.b(paramQQAppInterface, "dc00898", "", str, "0X800B0B1", "0X800B0B1", 0, 0, paramProfileCardInfo, "", "", "");
      return;
    }
  }
  
  public static void reportGivePresentClick(QQAppInterface paramQQAppInterface, ProfileCardInfo paramProfileCardInfo)
  {
    String str = paramProfileCardInfo.a.jdField_a_of_type_JavaLangString;
    if (ProfileCardUtils.isFriend(paramQQAppInterface, str)) {}
    for (paramProfileCardInfo = "1";; paramProfileCardInfo = "2")
    {
      ReportController.b(paramQQAppInterface, "dc00898", "", str, "0X800A1C5", "0X800A1C5", 0, 0, paramProfileCardInfo, "", "", "");
      return;
    }
  }
  
  public static void reportMiniAppClick(QQAppInterface paramQQAppInterface, ProfileCardInfo paramProfileCardInfo)
  {
    String str = paramProfileCardInfo.a.jdField_a_of_type_JavaLangString;
    int i;
    if (paramProfileCardInfo.a.jdField_a_of_type_Int == 0)
    {
      i = 1;
      if (i == 0) {
        break label55;
      }
    }
    label55:
    for (paramProfileCardInfo = "1";; paramProfileCardInfo = "2")
    {
      ReportController.b(paramQQAppInterface, "dc00898", "", str, "0X800B0B5", "0X800B0B5", 0, 0, paramProfileCardInfo, "", "", "");
      return;
      i = 0;
      break;
    }
  }
  
  public static void reportPresentClick(QQAppInterface paramQQAppInterface, ProfileCardInfo paramProfileCardInfo)
  {
    String str = paramProfileCardInfo.a.jdField_a_of_type_JavaLangString;
    int i;
    if (paramProfileCardInfo.a.jdField_a_of_type_Int == 0)
    {
      i = 1;
      if (i == 0) {
        break label55;
      }
    }
    label55:
    for (paramProfileCardInfo = "1";; paramProfileCardInfo = "2")
    {
      ReportController.b(paramQQAppInterface, "dc00898", "", str, "0X800B0BC", "0X800B0BC", 0, 0, paramProfileCardInfo, "", "", "");
      return;
      i = 0;
      break;
    }
  }
  
  public static void reportProfileEditClick(QQAppInterface paramQQAppInterface, ProfileCardInfo paramProfileCardInfo)
  {
    ReportController.b(paramQQAppInterface, "dc00898", "", paramProfileCardInfo.a.jdField_a_of_type_JavaLangString, "0X8007EB6", "0X8007EB6", 0, 0, "", "", "", "");
  }
  
  public static void reportProfileEntry(QQAppInterface paramQQAppInterface, ProfileCardInfo paramProfileCardInfo)
  {
    int i = 1;
    int j = paramProfileCardInfo.a.jdField_a_of_type_Int;
    int k = paramProfileCardInfo.a.h;
    if (j == 0)
    {
      j = 1;
      if (j == 0) {
        break label137;
      }
      if (k != 8) {
        break label70;
      }
    }
    label137:
    for (;;)
    {
      if (j == 0) {
        break label250;
      }
      ReportController.b(paramQQAppInterface, "dc00898", "", "", "0X8007EB3", "0X8007EB3", i, 0, "", "", "", "");
      return;
      j = 0;
      break;
      label70:
      if (k == 1)
      {
        i = 2;
      }
      else if (k == 107)
      {
        i = 3;
      }
      else if (k == 106)
      {
        i = 5;
      }
      else if (k == 7)
      {
        i = 6;
      }
      else if (k == 98)
      {
        i = 9;
      }
      else
      {
        i = 15;
        continue;
        if (k != 61) {
          if (k == 1) {
            i = 2;
          } else if (k == 107) {
            i = 3;
          } else if (k == 106) {
            i = 5;
          } else if (k == 109) {
            i = 6;
          } else if (k == 59) {
            i = 7;
          } else if (k == 98) {
            i = 9;
          } else if (k == 88) {
            i = 10;
          } else if (k == 7) {
            i = 11;
          } else {
            i = 15;
          }
        }
      }
    }
    label250:
    String str2 = paramProfileCardInfo.a.jdField_a_of_type_JavaLangString;
    String str1;
    if (ProfileCardUtils.isFriend(paramQQAppInterface, str2))
    {
      str1 = "1";
      if (!ProfileActivity.AllInOne.b(paramProfileCardInfo.a)) {
        break label316;
      }
    }
    label316:
    for (paramProfileCardInfo = "2";; paramProfileCardInfo = "1")
    {
      ReportController.b(paramQQAppInterface, "dc00898", "", str2, "0X8007EB4", "0X8007EB4", i, 0, str1, "", paramProfileCardInfo, "");
      return;
      str1 = "2";
      break;
    }
  }
  
  public static void reportQQCircleClick(QQAppInterface paramQQAppInterface, ProfileCardInfo paramProfileCardInfo)
  {
    String str = paramProfileCardInfo.a.jdField_a_of_type_JavaLangString;
    int i;
    if (paramProfileCardInfo.a.jdField_a_of_type_Int == 0)
    {
      i = 1;
      if (i == 0) {
        break label55;
      }
    }
    label55:
    for (paramProfileCardInfo = "1";; paramProfileCardInfo = "2")
    {
      ReportController.b(paramQQAppInterface, "dc00898", "", str, "0X800B0B9", "0X800B0B9", 0, 0, paramProfileCardInfo, "", "", "");
      return;
      i = 0;
      break;
    }
  }
  
  public static void reportTemplateClick(QQAppInterface paramQQAppInterface, ProfileCardInfo paramProfileCardInfo)
  {
    ReportController.b(paramQQAppInterface, "dc00898", "", paramProfileCardInfo.a.jdField_a_of_type_JavaLangString, "0X800B0B3", "0X800B0B3", 0, 0, "", "", "", "");
  }
  
  public static void reportTroopLevelClick(QQAppInterface paramQQAppInterface, ProfileCardInfo paramProfileCardInfo)
  {
    String str = paramProfileCardInfo.a.jdField_a_of_type_JavaLangString;
    int i;
    if (paramProfileCardInfo.a.jdField_a_of_type_Int == 0)
    {
      i = 1;
      if (i == 0) {
        break label55;
      }
    }
    label55:
    for (paramProfileCardInfo = "1";; paramProfileCardInfo = "2")
    {
      ReportController.b(paramQQAppInterface, "dc00898", "", str, "0X800B0B7", "0X800B0B7", 0, 0, paramProfileCardInfo, "", "", "");
      return;
      i = 0;
      break;
    }
  }
  
  public static void reportTroopProfileCardGivePresentClick(QQAppInterface paramQQAppInterface, ProfileCardInfo paramProfileCardInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileCardReport", 2, "reportTroopProfileCardGivePresentClick");
    }
    String str = paramProfileCardInfo.a.jdField_a_of_type_JavaLangString;
    if (ProfileCardUtils.isFriend(paramQQAppInterface, str)) {}
    for (paramProfileCardInfo = "1";; paramProfileCardInfo = "2")
    {
      ReportController.b(paramQQAppInterface, "dc00898", "", str, "0X800B102", "0X800B102", 0, 0, paramProfileCardInfo, "", "", "");
      return;
    }
  }
  
  public static void reportVideoCallClick(QQAppInterface paramQQAppInterface, ProfileCardInfo paramProfileCardInfo)
  {
    ReportController.b(paramQQAppInterface, "dc00898", "", paramProfileCardInfo.a.jdField_a_of_type_JavaLangString, "0X8008404", "0X8008404", 0, 0, "", "", "", "");
  }
  
  public static void reportWeiShiClick(QQAppInterface paramQQAppInterface, ProfileCardInfo paramProfileCardInfo)
  {
    String str = paramProfileCardInfo.a.jdField_a_of_type_JavaLangString;
    int i;
    if (paramProfileCardInfo.a.jdField_a_of_type_Int == 0)
    {
      i = 1;
      if (i == 0) {
        break label55;
      }
    }
    label55:
    for (paramProfileCardInfo = "1";; paramProfileCardInfo = "2")
    {
      ReportController.b(paramQQAppInterface, "dc00898", "", str, "0X800B0BB", "0X800B0BB", 0, 0, paramProfileCardInfo, "", "", "");
      return;
      i = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.base.report.ProfileCardReport
 * JD-Core Version:    0.7.0.1
 */