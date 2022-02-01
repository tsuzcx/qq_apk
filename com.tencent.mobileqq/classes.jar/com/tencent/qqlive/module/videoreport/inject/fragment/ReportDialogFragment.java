package com.tencent.qqlive.module.videoreport.inject.fragment;

import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

public class ReportDialogFragment
  extends DialogFragment
{
  public Dialog onCreateDialog(Bundle paramBundle)
  {
    return new ReportDialog(getActivity(), getTheme());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.inject.fragment.ReportDialogFragment
 * JD-Core Version:    0.7.0.1
 */