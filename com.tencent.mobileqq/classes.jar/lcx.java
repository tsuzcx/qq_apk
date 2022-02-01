import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.core.VcControllerImpl;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;

public class lcx
  implements mta
{
  public lcx(VideoController paramVideoController)
  {
    if (QLog.isColorLevel()) {
      QLog.d(VideoController.jdField_a_of_type_JavaLangString, 2, "new QQPhoneStatusListener");
    }
  }
  
  public void a(boolean paramBoolean)
  {
    lff locallff = this.a.a();
    boolean bool2 = locallff.T;
    long l = AudioHelper.b();
    boolean bool1;
    if (QLog.isColorLevel())
    {
      String str = VideoController.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder().append("onCallStateChanged, isCalling[").append(locallff.b).append("->").append(paramBoolean).append("], mVcCtrl[");
      if (this.a.jdField_a_of_type_ComTencentAvCoreVcControllerImpl != null)
      {
        bool1 = true;
        QLog.w(str, 1, bool1 + "], sessionInfo state[" + locallff.jdField_g_of_type_Int + "], isPeerOnPhone[" + bool2 + "], seq[" + l + "]");
      }
    }
    else
    {
      if (this.a.jdField_a_of_type_ComTencentAvCoreVcControllerImpl != null) {
        break label147;
      }
    }
    for (;;)
    {
      return;
      bool1 = false;
      break;
      label147:
      if (paramBoolean) {
        switch (locallff.jdField_g_of_type_Int)
        {
        }
      }
      while (!bool2)
      {
        this.a.a(true, paramBoolean);
        return;
        this.a.a(locallff.d, 218);
        this.a.b(218);
        this.a.b(locallff.d, 0);
        continue;
        this.a.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.rejectVideo(locallff.d, this.a.c(), 65535);
        this.a.a(locallff.d, 219);
        this.a.b(219);
        this.a.b(locallff.d, 1);
        continue;
        this.a.a(l, 3, Long.valueOf(locallff.d).longValue());
        if (QLog.isColorLevel())
        {
          QLog.e(VideoController.jdField_a_of_type_JavaLangString, 2, "Reject Video Request when chating");
          continue;
          this.a.a(true);
          continue;
          this.a.a(l, this.a.m, this.a.d);
          this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(67), Long.valueOf(this.a.d), Integer.valueOf(3) });
          continue;
          this.a.a(mvd.b(locallff.j), locallff.jdField_g_of_type_Long, 86);
          this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(66), Long.valueOf(locallff.jdField_g_of_type_Long) });
          continue;
          switch (locallff.jdField_g_of_type_Int)
          {
          case 2: 
          case 5: 
          case 6: 
          case 7: 
          case 8: 
          default: 
            break;
          case 3: 
          case 4: 
          case 9: 
          case 10: 
            this.a.a(false);
          }
        }
      }
    }
  }
  
  protected void finalize()
  {
    super.finalize();
    if (QLog.isColorLevel()) {
      QLog.d(VideoController.jdField_a_of_type_JavaLangString, 2, "finalize QQPhoneStatusListener");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lcx
 * JD-Core Version:    0.7.0.1
 */