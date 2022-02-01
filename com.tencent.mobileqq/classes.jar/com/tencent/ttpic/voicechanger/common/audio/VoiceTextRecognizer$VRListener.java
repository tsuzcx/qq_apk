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
    String str = VoiceTextRecognizer.access$200();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onGetError, errorCode = ");
    localStringBuilder.append(paramInt);
    LogUtils.e(str, localStringBuilder.toString());
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
    String str = VoiceTextRecognizer.access$200();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onGetResult, text = ");
    localStringBuilder.append(paramVoiceRecognizerResult.text);
    LogUtils.e(str, localStringBuilder.toString());
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