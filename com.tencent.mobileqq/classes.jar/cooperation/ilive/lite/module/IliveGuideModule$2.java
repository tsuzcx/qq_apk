package cooperation.ilive.lite.module;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.ilive.interfaces.IAudienceRoomPager;

class IliveGuideModule$2
  implements ValueAnimator.AnimatorUpdateListener
{
  IliveGuideModule$2(IliveGuideModule paramIliveGuideModule, int paramInt1, IAudienceRoomPager paramIAudienceRoomPager, int paramInt2) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = this.a;
    int j = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    this.b.scrollTo(0, this.c + (i - j));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.ilive.lite.module.IliveGuideModule.2
 * JD-Core Version:    0.7.0.1
 */