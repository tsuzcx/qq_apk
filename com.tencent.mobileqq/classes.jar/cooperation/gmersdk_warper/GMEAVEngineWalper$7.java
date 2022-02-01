package cooperation.gmersdk_warper;

import com.tencent.TMG.sdk.AVCallback;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqavopensdk.AVEngineEventHandler;

class GMEAVEngineWalper$7
  implements AVCallback
{
  GMEAVEngineWalper$7(GMEAVEngineWalper paramGMEAVEngineWalper) {}
  
  public void onComplete(int paramInt, String paramString)
  {
    if (paramInt == 0)
    {
      QLog.e("AVEngineWalper", 1, "AVCallback make connection successfully!!!");
      GMEAVEngineWalper.a(this.a, true);
    }
    for (;;)
    {
      if (this.a.a != null) {
        this.a.a.a(paramInt, paramString);
      }
      return;
      QLog.e("AVEngineWalper", 1, "AVCallback result=" + paramInt + ", errorInfo=" + paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.gmersdk_warper.GMEAVEngineWalper.7
 * JD-Core Version:    0.7.0.1
 */