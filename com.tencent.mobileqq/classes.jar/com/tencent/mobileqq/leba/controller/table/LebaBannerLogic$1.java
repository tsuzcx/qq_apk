package com.tencent.mobileqq.leba.controller.table;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

class LebaBannerLogic$1
  implements Runnable
{
  LebaBannerLogic$1(LebaBannerLogic paramLebaBannerLogic) {}
  
  public void run()
  {
    if (this.this$0.jdField_a_of_type_AndroidWidgetFrameLayout == null)
    {
      QLog.i("LebaBannerLogic", 1, "mRootLayout == null");
      return;
    }
    if (this.this$0.jdField_a_of_type_MqqAppAppRuntime == null)
    {
      QLog.i("LebaBannerLogic", 1, "mRuntime == null");
      return;
    }
    BusinessInfoCheckUpdate.AppInfo localAppInfo = ((IRedTouchManager)this.this$0.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(IRedTouchManager.class, "")).getAppInfo(0, "100000");
    if (localAppInfo != null) {}
    try
    {
      if (RedTouch.a(localAppInfo))
      {
        View localView;
        if (this.this$0.jdField_a_of_type_AndroidWidgetFrameLayout.getChildCount() > 0)
        {
          QLog.i("LebaBannerLogic", 1, "showBannerView reused");
          localView = this.this$0.jdField_a_of_type_AndroidWidgetFrameLayout.getChildAt(0);
        }
        else
        {
          QLog.i("LebaBannerLogic", 1, "showBannerView new");
          localView = ((LayoutInflater)LebaBannerLogic.a(this.this$0).getSystemService("layout_inflater")).inflate(2131561137, null);
          this.this$0.jdField_a_of_type_AndroidWidgetFrameLayout.setOnClickListener(this.this$0);
          this.this$0.jdField_a_of_type_AndroidWidgetFrameLayout.setPadding(ViewUtils.b(16.0F), ViewUtils.b(12.0F), ViewUtils.b(16.0F), 0);
          this.this$0.jdField_a_of_type_AndroidWidgetFrameLayout.addView(localView);
        }
        LebaBannerLogic.a(this.this$0, localAppInfo, localView);
        return;
      }
      if (this.this$0.jdField_a_of_type_AndroidWidgetFrameLayout.getChildCount() > 0)
      {
        QLog.i("LebaBannerLogic", 1, "hideBannerView remove");
        this.this$0.jdField_a_of_type_AndroidWidgetFrameLayout.setPadding(0, 0, 0, 0);
        this.this$0.jdField_a_of_type_AndroidWidgetFrameLayout.removeAllViews();
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.i("LebaBannerLogic", 1, "showBannerView", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.leba.controller.table.LebaBannerLogic.1
 * JD-Core Version:    0.7.0.1
 */