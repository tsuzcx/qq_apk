package com.tencent.mobileqq.simpleui;

import QC.GetConciseThemeReq;
import QC.GetConciseThemeRsp;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.vip.JceProtocol;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
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
      a();
      SimpleUIUtil.b();
      a = true;
    }
    if (SimpleUIUtil.a()) {
      return SimpleUIUtil.c();
    }
    return 0;
  }
  
  private static void a()
  {
    Object localObject = MobileQQ.sMobileQQ.peekAppRuntime();
    if ((localObject instanceof QQAppInterface))
    {
      localObject = (QQAppInterface)localObject;
      SimpleUIUtil.d(MobileQQ.getContext().getSharedPreferences("key_simple_status_sp_" + ((QQAppInterface)localObject).getCurrentAccountUin(), 0).getInt("simple_ui_mode_switch", 0));
    }
  }
  
  public static void a(int paramInt)
  {
    SimpleUIUtil.d(paramInt);
    Object localObject = MobileQQ.sMobileQQ.peekAppRuntime();
    if ((localObject instanceof QQAppInterface))
    {
      localObject = (QQAppInterface)localObject;
      localObject = MobileQQ.getContext().getSharedPreferences("key_simple_status_sp_" + ((QQAppInterface)localObject).getCurrentAccountUin(), 0).edit();
      ((SharedPreferences.Editor)localObject).putInt("simple_ui_mode_switch", paramInt);
      ((SharedPreferences.Editor)localObject).apply();
    }
  }
  
  public static void a(AppInterface paramAppInterface, boolean paramBoolean, String paramString)
  {
    new JceProtocol("QC.HomepageLogicServer.HomepageLogicObj", "QcHomePageLogic.GetConciseThemeReq", "stReq", "stRsp").a("GetConciseTheme", new GetConciseThemeReq(JceProtocol.a()), new GetConciseThemeRsp(), new SimpleUIProtocolUtil.1(paramString, paramAppInterface, paramBoolean), false);
  }
  
  private static final void a(String paramString)
  {
    Object localObject = (QQAppInterface)MobileQQ.sMobileQQ.peekAppRuntime();
    if ((localObject != null) && (SimpleUIUtil.b() != -2147483648) && (SimpleUIUtil.a() != -2147483648) && (SimpleUIUtil.a(SimpleUIUtil.a())))
    {
      localObject = (SimpleUIHandler)((QQAppInterface)localObject).getBusinessHandler(BusinessHandlerFactory.SIMPLE_UI_HANDLER);
      if (SimpleUIUtil.b() != 1) {
        break label137;
      }
    }
    label137:
    for (boolean bool = true;; bool = false)
    {
      int i = SimpleUIUtil.a();
      ((SimpleUIHandler)localObject).a(bool, i);
      ((SimpleUIHandler)localObject).notifyUI(4, true, new Object[] { Boolean.valueOf(bool), Integer.valueOf(i), paramString });
      if (QLog.isColorLevel()) {
        QLog.i("SimpleUIProtocolUtil", 1, String.format(Locale.getDefault(), "onGetSimpleUISwitchOnLogin [%b,%b]", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i) }));
      }
      return;
    }
  }
  
  public static final void a(String paramString, int paramInt1, int paramInt2)
  {
    QLog.d("SimpleUIProtocolUtil", 1, String.format("onGetSimpleUIPref type=%d bPref=%d uin=%s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), paramString }));
    Object localObject = (QQAppInterface)MobileQQ.sMobileQQ.peekAppRuntime();
    if ((localObject != null) && (paramString.equals(((QQAppInterface)localObject).getCurrentAccountUin())))
    {
      int i = paramInt1;
      if (!SimpleUIUtil.a(paramInt1)) {
        i = 0;
      }
      SimpleUIUtil.a(i);
      localObject = ThemeUtil.getUinThemePreferences((AppRuntime)localObject);
      ((SharedPreferences)localObject).edit().putInt("key_simple_ui_pref_828", i).apply();
      if (i != SimpleUIUtil.c)
      {
        SimpleUIUtil.b(i);
        ((SharedPreferences)localObject).edit().putInt("key_simple_no_night_ui_828", i).apply();
      }
      if (paramInt2 == 1) {
        a(paramString);
      }
    }
  }
  
  public static final void a(String paramString, boolean paramBoolean, int paramInt)
  {
    int i = 0;
    QLog.d("SimpleUIProtocolUtil", 1, String.format("onGetSimpleUISwitch type=%d bSwitch=%b uin=%s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean), paramString }));
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if ((localQQAppInterface != null) && (paramString.equals(localQQAppInterface.getCurrentAccountUin())))
    {
      if (paramBoolean) {
        i = 1;
      }
      SimpleUIUtil.c(i);
      ThemeUtil.getUinThemePreferences(localQQAppInterface).edit().putBoolean("key_simple_ui_switch", paramBoolean).commit();
      if (paramInt == 1) {
        a(paramString);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.simpleui.SimpleUIProtocolUtil
 * JD-Core Version:    0.7.0.1
 */