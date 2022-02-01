package com.tencent.mobileqq.data;

import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;

public class MessageForShakeWindow
  extends ChatMessage
{
  public ShakeWindowMsg mShakeWindowMsg;
  
  public MessageForShakeWindow() {}
  
  public MessageForShakeWindow(long paramLong1, long paramLong2, long paramLong3, long paramLong4, int paramInt, long paramLong5)
  {
    init(paramLong1, paramLong2, paramLong3, "[Shake Window]", paramLong4, -2020, paramInt, paramLong5);
  }
  
  protected void doParse()
  {
    try
    {
      this.mShakeWindowMsg = new ShakeWindowMsg();
      ObjectInputStream localObjectInputStream = new ObjectInputStream(new ByteArrayInputStream(this.msgData));
      this.mShakeWindowMsg.readExternal(localObjectInputStream);
      localObjectInputStream.close();
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.shakemsg", 2, "convert byte array to ShakeWindowMsg failed", localException);
      }
      this.mShakeWindowMsg = null;
    }
  }
  
  public boolean needVipBubble()
  {
    return false;
  }
  
  protected void postRead()
  {
    parse();
  }
  
  protected void prewrite()
  {
    ShakeWindowMsg localShakeWindowMsg = this.mShakeWindowMsg;
    if (localShakeWindowMsg != null) {
      try
      {
        this.msgData = localShakeWindowMsg.getBytes();
        return;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.shakemsg", 2, "convert ShakeWindowMsg to byte array failed", localException);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForShakeWindow
 * JD-Core Version:    0.7.0.1
 */