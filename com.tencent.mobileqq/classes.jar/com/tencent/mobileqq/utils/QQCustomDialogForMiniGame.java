package com.tencent.mobileqq.utils;

import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;

public class QQCustomDialogForMiniGame
  extends QQCustomDialog
{
  public QQCustomDialogForMiniGame(Context paramContext)
  {
    super(paramContext);
  }
  
  public QQCustomDialogForMiniGame(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  protected QQCustomDialogForMiniGame(Context paramContext, boolean paramBoolean, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    super(paramContext, paramBoolean, paramOnCancelListener);
  }
  
  public void setBodyLayoutNoMargin()
  {
    this.rootView.setPadding(0, 0, 0, 0);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.bodyLayout.getLayoutParams();
    localLayoutParams.setMargins(0, 0, 0, 0);
    this.bodyLayout.setLayoutParams(localLayoutParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.QQCustomDialogForMiniGame
 * JD-Core Version:    0.7.0.1
 */