package com.tencent.mobileqq.filemanager.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.view.KeyEvent;
import com.tencent.widget.ActionSheet;

class UniformDownloadActivity$5
  implements DialogInterface.OnKeyListener
{
  UniformDownloadActivity$5(UniformDownloadActivity paramUniformDownloadActivity) {}
  
  public boolean onKey(DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool = false;
    if (paramInt == 4)
    {
      if (this.a.n != null)
      {
        this.a.n.dismiss();
        this.a.n = null;
      }
      this.a.finish();
      this.a.overridePendingTransition(0, 0);
      bool = true;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.UniformDownloadActivity.5
 * JD-Core Version:    0.7.0.1
 */