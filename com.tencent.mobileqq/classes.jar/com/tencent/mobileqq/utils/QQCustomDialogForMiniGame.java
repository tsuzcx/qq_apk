package com.tencent.mobileqq.utils;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;

public class QQCustomDialogForMiniGame
  extends QQCustomDialog
{
  public QQCustomDialogForMiniGame(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  public void setBodyLayoutNoMargin()
  {
    findViewById(2131365787).setVisibility(8);
    this.rootView.setPadding(0, 0, 0, 0);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.bodyLayout.getLayoutParams();
    localLayoutParams.setMargins(0, 0, 0, 0);
    this.bodyLayout.setLayoutParams(localLayoutParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.utils.QQCustomDialogForMiniGame
 * JD-Core Version:    0.7.0.1
 */