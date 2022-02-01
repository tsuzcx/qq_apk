package cooperation.ilive.lite.module;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.ilive.interfaces.IAudienceRoomPager;

class IliveGuideModule$3
  implements ValueAnimator.AnimatorUpdateListener
{
  IliveGuideModule$3(IliveGuideModule paramIliveGuideModule, int paramInt1, IAudienceRoomPager paramIAudienceRoomPager, int paramInt2) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = this.jdField_a_of_type_Int;
    int j = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    this.jdField_a_of_type_ComTencentIliveInterfacesIAudienceRoomPager.scrollTo(0, this.b + (i - j));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.ilive.lite.module.IliveGuideModule.3
 * JD-Core Version:    0.7.0.1
 */