package com.tencent.mobileqq.data;

import com.tencent.mobileqq.confess.data.TroopConfessMsg;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;

public class MessageForTroopConfess
  extends ChatMessage
{
  public boolean isToSelf;
  public TroopConfessMsg mTroopConfessMsg;
  
  public MessageForTroopConfess() {}
  
  public MessageForTroopConfess(long paramLong1, long paramLong2, long paramLong3, long paramLong4, int paramInt, long paramLong5)
  {
    init(paramLong1, paramLong2, paramLong3, "[TroopConfess]", paramLong4, -2067, paramInt, paramLong5);
  }
  
  public void doParse()
  {
    try
    {
      this.mTroopConfessMsg = new TroopConfessMsg();
      ObjectInputStream localObjectInputStream = new ObjectInputStream(new ByteArrayInputStream(this.msgData));
      this.mTroopConfessMsg.readExternal(localObjectInputStream);
      localObjectInputStream.close();
      this.msg = this.mTroopConfessMsg.getSimpleMsg();
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.TroopConfess", 2, "convert byte array to TroopConfessMsg failed", localException);
      }
      this.mTroopConfessMsg = null;
    }
  }
  
  public long getConfessToUin()
  {
    TroopConfessMsg localTroopConfessMsg = this.mTroopConfessMsg;
    if (localTroopConfessMsg != null) {
      return localTroopConfessMsg.getConfessToUin();
    }
    return 0L;
  }
  
  public int getConfessTopicId()
  {
    TroopConfessMsg localTroopConfessMsg = this.mTroopConfessMsg;
    if (localTroopConfessMsg != null) {
      return localTroopConfessMsg.getConfessTopicId();
    }
    return 0;
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
    TroopConfessMsg localTroopConfessMsg = this.mTroopConfessMsg;
    if (localTroopConfessMsg != null) {
      try
      {
        this.msgData = localTroopConfessMsg.getBytes();
        return;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.TroopConfess", 2, "convert TroopConfessItem to byte array failed", localException);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForTroopConfess
 * JD-Core Version:    0.7.0.1
 */