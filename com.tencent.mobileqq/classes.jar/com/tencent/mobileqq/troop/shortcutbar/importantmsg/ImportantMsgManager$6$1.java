package com.tencent.mobileqq.troop.shortcutbar.importantmsg;

import java.util.HashMap;

class ImportantMsgManager$6$1
  implements Runnable
{
  ImportantMsgManager$6$1(ImportantMsgManager.6 param6, ImportantMsgItem paramImportantMsgItem) {}
  
  public void run()
  {
    if (ImportantMsgManager.a(this.b.this$0).containsKey(Long.valueOf(this.b.a)))
    {
      this.b.b.a(this.b.a, (ImportantMsgItem)ImportantMsgManager.a(this.b.this$0).get(Long.valueOf(this.b.a)));
      return;
    }
    ImportantMsgManager.a(this.b.this$0).put(Long.valueOf(this.b.a), this.a);
    this.b.b.a(this.b.a, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.shortcutbar.importantmsg.ImportantMsgManager.6.1
 * JD-Core Version:    0.7.0.1
 */