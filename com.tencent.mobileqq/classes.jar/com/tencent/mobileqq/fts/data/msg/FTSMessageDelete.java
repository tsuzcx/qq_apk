package com.tencent.mobileqq.fts.data.msg;

import com.tencent.qphone.base.util.QLog;

public class FTSMessageDelete
  extends FTSMessageSync
{
  public static final String MSG_DEL_LOG_TABLE = "msg_del_log";
  public long delCounter;
  public int mode;
  
  public void deleteAll()
  {
    this.mode = 3;
    if (QLog.isColorLevel()) {
      QLog.d("Q.fts.FTSMessage", 2, new Object[] { "insert delete all uin:", String.valueOf(this.uin), " istroop:", String.valueOf(this.istroop) });
    }
  }
  
  public void deleteEntire()
  {
    this.mode = 4;
  }
  
  public void deleteOne()
  {
    this.mode = 1;
  }
  
  public void deletePatch()
  {
    this.mode = 2;
  }
  
  public String getTableName()
  {
    return "msg_del_log";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.fts.data.msg.FTSMessageDelete
 * JD-Core Version:    0.7.0.1
 */