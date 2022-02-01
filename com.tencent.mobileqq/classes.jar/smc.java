import android.animation.ValueAnimator;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.Scroller;
import com.tencent.biz.pubaccount.readinjoy.view.CaptureOperateTouchLayout;
import com.tencent.biz.pubaccount.readinjoy.view.CaptureOperateTouchLayout.IndicatorTouchListener.1;
import com.tencent.biz.pubaccount.readinjoy.view.CaptureOperateTouchLayout.IndicatorTouchListener.2;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class smc
  implements View.OnTouchListener
{
  private float jdField_a_of_type_Float;
  private Runnable jdField_a_of_type_JavaLangRunnable = new CaptureOperateTouchLayout.IndicatorTouchListener.1(this);
  private smb jdField_a_of_type_Smb;
  private float jdField_b_of_type_Float;
  private Runnable jdField_b_of_type_JavaLangRunnable = new CaptureOperateTouchLayout.IndicatorTouchListener.2(this);
  private float c;
  private float d;
  private float e;
  private float f;
  private float g;
  
  public smc(CaptureOperateTouchLayout paramCaptureOperateTouchLayout, smb paramsmb)
  {
    this.jdField_a_of_type_Smb = paramsmb;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      this.g = paramMotionEvent.getRawX();
      return true;
      this.jdField_a_of_type_Float = paramView.getX();
      this.jdField_b_of_type_Float = paramView.getY();
      this.c = paramMotionEvent.getRawX();
      this.d = paramMotionEvent.getRawY();
      this.e = paramView.getX();
      this.f = paramView.getY();
      CaptureOperateTouchLayout.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewCaptureOperateTouchLayout, false);
      CaptureOperateTouchLayout.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewCaptureOperateTouchLayout).setFinalX((int)CaptureOperateTouchLayout.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewCaptureOperateTouchLayout).getX());
      CaptureOperateTouchLayout.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewCaptureOperateTouchLayout).postDelayed(this.jdField_b_of_type_JavaLangRunnable, 300L);
      CaptureOperateTouchLayout.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewCaptureOperateTouchLayout).postDelayed(this.jdField_a_of_type_JavaLangRunnable, 1000L);
      continue;
      if (CaptureOperateTouchLayout.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewCaptureOperateTouchLayout))
      {
        CaptureOperateTouchLayout.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewCaptureOperateTouchLayout, false);
        int i = (int)(Math.abs(paramView.getX() - this.e) / CaptureOperateTouchLayout.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewCaptureOperateTouchLayout) * 400.0F);
        ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { paramView.getScrollX(), this.e }).setDuration(i);
        localValueAnimator.addUpdateListener(new smd(this, paramView));
        localValueAnimator.start();
        this.jdField_a_of_type_Smb.a(true);
      }
      for (;;)
      {
        CaptureOperateTouchLayout.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewCaptureOperateTouchLayout).abortAnimation();
        CaptureOperateTouchLayout.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewCaptureOperateTouchLayout, CaptureOperateTouchLayout.b());
        CaptureOperateTouchLayout.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewCaptureOperateTouchLayout, CaptureOperateTouchLayout.b());
        CaptureOperateTouchLayout.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewCaptureOperateTouchLayout).removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
        CaptureOperateTouchLayout.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewCaptureOperateTouchLayout).removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
        break;
        this.jdField_a_of_type_Smb.a(false);
      }
      float f2 = this.jdField_a_of_type_Float;
      float f3 = paramMotionEvent.getRawX();
      float f4 = this.c;
      float f1 = CaptureOperateTouchLayout.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewCaptureOperateTouchLayout);
      f2 = Math.min(Math.max(f2 + (f3 - f4), 0.0F), f1);
      paramView.setX(f2);
      f1 = f2 / f1;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewCaptureOperateTouchLayout.a(f1, CaptureOperateTouchLayout.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewCaptureOperateTouchLayout));
      if ((!CaptureOperateTouchLayout.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewCaptureOperateTouchLayout)) && ((Math.abs(this.e - paramView.getX()) > 10.0F) || (Math.abs(this.f - paramView.getY()) > 10.0F)))
      {
        this.e = paramView.getX();
        this.f = paramView.getY();
        ThreadManager.getUIHandler().removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
        ThreadManager.getUIHandler().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
        ThreadManager.getUIHandler().postDelayed(this.jdField_b_of_type_JavaLangRunnable, 300L);
        ThreadManager.getUIHandler().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 1000L);
        this.jdField_a_of_type_Smb.c();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     smc
 * JD-Core Version:    0.7.0.1
 */