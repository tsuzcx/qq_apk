package com.tencent.mobileqq.widget;

import com.tencent.mobileqq.activity.aio.item.ChatThumbView;
import java.util.Stack;

class MixedMsgLinearLayout$ImageScrapHeap
{
  private Stack<ChatThumbView> jdField_a_of_type_JavaUtilStack = new Stack();
  
  MixedMsgLinearLayout$ImageScrapHeap(MixedMsgLinearLayout paramMixedMsgLinearLayout) {}
  
  public ChatThumbView a()
  {
    if (this.jdField_a_of_type_JavaUtilStack.isEmpty()) {
      return null;
    }
    return (ChatThumbView)this.jdField_a_of_type_JavaUtilStack.pop();
  }
  
  public void a(ChatThumbView paramChatThumbView)
  {
    this.jdField_a_of_type_JavaUtilStack.push(paramChatThumbView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.MixedMsgLinearLayout.ImageScrapHeap
 * JD-Core Version:    0.7.0.1
 */