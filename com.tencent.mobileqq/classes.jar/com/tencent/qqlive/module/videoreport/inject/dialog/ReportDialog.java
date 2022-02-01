package com.tencent.qqlive.module.videoreport.inject.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.MotionEvent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ReportDialog
  extends Dialog
{
  public ReportDialog(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  public ReportDialog(@NonNull Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  protected ReportDialog(@NonNull Context paramContext, boolean paramBoolean, @Nullable DialogInterface.OnCancelListener paramOnCancelListener)
  {
    super(paramContext, paramBoolean, paramOnCancelListener);
  }
  
  public boolean dispatchTouchEvent(@NonNull MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onDialogDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onDialogDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog
 * JD-Core Version:    0.7.0.1
 */