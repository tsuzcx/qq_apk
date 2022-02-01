package com.tencent.mobileqq.msgforward;

import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.multimsg.save.FileSaveDialog.IFileSaveCancelInterface;
import com.tencent.mobileqq.multimsg.save.MultiRichMediaSaveManager;

class AIOShareActionSheet$10$1
  implements FileSaveDialog.IFileSaveCancelInterface
{
  AIOShareActionSheet$10$1(AIOShareActionSheet.10 param10) {}
  
  public void a()
  {
    if ((AIOShareActionSheet.a(this.a.d) != null) && (AIOShareActionSheet.a(this.a.d).ah != null)) {
      this.a.b.a(this.a.c, 2, AIOShareActionSheet.a(this.a.d).ah.a);
    }
    this.a.b.a();
    if (AIOShareActionSheet.a(this.a.d) != null) {
      AIOShareActionSheet.a(this.a.d).a(false, null, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msgforward.AIOShareActionSheet.10.1
 * JD-Core Version:    0.7.0.1
 */