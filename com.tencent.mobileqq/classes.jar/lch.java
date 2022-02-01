import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;

public class lch
  extends lbo
  implements ljj
{
  private final VideoController jdField_a_of_type_ComTencentAvVideoController;
  private WeakReference<lci> jdField_a_of_type_MqqUtilWeakReference;
  private boolean b;
  
  public lch(VideoController paramVideoController)
  {
    this.jdField_a_of_type_ComTencentAvVideoController = paramVideoController;
  }
  
  public int a(long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = this.jdField_a_of_type_ComTencentAvVideoController.a().d;
    if (paramBoolean2) {
      this.jdField_a_of_type_ComTencentAvVideoController.a().q = true;
    }
    if (paramBoolean1)
    {
      this.jdField_a_of_type_ComTencentAvVideoController.a().n = false;
      this.jdField_a_of_type_ComTencentAvVideoController.a().S = false;
      this.jdField_a_of_type_ComTencentAvVideoController.a().a(paramLong, true);
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().d != 1) {
        break label114;
      }
      this.jdField_a_of_type_ComTencentAvVideoController.a().a(paramLong, "afterOpenCamera.1", 2);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvVideoController.c(this.jdField_a_of_type_ComTencentAvVideoController.a().d);
      return i;
      label114:
      if ((this.jdField_a_of_type_ComTencentAvVideoController.a().d == 3) || (this.jdField_a_of_type_ComTencentAvVideoController.a().d == 4)) {
        this.jdField_a_of_type_ComTencentAvVideoController.a().a(paramLong, "afterOpenCamera.2", 4);
      }
    }
  }
  
  public void a()
  {
    long l = AudioHelper.b();
    if (QLog.isColorLevel()) {
      QLog.i("CameraDataProcess", 2, "notifyCameraNoData, seq[" + l + "]");
    }
    this.jdField_a_of_type_ComTencentAvVideoController.a.a(new Object[] { Integer.valueOf(38), Integer.valueOf(1), Long.valueOf(l) });
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_ComTencentAvVideoController.a().a(new Object[] { Integer.valueOf(38), Integer.valueOf(2), Long.valueOf(paramLong) });
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_ComTencentAvVideoController.a();
    if (((lff)localObject).d == 2) {
      if (paramBoolean)
      {
        ((lff)localObject).a(paramLong, false);
        if (!((lff)localObject).k)
        {
          ((lff)localObject).a(paramLong, "CloseCameraRunnable.1", 1);
          ((lff)localObject).S = true;
        }
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvVideoController.c(((lff)localObject).d);
      localObject = this.jdField_a_of_type_Msb;
      this.jdField_a_of_type_Msb = null;
      if (localObject != null) {
        ((msb)localObject).d();
      }
      return;
      if ((((lff)localObject).d == 4) && (!((lff)localObject).k)) {
        ((lff)localObject).a(paramLong, "CloseCameraRunnable.2", 3);
      }
    }
  }
  
  public void a(lpc paramlpc)
  {
    if (paramlpc.a())
    {
      paramlpc.b();
      if (QLog.isColorLevel()) {
        QLog.e("OnPreviewData", 2, "onPreviewData data is null");
      }
      return;
    }
    if (this.b)
    {
      if (QLog.isColorLevel()) {
        QLog.i("SurfaceTag", 2, "onPreviewData, first frame for switchCamera");
      }
      if (this.jdField_a_of_type_MqqUtilWeakReference != null) {
        break label77;
      }
    }
    label77:
    for (lci locallci = null;; locallci = (lci)this.jdField_a_of_type_MqqUtilWeakReference.get())
    {
      if (locallci != null) {
        locallci.a();
      }
      this.b = false;
      super.a(paramlpc);
      return;
    }
  }
  
  public void a(boolean paramBoolean, lci paramlci)
  {
    this.b = paramBoolean;
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramlci);
    if (QLog.isColorLevel()) {
      QLog.i("SurfaceTag", 2, "setSwitchStart, isStart[" + paramBoolean + "], listener[" + paramlci + "]");
    }
  }
  
  public void b()
  {
    lpm locallpm = this.jdField_a_of_type_ComTencentAvVideoController.a(BaseApplicationImpl.getContext());
    if (locallpm != null)
    {
      a(locallpm);
      return;
    }
    QLog.i("CameraDataProcess", 1, "checkEffectCtrl, ctrl is null.");
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_MqqUtilWeakReference != null) {
      this.jdField_a_of_type_MqqUtilWeakReference.clear();
    }
    if (QLog.isColorLevel()) {
      QLog.i("SurfaceTag", 2, "clearSwitchCameraListener, isStart[" + this.b + "]");
    }
  }
  
  public void d() {}
  
  public void e()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Boolean = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lch
 * JD-Core Version:    0.7.0.1
 */