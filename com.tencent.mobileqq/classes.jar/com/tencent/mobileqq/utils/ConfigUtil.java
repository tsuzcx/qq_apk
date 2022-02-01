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
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Content;
import com.tencent.mobileqq.olympic.utils.OlympicUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qqexpand.manager.IExpandManager;
import com.tencent.mobileqq.qqexpand.utils.IExpandSPUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.api.ISosoInterfaceApi;
import com.tencent.qphone.base.util.QLog;
import java.nio.charset.StandardCharsets;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

public class ConfigUtil
{
  public static ConfigurationService.Content a(PBRepeatMessageField<ConfigurationService.Content> paramPBRepeatMessageField)
  {
    int i = 0;
    Object localObject2 = (ConfigurationService.Content)paramPBRepeatMessageField.get(0);
    long l1;
    for (long l2 = 0L; i < paramPBRepeatMessageField.size(); l2 = l1)
    {
      Object localObject1 = a((ConfigurationService.Content)paramPBRepeatMessageField.get(i));
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject1 = localObject2;
        l1 = l2;
      }
      else
      {
        try
        {
          long l3 = new JSONObject((String)localObject1).optLong("time", 0L);
          if (l3 > l2)
          {
            try
            {
              localObject1 = (ConfigurationService.Content)paramPBRepeatMessageField.get(i);
              l1 = l3;
            }
            catch (JSONException localJSONException1)
            {
              l2 = l3;
              break label169;
            }
          }
          else
          {
            localObject1 = localObject2;
            l1 = l2;
            if (l3 != l2) {
              break label228;
            }
            localObject1 = localObject2;
            l1 = l2;
            if (((ConfigurationService.Content)paramPBRepeatMessageField.get(i)).task_id.get() <= ((ConfigurationService.Content)localObject2).task_id.get()) {
              break label228;
            }
            localObject1 = (ConfigurationService.Content)paramPBRepeatMessageField.get(i);
            l1 = l2;
          }
        }
        catch (JSONException localJSONException2)
        {
          label169:
          localObject1 = localObject2;
          l1 = l2;
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append(" getExpandConfig Throwable:");
            ((StringBuilder)localObject1).append(localJSONException2.getMessage());
            QLog.d("ConfigUtil", 2, ((StringBuilder)localObject1).toString());
            l1 = l2;
            localObject1 = localObject2;
          }
        }
      }
      label228:
      i += 1;
      localObject2 = localObject1;
    }
    if (QLog.isColorLevel())
    {
      paramPBRepeatMessageField = new StringBuilder();
      paramPBRepeatMessageField.append("getExpandConfig ");
      paramPBRepeatMessageField.append(((ConfigurationService.Content)localObject2).task_id.get());
      QLog.d("expand.config.ExpandConfigManager", 2, paramPBRepeatMessageField.toString());
    }
    return localObject2;
  }
  
  public static String a(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = FileUtils.readObject(String.format(Locale.getDefault(), "%s_%s_config_content", new Object[] { paramString1, paramString2 }));
    if (paramContext == null) {
      return null;
    }
    return (String)paramContext;
  }
  
  private static String a(ConfigurationService.Content paramContent)
  {
    if (paramContent == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ConfigUtil", 2, " handleConfig content is null !");
      }
      return "";
    }
    if (paramContent.compress.get() == 1)
    {
      paramContent = OlympicUtil.a(paramContent.content.get().toByteArray());
      if (paramContent == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ConfigUtil", 2, " handleConfig inflateConfigString error!");
        }
        return "";
      }
      try
      {
        paramContent = new String(paramContent, StandardCharsets.UTF_8);
        return paramContent;
      }
      catch (Throwable paramContent)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(" handleConfig Throwable:");
          localStringBuilder.append(paramContent.getMessage());
          QLog.d("ConfigUtil", 2, localStringBuilder.toString());
        }
        return "";
      }
    }
    return paramContent.content.get().toStringUtf8();
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    FileUtils.writeObject(String.format(Locale.getDefault(), "%s_%s_config_content", new Object[] { paramString1, paramString2 }), paramString3);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, CfgProcess.CfgParseResult paramCfgParseResult, int paramInt)
  {
    String str = paramQQAppInterface.getCurrentUin();
    if ("confess_config".equals(paramString))
    {
      if (paramQQAppInterface.isCreateManager(QQManagerFactory.CONFESS_MANAGER))
      {
        paramString = ((ConfessManager)paramQQAppInterface.getManager(QQManagerFactory.CONFESS_MANAGER)).a();
        paramCfgParseResult.jdField_b_of_type_Boolean = paramString.a(paramCfgParseResult.jdField_a_of_type_JavaLangString);
        ((ConfessHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.CONFESS_HANDLER)).a(paramQQAppInterface, paramString);
      }
      else
      {
        paramCfgParseResult.jdField_b_of_type_Boolean = ConfessConfig.b(paramCfgParseResult.jdField_a_of_type_JavaLangString);
      }
      paramCfgParseResult.jdField_a_of_type_Boolean = true;
      return;
    }
    Object localObject1;
    if ("extend_friend_config_785".equals(paramString))
    {
      paramCfgParseResult.jdField_a_of_type_Boolean = true;
      if (TextUtils.isEmpty(paramCfgParseResult.jdField_a_of_type_JavaLangString))
      {
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append("processExtendFriendConfig is emtpy !! configParseResult version:");
        paramQQAppInterface.append(paramCfgParseResult.jdField_b_of_type_Int);
        paramQQAppInterface.append(" localVersion ");
        paramQQAppInterface.append(paramCfgParseResult.jdField_a_of_type_Int);
        QLog.e("ConfigUtil", 2, paramQQAppInterface.toString());
        paramCfgParseResult.jdField_b_of_type_Boolean = false;
        return;
      }
      a(paramQQAppInterface.getApp(), str, paramString, paramCfgParseResult.jdField_a_of_type_JavaLangString);
      paramString = (IExpandSPUtils)QRoute.api(IExpandSPUtils.class);
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(paramInt);
      ((StringBuilder)localObject1).append("");
      paramString.setExtendFriendsConfigTaskId(str, ((StringBuilder)localObject1).toString());
      if (paramQQAppInterface.isCreateManager(QQManagerFactory.EXTEND_FRIEND_MANAGER)) {
        ((IExpandManager)paramQQAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER)).d(paramCfgParseResult.jdField_a_of_type_JavaLangString);
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
    Object localObject2;
    if ("register_invitation_config".equals(paramString))
    {
      try
      {
        localObject2 = new JSONObject(paramCfgParseResult.jdField_a_of_type_JavaLangString);
        paramString = ((JSONObject)localObject2).optString("entranceTitle");
        localObject1 = ((JSONObject)localObject2).optString("entranceSubtitle");
        localObject2 = ((JSONObject)localObject2).optString("entranceUrl");
        SharedPreUtils.b(paramQQAppInterface.getApp(), str, "register_invitation_sp_firstline", paramString);
        SharedPreUtils.b(paramQQAppInterface.getApp(), str, "register_invitation_sp_secondline", (String)localObject1);
        SharedPreUtils.b(paramQQAppInterface.getApp(), str, "register_invitation_sp_entry", (String)localObject2);
      }
      catch (Exception paramQQAppInterface)
      {
        if (QLog.isColorLevel()) {
          QLog.i("ConfigUtil", 2, paramQQAppInterface.getMessage(), paramQQAppInterface);
        }
      }
      catch (JSONException paramQQAppInterface)
      {
        if (QLog.isColorLevel()) {
          QLog.i("ConfigUtil", 2, paramQQAppInterface.getMessage(), paramQQAppInterface);
        }
      }
      paramCfgParseResult.jdField_a_of_type_Boolean = false;
      paramCfgParseResult.jdField_b_of_type_Boolean = true;
      return;
    }
    if ("account_logout_config".equals(paramString)) {}
    for (;;)
    {
      try
      {
        localObject2 = new JSONObject(paramCfgParseResult.jdField_a_of_type_JavaLangString);
        if (((JSONObject)localObject2).optInt("isShowEntrance") != 1) {
          break label695;
        }
        bool = true;
        paramString = ((JSONObject)localObject2).optString("webUrl");
        localObject1 = ((JSONObject)localObject2).optString("successText");
        localObject2 = ((JSONObject)localObject2).optString("boldText");
        SharedPreUtils.b(paramQQAppInterface.getApp(), str, "account_logout_url", paramString);
        SharedPreUtils.b(paramQQAppInterface.getApp(), str, "account_logout_entrance", bool);
        SharedPreUtils.b(paramQQAppInterface.getApp(), str, "account_logout_success_text", (String)localObject1);
        SharedPreUtils.b(paramQQAppInterface.getApp(), str, "account_logout_bold_text", (String)localObject2);
        if (QLog.isColorLevel()) {
          QLog.d("ConfigUtil", 2, String.format("update account logout config, showEntrance:%s, webUrl: %s, successText: %s, boldText: %s", new Object[] { Boolean.valueOf(bool), paramString, localObject1, localObject2 }));
        }
      }
      catch (Exception paramString)
      {
        QLog.e("ConfigUtil", 1, paramString.getMessage(), paramString);
        SharedPreUtils.b(paramQQAppInterface.getApp(), str, "account_logout_url", "");
        SharedPreUtils.b(paramQQAppInterface.getApp(), str, "account_logout_entrance", false);
        SharedPreUtils.b(paramQQAppInterface.getApp(), str, "account_logout_success_text", "");
        SharedPreUtils.b(paramQQAppInterface.getApp(), str, "account_logout_bold_text", "");
      }
      paramCfgParseResult.jdField_a_of_type_Boolean = false;
      paramCfgParseResult.jdField_b_of_type_Boolean = true;
      return;
      label695:
      boolean bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.utils.ConfigUtil
 * JD-Core Version:    0.7.0.1
 */