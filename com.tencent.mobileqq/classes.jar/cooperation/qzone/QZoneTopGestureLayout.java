package cooperation.qzone;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import bmuk;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;

public class QZoneTopGestureLayout
  extends TopGestureLayout
{
  private static boolean a = true;
  private static boolean b = true;
  
  public QZoneTopGestureLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public QZoneTopGestureLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public static void a(boolean paramBoolean)
  {
    b = paramBoolean;
  }
  
  public static void setBackEnabled(boolean paramBoolean)
  {
    a = paramBoolean;
  }
  
  public void a(Context paramContext)
  {
    a = true;
    b = true;
    this.mTopGestureDetector = new GestureDetector(paramContext, new bmuk(this, paramContext), new Handler(Looper.getMainLooper()));
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!b) {
      return false;
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.QZoneTopGestureLayout
 * JD-Core Version:    0.7.0.1
 */