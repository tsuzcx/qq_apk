package com.tencent.mobileqq.simpleui;

import QC.GetConciseThemeReq;
import QC.GetConciseThemeRsp;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vas.api.IJce;
import com.tencent.mobileqq.vas.api.IJce.Util;
import com.tencent.mobileqq.vas.api.IVasService;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.Locale;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class SimpleUIProtocolUtil
{
  private static boolean a = false;
  
  public static int a()
  {
    if (!a)
    {
      b();
      SimpleUIUtil.l();
      a = true;
    }
    if (SimpleUIUtil.e()) {
      return SimpleUIUtil.d();
    }
    return 0;
  }
  
  public static void a(int paramInt)
  {
    SimpleUIUtil.e(paramInt);
    Object localObject = MobileQQ.sMobileQQ.peekAppRuntime();
    if ((localObject instanceof QQAppInterface))
    {
      localObject = (QQAppInterface)localObject;
      BaseApplication localBaseApplication = MobileQQ.getContext();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("key_simple_status_sp_");
      localStringBuilder.append(((QQAppInterface)localObject).getCurrentAccountUin());
      localObject = localBaseApplication.getSharedPreferences(localStringBuilder.toString(), 0).edit();
      ((SharedPreferences.Editor)localObject).putInt("simple_ui_mode_switch", paramInt);
      ((SharedPreferences.Editor)localObject).apply();
    }
  }
  
  public static void a(AppInterface paramAppInterface, boolean paramBoolean, String paramString)
  {
    VasUtil.a().getJceRequset().build("QC.HomepageLogicServer.HomepageLogicObj", "QcHomePageLogic.GetConciseThemeReq", "stReq", "stRsp").request("GetConciseTheme", new GetConciseThemeReq(IJce.Util.a()), new GetConciseThemeRsp(), new SimpleUIProtocolUtil.1(paramString, paramAppInterface, paramBoolean), false);
  }
  
  private static final void a(String paramString)
  {
    Object localObject = (QQAppInterface)MobileQQ.sMobileQQ.peekAppRuntime();
    if ((localObject != null) && (SimpleUIUtil.c() != -2147483648) && (SimpleUIUtil.b() != -2147483648) && (SimpleUIUtil.g(SimpleUIUtil.b())))
    {
      localObject = (SimpleUIHandler)((QQAppInterface)localObject).getBusinessHandler(BusinessHandlerFactory.SIMPLE_UI_HANDLER);
      boolean bool;
      if (SimpleUIUtil.c() == 1) {
        bool = true;
      } else {
        bool = false;
      }
      int i = SimpleUIUtil.b();
      ((SimpleUIHandler)localObject).a(bool, i);
      ((SimpleUIHandler)localObject).notifyUI(4, true, new Object[] { Boolean.valueOf(bool), Integer.valueOf(i), paramString });
      if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
        com.tencent.qphone.base.util.QLog.i("SimpleUIProtocolUtil", 1, String.format(Locale.getDefault(), "onGetSimpleUISwitchOnLogin [%b,%b]", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i) }));
      }
    }
  }
  
  public static final void a(String paramString, int paramInt1, int paramInt2)
  {
    if (com.tencent.TMG.utils.QLog.isColorLevel()) {
      com.tencent.qphone.base.util.QLog.d("SimpleUIProtocolUtil", 1, String.format("onGetSimpleUIPref type=%d bPref=%d uin=%s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), paramString }));
    }
    Object localObject = (QQAppInterface)MobileQQ.sMobileQQ.peekAppRuntime();
    if ((localObject != null) && (paramString.equals(((QQAppInterface)localObject).getCurrentAccountUin())))
    {
      int i = paramInt1;
      if (!SimpleUIUtil.g(paramInt1)) {
        i = 0;
      }
      SimpleUIUtil.b(i);
      localObject = ThemeUtil.getUinThemePreferences((AppRuntime)localObject);
      ((SharedPreferences)localObject).edit().putInt("key_simple_ui_pref_828", i).apply();
      if (i != SimpleUIUtil.d)
      {
        SimpleUIUtil.c(i);
        ((SharedPreferences)localObject).edit().putInt("key_simple_no_night_ui_828", i).apply();
      }
      if (paramInt2 == 1) {
        a(paramString);
      }
    }
  }
  
  public static final void a(String paramString, boolean paramBoolean, int paramInt)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge Z and I\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.useAs(TypeTransformer.java:868)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:668)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private static void b()
  {
    Object localObject = MobileQQ.sMobileQQ.peekAppRuntime();
    if ((localObject instanceof QQAppInterface))
    {
      localObject = (QQAppInterface)localObject;
      BaseApplication localBaseApplication = MobileQQ.getContext();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("key_simple_status_sp_");
      localStringBuilder.append(((QQAppInterface)localObject).getCurrentAccountUin());
      SimpleUIUtil.e(localBaseApplication.getSharedPreferences(localStringBuilder.toString(), 0).getInt("simple_ui_mode_switch", 0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.simpleui.SimpleUIProtocolUtil
 * JD-Core Version:    0.7.0.1
 */