package com.tencent.mobileqq.winkpublish.task;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.winkpublish.event.PublishUploadTaskResultEvent;
import com.tencent.mobileqq.winkpublish.event.WinkDraftStatusEvent;
import com.tencent.mobileqq.winkpublish.model.ImageInfo;
import com.tencent.mobileqq.winkpublish.model.MediaWrapper;
import com.tencent.mobileqq.winkpublish.model.ShuoshuoVideoInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class FSUploadShuoShuoTask$3
  implements Runnable
{
  FSUploadShuoShuoTask$3(FSUploadShuoShuoTask paramFSUploadShuoShuoTask, boolean paramBoolean) {}
  
  public void run()
  {
    if ((this.this$0.p != null) && (this.this$0.p.size() > 0))
    {
      if ((((MediaWrapper)this.this$0.p.get(0)).a()) && (((MediaWrapper)this.this$0.p.get(0)).c() != null))
      {
        str1 = ((MediaWrapper)this.this$0.p.get(0)).c().h;
        break label149;
      }
      if (((MediaWrapper)this.this$0.p.get(0)).b())
      {
        str1 = ((MediaWrapper)this.this$0.p.get(0)).d().a;
        break label149;
      }
    }
    String str1 = "";
    label149:
    String str2;
    long l;
    if (FSUploadShuoShuoTask.c(this.this$0) != null)
    {
      str2 = FSUploadShuoShuoTask.c(this.this$0).c;
      l = FSUploadShuoShuoTask.c(this.this$0).h;
    }
    else
    {
      str2 = "";
      l = 0L;
    }
    boolean bool = this.a;
    String str3 = FSUploadShuoShuoTask.a(this.this$0);
    if (str2 != null) {
      localObject = str2;
    } else {
      localObject = "";
    }
    Object localObject = new PublishUploadTaskResultEvent(bool, str3, str1, (String)localObject, this.this$0.al, l);
    ((PublishUploadTaskResultEvent)localObject).setTargetPage(1);
    SimpleEventBus.getInstance().dispatchEvent((SimpleBaseEvent)localObject);
    localObject = new WinkDraftStatusEvent(this.this$0.getMissionId());
    int i;
    if (this.a) {
      i = 4;
    } else {
      i = 3;
    }
    ((WinkDraftStatusEvent)localObject).setUploadStatus(i);
    SimpleEventBus.getInstance().dispatchEvent((SimpleBaseEvent)localObject);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("notifyComplete... success:");
    ((StringBuilder)localObject).append(this.a);
    ((StringBuilder)localObject).append(" missionId:");
    ((StringBuilder)localObject).append(FSUploadShuoShuoTask.a(this.this$0));
    ((StringBuilder)localObject).append(" feedId:");
    ((StringBuilder)localObject).append(str2);
    ((StringBuilder)localObject).append(" coverUrl:");
    ((StringBuilder)localObject).append(str1);
    QLog.d("[upload2_FSUploadShuoShuoTask]", 1, ((StringBuilder)localObject).toString());
    FSUploadShuoShuoTask.d(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.task.FSUploadShuoShuoTask.3
 * JD-Core Version:    0.7.0.1
 */