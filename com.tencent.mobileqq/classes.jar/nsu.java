import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.biz.qqstory.playvideo.StoryPlayVideoActivity;
import com.tencent.biz.qqstory.widget.circularreveal.CircularRevealCompatLayout;

public class nsu
  extends AnimatorListenerAdapter
{
  public nsu(StoryPlayVideoActivity paramStoryPlayVideoActivity, CircularRevealCompatLayout paramCircularRevealCompatLayout) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryWidgetCircularrevealCircularRevealCompatLayout.setVisibility(4);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nsu
 * JD-Core Version:    0.7.0.1
 */