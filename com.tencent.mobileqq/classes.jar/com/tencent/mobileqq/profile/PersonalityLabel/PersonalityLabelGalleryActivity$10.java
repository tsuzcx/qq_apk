package com.tencent.mobileqq.profile.PersonalityLabel;

import android.animation.Animator;
import android.os.Handler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.D8SafeAnimatorListener;
import java.util.Iterator;
import java.util.List;

class PersonalityLabelGalleryActivity$10
  extends D8SafeAnimatorListener
{
  PersonalityLabelGalleryActivity$10(PersonalityLabelGalleryActivity paramPersonalityLabelGalleryActivity, long paramLong) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    paramAnimator = PersonalityLabelGalleryActivity.b(this.b).personalityLabelInfos.iterator();
    while (paramAnimator.hasNext())
    {
      PersonalityLabelInfo localPersonalityLabelInfo = (PersonalityLabelInfo)paramAnimator.next();
      if (this.a == localPersonalityLabelInfo.id)
      {
        PersonalityLabelGalleryActivity.b(this.b).personalityLabelInfos.remove(localPersonalityLabelInfo);
        paramAnimator = PersonalityLabelGalleryActivity.b(this.b);
        paramAnimator.remainCount += 1;
        paramAnimator = this.b;
        paramAnimator.a(PersonalityLabelGalleryActivity.b(paramAnimator), false);
        PersonalityLabelGalleryActivity.b(this.b, true);
        if ((!this.b.c()) && (this.b.i)) {
          PersonalityLabelGalleryActivity.c(this.b, false);
        }
        if (this.b.g.hasMessages(0)) {
          this.b.g.removeMessages(0);
        }
        paramAnimator = this.b.g.obtainMessage(0, PersonalityLabelGalleryActivity.b(this.b));
        this.b.g.sendMessageDelayed(paramAnimator, 500L);
      }
    }
    ((PersonalityLabelHandler)this.b.app.getBusinessHandler(BusinessHandlerFactory.PROFILE_PERSONALITY_LABEL)).a(this.a);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelGalleryActivity.10
 * JD-Core Version:    0.7.0.1
 */