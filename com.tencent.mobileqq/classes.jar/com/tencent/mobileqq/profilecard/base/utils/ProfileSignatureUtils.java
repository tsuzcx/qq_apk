package com.tencent.mobileqq.profilecard.base.utils;

import android.content.Intent;
import android.view.View;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity.Launcher;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.profile.SigTopicManager;
import com.tencent.mobileqq.richstatus.SignatureHistoryFragment;
import com.tencent.mobileqq.richstatus.topic.TopicUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.unifiedname.MQQName;
import com.tencent.mobileqq.unifiedname.MQQProfileName;
import com.tencent.mobileqq.vas.signature.SignatureEditManager;

public class ProfileSignatureUtils
{
  public static void handleSignatureClick(ProfileCardInfo paramProfileCardInfo, BaseActivity paramBaseActivity, QQAppInterface paramQQAppInterface)
  {
    if (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0) {
      SignatureEditManager.a(paramBaseActivity, paramQQAppInterface, 0, "signature_ziliaoka");
    }
    while (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0)
    {
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X8006A79", "0X8006A79", 0, 0, "", "", "", "");
      return;
      Intent localIntent = new Intent(paramBaseActivity, PublicFragmentActivity.class);
      localIntent.putExtra("key_uin", paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
      localIntent.putExtra("key_uin_name", paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQProfileName.a.jdField_a_of_type_JavaLangString);
      localIntent.putExtra("key_open_via", "history-kerentaiziliaoka");
      PublicFragmentActivity.Launcher.a(paramBaseActivity, localIntent, PublicFragmentActivity.class, SignatureHistoryFragment.class);
    }
    ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X8006A8D", "0X8006A8D", 0, 0, "", "", "", "");
  }
  
  public static void handleSignatureCommonClick(View paramView, int paramInt, String paramString, BaseActivity paramBaseActivity, QQAppInterface paramQQAppInterface)
  {
    TopicUtil.a(paramBaseActivity, TopicUtil.a(paramInt, paramString), -1);
    paramView.setVisibility(8);
    SigTopicManager.a().b(paramQQAppInterface);
    ReportController.b(null, "dc00898", "", "", "0X800A4D5", "0X800A4D5", 0, 0, "1", "0", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.base.utils.ProfileSignatureUtils
 * JD-Core Version:    0.7.0.1
 */