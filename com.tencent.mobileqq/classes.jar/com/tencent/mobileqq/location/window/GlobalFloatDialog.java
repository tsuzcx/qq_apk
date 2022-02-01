package com.tencent.mobileqq.location.window;

import android.os.Build.VERSION;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.BaseApplication;

public class GlobalFloatDialog
{
  private final View a = View.inflate(BaseApplication.getContext(), 2131624594, null);
  private final TextView b = (TextView)this.a.findViewById(2131431864);
  private final TextView c;
  private final TextView d;
  private CanBackFrameLayout e = (CanBackFrameLayout)this.a.findViewById(2131431899);
  private WindowManager f = (WindowManager)BaseApplication.getContext().getSystemService("window");
  private GlobalFloatDialogEventReceiver g;
  
  public GlobalFloatDialog()
  {
    this.b.setOnClickListener(new GlobalFloatDialog.1(this));
    this.c = ((TextView)this.a.findViewById(2131431870));
    this.c.setOnClickListener(new GlobalFloatDialog.2(this));
    this.d = ((TextView)this.a.findViewById(2131431880));
    this.d.setVisibility(8);
    this.g = new GlobalFloatDialogEventReceiver();
  }
  
  public void a()
  {
    WindowManager.LayoutParams localLayoutParams = new WindowManager.LayoutParams();
    if (Build.VERSION.SDK_INT >= 26) {
      localLayoutParams.type = 2038;
    } else {
      localLayoutParams.type = 2002;
    }
    localLayoutParams.format = -3;
    localLayoutParams.height = ViewUtils.getScreenHeight();
    localLayoutParams.width = ViewUtils.getScreenWidth();
    this.f.addView(this.a, localLayoutParams);
    this.g.a(this);
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    this.b.setOnClickListener(new GlobalFloatDialog.3(this, paramOnClickListener));
  }
  
  public void a(String paramString)
  {
    ((TextView)this.a.findViewById(2131431876)).setText(paramString);
  }
  
  public void b()
  {
    this.f.removeView(this.a);
    this.g.a();
  }
  
  public void b(View.OnClickListener paramOnClickListener)
  {
    this.c.setOnClickListener(new GlobalFloatDialog.4(this, paramOnClickListener));
  }
  
  public void b(String paramString)
  {
    this.b.setText(paramString);
  }
  
  public void c()
  {
    this.a.setVisibility(8);
  }
  
  public void c(View.OnClickListener paramOnClickListener)
  {
    this.e.setBackKeyListener(new GlobalFloatDialog.5(this, paramOnClickListener));
  }
  
  public void c(String paramString)
  {
    this.c.setText(paramString);
  }
  
  public void d()
  {
    this.a.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.window.GlobalFloatDialog
 * JD-Core Version:    0.7.0.1
 */