package com.tencent.mobileqq.jsp;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import org.json.JSONObject;

class UiApiPlugin$20
  implements View.OnClickListener
{
  UiApiPlugin$20(UiApiPlugin paramUiApiPlugin, JSONObject paramJSONObject) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqJspUiApiPlugin.b(this.jdField_a_of_type_OrgJsonJSONObject);
    String str = this.jdField_a_of_type_OrgJsonJSONObject.optString("callback");
    if (!TextUtils.isEmpty(str)) {
      this.jdField_a_of_type_ComTencentMobileqqJspUiApiPlugin.callJs(str, new String[] { String.valueOf(0) });
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.UiApiPlugin.20
 * JD-Core Version:    0.7.0.1
 */