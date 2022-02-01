package dov.com.qq.im.ae.biz.qcircle.part;

import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.ae.view.NoScrollViewPager;

class AECirclePhotoListPart$1
  implements RadioGroup.OnCheckedChangeListener
{
  AECirclePhotoListPart$1(AECirclePhotoListPart paramAECirclePhotoListPart) {}
  
  public void onCheckedChanged(RadioGroup paramRadioGroup, int paramInt)
  {
    if (AECirclePhotoListPart.a(this.a).getId() == paramInt)
    {
      AECirclePhotoListPart.a(this.a).setCurrentItem(0);
      AECirclePhotoListPart.a(this.a, 0);
    }
    for (;;)
    {
      EventCollector.getInstance().onCheckedChanged(paramRadioGroup, paramInt);
      return;
      if (AECirclePhotoListPart.b(this.a).getId() == paramInt)
      {
        AECirclePhotoListPart.a(this.a).setCurrentItem(1);
        AECirclePhotoListPart.a(this.a, 1);
      }
      else if (AECirclePhotoListPart.c(this.a).getId() == paramInt)
      {
        AECirclePhotoListPart.a(this.a).setCurrentItem(2);
        AECirclePhotoListPart.a(this.a, 2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.biz.qcircle.part.AECirclePhotoListPart.1
 * JD-Core Version:    0.7.0.1
 */