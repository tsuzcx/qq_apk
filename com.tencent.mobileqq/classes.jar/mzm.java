import com.tencent.biz.qqstory.base.QQStoryFeedManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.Iterator;
import java.util.List;

public class mzm
  implements Runnable
{
  public mzm(QQStoryFeedManager paramQQStoryFeedManager, String paramString) {}
  
  public void run()
  {
    Iterator localIterator = QQStoryFeedManager.a(this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryFeedManager).a().a(this.jdField_a_of_type_JavaLangString, 0, new int[] { -2061 }).iterator();
    while (localIterator.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)localIterator.next();
      QQStoryFeedManager.a(this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryFeedManager).a().a(localMessageRecord.frienduin, 0, localMessageRecord.msgtype, localMessageRecord.uniseq);
      QQStoryFeedManager.a(this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryFeedManager).a().b(localMessageRecord.frienduin, localMessageRecord.istroop, localMessageRecord.uniseq);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mzm
 * JD-Core Version:    0.7.0.1
 */