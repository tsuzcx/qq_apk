import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.newshare.job.AddInteractViewJob;
import com.tencent.biz.qqstory.newshare.mode.base.ShareModeBase;
import com.tencent.biz.qqstory.newshare.model.ShareSinaData;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.AssertUtils;

public class nlg
  extends AddInteractViewJob
{
  public nlg(ShareModeBase paramShareModeBase, StoryVideoItem paramStoryVideoItem, ShareSinaData paramShareSinaData)
  {
    super(paramStoryVideoItem);
  }
  
  public boolean b()
  {
    String str = (String)a("result");
    AssertUtils.a(str);
    AssertUtils.a(this.jdField_a_of_type_ComTencentBizQqstoryNewshareModelShareSinaData.d);
    if (this.jdField_a_of_type_ComTencentBizQqstoryNewshareModelShareSinaData.d == null)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryNewshareModelShareSinaData.d = "";
      SLog.c(this.b, "imageLocalPath is null", new Throwable());
    }
    a("DownloadPic2FileJob_iiu", str);
    a("DownloadPic2FileJob_isfp", this.jdField_a_of_type_ComTencentBizQqstoryNewshareModelShareSinaData.d);
    a("DownloadPic2FileJob_IN_ROUND", Boolean.valueOf(this.jdField_a_of_type_ComTencentBizQqstoryNewshareModelShareSinaData.a));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nlg
 * JD-Core Version:    0.7.0.1
 */