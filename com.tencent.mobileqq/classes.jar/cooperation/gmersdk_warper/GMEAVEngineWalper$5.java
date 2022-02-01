package cooperation.gmersdk_warper;

import com.tencent.TMG.sdk.AVAudioCtrl.EnableMicCompleteCallback;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqavopensdk.AVEngineEventHandler;

class GMEAVEngineWalper$5
  extends AVAudioCtrl.EnableMicCompleteCallback
{
  GMEAVEngineWalper$5(GMEAVEngineWalper paramGMEAVEngineWalper) {}
  
  public void onComplete(boolean paramBoolean, int paramInt)
  {
    QLog.d("AVEngineWalper", 1, "StartOpenMic.OnComplete. bOpen = " + paramBoolean + ", result = " + paramInt);
    if (this.a.a != null) {
      this.a.a.a(paramBoolean, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.gmersdk_warper.GMEAVEngineWalper.5
 * JD-Core Version:    0.7.0.1
 */