import android.app.Activity;
import android.content.Context;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import com.tencent.biz.pubaccount.util.SwipeBackLayout;
import com.tencent.mobileqq.webview.swift.WebViewFragment;

public class rvz
  extends GestureDetector.SimpleOnGestureListener
{
  private float jdField_a_of_type_Float;
  
  public rvz(SwipeBackLayout paramSwipeBackLayout, Context paramContext)
  {
    this.jdField_a_of_type_Float = (ViewConfiguration.get(paramContext).getScaledTouchSlop() * 2);
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if ((paramMotionEvent1 == null) || (paramMotionEvent2 == null)) {
      return super.onFling(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
    }
    float f1 = paramMotionEvent1.getX() - paramMotionEvent2.getX();
    float f2 = Math.abs((paramMotionEvent1.getY() - paramMotionEvent2.getY()) / f1);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (SwipeBackLayout.b(this.jdField_a_of_type_ComTencentBizPubaccountUtilSwipeBackLayout))
    {
      bool1 = bool2;
      if (SwipeBackLayout.c(this.jdField_a_of_type_ComTencentBizPubaccountUtilSwipeBackLayout))
      {
        bool1 = bool2;
        if (!this.jdField_a_of_type_ComTencentBizPubaccountUtilSwipeBackLayout.jdField_a_of_type_Rvd.a())
        {
          bool1 = bool2;
          if (this.jdField_a_of_type_ComTencentBizPubaccountUtilSwipeBackLayout.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment != null) {
            bool1 = this.jdField_a_of_type_ComTencentBizPubaccountUtilSwipeBackLayout.a(paramMotionEvent1);
          }
        }
      }
    }
    if ((!this.jdField_a_of_type_ComTencentBizPubaccountUtilSwipeBackLayout.d) || (paramFloat1 < 200.0F)) {
      return super.onFling(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
    }
    if ((f1 < 0.0F) && (f2 < 0.5F) && (SwipeBackLayout.b(this.jdField_a_of_type_ComTencentBizPubaccountUtilSwipeBackLayout)) && (SwipeBackLayout.c(this.jdField_a_of_type_ComTencentBizPubaccountUtilSwipeBackLayout)) && (!bool1))
    {
      if (!(this.jdField_a_of_type_ComTencentBizPubaccountUtilSwipeBackLayout.jdField_a_of_type_AndroidContentContext instanceof Activity)) {
        break label233;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountUtilSwipeBackLayout.c = true;
      this.jdField_a_of_type_ComTencentBizPubaccountUtilSwipeBackLayout.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.G();
      this.jdField_a_of_type_ComTencentBizPubaccountUtilSwipeBackLayout.a();
    }
    for (;;)
    {
      return super.onFling(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
      label233:
      if (this.jdField_a_of_type_ComTencentBizPubaccountUtilSwipeBackLayout.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment != null)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountUtilSwipeBackLayout.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.G();
        this.jdField_a_of_type_ComTencentBizPubaccountUtilSwipeBackLayout.a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rvz
 * JD-Core Version:    0.7.0.1
 */