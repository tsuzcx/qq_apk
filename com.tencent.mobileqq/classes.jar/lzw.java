import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.camera.CameraUtils;
import com.tencent.qphone.base.util.QLog;

class lzw
  extends ljr
{
  lzw(lzv paramlzv) {}
  
  protected void a(long paramLong, boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.w("SmallScreenVideoController", 1, "onAfterOpenCamera, success[" + paramBoolean + "], preSessionType[" + paramInt + "], seq[" + paramLong + "]");
    }
    if (paramBoolean)
    {
      if ((this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) && (lzr.f()) && ((paramInt == 1) || (paramInt == 3)) && (this.a.jdField_a_of_type_Maa != null))
      {
        this.a.jdField_a_of_type_Maa.a(true, false);
        this.a.jdField_a_of_type_Maa.c(paramLong, this.a.jdField_a_of_type_ComTencentAvCameraCameraUtils.a());
      }
      return;
    }
    String str;
    if ((this.a.jdField_a_of_type_ComTencentAvVideoController != null) && (this.a.jdField_a_of_type_ComTencentAvVideoController.a() != null))
    {
      str = "";
      if (!this.a.jdField_a_of_type_ComTencentAvVideoController.a().r()) {
        break label250;
      }
      str = "0X8004894";
    }
    for (;;)
    {
      bdla.b(null, "CliOper", "", "", str, str, 0, 0, "", "", "", "");
      if (this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {
        break;
      }
      this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(38), Integer.valueOf(2), Long.valueOf(paramLong) });
      return;
      label250:
      if (this.a.jdField_a_of_type_ComTencentAvVideoController.a().f == 1) {
        str = "0X8004888";
      } else if (this.a.jdField_a_of_type_ComTencentAvVideoController.a().f == 2) {
        str = "0X800488E";
      }
    }
  }
  
  protected void a(boolean paramBoolean) {}
  
  protected void b() {}
  
  protected void b(long paramLong, boolean paramBoolean)
  {
    if ((this.a.jdField_a_of_type_ComTencentAvVideoController != null) && ((this.a.jdField_a_of_type_ComTencentAvVideoController.a().j == 1011) || (this.a.jdField_a_of_type_ComTencentAvVideoController.f)))
    {
      this.a.jdField_a_of_type_Maa.a(false, false);
      this.a.jdField_a_of_type_Maa.x_();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     lzw
 * JD-Core Version:    0.7.0.1
 */