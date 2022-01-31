package cooperation.qzone;

import amce;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.GestureDetector;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;

public class QZoneTopGestureLayout
  extends TopGestureLayout
{
  private static boolean a = true;
  
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
    a = paramBoolean;
  }
  
  protected void a(Context paramContext)
  {
    a = true;
    this.mTopGestureDetector = new GestureDetector(paramContext, new amce(this, paramContext), new Handler(Looper.getMainLooper()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.QZoneTopGestureLayout
 * JD-Core Version:    0.7.0.1
 */