package com.tencent.mobileqq.newfriend.msg;

import com.tencent.mobileqq.newfriend.config.NewFriendContactGuideConfBean;

public class NewFriendBindContactGuideMsgV2
  extends NewFriendMessage
{
  public final NewFriendContactGuideConfBean a;
  public final boolean b;
  
  public NewFriendBindContactGuideMsgV2(NewFriendContactGuideConfBean paramNewFriendContactGuideConfBean, boolean paramBoolean)
  {
    this.a = paramNewFriendContactGuideConfBean;
    this.b = paramBoolean;
  }
  
  public boolean b()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.newfriend.msg.NewFriendBindContactGuideMsgV2
 * JD-Core Version:    0.7.0.1
 */