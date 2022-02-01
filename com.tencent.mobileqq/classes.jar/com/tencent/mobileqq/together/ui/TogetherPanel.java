package com.tencent.mobileqq.together.ui;

import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.widget.PopupWindow.OnDismissListener;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.together.TogetherControlManager;
import com.tencent.qphone.base.util.QLog;

public class TogetherPanel
  implements PopupWindow.OnDismissListener
{
  TogetherPopupDialog a;
  BaseActivity b;
  
  public TogetherPanel(BaseActivity paramBaseActivity)
  {
    this.b = paramBaseActivity;
  }
  
  public void a(TroopChatPie paramTroopChatPie, View paramView, int paramInt)
  {
    paramView = (InputMethodManager)this.b.getSystemService("input_method");
    if (paramView.isActive()) {
      paramView.hideSoftInputFromWindow(this.b.getWindow().getDecorView().getWindowToken(), 0);
    }
    paramView = this.a;
    if (paramView == null)
    {
      this.a = TogetherPopupDialog.a(paramTroopChatPie, this.b, -1, -1, paramInt);
      this.a.setOnDismissListener(this);
      TogetherControlManager.a(this.b.app).c();
    }
    else if (paramInt == 1)
    {
      paramView.b();
    }
    paramTroopChatPie = this.b.getWindow();
    if (paramTroopChatPie != null)
    {
      paramView = paramTroopChatPie.getAttributes();
      paramView.alpha = 0.5F;
      paramTroopChatPie.setAttributes(paramView);
    }
    this.a.setAnimationStyle(2131952641);
    this.a.showAtLocation(this.b.getWindow().getDecorView(), 80, 0, 0);
    this.a.a();
  }
  
  public boolean a()
  {
    TogetherPopupDialog localTogetherPopupDialog = this.a;
    if ((localTogetherPopupDialog != null) && (localTogetherPopupDialog.isShowing()))
    {
      this.a.dismiss();
      return true;
    }
    return false;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TogetherPanel", 2, "destroyPanel");
    }
    a();
    this.a.c();
    this.a = null;
  }
  
  public void onDismiss()
  {
    TogetherControlManager.a(this.b.app).a(false);
    Window localWindow = this.b.getWindow();
    if (localWindow != null)
    {
      WindowManager.LayoutParams localLayoutParams = localWindow.getAttributes();
      localLayoutParams.alpha = 1.0F;
      localWindow.setAttributes(localLayoutParams);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.together.ui.TogetherPanel
 * JD-Core Version:    0.7.0.1
 */