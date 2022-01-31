import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.playvideo.QQStoryWatcherListActivity;
import com.tencent.biz.qqstory.storyHome.qqstorylist.common.ChildViewClickListener;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.BaseViewHolder;
import com.tencent.biz.qqstory.support.report.StoryReportor;

public class nny
  extends ChildViewClickListener
{
  public nny(QQStoryWatcherListActivity paramQQStoryWatcherListActivity) {}
  
  public void a(int paramInt, View paramView, Object paramObject, BaseViewHolder paramBaseViewHolder)
  {
    if ((paramObject instanceof QQUserUIItem))
    {
      paramView = (QQUserUIItem)paramObject;
      StoryApi.a(this.a, 10, paramView.uid);
      if ((!TextUtils.isEmpty(this.a.jdField_a_of_type_JavaLangString)) && (this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem != null)) {
        StoryReportor.a("home_page", "clk_head_list", StoryReportor.a(this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem), 0, new String[] { "1", StoryReportor.a(this.a.jdField_a_of_type_Int), "", this.a.jdField_a_of_type_JavaLangString });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nny
 * JD-Core Version:    0.7.0.1
 */