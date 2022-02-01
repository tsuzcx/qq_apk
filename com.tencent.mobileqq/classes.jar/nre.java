import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.tencent.biz.lebasearch.LebaSearchMoreInfoActivity;

public class nre
  extends Handler
{
  public nre(LebaSearchMoreInfoActivity paramLebaSearchMoreInfoActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    paramMessage = (Bundle)paramMessage.obj;
    this.a.jdField_a_of_type_Zon.a(17, paramMessage, this.a.jdField_a_of_type_ComTencentMobileqqAppBusinessObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nre
 * JD-Core Version:    0.7.0.1
 */