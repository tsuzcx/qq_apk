package com.tencent.mobileqq.mixedmsg;

import java.io.Serializable;

public abstract class MixedMsgInfo$MsgNode
  implements Serializable
{
  public int length()
  {
    if (text() == null) {
      return 0;
    }
    return text().length();
  }
  
  public abstract String text();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mixedmsg.MixedMsgInfo.MsgNode
 * JD-Core Version:    0.7.0.1
 */