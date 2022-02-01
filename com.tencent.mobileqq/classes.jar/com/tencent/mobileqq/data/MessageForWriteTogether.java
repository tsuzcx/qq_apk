package com.tencent.mobileqq.data;

import com.tencent.TMG.utils.QLog;

public class MessageForWriteTogether
  extends MessageForText
{
  private static final String TAG = "MessageForWriteTogether";
  public int baseRev;
  public boolean isLongMsg;
  public String padId;
  public int partCnt;
  public String token;
  
  public MessageForWriteTogether()
  {
    this.msgtype = -7014;
    this.isFlowMessage = false;
  }
  
  protected void doParse()
  {
    super.doParse();
    this.token = getExtInfoFromExtStr("write_together_token");
    this.padId = getExtInfoFromExtStr("write_together_pad_id");
    try
    {
      this.baseRev = Integer.valueOf(getExtInfoFromExtStr("write_together_base_rev")).intValue();
    }
    catch (Exception localException1)
    {
      try
      {
        for (;;)
        {
          this.partCnt = Integer.valueOf(getExtInfoFromExtStr("write_together_part_cnt")).intValue();
          if (QLog.isColorLevel()) {
            QLog.d("MessageForWriteTogether", 0, "[doParse] padId: " + this.padId + ", baseRev: " + this.baseRev + ", partCnt: " + this.partCnt);
          }
          this.isLongMsg = Boolean.parseBoolean(getExtInfoFromExtStr("write_together_long_msg"));
          return;
          localException1 = localException1;
          this.baseRev = 0;
          QLog.e("MessageForWriteTogether", 1, "[doParse] read from db, baseRev parse error.", localException1);
        }
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          this.partCnt = 1;
          QLog.e("MessageForWriteTogether", 1, "[doParse] read from db, partCnt parse error.", localException2);
        }
      }
    }
  }
  
  public boolean isFollowMessage()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForWriteTogether
 * JD-Core Version:    0.7.0.1
 */