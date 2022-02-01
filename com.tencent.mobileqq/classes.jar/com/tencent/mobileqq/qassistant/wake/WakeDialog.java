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
  public static boolean a = false;
  protected Context a;
  
  public WakeDialog(@NonNull Context paramContext, boolean paramBoolean)
  {
    super(paramContext, 2131755376);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    setCanceledOnTouchOutside(true);
    jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void dismiss()
  {
    jdField_a_of_type_Boolean = false;
    super.dismiss();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561579, null);
    setContentView(paramBundle);
    Object localObject = paramBundle.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).width = paramBundle.getResources().getDisplayMetrics().widthPixels;
    paramBundle.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = getWindow();
    ((Window)localObject).setWindowAnimations(2131755930);
    ((Window)localObject).setGravity(80);
    ((ImageView)paramBundle.findViewById(2131362936)).setOnClickListener(new WakeDialog.1(this));
  }
  
  public void show()
  {
    super.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.wake.WakeDialog
 * JD-Core Version:    0.7.0.1
 */