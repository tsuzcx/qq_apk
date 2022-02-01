package com.tencent.mobileqq.kandian.biz.atlas;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdUtilService;
import com.tencent.mobileqq.qroute.QRoute;

class ReadInJoySettingActivity$11
  implements CompoundButton.OnCheckedChangeListener
{
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).openFilterPatchAdReq();
      return;
    }
    ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).closeFilterPatchAdReq();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.atlas.ReadInJoySettingActivity.11
 * JD-Core Version:    0.7.0.1
 */