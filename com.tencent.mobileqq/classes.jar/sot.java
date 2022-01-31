import android.os.Message;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.data.Card;
import com.tencent.util.WeakReferenceHandler;

class sot
  implements Runnable
{
  sot(sos paramsos, Card paramCard) {}
  
  public void run()
  {
    boolean bool = this.jdField_a_of_type_Sos.a.a((int)this.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentStyleId, (int)this.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentBgId, this.jdField_a_of_type_ComTencentMobileqqDataCard.backgroundUrl, (int)this.jdField_a_of_type_ComTencentMobileqqDataCard.backgroundColor, this.jdField_a_of_type_ComTencentMobileqqDataCard.templateRet);
    Message localMessage = this.jdField_a_of_type_Sos.a.b.obtainMessage(13, Boolean.valueOf(bool));
    this.jdField_a_of_type_Sos.a.b.sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     sot
 * JD-Core Version:    0.7.0.1
 */