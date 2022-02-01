import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.smallscreen.SmallScreenActivityPlugin.1;
import com.tencent.av.smallscreen.SmallScreenActivityPlugin.2;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;

public class lyq
{
  private static volatile lyq jdField_a_of_type_Lyq;
  VideoController jdField_a_of_type_ComTencentAvVideoController;
  public VideoAppInterface a;
  boolean jdField_a_of_type_Boolean = false;
  public boolean b = true;
  
  private lyq(VideoAppInterface paramVideoAppInterface)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
    this.jdField_a_of_type_ComTencentAvVideoController = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
  }
  
  public static lyq a(VideoAppInterface paramVideoAppInterface)
  {
    if (jdField_a_of_type_Lyq == null) {}
    try
    {
      if (jdField_a_of_type_Lyq == null) {
        jdField_a_of_type_Lyq = new lyq(paramVideoAppInterface);
      }
      return jdField_a_of_type_Lyq;
    }
    finally {}
  }
  
  public void a()
  {
    if (lzb.f()) {
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
    lez locallez;
    if (!paramBoolean)
    {
      if (!lzb.f()) {
        break label170;
      }
      locallez = this.jdField_a_of_type_ComTencentAvVideoController.a();
      int i = locallez.d;
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
      lzb.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp(), locallez);
      return;
    }
    label170:
    lzb.a(paramLong, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 2);
  }
  
  public void a(boolean paramBoolean)
  {
    if (lzb.f())
    {
      this.jdField_a_of_type_Boolean = false;
      this.b = false;
    }
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_Boolean) || (!lzb.f());
  }
  
  public void b()
  {
    long l = AudioHelper.b();
    if (QLog.isColorLevel()) {
      QLog.w("SmallScreenActivityPlugin", 1, "onResume, seq[" + l + "]");
    }
    if (lzb.f())
    {
      this.jdField_a_of_type_Boolean = false;
      this.b = true;
      ThreadManager.excute(new SmallScreenActivityPlugin.1(this, l), 16, null, false);
    }
    lzb.a(l, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 0);
  }
  
  public void c()
  {
    this.jdField_a_of_type_Boolean = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lyq
 * JD-Core Version:    0.7.0.1
 */