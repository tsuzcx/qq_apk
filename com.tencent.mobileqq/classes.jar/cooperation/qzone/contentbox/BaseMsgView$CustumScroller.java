package cooperation.qzone.contentbox;

import android.content.Context;
import android.view.animation.Interpolator;
import android.widget.Scroller;

class BaseMsgView$CustumScroller
  extends Scroller
{
  public int mDuration;
  
  public BaseMsgView$CustumScroller(Context paramContext)
  {
    super(paramContext);
  }
  
  public BaseMsgView$CustumScroller(Context paramContext, Interpolator paramInterpolator)
  {
    super(paramContext, paramInterpolator);
  }
  
  public BaseMsgView$CustumScroller(Context paramContext, Interpolator paramInterpolator, boolean paramBoolean)
  {
    super(paramContext, paramInterpolator, paramBoolean);
  }
  
  public int getmDuration()
  {
    return this.mDuration;
  }
  
  public void setmDuration(int paramInt)
  {
    this.mDuration = paramInt;
  }
  
  public void startScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    startScroll(paramInt1, paramInt2, paramInt3, paramInt4, this.mDuration);
  }
  
  public void startScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    super.startScroll(paramInt1, paramInt2, paramInt3, paramInt4, this.mDuration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.contentbox.BaseMsgView.CustumScroller
 * JD-Core Version:    0.7.0.1
 */