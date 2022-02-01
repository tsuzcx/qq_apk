package com.tencent.mobileqq.togetherui.writetogether;

import beok;
import bepg;
import berv;
import com.tencent.mobileqq.together.writetogether.statemachine.EditorState;

public class WriteTogetherEditorFragment$7$1
  implements Runnable
{
  public WriteTogetherEditorFragment$7$1(berv paramberv) {}
  
  public void run()
  {
    if (this.a.a.a.a() == EditorState.CREATING)
    {
      WriteTogetherEditorFragment.a(this.a.a).c();
      WriteTogetherEditorFragment.a(this.a.a).e();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.togetherui.writetogether.WriteTogetherEditorFragment.7.1
 * JD-Core Version:    0.7.0.1
 */