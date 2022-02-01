package com.tencent.mobileqq.kandian.repo.db.struct;

import com.tencent.mobileqq.persistence.Entity;

public class ChannelTopCookie
  extends Entity
  implements Cloneable
{
  public static final String TABLE_NAME = "ChannelTopCookie";
  public int mChannelID = -1;
  public byte[] mSetTopCookie;
  
  public ChannelTopCookie clone()
  {
    try
    {
      ChannelTopCookie localChannelTopCookie = (ChannelTopCookie)super.clone();
      return localChannelTopCookie;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      localCloneNotSupportedException.printStackTrace();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.db.struct.ChannelTopCookie
 * JD-Core Version:    0.7.0.1
 */