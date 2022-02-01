package com.tencent.mobileqq.flutter.channel.expand;

import com.tencent.qqexpand.ExpandChannelDelegates;

public class ExpandChannelMethodImpl
  extends ExpandChannelDelegates
{
  public void initDelegate()
  {
    this.mPushModuleDelegate = new ExpandChannelMethodPushModelImpl();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.channel.expand.ExpandChannelMethodImpl
 * JD-Core Version:    0.7.0.1
 */