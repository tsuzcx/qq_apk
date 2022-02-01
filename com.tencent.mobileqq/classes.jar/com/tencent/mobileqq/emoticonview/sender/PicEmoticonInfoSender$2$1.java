package com.tencent.mobileqq.emoticonview.sender;

import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.magicface.view.MagicfaceViewController.OnMagicPlayEnd;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

class PicEmoticonInfoSender$2$1
  implements MagicfaceViewController.OnMagicPlayEnd
{
  PicEmoticonInfoSender$2$1(PicEmoticonInfoSender.2 param2, String paramString) {}
  
  public void onPlayEnd()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PicEmoticonInfoSender", 2, "[play back] ready to send msg,magicvalue:" + this.this$0.val$emoticon.magicValue);
    }
    this.this$0.val$emoticon.magicValue = this.val$magicValueCopy;
    ChatActivityFacade.a(this.this$0.val$app, this.this$0.val$context, this.this$0.val$sessionInfo, this.this$0.val$emoticon);
    ReportController.b(this.this$0.val$app, "CliOper", "", "", "ep_mall", "0X800579D", 0, 0, this.this$0.val$emoticon.epId, "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.sender.PicEmoticonInfoSender.2.1
 * JD-Core Version:    0.7.0.1
 */