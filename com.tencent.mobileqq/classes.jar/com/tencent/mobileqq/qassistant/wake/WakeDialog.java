package com.tencent.mobileqq.qassistant.wake;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

public class WakeDialog
  extends ReportDialog
{
  public static boolean b = false;
  protected Context a;
  
  public WakeDialog(@NonNull Context paramContext, boolean paramBoolean)
  {
    super(paramContext, 2131952084);
    this.a = paramContext;
    setCanceledOnTouchOutside(true);
    b = paramBoolean;
  }
  
  public void dismiss()
  {
    b = false;
    super.dismiss();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = LayoutInflater.from(this.a).inflate(2131627940, null);
    setContentView(paramBundle);
    Object localObject = paramBundle.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).width = paramBundle.getResources().getDisplayMetrics().widthPixels;
    paramBundle.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = getWindow();
    ((Window)localObject).setWindowAnimations(2131953051);
    ((Window)localObject).setGravity(80);
    ((ImageView)paramBundle.findViewById(2131428735)).setOnClickListener(new WakeDialog.1(this));
  }
  
  public void show()
  {
    super.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.wake.WakeDialog
 * JD-Core Version:    0.7.0.1
 */