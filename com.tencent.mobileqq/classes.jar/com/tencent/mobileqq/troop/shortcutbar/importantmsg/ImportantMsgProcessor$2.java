package com.tencent.mobileqq.troop.shortcutbar.importantmsg;

class ImportantMsgProcessor$2
  implements ImportantMsgManager.callbackInMainThread
{
  ImportantMsgProcessor$2(ImportantMsgProcessor paramImportantMsgProcessor, ImportantMsgManager paramImportantMsgManager) {}
  
  public void a(long paramLong, ImportantMsgItem paramImportantMsgItem)
  {
    if (paramImportantMsgItem == null) {
      return;
    }
    ImportantMsgProcessor.a(this.b, paramImportantMsgItem.getMsgInfoList());
    this.a.a(paramImportantMsgItem);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.shortcutbar.importantmsg.ImportantMsgProcessor.2
 * JD-Core Version:    0.7.0.1
 */