package com.tencent.mobileqq.kandian.biz.atlas;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.repo.common.RIJUserInfoSp;
import org.json.JSONException;
import org.json.JSONObject;

class ReadInJoySettingActivity$2
  implements CompoundButton.OnCheckedChangeListener
{
  ReadInJoySettingActivity$2(ReadInJoySettingActivity paramReadInJoySettingActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    RIJUserInfoSp.a(paramBoolean ^ true);
    paramCompoundButton = new JSONObject();
    int i;
    if (paramBoolean) {
      i = 1;
    }
    for (;;)
    {
      try
      {
        paramCompoundButton.put("click_opt", i);
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
      PublicAccountReportUtils.a(null, "", "0X800A80B", "0X800A80B", 0, 0, "", "", "", paramCompoundButton.toString(), false);
      return;
      i = 2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.atlas.ReadInJoySettingActivity.2
 * JD-Core Version:    0.7.0.1
 */