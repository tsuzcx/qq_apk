package com.tencent.open.downloadnew;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface.OnClickListener;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.view.Window;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import java.lang.ref.WeakReference;
import mqq.os.MqqHandler;

public class MyAppDialog
  extends ReportDialog
{
  protected final WeakReference<Activity> a;
  TextView b;
  TextView c;
  TextView d;
  TextView e;
  ProgressBar f;
  TextView g;
  
  public MyAppDialog(Activity paramActivity)
  {
    super(paramActivity);
    this.a = new WeakReference(paramActivity);
    requestWindowFeature(1);
    paramActivity = new ColorDrawable();
    paramActivity.setAlpha(0);
    getWindow().setBackgroundDrawable(paramActivity);
    setContentView(2131625684);
  }
  
  public Activity a()
  {
    Activity localActivity2 = (Activity)this.a.get();
    Activity localActivity1 = localActivity2;
    if (localActivity2 == null) {
      localActivity1 = null;
    }
    return localActivity1;
  }
  
  public MyAppDialog a(int paramInt)
  {
    this.c.setTextColor(paramInt);
    return this;
  }
  
  public MyAppDialog a(int paramInt1, int paramInt2, DialogInterface.OnClickListener paramOnClickListener, boolean paramBoolean)
  {
    if (paramOnClickListener == null)
    {
      this.d.setVisibility(8);
      return this;
    }
    this.d.setText(paramInt1);
    this.d.setTextColor(paramInt2);
    this.d.setVisibility(0);
    this.d.setOnClickListener(new MyAppDialog.3(this, paramOnClickListener, paramInt1, paramBoolean));
    return this;
  }
  
  public MyAppDialog a(int paramInt, DialogInterface.OnClickListener paramOnClickListener, boolean paramBoolean)
  {
    if (paramOnClickListener == null)
    {
      this.d.setVisibility(8);
      return this;
    }
    this.d.setText(paramInt);
    this.d.setVisibility(0);
    this.d.setOnClickListener(new MyAppDialog.2(this, paramOnClickListener, paramInt, paramBoolean));
    return this;
  }
  
  public MyAppDialog a(String paramString)
  {
    if (paramString != null) {
      this.b.setText(paramString);
    }
    return this;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    ThreadManager.getUIHandler().post(new MyAppDialog.1(this, paramInt1, paramInt2));
  }
  
  public void a(Drawable paramDrawable)
  {
    this.f.setProgressDrawable(paramDrawable);
  }
  
  public MyAppDialog b(int paramInt1, int paramInt2, DialogInterface.OnClickListener paramOnClickListener, boolean paramBoolean)
  {
    if (paramOnClickListener == null)
    {
      this.e.setVisibility(8);
      return this;
    }
    this.e.setText(paramInt1);
    this.e.setTextColor(paramInt2);
    this.e.setVisibility(0);
    this.e.setOnClickListener(new MyAppDialog.5(this, paramOnClickListener, paramInt1, paramBoolean));
    return this;
  }
  
  public MyAppDialog b(int paramInt, DialogInterface.OnClickListener paramOnClickListener, boolean paramBoolean)
  {
    if (paramOnClickListener == null)
    {
      this.e.setVisibility(8);
      return this;
    }
    this.e.setText(paramInt);
    this.e.setVisibility(0);
    this.e.setOnClickListener(new MyAppDialog.4(this, paramOnClickListener, paramInt, paramBoolean));
    return this;
  }
  
  public MyAppDialog b(String paramString)
  {
    if (paramString != null) {
      this.c.setText(paramString);
    }
    return this;
  }
  
  public void dismiss()
  {
    try
    {
      super.dismiss();
      return;
    }
    catch (Exception localException) {}
  }
  
  public void setContentView(int paramInt)
  {
    super.setContentView(paramInt);
    this.b = ((TextView)findViewById(2131431880));
    this.c = ((TextView)findViewById(2131431876));
    this.d = ((TextView)findViewById(2131431864));
    this.d.getPaint().setFakeBoldText(true);
    this.e = ((TextView)findViewById(2131431870));
    this.f = ((ProgressBar)findViewById(2131440726));
    this.g = ((TextView)findViewById(2131440760));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.downloadnew.MyAppDialog
 * JD-Core Version:    0.7.0.1
 */