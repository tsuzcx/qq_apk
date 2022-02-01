package com.tencent.mobileqq.forward;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.TMG.utils.QLog;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.ark.ArkAppCenterCheckEvent;
import com.tencent.mobileqq.ark.api.IArkHelper;
import com.tencent.mobileqq.ark.api.IArkSecure;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.util.Utils;
import com.tencent.open.agent.report.ReportCenter;
import com.tencent.open.sdk.report.SdkShareReporter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;

public class ForwardArkMsgOption
  extends ForwardBaseOption
{
  public ForwardArkMsgOption(Intent paramIntent)
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
  
  protected void a()
  {
    super.a();
    SdkShareReporter.a(this.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_Long);
  }
  
  public void a(QQAppInterface paramQQAppInterface, Activity paramActivity)
  {
    super.a(paramQQAppInterface, paramActivity);
    ((IArkHelper)QRoute.api(IArkHelper.class)).preDownloadApp(this.jdField_a_of_type_AndroidOsBundle.getString("forward_ark_app_name"), this.jdField_a_of_type_AndroidOsBundle.getString("forward_ark_app_view"));
  }
  
  public boolean a()
  {
    super.a();
    e();
    if (this.jdField_a_of_type_AndroidOsBundle.getBoolean("forward_ark_app_direct"))
    {
      d();
      this.jdField_a_of_type_AndroidAppActivity.finish();
    }
    return true;
  }
  
  protected boolean a(String paramString1, int paramInt1, String paramString2, int paramInt2)
  {
    SessionInfo localSessionInfo = new SessionInfo();
    localSessionInfo.jdField_a_of_type_Int = paramInt1;
    localSessionInfo.jdField_a_of_type_JavaLangString = paramString1;
    localSessionInfo.b = paramString2;
    int i = localSessionInfo.jdField_a_of_type_Int;
    paramInt1 = 0;
    if ((i >= 0) && (!TextUtils.isEmpty(localSessionInfo.jdField_a_of_type_JavaLangString)))
    {
      this.jdField_a_of_type_AndroidOsBundle.keySet();
      paramString1 = this.jdField_a_of_type_AndroidOsBundle.getString("forward_ark_app_name");
      paramString2 = this.jdField_a_of_type_AndroidOsBundle.getString("forward_ark_app_view");
      localObject2 = this.jdField_a_of_type_AndroidOsBundle.getString("forward_ark_app_desc");
      str2 = this.jdField_a_of_type_AndroidOsBundle.getString("forward_ark_app_ver");
      String str3 = this.jdField_a_of_type_AndroidOsBundle.getString("forward_ark_app_prompt");
      String str4 = this.jdField_a_of_type_AndroidOsBundle.getString("forward_ark_app_meta");
      String str5 = this.jdField_a_of_type_AndroidOsBundle.getString("forward_ark_app_config");
      String str6 = this.jdField_a_of_type_AndroidOsBundle.getString("forward_ark_app_compat");
      localObject1 = this.jdField_a_of_type_AndroidOsBundle.getString("forward_ark_app_list");
      str1 = this.jdField_a_of_type_AndroidOsBundle.getString("forward_ark_app_text");
      if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
      {
        if (this.jdField_a_of_type_AndroidOsBundle.getBoolean("forward_ark_app_direct")) {
          ReportCenter.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "", "0", "2000", "2006", "0", false);
        }
        paramString2 = new ArkAppMessage(str3, paramString1, (String)localObject2, paramString2, str2, str4, str5, str6);
        if (!TextUtils.isEmpty(str1)) {
          paramString2.mText = str1;
        }
        if (TextUtils.isEmpty((CharSequence)localObject1)) {}
      }
    }
    try
    {
      localObject1 = new JSONArray((String)localObject1);
      i = ((JSONArray)localObject1).length();
      paramString2.mAppList = new ArrayList();
      while (paramInt1 < i)
      {
        str1 = ((JSONArray)localObject1).optString(paramInt1);
        if (!TextUtils.isEmpty(str1))
        {
          localObject2 = new ArkAppMessage();
          ((ArkAppMessage)localObject2).fromAppXml(str1);
          paramString2.mAppList.add(localObject2);
        }
        paramInt1 += 1;
      }
    }
    catch (Exception localException)
    {
      label358:
      break label358;
    }
    QLog.e("ForwardOption.ForwardBaseOption", 1, "appList error");
    Object localObject1 = (ArkAppMessage)ArkAppCenterCheckEvent.a(2, paramString1, this.jdField_a_of_type_AndroidOsBundle, paramString2);
    paramString1 = (String)localObject1;
    if (localObject1 == null) {
      paramString1 = paramString2;
    }
    paramString2 = this.jdField_a_of_type_AndroidOsBundle.getString("forward_appId_ark_from_sdk");
    localObject1 = this.jdField_a_of_type_AndroidOsBundle.getString("struct_share_key_source_name");
    String str1 = this.jdField_a_of_type_AndroidOsBundle.getString("struct_share_key_source_action_data");
    Object localObject2 = this.jdField_a_of_type_AndroidOsBundle.getString("struct_share_key_source_a_action_data");
    String str2 = this.jdField_a_of_type_AndroidOsBundle.getString("struct_share_key_source_url");
    if (!TextUtils.isEmpty(paramString2))
    {
      paramString1.appId = paramString2;
      paramString1.mSourceName = ((String)localObject1);
      paramString1.mSourceActionData = str1;
      paramString1.mSource_A_ActionData = ((String)localObject2);
      paramString1.mSourceUrl = str2;
    }
    i = this.jdField_a_of_type_AndroidOsBundle.getInt("KEY_MSG_FORWARD_ID");
    paramInt1 = i;
    if (i == 0)
    {
      paramString2 = this.jdField_a_of_type_AndroidOsBundle.getIntArray("KEY_MSG_FORWARD_ID_ARRAY");
      paramInt1 = i;
      if (paramString2 != null) {
        if (paramString2.length > paramInt2)
        {
          paramInt1 = paramString2[paramInt2];
        }
        else
        {
          ArkAppCenter.a("ArkApp", "ForwardArkMsgOption.sendArkMessage, forward array has not enough length");
          paramInt1 = i;
        }
      }
    }
    ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localSessionInfo, paramString1, paramInt1);
    return true;
    if (this.jdField_a_of_type_AndroidOsBundle.getBoolean("forward_ark_app_direct")) {
      ReportCenter.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "", "0", "2000", "2006", "1", false);
    }
    return false;
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
  
  public boolean b()
  {
    return true;
  }
  
  protected boolean c()
  {
    if (j())
    {
      List localList = b();
      int i = 0;
      while (i < localList.size())
      {
        ResultRecord localResultRecord = (ResultRecord)localList.get(i);
        a(localResultRecord.uin, localResultRecord.getUinType(), localResultRecord.groupUin, i);
        i += 1;
      }
      return super.c();
    }
    d();
    return super.c();
  }
  
  protected boolean d()
  {
    int i = this.jdField_a_of_type_AndroidOsBundle.getInt("uintype");
    return a(this.jdField_a_of_type_AndroidOsBundle.getString("uin"), i, this.jdField_a_of_type_AndroidOsBundle.getString("troop_uin"), 0);
  }
  
  public void e()
  {
    String str1 = this.jdField_a_of_type_AndroidOsBundle.getString("forward_ark_app_name");
    String str2 = this.jdField_a_of_type_AndroidOsBundle.getString("forward_ark_h5_from_js");
    String str3 = this.jdField_a_of_type_AndroidOsBundle.getString("forward_ark_app_view");
    if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2))) {
      ((IArkSecure)QRoute.api(IArkSecure.class)).checkShareUrl(str1, str3, str2, new ForwardArkMsgOption.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardArkMsgOption
 * JD-Core Version:    0.7.0.1
 */