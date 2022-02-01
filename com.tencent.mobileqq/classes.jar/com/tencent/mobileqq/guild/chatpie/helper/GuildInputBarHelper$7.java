package com.tencent.mobileqq.guild.chatpie.helper;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.guild.api.IQQGuildRouterApi;
import com.tencent.mobileqq.guild.chatpie.GuildChatContext;
import com.tencent.mobileqq.guild.vas.IGiftPanelAction;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import mqq.manager.TicketManager;

class GuildInputBarHelper$7
  implements IGiftPanelAction
{
  GuildInputBarHelper$7(GuildInputBarHelper paramGuildInputBarHelper) {}
  
  public String a()
  {
    String str = GuildInputBarHelper.c(this.a).getCurrentAccountUin();
    return ((TicketManager)GuildInputBarHelper.c(this.a).getManager(2)).getPskey(str, "qzone.qq.com");
  }
  
  public void a(String paramString)
  {
    if ((paramString != null) && (paramString.length() > 0)) {
      QQToast.makeText(BaseApplicationImpl.sApplication, paramString, 0).show();
    }
  }
  
  public long b()
  {
    String str;
    if (GuildInputBarHelper.a(this.a) == null) {
      str = null;
    } else {
      str = GuildInputBarHelper.a(this.a).getChannelUin();
    }
    if (str == null) {
      return 0L;
    }
    if (Long.decode(str) == null) {
      return 0L;
    }
    return Long.decode(str).longValue();
  }
  
  public void c()
  {
    try
    {
      ((IQQGuildRouterApi)QRoute.api(IQQGuildRouterApi.class)).openGuildMemberSelector(this.a.a.b(), GuildInputBarHelper.c(this.a), GuildInputBarHelper.a(this.a).getGuildId(), this.a.a.b().getString(2131890333), 1, 1);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("GuildInputBarHelper", 2, "open select panel error", localException);
    }
  }
  
  public int d()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public long e()
  {
    String str = ((IGPSService)GuildInputBarHelper.c(this.a).getRuntimeService(IGPSService.class, "")).getSelfTinyId();
    if (TextUtils.isEmpty(str)) {
      return 0L;
    }
    if (Long.decode(str) == null) {
      return 0L;
    }
    return Long.decode(str).longValue();
  }
  
  public long f()
  {
    String str = GuildInputBarHelper.a(this.a).getGuildId();
    if (TextUtils.isEmpty(str)) {
      return 0L;
    }
    if (Long.decode(str) == null) {
      return 0L;
    }
    return Long.decode(str).longValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.helper.GuildInputBarHelper.7
 * JD-Core Version:    0.7.0.1
 */