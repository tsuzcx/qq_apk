import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.photo.PeakService;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.qphone.base.util.QLog;

public class rsb
  implements Runnable
{
  public rsb(BaseChatPie paramBaseChatPie) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.BaseChatPie", 2, "start preload peak process");
    }
    Intent localIntent = new Intent(this.a.jdField_a_of_type_AndroidContentContext, PeakService.class);
    if (VideoEnvironment.d(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
      localIntent.putExtra("ServiceAction", 2);
    }
    try
    {
      this.a.jdField_a_of_type_AndroidContentContext.startService(localIntent);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("Q.aio.BaseChatPie", 1, "onShow_otherThings startService ", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rsb
 * JD-Core Version:    0.7.0.1
 */