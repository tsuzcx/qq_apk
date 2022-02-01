package com.tencent.ttpic.voicechanger.common.audio;

import com.qq.wx.voice.recognizer.VoiceRecognizerListener;
import com.qq.wx.voice.recognizer.VoiceRecognizerResult;
import com.qq.wx.voice.recognizer.VoiceRecordState;
import com.tencent.ttpic.baseutils.log.LogUtils;

public class VoiceTextRecognizer$VRListener
  implements VoiceRecognizerListener
{
  public VoiceTextRecognizer$VRListener(VoiceTextRecognizer paramVoiceTextRecognizer) {}
  
  public void onGetError(int paramInt)
  {
    LogUtils.e(VoiceTextRecognizer.access$200(), "onGetError, errorCode = " + paramInt);
    if (VoiceTextRecognizer.access$500(this.this$0) != null) {
      VoiceTextRecognizer.access$500(this.this$0).onError(paramInt);
    }
    if (VoiceTextRecognizer.access$300(this.this$0) != null) {
      VoiceTextRecognizer.access$300(this.this$0).onError(paramInt);
    }
    VoiceTextRecognizer.access$402(this.this$0, 4);
  }
  
  public void onGetResult(VoiceRecognizerResult paramVoiceRecognizerResult)
  {
    LogUtils.e(VoiceTextRecognizer.access$200(), "onGetResult, text = " + paramVoiceRecognizerResult.text);
    if (VoiceTextRecognizer.access$500(this.this$0) != null)
    {
      VoiceTextRecognizer.access$500(this.this$0).onVTChanged(paramVoiceRecognizerResult.text);
      if (paramVoiceRecognizerResult.isEnd) {
        VoiceTextRecognizer.access$500(this.this$0).onVTChanged("");
      }
    }
  }
  
  public void onGetVoicePackage(byte[] paramArrayOfByte, String paramString) {}
  
  public void onGetVoiceRecordState(VoiceRecordState paramVoiceRecordState) {}
  
  public void onVolumeChanged(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.voicechanger.common.audio.VoiceTextRecognizer.VRListener
 * JD-Core Version:    0.7.0.1
 */