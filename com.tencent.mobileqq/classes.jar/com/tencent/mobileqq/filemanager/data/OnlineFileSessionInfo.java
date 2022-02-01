package com.tencent.mobileqq.filemanager.data;

public class OnlineFileSessionInfo
  implements Cloneable
{
  public String a;
  public long b;
  public long c;
  public int d = 0;
  public long e = -1L;
  public byte[] f = new byte[16];
  public boolean g = false;
  public int h = 0;
  public boolean i = false;
  public short j = 0;
  public short k = 0;
  public boolean l = false;
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.OnlineFileSessionInfo
 * JD-Core Version:    0.7.0.1
 */