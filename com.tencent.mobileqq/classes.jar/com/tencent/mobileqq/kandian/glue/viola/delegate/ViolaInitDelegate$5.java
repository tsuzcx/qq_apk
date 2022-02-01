package com.tencent.mobileqq.kandian.glue.viola.delegate;

import android.content.Intent;
import android.widget.FrameLayout;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.kandian.biz.viola.view.ViolaFragment;
import com.tencent.mobileqq.kandian.glue.viola.CommonSuspensionGestureLayout.SuspensionGestureListener;

class ViolaInitDelegate$5
  implements CommonSuspensionGestureLayout.SuspensionGestureListener
{
  ViolaInitDelegate$5(ViolaInitDelegate paramViolaInitDelegate, FrameLayout paramFrameLayout) {}
  
  public void a() {}
  
  public void a(int paramInt)
  {
    if (ViolaInitDelegate.a(this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaDelegateViolaInitDelegate) != null) {
      ViolaInitDelegate.a(this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaDelegateViolaInitDelegate).a(paramInt);
    }
  }
  
  public void a(boolean paramBoolean, int paramInt) {}
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (paramInt2 == 5)
    {
      Intent localIntent = new Intent();
      localIntent.setAction("float_layer_finsh_action");
      ViolaInitDelegate.a(this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaDelegateViolaInitDelegate).getQBaseActivity().sendBroadcast(localIntent);
    }
    ViolaInitDelegate.a(this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaDelegateViolaInitDelegate).getQBaseActivity().doOnBackPressed();
    ViolaInitDelegate.a(this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaDelegateViolaInitDelegate).getQBaseActivity().overridePendingTransition(0, 0);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_AndroidWidgetFrameLayout.getVisibility() != 0) {
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
    }
  }
  
  public void b(int paramInt) {}
  
  public void c() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.delegate.ViolaInitDelegate.5
 * JD-Core Version:    0.7.0.1
 */