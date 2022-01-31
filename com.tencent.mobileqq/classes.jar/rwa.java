import com.tencent.mobileqq.activity.ChatHistory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageRecord;

class rwa
  implements Runnable
{
  rwa(rvz paramrvz) {}
  
  public void run()
  {
    MessageRecord localMessageRecord = new MessageRecord();
    localMessageRecord.shmsgseq = this.a.a.jdField_a_of_type_Long;
    int i = this.a.a.app.a().a(this.a.a.b, this.a.a.jdField_a_of_type_Int, localMessageRecord);
    this.a.a.runOnUiThread(new rwb(this, i));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rwa
 * JD-Core Version:    0.7.0.1
 */