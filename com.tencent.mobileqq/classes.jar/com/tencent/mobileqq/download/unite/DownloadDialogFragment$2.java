package com.tencent.mobileqq.download.unite;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.onlinestatus.ReportHelperKt;

class DownloadDialogFragment$2
  implements DialogInterface.OnClickListener
{
  DownloadDialogFragment$2(DownloadDialogFragment paramDownloadDialogFragment) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    DownloadDialogFragment.a(this.a, 1);
    DownloadDialogFragment.a(this.a.getBaseActivity());
    ReportHelperKt.a("0X800B53C");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.download.unite.DownloadDialogFragment.2
 * JD-Core Version:    0.7.0.1
 */