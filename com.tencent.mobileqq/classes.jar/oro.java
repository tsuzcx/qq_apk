import android.os.Handler;
import com.tencent.biz.qqstory.troop.forward.TroopStoryForwardTask;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SVIPHandler;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForTroopStory;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageRecordFactory;

public class oro
  implements Runnable
{
  public oro(TroopStoryForwardTask paramTroopStoryForwardTask) {}
  
  public void run()
  {
    MessageForTroopStory localMessageForTroopStory = (MessageForTroopStory)MessageRecordFactory.a(-2057);
    MessageRecordFactory.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageForTroopStory, this.a.k, this.a.l, this.a.jdField_d_of_type_Int);
    localMessageForTroopStory.uid = Long.valueOf(this.a.jdField_b_of_type_JavaLangString).longValue();
    localMessageForTroopStory.unionId = this.a.jdField_c_of_type_JavaLangString;
    localMessageForTroopStory.md5 = this.a.jdField_d_of_type_JavaLangString;
    localMessageForTroopStory.thumbUrl = this.a.e;
    localMessageForTroopStory.doodleUrl = this.a.f;
    localMessageForTroopStory.videoWidth = this.a.jdField_a_of_type_Int;
    localMessageForTroopStory.videoHeight = this.a.jdField_b_of_type_Int;
    localMessageForTroopStory.sourceName = this.a.g;
    localMessageForTroopStory.sourceActionType = this.a.h;
    localMessageForTroopStory.sourceActionData = this.a.i;
    localMessageForTroopStory.compatibleText = this.a.j;
    localMessageForTroopStory.ctrVersion = this.a.jdField_c_of_type_Int;
    localMessageForTroopStory.msg = "[小视频]";
    localMessageForTroopStory.serial();
    this.a.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopStory = localMessageForTroopStory;
    ((SVIPHandler)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(13)).a(localMessageForTroopStory);
    this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageForTroopStory, 0);
    this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageForTroopStory, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     oro
 * JD-Core Version:    0.7.0.1
 */