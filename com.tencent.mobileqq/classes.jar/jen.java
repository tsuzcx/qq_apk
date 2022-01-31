import android.content.Intent;
import com.tencent.av.VideoController;
import com.tencent.av.VideoController.GAudioFriends;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.core.VcControllerImpl;
import com.tencent.av.ui.MultiPstnCallbackFinishDialogActivity;
import com.tencent.av.utils.PhoneStatusMonitor.PhoneStatusListener;
import com.tencent.av.utils.UITools;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class jen
  implements PhoneStatusMonitor.PhoneStatusListener
{
  public jen(VideoController paramVideoController)
  {
    if (QLog.isColorLevel()) {
      QLog.d(VideoController.jdField_a_of_type_JavaLangString, 2, "new QQPhoneStatusListener");
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(VideoController.jdField_a_of_type_JavaLangString, 2, "onCallStateChanged isCalling: " + paramBoolean);
    }
    if (this.a.jdField_a_of_type_ComTencentAvCoreVcControllerImpl == null)
    {
      QLog.d(VideoController.jdField_a_of_type_JavaLangString, 2, "onCallStateChanged()  mVcCtrl == null !!    return !");
      return;
    }
    if (paramBoolean) {
      switch (this.a.a().g)
      {
      }
    }
    for (;;)
    {
      if ((this.a.a() != null) && (this.a.a().n()) && (this.a.a().x == 1))
      {
        if (!paramBoolean) {
          break;
        }
        this.a.a().M = false;
        this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(705), Boolean.valueOf(false) });
      }
      this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(22), Boolean.valueOf(paramBoolean) });
      return;
      this.a.a(this.a.a().c, 0);
      this.a.b(218);
      this.a.c(this.a.a().c, 0);
      continue;
      this.a.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.rejectVideo(this.a.a().c, this.a.c(), 3);
      this.a.a(this.a.a().c, 0);
      this.a.b(219);
      this.a.c(this.a.a().c, 1);
      continue;
      this.a.b(3, Long.valueOf(this.a.a().c).longValue());
      if (QLog.isColorLevel())
      {
        QLog.e(VideoController.jdField_a_of_type_JavaLangString, 2, "Reject Video Request when chating");
        continue;
        this.a.b(true);
        continue;
        this.a.b(this.a.s, this.a.e);
        this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(67), Long.valueOf(this.a.e), Integer.valueOf(3) });
        continue;
        this.a.a(UITools.a(this.a.a().i), this.a.a().f, 86);
        this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(66), Long.valueOf(this.a.a().f) });
        continue;
        switch (this.a.a().g)
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
    Object localObject = this.a.a().iterator();
    do
    {
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
    } while (((VideoController.GAudioFriends)((Iterator)localObject).next()).c == 0);
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        localObject = new Intent(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getApplicationContext(), MultiPstnCallbackFinishDialogActivity.class);
        ((Intent)localObject).addFlags(268435456);
        this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().startActivity((Intent)localObject);
        break;
      }
      this.a.a(UITools.a(this.a.a().i), this.a.a().f, 87);
      this.a.C();
      this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(66), Long.valueOf(this.a.a().f) });
      break;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jen
 * JD-Core Version:    0.7.0.1
 */