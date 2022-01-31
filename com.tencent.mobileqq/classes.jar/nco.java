import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.tencent.biz.lebasearch.LebaSearchMoreInfoActivity;

public class nco
  extends Handler
{
  public nco(LebaSearchMoreInfoActivity paramLebaSearchMoreInfoActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    paramMessage = (Bundle)paramMessage.obj;
    this.a.jdField_a_of_type_Wxr.a(17, paramMessage, this.a.jdField_a_of_type_Ajte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     nco
 * JD-Core Version:    0.7.0.1
 */