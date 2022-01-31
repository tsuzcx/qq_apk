import android.os.Handler;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.RelativeLayout;
import com.tencent.biz.qqstory.playvideo.StoryPlayVideoActivity;
import com.tencent.biz.qqstory.widget.circularreveal.CircularRevealCompatLayout;

public class nod
  implements ViewTreeObserver.OnPreDrawListener
{
  public nod(StoryPlayVideoActivity paramStoryPlayVideoActivity) {}
  
  public boolean onPreDraw()
  {
    this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(0);
    this.a.jdField_a_of_type_AndroidOsHandler.postDelayed(new noe(this), 100L);
    this.a.h();
    this.a.jdField_a_of_type_ComTencentBizQqstoryWidgetCircularrevealCircularRevealCompatLayout.getViewTreeObserver().removeOnPreDrawListener(this);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nod
 * JD-Core Version:    0.7.0.1
 */