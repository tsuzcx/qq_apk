package com.tencent.mobileqq.qwallet.hb.aio.impl;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.imcore.message.MsgProxyUtils;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.hb.aio.QQWalletBaseMsgElem;
import com.tencent.mobileqq.relation.api.IContactUtilsApi;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Set;
import mqq.app.AppRuntime;
import org.json.JSONObject;

public class QWalletRedPkgUtils
{
  public static int a(AppRuntime paramAppRuntime, BaseSessionInfo paramBaseSessionInfo)
  {
    int i = -1;
    if (paramAppRuntime != null)
    {
      if (paramBaseSessionInfo == null) {
        return -1;
      }
      i = paramBaseSessionInfo.jdField_a_of_type_Int;
      if (i != 0) {
        if (i != 1)
        {
          if (i != 1000)
          {
            if (i != 1001) {
              if (i != 1004)
              {
                if (i == 1008) {
                  break label105;
                }
                if (i != 3000)
                {
                  if ((i != 10002) && (i != 10004))
                  {
                    if ((i != 1024) && (i != 1025)) {
                      return -1;
                    }
                    return 58;
                  }
                }
                else {
                  return 2;
                }
              }
              else
              {
                return 4;
              }
            }
            return 6;
          }
          else
          {
            return 3;
          }
        }
        else {
          return 1;
        }
      }
      label105:
      i = 0;
    }
    return i;
  }
  
  public static Bundle a(BaseQQAppInterface paramBaseQQAppInterface, BaseSessionInfo paramBaseSessionInfo)
  {
    String str = ((IContactUtilsApi)QRoute.api(IContactUtilsApi.class)).getFriendName(paramBaseQQAppInterface.getCurrentAccountUin());
    int j = paramBaseSessionInfo.jdField_a_of_type_Int;
    int i = 1;
    if (j != 0)
    {
      paramBaseSessionInfo = str;
      if (j == 1) {
        break label220;
      }
      if (j != 1000)
      {
        if (j != 1001) {
          if (j != 1004)
          {
            if (j == 1008) {
              break label215;
            }
            if (j != 3000)
            {
              if ((j != 10002) && (j != 10004))
              {
                if ((j != 1024) && (j != 1025))
                {
                  i = -1;
                  paramBaseSessionInfo = str;
                  break label220;
                }
                i = 58;
                paramBaseSessionInfo = str;
                break label220;
              }
            }
            else
            {
              i = 2;
              paramBaseSessionInfo = ((IContactUtilsApi)QRoute.api(IContactUtilsApi.class)).getFriendName(paramBaseQQAppInterface.getCurrentAccountUin());
              break label220;
            }
          }
          else
          {
            i = 4;
            paramBaseSessionInfo = str;
            break label220;
          }
        }
        j = 6;
        str = ((IContactUtilsApi)QRoute.api(IContactUtilsApi.class)).getDateNickName(paramBaseQQAppInterface.getCurrentAccountUin());
        paramBaseSessionInfo = str;
        i = j;
        if (!TextUtils.isEmpty(str)) {
          break label220;
        }
        paramBaseSessionInfo = ((IContactUtilsApi)QRoute.api(IContactUtilsApi.class)).getFriendName(paramBaseQQAppInterface.getCurrentAccountUin());
        i = j;
        break label220;
      }
      else
      {
        i = 3;
        paramBaseSessionInfo = str;
        break label220;
      }
    }
    label215:
    i = 0;
    paramBaseSessionInfo = str;
    label220:
    paramBaseQQAppInterface = new Bundle();
    paramBaseQQAppInterface.putInt("groupType", i);
    paramBaseQQAppInterface.putString("name", paramBaseSessionInfo);
    return paramBaseQQAppInterface;
  }
  
