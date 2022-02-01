import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;

public class lca
  extends lbg
  implements ljd
{
  private final VideoController jdField_a_of_type_ComTencentAvVideoController;
  private WeakReference<lcb> jdField_a_of_type_MqqUtilWeakReference;
  private boolean b;
  
  public lca(VideoController paramVideoController)
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
    if (((lez)localObject).d == 2) {
      if (paramBoolean)
      {
        ((lez)localObject).a(paramLong, false);
        if (!((lez)localObject).k)
        {
          ((lez)localObject).a(paramLong, "CloseCameraRunnable.1", 1);
          ((lez)localObject).S = true;
        }
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvVideoController.c(((lez)localObject).d);
      localObject = this.jdField_a_of_type_Mrk;
      this.jdField_a_of_type_Mrk = null;
      if (localObject != null) {
        ((mrk)localObject).d();
      }
      return;
      if ((((lez)localObject).d == 4) && (!((lez)localObject).k)) {
        ((lez)localObject).a(paramLong, "CloseCameraRunnable.2", 3);
      }
    }
  }
  
  public void a(lok paramlok)
  {
    if (paramlok.a())
    {
      paramlok.b();
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
    for (lcb locallcb = null;; locallcb = (lcb)this.jdField_a_of_type_MqqUtilWeakReference.get())
    {
      if (locallcb != null) {
        locallcb.a();
      }
      this.b = false;
      super.a(paramlok);
      return;
    }
  }
  
  public void a(boolean paramBoolean, lcb paramlcb)
  {
    this.b = paramBoolean;
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramlcb);
    if (QLog.isColorLevel()) {
      QLog.i("SurfaceTag", 2, "setSwitchStart, isStart[" + paramBoolean + "], listener[" + paramlcb + "]");
    }
  }
  
  public void b()
  {
    lou locallou = this.jdField_a_of_type_ComTencentAvVideoController.a(BaseApplicationImpl.getContext());
    if (locallou != null)
    {
      a(locallou);
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
 * Qualified Name:     lca
 * JD-Core Version:    0.7.0.1
 */