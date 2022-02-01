import android.annotation.TargetApi;
import android.graphics.Bitmap;
import com.tencent.av.VideoController;
import com.tencent.av.screenshare.ScreenShareCtrl;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;

public class lvq
  implements lon, mja
{
  private final lvr jdField_a_of_type_Lvr = new lvr();
  private final WeakReference<ScreenShareCtrl> jdField_a_of_type_MqqUtilWeakReference;
  
  public lvq(ScreenShareCtrl paramScreenShareCtrl)
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
    if (localScreenShareCtrl.a(2) == 1) {}
    for (paramInt = 2;; paramInt = 3)
    {
      ScreenShareCtrl.a(paramInt);
      return;
    }
  }
  
  public void a(long paramLong) {}
  
  public void a(Bitmap paramBitmap, mwf parammwf)
  {
    ScreenShareCtrl localScreenShareCtrl = (ScreenShareCtrl)this.jdField_a_of_type_MqqUtilWeakReference.get();
    if (localScreenShareCtrl != null) {
      localScreenShareCtrl.a(paramBitmap, parammwf);
    }
  }
  
  @TargetApi(21)
  public void a(mwf parammwf, int paramInt1, int paramInt2)
  {
    ScreenShareCtrl localScreenShareCtrl = (ScreenShareCtrl)this.jdField_a_of_type_MqqUtilWeakReference.get();
    if (localScreenShareCtrl == null) {}
    do
    {
      return;
      localScreenShareCtrl.a(parammwf, paramInt1, paramInt2);
      if (localScreenShareCtrl.a(1) == 1)
      {
        ScreenShareCtrl.a(4);
        return;
      }
      ScreenShareCtrl.a(6);
      parammwf = VideoController.a().a();
    } while (parammwf == null);
    parammwf.a(1);
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, mwf parammwf)
  {
    this.jdField_a_of_type_Lvr.a(1, paramArrayOfByte, paramInt1, paramInt2, parammwf);
    ScreenShareCtrl localScreenShareCtrl = (ScreenShareCtrl)this.jdField_a_of_type_MqqUtilWeakReference.get();
    if (localScreenShareCtrl != null) {
      localScreenShareCtrl.a(paramArrayOfByte, paramInt1, paramInt2, parammwf);
    }
  }
  
  public void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AVShare", 2, "onMediaProjectionReady errorReason:=" + paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lvq
 * JD-Core Version:    0.7.0.1
 */