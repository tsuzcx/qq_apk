package dov.com.qq.im.ae.cmshow;

import android.support.annotation.Nullable;
import com.tencent.mobileqq.app.ThreadManager;
import dov.com.qq.im.ae.util.AEQLog;
import mqq.os.MqqHandler;

class AECMShowPhotoPreviewFragment$1
  implements AECMShowRequestController.Callback
{
  AECMShowPhotoPreviewFragment$1(AECMShowPhotoPreviewFragment paramAECMShowPhotoPreviewFragment) {}
  
  public void a(int paramInt, @Nullable AECMShowRequestController.CmShowDataWrapper paramCmShowDataWrapper)
  {
    AEQLog.a("AECMShowPhotoPreviewFragment", "[AECMShowRequestController.onComplete], resultCode=" + paramInt + ", dataWrapper=" + paramCmShowDataWrapper);
    ThreadManager.getUIHandler().post(new AECMShowPhotoPreviewFragment.1.2(this, paramInt, paramCmShowDataWrapper));
  }
  
  public void b(int paramInt)
  {
    ThreadManager.getUIHandler().post(new AECMShowPhotoPreviewFragment.1.1(this, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.cmshow.AECMShowPhotoPreviewFragment.1
 * JD-Core Version:    0.7.0.1
 */