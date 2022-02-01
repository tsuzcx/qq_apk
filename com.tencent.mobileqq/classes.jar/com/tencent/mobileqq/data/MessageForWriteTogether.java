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
      this.baseRev = 0;
      QLog.e("MessageForWriteTogether", 1, "[doParse] read from db, baseRev parse error.", localException1);
    }
    try
    {
      this.partCnt = Integer.valueOf(getExtInfoFromExtStr("write_together_part_cnt")).intValue();
    }
    catch (Exception localException2)
    {
      this.partCnt = 1;
      QLog.e("MessageForWriteTogether", 1, "[doParse] read from db, partCnt parse error.", localException2);
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[doParse] padId: ");
      localStringBuilder.append(this.padId);
      localStringBuilder.append(", baseRev: ");
      localStringBuilder.append(this.baseRev);
      localStringBuilder.append(", partCnt: ");
      localStringBuilder.append(this.partCnt);
      QLog.d("MessageForWriteTogether", 0, localStringBuilder.toString());
    }
    this.isLongMsg = Boolean.parseBoolean(getExtInfoFromExtStr("write_together_long_msg"));
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