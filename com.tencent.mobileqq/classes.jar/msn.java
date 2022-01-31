import android.os.Handler;
import android.os.Message;
import com.tencent.biz.now.NowVideoView;
import com.tencent.mobileqq.data.MessageRecord;

public class msn
  extends Handler
{
  public msn(NowVideoView paramNowVideoView) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        return;
      } while ((this.a.jdField_a_of_type_Msg == null) || (this.a.jdField_a_of_type_ComTencentMobileqqDataMessageRecord == null));
      this.a.jdField_a_of_type_Msg.a(this.a.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin, this.a.jdField_a_of_type_JavaLangString, this.a.b, this.a.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.msgseq, true);
      return;
    } while ((this.a.jdField_a_of_type_Msg == null) || (this.a.jdField_a_of_type_ComTencentMobileqqDataMessageRecord == null) || (this.a.jdField_a_of_type_Boolean) || (this.a.d != 2));
    this.a.jdField_a_of_type_Msg.a(this.a.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin, this.a.jdField_a_of_type_JavaLangString, this.a.b, this.a.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.msgseq, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     msn
 * JD-Core Version:    0.7.0.1
 */