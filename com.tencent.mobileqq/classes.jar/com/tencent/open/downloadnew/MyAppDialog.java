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
  ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  protected final WeakReference<Activity> a;
  TextView b;
  TextView c;
  TextView d;
  TextView e;
  
  public MyAppDialog(Activity paramActivity)
  {
    super(paramActivity);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramActivity);
    requestWindowFeature(1);
    paramActivity = new ColorDrawable();
    paramActivity.setAlpha(0);
    getWindow().setBackgroundDrawable(paramActivity);
    setContentView(2131559655);
  }
  
  public Activity a()
  {
    Activity localActivity2 = (Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    Activity localActivity1 = localActivity2;
    if (localActivity2 == null) {
      localActivity1 = null;
    }
    return localActivity1;
  }
  
  public MyAppDialog a(int paramInt)
  {
    this.b.setTextColor(paramInt);
    return this;
  }
  
  public MyAppDialog a(int paramInt1, int paramInt2, DialogInterface.OnClickListener paramOnClickListener, boolean paramBoolean)
  {
    if (paramOnClickListener == null)
    {
      this.c.setVisibility(8);
      return this;
    }
    this.c.setText(paramInt1);
    this.c.setTextColor(paramInt2);
    this.c.setVisibility(0);
    this.c.setOnClickListener(new MyAppDialog.3(this, paramOnClickListener, paramInt1, paramBoolean));
    return this;
  }
  
  public MyAppDialog a(int paramInt, DialogInterface.OnClickListener paramOnClickListener, boolean paramBoolean)
  {
    if (paramOnClickListener == null)
    {
      this.c.setVisibility(8);
      return this;
    }
    this.c.setText(paramInt);
    this.c.setVisibility(0);
    this.c.setOnClickListener(new MyAppDialog.2(this, paramOnClickListener, paramInt, paramBoolean));
    return this;
  }
  
  public MyAppDialog a(String paramString)
  {
    if (paramString != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
    }
    return this;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    ThreadManager.getUIHandler().post(new MyAppDialog.1(this, paramInt1, paramInt2));
  }
  
  public void a(Drawable paramDrawable)
  {
    this.jdField_a_of_type_AndroidWidgetProgressBar.setProgressDrawable(paramDrawable);
  }
  
  public MyAppDialog b(int paramInt1, int paramInt2, DialogInterface.OnClickListener paramOnClickListener, boolean paramBoolean)
  {
    if (paramOnClickListener == null)
    {
      this.d.setVisibility(8);
      return this;
    }
    this.d.setText(paramInt1);
    this.d.setTextColor(paramInt2);
    this.d.setVisibility(0);
    this.d.setOnClickListener(new MyAppDialog.5(this, paramOnClickListener, paramInt1, paramBoolean));
    return this;
  }
  
  public MyAppDialog b(int paramInt, DialogInterface.OnClickListener paramOnClickListener, boolean paramBoolean)
  {
    if (paramOnClickListener == null)
    {
      this.d.setVisibility(8);
      return this;
    }
    this.d.setText(paramInt);
    this.d.setVisibility(0);
    this.d.setOnClickListener(new MyAppDialog.4(this, paramOnClickListener, paramInt, paramBoolean));
    return this;
  }
  
  public MyAppDialog b(String paramString)
  {
    if (paramString != null) {
      this.b.setText(paramString);
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
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131365648));
    this.b = ((TextView)findViewById(2131365644));
    this.c = ((TextView)findViewById(2131365633));
    this.c.getPaint().setFakeBoldText(true);
    this.d = ((TextView)findViewById(2131365639));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)findViewById(2131373123));
    this.e = ((TextView)findViewById(2131373151));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.downloadnew.MyAppDialog
 * JD-Core Version:    0.7.0.1
 */