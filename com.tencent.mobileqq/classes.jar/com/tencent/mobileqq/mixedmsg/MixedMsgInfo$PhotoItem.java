package com.tencent.mobileqq.mixedmsg;

import java.io.Serializable;

public class MixedMsgInfo$PhotoItem
  implements Serializable
{
  public boolean isOriginal;
  public String path;
  
  public MixedMsgInfo$PhotoItem() {}
  
  public MixedMsgInfo$PhotoItem(String paramString, boolean paramBoolean)
  {
    this.isOriginal = paramBoolean;
    this.path = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mixedmsg.MixedMsgInfo.PhotoItem
 * JD-Core Version:    0.7.0.1
 */