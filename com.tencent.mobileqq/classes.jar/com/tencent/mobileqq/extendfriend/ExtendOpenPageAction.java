package com.tencent.mobileqq.extendfriend;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.google.gson.JsonObject;
import com.tencent.mobileqq.activity.ChatSettingActivity;
import com.tencent.mobileqq.activity.LoginInfoActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.parser.JumpActionBase;
import com.tencent.mobileqq.data.ExtendFriendUserInfo;
import com.tencent.mobileqq.extendfriend.utils.ExpandReportUtils;
import com.tencent.mobileqq.extendfriend.utils.ExtendFriendLabelUtils;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class ExtendOpenPageAction
  extends JumpActionBase
{
  private Handler b;
  
  public ExtendOpenPageAction(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
  }
  
  private boolean C()
  {
    String str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("focuson");
    Object localObject = (String)this.jdField_a_of_type_JavaUtilHashMap.get("uin");
    if ("photoswall".equals(str)) {
      str = "profile_scroll_to_photo_wall";
    }
    for (;;)
    {
      if ((!StringUtil.a((String)localObject)) && (((String)localObject).equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())))
      {
        i = 1;
        label61:
        if (i == 0) {
          break label168;
        }
      }
      label168:
      for (int i = 0;; i = 96)
      {
        localObject = new ProfileActivity.AllInOne((String)localObject, i);
        ProfileActivity.a(this.jdField_a_of_type_AndroidContentContext, (ProfileActivity.AllInOne)localObject, str);
        return true;
        if ("wangzhe".equals(str))
        {
          str = "profile_scroll_to_wangzhe";
          break;
        }
        if ("mystar".equals(str))
        {
          str = "profile_scroll_to_troop_fans";
          break;
        }
        if ("makelife".equals(str))
        {
          str = "profile_scroll_to_achievement";
          break;
        }
        if ("personalitylabel".equals(str))
        {
          str = "profile_scroll_to_personality_label";
          break;
        }
        if (!"expandfriend".equals(str)) {
          break label174;
        }
        str = "profile_scroll_to_extend_friend";
        break;
        i = 0;
        break label61;
      }
      label174:
      str = null;
    }
  }
  
  private boolean D()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, LoginInfoActivity.class);
    if (!(this.jdField_a_of_type_AndroidContentContext instanceof Activity)) {
      localIntent.addFlags(268435456);
    }
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    return true;
  }
  
  private boolean E()
  {
    if (this.b == null) {
      this.b = new Handler(Looper.getMainLooper());
    }
    this.b.post(new ExtendOpenPageAction.1(this));
    return true;
  }
  
  private boolean F()
  {
    JsonObject localJsonObject = new JsonObject();
    Object localObject = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      localJsonObject.addProperty(str, (String)this.jdField_a_of_type_JavaUtilHashMap.get(str));
    }
    localObject = (String)this.jdField_a_of_type_JavaUtilHashMap.get("from");
    int i;
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = "";
      i = 0;
    }
    for (;;)
    {
      ExtendFriendLabelUtils.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, i, localJsonObject.toString());
      ExpandReportUtils.b((String)localObject);
      return true;
      try
      {
        i = Integer.parseInt((String)localObject);
      }
      catch (NumberFormatException localNumberFormatException)
      {
        QLog.w("expand.ExtendOpenPageAction", 1, "gotoExpandHome " + localNumberFormatException);
        i = 0;
      }
    }
  }
  
  public void a()
  {
    String str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("uin");
    ExtendFriendUserInfo localExtendFriendUserInfo = ((ExtendFriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER)).a(str, false);
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, ChatSettingActivity.class);
    localIntent.putExtra("uin", str);
    localIntent.putExtra("uintype", 1044);
    if (localExtendFriendUserInfo != null)
    {
      localIntent.putExtra("subId", ExtendFriendUserInfo.fromTypeToSubID(localExtendFriendUserInfo.fromType));
      localIntent.putExtra("ExtendFriendLimitChatFromeType", localExtendFriendUserInfo.fromType);
    }
    if (!(this.jdField_a_of_type_AndroidContentContext instanceof Activity)) {
      localIntent.addFlags(268435456);
    }
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
  }
  
  public void a(String paramString)
  {
    super.a(paramString);
  }
  
  public boolean a()
  {
    QLog.d("expand.ExtendOpenPageAction", 2, "doAction , thread:" + Thread.currentThread().getName());
    try
    {
      String str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("page");
      if ("profile".equals(str)) {
        return C();
      }
      if ("accountsafe".equals(str)) {
        return D();
      }
      if ("safetyreport".equals(str)) {
        return E();
      }
      if ("chatsetting".equals(str))
      {
        a();
      }
      else if ("home".equals(str))
      {
        boolean bool = F();
        return bool;
      }
    }
    catch (Exception localException)
    {
      QLog.e("expand.ExtendOpenPageAction", 1, "doAction error: " + localException.getMessage());
      a("expand.ExtendOpenPageAction");
      return false;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.ExtendOpenPageAction
 * JD-Core Version:    0.7.0.1
 */