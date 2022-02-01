package com.tencent.mobileqq.pushdialog;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.webviewplugin.NewReportPlugin;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class HttpMqqJumper
{
  private Context jdField_a_of_type_AndroidContentContext;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private String jdField_a_of_type_JavaLangString;
  
  public HttpMqqJumper(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public HttpMqqJumper(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private boolean a()
  {
    return (this.jdField_a_of_type_JavaLangString.toLowerCase().startsWith("http://")) || (this.jdField_a_of_type_JavaLangString.toLowerCase().startsWith("https://"));
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_AndroidContentContext != null)
    {
      Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
      if (localObject1 != null)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
          return;
        }
        localObject1 = ((SessionInfo)localObject1).jdField_a_of_type_JavaLangString;
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          return;
        }
        try
        {
          localObject2 = NewReportPlugin.b((String)localObject1, NewReportPlugin.b(2));
          if (QLog.isColorLevel())
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("openMoreOptions uin:");
            ((StringBuilder)localObject3).append((String)localObject1);
            ((StringBuilder)localObject3).append(" uinCode:");
            ((StringBuilder)localObject3).append((String)localObject2);
            QLog.i("HttpMqqJumper", 2, ((StringBuilder)localObject3).toString());
          }
          Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, -1L, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.e, false);
          Object localObject4 = new ArrayList();
          if (localObject3 != null) {
            ((List)localObject4).addAll((Collection)localObject3);
          }
          localObject3 = NewReportPlugin.a((String)localObject1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 25004, 10, (List)localObject4);
          localObject4 = ((String)localObject3).replaceAll((String)localObject1, (String)localObject2);
          Bundle localBundle = NewReportPlugin.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("openMoreOptions safetyReport reportMsgOrg: ");
            localStringBuilder.append((String)localObject3);
            localStringBuilder.append("  reportMsg: ");
            localStringBuilder.append((String)localObject4);
            QLog.i("HttpMqqJumper", 2, localStringBuilder.toString());
          }
          NewReportPlugin.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a, (String)localObject1, (String)localObject2, null, null, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 25004, (String)localObject4, localBundle);
          return;
        }
        catch (Throwable localThrowable)
        {
          Object localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("openMoreOptions safetyReport error");
          ((StringBuilder)localObject2).append(localThrowable.getMessage());
          QLog.e("HttpMqqJumper", 1, ((StringBuilder)localObject2).toString());
        }
      }
    }
  }
  
  private boolean b()
  {
    return this.jdField_a_of_type_JavaLangString.toLowerCase().startsWith("mqq://jubao.qq.com");
  }
  
  private boolean c()
  {
    return this.jdField_a_of_type_JavaLangString.toLowerCase().startsWith("mqq://");
  }
  
  public HttpMqqJumper a(SessionInfo paramSessionInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    return this;
  }
  
  public HttpMqqJumper a(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
    return this;
  }
  
  public HttpMqqJumper a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    return this;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidContentContext != null)
    {
      if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        return;
      }
      Object localObject = null;
      if (b())
      {
        this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString.replace("mqq://", "https://");
        b();
      }
      else if (a())
      {
        localObject = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
        ((Intent)localObject).putExtra("url", this.jdField_a_of_type_JavaLangString);
      }
      else if (c())
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        if (localObject != null)
        {
          localObject = JumpParser.a((BaseQQAppInterface)localObject, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString);
          if (localObject != null)
          {
            ((JumpAction)localObject).d();
            ((JumpAction)localObject).a();
          }
        }
        return;
      }
      if (localObject != null) {
        this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.pushdialog.HttpMqqJumper
 * JD-Core Version:    0.7.0.1
 */