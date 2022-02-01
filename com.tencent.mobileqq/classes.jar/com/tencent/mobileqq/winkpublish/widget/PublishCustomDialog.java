package com.tencent.mobileqq.winkpublish.widget;

import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.view.Window;
import android.view.accessibility.AccessibilityEvent;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import java.util.List;

public class PublishCustomDialog
  extends ReportDialog
{
  protected TextView a;
  protected TextView b;
  protected TextView c;
  protected TextView d;
  protected LinearLayout e;
  ViewGroup f;
  
  @TargetApi(14)
  public PublishCustomDialog(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
    super.getWindow().setWindowAnimations(2131951986);
    if (Build.VERSION.SDK_INT >= 14) {
      getWindow().setDimAmount(0.5F);
    }
  }
  
  public static PublishCustomDialog a(Context paramContext, String paramString1, String paramString2, int paramInt1, int paramInt2, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new PublishCustomDialog(paramContext, 2131952059);
    paramContext.setContentView(2131627210);
    paramContext.a(paramString1);
    paramContext.a(paramString2);
    paramContext.a(paramInt1, paramOnClickListener2);
    paramContext.b(paramInt2, paramOnClickListener1);
    paramContext.setCanceledOnTouchOutside(false);
    return paramContext;
  }
  
  public PublishCustomDialog a(int paramInt, DialogInterface.OnClickListener paramOnClickListener)
  {
    if (paramOnClickListener == null)
    {
      this.c.setVisibility(8);
      return this;
    }
    this.c.setText(paramInt);
    TextView localTextView = this.c;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getContext().getString(paramInt));
    localStringBuilder.append(getContext().getString(2131888061));
    localTextView.setContentDescription(localStringBuilder.toString());
    this.c.setVisibility(0);
    this.c.setOnClickListener(new PublishCustomDialog.4(this, paramOnClickListener));
    return this;
  }
  
  public PublishCustomDialog a(CharSequence paramCharSequence)
  {
    if (!TextUtils.isEmpty(paramCharSequence))
    {
      this.b.setText(paramCharSequence);
      this.b.setContentDescription(paramCharSequence);
      this.b.setVisibility(0);
      return this;
    }
    this.b.setVisibility(8);
    return this;
  }
  
  public PublishCustomDialog a(String paramString)
  {
    if (paramString != null)
    {
      this.a.setText(paramString);
      this.a.setContentDescription(paramString);
      this.a.setVisibility(0);
      return this;
    }
    this.a.setVisibility(8);
    return this;
  }
  
  public PublishCustomDialog b(int paramInt, DialogInterface.OnClickListener paramOnClickListener)
  {
    if (paramOnClickListener == null)
    {
      this.d.setVisibility(8);
      return this;
    }
    this.d.setText(paramInt);
    this.d.setContentDescription(getContext().getString(paramInt));
    this.d.setVisibility(0);
    this.d.setOnClickListener(new PublishCustomDialog.5(this, paramOnClickListener));
    return this;
  }
  
  /* Error */
  public void dismiss()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 138	android/app/Dialog:dismiss	()V
    //   4: return
    //   5: astore_1
    //   6: aload_1
    //   7: athrow
    //   8: astore_1
    //   9: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	10	0	this	PublishCustomDialog
    //   5	2	1	localObject	java.lang.Object
    //   8	1	1	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   0	4	5	finally
    //   0	4	8	java/lang/Exception
  }
  
  public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    if (paramAccessibilityEvent.getEventType() == 32) {
      paramAccessibilityEvent.getText().add(getContext().getString(2131888064));
    }
    super.dispatchPopulateAccessibilityEvent(paramAccessibilityEvent);
    paramAccessibilityEvent.setClassName(Dialog.class.getName());
    return false;
  }
  
  public void setContentView(int paramInt)
  {
    super.setContentView(paramInt);
    this.a = ((TextView)findViewById(2131431880));
    this.b = ((TextView)findViewById(2131431876));
    this.c = ((TextView)findViewById(2131431864));
    this.d = ((TextView)findViewById(2131431870));
    this.c.setVisibility(8);
    this.d.setVisibility(8);
    this.e = ((LinearLayout)findViewById(2131429603));
    this.f = ((ViewGroup)findViewById(2131431871));
  }
  
  public void setTitle(int paramInt)
  {
    this.a.setText(paramInt);
    this.a.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.widget.PublishCustomDialog
 * JD-Core Version:    0.7.0.1
 */