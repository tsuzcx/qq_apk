package com.tencent.mobileqq.troop.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import com.tencent.mobileqq.WebSsoBody.WebSsoResponseBody;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.troop.utils.TroopBarUtils;
import com.tencent.mobileqq.widget.QQToast;
import mqq.observer.BusinessObserver;
import org.json.JSONObject;

class TroopBarCommentWindow$1
  implements BusinessObserver
{
  TroopBarCommentWindow$1(TroopBarCommentWindow paramTroopBarCommentWindow) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    this.a.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
    this.a.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getString(2131696272);
    if (paramBoolean) {}
    try
    {
      paramBundle = paramBundle.getByteArray("data");
      if (paramBundle != null)
      {
        Object localObject = new WebSsoBody.WebSsoResponseBody();
        ((WebSsoBody.WebSsoResponseBody)localObject).mergeFrom(paramBundle);
        paramInt = ((WebSsoBody.WebSsoResponseBody)localObject).ret.get();
        paramBundle = new JSONObject(((WebSsoBody.WebSsoResponseBody)localObject).data.get());
        if (paramInt != 0)
        {
          localObject = paramBundle.optString("msg");
          paramBundle = (Bundle)localObject;
          if (TextUtils.isEmpty((CharSequence)localObject)) {
            paramBundle = this.a.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getString(2131696273, new Object[] { Integer.valueOf(paramInt) });
          }
        }
        else
        {
          paramBundle = paramBundle.getJSONObject("result");
          TroopBarUtils.a("two_comment", "suc", this.a.d, this.a.h, "", "");
          this.a.jdField_a_of_type_Boolean = true;
          this.a.a(this.a.jdField_c_of_type_JavaLangString, paramBundle.toString(), true);
          this.a.dismiss();
        }
      }
      else
      {
        paramBundle = this.a.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getString(2131696273, new Object[] { Integer.valueOf(9991) });
      }
    }
    catch (Exception paramBundle)
    {
      break label255;
    }
    paramBundle = this.a.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getString(2131696273, new Object[] { Integer.valueOf(9992) });
    break label281;
    label255:
    paramBundle = this.a.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getString(2131696273, new Object[] { Integer.valueOf(9992) });
    label281:
    QQToast.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, 1, paramBundle, 0).b(this.a.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getTitleBarHeight());
    TroopBarUtils.a("two_comment", "fail", this.a.d, "4", "", "");
    this.a.jdField_c_of_type_Boolean = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopBarCommentWindow.1
 * JD-Core Version:    0.7.0.1
 */