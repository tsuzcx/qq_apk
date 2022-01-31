import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.network.BatchHandlerListPuller.IPullResultCallback;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.troop.model.VidToGroupInfoPuller;

public class omi
  implements BatchHandlerListPuller.IPullResultCallback
{
  public omi(VidToGroupInfoPuller paramVidToGroupInfoPuller) {}
  
  public void a(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("StoryId list to group info list finish !");
    if (paramBoolean) {}
    for (String str = "Every task success";; str = "Some task error")
    {
      SLog.d("Q.qqstory.net:VidToGroupInfoPuller", str);
      this.a.a(this.a.jdField_a_of_type_JavaUtilList, new ErrorMessage(), true, paramBoolean);
      this.a.jdField_a_of_type_Int = 2;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     omi
 * JD-Core Version:    0.7.0.1
 */