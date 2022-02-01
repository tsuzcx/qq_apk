package com.tencent.mobileqq.widget;

import android.os.Handler;
import android.os.Message;
import android.view.View;
import com.tencent.mobileqq.struct.PushBanner;
import java.lang.ref.WeakReference;

class ADView$WeakHandler
  extends Handler
{
  private ADView jdField_a_of_type_ComTencentMobileqqWidgetADView;
  private WeakReference<ADView> jdField_a_of_type_JavaLangRefWeakReference;
  
  public ADView$WeakHandler(ADView paramADView)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramADView);
  }
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    Object localObject;
    if (i != 0)
    {
      if (i == 1) {
        removeMessages(0);
      }
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetADView = ((ADView)this.jdField_a_of_type_JavaLangRefWeakReference.get());
      localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetADView;
      if (localObject == null) {
        break label177;
      }
      if (((ADView)localObject).a == null) {
        return;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqWidgetADView.a.getChildCount() > 1) && (this.jdField_a_of_type_ComTencentMobileqqWidgetADView.a.getWidth() > 0)) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetADView.a.a(this.jdField_a_of_type_ComTencentMobileqqWidgetADView.a.a() + 1);
      }
    }
    try
    {
      localObject = (PushBanner)this.jdField_a_of_type_ComTencentMobileqqWidgetADView.a.getChildAt(this.jdField_a_of_type_ComTencentMobileqqWidgetADView.a.a()).getTag();
      i = ((PushBanner)localObject).a * 1000;
      this.jdField_a_of_type_ComTencentMobileqqWidgetADView.setContentDescription(((PushBanner)localObject).n);
    }
    catch (Exception localException)
    {
      label155:
      break label155;
    }
    i = 5000;
    sendEmptyMessageDelayed(0, i);
    this.jdField_a_of_type_ComTencentMobileqqWidgetADView = null;
    super.handleMessage(paramMessage);
    label177:
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ADView.WeakHandler
 * JD-Core Version:    0.7.0.1
 */