package com.tencent.mobileqq.nearby.profilecard;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import com.tencent.mobileqq.WebSsoBody.WebSsoResponseBody;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.nearby.NearbyCardManager;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;
import mqq.observer.BusinessObserver;
import org.json.JSONObject;

class NearbyProfileDisplayTribePanel$18
  implements BusinessObserver
{
  NearbyProfileDisplayTribePanel$18(NearbyProfileDisplayTribePanel paramNearbyProfileDisplayTribePanel) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.i("NearbyProfileDisplayTribePanel", 2, "type = [" + paramInt + "], isSuccess = [" + paramBoolean + "], bundle = [" + paramBundle + "]");
    }
    Object localObject;
    if (paramBoolean)
    {
      try
      {
        ((NearbyCardManager)this.a.a.app.getManager(QQManagerFactory.NEARBY_CARD_MANAGER)).d.put(this.a.a.app.getCurrentAccountUin(), Integer.valueOf(1));
        paramBundle = paramBundle.getByteArray("data");
        if (paramBundle == null) {
          break label545;
        }
        localObject = new WebSsoBody.WebSsoResponseBody();
        ((WebSsoBody.WebSsoResponseBody)localObject).mergeFrom(paramBundle);
        paramInt = ((WebSsoBody.WebSsoResponseBody)localObject).ret.get();
        paramBundle = new JSONObject(((WebSsoBody.WebSsoResponseBody)localObject).data.get());
        if (QLog.isColorLevel()) {
          QLog.i("NearbyProfileDisplayTribePanel", 2, "retCode = [" + paramInt + "]");
        }
        if (paramInt == 0) {
          break label303;
        }
        paramBundle = paramBundle.optString("msg");
        if (!TextUtils.isEmpty(paramBundle))
        {
          QQToast.a(this.a.a, 1, "" + paramBundle, 1).a();
          return;
        }
        QQToast.a(this.a.a, 1, HardCodeUtil.a(2131707383), 1).a();
        return;
      }
      catch (Exception paramBundle)
      {
        QQToast.a(this.a.a, 1, HardCodeUtil.a(2131707319), 1).a();
        if (!QLog.isColorLevel()) {
          break label588;
        }
      }
      QLog.e("NearbyProfileDisplayTribePanel", 2, "未知异常，请稍后重试", paramBundle);
      return;
      label303:
      if (paramBundle.optInt("retcode") == 0)
      {
        paramBundle = this.a;
        if (NearbyProfileDisplayTribePanel.a(this.a)) {
          break label589;
        }
      }
    }
    label545:
    label588:
    label589:
    for (paramBoolean = true;; paramBoolean = false)
    {
      NearbyProfileDisplayTribePanel.a(paramBundle, paramBoolean);
      localObject = this.a.a;
      if (NearbyProfileDisplayTribePanel.a(this.a)) {}
      for (paramBundle = HardCodeUtil.a(2131707348);; paramBundle = HardCodeUtil.a(2131707306))
      {
        QQToast.a((Context)localObject, 2, paramBundle, 1).a();
        NearbyProfileDisplayTribePanel.a(this.a, 1, 60);
        if ((!NearbyProfileDisplayTribePanel.a(this.a)) && (NearbyProfileDisplayTribePanel.a(this.a).getChildAt(2).getVisibility() != 0))
        {
          paramBundle = (Button)NearbyProfileDisplayTribePanel.a(this.a).getChildAt(1).findViewById(2131380726);
          paramBundle.setTextColor(this.a.a.getResources().getColor(2131167066));
          paramBundle.setBackgroundDrawable(this.a.a.getResources().getDrawable(2130839424));
        }
        if (!NearbyProfileDisplayTribePanel.a(this.a)) {
          break;
        }
        paramBundle = (Button)NearbyProfileDisplayTribePanel.a(this.a).getChildAt(1).findViewById(2131380726);
        paramBundle.setTextColor(this.a.a.getResources().getColor(2131167068));
        paramBundle.setBackgroundDrawable(this.a.a.getResources().getDrawable(2130839463));
        return;
      }
      QQToast.a(this.a.a, 1, HardCodeUtil.a(2131707315), 1).a();
      return;
      QQToast.a(this.a.a, 1, HardCodeUtil.a(2131707321), 1).a();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayTribePanel.18
 * JD-Core Version:    0.7.0.1
 */