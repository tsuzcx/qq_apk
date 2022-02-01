package com.tencent.mobileqq.forward;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.ark.open.ArkAppCacheMgr;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.ArkAppCenterCheckEvent;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.service.MobileQQService;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.open.agent.report.ReportCenter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ForwardQzoneArkMsgOption
  extends ForwardBaseOption
{
  public ForwardQzoneArkMsgOption(Intent paramIntent)
  {
    super(paramIntent);
  }
  
  public String a()
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidOsBundle.getString("forward_ark_app_prompt");
      if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidOsBundle.getString("forward_ark_app_desc");
      }
    }
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public List<RecentUser> a(List<RecentUser> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      RecentUser localRecentUser = (RecentUser)paramList.next();
      if ((localRecentUser != null) && (!Utils.a(localRecentUser.uin)) && (localRecentUser.getType() != 1008) && (localRecentUser.getType() != 1005) && ((localRecentUser.getType() != 1006) || (a(ForwardAbility.ForwardAbilityType.h))) && (localRecentUser.getType() != 1009) && (localRecentUser.getType() != 1021) && (localRecentUser.getType() != 10004) && (localRecentUser.getType() != 7000) && (localRecentUser.getType() != 6004) && (localRecentUser.getType() != 9501) && ((localRecentUser.getType() != 0) || (!CrmUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localRecentUser.uin, localRecentUser.getType())))) {
        localArrayList.add(localRecentUser);
      }
    }
    return localArrayList;
  }
  
  public boolean a()
  {
    super.a();
    if (this.jdField_a_of_type_AndroidOsBundle.getBoolean("forward_ark_app_direct"))
    {
      d();
      this.jdField_a_of_type_AndroidAppActivity.finish();
    }
    return true;
  }
  
  protected boolean a(QQCustomDialog paramQQCustomDialog)
  {
    if (!this.jdField_a_of_type_AndroidOsBundle.getBoolean("is_ark_display_share")) {
      super.a(paramQQCustomDialog);
    }
    return true;
  }
  
  protected boolean a(String paramString1, int paramInt, String paramString2)
  {
    SessionInfo localSessionInfo = new SessionInfo();
    localSessionInfo.jdField_a_of_type_Int = paramInt;
    localSessionInfo.jdField_a_of_type_JavaLangString = paramString1;
    localSessionInfo.b = paramString2;
    if ((localSessionInfo.jdField_a_of_type_Int >= 0) && (!TextUtils.isEmpty(localSessionInfo.jdField_a_of_type_JavaLangString)))
    {
      Object localObject2 = this.jdField_a_of_type_AndroidOsBundle.getString("forward_ark_app_name");
      String str2 = this.jdField_a_of_type_AndroidOsBundle.getString("forward_ark_app_view");
      String str3 = this.jdField_a_of_type_AndroidOsBundle.getString("forward_ark_app_meta");
      String str4 = this.jdField_a_of_type_AndroidOsBundle.getString("forward_ark_app_config");
      String str5 = this.jdField_a_of_type_AndroidOsBundle.getString("forward_ark_app_prompt");
      String str1 = "0.0.0.1";
      Map localMap = ArkAppCacheMgr.getApplicationFromManifest((String)localObject2, "0.0.0.1");
      paramString2 = null;
      Object localObject1 = str1;
      if (localMap != null)
      {
        if (localMap.containsKey("desc")) {
          paramString1 = (String)localMap.get("desc");
        } else {
          paramString1 = "";
        }
        localObject1 = str1;
        paramString2 = paramString1;
        if (localMap.containsKey("version"))
        {
          localObject1 = (String)localMap.get("version");
          paramString2 = paramString1;
        }
      }
      if (TextUtils.isEmpty(paramString2)) {
        paramString1 = (String)localObject2;
      } else {
        paramString1 = paramString2;
      }
      if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (!TextUtils.isEmpty(str2)))
      {
        if (this.jdField_a_of_type_AndroidOsBundle.getBoolean("forward_ark_app_direct")) {
          ReportCenter.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "", "0", "2000", "2006", "0", false);
        }
        paramString2 = new ArkAppMessage(str5, (String)localObject2, paramString1, str2, (String)localObject1, str3, str4, "");
        localObject1 = (ArkAppMessage)ArkAppCenterCheckEvent.a(2, (String)localObject2, this.jdField_a_of_type_AndroidOsBundle, paramString2);
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
        paramInt = this.jdField_a_of_type_AndroidOsBundle.getInt("KEY_MSG_FORWARD_ID");
        ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localSessionInfo, paramString1, paramInt);
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
  
  protected void b()
  {
    if (p()) {
      this.jdField_a_of_type_JavaUtilSet.add(d);
    }
    if (q()) {
      this.jdField_a_of_type_JavaUtilSet.add(c);
    }
    if (r()) {
      this.jdField_a_of_type_JavaUtilSet.add(b);
    }
  }
  
  protected boolean c()
  {
    if (j())
    {
      Iterator localIterator = b().iterator();
      while (localIterator.hasNext())
      {
        ResultRecord localResultRecord = (ResultRecord)localIterator.next();
        a(localResultRecord.uin, localResultRecord.getUinType(), localResultRecord.groupUin);
      }
      return super.c();
    }
    d();
    return super.c();
  }
  
  protected boolean d()
  {
    int i = this.jdField_a_of_type_AndroidOsBundle.getInt("uintype");
    return a(this.jdField_a_of_type_AndroidOsBundle.getString("uin"), i, this.jdField_a_of_type_AndroidOsBundle.getString("troop_uin"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardQzoneArkMsgOption
 * JD-Core Version:    0.7.0.1
 */