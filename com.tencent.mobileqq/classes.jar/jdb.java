import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.QLog;

public class jdb
  implements Runnable
{
  public jdb(VideoController paramVideoController) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d(VideoController.jdField_a_of_type_JavaLangString, 2, "mDoubleVideoMeetingSwitchMulti timeOut ");
    }
    this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(28), String.valueOf(this.a.a().f), Boolean.valueOf(true) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jdb
 * JD-Core Version:    0.7.0.1
 */