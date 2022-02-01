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
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.addfriend.api.IAddFriendApi;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilesetting.InterestSwitchEditActivity;
import com.tencent.mobileqq.qqexpand.bean.profile.ExpandUserInfo;
import com.tencent.mobileqq.qqexpand.chat.ILimitChatUtils;
import com.tencent.mobileqq.qqexpand.entrance.IExpandEntrance;
import com.tencent.mobileqq.qqexpand.manager.IExpandManager;
import com.tencent.mobileqq.qqexpand.utils.IExpandReportUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class ExtendOpenPageAction
  extends JumpAction
{
  private Handler b;
  
  public ExtendOpenPageAction(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
  }
  
  private void a()
  {
    String str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("uin");
    ExpandUserInfo localExpandUserInfo = ((IExpandManager)this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER)).a(str, false);
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, ChatSettingActivity.class);
    localIntent.putExtra("uin", str);
    localIntent.putExtra("uintype", 1044);
    if (localExpandUserInfo != null)
    {
      localIntent.putExtra("subId", ExpandUserInfo.fromTypeToSubID(localExpandUserInfo.fromType));
      localIntent.putExtra("ExtendFriendLimitChatFromeType", localExpandUserInfo.fromType);
    }
    if (!(this.jdField_a_of_type_AndroidContentContext instanceof Activity)) {
      localIntent.addFlags(268435456);
    }
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
  }
  
  private boolean c()
  {
    if (this.b == null) {
      this.b = new Handler(Looper.getMainLooper());
    }
    this.b.post(new ExtendOpenPageAction.1(this));
    return true;
  }
  
  private boolean j()
  {
    String str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("focuson");
    Object localObject = (String)this.jdField_a_of_type_JavaUtilHashMap.get("uin");
    if ("photoswall".equals(str)) {
      str = "profile_scroll_to_photo_wall";
    } else if ("wangzhe".equals(str)) {
      str = "profile_scroll_to_wangzhe";
    } else if ("mystar".equals(str)) {
      str = "profile_scroll_to_troop_fans";
    } else if ("makelife".equals(str)) {
      str = "profile_scroll_to_achievement";
    } else if ("personalitylabel".equals(str)) {
      str = "profile_scroll_to_personality_label";
    } else if ("expandfriend".equals(str)) {
      str = "profile_scroll_to_extend_friend";
    } else {
      str = null;
    }
    boolean bool = StringUtil.a((String)localObject);
    int j = 0;
    int i;
    if ((!bool) && (((String)localObject).equals(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface.getCurrentAccountUin()))) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      i = j;
    } else {
      i = 96;
    }
    localObject = new AllInOne((String)localObject, i);
    ProfileActivity.a(this.jdField_a_of_type_AndroidContentContext, (AllInOne)localObject, str);
    return true;
  }
  
  private boolean k()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, LoginInfoActivity.class);
    if (!(this.jdField_a_of_type_AndroidContentContext instanceof Activity)) {
      localIntent.addFlags(268435456);
    }
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    return true;
  }
  
  private boolean l()
  {
    if (this.b == null) {
      this.b = new Handler(Looper.getMainLooper());
    }
    this.b.post(new ExtendOpenPageAction.2(this));
    return true;
  }
  
  private boolean m()
  {
    JsonObject localJsonObject = new JsonObject();
    Object localObject = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      localJsonObject.addProperty(str, (String)this.jdField_a_of_type_JavaUtilHashMap.get(str));
    }
    localObject = (String)this.jdField_a_of_type_JavaUtilHashMap.get("from");
    int i = 0;
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      localObject = "";
    } else {
      try
      {
        int j = Integer.parseInt((String)localObject);
        i = j;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("gotoExpandHome ");
        localStringBuilder.append(localNumberFormatException);
        QLog.w("expand.ExtendOpenPageAction", 1, localStringBuilder.toString());
      }
    }
    ((IExpandEntrance)QRoute.api(IExpandEntrance.class)).enterExpandByJumpAction(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface, i, localJsonObject.toString());
    ((IExpandReportUtils)QRoute.api(IExpandReportUtils.class)).reportEnterExpandClick((String)localObject);
    return true;
  }
  
  private boolean n()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, InterestSwitchEditActivity.class);
    if (!(this.jdField_a_of_type_AndroidContentContext instanceof Activity)) {
      localIntent.addFlags(268435456);
    }
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    return true;
  }
  
  private boolean o()
  {
    String str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("uin");
    if (TextUtils.isEmpty(str))
    {
      QLog.w("expand.ExtendOpenPageAction", 1, "gotoAddFriendPage uin is empty!");
      return false;
    }
    Object localObject = ((IAddFriendApi)QRoute.api(IAddFriendApi.class)).startAddFriend((Activity)this.jdField_a_of_type_AndroidContentContext, 1, str, "", 3001, 11, "", "", null, "", "");
    ((IAddFriendApi)QRoute.api(IAddFriendApi.class)).launchAddFriend(this.jdField_a_of_type_AndroidContentContext, (Intent)localObject);
    if ("graytip".equals((String)this.jdField_a_of_type_JavaUtilHashMap.get("from")))
    {
      localObject = new HashMap();
      ((HashMap)localObject).put("to_uid", str);
      ((HashMap)localObject).put("session_id", ((ILimitChatUtils)QRoute.api(ILimitChatUtils.class)).getSessionId(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface.getCurrentAccountUin(), str));
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
      localObject = (String)this.jdField_a_of_type_JavaUtilHashMap.get("page");
      if ("profile".equals(localObject)) {
        return j();
      }
      if ("accountsafe".equals(localObject)) {
        return k();
      }
      if ("safetyreport".equals(localObject)) {
        return l();
      }
      if ("chatsetting".equals(localObject))
      {
        a();
        return false;
      }
      if ("home".equals(localObject)) {
        return m();
      }
      if ("displaySetting".equals(localObject)) {
        return n();
      }
      if ("addfriend".equals(localObject)) {
        return o();
      }
      if ("profilereport".equals(localObject)) {
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
      b_("expand.ExtendOpenPageAction");
    }
    return false;
  }
  
  public void b_(String paramString)
  {
    super.b_(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.ExtendOpenPageAction
 * JD-Core Version:    0.7.0.1
 */