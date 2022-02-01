package com.tencent.mobileqq.forward;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.AnimationTextView;
import com.tencent.qphone.base.util.QLog;

public class ForwardPreviewTextController
  extends ForwardPreviewBaseController
{
  private AnimationTextView e;
  private ViewGroup f;
  private int g;
  
  public ForwardPreviewTextController(QQCustomDialog paramQQCustomDialog)
  {
    super(paramQQCustomDialog);
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ForwardPreviewTextController", 2, " bindData ");
    }
    if (paramString1 != null) {
      a(paramString1);
    }
    if (paramString2 != null)
    {
      paramString1 = this.e;
      if (paramString1 != null) {
        paramString1.setText(new QQText(paramString2, 5, 20));
      }
    }
  }
  
  protected View c()
  {
    this.f = ((ViewGroup)LayoutInflater.from(this.b).inflate(2131624593, null));
    this.e = ((AnimationTextView)this.f.findViewById(2131447089));
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    this.f.setLayoutParams(localLayoutParams);
    this.f.getViewTreeObserver().addOnGlobalLayoutListener(new ForwardPreviewTextController.1(this));
    return this.f;
  }
  
  protected int d()
  {
    if (this.g == 0) {
      this.g = ((int)((this.d.getRootViewHeight() - this.b.getResources().getDimensionPixelSize(2131297496)) / ViewUtils.mDensity));
    }
    return this.g;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardPreviewTextController
 * JD-Core Version:    0.7.0.1
 */