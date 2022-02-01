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
  private float a;
  String b;
  private Context c;
  private LayoutInflater d;
  private View e;
  private TextView f;
  private ImageView g = null;
  private ImageView h = null;
  private Animatable i;
  private LinearLayout j;
  private int k = 0;
  private int l = 48;
  private int m = -2;
  private QQProgressDialog.Callback n;
  
  public QQProgressDialog(Context paramContext)
  {
    this(paramContext, 0);
  }
  
  public QQProgressDialog(Context paramContext, int paramInt)
  {
    this(paramContext, paramInt, 2131627750, 48);
  }
  
  public QQProgressDialog(Context paramContext, int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramContext, 2131953338);
    this.c = paramContext;
    this.d = LayoutInflater.from(paramContext);
    this.a = this.c.getResources().getDisplayMetrics().density;
    this.e = this.d.inflate(paramInt2, null);
    this.j = ((LinearLayout)this.e.findViewById(2131429577));
    this.f = ((TextView)this.e.findViewById(2131438913));
    this.k = paramInt1;
    this.l = paramInt3;
    this.g = ((ImageView)this.e.findViewById(2131447458));
    this.h = ((ImageView)this.e.findViewById(2131447459));
    this.i = ((Animatable)this.h.getDrawable());
  }
  
  public void a(int paramInt)
  {
    this.m = paramInt;
  }
  
  public void a(Drawable paramDrawable)
  {
    this.j.setBackgroundDrawable(paramDrawable);
  }
  
  public void a(QQProgressDialog.Callback paramCallback)
  {
    this.n = paramCallback;
  }
  
  public void a(String paramString)
  {
    this.f.setText(paramString);
  }
  
  public void a(boolean paramBoolean)
  {
    ImageView localImageView = this.g;
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
    this.k = paramInt;
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.h == null) {
      return;
    }
    if (paramBoolean)
    {
      if (!this.i.isRunning()) {
        this.i.start();
      }
      this.h.setVisibility(0);
      return;
    }
    if (this.i.isRunning()) {
      this.i.stop();
    }
    this.h.setVisibility(8);
  }
  
  public void c(int paramInt)
  {
    this.f.setText(paramInt);
  }
  
  public void c(boolean paramBoolean)
  {
    setOnKeyListener(new QQProgressDialog.2(this, paramBoolean));
  }
  
  public void d(int paramInt)
  {
    ImageView localImageView = this.g;
    if (localImageView == null) {
      return;
    }
    localImageView.setVisibility(0);
    this.g.setImageResource(paramInt);
  }
  
  /* Error */
  public void dismiss()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 164	android/app/Dialog:dismiss	()V
    //   4: aload_0
    //   5: invokestatic 169	com/tencent/qqperf/monitor/memory/ActivityLeakSolution:a	(Landroid/app/Dialog;)V
    //   8: return
    //   9: astore_1
    //   10: aload_0
    //   11: invokestatic 169	com/tencent/qqperf/monitor/memory/ActivityLeakSolution:a	(Landroid/app/Dialog;)V
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
    if (TextUtils.isEmpty(this.b)) {
      return super.dispatchPopulateAccessibilityEvent(paramAccessibilityEvent);
    }
    if (QQUIDelegate.b) {
      QQTextToSpeechHelper.a(this.b);
    }
    return true;
  }
  
  public void e(int paramInt)
  {
    this.l = paramInt;
  }
  
  public void f(@DrawableRes int paramInt)
  {
    this.h.setImageResource(paramInt);
  }
  
  public void onBackPressed()
  {
    super.onBackPressed();
    QQProgressDialog.Callback localCallback = this.n;
    if (localCallback != null) {
      localCallback.a();
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getWindow();
    paramBundle.setContentView(this.e);
    WindowManager.LayoutParams localLayoutParams = paramBundle.getAttributes();
    localLayoutParams.width = -1;
    localLayoutParams.height = this.m;
    localLayoutParams.gravity = this.l;
    localLayoutParams.y += this.k;
    paramBundle.setAttributes(localLayoutParams);
    setCanceledOnTouchOutside(false);
  }
  
  protected void onStart()
  {
    this.h.postDelayed(new QQProgressDialog.1(this), 50L);
    super.onStart();
  }
  
  protected void onStop()
  {
    if (this.i.isRunning()) {
      this.i.stop();
    }
    super.onStop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.QQProgressDialog
 * JD-Core Version:    0.7.0.1
 */