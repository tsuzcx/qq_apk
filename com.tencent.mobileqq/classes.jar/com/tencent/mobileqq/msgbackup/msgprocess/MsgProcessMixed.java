package com.tencent.mobileqq.msgbackup.msgprocess;

import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForRichText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.mixedmsg.api.IMsgMixed;
import com.tencent.mobileqq.msgbackup.controller.RichMediaProcessor;
import com.tencent.mobileqq.msgbackup.data.MsgBackupResEntity;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MsgProcessMixed
  extends MsgProcessRichMedia<MessageRecord>
{
  public MsgProcessMixed(MessageRecord paramMessageRecord)
  {
    super(paramMessageRecord);
  }
  
  public void a()
  {
    Iterator localIterator = ((IMsgMixed)QRoute.api(IMsgMixed.class)).getElementList(this.b).iterator();
    while (localIterator.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)localIterator.next();
      if ((localMessageRecord instanceof MessageForPic)) {
        RichMediaProcessor.b(localMessageRecord).a();
      }
    }
  }
  
  public List<MsgBackupResEntity> b()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = ((IMsgMixed)QRoute.api(IMsgMixed.class)).getElementList(this.b).iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (MessageRecord)localIterator.next();
      if ((localObject instanceof MessageForPic))
      {
        localObject = RichMediaProcessor.b((MessageRecord)localObject);
        ((MsgProcessRichMedia)localObject).a(this.b);
        localArrayList.addAll(((MsgProcessRichMedia)localObject).b());
      }
    }
    return localArrayList;
  }
  
  protected int c()
  {
    return 1;
  }
  
  public void d()
  {
    if (this.b.isSendFromLocal())
    {
      this.b.issend = 2;
      ((MessageForRichText)this.b).prewriteForMsgbackup();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.msgprocess.MsgProcessMixed
 * JD-Core Version:    0.7.0.1
 */