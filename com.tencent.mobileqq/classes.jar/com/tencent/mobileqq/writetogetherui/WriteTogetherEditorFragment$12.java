package com.tencent.mobileqq.writetogetherui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.QBaseActivity;

class WriteTogetherEditorFragment$12
  implements DialogInterface.OnClickListener
{
  WriteTogetherEditorFragment$12(WriteTogetherEditorFragment paramWriteTogetherEditorFragment) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    this.a.getQBaseActivity().finish();
    WriteTogetherEditorFragment.c(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.writetogetherui.WriteTogetherEditorFragment.12
 * JD-Core Version:    0.7.0.1
 */