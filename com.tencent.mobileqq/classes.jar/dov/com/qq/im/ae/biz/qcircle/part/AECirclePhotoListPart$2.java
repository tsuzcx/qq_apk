package dov.com.qq.im.ae.biz.qcircle.part;

import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.widget.RadioGroup;

class AECirclePhotoListPart$2
  implements ViewPager.OnPageChangeListener
{
  AECirclePhotoListPart$2(AECirclePhotoListPart paramAECirclePhotoListPart) {}
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    if ((AECirclePhotoListPart.a(this.a) != null) && (AECirclePhotoListPart.a(this.a).getChildCount() > paramInt)) {
      AECirclePhotoListPart.a(this.a).getChildAt(paramInt).performClick();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.biz.qcircle.part.AECirclePhotoListPart.2
 * JD-Core Version:    0.7.0.1
 */