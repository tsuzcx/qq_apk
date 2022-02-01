package com.tencent.mobileqq.kandian.biz.atlas;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdUtilService;
import com.tencent.mobileqq.qroute.QRoute;

class ReadInJoySettingActivity$9
  implements CompoundButton.OnCheckedChangeListener
{
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).openSuperMaskSwitch();
      return;
    }
    ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).closeSuperMaskSwitch();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.atlas.ReadInJoySettingActivity.9
 * JD-Core Version:    0.7.0.1
 */