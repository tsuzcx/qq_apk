import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.smallscreen.SmallScreenActivityPlugin.1;
import com.tencent.av.smallscreen.SmallScreenActivityPlugin.2;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;

public class lyw
{
  private static volatile lyw jdField_a_of_type_Lyw;
  VideoController jdField_a_of_type_ComTencentAvVideoController;
  public VideoAppInterface a;
  boolean jdField_a_of_type_Boolean = false;
  public boolean b = true;
  
  private lyw(VideoAppInterface paramVideoAppInterface)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
    this.jdField_a_of_type_ComTencentAvVideoController = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
  }
  
  public static lyw a(VideoAppInterface paramVideoAppInterface)
  {
    if (jdField_a_of_type_Lyw == null) {}
    try
    {
      if (jdField_a_of_type_Lyw == null) {
        jdField_a_of_type_Lyw = new lyw(paramVideoAppInterface);
      }
      return jdField_a_of_type_Lyw;
    }
    finally {}
  }
  
  public void a()
  {
    if (lze.f()) {
      this.jdField_a_of_type_Boolean = false;
    }
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    boolean bool1 = true;
    boolean bool2 = VideoController.b(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp());
    if ((QLog.isColorLevel()) || (!bool2) || (paramBoolean)) {
      QLog.w("SmallScreenActivityPlugin", 1, "onPauseRender, isQuit[" + paramBoolean + "], isScreenOn[" + bool2 + "], seq[" + paramLong + "]");
    }
    lga locallga;
    if (!paramBoolean)
    {
      if (!lze.f()) {
        break label159;
      }
      locallga = this.jdField_a_of_type_ComTencentAvVideoController.a();
      int i = locallga.d;
      paramBoolean = bool1;
      if (i != 2) {
        if (i != 4) {
          break label154;
        }
      }
    }
    label154:
    for (paramBoolean = bool1;; paramBoolean = false)
    {
      ThreadManager.post(new SmallScreenActivityPlugin.2(this, paramLong, bool2, paramBoolean), 5, null, false);
      lze.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp(), locallga);
      return;
    }
    label159:
    lze.a(paramLong, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 2);
  }
  
  public void a(boolean paramBoolean)
  {
    if (lze.f())
    {
      this.jdField_a_of_type_Boolean = false;
      this.b = false;
    }
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_Boolean) || (!lze.f());
  }
  
  public void b()
  {
    long l = AudioHelper.b();
    if (QLog.isColorLevel()) {
      QLog.w("SmallScreenActivityPlugin", 1, "onResume, seq[" + l + "]");
    }
    if (lze.f())
    {
      this.jdField_a_of_type_Boolean = false;
      this.b = true;
      ThreadManager.post(new SmallScreenActivityPlugin.1(this, l), 5, null, false);
    }
    lze.a(l, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 0);
  }
  
  public void c()
  {
    this.jdField_a_of_type_Boolean = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lyw
 * JD-Core Version:    0.7.0.1
 */