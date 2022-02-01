package com.tencent.mobileqq.data;

import aezn;
import ahkz;
import amsw;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0xa28.oidb_0xa28.RoleInfo;

public class KplRoleInfo
  extends Entity
{
  public static final String KPL_TAG = "KplMessage";
  public static final String MSG_EXT_KEY = "msg_ext_key";
  public String roleName;
  public String roleScore;
  public String roleUrl;
  
  public static String getGameNickByUin(QQAppInterface paramQQAppInterface, String paramString)
  {
    Object localObject = null;
    String str1 = null;
    String str2 = paramQQAppInterface.getPreferences().getString("key_kpl_nick_table", null);
    paramQQAppInterface = str1;
    if (!TextUtils.isEmpty(str2)) {}
    try
    {
      str1 = new JSONObject(str2).optString(paramString);
      paramQQAppInterface = str1;
      localObject = str1;
      if (QLog.isColorLevel())
      {
        localObject = str1;
        QLog.d("KplMessage", 2, "getGameNickByUin uin=" + paramString + " kpl_nick=" + str1);
        paramQQAppInterface = str1;
      }
      return paramQQAppInterface;
    }
    catch (JSONException paramQQAppInterface)
    {
      if (QLog.isColorLevel()) {
        QLog.d("KplMessage", 2, "catch exception when getGameNickByUin json=" + str2 + " --uin=" + paramString);
      }
      paramQQAppInterface.printStackTrace();
    }
    return localObject;
  }
  
  public static String getKplVerifyMsg(QQAppInterface paramQQAppInterface)
  {
    String str = paramQQAppInterface.getPreferences().getString("key_kpl_nick_table" + paramQQAppInterface.getCurrentAccountUin(), null);
    if (QLog.isColorLevel()) {
      QLog.d("KplMessage", 2, "getKplVerifyMsg uin=" + paramQQAppInterface.getCurrentUin() + " kpl_verify_msg=" + str);
    }
    return str;
  }
  
  public static void handleKplFlag(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.d("KplMessage", 2, "handleKplFlag json=" + paramString);
      }
      paramQQAppInterface.getPreferences();
      try
      {
        paramString = new JSONObject(paramString);
        Iterator localIterator = paramString.keys();
        if (QLog.isColorLevel()) {
          QLog.d("KplMessage", 2, "handleKplFlag info: ----------------");
        }
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          saveGameNickWithUin(paramQQAppInterface, str, paramString.optString(str));
          continue;
          return;
        }
      }
      catch (Exception paramQQAppInterface)
      {
        if (QLog.isColorLevel()) {
          QLog.d("KplMessage", 2, "handleKplFlag catch an exception");
        }
        paramQQAppInterface.printStackTrace();
      }
    }
    while (!QLog.isColorLevel()) {}
    QLog.d("KplMessage", 2, "------------------------------------");
  }
  
  public static boolean isKplPie(BaseChatPie paramBaseChatPie)
  {
    boolean bool;
    if (ahkz.a(paramBaseChatPie.mContext, paramBaseChatPie.sessionInfo.curType, false, false) != null) {
      bool = true;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("KplMessage", 2, "isKplPie=" + bool + " friendUin=" + paramBaseChatPie.sessionInfo.curFriendUin);
      }
      return bool;
      if (paramBaseChatPie.sessionInfo.curType == 1022)
      {
        List localList = paramBaseChatPie.listAdapter.a();
        amsw localamsw = (amsw)paramBaseChatPie.app.getManager(51);
        if ((localList != null) && (localList.size() > 0) && (!localamsw.b(paramBaseChatPie.sessionInfo.curFriendUin)) && (!TextUtils.isEmpty(((ChatMessage)localList.get(localList.size() - 1)).getExtInfoFromExtStr("msg_ext_key"))))
        {
          bool = true;
          continue;
        }
      }
      bool = false;
    }
  }
  
  public static boolean isKplSession(QQAppInterface paramQQAppInterface, Context paramContext, String paramString, int paramInt)
  {
    boolean bool;
    if (ahkz.a(paramContext, paramInt, false, false) != null) {
      bool = true;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("KplMessage", 2, "isKplSession=" + bool + " friendUin=" + paramString + " sessionType=" + paramInt);
      }
      return bool;
      paramContext = paramQQAppInterface.getMessageFacade().getAIOList(paramString, paramInt);
      paramQQAppInterface = (amsw)paramQQAppInterface.getManager(51);
      if ((paramContext != null) && (paramContext.size() > 0) && (!paramQQAppInterface.b(paramString)) && (!TextUtils.isEmpty(((ChatMessage)paramContext.get(paramContext.size() - 1)).getExtInfoFromExtStr("msg_ext_key")))) {
        bool = true;
      } else {
        bool = false;
      }
    }
  }
  
  public static KplRoleInfo parseJsonString(String paramString)
  {
    KplRoleInfo localKplRoleInfo = new KplRoleInfo();
    try
    {
      paramString = new JSONObject(paramString);
      localKplRoleInfo.roleName = paramString.optString("roleName");
      localKplRoleInfo.roleScore = paramString.optString("roleScore");
      localKplRoleInfo.roleUrl = paramString.optString("roleUrl");
      return localKplRoleInfo;
    }
    catch (Exception paramString)
    {
      QLog.e("KplRoleInfo", 1, "parseJsonString exception:");
      paramString.printStackTrace();
    }
    return null;
  }
  
  public static KplRoleInfo parseProtoResp(oidb_0xa28.RoleInfo paramRoleInfo)
  {
    KplRoleInfo localKplRoleInfo = new KplRoleInfo();
    localKplRoleInfo.roleName = paramRoleInfo.bytes_role_name.get().toStringUtf8();
    localKplRoleInfo.roleScore = paramRoleInfo.bytes_role_score.get().toStringUtf8();
    localKplRoleInfo.roleUrl = paramRoleInfo.str_role_url.get();
    return localKplRoleInfo;
  }
  
  public static void saveGameNickWithUin(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    SharedPreferences localSharedPreferences = paramQQAppInterface.getPreferences();
    String str = localSharedPreferences.getString("key_kpl_nick_table", null);
    paramQQAppInterface = str;
    try
    {
      if (!TextUtils.isEmpty(str)) {
        paramQQAppInterface = str;
      }
      for (Object localObject = new JSONObject(str);; localObject = new JSONObject())
      {
        paramQQAppInterface = str;
        ((JSONObject)localObject).put(paramString1, paramString2);
        paramQQAppInterface = str;
        localObject = ((JSONObject)localObject).toString();
        paramQQAppInterface = (QQAppInterface)localObject;
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          break;
        }
        paramQQAppInterface = (QQAppInterface)localObject;
        localSharedPreferences.edit().putString("key_kpl_nick_table", (String)localObject).commit();
        paramQQAppInterface = (QQAppInterface)localObject;
        if (!QLog.isColorLevel()) {
          break;
        }
        paramQQAppInterface = (QQAppInterface)localObject;
        QLog.d("KplMessage", 2, "saveGameNickWithUin uin=" + paramString1 + " kpl_nick=" + paramString2);
        return;
        paramQQAppInterface = str;
      }
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("KplMessage", 2, "catch exception when saveGameNickWithUin json=" + paramQQAppInterface + " --uin=" + paramString1 + " --gameNick=" + paramString2);
      }
    }
  }
  
  public static void saveKplVerifyMsg(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      paramQQAppInterface.getPreferences().edit().putString("key_kpl_nick_table" + paramQQAppInterface.getCurrentAccountUin(), paramString).commit();
      if (QLog.isColorLevel()) {
        QLog.d("KplMessage", 2, "saveKplVerifyMsg uin=" + paramQQAppInterface.getCurrentUin() + " kpl_verify_msg=" + paramString);
      }
    }
  }
  
  public String toJsonString()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("roleName", this.roleName);
      localJSONObject.put("roleScore", this.roleScore);
      localJSONObject.put("roleUrl", this.roleUrl);
      return localJSONObject.toString();
    }
    catch (Exception localException)
    {
      QLog.e("KplRoleInfo", 1, "toJsonString exception:");
      localException.printStackTrace();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.KplRoleInfo
 * JD-Core Version:    0.7.0.1
 */