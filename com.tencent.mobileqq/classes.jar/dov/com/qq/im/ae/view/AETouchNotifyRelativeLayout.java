package dov.com.qq.im.ae.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import bnsd;

public class AETouchNotifyRelativeLayout
  extends RelativeLayout
{
  private bnsd a;
  
  public AETouchNotifyRelativeLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public AETouchNotifyRelativeLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public AETouchNotifyRelativeLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent.getAction() == 0) && (this.a != null)) {
      this.a.a(paramMotionEvent);
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public void setIaeTouchNotify(bnsd parambnsd)
  {
    this.a = parambnsd;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.view.AETouchNotifyRelativeLayout
 * JD-Core Version:    0.7.0.1
 */