import android.graphics.Bitmap;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.qqstory.playvideo.CustomViewPager;
import com.tencent.biz.qqstory.playvideo.StoryPlayVideoActivity;

public class nmu
  implements Animation.AnimationListener
{
  public nmu(StoryPlayVideoActivity paramStoryPlayVideoActivity) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.setResult(-1);
    this.a.finish();
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(0);
    if (this.a.a() != null)
    {
      this.a.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      paramAnimation = (RelativeLayout.LayoutParams)this.a.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
      paramAnimation.width = this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.getWidth();
      paramAnimation.height = (paramAnimation.width * this.a.a().getHeight() / this.a.a().getWidth());
      this.a.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(paramAnimation);
      this.a.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(this.a.a());
    }
    paramAnimation = new AlphaAnimation(1.0F, 0.0F);
    paramAnimation.setFillAfter(true);
    paramAnimation.setDuration(300L);
    this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoCustomViewPager.startAnimation(paramAnimation);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nmu
 * JD-Core Version:    0.7.0.1
 */