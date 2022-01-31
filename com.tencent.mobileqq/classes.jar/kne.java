import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.tencent.biz.lebasearch.LebaSearchMoreInfoActivity;
import com.tencent.biz.troop.TroopMemberApiClient;

public class kne
  extends Handler
{
  public kne(LebaSearchMoreInfoActivity paramLebaSearchMoreInfoActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    paramMessage = (Bundle)paramMessage.obj;
    this.a.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a(17, paramMessage, this.a.jdField_a_of_type_ComTencentMobileqqAppBusinessObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kne
 * JD-Core Version:    0.7.0.1
 */