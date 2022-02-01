package com.tencent.mobileqq.vashealth;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.api.IPublicAccountManager;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msg.api.IConversationFacade;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.mobileqq.vashealth.config.HealthConfigBean;
import com.tencent.mobileqq.vashealth.config.HealthConfigProcessor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.URLUtil;
import org.json.JSONException;
import org.json.JSONObject;

public class VSHealthUtil
{
  private static String a(BaseQQAppInterface paramBaseQQAppInterface)
  {
    if (paramBaseQQAppInterface == null) {
      return null;
    }
    Object localObject = (IConversationFacade)paramBaseQQAppInterface.getRuntimeService(IConversationFacade.class, "multi");
    if ((localObject != null) && (((IConversationFacade)localObject).getUnreadCount("3026775809", 1008) > 0))
    {
      paramBaseQQAppInterface = ((IMessageFacade)paramBaseQQAppInterface.getRuntimeService(IMessageFacade.class, "multi")).getLastMessage("3026775809", 1008);
      if ((paramBaseQQAppInterface != null) && (paramBaseQQAppInterface.mExJsonObject != null))
      {
        paramBaseQQAppInterface = paramBaseQQAppInterface.mExJsonObject.optString("report_key_bytes_oac_msg_extend", "");
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[redirectAIOToMainPage] bytes_oac_msg_extend: ");
        ((StringBuilder)localObject).append(paramBaseQQAppInterface);
        QLog.d("VSHealthUtil", 1, ((StringBuilder)localObject).toString());
        if (paramBaseQQAppInterface != null) {
          try
          {
            paramBaseQQAppInterface = new JSONObject(paramBaseQQAppInterface).optString("sports_extra");
            if (!TextUtils.isEmpty(paramBaseQQAppInterface))
            {
              paramBaseQQAppInterface = new JSONObject(paramBaseQQAppInterface).optString("h5_url");
              boolean bool = TextUtils.isEmpty(paramBaseQQAppInterface);
              if (!bool) {
                return paramBaseQQAppInterface;
              }
            }
          }
          catch (JSONException paramBaseQQAppInterface)
          {
            paramBaseQQAppInterface.printStackTrace();
          }
        }
      }
    }
    return null;
  }
  
  public static boolean a(Context paramContext, BaseQQAppInterface paramBaseQQAppInterface, String paramString, int paramInt)
  {
    if ((paramContext != null) && (paramBaseQQAppInterface != null))
    {
      paramString = HealthConfigProcessor.a().a();
      Object localObject = a(paramBaseQQAppInterface);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[redirectAIOToMainPage] healthMainPageJumpUrl: ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", msgJumpUrl: ");
      localStringBuilder.append((String)localObject);
      QLog.d("VSHealthUtil", 1, localStringBuilder.toString());
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        paramString = (String)localObject;
      }
      if (TextUtils.isEmpty(paramString))
      {
        QLog.e("VSHealthUtil", 1, "[redirectAIOToMainPage] error! targetJumpUrl is null!");
        return false;
      }
      localObject = JumpParser.a(paramBaseQQAppInterface, paramContext, paramString);
      if (localObject != null)
      {
        ((JumpAction)localObject).a();
      }
      else
      {
        paramString = URLUtil.a(URLUtil.a(URLUtil.a(URLUtil.a(paramString, "uin", paramBaseQQAppInterface.getCurrentUin()), "puin", "3026775809"), "isHealthPublicAccountMainPage", "1"), "sourceFrom", String.valueOf(paramInt));
        ((IPublicAccountManager)QRoute.api(IPublicAccountManager.class)).handleUrlEvent(paramContext, paramBaseQQAppInterface, paramString, "3026775809", null);
      }
      paramContext = (IConversationFacade)paramBaseQQAppInterface.getRuntimeService(IConversationFacade.class, "multi");
      if (paramContext != null) {
        paramContext.cleanUnread("3026775809", 1008, paramContext.getLastRead("3026775809", 1008), true);
      }
      return true;
    }
    paramBaseQQAppInterface = new StringBuilder();
    paramBaseQQAppInterface.append("[redirectAIOToMainPage] error! context: ");
    boolean bool;
    if (paramContext == null) {
      bool = true;
    } else {
      bool = false;
    }
    paramBaseQQAppInterface.append(bool);
    paramBaseQQAppInterface.append(", app: ");
    if (paramContext == null) {
      bool = true;
    } else {
      bool = false;
    }
    paramBaseQQAppInterface.append(bool);
    QLog.e("VSHealthUtil", 1, paramBaseQQAppInterface.toString());
    return false;
  }
  
  public static boolean a(String paramString)
  {
    if (b(paramString)) {
      return HealthConfigProcessor.a().a();
    }
    return false;
  }
  
  public static boolean b(String paramString)
  {
    return TextUtils.equals("3026775809", paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vashealth.VSHealthUtil
 * JD-Core Version:    0.7.0.1
 */