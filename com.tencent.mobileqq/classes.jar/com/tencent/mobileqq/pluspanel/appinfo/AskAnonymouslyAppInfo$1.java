package com.tencent.mobileqq.pluspanel.appinfo;

import android.app.Activity;
import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopBusinessObserver;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.troop.askanonymously.AskAnonymousUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class AskAnonymouslyAppInfo$1
  extends TroopBusinessObserver
{
  AskAnonymouslyAppInfo$1(AskAnonymouslyAppInfo paramAskAnonymouslyAppInfo) {}
  
  public void onOIDB0X88D_0_Ret(boolean paramBoolean, long paramLong, int paramInt1, TroopInfo paramTroopInfo, int paramInt2, String paramString, Object[] paramArrayOfObject)
  {
    long l;
    if (QLog.isColorLevel())
    {
      if (paramTroopInfo == null)
      {
        l = -1L;
        QLog.d("AskAnonymouslyAppInfo", 2, String.format("onOIDB0X88D_0_Ret suc=%b troopUin=%d dwGroupFlagExt=0x%x", new Object[] { Boolean.valueOf(paramBoolean), Long.valueOf(paramLong), Long.valueOf(l) }));
      }
    }
    else
    {
      if (AskAnonymouslyAppInfo.access$000(this.a) != null) {
        break label85;
      }
      paramString = null;
      label66:
      if ((paramString instanceof BaseActivity)) {
        break label103;
      }
    }
    label85:
    label103:
    do
    {
      return;
      l = paramTroopInfo.dwGroupFlagExt;
      break;
      paramString = (Activity)AskAnonymouslyAppInfo.access$000(this.a).get();
      break label66;
      paramArrayOfObject = ((BaseActivity)paramString).app;
      if (!paramBoolean) {
        paramTroopInfo = ((TroopManager)paramArrayOfObject.getManager(QQManagerFactory.TROOP_MANAGER)).c(paramLong + "");
      }
      if ((paramTroopInfo != null) && (AskAnonymousUtil.a(paramTroopInfo.dwGroupFlagExt))) {}
      for (paramInt1 = 1; paramInt1 == 0; paramInt1 = 0)
      {
        QQToast.a(BaseApplicationImpl.getApplication(), 2131698584, 1).a();
        return;
      }
    } while (!QQBrowserActivity.checkNotFrequentlyThenEnter(1000L));
    paramTroopInfo = new Intent(BaseApplicationImpl.getContext(), QQBrowserActivity.class);
    paramTroopInfo.putExtra("url", String.format("https://qun.qq.com/v2/anonymousqa/edit?_wv=16777218&_wwv=1&_cwv=8&gc=%s", new Object[] { paramLong + "" }));
    paramString.startActivity(paramTroopInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.pluspanel.appinfo.AskAnonymouslyAppInfo.1
 * JD-Core Version:    0.7.0.1
 */