package dov.com.qq.im.ae.play;

import android.support.v4.view.ViewPager.SimpleOnPageChangeListener;
import com.tencent.image.ApngImage;

class AEPlayShowPart$3
  extends ViewPager.SimpleOnPageChangeListener
{
  AEPlayShowPart$3(AEPlayShowPart paramAEPlayShowPart) {}
  
  public void onPageScrollStateChanged(int paramInt)
  {
    if (paramInt == 0)
    {
      ApngImage.resumeAll();
      return;
    }
    ApngImage.pauseAll();
  }
  
  public void onPageSelected(int paramInt)
  {
    AEPlayShowPart.access$200(this.this$0).onTabChecked(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.play.AEPlayShowPart.3
 * JD-Core Version:    0.7.0.1
 */