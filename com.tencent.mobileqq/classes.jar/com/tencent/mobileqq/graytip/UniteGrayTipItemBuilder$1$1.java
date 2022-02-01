package com.tencent.mobileqq.graytip;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.pic.api.IPicPreDownload;

class UniteGrayTipItemBuilder$1$1
  implements Runnable
{
  UniteGrayTipItemBuilder$1$1(UniteGrayTipItemBuilder.1 param1) {}
  
  public void run()
  {
    ((IPicPreDownload)this.a.this$0.a.getRuntimeService(IPicPreDownload.class, "")).productFromAIO((MessageForPic)this.a.a, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.graytip.UniteGrayTipItemBuilder.1.1
 * JD-Core Version:    0.7.0.1
 */