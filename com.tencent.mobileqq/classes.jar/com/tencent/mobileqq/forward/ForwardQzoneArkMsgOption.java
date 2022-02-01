package com.tencent.mobileqq.forward;

import aean;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import aqbu;
import auxr;
import auxu;
import bcpt;
import bcry;
import bdow;
import bhjx;
import bhpc;
import bjqh;
import com.tencent.ark.open.ArkAppCacheMgr;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import nok;

public class ForwardQzoneArkMsgOption
  extends auxu
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
      if ((localRecentUser != null) && (!bhjx.a(localRecentUser.uin)) && (localRecentUser.getType() != 1008) && (localRecentUser.getType() != 1005) && ((localRecentUser.getType() != 1006) || (a(auxr.h))) && (localRecentUser.getType() != 1009) && (localRecentUser.getType() != 1021) && (localRecentUser.getType() != 10004) && (localRecentUser.getType() != 7000) && (localRecentUser.getType() != 6004) && (localRecentUser.getType() != 9501) && ((localRecentUser.getType() != 0) || (!nok.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localRecentUser.uin, localRecentUser.getType())))) {
        localArrayList.add(localRecentUser);
      }
    }
    return localArrayList;
  }
  
  public void a()
  {
    if (m()) {
      this.jdField_a_of_type_JavaUtilSet.add(d);
    }
    if (n()) {
      this.jdField_a_of_type_JavaUtilSet.add(c);
    }
    if (o()) {
      this.jdField_a_of_type_JavaUtilSet.add(b);
    }
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
  
  public boolean a(bhpc parambhpc)
  {
    if (!this.jdField_a_of_type_AndroidOsBundle.getBoolean("is_ark_display_share")) {
      super.a(parambhpc);
    }
    return true;
  }
  
  protected boolean a(String paramString1, int paramInt, String paramString2)
  {
    SessionInfo localSessionInfo = new SessionInfo();
    localSessionInfo.jdField_a_of_type_Int = paramInt;
    localSessionInfo.jdField_a_of_type_JavaLangString = paramString1;
    localSessionInfo.b = paramString2;
    if ((localSessionInfo.jdField_a_of_type_Int < 0) || (TextUtils.isEmpty(localSessionInfo.jdField_a_of_type_JavaLangString)))
    {
      if (this.jdField_a_of_type_AndroidOsBundle.getBoolean("forward_ark_app_direct")) {
        bjqh.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "", "0", "2000", "2006", "1", false);
      }
      return false;
    }
    Object localObject1 = this.jdField_a_of_type_AndroidOsBundle.getString("forward_ark_app_name");
    Object localObject2 = this.jdField_a_of_type_AndroidOsBundle.getString("forward_ark_app_view");
    String str1 = this.jdField_a_of_type_AndroidOsBundle.getString("forward_ark_app_meta");
    String str2 = this.jdField_a_of_type_AndroidOsBundle.getString("forward_ark_app_config");
    String str3 = this.jdField_a_of_type_AndroidOsBundle.getString("forward_ark_app_prompt");
    paramString2 = ArkAppCacheMgr.getApplicationFromManifest((String)localObject1, "0.0.0.1");
    paramString1 = null;
    if (paramString2 != null) {
      if (paramString2.containsKey("desc"))
      {
        paramString1 = (String)paramString2.get("desc");
        if (!paramString2.containsKey("version")) {
          break label269;
        }
        paramString2 = (String)paramString2.get("version");
      }
    }
    for (;;)
    {
      label199:
      if (TextUtils.isEmpty(paramString1)) {
        paramString1 = (String)localObject1;
      }
      for (;;)
      {
        if ((TextUtils.isEmpty((CharSequence)localObject1)) || (TextUtils.isEmpty((CharSequence)localObject2)))
        {
          if (this.jdField_a_of_type_AndroidOsBundle.getBoolean("forward_ark_app_direct")) {
            bjqh.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "", "0", "2000", "2006", "1", false);
          }
          return false;
          paramString1 = "";
          break;
          label269:
          paramString2 = "0.0.0.1";
          break label199;
        }
        if (this.jdField_a_of_type_AndroidOsBundle.getBoolean("forward_ark_app_direct")) {
          bjqh.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "", "0", "2000", "2006", "0", false);
        }
        paramString1 = new ArkAppMessage(str3, (String)localObject1, paramString1, (String)localObject2, paramString2, str1, str2, "");
        paramString2 = (ArkAppMessage)aqbu.a(2, (String)localObject1, this.jdField_a_of_type_AndroidOsBundle, paramString1);
        if (paramString2 == null) {}
        for (;;)
        {
          localObject1 = bdow.a(this.jdField_a_of_type_AndroidOsBundle);
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
          if (localObject1 != null) {
            switch (localSessionInfo.jdField_a_of_type_Int)
            {
            }
          }
          for (paramString2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();; paramString2 = localSessionInfo.b)
          {
            localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
            str1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
            str2 = localSessionInfo.jdField_a_of_type_JavaLangString;
            paramInt = localSessionInfo.jdField_a_of_type_Int;
            int i = bcpt.jdField_a_of_type_Int;
            bcpt.jdField_a_of_type_Int = i + 1;
            paramString1.containStructMsg = bcry.a((QQAppInterface)localObject2, str1, str2, paramString2, paramInt, i, (AbsStructMsg)localObject1);
            paramInt = this.jdField_a_of_type_AndroidOsBundle.getInt("KEY_MSG_FORWARD_ID");
            aean.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localSessionInfo, paramString1, paramInt);
            return true;
          }
          paramString1 = paramString2;
        }
      }
      paramString2 = "0.0.0.1";
    }
  }
  
  public boolean c()
  {
    if (g())
    {
      Iterator localIterator = b().iterator();
      while (localIterator.hasNext())
      {
        ResultRecord localResultRecord = (ResultRecord)localIterator.next();
        a(localResultRecord.jdField_a_of_type_JavaLangString, localResultRecord.a(), localResultRecord.c);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardQzoneArkMsgOption
 * JD-Core Version:    0.7.0.1
 */