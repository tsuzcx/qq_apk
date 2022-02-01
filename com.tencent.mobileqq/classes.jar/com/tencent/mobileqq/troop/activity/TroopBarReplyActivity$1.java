package com.tencent.mobileqq.troop.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.mobileqq.WebSsoBody.WebSsoResponseBody;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.troop.utils.TroopBarUtils;
import com.tencent.mobileqq.widget.QQToast;
import java.util.ArrayList;
import mqq.observer.BusinessObserver;
import org.json.JSONObject;

class TroopBarReplyActivity$1
  implements BusinessObserver
{
  TroopBarReplyActivity$1(TroopBarReplyActivity paramTroopBarReplyActivity) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    this.a.a(false);
    this.a.rightViewText.setEnabled(true);
    TroopBarReplyActivity localTroopBarReplyActivity = this.a;
    this.a.getString(2131696253);
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        paramBundle = paramBundle.getByteArray("data");
        if (paramBundle == null) {
          continue;
        }
        localObject = new WebSsoBody.WebSsoResponseBody();
        ((WebSsoBody.WebSsoResponseBody)localObject).mergeFrom(paramBundle);
        paramInt = ((WebSsoBody.WebSsoResponseBody)localObject).ret.get();
        paramBundle = new JSONObject(((WebSsoBody.WebSsoResponseBody)localObject).data.get());
        if (paramInt == 0) {
          continue;
        }
        localObject = paramBundle.optString("msg");
        paramBundle = (Bundle)localObject;
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          paramBundle = this.a.getString(2131696254, new Object[] { Integer.valueOf(paramInt) });
        }
      }
      catch (Exception paramBundle)
      {
        Object localObject;
        paramBundle = this.a.getString(2131696254, new Object[] { Integer.valueOf(9992) });
        continue;
        paramBundle = this.a.getString(2131696254, new Object[] { Integer.valueOf(9991) });
        continue;
      }
      this.a.jdField_a_of_type_Boolean = false;
      QQToast.a(localTroopBarReplyActivity, 1, paramBundle, 0).b(this.a.getTitleBarHeight());
      return;
      paramBundle = paramBundle.getJSONObject("result");
      localObject = new StringBuffer();
      if ((this.a.jdField_a_of_type_JavaUtilArrayList != null) && (this.a.jdField_a_of_type_JavaUtilArrayList.size() > 0)) {
        ((StringBuffer)localObject).append("0");
      }
      if (this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI != null) {
        ((StringBuffer)localObject).append("1");
      }
      if (!TextUtils.isEmpty(TroopBarUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetXEditTextExWithListener))) {
        ((StringBuffer)localObject).append("2");
      }
      if (this.a.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo != null) {
        ((StringBuffer)localObject).append("5");
      }
      ((StringBuffer)localObject).append("8");
      this.a.b = true;
      paramBundle.optString("pid");
      paramBundle.optString("bid");
      localObject = new Intent();
      ((Intent)localObject).putExtra("result", paramBundle.toString());
      this.a.setResult(-1, (Intent)localObject);
      this.a.finish();
      this.a.jdField_a_of_type_Boolean = false;
      return;
      paramBundle = this.a.getString(2131696254, new Object[] { Integer.valueOf(9992) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopBarReplyActivity.1
 * JD-Core Version:    0.7.0.1
 */