import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.smallscreen.SmallScreenActivityPlugin.1;
import com.tencent.av.smallscreen.SmallScreenActivityPlugin.2;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;

public class loj
{
  private static volatile loj jdField_a_of_type_Loj;
  VideoController jdField_a_of_type_ComTencentAvVideoController;
  public VideoAppInterface a;
  boolean jdField_a_of_type_Boolean = false;
  public boolean b = true;
  
  private loj(VideoAppInterface paramVideoAppInterface)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
    this.jdField_a_of_type_ComTencentAvVideoController = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
  }
  
  public static loj a(VideoAppInterface paramVideoAppInterface)
  {
    if (jdField_a_of_type_Loj == null) {}
    try
    {
      if (jdField_a_of_type_Loj == null) {
        jdField_a_of_type_Loj = new loj(paramVideoAppInterface);
      }
      return jdField_a_of_type_Loj;
    }
    finally {}
  }
  
  public void a()
  {
    if (lor.f()) {
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
    kvq localkvq;
    if (!paramBoolean)
    {
      if (!lor.f()) {
        break label159;
      }
      localkvq = this.jdField_a_of_type_ComTencentAvVideoController.a();
      int i = localkvq.d;
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
      lor.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp(), localkvq);
      return;
    }
    label159:
    lor.a(paramLong, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 2);
  }
  
  public void a(boolean paramBoolean)
  {
    if (lor.f())
    {
      this.jdField_a_of_type_Boolean = false;
      this.b = false;
    }
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_Boolean) || (!lor.f());
  }
  
  public void b()
  {
    long l = AudioHelper.b();
    if (QLog.isColorLevel()) {
      QLog.w("SmallScreenActivityPlugin", 1, "onResume, seq[" + l + "]");
    }
    if (lor.f())
    {
      this.jdField_a_of_type_Boolean = false;
      this.b = true;
      ThreadManager.post(new SmallScreenActivityPlugin.1(this, l), 5, null, false);
    }
    lor.a(l, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 0);
  }
  
  public void c()
  {
    this.jdField_a_of_type_Boolean = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     loj
 * JD-Core Version:    0.7.0.1
 */