package com.tencent.qqmini.sdk.core.widget;

import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.accessibility.AccessibilityEvent;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.qqmini.sdk.R.id;
import com.tencent.qqmini.sdk.R.string;
import com.tencent.qqmini.sdk.R.style;
import java.util.List;

public class AppCloseDialog
  extends ReportDialog
{
  public static final int WHICH_CANCEL = 2;
  public static final int WHICH_NEGATIVE = 0;
  public static final int WHICH_POSITIVE = 1;
  protected LinearLayout bodyLayout;
  protected TextView lBtn;
  protected TextView rBtn;
  ViewGroup rootView;
  Object tag;
  protected TextView title;
  
  @TargetApi(14)
  public AppCloseDialog(Context paramContext)
  {
    super(paramContext);
    super.getWindow().setWindowAnimations(R.style.mini_sdk_CustomAnimationDialog);
    if (Build.VERSION.SDK_INT >= 14) {
      getWindow().setDimAmount(0.5F);
    }
  }
  
  @TargetApi(14)
  public AppCloseDialog(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
    super.getWindow().setWindowAnimations(R.style.mini_sdk_CustomAnimationDialog);
    if (Build.VERSION.SDK_INT >= 14) {
      getWindow().setDimAmount(0.5F);
    }
  }
  
  @TargetApi(14)
  protected AppCloseDialog(Context paramContext, boolean paramBoolean, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    super(paramContext, paramBoolean, paramOnCancelListener);
    super.getWindow().setWindowAnimations(R.style.mini_sdk_CustomAnimationDialog);
    if (Build.VERSION.SDK_INT >= 14) {
      getWindow().setDimAmount(0.5F);
    }
  }
  
  public AppCloseDialog addCenterView(View paramView, LinearLayout.LayoutParams paramLayoutParams)
  {
    this.bodyLayout.addView(paramView, paramLayoutParams);
    this.bodyLayout.setGravity(17);
    return this;
  }
  
  public AppCloseDialog addView(View paramView)
  {
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
    this.bodyLayout.addView(paramView, localLayoutParams);
    return this;
  }
  
  public AppCloseDialog addView(View paramView, LinearLayout.LayoutParams paramLayoutParams)
  {
    this.bodyLayout.addView(paramView, paramLayoutParams);
    return this;
  }
  
  /* Error */
  public void dismiss()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 89	android/app/Dialog:dismiss	()V
    //   4: return
    //   5: astore_1
    //   6: aload_1
    //   7: athrow
    //   8: astore_1
    //   9: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	10	0	this	AppCloseDialog
    //   5	2	1	localObject	Object
    //   8	1	1	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   0	4	5	finally
    //   0	4	8	java/lang/Exception
  }
  
  public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    if (paramAccessibilityEvent.getEventType() == 32) {
      paramAccessibilityEvent.getText().add(getContext().getString(R.string.mini_sdk_content_desc_dialog_hint));
    }
    super.dispatchPopulateAccessibilityEvent(paramAccessibilityEvent);
    paramAccessibilityEvent.setClassName(Dialog.class.getName());
    return false;
  }
  
  public void setBodyLayoutNoMargin()
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.bodyLayout.getLayoutParams();
    localLayoutParams.setMargins(0, localLayoutParams.topMargin, 0, 0);
    this.bodyLayout.setLayoutParams(localLayoutParams);
  }
  
  public void setButtonTextBold()
  {
    this.lBtn.setTypeface(Typeface.DEFAULT, 1);
    this.rBtn.setTypeface(Typeface.DEFAULT, 1);
  }
  
  public void setContentView(int paramInt)
  {
    super.setContentView(paramInt);
    this.title = ((TextView)findViewById(R.id.dialogTitle));
    this.lBtn = ((TextView)findViewById(R.id.dialogLeftBtn));
    this.rBtn = ((TextView)findViewById(R.id.dialogRightBtn));
    this.lBtn.setVisibility(8);
    this.rBtn.setVisibility(8);
    this.bodyLayout = ((LinearLayout)findViewById(R.id.bodyLayout));
    this.rootView = ((ViewGroup)findViewById(R.id.dialogRoot));
  }
  
  public AppCloseDialog setNegativeButton(String paramString, int paramInt, DialogInterface.OnClickListener paramOnClickListener)
  {
    if (paramOnClickListener == null)
    {
      this.lBtn.setVisibility(8);
      return this;
    }
    this.lBtn.setTextColor(paramInt);
    return setNegativeButton(paramString, paramOnClickListener);
  }
  
  public AppCloseDialog setNegativeButton(String paramString, DialogInterface.OnClickListener paramOnClickListener)
  {
    if (paramOnClickListener == null)
    {
      this.lBtn.setVisibility(8);
      return this;
    }
    this.lBtn.setText(paramString);
    TextView localTextView = this.lBtn;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(getContext().getString(R.string.mini_sdk_content_desc_button));
    localTextView.setContentDescription(localStringBuilder.toString());
    this.lBtn.setVisibility(0);
    this.lBtn.setOnClickListener(new AppCloseDialog.1(this, paramOnClickListener));
    return this;
  }
  
  public AppCloseDialog setPositiveButton(String paramString, int paramInt, DialogInterface.OnClickListener paramOnClickListener)
  {
    if (paramOnClickListener == null)
    {
      this.rBtn.setVisibility(8);
      return this;
    }
    this.rBtn.setTextColor(paramInt);
    return setPositiveButton(paramString, paramOnClickListener);
  }
  
  public AppCloseDialog setPositiveButton(String paramString, DialogInterface.OnClickListener paramOnClickListener)
  {
    if (paramOnClickListener == null)
    {
      this.rBtn.setVisibility(8);
      return this;
    }
    this.rBtn.setText(paramString);
    TextView localTextView = this.rBtn;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(getContext().getString(R.string.mini_sdk_content_desc_button));
    localTextView.setContentDescription(localStringBuilder.toString());
    this.rBtn.setVisibility(0);
    this.rBtn.setOnClickListener(new AppCloseDialog.2(this, paramOnClickListener));
    return this;
  }
  
  public void setTextSingleLine(boolean paramBoolean)
  {
    this.title.setSingleLine(paramBoolean);
  }
  
  public AppCloseDialog setTitle(String paramString)
  {
    if (paramString != null)
    {
      this.title.setText(paramString);
      this.title.setVisibility(0);
      return this;
    }
    this.title.setVisibility(8);
    return this;
  }
  
  public void setTitleHeight(int paramInt)
  {
    this.title.setHeight(paramInt);
  }
  
  public void setTitleTextBold()
  {
    this.title.setTypeface(Typeface.DEFAULT, 1);
  }
  
  public AppCloseDialog setView(View paramView)
  {
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
    this.bodyLayout.addView(paramView, localLayoutParams);
    return this;
  }
  
  public void show()
  {
    if ((this.rBtn.getVisibility() != 8) && (this.lBtn.getVisibility() != 8)) {
      findViewById(R.id.btnDivider).setVisibility(0);
    }
    super.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.widget.AppCloseDialog
 * JD-Core Version:    0.7.0.1
 */