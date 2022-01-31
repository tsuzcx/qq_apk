import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.troop.data.TroopAioTips;
import com.tencent.mobileqq.widget.ScrollerRunnable;
import com.tencent.qphone.base.util.QLog;

class rrc
  implements Runnable
{
  rrc(rrb paramrrb, MessageRecord paramMessageRecord) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Rrb.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().isFinishing()) {}
    int i;
    do
    {
      do
      {
        return;
      } while ((this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord == null) || (this.jdField_a_of_type_Rrb.jdField_a_of_type_Int > 200));
      if (QLog.isColorLevel()) {
        QLog.d("Q.aio.BaseChatPie.troop.special_msg", 2, "refreshHeadMessage==>fistseq:" + this.jdField_a_of_type_Rrb.jdField_b_of_type_Long + ", mr.shmsgseq:" + this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.shmsgseq);
      }
      if ((int)this.jdField_a_of_type_Rrb.jdField_b_of_type_Long >= this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.shmsgseq + 1L)
      {
        if (this.jdField_a_of_type_Rrb.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips != null) {
          this.jdField_a_of_type_Rrb.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.a(this.jdField_a_of_type_Rrb.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.shmsgseq, false);
        }
        if (this.jdField_a_of_type_Rrb.jdField_b_of_type_Int == 5) {
          this.jdField_a_of_type_Rrb.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq);
        }
        this.jdField_a_of_type_Rrb.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.a(this.jdField_a_of_type_Rrb.jdField_b_of_type_Int, 0, -1, this.jdField_a_of_type_Rrb.jdField_a_of_type_JavaLangRunnable);
        return;
      }
      i = this.jdField_a_of_type_Rrb.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.a((ChatMessage)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
    } while (i == -1);
    this.jdField_a_of_type_Rrb.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.a(this.jdField_a_of_type_Rrb.jdField_b_of_type_Int, i, i, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rrc
 * JD-Core Version:    0.7.0.1
 */