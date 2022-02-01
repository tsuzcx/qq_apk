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
  
  public static boolean a(Context paramContext, BaseQQAppInterface paramBaseQQAppInterface, int paramInt)
  {
    if ((paramContext != null) && (paramBaseQQAppInterface != null))
    {
      localObject1 = HealthConfigProcessor.a().b();
      Object localObject2 = a(paramBaseQQAppInterface);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[redirectAIOToMainPage] healthMainPageJumpUrl: ");
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append(", msgJumpUrl: ");
      localStringBuilder.append((String)localObject2);
      QLog.d("VSHealthUtil", 1, localStringBuilder.toString());
      if (paramInt != 164)
      {
        if (paramInt != 165)
        {
          if (!TextUtils.isEmpty((CharSequence)localObject2)) {
            localObject1 = localObject2;
          }
        }
        else {
          localObject1 = HealthConfigProcessor.a().e();
        }
      }
      else {
        localObject1 = HealthConfigProcessor.a().c();
      }
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        QLog.e("VSHealthUtil", 1, "[redirectAIOToMainPage] error! targetJumpUrl is null!");
        return false;
      }
      localObject2 = JumpParser.a(paramBaseQQAppInterface, paramContext, (String)localObject1);
      if (localObject2 != null) {
        ((JumpAction)localObject2).a();
      } else {
        ((IPublicAccountManager)QRoute.api(IPublicAccountManager.class)).handleUrlEvent(paramContext, paramBaseQQAppInterface, (String)localObject1, "3026775809", null);
      }
      paramContext = (IConversationFacade)paramBaseQQAppInterface.getRuntimeService(IConversationFacade.class, "multi");
      if (paramContext != null) {
        paramContext.cleanUnread("3026775809", 1008, paramContext.getLastRead("3026775809", 1008), true);
      }
      return true;
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("[redirectAIOToMainPage] error! context: ");
    boolean bool;
    if (paramContext == null) {
      bool = true;
    } else {
      bool = false;
    }
    ((StringBuilder)localObject1).append(bool);
    ((StringBuilder)localObject1).append(", app: ");
    if (paramBaseQQAppInterface == null) {
      bool = true;
    } else {
      bool = false;
    }
    ((StringBuilder)localObject1).append(bool);
    QLog.e("VSHealthUtil", 1, ((StringBuilder)localObject1).toString());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vashealth.VSHealthUtil
 * JD-Core Version:    0.7.0.1
 */