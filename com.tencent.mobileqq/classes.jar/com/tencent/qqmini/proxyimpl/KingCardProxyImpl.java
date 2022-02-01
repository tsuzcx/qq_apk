package com.tencent.qqmini.proxyimpl;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.mobileqq.mini.appbrand.utils.AppBrandTask;
import com.tencent.mobileqq.mini.util.DisplayUtil;
import com.tencent.mobileqq.mini.util.StorageUtil;
import com.tencent.mobileqq.mini.utils.MiniAppGlobal;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.vip.CUKingCardUtils;
import com.tencent.mobileqq.vip.diy.common.DIYLottieLoader;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.annotation.ProxyService;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.proxy.KingCardProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.AppMode;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqperf.monitor.memory.MemoryManager;
import mqq.app.AppRuntime;

@ProxyService(proxy=KingCardProxy.class)
public class KingCardProxyImpl
  implements KingCardProxy
{
  private final String a = "KingCardProxyImpl";
  private String b = "mini_app_kingcard_guide_";
  private String c;
  private DIYLottieLoader d;
  
  private boolean a()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.b);
    ((StringBuilder)localObject).append(BaseApplicationImpl.getApplication().getRuntime().getAccount());
    localObject = ((StringBuilder)localObject).toString();
    return StorageUtil.getPreference().getBoolean((String)localObject, false);
  }
  
  private boolean a(MiniAppInfo paramMiniAppInfo)
  {
    boolean bool2 = AppNetConnInfo.isMobileConn();
    boolean bool1 = false;
    if (!bool2)
    {
      paramMiniAppInfo = new StringBuilder();
      paramMiniAppInfo.append("shouldShowKingCardTip network type is wifi + ");
      paramMiniAppInfo.append(AppNetConnInfo.isWifiConn());
      QLog.i("KingCardProxyImpl", 1, paramMiniAppInfo.toString());
      return false;
    }
    if ((paramMiniAppInfo != null) && (paramMiniAppInfo.appMode != null) && (paramMiniAppInfo.appMode.isWangKa)) {
      i = 1;
    } else {
      i = 0;
    }
    if (i == 0)
    {
      QLog.i("KingCardProxyImpl", 1, "shouldShowKingCardTip， not wangka app");
      return false;
    }
    int i = CUKingCardUtils.a();
    paramMiniAppInfo = new StringBuilder();
    paramMiniAppInfo.append("shouldShowKingCardTip， king card status = ");
    paramMiniAppInfo.append(i);
    QLog.i("KingCardProxyImpl", 1, paramMiniAppInfo.toString());
    if (i == 1) {
      bool1 = true;
    }
    return bool1;
  }
  
  private void b()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.b);
    ((StringBuilder)localObject).append(BaseApplicationImpl.getApplication().getRuntime().getAccount());
    localObject = ((StringBuilder)localObject).toString();
    StorageUtil.getPreference().edit().putBoolean((String)localObject, true).apply();
  }
  
  public ImageView getCapsuleButtonMoreView(Context paramContext)
  {
    if (!TextUtils.isEmpty(MiniAppGlobal.KINGCARD_GUIDE_TEXT)) {
      localObject = MiniAppGlobal.KINGCARD_GUIDE_TEXT;
    } else {
      localObject = paramContext.getResources().getString(2131891761);
    }
    this.c = ((String)localObject);
    this.d = new DIYLottieLoader(paramContext);
    int i = (int)(MemoryManager.d() / 2L);
    this.d.setMemoryCacheSize(i);
    Object localObject = new DiniFlyAnimationView(paramContext);
    ((DiniFlyAnimationView)localObject).setVisibility(0);
    ((DiniFlyAnimationView)localObject).setContentDescription(HardCodeUtil.a(2131899588));
    paramContext = new RelativeLayout.LayoutParams(DisplayUtil.dip2px(paramContext, 40.0F), -1);
    paramContext.addRule(9, -1);
    ((DiniFlyAnimationView)localObject).setScaleType(ImageView.ScaleType.CENTER_INSIDE);
    ((DiniFlyAnimationView)localObject).setLayoutParams(paramContext);
    return localObject;
  }
  
  public boolean showKingCardTips(IMiniAppContext paramIMiniAppContext, ImageView paramImageView)
  {
    QLog.i("KingCardProxyImpl", 1, "showKingCardTips trigger");
    Activity localActivity = paramIMiniAppContext.getAttachedActivity();
    if ((localActivity != null) && (!localActivity.isFinishing()))
    {
      if (!(paramImageView instanceof DiniFlyAnimationView)) {
        return false;
      }
      MiniAppInfo localMiniAppInfo = paramIMiniAppContext.getMiniAppInfo();
      if (localMiniAppInfo == null) {
        return false;
      }
      if (this.d == null)
      {
        QMLog.w("KingCardProxyImpl", "lottie loader is null");
        return false;
      }
      DiniFlyAnimationView localDiniFlyAnimationView = (DiniFlyAnimationView)paramImageView;
      if (localDiniFlyAnimationView.getVisibility() != 0)
      {
        QLog.i("KingCardProxyImpl", 1, "showKingCardTips 小程序官方模式下是 GONE状态，不需要展示");
        return false;
      }
      if ((paramImageView != null) && (localActivity != null) && (!localActivity.isFinishing()) && (a(localMiniAppInfo))) {
        AppBrandTask.runTaskOnUiThreadIfNot(new KingCardProxyImpl.1(this, localActivity, localDiniFlyAnimationView, paramIMiniAppContext));
      }
      return true;
    }
    QLog.i("KingCardProxyImpl", 1, "activity is null");
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.KingCardProxyImpl
 * JD-Core Version:    0.7.0.1
 */