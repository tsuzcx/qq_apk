package com.tencent.open.downloadnew;

import aliw;
import alix;
import aliy;
import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface.OnClickListener;
import android.graphics.drawable.ColorDrawable;
import android.text.TextPaint;
import android.view.Window;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mobileqq.app.ThreadManager;
import java.lang.ref.WeakReference;
import mqq.os.MqqHandler;

public class MyAppDialog
  extends Dialog
{
  public ProgressBar a;
  TextView a;
  protected final WeakReference a;
  TextView b;
  public TextView c;
  TextView d;
  public TextView e;
  
  public MyAppDialog(Activity paramActivity)
  {
    super(paramActivity);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramActivity);
    requestWindowFeature(1);
    paramActivity = new ColorDrawable();
    paramActivity.setAlpha(0);
    getWindow().setBackgroundDrawable(paramActivity);
    setContentView(2130969249);
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
  
  public MyAppDialog a(int paramInt, DialogInterface.OnClickListener paramOnClickListener, boolean paramBoolean)
  {
    if (paramOnClickListener == null)
    {
      this.c.setVisibility(8);
      return this;
    }
    this.c.setText(paramInt);
    this.c.setVisibility(0);
    this.c.setOnClickListener(new alix(this, paramOnClickListener, paramInt, paramBoolean));
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
    ThreadManager.getUIHandler().post(new aliw(this, paramInt1, paramInt2));
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
    this.d.setOnClickListener(new aliy(this, paramOnClickListener, paramInt, paramBoolean));
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
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131364034));
    this.b = ((TextView)findViewById(2131362776));
    this.c = ((TextView)findViewById(2131364037));
    this.c.getPaint().setFakeBoldText(true);
    this.d = ((TextView)findViewById(2131364038));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)findViewById(2131363005));
    this.e = ((TextView)findViewById(2131365724));
  }
  
  public void setTitle(int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramInt);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.open.downloadnew.MyAppDialog
 * JD-Core Version:    0.7.0.1
 */