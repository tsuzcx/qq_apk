package com.tencent.mobileqq.minigame.manager;

import ajjy;
import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.mini.app.AuthorizeCenter;
import com.tencent.mobileqq.mini.appbrand.jsapi.plugins.BaseJsPluginEngine;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.mini.widget.AuthDialog;
import com.tencent.mobileqq.minigame.gpkg.MiniGamePkg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import mqq.os.MqqHandler;

public class MiniGameAuthorizeManager
{
  private static final String TAG = "MiniGameAuthorizeManager";
  private static volatile MiniGameAuthorizeManager sManger;
  private AuthDialog mAuthorDialog;
  private Map<String, AuthorizeCenter> mAuthorizeMap = new HashMap();
  
  private MiniGameAuthorizeManager()
  {
    BaseJsPluginEngine.initAuthWhiteList();
  }
  
  /* Error */
  private AuthorizeCenter getAuthorizeCenterByAppid(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokestatic 54	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6: istore_2
    //   7: iload_2
    //   8: ifeq +9 -> 17
    //   11: aconst_null
    //   12: astore_3
    //   13: aload_0
    //   14: monitorexit
    //   15: aload_3
    //   16: areturn
    //   17: aload_0
    //   18: getfield 24	com/tencent/mobileqq/minigame/manager/MiniGameAuthorizeManager:mAuthorizeMap	Ljava/util/Map;
    //   21: aload_1
    //   22: invokeinterface 60 2 0
    //   27: checkcast 62	com/tencent/mobileqq/mini/app/AuthorizeCenter
    //   30: astore 4
    //   32: aload 4
    //   34: astore_3
    //   35: aload 4
    //   37: ifnonnull +24 -> 61
    //   40: new 62	com/tencent/mobileqq/mini/app/AuthorizeCenter
    //   43: dup
    //   44: invokestatic 68	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   47: aload_1
    //   48: invokestatic 68	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   51: invokevirtual 72	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   54: invokevirtual 78	mqq/app/AppRuntime:getAccount	()Ljava/lang/String;
    //   57: invokespecial 81	com/tencent/mobileqq/mini/app/AuthorizeCenter:<init>	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   60: astore_3
    //   61: aload_0
    //   62: getfield 24	com/tencent/mobileqq/minigame/manager/MiniGameAuthorizeManager:mAuthorizeMap	Ljava/util/Map;
    //   65: aload_1
    //   66: aload_3
    //   67: invokeinterface 85 3 0
    //   72: pop
    //   73: goto -60 -> 13
    //   76: astore_1
    //   77: aload_0
    //   78: monitorexit
    //   79: aload_1
    //   80: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	81	0	this	MiniGameAuthorizeManager
    //   0	81	1	paramString	String
    //   6	2	2	bool	boolean
    //   12	55	3	localObject	Object
    //   30	6	4	localAuthorizeCenter	AuthorizeCenter
    // Exception table:
    //   from	to	target	type
    //   2	7	76	finally
    //   17	32	76	finally
    //   40	61	76	finally
    //   61	73	76	finally
  }
  
  public static MiniGameAuthorizeManager getInstance()
  {
    if (sManger == null) {}
    try
    {
      if (sManger == null) {
        sManger = new MiniGameAuthorizeManager();
      }
      return sManger;
    }
    finally {}
  }
  
  private void showDialog(String paramString1, String paramString2, MiniGameAuthorizeManager.AuthorizeCallback paramAuthorizeCallback)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      QLog.e("MiniGameAuthorizeManager", 1, "showDialog: appid or scopeName is empty,appid= " + paramString1 + "scopeName=" + paramString2);
    }
    MiniGamePkg localMiniGamePkg;
    Object localObject;
    String str;
    do
    {
      return;
      if ((this.mAuthorDialog != null) && (this.mAuthorDialog.isShowing()))
      {
        QLog.e("MiniGameAuthorizeManager", 1, "showDialog: mAuthorDialog is showing now.just return");
        return;
      }
      localMiniGamePkg = GameInfoManager.g().getMiniGamePkg();
      if ((localMiniGamePkg == null) || (!TextUtils.equals(localMiniGamePkg.appId, paramString1)))
      {
        QLog.e("MiniGameAuthorizeManager", 1, "showDialog: cann't get gamePkg");
        return;
      }
      localObject = BaseActivity.sTopActivity;
      if (localObject == null)
      {
        QLog.e("MiniGameAuthorizeManager", 1, "showDialog: activity is null");
        return;
      }
      paramString1 = new MiniGameAuthorizeManager.2(this, paramString1, paramString2, paramAuthorizeCallback);
      this.mAuthorDialog = new AuthDialog((Context)localObject);
      this.mAuthorDialog.setOnDismissListener(paramString1);
      paramString1 = (String)AuthorizeCenter.scopeTitleMap.get(paramString2);
      paramAuthorizeCallback = (String)AuthorizeCenter.scopeDescMap.get(paramString2);
      localObject = ajjy.a(2131641055);
      str = ajjy.a(2131641053);
      if ("scope.userInfo".equals(paramString2))
      {
        MiniAppCmdUtil.getInstance().getUserInfo(localMiniGamePkg.appId, false, "en", new MiniGameAuthorizeManager.3(this, localMiniGamePkg, paramString1, paramAuthorizeCallback, str));
        return;
      }
    } while (this.mAuthorDialog == null);
    this.mAuthorDialog.show(localMiniGamePkg.iconUrl, localMiniGamePkg.apkgName, paramString1, null, null, paramAuthorizeCallback, (String)localObject, new MiniGameAuthorizeManager.4(this), str, new MiniGameAuthorizeManager.5(this));
  }
  
  public int getAuthFlag(String paramString1, String paramString2)
  {
    int j = 1;
    int i;
    if (BaseJsPluginEngine.isAuthWhiteAppId(GameInfoManager.g().getAppId())) {
      i = 2;
    }
    do
    {
      do
      {
        do
        {
          return i;
          i = j;
        } while (TextUtils.isEmpty(paramString1));
        i = j;
      } while (TextUtils.isEmpty(paramString2));
      paramString1 = getAuthorizeCenterByAppid(paramString1);
      i = j;
    } while (paramString1 == null);
    return paramString1.getAuthFlagFromAuthorize(paramString2);
  }
  
  public void requestAuthorize(String paramString1, String paramString2, MiniGameAuthorizeManager.AuthorizeCallback paramAuthorizeCallback)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      QLog.w("MiniGameAuthorizeManager", 1, "requestAuthorize: appid or scopeName is empty,appid= " + paramString1 + "scopeName=" + paramString2);
    }
    do
    {
      return;
      if (getAuthFlag(paramString1, paramString2) != 2L) {
        break;
      }
    } while (paramAuthorizeCallback == null);
    paramAuthorizeCallback.onAuthorizeFinish(true);
    return;
    ThreadManager.getUIHandler().post(new MiniGameAuthorizeManager.1(this, paramString1, paramString2, paramAuthorizeCallback));
  }
  
  public void setAuthorize(String paramString1, String paramString2, boolean paramBoolean)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      QLog.w("MiniGameAuthorizeManager", 1, "setAuthorize: appid or scopeName is empty,appid= " + paramString1 + "scopeName=" + paramString2);
      return;
    }
    getAuthorizeCenterByAppid(paramString1).setAuthorize(paramString2, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.manager.MiniGameAuthorizeManager
 * JD-Core Version:    0.7.0.1
 */