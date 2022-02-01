package com.tencent.mobileqq.kandian.biz.ugc.account;

import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.kandian.biz.pts.lite.PTSLiteEventTypeHandler;
import com.tencent.pts.core.PTSComposer;
import com.tencent.pts.core.lite.DefaultPTSLiteEventListener;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class RIJUGCPopupPtsLiteBuilder$1
  extends DefaultPTSLiteEventListener
{
  RIJUGCPopupPtsLiteBuilder$1(RIJUGCPopupPtsLiteBuilder paramRIJUGCPopupPtsLiteBuilder) {}
  
  public void onTapEventTriggered(String paramString, HashMap<String, String> paramHashMap, View paramView, PTSComposer paramPTSComposer)
  {
    PTSLiteEventTypeHandler.a.a(paramPTSComposer, paramHashMap);
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("RIJUGCPopupPtsLiteBuilder", 1, "[onTapEventTriggered], identifier is empty.");
      return;
    }
    if (TextUtils.equals(paramString, "editPersonalProfile"))
    {
      RIJUGCAddAccountFragment.b(RIJUGCPopupPtsLiteBuilder.a(this.a));
      RIJUGCAddAccountFragment.a(RIJUGCAddAccountFragment.c);
      return;
    }
    if (TextUtils.equals(paramString, "useOriginalAccount"))
    {
      RIJUGCAddAccountFragment.a(RIJUGCPopupPtsLiteBuilder.a(this.a));
      RIJUGCAddAccountFragment.a(RIJUGCAddAccountFragment.b);
      if ((RIJUGCPopupPtsLiteBuilder.a(this.a) instanceof BaseActivity)) {
        ((BaseActivity)RIJUGCPopupPtsLiteBuilder.a(this.a)).finish();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.account.RIJUGCPopupPtsLiteBuilder.1
 * JD-Core Version:    0.7.0.1
 */