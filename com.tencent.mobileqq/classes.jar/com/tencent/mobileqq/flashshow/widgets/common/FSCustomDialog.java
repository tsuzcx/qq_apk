package com.tencent.mobileqq.flashshow.widgets.common;

import android.annotation.TargetApi;
import android.app.Activity;
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

public class FSCustomDialog
  extends ReportDialog
{
  protected TextView a;
  protected TextView b;
  protected TextView c;
  protected TextView d;
  protected LinearLayout e;
  ViewGroup f;
  private Context g;
  
  @TargetApi(14)
  public FSCustomDialog(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
    a(paramContext);
  }
  
  public static FSCustomDialog a(Context paramContext, String paramString1, String paramString2, int paramInt1, int paramInt2, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new FSCustomDialog(paramContext, 2131952059);
    paramContext.setContentView(2131624789);
    paramContext.a(paramString1);
    paramContext.a(paramString2);
    paramContext.a(paramInt1, paramOnClickListener2);
    paramContext.b(paramInt2, paramOnClickListener1);
    paramContext.setCanceledOnTouchOutside(false);
    return paramContext;
  }
  
  private void a(Context paramContext)
  {
    super.getWindow().setWindowAnimations(2131951986);
    if (Build.VERSION.SDK_INT >= 14) {
      getWindow().setDimAmount(0.5F);
    }
    this.g = paramContext;
  }
  
  public FSCustomDialog a(int paramInt, DialogInterface.OnClickListener paramOnClickListener)
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
    this.c.setOnClickListener(new FSCustomDialog.4(this, paramOnClickListener));
    return this;
  }
  
  public FSCustomDialog a(CharSequence paramCharSequence)
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
  
  public FSCustomDialog a(String paramString)
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
  
  public FSCustomDialog b(int paramInt, DialogInterface.OnClickListener paramOnClickListener)
  {
    if (paramOnClickListener == null)
    {
      this.d.setVisibility(8);
      return this;
    }
    this.d.setText(paramInt);
    this.d.setContentDescription(getContext().getString(paramInt));
    this.d.setVisibility(0);
    this.d.setOnClickListener(new FSCustomDialog.5(this, paramOnClickListener));
    return this;
  }
  
  /* Error */
  public void dismiss()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 145	android/app/Dialog:dismiss	()V
    //   4: aload_0
    //   5: invokestatic 150	com/tencent/mobileqq/flashshow/utils/FSViewUtils:a	(Landroid/app/Dialog;)V
    //   8: return
    //   9: astore_1
    //   10: aload_0
    //   11: invokestatic 150	com/tencent/mobileqq/flashshow/utils/FSViewUtils:a	(Landroid/app/Dialog;)V
    //   14: aload_1
    //   15: athrow
    //   16: astore_1
    //   17: goto -13 -> 4
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	20	0	this	FSCustomDialog
    //   9	6	1	localObject	java.lang.Object
    //   16	1	1	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   0	4	9	finally
    //   0	4	16	java/lang/Exception
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
  
  public void show()
  {
    Context localContext = this.g;
    if (((localContext instanceof Activity)) && (((Activity)localContext).isFinishing())) {
      return;
    }
    super.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.widgets.common.FSCustomDialog
 * JD-Core Version:    0.7.0.1
 */