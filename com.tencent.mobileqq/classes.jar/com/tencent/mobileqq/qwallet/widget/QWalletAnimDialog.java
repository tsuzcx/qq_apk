package com.tencent.mobileqq.qwallet.widget;

import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.graphics.drawable.ColorDrawable;
import android.view.Window;
import com.tencent.mobileqq.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.widget.AnimationView;
import com.tencent.mobileqq.widget.AnimationView.AnimationInfo;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.widget.immersive.ImmersiveUtils;

public class QWalletAnimDialog
  extends ReportDialog
{
  protected long a;
  protected boolean b = false;
  protected String c;
  protected String d;
  protected String e;
  protected Activity f;
  private AnimationView g;
  private AnimationView.AnimationInfo h;
  private BroadcastReceiver i = new QWalletAnimDialog.2(this);
  
  public QWalletAnimDialog(Activity paramActivity, int paramInt, AnimationView.AnimationInfo paramAnimationInfo, long paramLong)
  {
    super(paramActivity, paramInt);
    this.h = paramAnimationInfo;
    this.a = paramLong;
    this.f = paramActivity;
    a();
  }
  
  private void a()
  {
    super.requestWindowFeature(1);
    Object localObject = getWindow();
    setContentView(2131628491);
    ((Window)localObject).setLayout(-1, -1);
    ((Window)localObject).setBackgroundDrawable(new ColorDrawable(0));
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      ((Window)localObject).addFlags(67108864);
    }
    setCanceledOnTouchOutside(false);
    this.g = ((AnimationView)findViewById(2131430428));
    this.g.setAnimationFromInfo(this.h);
    this.g.setAnimationListener(new QWalletAnimDialog.1(this));
    localObject = new IntentFilter();
    ((IntentFilter)localObject).addAction("qwallet.facetoface");
    getContext().registerReceiver(this.i, (IntentFilter)localObject);
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    this.c = paramString1;
    this.d = paramString2;
    this.e = paramString3;
  }
  
  public void dismiss()
  {
    super.dismiss();
    getContext().unregisterReceiver(this.i);
    this.g.stop();
    this.g.setImageDrawable(null);
    AnimationView.AnimationInfo localAnimationInfo = this.h;
    if (localAnimationInfo != null)
    {
      localAnimationInfo.destoryBitmaps();
      this.h = null;
    }
    this.f = null;
    VACDReportUtil.a(this.a, null, "animDialogDismiss", null, 0, null);
  }
  
  public void show()
  {
    super.show();
    this.g.play();
    VACDReportUtil.a(this.a, null, "animDialogShow", null, 0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.widget.QWalletAnimDialog
 * JD-Core Version:    0.7.0.1
 */