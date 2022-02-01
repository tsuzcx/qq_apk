package com.tencent.qqlive.module.videoreport.inject.dialog;

import android.app.ProgressDialog;
import android.content.Context;
import android.support.annotation.NonNull;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ReportProgressDialog
  extends ProgressDialog
{
  public ReportProgressDialog(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  public ReportProgressDialog(@NonNull Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  protected void onStop()
  {
    super.onStop();
    EventCollector.getInstance().onDialogStop(this);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    EventCollector.getInstance().onDialogFocusChanged(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.inject.dialog.ReportProgressDialog
 * JD-Core Version:    0.7.0.1
 */