package com.tencent.mobileqq.qqexpand.flutter.channel;

import com.tencent.qqexpand.ExpandChannelDelegates;

public class ExpandChannelMethodImpl
  extends ExpandChannelDelegates
{
  public void initDelegate()
  {
    this.mPushModuleDelegate = new ExpandChannelMethodPushModelImpl();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.flutter.channel.ExpandChannelMethodImpl
 * JD-Core Version:    0.7.0.1
 */