package com.tencent.mobileqq.filemanager.guild;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.guild.api.IGuildHandlerNameApi;
import com.tencent.mobileqq.guild.message.api.IGuildSendMessageHandler;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.qroute.QRoute;

class QFileGuildTransferWrapper$2
  implements Runnable
{
  QFileGuildTransferWrapper$2(QFileGuildTransferWrapper paramQFileGuildTransferWrapper, String paramString1, String paramString2, FileInfo paramFileInfo) {}
  
  public void run()
  {
    FileManagerEntity localFileManagerEntity = new FileManagerEntity();
    MessageRecord localMessageRecord = QFileGuildTransferWrapper.a(this.this$0, this.a, this.b, this.c, localFileManagerEntity);
    ((IMessageFacade)QFileGuildTransferWrapper.a(this.this$0).getRuntimeService(IMessageFacade.class, "")).addMessage(localMessageRecord, QFileGuildTransferWrapper.a(this.this$0).getCurrentAccountUin());
    ((IGuildSendMessageHandler)QFileGuildTransferWrapper.a(this.this$0).getBusinessHandler(((IGuildHandlerNameApi)QRoute.api(IGuildHandlerNameApi.class)).getGuildSendMsgHandlerName())).a(localMessageRecord);
    QFileGuildTransferWrapper.a(this.this$0, localFileManagerEntity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.guild.QFileGuildTransferWrapper.2
 * JD-Core Version:    0.7.0.1
 */