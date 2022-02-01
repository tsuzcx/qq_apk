import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.smallscreen.SmallScreenActivityPlugin.1;
import com.tencent.av.smallscreen.SmallScreenActivityPlugin.2;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;

public class lyj
{
  private static volatile lyj jdField_a_of_type_Lyj;
  VideoController jdField_a_of_type_ComTencentAvVideoController;
  public VideoAppInterface a;
  boolean jdField_a_of_type_Boolean = false;
  public boolean b = true;
  
  private lyj(VideoAppInterface paramVideoAppInterface)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
    this.jdField_a_of_type_ComTencentAvVideoController = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
  }
  
  public static lyj a(VideoAppInterface paramVideoAppInterface)
  {
    if (jdField_a_of_type_Lyj == null) {}
    try
    {
      if (jdField_a_of_type_Lyj == null) {
        jdField_a_of_type_Lyj = new lyj(paramVideoAppInterface);
      }
      return jdField_a_of_type_Lyj;
    }
    finally {}
  }
  
  public void a()
  {
    if (lyu.f()) {
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
    ley localley;
    if (!paramBoolean)
    {
      if (!lyu.f()) {
        break label170;
      }
      localley = this.jdField_a_of_type_ComTencentAvVideoController.a();
      int i = localley.d;
      paramBoolean = bool1;
      if (i != 2) {
        if (i != 4) {
          break label165;
        }
      }
    }
    label165:
    for (paramBoolean = bool1;; paramBoolean = false)
    {
      ThreadManager.excute(new SmallScreenActivityPlugin.2(this, paramLong, bool2, this.jdField_a_of_type_ComTencentAvVideoController.a().c(), paramBoolean), 16, null, false);
      lyu.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp(), localley);
      return;
    }
    label170:
    lyu.a(paramLong, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 2);
  }
  
  public void a(boolean paramBoolean)
  {
    if (lyu.f())
    {
      this.jdField_a_of_type_Boolean = false;
      this.b = false;
    }
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_Boolean) || (!lyu.f());
  }
  
  public void b()
  {
    long l = AudioHelper.b();
    if (QLog.isColorLevel()) {
      QLog.w("SmallScreenActivityPlugin", 1, "onResume, seq[" + l + "]");
    }
    if (lyu.f())
    {
      this.jdField_a_of_type_Boolean = false;
      this.b = true;
      ThreadManager.excute(new SmallScreenActivityPlugin.1(this, l), 16, null, false);
    }
    lyu.a(l, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 0);
  }
  
  public void c()
  {
    this.jdField_a_of_type_Boolean = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lyj
 * JD-Core Version:    0.7.0.1
 */