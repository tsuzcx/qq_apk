package com.tencent.mobileqq.emoticonview;

import admh;
import awtb;
import bdla;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.qphone.base.util.QLog;

class PicEmoticonInfo$3$1
  implements awtb
{
  PicEmoticonInfo$3$1(PicEmoticonInfo.3 param3, String paramString) {}
  
  public void onPlayEnd()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PicEmoticonInfo", 2, "[play back] ready to send msg,magicvalue:" + this.this$0.val$emoticon.magicValue);
    }
    this.this$0.val$emoticon.magicValue = this.val$magicValueCopy;
    admh.a(this.this$0.val$app, this.this$0.val$context, this.this$0.val$sessionInfo, this.this$0.val$emoticon);
    bdla.b(this.this$0.val$app, "CliOper", "", "", "ep_mall", "0X800579D", 0, 0, this.this$0.val$emoticon.epId, "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.PicEmoticonInfo.3.1
 * JD-Core Version:    0.7.0.1
 */