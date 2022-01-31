import com.tencent.biz.qqstory.storyHome.memory.model.StoryQQ2UidConverter;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class nxm
  implements Runnable
{
  public nxm(StoryQQ2UidConverter paramStoryQQ2UidConverter, long paramLong) {}
  
  public void run()
  {
    String str = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryModelStoryQQ2UidConverter.a(this.jdField_a_of_type_Long);
    SLog.a("Q.qqstory.memories.StoryQQ2UidConverter", "get uid by qq from cache. qq = %d, uid = %s.", Long.valueOf(this.jdField_a_of_type_Long), str);
    ThreadManager.getUIHandler().post(new nxn(this, str));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nxm
 * JD-Core Version:    0.7.0.1
 */