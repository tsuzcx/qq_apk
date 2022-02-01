package com.tencent.mobileqq.emoticonview.sender;

import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.emoticonview.api.IEmosmService;
import com.tencent.mobileqq.magicface.view.OnMagicPlayEnd;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

class PicEmoticonInfoSender$1$1
  implements OnMagicPlayEnd
{
  PicEmoticonInfoSender$1$1(PicEmoticonInfoSender.1 param1, String paramString) {}
  
  public void onPlayEnd()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("forward, [play back] ready to send msg,magicvalue:");
      localStringBuilder.append(this.this$0.val$emoticon.magicValue);
      QLog.d("PicEmoticonInfoSender", 2, localStringBuilder.toString());
    }
    this.this$0.val$emoticon.magicValue = this.val$magicValueCopy;
    ((IEmosmService)QRoute.api(IEmosmService.class)).sendEmosmMsg(this.this$0.val$app, this.this$0.val$context, this.this$0.val$sessionInfo, this.this$0.val$emoticon);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.sender.PicEmoticonInfoSender.1.1
 * JD-Core Version:    0.7.0.1
 */