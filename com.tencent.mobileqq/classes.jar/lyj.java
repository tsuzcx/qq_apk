import android.annotation.TargetApi;
import android.graphics.Bitmap;
import com.tencent.av.VideoConstants.EmShareOps;
import com.tencent.av.VideoConstants.EmShareOpsRet;
import com.tencent.av.VideoController;
import com.tencent.av.screenshare.ScreenShareCtrl;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;

public class lyj
  implements lrv, mlt
{
  private final lyk jdField_a_of_type_Lyk = new lyk();
  private final WeakReference<ScreenShareCtrl> jdField_a_of_type_MqqUtilWeakReference;
  
  public lyj(ScreenShareCtrl paramScreenShareCtrl)
  {
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramScreenShareCtrl);
  }
  
  @TargetApi(21)
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AVShare", 2, "onMediaProjectionEnd fromType:=" + paramInt);
    }
    ScreenShareCtrl localScreenShareCtrl = (ScreenShareCtrl)this.jdField_a_of_type_MqqUtilWeakReference.get();
    if (localScreenShareCtrl == null) {}
    while (paramInt != 2) {
      return;
    }
    if (localScreenShareCtrl.a(VideoConstants.EmShareOps.STOP) == VideoConstants.EmShareOpsRet.SUC) {}
    for (paramInt = 2;; paramInt = 3)
    {
      ScreenShareCtrl.a(paramInt);
      return;
    }
  }
  
  public void a(long paramLong) {}
  
  public void a(Bitmap paramBitmap, lyh paramlyh)
  {
    ScreenShareCtrl localScreenShareCtrl = (ScreenShareCtrl)this.jdField_a_of_type_MqqUtilWeakReference.get();
    if (localScreenShareCtrl != null) {
      localScreenShareCtrl.a(paramBitmap, paramlyh);
    }
  }
  
  @TargetApi(21)
  public void a(lyh paramlyh, int paramInt1, int paramInt2)
  {
    ScreenShareCtrl localScreenShareCtrl = (ScreenShareCtrl)this.jdField_a_of_type_MqqUtilWeakReference.get();
    if (localScreenShareCtrl == null) {}
    do
    {
      return;
      localScreenShareCtrl.a(paramlyh, paramInt1, paramInt2);
      if (localScreenShareCtrl.a(VideoConstants.EmShareOps.START) == VideoConstants.EmShareOpsRet.SUC)
      {
        ScreenShareCtrl.a(4);
        return;
      }
      ScreenShareCtrl.a(6);
      paramlyh = VideoController.a().a();
    } while (paramlyh == null);
    paramlyh.a(1);
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, lyh paramlyh)
  {
    this.jdField_a_of_type_Lyk.a(1, paramArrayOfByte, paramInt1, paramInt2, paramlyh);
    ScreenShareCtrl localScreenShareCtrl = (ScreenShareCtrl)this.jdField_a_of_type_MqqUtilWeakReference.get();
    if (localScreenShareCtrl != null) {
      localScreenShareCtrl.a(paramArrayOfByte, paramInt1, paramInt2, paramlyh);
    }
  }
  
  public void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AVShare", 2, "onMediaProjectionReady errorReason:=" + paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     lyj
 * JD-Core Version:    0.7.0.1
 */