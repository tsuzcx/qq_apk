package com.tencent.mobileqq.extendfriend.wiget;

import android.app.Dialog;
import android.content.Context;
import android.os.Build.VERSION;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import androidx.annotation.NonNull;
import com.tencent.ark.ArkViewImplement.LoadCallback;
import com.tencent.ark.open.ArkAppInfo.Size;
import com.tencent.ark.open.ArkView;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

public class ExtendFriendSafeTipArkDialog
  extends ReportDialog
{
  private ArkView a;
  
  public ExtendFriendSafeTipArkDialog(@NonNull Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
    super.getWindow().setWindowAnimations(2131755132);
    if (Build.VERSION.SDK_INT >= 14) {
      getWindow().setDimAmount(0.5F);
    }
  }
  
  public static View a(ArkView paramArkView, ArkViewImplement.LoadCallback paramLoadCallback)
  {
    int i = ViewUtils.a();
    ArkAppInfo.Size localSize = new ArkAppInfo.Size(i, (int)(i / 0.641921F));
    paramArkView.setSize(localSize, localSize, localSize);
    paramArkView.setBorderType(1);
    paramArkView.load("com.tencent.mobileqq.expand.aiosafe", "expand_aio_safetip", "1.0.0.0", "", "", paramLoadCallback);
    return paramArkView;
  }
  
  private void d()
  {
    getWindow().getDecorView().setPadding(0, 0, 0, 0);
  }
  
  public void a()
  {
    if (this.a != null) {
      this.a.onResume();
    }
  }
  
  public void a(ArkView paramArkView)
  {
    this.a = paramArkView;
  }
  
  public void b()
  {
    if (this.a != null) {
      this.a.onPause();
    }
  }
  
  public void c()
  {
    if (this.a != null)
    {
      this.a.onDestroy();
      this.a = null;
    }
  }
  
  public void dismiss()
  {
    if (isShowing())
    {
      if (this.a != null)
      {
        this.a.onPause();
        this.a.onDestroy();
        this.a = null;
      }
      super.dismiss();
    }
  }
  
  public void setContentView(int paramInt)
  {
    try
    {
      getWindow().setFlags(16777216, 16777216);
      super.setContentView(paramInt);
      FrameLayout localFrameLayout = (FrameLayout)findViewById(2131363019);
      if (this.a == null)
      {
        QLog.w("ExtendFriendArkDialog", 1, "arkView is null!");
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("ExtendFriendArkDialog", 1, localException.getMessage());
      }
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
      localLayoutParams.gravity = 17;
      localException.addView(this.a, localLayoutParams);
      this.a.setVisibility(0);
    }
  }
  
  public void show()
  {
    super.show();
    d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.wiget.ExtendFriendSafeTipArkDialog
 * JD-Core Version:    0.7.0.1
 */