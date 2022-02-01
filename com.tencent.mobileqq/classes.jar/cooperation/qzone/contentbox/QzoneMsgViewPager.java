package cooperation.qzone.contentbox;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.viewpager.widget.ViewPager;

public class QzoneMsgViewPager
  extends ViewPager
{
  public QzoneMsgViewPager(Context paramContext)
  {
    super(paramContext);
  }
  
  public QzoneMsgViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     cooperation.qzone.contentbox.QzoneMsgViewPager
 * JD-Core Version:    0.7.0.1
 */