package com.tencent.mobileqq.nearby.api.impl;

import com.tencent.mobileqq.nearby.api.HotChatReadConfirmCallback;
import com.tencent.mobileqq.nearby.api.IHotChatReadConfirmCallback;

public class HotChatReadConfirmCallbackImpl
  implements IHotChatReadConfirmCallback
{
  private final HotChatReadConfirmCallback mHotChatReadConfirmCallback = new HotChatReadConfirmCallback();
  
  public Object get()
  {
    return this.mHotChatReadConfirmCallback;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.api.impl.HotChatReadConfirmCallbackImpl
 * JD-Core Version:    0.7.0.1
 */