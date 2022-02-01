package com.tencent.mobileqq.data;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.StrangerChatPie;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class KplHelper
{
  public static String a(QQAppInterface paramQQAppInterface)
  {
    Object localObject = paramQQAppInterface.getPreferences();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("key_kpl_nick_table");
    localStringBuilder.append(paramQQAppInterface.getCurrentAccountUin());
    localObject = ((SharedPreferences)localObject).getString(localStringBuilder.toString(), null);
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("getKplVerifyMsg uin=");
      localStringBuilder.append(paramQQAppInterface.getCurrentUin());
      localStringBuilder.append(" kpl_verify_msg=");
      localStringBuilder.append((String)localObject);
      QLog.d("KplHelper", 2, localStringBuilder.toString());
    }
    return localObject;
  }
  
  public static String a(QQAppInterface paramQQAppInterface, String paramString)
  {
    Object localObject2 = paramQQAppInterface.getPreferences();
    Object localObject1 = null;
    paramQQAppInterface = null;
    String str = ((SharedPreferences)localObject2).getString("key_kpl_nick_table", null);
    QQAppInterface localQQAppInterface;
    if (!TextUtils.isEmpty(str)) {
      try
      {
        localObject2 = new JSONObject(str).optString(paramString);
        paramQQAppInterface = (QQAppInterface)localObject2;
        localObject1 = localObject2;
        if (QLog.isColorLevel())
        {
          paramQQAppInterface = (QQAppInterface)localObject2;
          localObject1 = new StringBuilder();
          paramQQAppInterface = (QQAppInterface)localObject2;
          ((StringBuilder)localObject1).append("getGameNickByUin uin=");
          paramQQAppInterface = (QQAppInterface)localObject2;
          ((StringBuilder)localObject1).append(paramString);
          paramQQAppInterface = (QQAppInterface)localObject2;
          ((StringBuilder)localObject1).append(" kpl_nick=");
          paramQQAppInterface = (QQAppInterface)localObject2;
          ((StringBuilder)localObject1).append((String)localObject2);
          paramQQAppInterface = (QQAppInterface)localObject2;
          QLog.d("KplHelper", 2, ((StringBuilder)localObject1).toString());
          return localObject2;
        }
      }
      catch (JSONException localJSONException)
      {
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("catch exception when getGameNickByUin json=");
          ((StringBuilder)localObject2).append(str);
          ((StringBuilder)localObject2).append(" --uin=");
          ((StringBuilder)localObject2).append(paramString);
          QLog.d("KplMessage", 2, ((StringBuilder)localObject2).toString());
        }
        localJSONException.printStackTrace();
        localQQAppInterface = paramQQAppInterface;
      }
    }
    return localQQAppInterface;
  }
  
  public static void a(AppInterface paramAppInterface, String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      Object localObject = paramAppInterface.getPreferences().edit();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("key_kpl_nick_table");
      localStringBuilder.append(paramAppInterface.getCurrentAccountUin());
      ((SharedPreferences.Editor)localObject).putString(localStringBuilder.toString(), paramString).commit();
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("saveKplVerifyMsg uin=");
        ((StringBuilder)localObject).append(paramAppInterface.getCurrentUin());
        ((StringBuilder)localObject).append(" kpl_verify_msg=");
        ((StringBuilder)localObject).append(paramString);
        QLog.d("KplHelper", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  public static void a(AppInterface paramAppInterface, String paramString1, String paramString2)
  {
    SharedPreferences localSharedPreferences = paramAppInterface.getPreferences();
    Object localObject2 = localSharedPreferences.getString("key_kpl_nick_table", null);
    paramAppInterface = (AppInterface)localObject2;
    try
    {
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        paramAppInterface = (AppInterface)localObject2;
        localObject1 = new JSONObject((String)localObject2);
      }
      else
      {
        paramAppInterface = (AppInterface)localObject2;
        localObject1 = new JSONObject();
      }
      paramAppInterface = (AppInterface)localObject2;
      ((JSONObject)localObject1).put(paramString1, paramString2);
      paramAppInterface = (AppInterface)localObject2;
      localObject1 = ((JSONObject)localObject1).toString();
      paramAppInterface = (AppInterface)localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        break label240;
      }
      paramAppInterface = (AppInterface)localObject1;
      localSharedPreferences.edit().putString("key_kpl_nick_table", (String)localObject1).commit();
      paramAppInterface = (AppInterface)localObject1;
      if (!QLog.isColorLevel()) {
        break label240;
      }
      paramAppInterface = (AppInterface)localObject1;
      localObject2 = new StringBuilder();
      paramAppInterface = (AppInterface)localObject1;
      ((StringBuilder)localObject2).append("saveGameNickWithUin uin=");
      paramAppInterface = (AppInterface)localObject1;
      ((StringBuilder)localObject2).append(paramString1);
      paramAppInterface = (AppInterface)localObject1;
      ((StringBuilder)localObject2).append(" kpl_nick=");
      paramAppInterface = (AppInterface)localObject1;
      ((StringBuilder)localObject2).append(paramString2);
      paramAppInterface = (AppInterface)localObject1;
      QLog.d("KplHelper", 2, ((StringBuilder)localObject2).toString());
      return;
    }
    catch (Exception localException)
    {
      Object localObject1;
      label177:
      break label177;
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("catch exception when saveGameNickWithUin json=");
      ((StringBuilder)localObject1).append(paramAppInterface);
      ((StringBuilder)localObject1).append(" --uin=");
      ((StringBuilder)localObject1).append(paramString1);
      ((StringBuilder)localObject1).append(" --gameNick=");
      ((StringBuilder)localObject1).append(paramString2);
      QLog.d("KplMessage", 2, ((StringBuilder)localObject1).toString());
    }
    label240:
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("handleKplFlag json=");
        ((StringBuilder)localObject).append(paramString);
        QLog.d("KplHelper", 2, ((StringBuilder)localObject).toString());
      }
      paramQQAppInterface.getPreferences();
      try
      {
        paramString = new JSONObject(paramString);
        localObject = paramString.keys();
        if (QLog.isColorLevel()) {
          QLog.d("KplHelper", 2, "handleKplFlag info: ----------------");
        }
        while (((Iterator)localObject).hasNext())
        {
          String str = (String)((Iterator)localObject).next();
          a(paramQQAppInterface, str, paramString.optString(str));
        }
        if (QLog.isColorLevel())
        {
          QLog.d("KplHelper", 2, "------------------------------------");
          return;
        }
      }
      catch (Exception paramQQAppInterface)
      {
        if (QLog.isColorLevel()) {
          QLog.d("KplHelper", 2, "handleKplFlag catch an exception");
        }
        paramQQAppInterface.printStackTrace();
      }
    }
  }
  
  public static boolean a(BaseChatPie paramBaseChatPie)
  {
    Object localObject = StrangerChatPie.a(paramBaseChatPie.jdField_a_of_type_AndroidContentContext, paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, false, false);
    boolean bool = true;
    if (localObject == null) {
      if (paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1022)
      {
        localObject = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.a();
        FriendsManager localFriendsManager = (FriendsManager)paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
        if ((localObject != null) && (((List)localObject).size() > 0) && (!localFriendsManager.b(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(((ChatMessage)((List)localObject).get(((List)localObject).size() - 1)).getExtInfoFromExtStr("msg_ext_key")))) {}
      }
      else
      {
        bool = false;
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("isKplPie=");
      ((StringBuilder)localObject).append(bool);
      ((StringBuilder)localObject).append(" friendUin=");
      ((StringBuilder)localObject).append(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      QLog.d("KplMessage", 2, ((StringBuilder)localObject).toString());
    }
    return bool;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString, int paramInt)
  {
    paramContext = StrangerChatPie.a(paramContext, paramInt, false, false);
    boolean bool = true;
    if (paramContext == null)
    {
      paramContext = paramQQAppInterface.getMessageFacade().b(paramString, paramInt);
      paramQQAppInterface = (FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
      if ((paramContext == null) || (paramContext.size() <= 0) || (paramQQAppInterface.b(paramString)) || (TextUtils.isEmpty(((ChatMessage)paramContext.get(paramContext.size() - 1)).getExtInfoFromExtStr("msg_ext_key")))) {
        bool = false;
      }
    }
    if (QLog.isColorLevel())
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("isKplSession=");
      paramQQAppInterface.append(bool);
      paramQQAppInterface.append(" friendUin=");
      paramQQAppInterface.append(paramString);
      paramQQAppInterface.append(" sessionType=");
      paramQQAppInterface.append(paramInt);
      QLog.d("KplMessage", 2, paramQQAppInterface.toString());
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.data.KplHelper
 * JD-Core Version:    0.7.0.1
 */