package com.tencent.mobileqq.msgbackup.msgprocess;

import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msgbackup.data.MsgBackupResEntity;
import java.util.List;

public class MsgProcessCommon
  extends MsgProcessRichMedia<MessageRecord>
{
  public MsgProcessCommon(MessageRecord paramMessageRecord)
  {
    super(paramMessageRecord);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.a);
    localStringBuilder.append(".");
    localStringBuilder.append(paramMessageRecord.getClass().getSimpleName());
    this.a = localStringBuilder.toString();
  }
  
  protected int a()
  {
    return 0;
  }
  
  public List<MsgBackupResEntity> a()
  {
    return null;
  }
  
  public void a() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.msgprocess.MsgProcessCommon
 * JD-Core Version:    0.7.0.1
 */