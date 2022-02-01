package com.tencent.mobileqq.forward;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.ark.open.ArkAppCacheMgr;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.ArkAppCenterCheckEvent;
import com.tencent.mobileqq.ark.api.IArkSecure;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.service.MobileQQService;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.open.agent.report.ReportCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ForwardArkH5StructOption
  extends ForwardPluginShareStructMsgOption
{
  public ForwardArkH5StructOption(Intent paramIntent)
  {
    super(paramIntent);
  }
  
  protected void a()
  {
    boolean bool1 = this.jdField_a_of_type_AndroidOsBundle.getBoolean("forward_ark_from_h5_success");
    boolean bool2 = this.jdField_a_of_type_AndroidOsBundle.getBoolean("forward_ark_from_h5_parse_meta_success");
    QLog.d("ForwardOption.ForwardPluginShareStructMsgOption", 1, new Object[] { "ShareArkFromH5 before sendArkMag isUrlLegal=", Boolean.valueOf(bool1), ", isMetaLegal=", Boolean.valueOf(bool2) });
    if (j())
    {
      if ((bool1) && (bool2))
      {
        H();
        Iterator localIterator = b().iterator();
        while (localIterator.hasNext())
        {
          ResultRecord localResultRecord = (ResultRecord)localIterator.next();
          a(localResultRecord.uin, localResultRecord.groupUin, localResultRecord.getUinType());
        }
      }
      super.a();
      return;
    }
    if ((bool1) && (bool2))
    {
      H();
      l_();
      return;
    }
    super.a();
  }
  
  public boolean a()
  {
    e();
    o();
    return super.a();
  }
  
  protected boolean a(QQCustomDialog paramQQCustomDialog)
  {
    if ((!this.jdField_a_of_type_AndroidOsBundle.getBoolean("is_ark_display_share")) || (!this.jdField_a_of_type_AndroidOsBundle.getBoolean("forward_ark_from_h5_parse_meta_success"))) {
      super.a(paramQQCustomDialog);
    }
    return true;
  }
  
  protected boolean a(String paramString1, String paramString2, int paramInt)
  {
    SessionInfo localSessionInfo = new SessionInfo();
    localSessionInfo.jdField_a_of_type_Int = paramInt;
    localSessionInfo.jdField_a_of_type_JavaLangString = paramString1;
    localSessionInfo.b = paramString2;
    if ((localSessionInfo.jdField_a_of_type_Int >= 0) && (!TextUtils.isEmpty(localSessionInfo.jdField_a_of_type_JavaLangString)))
    {
      String str1 = this.jdField_a_of_type_AndroidOsBundle.getString("forward_ark_app_name");
      String str2 = this.jdField_a_of_type_AndroidOsBundle.getString("forward_ark_app_view");
      Object localObject1 = this.jdField_a_of_type_AndroidOsBundle.getString("forward_ark_app_desc", "");
      String str3 = this.jdField_a_of_type_AndroidOsBundle.getString("forward_ark_app_meta");
      String str4 = this.jdField_a_of_type_AndroidOsBundle.getString("forward_ark_app_config");
      Object localObject2 = this.jdField_a_of_type_AndroidOsBundle.getString("forward_ark_app_prompt");
      paramString2 = "0.0.0.1";
      Map localMap = ArkAppCacheMgr.getApplicationFromManifest(str1, "0.0.0.1");
      paramString1 = paramString2;
      if (localMap != null)
      {
        paramString1 = paramString2;
        if (localMap.containsKey("version")) {
          paramString1 = (String)localMap.get("version");
        }
      }
      paramString2 = (String)localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        paramString2 = String.format(HardCodeUtil.a(2131704828), new Object[] { "" });
      }
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject1 = "";
      }
      if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2)))
      {
        if (this.jdField_a_of_type_AndroidOsBundle.getBoolean("forward_ark_app_direct")) {
          ReportCenter.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "", "0", "2000", "2006", "0", false);
        }
        paramString2 = new ArkAppMessage(paramString2, str1, (String)localObject1, str2, paramString1, str3, str4, "");
        localObject1 = (ArkAppMessage)ArkAppCenterCheckEvent.a(2, str1, this.jdField_a_of_type_AndroidOsBundle, paramString2);
        paramString1 = (String)localObject1;
        if (localObject1 == null) {
          paramString1 = paramString2;
        }
        localObject1 = StructMsgFactory.a(this.jdField_a_of_type_AndroidOsBundle);
        paramString2 = this.jdField_a_of_type_AndroidOsBundle.getString("forward_appId_ark_from_sdk");
        localObject2 = this.jdField_a_of_type_AndroidOsBundle.getString("struct_share_key_source_name");
        str1 = this.jdField_a_of_type_AndroidOsBundle.getString("struct_share_key_source_action_data");
        str2 = this.jdField_a_of_type_AndroidOsBundle.getString("struct_share_key_source_a_action_data_from_h5");
        str3 = this.jdField_a_of_type_AndroidOsBundle.getString("struct_share_key_source_url");
        if (!TextUtils.isEmpty(paramString2))
        {
          paramString1.appId = paramString2;
          paramString1.mSourceName = ((String)localObject2);
          paramString1.mSourceActionData = str1;
          paramString1.mSource_A_ActionData = str2;
          paramString1.mSourceUrl = str3;
        }
        if (localObject1 != null)
        {
          paramInt = localSessionInfo.jdField_a_of_type_Int;
          if ((paramInt != 1000) && (paramInt != 1004) && (paramInt != 1020)) {}
          for (paramString2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();; paramString2 = localSessionInfo.b) {
            break;
          }
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
          str1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
          str2 = localSessionInfo.jdField_a_of_type_JavaLangString;
          paramInt = localSessionInfo.jdField_a_of_type_Int;
          int i = MobileQQService.seq;
          MobileQQService.seq = i + 1;
          paramString1.containStructMsg = MessageRecordFactory.a((QQAppInterface)localObject2, str1, str2, paramString2, paramInt, i, (AbsStructMsg)localObject1);
        }
        ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localSessionInfo, paramString1);
        return true;
      }
      if (this.jdField_a_of_type_AndroidOsBundle.getBoolean("forward_ark_app_direct")) {
        ReportCenter.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "", "0", "2000", "2006", "1", false);
      }
      return false;
    }
    if (this.jdField_a_of_type_AndroidOsBundle.getBoolean("forward_ark_app_direct")) {
      ReportCenter.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "", "0", "2000", "2006", "1", false);
    }
    return false;
  }
  
  protected void e()
  {
    String str1 = this.jdField_a_of_type_AndroidOsBundle.getString("forward_ark_app_name");
    String str2 = this.jdField_a_of_type_AndroidOsBundle.getString("forward_ark_h5_from_normal");
    String str3 = this.jdField_a_of_type_AndroidOsBundle.getString("forward_ark_app_view");
    if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2))) {
      ((IArkSecure)QRoute.api(IArkSecure.class)).checkShareUrl(str1, str3, str2, new ForwardArkH5StructOption.1(this));
    }
  }
  
  protected boolean l_()
  {
    int i = this.jdField_a_of_type_AndroidOsBundle.getInt("uintype");
    boolean bool = a(this.jdField_a_of_type_AndroidOsBundle.getString("uin"), this.jdField_a_of_type_AndroidOsBundle.getString("troop_uin"), i);
    this.jdField_a_of_type_AndroidAppActivity.finish();
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardArkH5StructOption
 * JD-Core Version:    0.7.0.1
 */