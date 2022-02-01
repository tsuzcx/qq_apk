package com.tencent.mobileqq.flashshow.widgets.share;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.os.Bundle;
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
import com.tencent.biz.qcircleshadow.lib.QCircleHostConstants._AppSetting;
import com.tencent.biz.qcircleshadow.lib.variation.HostAppInterfaceUtil;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

public class FSProgressDialog
  extends ReportDialog
{
  String a;
  private float b;
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
  private FSProgressDialog.Callback n;
  
  public FSProgressDialog(Context paramContext)
  {
    this(paramContext, 0);
  }
  
  public FSProgressDialog(Context paramContext, int paramInt)
  {
    this(paramContext, paramInt, 2131624842, 48);
  }
  
  public FSProgressDialog(Context paramContext, int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramContext, 2131952059);
    this.c = paramContext;
    this.d = LayoutInflater.from(paramContext);
    this.b = this.c.getResources().getDisplayMetrics().density;
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
    this.f.setText(paramInt);
  }
  
  /* Error */
  public void dismiss()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 127	android/app/Dialog:dismiss	()V
    //   4: aload_0
    //   5: invokestatic 132	com/tencent/mobileqq/flashshow/utils/FSViewUtils:a	(Landroid/app/Dialog;)V
    //   8: return
    //   9: astore_1
    //   10: aload_0
    //   11: invokestatic 132	com/tencent/mobileqq/flashshow/utils/FSViewUtils:a	(Landroid/app/Dialog;)V
    //   14: aload_1
    //   15: athrow
    //   16: astore_1
    //   17: goto -13 -> 4
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	20	0	this	FSProgressDialog
    //   9	6	1	localObject	java.lang.Object
    //   16	1	1	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   0	4	9	finally
    //   0	4	16	java/lang/Exception
  }
  
  public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    if (TextUtils.isEmpty(this.a)) {
      return super.dispatchPopulateAccessibilityEvent(paramAccessibilityEvent);
    }
    if (QCircleHostConstants._AppSetting.enableTalkBack()) {
      HostAppInterfaceUtil.speak(this.a);
    }
    return true;
  }
  
  public void onBackPressed()
  {
    super.onBackPressed();
    FSProgressDialog.Callback localCallback = this.n;
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
    this.h.postDelayed(new FSProgressDialog.1(this), 50L);
    super.onStart();
  }
  
  protected void onStop()
  {
    if (this.i.isRunning()) {
      this.i.stop();
    }
    super.onStop();
  }
  
  public void show()
  {
    Context localContext = this.c;
    if (((localContext instanceof Activity)) && (((Activity)localContext).isFinishing())) {
      return;
    }
    super.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.widgets.share.FSProgressDialog
 * JD-Core Version:    0.7.0.1
 */