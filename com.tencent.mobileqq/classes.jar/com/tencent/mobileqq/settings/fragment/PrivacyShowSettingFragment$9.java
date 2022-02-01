package com.tencent.mobileqq.settings.fragment;

import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qphone.base.util.QLog;

class PrivacyShowSettingFragment$9
  extends CardObserver
{
  PrivacyShowSettingFragment$9(PrivacyShowSettingFragment paramPrivacyShowSettingFragment) {}
  
  protected void onGetAllowSeeLoginDays(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    if ((paramString != null) && (paramString.equals(this.a.a.getCurrentAccountUin())))
    {
      if (paramBoolean1)
      {
        paramString = this.a;
        PrivacyShowSettingFragment.a(paramString, PrivacyShowSettingFragment.e(paramString).getSwitch(), paramBoolean2);
      }
    }
    else
    {
      paramString = new StringBuilder();
      paramString.append("onGetAllowSeeLoginDays isSuccess ");
      paramString.append(paramBoolean1);
      paramString.append("isAllow:");
      paramString.append(paramBoolean2);
      paramString.append("uin empty!");
      QLog.e("IphoneTitleBarFragment", 2, paramString.toString());
    }
  }
  
  protected void onGetPrettyOwnerFlag(boolean paramBoolean, Object paramObject)
  {
    if (!paramBoolean) {
      return;
    }
    if (paramObject != null) {}
    for (;;)
    {
      try
      {
        paramBoolean = ((Boolean)paramObject).booleanValue();
        PrivacyShowSettingFragment.a(this.a, paramBoolean);
        PrivacyShowSettingFragment.b(this.a).setChecked(paramBoolean);
        paramObject = new StringBuilder();
        paramObject.append("onGetPrettyOwnerFlag ");
        paramObject.append(paramBoolean);
        QLog.e("vip_pretty.IphoneTitleBarFragment", 1, paramObject.toString());
        return;
      }
      catch (Exception localException)
      {
        Object localObject;
        continue;
      }
      paramObject = new StringBuilder();
      paramObject.append("onGetPrettyOwnerFlag ex:");
      paramObject.append(localObject);
      QLog.e("vip_pretty.IphoneTitleBarFragment", 1, paramObject.toString());
      return;
      paramBoolean = false;
    }
  }
  
  protected void onSetAllowSeeLoginDays(boolean paramBoolean)
  {
    Card localCard = ((FriendsManager)this.a.a.getManager(QQManagerFactory.FRIENDS_MANAGER)).g(this.a.a.getCurrentAccountUin());
    PrivacyShowSettingFragment localPrivacyShowSettingFragment = this.a;
    PrivacyShowSettingFragment.a(localPrivacyShowSettingFragment, PrivacyShowSettingFragment.e(localPrivacyShowSettingFragment).getSwitch(), localCard.allowPeopleSee);
  }
  
  protected void onSetMedal(boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  protected void onSetPrettyOwnerFlag(boolean paramBoolean, Object paramObject)
  {
    if (!paramBoolean) {
      return;
    }
    if (paramObject != null) {}
    for (;;)
    {
      try
      {
        paramBoolean = ((Boolean)paramObject).booleanValue();
        PrivacyShowSettingFragment.a(this.a, paramBoolean);
        paramObject = new StringBuilder();
        paramObject.append("onSetPrettyOwnerFlag ");
        paramObject.append(paramBoolean);
        QLog.e("vip_pretty.IphoneTitleBarFragment", 1, paramObject.toString());
        return;
      }
      catch (Exception localException)
      {
        Object localObject;
        continue;
      }
      paramObject = new StringBuilder();
      paramObject.append("onSetPrettyOwnerFlag ex:");
      paramObject.append(localObject);
      QLog.e("vip_pretty.IphoneTitleBarFragment", 1, paramObject.toString());
      return;
      paramBoolean = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.settings.fragment.PrivacyShowSettingFragment.9
 * JD-Core Version:    0.7.0.1
 */