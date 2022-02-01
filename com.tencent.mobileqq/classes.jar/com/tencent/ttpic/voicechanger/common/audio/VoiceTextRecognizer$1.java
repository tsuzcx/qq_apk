package com.tencent.ttpic.voicechanger.common.audio;

import android.content.Context;
import com.qq.wx.voice.recognizer.VoiceRecognizer;
import com.tencent.ttpic.baseutils.log.LogUtils;

class VoiceTextRecognizer$1
  implements Runnable
{
  VoiceTextRecognizer$1(VoiceTextRecognizer paramVoiceTextRecognizer, boolean paramBoolean, Context paramContext) {}
  
  public void run()
  {
    VoiceRecognizer.shareInstance().setListener(VoiceTextRecognizer.access$000(this.this$0));
    VoiceRecognizer.shareInstance().setSilentTime(500);
    VoiceRecognizer.shareInstance().setContRes(true);
    VoiceRecognizer.shareInstance().setContReco(true);
    VoiceRecognizer.shareInstance().setResultType(1);
    if (this.val$needLoadSo) {
      i = VoiceRecognizer.shareInstance().init(this.val$context, VoiceTextRecognizer.access$100());
    }
    try
    {
      i = VoiceRecognizer.shareInstance().initNoLoadSo(this.val$context, VoiceTextRecognizer.access$100());
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      label84:
      break label84;
    }
    int i = VoiceTextRecognizer.ErrorCode.SO_NOT_LOAD.value;
    if (i < 0)
    {
      LogUtils.e(VoiceTextRecognizer.access$200(), "初始化语音识别失败");
      if (VoiceTextRecognizer.access$300(this.this$0) != null) {
        VoiceTextRecognizer.access$300(this.this$0).onError(i);
      }
      return;
    }
    VoiceTextRecognizer.access$402(this.this$0, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.voicechanger.common.audio.VoiceTextRecognizer.1
 * JD-Core Version:    0.7.0.1
 */