package com.tencent.mobileqq.wink.editor.music.ui;

import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/wink/editor/music/ui/MarqueeTextView$State;", "", "(Ljava/lang/String;I)V", "IDLE", "ANIMATING", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public enum MarqueeTextView$State
{
  static
  {
    State localState1 = new State("IDLE", 0);
    IDLE = localState1;
    State localState2 = new State("ANIMATING", 1);
    ANIMATING = localState2;
    $VALUES = new State[] { localState1, localState2 };
  }
  
  private MarqueeTextView$State() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.music.ui.MarqueeTextView.State
 * JD-Core Version:    0.7.0.1
 */