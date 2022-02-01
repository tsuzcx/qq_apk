package com.tencent.mobileqq.quicklogin;

import android.content.res.Resources;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class ClosePCVerifyImpl$ClosePCVerifyClickableSpan
  extends ClickableSpan
{
  private WeakReference<BaseQQAppInterface> jdField_a_of_type_JavaLangRefWeakReference;
  private WeakReference<QBaseActivity> b;
  
  public ClosePCVerifyImpl$ClosePCVerifyClickableSpan(WeakReference<BaseQQAppInterface> paramWeakReference, WeakReference<QBaseActivity> paramWeakReference1)
  {
    WeakReference localWeakReference;
    if (a(paramWeakReference1, localWeakReference))
    {
      QLog.e("ClosePCVerifyImpl", 1, "ClosePCVerifyClickableSpan() error: params wrong");
      return;
    }
    this.jdField_a_of_type_JavaLangRefWeakReference = paramWeakReference1;
    this.b = localWeakReference;
  }
  
  private boolean a()
  {
    WeakReference localWeakReference = this.b;
    return (localWeakReference == null) || (this.jdField_a_of_type_JavaLangRefWeakReference == null) || (localWeakReference.get() == null) || (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null);
  }
  
  private boolean a(WeakReference<BaseQQAppInterface> paramWeakReference, WeakReference<QBaseActivity> paramWeakReference1)
  {
    return (paramWeakReference == null) || (paramWeakReference1 == null);
  }
  
  public void onClick(View paramView)
  {
    QLog.d("ClosePCVerifyImpl", 1, "onClick");
    ReportController.b(null, "dc00898", "", "", "0X800AE03", "0X800AE03", 0, 0, "", "", "", "");
    if (a())
    {
      QLog.e("ClosePCVerifyImpl", 1, "onClick error: params wrong");
      return;
    }
    paramView = (QBaseActivity)this.b.get();
    BaseQQAppInterface localBaseQQAppInterface = (BaseQQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (!NetworkUtil.isNetSupport(paramView))
    {
      QQToast.a(paramView, 1, 2131699408, 1).a();
      QLog.e("ClosePCVerifyImpl", 1, "NetworkError");
      return;
    }
    ClosePCVerifyImpl.a(this.jdField_a_of_type_ComTencentMobileqqQuickloginClosePCVerifyImpl, localBaseQQAppInterface, paramView);
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    QLog.d("ClosePCVerifyImpl", 1, "updateDrawState");
    if (a())
    {
      QLog.e("ClosePCVerifyImpl", 1, "updateDrawState error: param wrong");
      return;
    }
    paramTextPaint.setColor(((QBaseActivity)this.b.get()).getResources().getColor(2131165741));
    paramTextPaint.setUnderlineText(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.quicklogin.ClosePCVerifyImpl.ClosePCVerifyClickableSpan
 * JD-Core Version:    0.7.0.1
 */