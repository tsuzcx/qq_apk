import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.QQStoryHandler;
import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.playmode.util.PlayModeUtils;
import com.tencent.biz.qqstory.storyHome.model.BannerFeedItem;
import com.tencent.biz.qqstory.storyHome.model.BannerHomeFeed;
import com.tencent.biz.qqstory.storyHome.model.HomeFeedPresenter;
import com.tencent.biz.qqstory.storyHome.qqstorylist.common.ChildViewClickListener;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.BaseViewHolder;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.FeedSegment;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.utils.NetworkUtils;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.mobileqq.widget.QQToast;
import java.util.List;

public class oey
  extends ChildViewClickListener
{
  public oey(FeedSegment paramFeedSegment) {}
  
  public void a(int paramInt, View paramView, Object paramObject, BaseViewHolder paramBaseViewHolder)
  {
    if (paramView.getVisibility() != 0) {}
    while (UIUtils.b()) {
      return;
    }
    paramBaseViewHolder = (BannerHomeFeed)this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelHomeFeedPresenter.a().get(paramInt);
    paramObject = (BannerFeedItem)paramBaseViewHolder.a();
    String str1;
    String str2;
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131371658: 
    case 2131371659: 
      str1 = paramObject.getOwner().getUnionId();
      str2 = paramObject.feedId;
      if (paramView.getId() != 2131371658) {
        break;
      }
    case 2131371740: 
      for (paramView = "1";; paramView = "2")
      {
        StoryReportor.a("home_page", "clk_ac_card", 0, 0, new String[] { paramView, "", str1, str2 });
        if (!TextUtils.isEmpty(paramObject.schema)) {
          break;
        }
        SLog.e("Q.qqstory.home:FeedSegment", "The schema url is null!!");
        return;
        StoryApi.a(FeedSegment.a(this.a), 4, paramObject.getOwner().getUnionId());
        paramInt = StoryReportor.a(paramObject);
        int i = StoryReportor.b(paramObject);
        if (this.a.jdField_a_of_type_Int == 11) {}
        for (paramView = "3";; paramView = "1")
        {
          StoryReportor.a("home_page", "clk_head_nick", paramInt, 0, new String[] { String.valueOf(i), paramView, paramObject.feedId, "" });
          return;
        }
      }
      SLog.a("Q.qqstory.home:FeedSegment", "click banner feed and jump to %s", paramObject.schema);
      if (((BannerFeedItem)paramBaseViewHolder.a()).schema.startsWith("mqqapi:"))
      {
        QQStoryContext.a();
        JumpParser.a((QQAppInterface)QQStoryContext.a(), FeedSegment.a(this.a), paramObject.schema).b();
        return;
      }
      if (!NetworkUtils.a(FeedSegment.a(this.a)))
      {
        QQToast.a(FeedSegment.a(this.a), 1, "网络异常，请稍后重试", 0).a();
        return;
      }
      paramView = new Intent(FeedSegment.a(this.a), QQBrowserActivity.class);
      paramView.putExtra("url", paramObject.schema);
      FeedSegment.a(this.a).startActivity(paramView);
      return;
    case 2131371725: 
      if (!NetworkUtils.a(FeedSegment.a(this.a)))
      {
        QQToast.a(FeedSegment.a(this.a), 1, "网络异常，请稍后重试", 0).a();
        return;
      }
      paramObject = ((BannerFeedItem)paramBaseViewHolder.a()).getOwner();
      ((QQStoryHandler)PlayModeUtils.a().a(98)).a(1, paramObject.getUnionId(), 0, 12);
      paramView.setVisibility(8);
      StoryReportor.a("home_page", "follow_recom", 0, 0, new String[] { "3", "1", paramObject.getUnionId(), ((BannerFeedItem)paramBaseViewHolder.a()).feedId });
      return;
    }
    FeedSegment.a(this.a, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     oey
 * JD-Core Version:    0.7.0.1
 */