package com.tencent.mobileqq.msgbackup.fragment;

import android.widget.TextView;

class MsgBackupBaseFragment$7
  implements Runnable
{
  MsgBackupBaseFragment$7(MsgBackupBaseFragment paramMsgBackupBaseFragment, TextView paramTextView, String paramString) {}
  
  public void run()
  {
    TextView localTextView = this.a;
    if (localTextView != null)
    {
      localTextView.setText(this.b);
      this.a.setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.fragment.MsgBackupBaseFragment.7
 * JD-Core Version:    0.7.0.1
 */