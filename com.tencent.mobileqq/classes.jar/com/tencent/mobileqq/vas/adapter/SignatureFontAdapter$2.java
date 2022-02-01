package com.tencent.mobileqq.vas.adapter;

import com.etrump.mixlayout.ETTextView;
import com.etrump.mixlayout.ETTextView.TextAnimationListener;
import com.tencent.mobileqq.data.ChatMessage;

class SignatureFontAdapter$2
  extends ETTextView.TextAnimationListener
{
  SignatureFontAdapter$2(SignatureFontAdapter paramSignatureFontAdapter) {}
  
  public void a(ChatMessage paramChatMessage, int paramInt)
  {
    if ((SignatureFontAdapter.a(this.a) < 0) || (SignatureFontAdapter.b(this.a) < SignatureFontAdapter.a(this.a)))
    {
      SignatureFontAdapter.a(this.a).shouldStartAnimation = true;
      SignatureFontAdapter.a(this.a).startAnimation(false, false);
      if (SignatureFontAdapter.a(this.a) > 0) {
        SignatureFontAdapter.c(this.a);
      }
    }
  }
  
  public void a(ChatMessage paramChatMessage, boolean paramBoolean, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.adapter.SignatureFontAdapter.2
 * JD-Core Version:    0.7.0.1
 */