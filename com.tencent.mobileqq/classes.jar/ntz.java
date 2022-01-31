import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.StoryConfigManager;
import com.tencent.biz.qqstory.storyHome.QQStoryTakeVideoHelper;
import com.tencent.biz.qqstory.storyHome.qqstorylist.model.QQStoryNetReqUtils.RequestCallBack;
import com.tencent.biz.qqstory.support.logging.SLog;

public class ntz
  implements QQStoryNetReqUtils.RequestCallBack
{
  public ntz(QQStoryTakeVideoHelper paramQQStoryTakeVideoHelper, StoryConfigManager paramStoryConfigManager) {}
  
  public void a(ErrorMessage paramErrorMessage)
  {
    SLog.e("QQStoryTakeVideoHelper", "get vip error.");
  }
  
  public void a(Integer paramInteger)
  {
    SLog.b("QQStoryTakeVideoHelper", "get vip competed, vip:" + paramInteger);
    this.jdField_a_of_type_ComTencentBizQqstoryModelStoryConfigManager.b("qqstory_i_am_vip", paramInteger);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ntz
 * JD-Core Version:    0.7.0.1
 */