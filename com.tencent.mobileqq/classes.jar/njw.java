import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.widget.TextView;
import com.tencent.avgame.gameroom.seat.MemberItemView;
import com.tencent.avgame.gameroom.seat.TalkingEffectLayout;

public class njw
  implements Animator.AnimatorListener
{
  public njw(MemberItemView paramMemberItemView) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    this.a.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.a.jdField_a_of_type_ComTencentAvgameGameroomSeatTalkingEffectLayout.setVisibility(4);
    this.a.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    this.a.jdField_a_of_type_ComTencentAvgameGameroomSeatTalkingEffectLayout.setVisibility(0);
    this.a.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-14558778);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     njw
 * JD-Core Version:    0.7.0.1
 */