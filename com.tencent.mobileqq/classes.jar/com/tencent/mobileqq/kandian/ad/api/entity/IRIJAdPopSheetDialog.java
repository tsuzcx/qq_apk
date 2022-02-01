package com.tencent.mobileqq.kandian.ad.api.entity;

import android.content.Context;
import androidx.annotation.NonNull;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

public abstract class IRIJAdPopSheetDialog
  extends ReportDialog
{
  public IRIJAdPopSheetDialog(@NonNull Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  public abstract void a(IRIJAdPopSheetDialog.OnPopSheetDismissListener paramOnPopSheetDismissListener);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.ad.api.entity.IRIJAdPopSheetDialog
 * JD-Core Version:    0.7.0.1
 */