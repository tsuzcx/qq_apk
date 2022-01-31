import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.core.VcControllerImpl;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;

public class lfw
  implements muw
{
  public lfw(VideoController paramVideoController)
  {
    if (QLog.isColorLevel()) {
      QLog.d(VideoController.jdField_a_of_type_JavaLangString, 2, "new QQPhoneStatusListener");
    }
  }
  
  public void a(boolean paramBoolean)
  {
    lid locallid = this.a.a();
    boolean bool2 = locallid.S;
    long l = AudioHelper.b();
    boolean bool1;
    if (QLog.isColorLevel())
    {
      String str = VideoController.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder().append("onCallStateChanged, isCalling[").append(locallid.b).append("->").append(paramBoolean).append("], mVcCtrl[");
      if (this.a.jdField_a_of_type_ComTencentAvCoreVcControllerImpl != null)
      {
        bool1 = true;
        QLog.w(str, 1, bool1 + "], sessionInfo[" + locallid + "], isPeerOnPhone[" + bool2 + "], seq[" + l + "]");
      }
    }
    else
    {
      if (this.a.jdField_a_of_type_ComTencentAvCoreVcControllerImpl != null) {
        break label144;
      }
    }
    for (;;)
    {
      return;
      bool1 = false;
      break;
      label144:
      if (paramBoolean) {
        switch (locallid.jdField_g_of_type_Int)
        {
        }
      }
      while (!bool2)
      {
        this.a.a(true, paramBoolean);
        return;
        this.a.a(locallid.d, 218);
        this.a.b(218);
        this.a.b(locallid.d, 0);
        continue;
        this.a.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.rejectVideo(locallid.d, this.a.c(), 65535);
        this.a.a(locallid.d, 219);
        this.a.b(219);
        this.a.b(locallid.d, 1);
        continue;
        this.a.a(l, 3, Long.valueOf(locallid.d).longValue());
        if (QLog.isColorLevel())
        {
          QLog.e(VideoController.jdField_a_of_type_JavaLangString, 2, "Reject Video Request when chating");
          continue;
          this.a.b(true);
          continue;
          this.a.a(l, this.a.n, this.a.d);
          this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(67), Long.valueOf(this.a.d), Integer.valueOf(3) });
          continue;
          this.a.a(mww.b(locallid.i), locallid.jdField_g_of_type_Long, 86);
          this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(66), Long.valueOf(locallid.jdField_g_of_type_Long) });
          continue;
          switch (locallid.jdField_g_of_type_Int)
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
            this.a.b(false);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     lfw
 * JD-Core Version:    0.7.0.1
 */