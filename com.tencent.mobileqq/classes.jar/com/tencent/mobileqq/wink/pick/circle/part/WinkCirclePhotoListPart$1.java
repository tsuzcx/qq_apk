package com.tencent.mobileqq.wink.pick.circle.part;

import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import com.tencent.mobileqq.wink.pick.circle.view.NoScrollViewPager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class WinkCirclePhotoListPart$1
  implements RadioGroup.OnCheckedChangeListener
{
  WinkCirclePhotoListPart$1(WinkCirclePhotoListPart paramWinkCirclePhotoListPart) {}
  
  public void onCheckedChanged(RadioGroup paramRadioGroup, int paramInt)
  {
    if (WinkCirclePhotoListPart.a(this.a).getId() == paramInt)
    {
      WinkCirclePhotoListPart.b(this.a).setCurrentItem(0);
      WinkCirclePhotoListPart.a(this.a, 0);
    }
    else if (WinkCirclePhotoListPart.c(this.a).getId() == paramInt)
    {
      WinkCirclePhotoListPart.b(this.a).setCurrentItem(1);
      WinkCirclePhotoListPart.a(this.a, 1);
    }
    else if (WinkCirclePhotoListPart.d(this.a).getId() == paramInt)
    {
      WinkCirclePhotoListPart.b(this.a).setCurrentItem(2);
      WinkCirclePhotoListPart.a(this.a, 2);
    }
    EventCollector.getInstance().onCheckedChanged(paramRadioGroup, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.pick.circle.part.WinkCirclePhotoListPart.1
 * JD-Core Version:    0.7.0.1
 */