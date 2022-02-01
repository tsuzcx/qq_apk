package com.tencent.mobileqq.utils;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.confess.ConfessConfig;
import com.tencent.mobileqq.confess.ConfessHandler;
import com.tencent.mobileqq.confess.ConfessManager;
import com.tencent.mobileqq.config.CfgProcess.CfgParseResult;
import com.tencent.mobileqq.extendfriend.ExtendFriendManager;
import com.tencent.mobileqq.extendfriend.utils.ExpandSharePreUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.api.ISosoInterfaceApi;
import com.tencent.qphone.base.util.QLog;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

public class ConfigUtil
{
  public static String a(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = FileUtils.a(String.format(Locale.getDefault(), "%s_%s_config_content", new Object[] { paramString1, paramString2 }));
    if (paramContext == null) {
      return null;
    }
    return (String)paramContext;
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    FileUtils.a(String.format(Locale.getDefault(), "%s_%s_config_content", new Object[] { paramString1, paramString2 }), paramString3);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, CfgProcess.CfgParseResult paramCfgParseResult, int paramInt)
  {
    str1 = paramQQAppInterface.getCurrentUin();
    if ("confess_config".equals(paramString)) {
      if (paramQQAppInterface.isCreateManager(QQManagerFactory.CONFESS_MANAGER))
      {
        paramString = ((ConfessManager)paramQQAppInterface.getManager(QQManagerFactory.CONFESS_MANAGER)).a();
        paramCfgParseResult.jdField_b_of_type_Boolean = paramString.a(paramCfgParseResult.jdField_a_of_type_JavaLangString);
        ((ConfessHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.CONFESS_HANDLER)).a(paramQQAppInterface, paramString);
        paramCfgParseResult.jdField_a_of_type_Boolean = true;
      }
    }
    Object localObject;
    String str2;
    do
    {
      return;
      paramCfgParseResult.jdField_b_of_type_Boolean = ConfessConfig.b(paramCfgParseResult.jdField_a_of_type_JavaLangString);
      break;
      if ("extend_friend_config_785".equals(paramString))
      {
        paramCfgParseResult.jdField_a_of_type_Boolean = true;
        if (TextUtils.isEmpty(paramCfgParseResult.jdField_a_of_type_JavaLangString))
        {
          QLog.e("ConfigUtil", 2, "processExtendFriendConfig is emtpy !! configParseResult version:" + paramCfgParseResult.jdField_b_of_type_Int + " localVersion " + paramCfgParseResult.jdField_a_of_type_Int);
          paramCfgParseResult.jdField_b_of_type_Boolean = false;
          return;
        }
        a(paramQQAppInterface.getApp(), str1, paramString, paramCfgParseResult.jdField_a_of_type_JavaLangString);
        ExpandSharePreUtils.a(str1, paramInt + "");
        if (paramQQAppInterface.isCreateManager(QQManagerFactory.EXTEND_FRIEND_MANAGER)) {
          ((ExtendFriendManager)paramQQAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER)).b(paramCfgParseResult.jdField_a_of_type_JavaLangString);
        }
        paramCfgParseResult.jdField_b_of_type_Boolean = true;
        return;
      }
      if ("sosointerface_config".equals(paramString))
      {
        paramCfgParseResult.jdField_b_of_type_Boolean = ((ISosoInterfaceApi)QRoute.api(ISosoInterfaceApi.class)).saveSosoInterfaceConfig(paramCfgParseResult.jdField_a_of_type_JavaLangString);
        paramCfgParseResult.jdField_a_of_type_Boolean = true;
        return;
      }
      if ("register_invitation_config".equals(paramString)) {
        try
        {
          localObject = new JSONObject(paramCfgParseResult.jdField_a_of_type_JavaLangString);
          paramString = ((JSONObject)localObject).optString("entranceTitle");
          str2 = ((JSONObject)localObject).optString("entranceSubtitle");
          localObject = ((JSONObject)localObject).optString("entranceUrl");
          SharedPreUtils.b(paramQQAppInterface.getApp(), str1, "register_invitation_sp_firstline", paramString);
          SharedPreUtils.b(paramQQAppInterface.getApp(), str1, "register_invitation_sp_secondline", str2);
          SharedPreUtils.b(paramQQAppInterface.getApp(), str1, "register_invitation_sp_entry", (String)localObject);
          paramCfgParseResult.jdField_a_of_type_Boolean = false;
          paramCfgParseResult.jdField_b_of_type_Boolean = true;
          return;
        }
        catch (JSONException paramQQAppInterface)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.i("ConfigUtil", 2, paramQQAppInterface.getMessage(), paramQQAppInterface);
            }
          }
        }
        catch (Exception paramQQAppInterface)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.i("ConfigUtil", 2, paramQQAppInterface.getMessage(), paramQQAppInterface);
            }
          }
        }
      }
    } while (!"account_logout_config".equals(paramString));
    for (;;)
    {
      try
      {
        localObject = new JSONObject(paramCfgParseResult.jdField_a_of_type_JavaLangString);
        if (((JSONObject)localObject).optInt("isShowEntrance") != 1) {
          continue;
        }
        bool = true;
        paramString = ((JSONObject)localObject).optString("webUrl");
        str2 = ((JSONObject)localObject).optString("successText");
        localObject = ((JSONObject)localObject).optString("boldText");
        SharedPreUtils.b(paramQQAppInterface.getApp(), str1, "account_logout_url", paramString);
        SharedPreUtils.a(paramQQAppInterface.getApp(), str1, "account_logout_entrance", bool);
        SharedPreUtils.b(paramQQAppInterface.getApp(), str1, "account_logout_success_text", str2);
        SharedPreUtils.b(paramQQAppInterface.getApp(), str1, "account_logout_bold_text", (String)localObject);
        if (QLog.isColorLevel()) {
          QLog.d("ConfigUtil", 2, String.format("update account logout config, showEntrance:%s, webUrl: %s, successText: %s, boldText: %s", new Object[] { Boolean.valueOf(bool), paramString, str2, localObject }));
        }
      }
      catch (Exception paramString)
      {
        boolean bool;
        QLog.e("ConfigUtil", 1, paramString.getMessage(), paramString);
        SharedPreUtils.b(paramQQAppInterface.getApp(), str1, "account_logout_url", "");
        SharedPreUtils.a(paramQQAppInterface.getApp(), str1, "account_logout_entrance", false);
        SharedPreUtils.b(paramQQAppInterface.getApp(), str1, "account_logout_success_text", "");
        SharedPreUtils.b(paramQQAppInterface.getApp(), str1, "account_logout_bold_text", "");
        continue;
      }
      paramCfgParseResult.jdField_a_of_type_Boolean = false;
      paramCfgParseResult.jdField_b_of_type_Boolean = true;
      return;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.utils.ConfigUtil
 * JD-Core Version:    0.7.0.1
 */