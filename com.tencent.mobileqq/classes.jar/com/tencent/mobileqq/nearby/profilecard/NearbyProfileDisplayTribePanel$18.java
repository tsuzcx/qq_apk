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
        ((INearbyCardManager)this.a.a.app.getManager(QQManagerFactory.NEARBY_CARD_MANAGER)).a().put(this.a.a.app.getCurrentAccountUin(), Integer.valueOf(1));
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
              localObject = this.a.a;
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("");
              localStringBuilder.append(paramBundle);
              QQToast.a((Context)localObject, 1, localStringBuilder.toString(), 1).a();
              return;
            }
            QQToast.a(this.a.a, 1, HardCodeUtil.a(2131707408), 1).a();
            return;
          }
          if (paramBundle.optInt("retcode") == 0)
          {
            paramBundle = this.a;
            if (NearbyProfileDisplayTribePanel.a(this.a)) {
              break label646;
            }
            paramBoolean = true;
            NearbyProfileDisplayTribePanel.a(paramBundle, paramBoolean);
            localObject = this.a.a;
            if (NearbyProfileDisplayTribePanel.a(this.a)) {
              paramBundle = HardCodeUtil.a(2131707373);
            } else {
              paramBundle = HardCodeUtil.a(2131707331);
            }
            QQToast.a((Context)localObject, 2, paramBundle, 1).a();
            NearbyProfileDisplayTribePanel.a(this.a, 1, 60);
          }
          if ((!NearbyProfileDisplayTribePanel.a(this.a)) && (NearbyProfileDisplayTribePanel.a(this.a).getChildAt(2).getVisibility() != 0))
          {
            paramBundle = (Button)NearbyProfileDisplayTribePanel.a(this.a).getChildAt(1).findViewById(2131379994);
            paramBundle.setTextColor(this.a.a.getResources().getColor(2131167089));
            paramBundle.setBackgroundDrawable(this.a.a.getResources().getDrawable(2130839280));
          }
          if (!NearbyProfileDisplayTribePanel.a(this.a)) {
            break label645;
          }
          paramBundle = (Button)NearbyProfileDisplayTribePanel.a(this.a).getChildAt(1).findViewById(2131379994);
          paramBundle.setTextColor(this.a.a.getResources().getColor(2131167091));
          paramBundle.setBackgroundDrawable(this.a.a.getResources().getDrawable(2130839319));
          return;
        }
        QQToast.a(this.a.a, 1, HardCodeUtil.a(2131707340), 1).a();
        return;
      }
      catch (Exception paramBundle)
      {
        QQToast.a(this.a.a, 1, HardCodeUtil.a(2131707344), 1).a();
        if (!QLog.isColorLevel()) {
          break label645;
        }
        QLog.e("NearbyProfileDisplayTribePanel", 2, "未知异常，请稍后重试", paramBundle);
      }
      QQToast.a(this.a.a, 1, HardCodeUtil.a(2131707346), 1).a();
      return;
      label645:
      return;
      label646:
      paramBoolean = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayTribePanel.18
 * JD-Core Version:    0.7.0.1
 */