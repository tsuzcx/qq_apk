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
  private WeakReference<BaseQQAppInterface> b;
  private WeakReference<QBaseActivity> c;
  
  public ClosePCVerifyImpl$ClosePCVerifyClickableSpan(WeakReference<BaseQQAppInterface> paramWeakReference, WeakReference<QBaseActivity> paramWeakReference1)
  {
    WeakReference localWeakReference;
    if (a(paramWeakReference1, localWeakReference))
    {
      QLog.e("ClosePCVerifyImpl", 1, "ClosePCVerifyClickableSpan() error: params wrong");
      return;
    }
    this.b = paramWeakReference1;
    this.c = localWeakReference;
  }
  
  private boolean a()
  {
    WeakReference localWeakReference = this.c;
    return (localWeakReference == null) || (this.b == null) || (localWeakReference.get() == null) || (this.b.get() == null);
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
    paramView = (QBaseActivity)this.c.get();
    BaseQQAppInterface localBaseQQAppInterface = (BaseQQAppInterface)this.b.get();
    if (!NetworkUtil.isNetSupport(paramView))
    {
      QQToast.makeText(paramView, 1, 2131897439, 1).show();
      QLog.e("ClosePCVerifyImpl", 1, "NetworkError");
      return;
    }
    ClosePCVerifyImpl.a(this.a, localBaseQQAppInterface, paramView);
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    QLog.d("ClosePCVerifyImpl", 1, "updateDrawState");
    if (a())
    {
      QLog.e("ClosePCVerifyImpl", 1, "updateDrawState error: param wrong");
      return;
    }
    paramTextPaint.setColor(((QBaseActivity)this.c.get()).getResources().getColor(2131166337));
    paramTextPaint.setUnderlineText(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.quicklogin.ClosePCVerifyImpl.ClosePCVerifyClickableSpan
 * JD-Core Version:    0.7.0.1
 */