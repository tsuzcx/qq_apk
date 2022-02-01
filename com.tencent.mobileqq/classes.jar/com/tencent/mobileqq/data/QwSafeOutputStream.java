package com.tencent.mobileqq.data;

import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;

public class QwSafeOutputStream
{
  private ByteArrayOutputStream mByteArrayOutputStream = new ByteArrayOutputStream();
  private ObjectOutputStream mObjectOutputStream = new ObjectOutputStream(this.mByteArrayOutputStream);
  
  public byte[] flushDataAndCloseStream()
  {
    try
    {
      this.mObjectOutputStream.close();
      try
      {
        byte[] arrayOfByte1 = this.mByteArrayOutputStream.toByteArray();
      }
      catch (Exception localException1)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.qqwalletmsg", 2, "flushDataAndCloseStream toByteArray Exception", localException1);
        }
        arrayOfByte2 = null;
      }
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        try
        {
          byte[] arrayOfByte2;
          this.mByteArrayOutputStream.close();
          return arrayOfByte2;
        }
        catch (Exception localException3) {}
        localException2 = localException2;
      }
      return localException2;
    }
  }
  
  public void writeBoolean(boolean paramBoolean)
  {
    this.mObjectOutputStream.writeBoolean(paramBoolean);
  }
  
  public void writeInt(int paramInt)
  {
    this.mObjectOutputStream.writeInt(paramInt);
  }
  
  public void writeObject(Object paramObject)
  {
    this.mObjectOutputStream.writeObject(paramObject);
  }
  
  public void writeUTF(String paramString)
  {
    writeUTF(paramString, "");
  }
  
  public void writeUTF(String paramString1, String paramString2)
  {
    if (paramString1 == null)
    {
      this.mObjectOutputStream.writeUTF(paramString2);
      return;
    }
    this.mObjectOutputStream.writeUTF(paramString1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.data.QwSafeOutputStream
 * JD-Core Version:    0.7.0.1
 */