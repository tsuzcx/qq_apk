package com.tencent.mobileqq.filemanager.data;

public class OnlineFileSessionInfo
  implements Cloneable
{
  public long a;
  public String a;
  public short a;
  public boolean a;
  public byte[] a = new byte[16];
  public long b;
  public short b;
  public boolean b;
  public long c = -1L;
  
  public OnlineFileSessionInfo a()
  {
    try
    {
      OnlineFileSessionInfo localOnlineFileSessionInfo = (OnlineFileSessionInfo)super.clone();
      return localOnlineFileSessionInfo;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      localCloneNotSupportedException.printStackTrace();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.OnlineFileSessionInfo
 * JD-Core Version:    0.7.0.1
 */