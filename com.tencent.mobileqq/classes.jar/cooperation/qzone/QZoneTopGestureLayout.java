package cooperation.qzone;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;

public class QZoneTopGestureLayout
  extends TopGestureLayout
{
  private static boolean backEnabled = true;
  private static boolean shallIntercept = true;
  
  public QZoneTopGestureLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public QZoneTopGestureLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public static void setBackEnabled(boolean paramBoolean)
  {
    backEnabled = paramBoolean;
  }
  
  public static void shouldInterceptEvent(boolean paramBoolean)
  {
    shallIntercept = paramBoolean;
  }
  
  public void init(Context paramContext)
  {
    backEnabled = true;
    shallIntercept = true;
    this.mTopGestureDetector = new GestureDetector(paramContext, new QZoneTopGestureLayout.QZoneTopGestureDetector(this, paramContext), new Handler(Looper.getMainLooper()));
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!shallIntercept) {
      return false;
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.QZoneTopGestureLayout
 * JD-Core Version:    0.7.0.1
 */