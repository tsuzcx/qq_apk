package com.tencent.mobileqq.extendfriend;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.google.gson.JsonObject;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.ChatSettingActivity;
import com.tencent.mobileqq.activity.LoginInfoActivity;
import com.tencent.mobileqq.addfriend.api.IAddFriendApi;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.profilesetting.InterestSwitchEditActivity;
import com.tencent.mobileqq.qqexpand.bean.profile.ExpandUserInfo;
import com.tencent.mobileqq.qqexpand.chat.ILimitChatUtils;
import com.tencent.mobileqq.qqexpand.entrance.IExpandEntrance;
import com.tencent.mobileqq.qqexpand.manager.IExpandManager;
import com.tencent.mobileqq.qqexpand.utils.IExpandReportUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class ExtendOpenPageAction
  extends JumpAction
{
  private Handler H;
  
  public ExtendOpenPageAction(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
  }
  
  private boolean c()
  {
    JsonObject localJsonObject = new JsonObject();
    Object localObject = this.f.keySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      localJsonObject.addProperty(str, (String)this.f.get(str));
    }
    localObject = (String)this.f.get("from");
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      localObject = "";
    }
    int i;
    for (;;)
    {
      i = 0;
      break;
      try
      {
        i = Integer.parseInt((String)localObject);
      }
      catch (NumberFormatException localNumberFormatException)
      {
        QLog.w("expand.ExtendOpenPageAction", 1, "gotoExpandChatList ", localNumberFormatException);
      }
    }
    ((IExpandEntrance)QRoute.api(IExpandEntrance.class)).enterExpandByJumpAction(this.b, this.a, "qqExpandMessageList", i, localJsonObject.toString());
    ((IExpandReportUtils)QRoute.api(IExpandReportUtils.class)).reportEnterExpandClick((String)localObject);
    return true;
  }
  
  private boolean d()
  {
    if (this.H == null) {
      this.H = new Handler(Looper.getMainLooper());
    }
    this.H.post(new ExtendOpenPageAction.1(this));
    return true;
  }
  
  private boolean e()
  {
    String str3 = (String)this.f.get("uin");
    String str2 = (String)this.f.get("fromPage");
    String str1;
    if (str2 != null)
    {
      str1 = str2;
      if (!TextUtils.isEmpty(str2)) {}
    }
    else
    {
      str1 = Integer.toString(23);
    }
    ((ILimitChatUtils)QRoute.api(ILimitChatUtils.class)).startExtendFriendCardOnClickAvatar(this.b, str3, Integer.parseInt(str1));
    return true;
  }
  
  private boolean f()
  {
    Intent localIntent = new Intent(this.b, LoginInfoActivity.class);
    if (!(this.b instanceof Activity)) {
      localIntent.addFlags(268435456);
    }
    this.b.startActivity(localIntent);
    return true;
  }
  
  private boolean q()
  {
    if (this.H == null) {
      this.H = new Handler(Looper.getMainLooper());
    }
    this.H.post(new ExtendOpenPageAction.2(this));
    return true;
  }
  
  private void r()
  {
    String str = (String)this.f.get("uin");
    ExpandUserInfo localExpandUserInfo = ((IExpandManager)this.a.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER)).a(str, false);
    Intent localIntent = new Intent(this.b, ChatSettingActivity.class);
    localIntent.putExtra("uin", str);
    localIntent.putExtra("uintype", 1044);
    if (localExpandUserInfo != null)
    {
      localIntent.putExtra("subId", ExpandUserInfo.fromTypeToSubID(localExpandUserInfo.fromType));
      localIntent.putExtra("ExtendFriendLimitChatFromeType", localExpandUserInfo.fromType);
    }
    if (!(this.b instanceof Activity)) {
      localIntent.addFlags(268435456);
    }
    this.b.startActivity(localIntent);
  }
  
  private boolean s()
  {
    JsonObject localJsonObject = new JsonObject();
    Object localObject = this.f.keySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      localJsonObject.addProperty(str, (String)this.f.get(str));
    }
    localObject = (String)this.f.get("from");
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      localObject = "";
    }
    int i;
    for (;;)
    {
      i = 0;
      break;
      try
      {
        i = Integer.parseInt((String)localObject);
      }
      catch (NumberFormatException localNumberFormatException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("gotoExpandHome ");
        localStringBuilder.append(localNumberFormatException);
        QLog.w("expand.ExtendOpenPageAction", 1, localStringBuilder.toString());
      }
    }
    ((IExpandEntrance)QRoute.api(IExpandEntrance.class)).enterExpandByJumpAction(this.b, this.a, "QQExpandWidget", i, localJsonObject.toString());
    ((IExpandReportUtils)QRoute.api(IExpandReportUtils.class)).reportEnterExpandClick((String)localObject);
    return true;
  }
  
  private boolean t()
  {
    Intent localIntent = new Intent(this.b, InterestSwitchEditActivity.class);
    if (!(this.b instanceof Activity)) {
      localIntent.addFlags(268435456);
    }
    this.b.startActivity(localIntent);
    return true;
  }
  
  private boolean u()
  {
    String str = (String)this.f.get("uin");
    if (TextUtils.isEmpty(str))
    {
      QLog.w("expand.ExtendOpenPageAction", 1, "gotoAddFriendPage uin is empty!");
      return false;
    }
    Object localObject = ((IAddFriendApi)QRoute.api(IAddFriendApi.class)).startAddFriend((Activity)this.b, 1, str, "", 3001, 11, "", "", null, "", "");
    ((IAddFriendApi)QRoute.api(IAddFriendApi.class)).launchAddFriend(this.b, (Intent)localObject);
    if ("graytip".equals((String)this.f.get("from")))
    {
      localObject = new HashMap();
      ((HashMap)localObject).put("to_uid", str);
      ((HashMap)localObject).put("session_id", ((ILimitChatUtils)QRoute.api(ILimitChatUtils.class)).getSessionId(this.a.getCurrentAccountUin(), str));
      ((IExpandReportUtils)QRoute.api(IExpandReportUtils.class)).onUserActionToTunnel("click#chat_page#gray_tips_add_friend", true, (Map)localObject);
    }
    return true;
  }
  
  public boolean a()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("doAction , thread:");
    ((StringBuilder)localObject).append(Thread.currentThread().getName());
    QLog.d("expand.ExtendOpenPageAction", 2, ((StringBuilder)localObject).toString());
    boolean bool = false;
    try
    {
      localObject = (String)this.f.get("page");
      if ("profile".equals(localObject)) {
        return e();
      }
      if ("accountsafe".equals(localObject)) {
        return f();
      }
      if ("safetyreport".equals(localObject)) {
        return q();
      }
      if ("chatsetting".equals(localObject))
      {
        r();
        return false;
      }
      if ("home".equals(localObject)) {
        return s();
      }
      if ("displaySetting".equals(localObject)) {
        return t();
      }
      if ("addfriend".equals(localObject)) {
        return u();
      }
      if ("profilereport".equals(localObject)) {
        return d();
      }
      if ("chatlist".equals(localObject)) {
        bool = c();
      }
      return bool;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("doAction error: ");
      localStringBuilder.append(localException.getMessage());
      QLog.e("expand.ExtendOpenPageAction", 1, localStringBuilder.toString());
      h_("expand.ExtendOpenPageAction");
    }
    return false;
  }
  
  public void h_(String paramString)
  {
    super.h_(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.ExtendOpenPageAction
 * JD-Core Version:    0.7.0.1
 */