package com.tencent.mobileqq.qassistant.command.jump;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.home.impl.FrameControllerUtil;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.confess.ConfessManager;
import com.tencent.mobileqq.extendfriend.ExtendFriendManager;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.mobileqq.utils.SharedPreUtils;
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
  
  protected void a(QQAppInterface paramQQAppInterface, Context paramContext) {}
  
  protected void a(JumpAction paramJumpAction, QQAppInterface paramQQAppInterface, Context paramContext) {}
  
  public boolean a(BaseActivity paramBaseActivity)
  {
    return a(paramBaseActivity, a());
  }
  
  public boolean a(BaseActivity paramBaseActivity, boolean paramBoolean)
  {
    if (paramBaseActivity == null)
    {
      QAssistantConfigUtils.a(this.g, this.f, 100);
      return false;
    }
    Intent localIntent;
    if (paramBoolean) {
      localIntent = new Intent(paramBaseActivity, SplashActivity.class);
    }
    for (;;)
    {
      localIntent.setFlags(67108864);
      QAssistantConfigUtils.a(this, paramBoolean, localIntent);
      QLog.d("QAssistantConfigItem", 1, "mqqaudioassistant QAssistantConfigItem.Jump item_server = " + this.c + "|" + paramBaseActivity.getClass().toString());
      paramBaseActivity.startActivity(localIntent);
      return true;
      localIntent = new Intent(paramBaseActivity, SplashActivity.class);
      localIntent.putExtra("tab_index", FrameControllerUtil.a);
      localIntent.putExtra("fragment_id", 1);
    }
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if ((paramQQAppInterface == null) || (paramContext == null))
    {
      QAssistantConfigUtils.a(this.g, this.f, 100);
      return false;
    }
    QLog.d("QAssistantConfigItem", 1, "mqqaudioassistant RealJump start");
    a(paramQQAppInterface, paramContext);
    if (!b(paramQQAppInterface, paramContext))
    {
      QAssistantConfigUtils.a(this.g, this.f, 3);
      QLog.d("QAssistantConfigItem", 1, "mqqaudioassistant checkIsSupportJump is false");
      return false;
    }
    if ((StringUtil.a(this.b)) && (StringUtil.a(this.c)))
    {
      QAssistantConfigUtils.a(this.g, this.f, 100);
      return false;
    }
    JumpAction localJumpAction2;
    JumpAction localJumpAction1;
    if (!StringUtil.a(this.b))
    {
      localJumpAction2 = JumpParser.a(paramQQAppInterface, paramContext, this.b);
      localJumpAction1 = localJumpAction2;
      if (localJumpAction2 != null)
      {
        localJumpAction1 = localJumpAction2;
        if (!StringUtil.a(this.e))
        {
          localJumpAction1 = localJumpAction2;
          if (!StringUtil.a(this.e))
          {
            localJumpAction2.c(this.e);
            localJumpAction1 = localJumpAction2;
          }
        }
      }
    }
    while (localJumpAction1 == null)
    {
      QAssistantConfigUtils.a(this.g, this.f, 102);
      return false;
      localJumpAction2 = new JumpAction(paramQQAppInterface, paramContext);
      localJumpAction2.b = this.c;
      if ((!StringUtil.a(this.d)) && (!StringUtil.a(this.d))) {
        localJumpAction2.c = this.d;
      }
      localJumpAction1 = localJumpAction2;
      if (!this.jdField_a_of_type_JavaUtilHashMap.isEmpty())
      {
        localJumpAction2.a(this.jdField_a_of_type_JavaUtilHashMap);
        localJumpAction1 = localJumpAction2;
      }
    }
    QLog.d("QAssistantConfigItem", 1, "mqqaudioassistant RealJump ready Jump server = " + this.c);
    a(localJumpAction1, paramQQAppInterface, paramContext);
    if (localJumpAction1.a())
    {
      QAssistantConfigUtils.a(this.g, this.f, 0);
      QAssistantConfigUtils.a(this.f);
    }
    for (;;)
    {
      return true;
      QAssistantConfigUtils.a(this.g, this.f, 103);
    }
  }
  
  protected boolean b(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (this.f != null)
    {
      if (!this.f.equalsIgnoreCase("ecchat")) {
        break label79;
      }
      int i = SharedPreUtils.a(paramQQAppInterface.getCurrentAccountUin(), "extend_friend_config_785").getInt("sp_extend_friend_entry_add_friend", 0);
      paramQQAppInterface = (ExtendFriendManager)paramQQAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER);
      if ((i != 1) || (!paramQQAppInterface.d())) {
        break label73;
      }
      bool1 = true;
    }
    label73:
    label79:
    do
    {
      do
      {
        for (;;)
        {
          return bool1;
          bool1 = false;
        }
        bool1 = bool2;
      } while (!this.f.equalsIgnoreCase("confessmsg"));
      bool1 = bool2;
    } while (((ConfessManager)paramQQAppInterface.getManager(QQManagerFactory.CONFESS_MANAGER)).a() != null);
    return false;
  }
  
  public String toString()
  {
    return "{\"strName\":\"" + this.jdField_a_of_type_JavaLangString + "\", \"strScheme\":\"" + this.b + "\", \"strServer\":\"" + this.c + "\", \"strAction\":\"" + this.d + "\", \"strPackage\":\"" + this.e + "\", \"isOpenEnable\":" + this.jdField_a_of_type_Boolean + ", \"openAction\":\"" + this.f + "\", \"host\":\"" + this.g + "\", \"attributes\":" + this.jdField_a_of_type_JavaUtilHashMap + "}";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.command.jump.QAssistantConfigItem
 * JD-Core Version:    0.7.0.1
 */