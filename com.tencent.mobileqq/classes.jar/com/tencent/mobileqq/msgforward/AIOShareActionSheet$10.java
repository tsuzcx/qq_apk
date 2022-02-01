package com.tencent.mobileqq.msgforward;

import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.multimsg.save.FileSaveDialog;
import com.tencent.mobileqq.multimsg.save.FileSaveResult;
import com.tencent.mobileqq.multimsg.save.FileSaveToastUtils;
import com.tencent.mobileqq.multimsg.save.ISaveCallBack;
import com.tencent.mobileqq.multimsg.save.MultiRichMediaSaveManager;
import java.util.List;

class AIOShareActionSheet$10
  implements ISaveCallBack
{
  AIOShareActionSheet$10(AIOShareActionSheet paramAIOShareActionSheet, FileSaveDialog paramFileSaveDialog, MultiRichMediaSaveManager paramMultiRichMediaSaveManager, List paramList) {}
  
  public void a()
  {
    this.a.a(new AIOShareActionSheet.10.1(this));
    this.a.show();
  }
  
  public void a(FileSaveResult paramFileSaveResult)
  {
    if ((paramFileSaveResult != null) && (AIOShareActionSheet.a(this.d) != null) && (AIOShareActionSheet.a(this.d).aY()))
    {
      int i = paramFileSaveResult.b;
      if (i != -1)
      {
        if (i != 0)
        {
          if (i == 3) {
            FileSaveToastUtils.c(AIOShareActionSheet.b(this.d));
          }
        }
        else {
          FileSaveToastUtils.a(AIOShareActionSheet.b(this.d));
        }
      }
      else {
        FileSaveToastUtils.b(AIOShareActionSheet.b(this.d));
      }
    }
    if (this.a.isShowing()) {
      this.a.dismiss();
    }
    if (AIOShareActionSheet.a(this.d) != null) {
      AIOShareActionSheet.a(this.d).a(false, null, false);
    }
    this.b.b();
  }
  
  public void a(FileSaveResult paramFileSaveResult, int paramInt)
  {
    this.a.a(paramInt);
  }
  
  public void b()
  {
    if (this.a.isShowing()) {
      this.a.dismiss();
    }
    if (AIOShareActionSheet.a(this.d) != null) {
      AIOShareActionSheet.a(this.d).a(false, null, false);
    }
    this.b.b();
  }
  
  public void c()
  {
    this.b.a(AIOShareActionSheet.b(this.d), this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msgforward.AIOShareActionSheet.10
 * JD-Core Version:    0.7.0.1
 */