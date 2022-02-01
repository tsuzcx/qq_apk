package com.tencent.mobileqq.nearby;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.WebSsoBody.WebSsoResponseBody;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;
import org.json.JSONObject;

class NearbyUtilsReal$1$1
  implements BusinessObserver
{
  NearbyUtilsReal$1$1(NearbyUtilsReal.1 param1) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramBoolean) {
      try
      {
        paramBundle = paramBundle.getByteArray("data");
        if (paramBundle != null)
        {
          localObject = new WebSsoBody.WebSsoResponseBody();
          ((WebSsoBody.WebSsoResponseBody)localObject).mergeFrom(paramBundle);
          paramInt = ((WebSsoBody.WebSsoResponseBody)localObject).ret.get();
          paramBundle = new JSONObject(((WebSsoBody.WebSsoResponseBody)localObject).data.get());
          if (paramInt != 0)
          {
            paramBundle = paramBundle.optString("msg");
            if (!TextUtils.isEmpty(paramBundle))
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("get nearby_sig,targetUin:");
              ((StringBuilder)localObject).append(this.a.jdField_a_of_type_JavaLangString);
              ((StringBuilder)localObject).append(", errMsg:");
              ((StringBuilder)localObject).append(paramBundle);
              QLog.d("NearbyUtilsQ.nearby.nearby_sig", 2, ((StringBuilder)localObject).toString());
            }
          }
          else
          {
            paramBundle = paramBundle.optString("signature");
            if (QLog.isColorLevel())
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("get nearby_sig,targetUin:");
              ((StringBuilder)localObject).append(this.a.jdField_a_of_type_JavaLangString);
              ((StringBuilder)localObject).append("signature:");
              ((StringBuilder)localObject).append(paramBundle);
              QLog.d("NearbyUtilsQ.nearby.nearby_sig", 2, ((StringBuilder)localObject).toString());
            }
            try
            {
              if (TextUtils.isEmpty(paramBundle)) {
                return;
              }
              if (this.a.jdField_a_of_type_Int == 0)
              {
                this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().g(this.a.jdField_a_of_type_JavaLangString, Base64Util.decode(paramBundle, 0));
                return;
              }
              this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().h(this.a.jdField_a_of_type_JavaLangString, Base64Util.decode(paramBundle, 0));
              return;
            }
            catch (Exception paramBundle)
            {
              if (!QLog.isColorLevel()) {
                return;
              }
            }
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("get nearby_sig Exception:");
            ((StringBuilder)localObject).append(paramBundle.toString());
            QLog.e("NearbyUtilsQ.nearby.nearby_sig", 2, ((StringBuilder)localObject).toString());
            return;
          }
        }
      }
      catch (Exception paramBundle)
      {
        Object localObject;
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("get nearby_sig Exception");
          ((StringBuilder)localObject).append(paramBundle.toString());
          QLog.d("NearbyUtilsQ.nearby.nearby_sig", 2, ((StringBuilder)localObject).toString());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.NearbyUtilsReal.1.1
 * JD-Core Version:    0.7.0.1
 */