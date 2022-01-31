import com.tencent.biz.qqstory.newshare.job.ShortenUrlJob;
import com.tencent.biz.qqstory.newshare.mode.base.ShareModeBase;
import com.tencent.biz.qqstory.newshare.model.ShareCopyLinkData;
import java.util.HashMap;

public class nkx
  extends ShortenUrlJob
{
  public nkx(ShareModeBase paramShareModeBase, ShareCopyLinkData paramShareCopyLinkData) {}
  
  public boolean b()
  {
    HashMap localHashMap = (HashMap)a("ShortenUrlJob_shortenedUrls");
    this.jdField_a_of_type_ComTencentBizQqstoryNewshareModelShareCopyLinkData.a = ((String)localHashMap.get(this.jdField_a_of_type_ComTencentBizQqstoryNewshareModelShareCopyLinkData.a));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nkx
 * JD-Core Version:    0.7.0.1
 */