package cooperation.gmersdk_warper;

import com.tencent.TMG.sdk.AVAudioCtrl.EnableMicCompleteCallback;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqavopensdk.AVEngineEventHandler;

class GMEAVEngineWalper$5
  extends AVAudioCtrl.EnableMicCompleteCallback
{
  protected void onComplete(boolean paramBoolean, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("StartOpenMic.OnComplete. bOpen = ");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(", result = ");
    localStringBuilder.append(paramInt);
    QLog.d("AVEngineWalper", 1, localStringBuilder.toString());
    if (this.a.b != null) {
      this.a.b.a(paramBoolean, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.gmersdk_warper.GMEAVEngineWalper.5
 * JD-Core Version:    0.7.0.1
 */