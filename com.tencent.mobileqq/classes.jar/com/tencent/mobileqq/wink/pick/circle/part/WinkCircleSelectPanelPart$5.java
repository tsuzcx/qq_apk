package com.tencent.mobileqq.wink.pick.circle.part;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.richframework.part.utils.FastClickUtils;
import com.tencent.mobileqq.wink.pick.circle.WinkCirclePhotoListLogic;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class WinkCircleSelectPanelPart$5
  implements View.OnClickListener
{
  WinkCircleSelectPanelPart$5(WinkCircleSelectPanelPart paramWinkCircleSelectPanelPart) {}
  
  public void onClick(View paramView)
  {
    if (WinkCircleSelectPanelPart.d(this.a) != null)
    {
      if (FastClickUtils.a("WinkCircleSelectPanelPartautoTempClick", WinkCircleSelectPanelPart.b))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("WinkCircleSelectPanelPartautoTempClick");
        localStringBuilder.append("[changeOperationShow] operate too fast to handle, try again later.");
        QLog.d("WinkCircleSelectPanelPart", 1, localStringBuilder.toString());
      }
      else
      {
        WinkCircleSelectPanelPart.e(this.a).q();
      }
    }
    else {
      QLog.d("WinkCircleSelectPanelPart", 1, "initMove, mPhotoListLogic == null");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.pick.circle.part.WinkCircleSelectPanelPart.5
 * JD-Core Version:    0.7.0.1
 */