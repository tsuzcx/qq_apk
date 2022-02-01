package com.tencent.mobileqq.writetogetherui;

import com.tencent.mobileqq.writetogether.client.UserStateController;
import com.tencent.mobileqq.writetogether.statemachine.EditorState;
import com.tencent.mobileqq.writetogether.statemachine.EditorStateMachineController;

class WriteTogetherEditorFragment$7$1
  implements Runnable
{
  WriteTogetherEditorFragment$7$1(WriteTogetherEditorFragment.7 param7) {}
  
  public void run()
  {
    if (this.a.a.a.a() == EditorState.CREATING)
    {
      WriteTogetherEditorFragment.a(this.a.a).c();
      WriteTogetherEditorFragment.a(this.a.a).e();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.writetogetherui.WriteTogetherEditorFragment.7.1
 * JD-Core Version:    0.7.0.1
 */