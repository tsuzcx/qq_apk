import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.TroopVidToVideoInfoPuller;
import com.tencent.biz.qqstory.network.BatchHandlerListPuller.IPullResultCallback;
import com.tencent.biz.qqstory.support.logging.SLog;
import java.util.List;

public class nhd
  implements BatchHandlerListPuller.IPullResultCallback
{
  public nhd(TroopVidToVideoInfoPuller paramTroopVidToVideoInfoPuller, List paramList) {}
  
  public void a(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("Vid list to video info list finish !");
    if (paramBoolean) {}
    for (String str = "Every task success";; str = "Some task error")
    {
      SLog.d("Q.qqstory.net:TroopVidToVideoInfoPuller", str);
      this.jdField_a_of_type_ComTencentBizQqstoryModelTroopVidToVideoInfoPuller.a(this.jdField_a_of_type_JavaUtilList, new ErrorMessage(), true, paramBoolean);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nhd
 * JD-Core Version:    0.7.0.1
 */