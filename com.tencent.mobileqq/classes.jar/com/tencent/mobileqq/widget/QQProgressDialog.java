package com.tencent.mobileqq.widget;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.util.QQTextToSpeechHelper;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

public class QQProgressDialog
  extends ReportDialog
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int = 0;
  private Context jdField_a_of_type_AndroidContentContext;
  private Animatable jdField_a_of_type_AndroidGraphicsDrawableAnimatable;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView = null;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private QQProgressDialog.Callback jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog$Callback;
  String jdField_a_of_type_JavaLangString;
  private int jdField_b_of_type_Int = 48;
  private ImageView jdField_b_of_type_AndroidWidgetImageView = null;
  private int c = -2;
  
  public QQProgressDialog(Context paramContext)
  {
    this(paramContext, 0);
  }
  
  public QQProgressDialog(Context paramContext, int paramInt)
  {
    this(paramContext, paramInt, 2131561394, 48);
  }
  
  public QQProgressDialog(Context paramContext, int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramContext, 2131756189);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
    this.jdField_a_of_type_Float = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().density;
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(paramInt2, null);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131363664));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131371534));
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt3;
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131378779));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131378780));
    this.jdField_a_of_type_AndroidGraphicsDrawableAnimatable = ((Animatable)this.jdField_b_of_type_AndroidWidgetImageView.getDrawable());
  }
  
  public void a(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void a(Drawable paramDrawable)
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundDrawable(paramDrawable);
  }
  
  public void a(QQProgressDialog.Callback paramCallback)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog$Callback = paramCallback;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
  }
  
  public void a(boolean paramBoolean)
  {
    ImageView localImageView = this.jdField_a_of_type_AndroidWidgetImageView;
    if (localImageView == null) {
      return;
    }
    if (paramBoolean)
    {
      localImageView.setVisibility(0);
      return;
    }
    localImageView.setVisibility(8);
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.jdField_b_of_type_AndroidWidgetImageView == null) {
      return;
    }
    if (paramBoolean)
    {
      if (!this.jdField_a_of_type_AndroidGraphicsDrawableAnimatable.isRunning()) {
        this.jdField_a_of_type_AndroidGraphicsDrawableAnimatable.start();
      }
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      return;
    }
    if (this.jdField_a_of_type_AndroidGraphicsDrawableAnimatable.isRunning()) {
      this.jdField_a_of_type_AndroidGraphicsDrawableAnimatable.stop();
    }
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  public void c(int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramInt);
  }
  
  public void c(boolean paramBoolean)
  {
    setOnKeyListener(new QQProgressDialog.2(this, paramBoolean));
  }
  
  public void d(int paramInt)
  {
    ImageView localImageView = this.jdField_a_of_type_AndroidWidgetImageView;
    if (localImageView == null) {
      return;
    }
    localImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(paramInt);
  }
  
  /* Error */
  public void dismiss()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 154	android/app/Dialog:dismiss	()V
    //   4: aload_0
    //   5: invokestatic 159	com/tencent/qqperf/monitor/memory/ActivityLeakSolution:a	(Landroid/app/Dialog;)V
    //   8: return
    //   9: astore_1
    //   10: aload_0
    //   11: invokestatic 159	com/tencent/qqperf/monitor/memory/ActivityLeakSolution:a	(Landroid/app/Dialog;)V
    //   14: aload_1
    //   15: athrow
    //   16: astore_1
    //   17: goto -13 -> 4
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	20	0	this	QQProgressDialog
    //   9	6	1	localObject	java.lang.Object
    //   16	1	1	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   0	4	9	finally
    //   0	4	16	java/lang/Exception
  }
  
  public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      return super.dispatchPopulateAccessibilityEvent(paramAccessibilityEvent);
    }
    if (QQUIDelegate.b) {
      QQTextToSpeechHelper.a(this.jdField_a_of_type_JavaLangString);
    }
    return true;
  }
  
  public void e(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void f(@DrawableRes int paramInt)
  {
    this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(paramInt);
  }
  
  public void onBackPressed()
  {
    super.onBackPressed();
    QQProgressDialog.Callback localCallback = this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog$Callback;
    if (localCallback != null) {
      localCallback.a();
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getWindow();
    paramBundle.setContentView(this.jdField_a_of_type_AndroidViewView);
    WindowManager.LayoutParams localLayoutParams = paramBundle.getAttributes();
    localLayoutParams.width = -1;
    localLayoutParams.height = this.c;
    localLayoutParams.gravity = this.jdField_b_of_type_Int;
    localLayoutParams.y += this.jdField_a_of_type_Int;
    paramBundle.setAttributes(localLayoutParams);
    setCanceledOnTouchOutside(false);
  }
  
  protected void onStart()
  {
    this.jdField_b_of_type_AndroidWidgetImageView.postDelayed(new QQProgressDialog.1(this), 50L);
    super.onStart();
  }
  
  protected void onStop()
  {
    if (this.jdField_a_of_type_AndroidGraphicsDrawableAnimatable.isRunning()) {
      this.jdField_a_of_type_AndroidGraphicsDrawableAnimatable.stop();
    }
    super.onStop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.QQProgressDialog
 * JD-Core Version:    0.7.0.1
 */