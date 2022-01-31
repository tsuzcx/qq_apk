import android.content.Context;
import android.view.View;
import com.tencent.biz.qqstory.comment.FeedCommentEventHandler.KeyBoardUpCallback;
import com.tencent.biz.qqstory.comment.FeedCommentLego;
import com.tencent.biz.qqstory.comment.FeedCommentLikeLego;
import com.tencent.biz.qqstory.comment.FeedCommentLikeLego.MainWidgetClickListener;
import com.tencent.biz.qqstory.comment.lego.LegoEvenHandler;
import com.tencent.biz.qqstory.model.item.IFeedOwner;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.newshare.StoryShare;
import com.tencent.biz.qqstory.newshare.mode.BannerWebShareMode;
import com.tencent.biz.qqstory.newshare.mode.FeedDetailShareMode;
import com.tencent.biz.qqstory.newshare.mode.ShareGroupOneDayStoryShareMode;
import com.tencent.biz.qqstory.playvideo.QQStoryWatcherListActivity;
import com.tencent.biz.qqstory.shareGroup.ShareGroupUtil;
import com.tencent.biz.qqstory.shareGroup.model.ShareGroupItem;
import com.tencent.biz.qqstory.storyHome.detail.view.StoryDetailActivity;
import com.tencent.biz.qqstory.storyHome.model.BannerFeedItem;
import com.tencent.biz.qqstory.storyHome.model.BannerHomeFeed;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeHomeFeed;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.utils.DateUtils;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class nfs
  extends LegoEvenHandler
{
  public nfs(FeedCommentLikeLego paramFeedCommentLikeLego) {}
  
  public void onClick(View paramView)
  {
    Object localObject1;
    label760:
    List localList;
    label1093:
    Object localObject3;
    Object localObject2;
    switch (paramView.getId())
    {
    default: 
    case 2131371729: 
    case 2131371730: 
    case 2131371700: 
    case 2131371735: 
    case 2131371731: 
      int i;
      do
      {
        return;
        if (!NetworkUtil.d(this.a.jdField_a_of_type_AndroidContentContext))
        {
          QQToast.a(BaseApplication.getContext(), 1, "网络不可用，请检查你的网络设置", 0).a();
          return;
        }
        if ((this.a.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem != null) && (this.a.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem.type == 2))
        {
          if (ShareGroupUtil.a(this.a.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem)) {
            QQToast.a(this.a.jdField_a_of_type_AndroidContentContext, 1, "你无权进行该项操作", 1).a();
          }
        }
        else if ((this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeHomeFeed != null) && (ShareGroupUtil.a()))
        {
          i = this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeHomeFeed.a().type;
          if ((i == 3) || (i == 5))
          {
            QQToast.a(this.a.jdField_a_of_type_AndroidContentContext, 1, "你无权进行该项操作", 1).a();
            return;
          }
        }
        this.a.e();
        return;
        if (!NetworkUtil.d(this.a.jdField_a_of_type_AndroidContentContext))
        {
          QQToast.a(BaseApplication.getContext(), 1, "网络不可用，请检查你的网络设置", 0).a();
          return;
        }
        if (this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.isFakeFeedItem())
        {
          QQToast.a(BaseApplication.getContext(), 1, "视频上传失败，无法评论", 0).a();
          return;
        }
        if ((this.a.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem != null) && (this.a.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem.type == 2))
        {
          if (ShareGroupUtil.a(this.a.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem)) {
            QQToast.a(this.a.jdField_a_of_type_AndroidContentContext, 1, "你无权进行该项操作", 1).a();
          }
        }
        else if ((this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeHomeFeed != null) && (ShareGroupUtil.a()))
        {
          i = this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeHomeFeed.a().type;
          if ((i == 3) || (i == 5))
          {
            QQToast.a(this.a.jdField_a_of_type_AndroidContentContext, 1, "你无权进行该项操作", 1).a();
            return;
          }
        }
        i = StoryReportor.b(this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem);
        if ((this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner() instanceof ShareGroupItem)) {}
        for (localObject1 = this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner().getUnionId();; localObject1 = "")
        {
          StoryReportor.a("home_page", "clk_reply", StoryReportor.a(this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem), 0, new String[] { String.valueOf(i), StoryReportor.a(this.a.jdField_a_of_type_Int), this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId, localObject1 });
          if (this.a.jdField_a_of_type_ComTencentBizQqstoryCommentFeedCommentEventHandler$KeyBoardUpCallback == null) {
            break;
          }
          localObject1 = (FeedCommentLego)this.a.a("commentLego");
          this.a.jdField_a_of_type_ComTencentBizQqstoryCommentFeedCommentEventHandler$KeyBoardUpCallback.a((FeedCommentLego)localObject1, paramView, this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId);
          return;
        }
        if (FeedCommentLikeLego.a(this.a) != null)
        {
          if ((this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner() instanceof QQUserUIItem))
          {
            paramView = (QQUserUIItem)this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner();
            FeedCommentLikeLego.a(this.a).a(Long.parseLong(paramView.qq), this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.ownerId, this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem);
          }
        }
        else
        {
          i = StoryReportor.b(this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem);
          if (!(this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner() instanceof ShareGroupItem)) {
            break label760;
          }
        }
        for (paramView = this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner().getUnionId();; paramView = "")
        {
          StoryReportor.a("home_page", "clk_play", StoryReportor.a(this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem), 0, new String[] { String.valueOf(i), StoryReportor.a(this.a.jdField_a_of_type_Int), this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId, paramView });
          return;
          FeedCommentLikeLego.a(this.a).a(0L, this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.ownerId, this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem);
          break;
        }
        if (this.a.jdField_a_of_type_Int == 11) {
          i = 211;
        }
        for (;;)
        {
          StoryDetailActivity.a(this.a.jdField_a_of_type_AndroidAppActivity, this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId, i, 0);
          StoryReportor.a("home_page", "clk_reply_mini", StoryReportor.a(this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem), 0, new String[] { String.valueOf(StoryReportor.b(this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem)), StoryReportor.a(this.a.jdField_a_of_type_Int), "", this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId });
          return;
          if (this.a.jdField_a_of_type_Int == 12) {
            i = 222;
          } else {
            i = 210;
          }
        }
        if (!NetworkUtil.d(this.a.jdField_a_of_type_AndroidContentContext))
        {
          QQToast.a(BaseApplication.getContext(), 1, "网络不可用，请检查你的网络设置", 0).a();
          return;
        }
      } while (UIUtils.b());
      if ((this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner() instanceof ShareGroupItem)) {}
      for (paramView = this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner().getUnionId();; paramView = "")
      {
        StoryReportor.a("home_page", "clk_share", StoryReportor.a(this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem), 0, new String[] { StoryReportor.b(this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem) + "", StoryReportor.a(this.a.jdField_a_of_type_Int), this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId, paramView });
        if ((this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem != null) && (this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner() != null)) {
          break label1093;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("FeedCommentLikeLego", 2, "can't share, commentLikeFeedItem not ready");
        return;
      }
      if (this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelBannerHomeFeed != null)
      {
        if (FeedCommentLikeLego.a(this.a) == null) {
          FeedCommentLikeLego.a(this.a, StoryShare.a(this.a.jdField_a_of_type_AndroidAppActivity));
        }
        FeedCommentLikeLego.a(this.a).a(this.a.jdField_a_of_type_AndroidContentContext.getString(2131433114)).a(new nft(this)).a(new BannerWebShareMode((BannerFeedItem)this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelBannerHomeFeed.a())).a();
        return;
      }
      localObject1 = null;
      paramView = null;
      localList = this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeHomeFeed.a();
      if (!localList.isEmpty())
      {
        Iterator localIterator = localList.iterator();
        if (localIterator.hasNext())
        {
          localObject3 = (StoryVideoItem)localIterator.next();
          if (StoryVideoItem.isFakeVid(((StoryVideoItem)localObject3).mVid)) {
            break label1876;
          }
          localObject2 = paramView;
          if (paramView == null)
          {
            if (!DateUtils.c(((StoryVideoItem)localObject3).mCreateTime)) {
              break label1372;
            }
            i = localList.size() - 1;
            label1289:
            if (i < 0) {
              break label1873;
            }
            localObject2 = (StoryVideoItem)localList.get(i);
            if (StoryVideoItem.isFakeVid(((StoryVideoItem)localObject2).mVid)) {
              break label1365;
            }
            paramView = (View)localObject2;
          }
          label1320:
          label1336:
          label1352:
          label1365:
          label1372:
          for (localObject2 = paramView;; localObject2 = localObject3)
          {
            if (localObject1 != null) {
              break label1867;
            }
            paramView = new ArrayList();
            paramView.add(((StoryVideoItem)localObject3).mVid);
            localObject1 = localObject2;
            localObject2 = localObject1;
            localObject1 = paramView;
            paramView = (View)localObject2;
            break;
            i -= 1;
            break label1289;
          }
        }
      }
      break;
    }
    for (;;)
    {
      if (localObject1 == null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("FeedCommentLikeLego", 2, "can't share, video list empty");
        }
        QQToast.a(BaseApplication.getContext(), 1, "视频尚未上传成功", 0).a();
        return;
      }
      if (paramView == null) {
        break;
      }
      boolean bool1 = StoryVideoItem.hasPollVideo(localList);
      boolean bool2 = StoryVideoItem.hasInteractVideo(localList);
      boolean bool3 = this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner().isMe();
      if ((this.a.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem != null) && (this.a.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem.allowStrangerVisitAndPost == 1))
      {
        if (FeedCommentLikeLego.a(this.a) == null) {
          FeedCommentLikeLego.a(this.a, StoryShare.a(this.a.jdField_a_of_type_AndroidAppActivity));
        }
        localObject3 = FeedCommentLikeLego.a(this.a);
        if (bool3)
        {
          localObject2 = "分享我的一天";
          localObject1 = ((StoryShare)localObject3).a((String)localObject2).a(new nfu(this)).a(ShareGroupOneDayStoryShareMode.a(this.a.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem, paramView, this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId, paramView.mCreateTime, ((List)localObject1).size()));
          if (!bool1) {
            break label1662;
          }
          paramView = "1";
          label1583:
          localObject1 = ((StoryShare)localObject1).a("vote", paramView);
          if (!bool2) {
            break label1669;
          }
        }
        label1669:
        for (paramView = "1";; paramView = "0")
        {
          ((StoryShare)localObject1).a("grade", paramView).a();
          StoryReportor.a("share_story", "share_day", 0, 0, new String[] { this.a.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem.getReportUserType() });
          return;
          localObject2 = this.a.jdField_a_of_type_AndroidContentContext.getString(2131433114);
          break;
          label1662:
          paramView = "0";
          break label1583;
        }
      }
      if (FeedCommentLikeLego.a(this.a) == null) {
        FeedCommentLikeLego.a(this.a, StoryShare.a(this.a.jdField_a_of_type_AndroidAppActivity));
      }
      localObject3 = FeedCommentLikeLego.a(this.a);
      if (bool3)
      {
        localObject2 = "分享我的一天";
        localObject1 = ((StoryShare)localObject3).a((String)localObject2).a(new nfv(this)).a(new FeedDetailShareMode(paramView, this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId, ((List)localObject1).size()));
        if (!bool1) {
          break label1830;
        }
        paramView = "1";
        label1779:
        localObject1 = ((StoryShare)localObject1).a("vote", paramView);
        if (!bool2) {
          break label1837;
        }
      }
      label1830:
      label1837:
      for (paramView = "1";; paramView = "0")
      {
        ((StoryShare)localObject1).a("grade", paramView).a();
        return;
        localObject2 = this.a.jdField_a_of_type_AndroidContentContext.getString(2131433114);
        break;
        paramView = "0";
        break label1779;
      }
      QQStoryWatcherListActivity.a(this.a.jdField_a_of_type_AndroidAppActivity, this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId, 10);
      return;
      label1867:
      paramView = (View)localObject1;
      break label1336;
      label1873:
      break label1320;
      label1876:
      localObject2 = localObject1;
      localObject1 = paramView;
      paramView = (View)localObject2;
      break label1352;
      localObject1 = null;
      paramView = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nfs
 * JD-Core Version:    0.7.0.1
 */