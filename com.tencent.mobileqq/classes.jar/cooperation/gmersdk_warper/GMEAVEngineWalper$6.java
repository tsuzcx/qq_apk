package cooperation.gmersdk_warper;

import com.tencent.TMG.sdk.AVAudioCtrl.EnableSpeakerCompleteCallback;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqavopensdk.AVEngineEventHandler;

class GMEAVEngineWalper$6
  extends AVAudioCtrl.EnableSpeakerCompleteCallback
{
  GMEAVEngineWalper$6(GMEAVEngineWalper paramGMEAVEngineWalper) {}
  
  public void onComplete(boolean paramBoolean, int paramInt)
  {
    QLog.d("AVEngineWalper", 1, "StartOpenSpeaker.OnComplete. bOpen = " + paramBoolean + ", result = " + paramInt);
    if (this.a.a != null) {
      this.a.a.b(paramBoolean, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.gmersdk_warper.GMEAVEngineWalper.6
 * JD-Core Version:    0.7.0.1
 */