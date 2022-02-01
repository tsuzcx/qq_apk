package com.tencent.mobileqq.hotpic;

import android.view.View;
import auib;
import auij;
import auix;
import bcef;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class PresenceInterfaceImpl$5
  implements Runnable
{
  public PresenceInterfaceImpl$5(auij paramauij) {}
  
  public void run()
  {
    if (this.this$0.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout.jdField_a_of_type_AndroidViewView == null) {
      return;
    }
    this.this$0.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.this$0.jdField_a_of_type_Auix.a(this.this$0.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout.jdField_a_of_type_AndroidViewView);
    if ((this.this$0.jdField_a_of_type_JavaLangRefWeakReference != null) && ((HotPicPageView)this.this$0.jdField_a_of_type_JavaLangRefWeakReference.get() != null)) {}
    for (boolean bool = HotPicPageView.a;; bool = false)
    {
      this.this$0.jdField_a_of_type_Auix.a(this.this$0.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout.jdField_a_of_type_Auib.c, this.this$0.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout.jdField_a_of_type_Auib.d, 0L, this.this$0.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout.jdField_a_of_type_Auib.a, bool);
      if (this.this$0.jdField_a_of_type_Auix.a()) {}
      for (String str = "0X8007ED5";; str = "0X8007ED6")
      {
        bcef.b((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), "dc00898", "", "", str, str, 0, 0, "", "", "", "");
        QLog.d("PresenceInterfaceImpl", 2, "have run mVideoPlayControl.startPlay");
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.hotpic.PresenceInterfaceImpl.5
 * JD-Core Version:    0.7.0.1
 */