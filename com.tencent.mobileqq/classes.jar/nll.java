import com.tencent.biz.qqstory.newshare.callback.OnPlayModeShareListener;
import com.tencent.biz.qqstory.playmode.VideoPlayModeBase;
import com.tencent.biz.qqstory.playmode.child.ShareGroupHotSortPlayMode;
import com.tencent.biz.qqstory.shareGroup.model.ShareGroupItem;
import com.tencent.biz.qqstory.support.report.StoryReportor;

public class nll
  extends OnPlayModeShareListener
{
  public nll(ShareGroupHotSortPlayMode paramShareGroupHotSortPlayMode, VideoPlayModeBase paramVideoPlayModeBase, ShareGroupItem paramShareGroupItem)
  {
    super(paramVideoPlayModeBase);
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    StoryReportor.a("share_story", "single_suc", 0, paramInt, new String[] { this.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem.getReportUserType() });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nll
 * JD-Core Version:    0.7.0.1
 */