package com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule.dialog;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.falco.utils.UIUtil;
import com.tencent.smtt.sdk.WebView;

public class HalfSizeWebviewDialog
  extends BaseWebDialogFragment
{
  protected boolean k = false;
  protected int l;
  protected int m = 0;
  protected int n = 0;
  protected float o = 1.0F;
  protected boolean p;
  protected boolean q = false;
  protected boolean r = false;
  protected ImageView s;
  protected ImageView t;
  protected ViewGroup u;
  protected TextView v;
  protected View w;
  
  private void d()
  {
    if (this.n == 0)
    {
      this.s.setVisibility(8);
      return;
    }
    this.s.setVisibility(0);
  }
  
  public int a()
  {
    return 2131625155;
  }
  
  public FrameLayout a(View paramView)
  {
    return (FrameLayout)paramView.findViewById(2131450073);
  }
  
  public void a(Dialog paramDialog)
  {
    if (paramDialog == null) {
      return;
    }
    paramDialog.setCanceledOnTouchOutside(true);
    Window localWindow = paramDialog.getWindow();
    if (localWindow != null)
    {
      WindowManager.LayoutParams localLayoutParams = localWindow.getAttributes();
      if (getActivity() != null) {
        if (!this.q)
        {
          localWindow.setWindowAnimations(2131953178);
          localLayoutParams.gravity = 80;
        }
        else
        {
          localWindow.setWindowAnimations(2131953179);
          localLayoutParams.gravity = 5;
        }
      }
      int i = this.l;
      if (i == 0) {
        localLayoutParams.width = -1;
      } else {
        localLayoutParams.width = i;
      }
      i = this.m;
      if (i == 0) {
        localLayoutParams.height = (UIUtil.getScreenHeight(paramDialog.getContext()) / 2);
      } else {
        localLayoutParams.height = i;
      }
      localWindow.setAttributes(localLayoutParams);
      localWindow.setDimAmount(this.o);
    }
    if (this.k) {
      b();
    }
    if (!this.r) {
      c();
    }
  }
  
  public FrameLayout b(View paramView)
  {
    return (FrameLayout)paramView.findViewById(2131450073);
  }
  
  protected void b()
  {
    this.e.setWebChromeClient(new HalfSizeWebviewDialog.1(this));
  }
  
  protected void c()
  {
    this.w.setVisibility(8);
  }
  
  public void c(View paramView)
  {
    d(paramView);
  }
  
  protected void d(View paramView)
  {
    this.u = ((ViewGroup)paramView.findViewById(2131435210));
    ViewGroup localViewGroup = this.u;
    int i;
    if (this.k) {
      i = 0;
    } else {
      i = 8;
    }
    localViewGroup.setVisibility(i);
    this.s = ((ImageView)paramView.findViewById(2131435209));
    this.t = ((ImageView)paramView.findViewById(2131435211));
    this.v = ((TextView)paramView.findViewById(2131435212));
    this.t.setOnClickListener(new HalfSizeWebviewDialog.2(this));
    this.s.setOnClickListener(new HalfSizeWebviewDialog.3(this));
    this.w = paramView.findViewById(2131447740);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getArguments();
    if (paramBundle != null)
    {
      this.l = paramBundle.getInt("width");
      this.m = paramBundle.getInt("height");
      this.k = paramBundle.getBoolean("showTitleBar", false);
      this.q = paramBundle.getBoolean("isLandscape", false);
      this.o = paramBundle.getFloat("dimAmount", 1.0F);
      this.p = paramBundle.getBoolean("leftClickClose", false);
      this.f = paramBundle.getBoolean("plantCookieWhenResume", false);
      this.r = paramBundle.getBoolean("needTopRadius", false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule.dialog.HalfSizeWebviewDialog
 * JD-Core Version:    0.7.0.1
 */