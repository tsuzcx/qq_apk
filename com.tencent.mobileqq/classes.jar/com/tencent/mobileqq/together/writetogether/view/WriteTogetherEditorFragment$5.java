package com.tencent.mobileqq.together.writetogether.view;

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
    if (WriteTogetherEditorFragment.a(this.this$0).getVisibility() == 0) {
      ((TextView)WriteTogetherEditorFragment.a(this.this$0).findViewById(2131381510)).setText(2131719395);
    }
    if (QLog.isColorLevel()) {
      QLog.d("WriteTogetherEditorFragment", 2, "[processOnCreateView#run] open timeout");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.together.writetogether.view.WriteTogetherEditorFragment.5
 * JD-Core Version:    0.7.0.1
 */