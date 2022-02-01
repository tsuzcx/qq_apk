package com.tencent.mobileqq.emoticonview.sender;

import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.magicface.view.MagicfaceViewController.OnMagicPlayEnd;
import com.tencent.qphone.base.util.QLog;

class PicEmoticonInfoSender$1$1
  implements MagicfaceViewController.OnMagicPlayEnd
{
  PicEmoticonInfoSender$1$1(PicEmoticonInfoSender.1 param1, String paramString) {}
  
  public void onPlayEnd()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PicEmoticonInfoSender", 2, "forward, [play back] ready to send msg,magicvalue:" + this.this$1.val$emoticon.magicValue);
    }
    this.this$1.val$emoticon.magicValue = this.val$magicValueCopy;
    ChatActivityFacade.a(this.this$1.val$app, this.this$1.val$context, this.this$1.val$sessionInfo, this.this$1.val$emoticon);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.sender.PicEmoticonInfoSender.1.1
 * JD-Core Version:    0.7.0.1
 */