  public static Bundle a(BaseQQAppInterface paramBaseQQAppInterface, BaseSessionInfo paramBaseSessionInfo, int paramInt)
  {
    String str = ((IContactUtilsApi)QRoute.api(IContactUtilsApi.class)).getFriendName(paramBaseQQAppInterface.getCurrentAccountUin());
    int i = 1;
    if (paramInt != 0)
    {
      paramBaseSessionInfo = str;
      if (paramInt == 1) {
        break label200;
      }
      if (paramInt != 1000)
      {
        if (paramInt != 1001) {
          if (paramInt != 1004)
          {
            if (paramInt == 1008) {
              break label195;
            }
            if (paramInt != 3000)
            {
              if ((paramInt != 10002) && (paramInt != 10004))
              {
                if ((paramInt != 1024) && (paramInt != 1025))
                {
                  i = -1;
                  paramBaseSessionInfo = str;
                  break label200;
                }
                i = 58;
                paramBaseSessionInfo = str;
                break label200;
              }
            }
            else
            {
              i = 2;
              paramBaseSessionInfo = str;
              break label200;
            }
          }
          else
          {
            i = 4;
            paramBaseSessionInfo = str;
            break label200;
          }
        }
        paramInt = 6;
        str = ((IContactUtilsApi)QRoute.api(IContactUtilsApi.class)).getDateNickName(paramBaseQQAppInterface.getCurrentAccountUin());
        i = paramInt;
        paramBaseSessionInfo = str;
        if (!TextUtils.isEmpty(str)) {
          break label200;
        }
        paramBaseSessionInfo = ((IContactUtilsApi)QRoute.api(IContactUtilsApi.class)).getFriendName(paramBaseQQAppInterface.getCurrentAccountUin());
        i = paramInt;
        break label200;
      }
      else
      {
        i = 3;
        paramBaseSessionInfo = str;
        break label200;
      }
    }
    label195:
    i = 0;
    paramBaseSessionInfo = str;
    label200:
    paramBaseQQAppInterface = new Bundle();
    paramBaseQQAppInterface.putInt("groupType", i);
    paramBaseQQAppInterface.putString("name", paramBaseSessionInfo);
    return paramBaseQQAppInterface;
  }
  
  public static JSONObject a(AppInterface paramAppInterface, BaseSessionInfo paramBaseSessionInfo, int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, int paramInt2, int paramInt3, int paramInt4)
  {
    return a(paramAppInterface, paramBaseSessionInfo, paramInt1, paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, paramInt2, paramInt3, "", 0, paramInt4, null);
  }
  
  public static JSONObject a(AppInterface paramAppInterface, BaseSessionInfo paramBaseSessionInfo, int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, int paramInt2, int paramInt3, String paramString8, int paramInt4, int paramInt5, Bundle paramBundle)
  {
    paramString1 = a(paramString2, paramString1, paramInt1, paramString3, paramString4, paramString7, paramBaseSessionInfo.b, paramInt2, paramInt3, paramInt4, paramString8, paramInt5, paramBundle, paramBaseSessionInfo.jdField_a_of_type_JavaLangString);
    if (paramBaseSessionInfo.jdField_a_of_type_Int == 1008)
    {
      paramBaseSessionInfo = new JSONObject();
      try
      {
        paramBaseSessionInfo.put("channel", 2);
        paramString1.put("detailinfo", paramBaseSessionInfo);
      }
      catch (Exception paramBaseSessionInfo)
      {
        if (QLog.isDevelopLevel()) {
          paramBaseSessionInfo.printStackTrace();
        }
      }
    }
    paramBaseSessionInfo = new JSONObject();
    try
    {
      paramBaseSessionInfo.put("userId", paramAppInterface.getCurrentAccountUin());
      paramBaseSessionInfo.put("viewTag", paramString6);
      paramBaseSessionInfo.put("app_info", paramString5);
      paramBaseSessionInfo.put("come_from", 2);
      paramBaseSessionInfo.put("extra_data", paramString1);
      return paramBaseSessionInfo;
    }
    catch (Exception paramAppInterface)
    {
      if (QLog.isDevelopLevel()) {
        paramAppInterface.printStackTrace();
      }
    }
    return paramBaseSessionInfo;
  }
  
