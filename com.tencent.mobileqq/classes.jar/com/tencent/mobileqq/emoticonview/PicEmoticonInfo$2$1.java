package com.tencent.mobileqq.emoticonview;

import acvv;
import avmw;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.qphone.base.util.QLog;

class PicEmoticonInfo$2$1
  implements avmw
{
  PicEmoticonInfo$2$1(PicEmoticonInfo.2 param2, String paramString) {}
  
  public void onPlayEnd()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PicEmoticonInfo", 2, "forward, [play back] ready to send msg,magicvalue:" + this.this$1.this$0.emoticon.magicValue);
    }
    this.this$1.this$0.emoticon.magicValue = this.val$magicValueCopy;
    acvv.a(this.this$1.val$app, this.this$1.val$context, this.this$1.val$sessionInfo, this.this$1.this$0.emoticon);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.PicEmoticonInfo.2.1
 * JD-Core Version:    0.7.0.1
 */