package com.tencent.mobileqq.writetogetherui;

import android.view.View;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;

class WriteTogetherEditorFragment$5
  implements Runnable
{
  WriteTogetherEditorFragment$5(WriteTogetherEditorFragment paramWriteTogetherEditorFragment) {}
  
  public void run()
  {
    WriteTogetherEditorFragment.c(this.this$0, true);
    if (WriteTogetherEditorFragment.d(this.this$0).getVisibility() == 0) {
      ((TextView)WriteTogetherEditorFragment.d(this.this$0).findViewById(2131450308)).setText(2131918148);
    }
    if (QLog.isColorLevel()) {
      QLog.d("WriteTogetherEditorFragment", 2, "[processOnCreateView#run] open timeout");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.writetogetherui.WriteTogetherEditorFragment.5
 * JD-Core Version:    0.7.0.1
 */