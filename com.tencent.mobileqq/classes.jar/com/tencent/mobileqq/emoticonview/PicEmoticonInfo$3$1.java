package com.tencent.mobileqq.emoticonview;

import acvv;
import avmw;
import bcef;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.qphone.base.util.QLog;

class PicEmoticonInfo$3$1
  implements avmw
{
  PicEmoticonInfo$3$1(PicEmoticonInfo.3 param3, String paramString) {}
  
  public void onPlayEnd()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PicEmoticonInfo", 2, "[play back] ready to send msg,magicvalue:" + this.this$0.val$emoticon.magicValue);
    }
    this.this$0.val$emoticon.magicValue = this.val$magicValueCopy;
    acvv.a(this.this$0.val$app, this.this$0.val$context, this.this$0.val$sessionInfo, this.this$0.val$emoticon);
    bcef.b(this.this$0.val$app, "CliOper", "", "", "ep_mall", "0X800579D", 0, 0, this.this$0.val$emoticon.epId, "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.PicEmoticonInfo.3.1
 * JD-Core Version:    0.7.0.1
 */