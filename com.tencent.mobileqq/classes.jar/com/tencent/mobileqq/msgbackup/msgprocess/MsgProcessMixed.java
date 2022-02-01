package com.tencent.mobileqq.msgbackup.msgprocess;

import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msgbackup.controller.RichMediaProcessor;
import com.tencent.mobileqq.msgbackup.data.MsgBackupResEntity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MsgProcessMixed
  extends MsgProcessRichMedia<MessageForMixedMsg>
{
  public MsgProcessMixed(MessageForMixedMsg paramMessageForMixedMsg)
  {
    super(paramMessageForMixedMsg);
  }
  
  protected int a()
  {
    return 1;
  }
  
  public List<MsgBackupResEntity> a()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = ((MessageForMixedMsg)this.a).msgElemList.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (MessageRecord)localIterator.next();
      if ((localObject instanceof MessageForPic))
      {
        localObject = RichMediaProcessor.a((MessageRecord)localObject);
        ((MsgProcessRichMedia)localObject).a(this.a);
        localArrayList.addAll(((MsgProcessRichMedia)localObject).a());
      }
    }
    return localArrayList;
  }
  
  public void a()
  {
    Iterator localIterator = ((MessageForMixedMsg)this.a).msgElemList.iterator();
    while (localIterator.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)localIterator.next();
      if ((localMessageRecord instanceof MessageForPic)) {
        RichMediaProcessor.a(localMessageRecord).a();
      }
    }
  }
  
  public void b()
  {
    if (((MessageForMixedMsg)this.a).isSendFromLocal())
    {
      ((MessageForMixedMsg)this.a).issend = 2;
      ((MessageForMixedMsg)this.a).prewrite();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.msgprocess.MsgProcessMixed
 * JD-Core Version:    0.7.0.1
 */