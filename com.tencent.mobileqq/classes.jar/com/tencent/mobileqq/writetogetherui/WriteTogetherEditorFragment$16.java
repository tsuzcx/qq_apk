package com.tencent.mobileqq.writetogetherui;

import android.text.TextUtils;
import com.tencent.mobileqq.writetogether.statemachine.CreatingState;
import com.tencent.mobileqq.writetogether.statemachine.CreatingStateMachineController;

class WriteTogetherEditorFragment$16
  implements Runnable
{
  WriteTogetherEditorFragment$16(WriteTogetherEditorFragment paramWriteTogetherEditorFragment) {}
  
  public void run()
  {
    if (WriteTogetherEditorFragment.a(this.this$0).a() == CreatingState.TEMPLATE_FIRST_USE)
    {
      if (TextUtils.isEmpty(WriteTogetherEditorFragment.a(this.this$0).a()))
      {
        WriteTogetherEditorFragment.a(this.this$0).a(CreatingState.TEMPLATE_SHOW_LAYER);
        return;
      }
      WriteTogetherEditorFragment.a(this.this$0).a(CreatingState.TEMPLATE_SHOW_ENTRANCE);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.writetogetherui.WriteTogetherEditorFragment.16
 * JD-Core Version:    0.7.0.1
 */