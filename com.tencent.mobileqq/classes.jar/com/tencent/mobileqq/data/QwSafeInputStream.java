package com.tencent.mobileqq.data;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;

public class QwSafeInputStream
{
  private ByteArrayInputStream mByteArrayInputStream;
  private boolean mHasException;
  private ObjectInputStream mObjectInputStream;
  
  private QwSafeInputStream() {}
  
  public QwSafeInputStream(byte[] paramArrayOfByte)
  {
    this.mByteArrayInputStream = new ByteArrayInputStream(paramArrayOfByte);
    this.mObjectInputStream = new ObjectInputStream(this.mByteArrayInputStream);
  }
  
  public void close()
  {
    try
    {
      this.mObjectInputStream.close();
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        try
        {
          this.mByteArrayInputStream.close();
          return;
        }
        catch (Exception localException2) {}
        localException1 = localException1;
      }
    }
  }
  
  public boolean readBoolean()
  {
    return readBoolean(false);
  }
  
  public boolean readBoolean(boolean paramBoolean)
  {
    if (!this.mHasException) {}
    try
    {
      boolean bool = this.mObjectInputStream.readBoolean();
      return bool;
    }
    catch (Exception localException)
    {
      label17:
      break label17;
    }
    this.mHasException = true;
    return paramBoolean;
  }
  
  public int readInt()
  {
    return readInt(0);
  }
  
  public int readInt(int paramInt)
  {
    if (!this.mHasException) {}
    try
    {
      int i = this.mObjectInputStream.readInt();
      return i;
    }
    catch (Exception localException)
    {
      label17:
      break label17;
    }
    this.mHasException = true;
    return paramInt;
  }
  
  public Object readObject(Object paramObject)
  {
    if (!this.mHasException) {}
    try
    {
      Object localObject = this.mObjectInputStream.readObject();
      return localObject;
    }
    catch (Exception localException)
    {
      label17:
      break label17;
    }
    this.mHasException = true;
    return paramObject;
  }
  
  public String readUTF()
  {
    return readUTF("");
  }
  
  public String readUTF(String paramString)
  {
    if (!this.mHasException) {}
    try
    {
      String str = this.mObjectInputStream.readUTF();
      return str;
    }
    catch (Exception localException)
    {
      label17:
      break label17;
    }
    this.mHasException = true;
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.QwSafeInputStream
 * JD-Core Version:    0.7.0.1
 */