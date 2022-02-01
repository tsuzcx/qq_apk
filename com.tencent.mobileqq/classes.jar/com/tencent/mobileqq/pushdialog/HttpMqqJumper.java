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
  private String a;
  private Context b;
  private SessionInfo c;
  private QQAppInterface d;
  private BaseChatPie e;
  
  public HttpMqqJumper(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public HttpMqqJumper(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    this.b = paramContext;
    this.d = paramQQAppInterface;
  }
  
  private void b()
  {
    if (this.b != null)
    {
      Object localObject1 = this.c;
      if (localObject1 != null)
      {
        if (this.d == null) {
          return;
        }
        localObject1 = ((SessionInfo)localObject1).b;
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          return;
        }
        try
        {
          localObject2 = NewReportPlugin.b((String)localObject1, NewReportPlugin.c(2));
          if (QLog.isColorLevel())
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("openMoreOptions uin:");
            ((StringBuilder)localObject3).append((String)localObject1);
            ((StringBuilder)localObject3).append(" uinCode:");
            ((StringBuilder)localObject3).append((String)localObject2);
            QLog.i("HttpMqqJumper", 2, ((StringBuilder)localObject3).toString());
          }
          Object localObject3 = this.d.getMessageFacade().a(this.c.b, this.c.a, -1L, this.c.v, false);
          Object localObject4 = new ArrayList();
          if (localObject3 != null) {
            ((List)localObject4).addAll((Collection)localObject3);
          }
          localObject3 = NewReportPlugin.a((String)localObject1, this.d.getCurrentAccountUin(), 25004, 10, (List)localObject4);
          localObject4 = ((String)localObject3).replaceAll((String)localObject1, (String)localObject2);
          Bundle localBundle = NewReportPlugin.a(this.c);
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("openMoreOptions safetyReport reportMsgOrg: ");
            localStringBuilder.append((String)localObject3);
            localStringBuilder.append("  reportMsg: ");
            localStringBuilder.append((String)localObject4);
            QLog.i("HttpMqqJumper", 2, localStringBuilder.toString());
          }
          NewReportPlugin.a(this.e.f, (String)localObject1, (String)localObject2, null, null, this.d.getCurrentAccountUin(), 25004, (String)localObject4, localBundle);
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
  
  private boolean c()
  {
    return (this.a.toLowerCase().startsWith("http://")) || (this.a.toLowerCase().startsWith("https://"));
  }
  
  private boolean d()
  {
    return this.a.toLowerCase().startsWith("mqq://jubao.qq.com");
  }
  
  private boolean e()
  {
    return this.a.toLowerCase().startsWith("mqq://");
  }
  
  public HttpMqqJumper a(SessionInfo paramSessionInfo)
  {
    this.c = paramSessionInfo;
    return this;
  }
  
  public HttpMqqJumper a(BaseChatPie paramBaseChatPie)
  {
    this.e = paramBaseChatPie;
    return this;
  }
  
  public HttpMqqJumper a(String paramString)
  {
    this.a = paramString;
    return this;
  }
  
  public void a()
  {
    if (this.b != null)
    {
      if (TextUtils.isEmpty(this.a)) {
        return;
      }
      Object localObject = null;
      if (d())
      {
        this.a = this.a.replace("mqq://", "https://");
        b();
      }
      else if (c())
      {
        localObject = new Intent(this.b, QQBrowserActivity.class);
        ((Intent)localObject).putExtra("url", this.a);
      }
      else if (e())
      {
        localObject = this.d;
        if (localObject != null)
        {
          localObject = JumpParser.a((BaseQQAppInterface)localObject, this.b, this.a);
          if (localObject != null)
          {
            ((JumpAction)localObject).g();
            ((JumpAction)localObject).a();
          }
        }
        return;
      }
      if (localObject != null) {
        this.b.startActivity((Intent)localObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.pushdialog.HttpMqqJumper
 * JD-Core Version:    0.7.0.1
 */