package com.tencent.mobileqq.qassistant.config;

import android.content.Context;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qassistant.api.IQAssistantTempApi;
import com.tencent.mobileqq.qassistant.api.IVoiceAssistantMain;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class QAssistantConfigItem
{
  public String a;
  public HashMap<String, String> a;
  public boolean a;
  public String b;
  public String c;
  public String d;
  public String e;
  public String f;
  public String g = null;
  
  public QAssistantConfigItem()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public static boolean a()
  {
    return false;
  }
  
  protected void a(BaseQQAppInterface paramBaseQQAppInterface, Context paramContext) {}
  
  protected void a(JumpAction paramJumpAction, BaseQQAppInterface paramBaseQQAppInterface, Context paramContext) {}
  
  public boolean a(BaseQQAppInterface paramBaseQQAppInterface, Context paramContext)
  {
    if ((paramBaseQQAppInterface != null) && (paramContext != null))
    {
      QLog.d("QAssistantConfigItem", 1, "mqqaudioassistant RealJump start");
      a(paramBaseQQAppInterface, paramContext);
      if (!b(paramBaseQQAppInterface, paramContext))
      {
        ((IVoiceAssistantMain)QRoute.api(IVoiceAssistantMain.class)).reportQAssistantJumpMonitor(this.g, this.f, 3);
        QLog.d("QAssistantConfigItem", 1, "mqqaudioassistant checkIsSupportJump is false");
        return false;
      }
      if ((StringUtil.a(this.b)) && (StringUtil.a(this.c)))
      {
        ((IVoiceAssistantMain)QRoute.api(IVoiceAssistantMain.class)).reportQAssistantJumpMonitor(this.g, this.f, 100);
        return false;
      }
      Object localObject1;
      if (!StringUtil.a(this.b))
      {
        localObject2 = JumpParser.a(paramBaseQQAppInterface, paramContext, this.b);
        localObject1 = localObject2;
        if (localObject2 != null)
        {
          localObject1 = localObject2;
          if (!StringUtil.a(this.e))
          {
            localObject1 = localObject2;
            if (!StringUtil.a(this.e))
            {
              ((JumpAction)localObject2).c(this.e);
              localObject1 = localObject2;
            }
          }
        }
      }
      else
      {
        localObject2 = ((IQAssistantTempApi)QRoute.api(IQAssistantTempApi.class)).createJumpAction(paramContext);
        localObject1 = localObject2;
        if (localObject2 != null)
        {
          ((JumpAction)localObject2).b = this.c;
          if ((!StringUtil.a(this.d)) && (!StringUtil.a(this.d))) {
            ((JumpAction)localObject2).c = this.d;
          }
          localObject1 = localObject2;
          if (!this.jdField_a_of_type_JavaUtilHashMap.isEmpty())
          {
            ((JumpAction)localObject2).a(this.jdField_a_of_type_JavaUtilHashMap);
            localObject1 = localObject2;
          }
        }
      }
      if (localObject1 == null)
      {
        ((IVoiceAssistantMain)QRoute.api(IVoiceAssistantMain.class)).reportQAssistantJumpMonitor(this.g, this.f, 102);
        return false;
      }
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("mqqaudioassistant RealJump ready Jump server = ");
      ((StringBuilder)localObject2).append(this.c);
      QLog.d("QAssistantConfigItem", 1, ((StringBuilder)localObject2).toString());
      a(localObject1, paramBaseQQAppInterface, paramContext);
      if (localObject1.a())
      {
        ((IVoiceAssistantMain)QRoute.api(IVoiceAssistantMain.class)).reportQAssistantJumpMonitor(this.g, this.f, 0);
        ((IVoiceAssistantMain)QRoute.api(IVoiceAssistantMain.class)).reportQAssistantJump(this.f);
        return true;
      }
      ((IVoiceAssistantMain)QRoute.api(IVoiceAssistantMain.class)).reportQAssistantJumpMonitor(this.g, this.f, 103);
      return true;
    }
    ((IVoiceAssistantMain)QRoute.api(IVoiceAssistantMain.class)).reportQAssistantJumpMonitor(this.g, this.f, 100);
    return false;
  }
  
  public boolean a(QBaseActivity paramQBaseActivity)
  {
    return a(paramQBaseActivity, a());
  }
  
  public boolean a(QBaseActivity paramQBaseActivity, boolean paramBoolean)
  {
    if (paramQBaseActivity == null)
    {
      ((IVoiceAssistantMain)QRoute.api(IVoiceAssistantMain.class)).reportQAssistantJumpMonitor(this.g, this.f, 100);
      return false;
    }
    ActivityURIRequest localActivityURIRequest = new ActivityURIRequest(paramQBaseActivity, "/base/start/splash");
    if (!paramBoolean) {
      ((IQAssistantTempApi)QRoute.api(IQAssistantTempApi.class)).extendJumpIntentExtra1(localActivityURIRequest.extra());
    }
    localActivityURIRequest.setFlags(67108864);
    ((IVoiceAssistantMain)QRoute.api(IVoiceAssistantMain.class)).writeToActivityRequest(this, paramBoolean, localActivityURIRequest);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("QAssistantConfigItem.Jump item_server = ");
    localStringBuilder.append(this.c);
    localStringBuilder.append("|");
    localStringBuilder.append(paramQBaseActivity.getClass().toString());
    QLog.d("QAssistantConfigItem", 1, localStringBuilder.toString());
    QRoute.startUri(localActivityURIRequest, null);
    return true;
  }
  
  protected boolean b(BaseQQAppInterface paramBaseQQAppInterface, Context paramContext)
  {
    paramBaseQQAppInterface = (IQAssistantTempApi)QRoute.api(IQAssistantTempApi.class);
    if (paramBaseQQAppInterface != null) {
      return paramBaseQQAppInterface.checkIsSupportJump(paramContext, this.f);
    }
    return true;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{\"strName\":\"");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append("\", \"strScheme\":\"");
    localStringBuilder.append(this.b);
    localStringBuilder.append("\", \"strServer\":\"");
    localStringBuilder.append(this.c);
    localStringBuilder.append("\", \"strAction\":\"");
    localStringBuilder.append(this.d);
    localStringBuilder.append("\", \"strPackage\":\"");
    localStringBuilder.append(this.e);
    localStringBuilder.append("\", \"isOpenEnable\":");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append(", \"openAction\":\"");
    localStringBuilder.append(this.f);
    localStringBuilder.append("\", \"host\":\"");
    localStringBuilder.append(this.g);
    localStringBuilder.append("\", \"attributes\":");
    localStringBuilder.append(this.jdField_a_of_type_JavaUtilHashMap);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.config.QAssistantConfigItem
 * JD-Core Version:    0.7.0.1
 */