import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.tencent.biz.qqstory.playvideo.StoryPlayVideoActivity;
import com.tencent.biz.qqstory.widget.circularreveal.CircularRevealCompatLayout;

public class nsp
  implements ViewTreeObserver.OnPreDrawListener
{
  public nsp(StoryPlayVideoActivity paramStoryPlayVideoActivity) {}
  
  public boolean onPreDraw()
  {
    this.a.a(this.a.a, this.a.j, this.a.i, this.a.k, this.a.l, this.a.m);
    this.a.a.getViewTreeObserver().removeOnPreDrawListener(this);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nsp
 * JD-Core Version:    0.7.0.1
 */