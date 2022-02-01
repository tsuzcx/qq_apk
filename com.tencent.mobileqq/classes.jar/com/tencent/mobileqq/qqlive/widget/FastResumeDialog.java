package com.tencent.mobileqq.qqlive.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.qqlive.prepare.PrepareFragmentViewModel;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class FastResumeDialog
  extends BaseDialog<PrepareFragmentViewModel>
  implements View.OnClickListener
{
  private FastResumeDialog.OnDialogClickListener b;
  
  public FastResumeDialog(@NonNull Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    paramContext = LayoutInflater.from(paramContext).inflate(2131627990, null);
    paramContext.findViewById(2131439179).setOnClickListener(this);
    paramContext.findViewById(2131440535).setOnClickListener(this);
    if (getWindow() != null)
    {
      Window localWindow = getWindow();
      localWindow.setWindowAnimations(2131953329);
      localWindow.setGravity(17);
      localWindow.getDecorView().setPadding(0, 0, 0, 0);
      WindowManager.LayoutParams localLayoutParams = getWindow().getAttributes();
      localLayoutParams.width = -1;
      localWindow.setAttributes(localLayoutParams);
      localWindow.addContentView(paramContext, new ViewGroup.LayoutParams(-1, -1));
    }
    setCanceledOnTouchOutside(false);
    setCancelable(false);
    setOnKeyListener(new FastResumeDialog.1(this));
  }
  
  public void a(FastResumeDialog.OnDialogClickListener paramOnDialogClickListener)
  {
    this.b = paramOnDialogClickListener;
  }
  
  public void onClick(View paramView)
  {
    if (this.b != null) {
      if (paramView.getId() == 2131439179) {
        this.b.a();
      } else if (paramView.getId() == 2131440535) {
        this.b.b();
      }
    }
    dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.widget.FastResumeDialog
 * JD-Core Version:    0.7.0.1
 */