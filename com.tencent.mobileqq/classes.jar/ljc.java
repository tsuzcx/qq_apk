import android.text.TextUtils;
import com.qq.wx.voice.embedqqegg.recognizer.VoiceRecognizer;
import com.qq.wx.voice.embedqqegg.recognizer.VoiceRecognizerListener;
import com.qq.wx.voice.embedqqegg.recognizer.VoiceRecognizerResult;
import com.qq.wx.voice.embedqqegg.recognizer.VoiceRecordState;
import com.tencent.qphone.base.util.QLog;

class ljc
  implements VoiceRecognizerListener
{
  ljc(lja paramlja) {}
  
  public void onGetError(int paramInt)
  {
    QLog.d("AVVoiceRecog", 2, "onGetError. err = " + paramInt);
  }
  
  public void onGetResult(VoiceRecognizerResult paramVoiceRecognizerResult)
  {
    if ((!lja.a(this.a)) || (lja.b(this.a))) {
      QLog.i("AVVoiceRecog", 1, "onGetResult. discard. !mIsInitAndStart || mIsPause.");
    }
    label162:
    for (;;)
    {
      return;
      if (paramVoiceRecognizerResult.isHalf)
      {
        QLog.i("AVVoiceRecog", 1, "onGetResult. result.isHalf.");
        return;
      }
      if (TextUtils.isEmpty(paramVoiceRecognizerResult.text)) {
        QLog.i("AVVoiceRecog", 1, "onGetResult. result.text == null.");
      }
      for (;;)
      {
        if (!paramVoiceRecognizerResult.isEnd) {
          break label162;
        }
        int i = VoiceRecognizer.shareInstance().startReceiving();
        if (i >= 0) {
          break;
        }
        QLog.i("AVVoiceRecog", 1, "restart falied. ret = " + i);
        return;
        QLog.i("AVVoiceRecog", 1, "onGetResult. result.text = " + paramVoiceRecognizerResult.text);
        if (lja.a(this.a) != null) {
          lja.a(this.a).a(paramVoiceRecognizerResult.text);
        }
      }
    }
  }
  
  public void onGetVoiceRecordState(VoiceRecordState paramVoiceRecordState)
  {
    QLog.d("AVVoiceRecog", 2, "onGetVoiceRecordState. state = " + paramVoiceRecordState);
  }
  
  public void onVolumeChanged(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AVVoiceRecog", 2, "onVolumeChanged. volume = " + paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     ljc
 * JD-Core Version:    0.7.0.1
 */