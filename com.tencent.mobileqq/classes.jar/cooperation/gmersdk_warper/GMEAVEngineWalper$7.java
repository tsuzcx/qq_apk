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
    else
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("AVCallback result=");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", errorInfo=");
      localStringBuilder.append(paramString);
      QLog.e("AVEngineWalper", 1, localStringBuilder.toString());
    }
    if (this.a.a != null) {
      this.a.a.a(paramInt, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.gmersdk_warper.GMEAVEngineWalper.7
 * JD-Core Version:    0.7.0.1
 */