  public static JSONObject a(AppInterface paramAppInterface, MessageForQQWalletMsg paramMessageForQQWalletMsg, QQWalletBaseMsgElem paramQQWalletBaseMsgElem, int paramInt1, BaseSessionInfo paramBaseSessionInfo, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    int m = 0;
    int i;
    int j;
    int k;
    if (paramQQWalletBaseMsgElem != null)
    {
      i = paramQQWalletBaseMsgElem.h;
      j = paramQQWalletBaseMsgElem.i;
      m = paramQQWalletBaseMsgElem.k;
      k = paramQQWalletBaseMsgElem.m;
    }
    else
    {
      k = 0;
      i = 0;
      j = 0;
    }
    paramQQWalletBaseMsgElem = a(paramString2, paramString1, paramInt2, paramString3, paramString4, paramString7, paramMessageForQQWalletMsg.senderuin, paramInt1, i, j, "", paramMessageForQQWalletMsg.fromHBList, null, paramBaseSessionInfo.jdField_a_of_type_JavaLangString);
    try
    {
      paramQQWalletBaseMsgElem.put("bigAnimId", m);
      paramQQWalletBaseMsgElem.put("hb_from", k);
      if (paramBaseSessionInfo.jdField_a_of_type_Int == 1008)
      {
        paramBaseSessionInfo = new JSONObject();
        paramBaseSessionInfo.put("channel", 2);
        paramQQWalletBaseMsgElem.put("detailinfo", paramBaseSessionInfo);
      }
    }
    catch (Exception paramBaseSessionInfo)
    {
      if (QLog.isDevelopLevel()) {
        paramBaseSessionInfo.printStackTrace();
      }
    }
    paramBaseSessionInfo = new JSONObject();
    try
    {
      paramBaseSessionInfo.put("userId", paramAppInterface.getCurrentAccountUin());
      paramBaseSessionInfo.put("viewTag", paramString6);
      paramBaseSessionInfo.put("app_info", paramString5);
      paramBaseSessionInfo.put("comeForm", 2);
      paramBaseSessionInfo.put("extra_data", paramQQWalletBaseMsgElem);
      paramBaseSessionInfo.put("senderuin", MsgProxyUtils.a(paramMessageForQQWalletMsg));
      return paramBaseSessionInfo;
    }
    catch (Exception paramAppInterface)
    {
      if (QLog.isDevelopLevel()) {
        paramAppInterface.printStackTrace();
      }
    }
    return paramBaseSessionInfo;
  }
  
  public static JSONObject a(String paramString1, String paramString2, int paramInt1, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt2, int paramInt3, int paramInt4, String paramString7, int paramInt5, Bundle paramBundle, String paramString8)
  {
    localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("listid", paramString1);
      localJSONObject.put("name", paramString2);
      paramString1 = new StringBuilder();
      paramString1.append(paramInt1);
      paramString1.append("");
      localJSONObject.put("grouptype", paramString1.toString());
      localJSONObject.put("groupid", paramString4);
      localJSONObject.put("channel", paramInt2);
      localJSONObject.put("resource_type", paramInt3);
      localJSONObject.put("skin_id", paramInt4);
      localJSONObject.put("fromHBList", paramInt5);
      if (paramString6 != null) {
        localJSONObject.put("groupuin", paramString6);
      }
      if (paramString3 != null) {
        localJSONObject.put("authkey", paramString3);
      }
      if (paramString5 != null) {
        localJSONObject.put("cftImageUrl", paramString5);
      }
      if (!TextUtils.isEmpty(paramString7)) {
        localJSONObject.put("voice_rate_id", paramString7);
      }
      if (!TextUtils.isEmpty(paramString8)) {
        localJSONObject.put("curFriendUin", paramString8);
      }
      if (paramBundle != null)
      {
        paramString1 = paramBundle.keySet();
        if (paramString1 != null)
        {
          paramString1 = paramString1.iterator();
          while (paramString1.hasNext())
          {
            paramString2 = (String)paramString1.next();
            localJSONObject.put(paramString2, paramBundle.get(paramString2));
          }
        }
      }
      return localJSONObject;
    }
    catch (Exception paramString1)
    {
      if (QLog.isDevelopLevel()) {
        paramString1.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.aio.impl.QWalletRedPkgUtils
 * JD-Core Version:    0.7.0.1
 */