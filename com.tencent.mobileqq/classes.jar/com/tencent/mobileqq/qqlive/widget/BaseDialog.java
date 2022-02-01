package com.tencent.mobileqq.qqlive.widget;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.mvvm.BaseViewModel;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

abstract class BaseDialog<T extends BaseViewModel>
  extends Dialog
{
  protected T a;
  
  public BaseDialog(@NonNull Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
    a();
  }
  
  private void a()
  {
    if (getWindow() != null) {
      getWindow().getDecorView().setPadding(0, 0, 0, 0);
    }
  }
  
  public void a(T paramT)
  {
    this.a = paramT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.widget.BaseDialog
 * JD-Core Version:    0.7.0.1
 */