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
import com.tencent.mobileqq.nearby.INearbyCardManager;
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
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("type = [");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append("], isSuccess = [");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append("], bundle = [");
      ((StringBuilder)localObject).append(paramBundle);
      ((StringBuilder)localObject).append("]");
      QLog.i("NearbyProfileDisplayTribePanel", 2, ((StringBuilder)localObject).toString());
    }
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        ((INearbyCardManager)this.a.e.app.getManager(QQManagerFactory.NEARBY_CARD_MANAGER)).f().put(this.a.e.app.getCurrentAccountUin(), Integer.valueOf(1));
        paramBundle = paramBundle.getByteArray("data");
        if (paramBundle != null)
        {
          localObject = new WebSsoBody.WebSsoResponseBody();
          ((WebSsoBody.WebSsoResponseBody)localObject).mergeFrom(paramBundle);
          paramInt = ((WebSsoBody.WebSsoResponseBody)localObject).ret.get();
          paramBundle = new JSONObject(((WebSsoBody.WebSsoResponseBody)localObject).data.get());
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("retCode = [");
            ((StringBuilder)localObject).append(paramInt);
            ((StringBuilder)localObject).append("]");
            QLog.i("NearbyProfileDisplayTribePanel", 2, ((StringBuilder)localObject).toString());
          }
          if (paramInt != 0)
          {
            paramBundle = paramBundle.optString("msg");
            if (!TextUtils.isEmpty(paramBundle))
            {
              localObject = this.a.e;
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("");
              localStringBuilder.append(paramBundle);
              QQToast.makeText((Context)localObject, 1, localStringBuilder.toString(), 1).show();
              return;
            }
            QQToast.makeText(this.a.e, 1, HardCodeUtil.a(2131905226), 1).show();
            return;
          }
          if (paramBundle.optInt("retcode") == 0)
          {
            paramBundle = this.a;
            if (NearbyProfileDisplayTribePanel.m(this.a)) {
              break label646;
            }
            paramBoolean = true;
            NearbyProfileDisplayTribePanel.a(paramBundle, paramBoolean);
            localObject = this.a.e;
            if (NearbyProfileDisplayTribePanel.m(this.a)) {
              paramBundle = HardCodeUtil.a(2131905193);
            } else {
              paramBundle = HardCodeUtil.a(2131905154);
            }
            QQToast.makeText((Context)localObject, 2, paramBundle, 1).show();
            NearbyProfileDisplayTribePanel.a(this.a, 1, 60);
          }
          if ((!NearbyProfileDisplayTribePanel.m(this.a)) && (NearbyProfileDisplayTribePanel.n(this.a).getChildAt(2).getVisibility() != 0))
          {
            paramBundle = (Button)NearbyProfileDisplayTribePanel.n(this.a).getChildAt(1).findViewById(2131448897);
            paramBundle.setTextColor(this.a.e.getResources().getColor(2131168041));
            paramBundle.setBackgroundDrawable(this.a.e.getResources().getDrawable(2130839460));
          }
          if (!NearbyProfileDisplayTribePanel.m(this.a)) {
            break label645;
          }
          paramBundle = (Button)NearbyProfileDisplayTribePanel.n(this.a).getChildAt(1).findViewById(2131448897);
          paramBundle.setTextColor(this.a.e.getResources().getColor(2131168043));
          paramBundle.setBackgroundDrawable(this.a.e.getResources().getDrawable(2130839499));
          return;
        }
        QQToast.makeText(this.a.e, 1, HardCodeUtil.a(2131905163), 1).show();
        return;
      }
      catch (Exception paramBundle)
      {
        QQToast.makeText(this.a.e, 1, HardCodeUtil.a(2131905166), 1).show();
        if (!QLog.isColorLevel()) {
          break label645;
        }
        QLog.e("NearbyProfileDisplayTribePanel", 2, "未知异常，请稍后重试", paramBundle);
      }
      QQToast.makeText(this.a.e, 1, HardCodeUtil.a(2131905168), 1).show();
      return;
      label645:
      return;
      label646:
      paramBoolean = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayTribePanel.18
 * JD-Core Version:    0.7.0.1
 */