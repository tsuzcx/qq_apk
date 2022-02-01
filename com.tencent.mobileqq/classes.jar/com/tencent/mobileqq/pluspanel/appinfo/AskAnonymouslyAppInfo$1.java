package com.tencent.mobileqq.pluspanel.appinfo;

import android.app.Activity;
import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.troop.askanonymously.AskAnonymousUtil;
import com.tencent.mobileqq.troop.troopmanager.api.TroopManagerBizObserver;
import com.tencent.mobileqq.webview.util.WebViewComUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class AskAnonymouslyAppInfo$1
  extends TroopManagerBizObserver
{
  AskAnonymouslyAppInfo$1(AskAnonymouslyAppInfo paramAskAnonymouslyAppInfo) {}
  
  protected void onGetTroopInfoForSetJoinTypeRet(boolean paramBoolean, long paramLong, int paramInt, TroopInfo paramTroopInfo, Object[] paramArrayOfObject)
  {
    if (QLog.isColorLevel())
    {
      long l;
      if (paramTroopInfo == null) {
        l = -1L;
      } else {
        l = paramTroopInfo.dwGroupFlagExt;
      }
      QLog.d("AskAnonymouslyAppInfo", 2, String.format("onGetTroopInfoForSetJoinTypeRet suc=%b troopUin=%d dwGroupFlagExt=0x%x", new Object[] { Boolean.valueOf(paramBoolean), Long.valueOf(paramLong), Long.valueOf(l) }));
    }
    if (AskAnonymouslyAppInfo.access$000(this.a) == null) {
      paramArrayOfObject = null;
    } else {
      paramArrayOfObject = (Activity)AskAnonymouslyAppInfo.access$000(this.a).get();
    }
    if (!(paramArrayOfObject instanceof BaseActivity)) {
      return;
    }
    Object localObject = ((BaseActivity)paramArrayOfObject).app;
    if (!paramBoolean)
    {
      paramTroopInfo = (TroopManager)((QQAppInterface)localObject).getManager(QQManagerFactory.TROOP_MANAGER);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append("");
      paramTroopInfo = paramTroopInfo.c(((StringBuilder)localObject).toString());
    }
    if ((paramTroopInfo != null) && (AskAnonymousUtil.a(paramTroopInfo.dwGroupFlagExt))) {
      paramInt = 1;
    } else {
      paramInt = 0;
    }
    if (paramInt == 0)
    {
      QQToast.a(BaseApplicationImpl.getApplication(), 2131698650, 1).a();
      return;
    }
    if (WebViewComUtils.a(1000L))
    {
      paramTroopInfo = new Intent(BaseApplicationImpl.getContext(), QQBrowserActivity.class);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append("");
      paramTroopInfo.putExtra("url", String.format("https://qun.qq.com/v2/anonymousqa/edit?_wv=16777218&_wwv=1&_cwv=8&gc=%s", new Object[] { ((StringBuilder)localObject).toString() }));
      paramArrayOfObject.startActivity(paramTroopInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.pluspanel.appinfo.AskAnonymouslyAppInfo.1
 * JD-Core Version:    0.7.0.1
 */