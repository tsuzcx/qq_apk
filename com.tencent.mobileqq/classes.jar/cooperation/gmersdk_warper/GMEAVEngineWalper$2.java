package cooperation.gmersdk_warper;

import android.os.Handler;
import android.os.Looper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqavopensdk.AVEngineEventHandler;

class GMEAVEngineWalper$2
  implements GMEAVManager.EnterRoomCallback
{
  GMEAVEngineWalper$2(GMEAVEngineWalper paramGMEAVEngineWalper) {}
  
  public void a(int paramInt, String paramString)
  {
    if (paramInt == 0)
    {
      QLog.e("AVEngineWalper", 1, "enter room successfully!!!");
    }
    else
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("enter room failed. result=");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", errorInfo=");
      localStringBuilder.append(paramString);
      QLog.e("AVEngineWalper", 1, localStringBuilder.toString());
    }
    if (this.a.b != null) {
      this.a.b.b(paramInt, paramString);
    }
    new Handler(Looper.getMainLooper()).postDelayed(new GMEAVEngineWalper.2.1(this), 500L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.gmersdk_warper.GMEAVEngineWalper.2
 * JD-Core Version:    0.7.0.1
 */