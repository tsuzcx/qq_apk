import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.newshare.job.AddInteractViewJob;
import com.tencent.biz.qqstory.newshare.mode.base.ShareModeBase;
import com.tencent.biz.qqstory.newshare.model.ShareQQData;

public class nfh
  extends AddInteractViewJob
{
  public nfh(ShareModeBase paramShareModeBase, StoryVideoItem paramStoryVideoItem, ShareQQData paramShareQQData)
  {
    super(paramStoryVideoItem);
  }
  
  public boolean b()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryNewshareModelShareQQData.a = ((String)a("result"));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nfh
 * JD-Core Version:    0.7.0.1
 */