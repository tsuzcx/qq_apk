package com.tencent.mobileqq.qassistant.command.jump;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.confess.ConfessConfig;
import com.tencent.mobileqq.confess.ConfessManager;
import com.tencent.mobileqq.leba.LebaConstant;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;

public class QAssistantConfigWebItem
  extends QAssistantConfigItem
{
  protected String a(QQAppInterface paramQQAppInterface)
  {
    if (StringUtil.a(this.f)) {
      paramQQAppInterface = "";
    }
    ConfessConfig localConfessConfig;
    do
    {
      String str;
      do
      {
        return paramQQAppInterface;
        if (this.f.equalsIgnoreCase("qqgame")) {
          return IndividuationUrlHelper.a("vipGameCenter");
        }
        if (!this.f.equalsIgnoreCase("confessmsg")) {
          break;
        }
        localConfessConfig = ((ConfessManager)paramQQAppInterface.getManager(QQManagerFactory.CONFESS_MANAGER)).b();
        str = "https://ti.qq.com/honest-say/main.html?_bid=3104&_qStyle=1&_wv=9191&_nav_alpha=0&_nav_txtclr=FFFFFF&_nav_titleclr=FFFFFF&_nav_anim=true&_wwv=128&adtag=message_box";
        paramQQAppInterface = str;
      } while (localConfessConfig == null);
      paramQQAppInterface = str;
    } while (TextUtils.isEmpty(localConfessConfig.l));
    return localConfessConfig.l;
    if (this.f.equalsIgnoreCase("qinterest"))
    {
      paramQQAppInterface = SharedPreUtils.c(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin());
      if (!TextUtils.isEmpty(paramQQAppInterface)) {
        return paramQQAppInterface.trim();
      }
      return LebaConstant.a;
    }
    return "";
  }
  
  protected void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    paramQQAppInterface = a(paramQQAppInterface);
    if (StringUtil.a(paramQQAppInterface)) {
      return;
    }
    this.b = paramQQAppInterface;
  }
  
  protected void a(JumpAction paramJumpAction, QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if (this.f.equalsIgnoreCase("qqgame")) {
      paramJumpAction.e("platformId=qq_m");
    }
  }
  
  protected boolean b(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    return !StringUtil.a(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.command.jump.QAssistantConfigWebItem
 * JD-Core Version:    0.7.0.1
 */