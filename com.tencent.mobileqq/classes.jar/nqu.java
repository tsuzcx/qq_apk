import com.tencent.biz.qqstory.newshare.callback.OnSimpleShareListener;
import com.tencent.biz.qqstory.shareGroup.infocard.QQStoryShareGroupProfileActivity;
import com.tencent.biz.qqstory.shareGroup.infocard.QQStoryShareGroupProfileActivity.UIEventListenerImpl;
import com.tencent.biz.qqstory.shareGroup.model.ShareGroupItem;
import com.tencent.biz.qqstory.support.report.StoryReportor;

public class nqu
  extends OnSimpleShareListener
{
  public nqu(QQStoryShareGroupProfileActivity.UIEventListenerImpl paramUIEventListenerImpl) {}
  
  public void a()
  {
    super.a();
    QQStoryShareGroupProfileActivity.UIEventListenerImpl.a(this.a).jdField_a_of_type_ComTencentBizQqstoryNewshareStoryShare = null;
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    StoryReportor.a("share_story", "day_suc", 0, paramInt, new String[] { QQStoryShareGroupProfileActivity.UIEventListenerImpl.a(this.a).jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem.getReportUserType() });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nqu
 * JD-Core Version:    0.7.0.1
 */