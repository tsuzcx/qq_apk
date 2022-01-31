import android.content.Context;
import android.view.View;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.QQStoryWatcherListActivity;
import com.tencent.biz.qqstory.shareGroup.model.ShareGroupItem;
import com.tencent.biz.qqstory.storyHome.detail.view.StoryDetailActivity;
import com.tencent.biz.qqstory.storyHome.model.BannerFeedItem;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class szz
  extends tax
{
  szz(szy paramszy) {}
  
  public void onClick(View paramView)
  {
    Object localObject1;
    label781:
    label1117:
    List localList;
    Object localObject3;
    Object localObject2;
    switch (paramView.getId())
    {
    default: 
    case 2131370359: 
    case 2131370357: 
    case 2131373268: 
    case 2131364471: 
    case 2131370360: 
      int i;
      do
      {
        return;
        if (!bbfj.d(this.a.jdField_a_of_type_AndroidContentContext))
        {
          bcql.a(BaseApplication.getContext(), 1, ajya.a(2131704410), 0).a();
          return;
        }
        if ((this.a.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem != null) && (this.a.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem.type == 2))
        {
          if (uke.a(this.a.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem)) {
            bcql.a(this.a.jdField_a_of_type_AndroidContentContext, 1, ajya.a(2131704430), 1).a();
          }
        }
        else if ((this.a.jdField_a_of_type_Uvh != null) && (uke.a()))
        {
          i = this.a.jdField_a_of_type_Uvh.a().type;
          if ((i == 3) || (i == 5))
          {
            bcql.a(this.a.jdField_a_of_type_AndroidContentContext, 1, ajya.a(2131704401), 1).a();
            return;
          }
        }
        this.a.e();
        return;
        if (!bbfj.d(this.a.jdField_a_of_type_AndroidContentContext))
        {
          bcql.a(BaseApplication.getContext(), 1, ajya.a(2131704424), 0).a();
          return;
        }
        if (this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.isFakeFeedItem())
        {
          bcql.a(BaseApplication.getContext(), 1, ajya.a(2131704408), 0).a();
          return;
        }
        if ((this.a.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem != null) && (this.a.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem.type == 2))
        {
          if (uke.a(this.a.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem)) {
            bcql.a(this.a.jdField_a_of_type_AndroidContentContext, 1, ajya.a(2131704415), 1).a();
          }
        }
        else if ((this.a.jdField_a_of_type_Uvh != null) && (uke.a()))
        {
          i = this.a.jdField_a_of_type_Uvh.a().type;
          if ((i == 3) || (i == 5))
          {
            bcql.a(this.a.jdField_a_of_type_AndroidContentContext, 1, ajya.a(2131704425), 1).a();
            return;
          }
        }
        i = vei.b(this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem);
        if ((this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner() instanceof ShareGroupItem)) {}
        for (localObject1 = this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner().getUnionId();; localObject1 = "")
        {
          vei.a("home_page", "clk_reply", vei.a(this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem), 0, new String[] { String.valueOf(i), vei.a(this.a.jdField_a_of_type_Int), this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId, localObject1 });
          if (this.a.jdField_a_of_type_Szo == null) {
            break;
          }
          localObject1 = (szs)this.a.a("commentLego");
          this.a.jdField_a_of_type_Szo.a((szs)localObject1, paramView, this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId);
          return;
        }
        if (szy.a(this.a) != null)
        {
          if ((this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner() instanceof QQUserUIItem))
          {
            paramView = (QQUserUIItem)this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner();
            szy.a(this.a).a(Long.parseLong(paramView.qq), this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.ownerId, this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem);
          }
        }
        else
        {
          i = vei.b(this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem);
          if (!(this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner() instanceof ShareGroupItem)) {
            break label781;
          }
        }
        for (paramView = this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner().getUnionId();; paramView = "")
        {
          vei.a("home_page", "clk_play", vei.a(this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem), 0, new String[] { String.valueOf(i), vei.a(this.a.jdField_a_of_type_Int), this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId, paramView });
          return;
          szy.a(this.a).a(0L, this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.ownerId, this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem);
          break;
        }
        if (this.a.jdField_a_of_type_Int == 11) {
          i = 211;
        }
        for (;;)
        {
          StoryDetailActivity.a(this.a.jdField_a_of_type_AndroidAppActivity, this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId, i, 0);
          vei.a("home_page", "clk_reply_mini", vei.a(this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem), 0, new String[] { String.valueOf(vei.b(this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem)), vei.a(this.a.jdField_a_of_type_Int), "", this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId });
          return;
          if (this.a.jdField_a_of_type_Int == 12) {
            i = 222;
          } else {
            i = 210;
          }
        }
        if (!bbfj.d(this.a.jdField_a_of_type_AndroidContentContext))
        {
          bcql.a(BaseApplication.getContext(), 1, ajya.a(2131704409), 0).a();
          return;
        }
      } while (vzl.b());
      if ((this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner() instanceof ShareGroupItem)) {}
      for (paramView = this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner().getUnionId();; paramView = "")
      {
        vei.a("home_page", "clk_share", vei.a(this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem), 0, new String[] { vei.b(this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem) + "", vei.a(this.a.jdField_a_of_type_Int), this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId, paramView });
        if ((this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem != null) && (this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner() != null)) {
          break label1117;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("FeedCommentLikeLego", 2, "can't share, commentLikeFeedItem not ready");
        return;
      }
      if (this.a.jdField_a_of_type_Uvg != null)
      {
        if (szy.a(this.a) == null) {
          szy.a(this.a, tpb.a(this.a.jdField_a_of_type_AndroidAppActivity));
        }
        szy.a(this.a).a(this.a.jdField_a_of_type_AndroidContentContext.getString(2131719508)).a(new taa(this)).a(new tqa((BannerFeedItem)this.a.jdField_a_of_type_Uvg.a())).b();
        return;
      }
      localObject1 = null;
      paramView = null;
      localList = this.a.jdField_a_of_type_Uvh.a();
      if (!localList.isEmpty())
      {
        Iterator localIterator = localList.iterator();
        if (localIterator.hasNext())
        {
          localObject3 = (StoryVideoItem)localIterator.next();
          if (StoryVideoItem.isFakeVid(((StoryVideoItem)localObject3).mVid)) {
            break label1909;
          }
          localObject2 = paramView;
          if (paramView == null)
          {
            if (!vxy.c(((StoryVideoItem)localObject3).mCreateTime)) {
              break label1396;
            }
            i = localList.size() - 1;
            label1313:
            if (i < 0) {
              break label1906;
            }
            localObject2 = (StoryVideoItem)localList.get(i);
            if (StoryVideoItem.isFakeVid(((StoryVideoItem)localObject2).mVid)) {
              break label1389;
            }
            paramView = (View)localObject2;
          }
          label1344:
          label1360:
          label1376:
          label1389:
          label1396:
          for (localObject2 = paramView;; localObject2 = localObject3)
          {
            if (localObject1 != null) {
              break label1900;
            }
            paramView = new ArrayList();
            paramView.add(((StoryVideoItem)localObject3).mVid);
            localObject1 = localObject2;
            localObject2 = localObject1;
            localObject1 = paramView;
            paramView = (View)localObject2;
            break;
            i -= 1;
            break label1313;
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
        bcql.a(BaseApplication.getContext(), 1, ajya.a(2131704438), 0).a();
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
        if (szy.a(this.a) == null) {
          szy.a(this.a, tpb.a(this.a.jdField_a_of_type_AndroidAppActivity));
        }
        localObject3 = szy.a(this.a);
        if (bool3)
        {
          localObject2 = ajya.a(2131704435);
          localObject1 = ((tpb)localObject3).a((String)localObject2).a(new tab(this)).a(tqe.a(this.a.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem, paramView, this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId, paramView.mCreateTime, ((List)localObject1).size()));
          if (!bool1) {
            break label1692;
          }
          paramView = "1";
          label1613:
          localObject1 = ((tpb)localObject1).a("vote", paramView);
          if (!bool2) {
            break label1699;
          }
        }
        label1692:
        label1699:
        for (paramView = "1";; paramView = "0")
        {
          ((tpb)localObject1).a("grade", paramView).b();
          vei.a("share_story", "share_day", 0, 0, new String[] { this.a.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem.getReportUserType() });
          return;
          localObject2 = this.a.jdField_a_of_type_AndroidContentContext.getString(2131719508);
          break;
          paramView = "0";
          break label1613;
        }
      }
      if (szy.a(this.a) == null) {
        szy.a(this.a, tpb.a(this.a.jdField_a_of_type_AndroidAppActivity));
      }
      localObject3 = szy.a(this.a);
      if (bool3)
      {
        localObject2 = ajya.a(2131704419);
        localObject1 = ((tpb)localObject3).a((String)localObject2).a(new tac(this)).a(new tqb(paramView, this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId, ((List)localObject1).size()));
        if (!bool1) {
          break label1863;
        }
        paramView = "1";
        label1812:
        localObject1 = ((tpb)localObject1).a("vote", paramView);
        if (!bool2) {
          break label1870;
        }
      }
      label1863:
      label1870:
      for (paramView = "1";; paramView = "0")
      {
        ((tpb)localObject1).a("grade", paramView).b();
        return;
        localObject2 = this.a.jdField_a_of_type_AndroidContentContext.getString(2131719508);
        break;
        paramView = "0";
        break label1812;
      }
      QQStoryWatcherListActivity.a(this.a.jdField_a_of_type_AndroidAppActivity, this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId, 10);
      return;
      label1900:
      paramView = (View)localObject1;
      break label1360;
      label1906:
      break label1344;
      label1909:
      localObject2 = localObject1;
      localObject1 = paramView;
      paramView = (View)localObject2;
      break label1376;
      localObject1 = null;
      paramView = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     szz
 * JD-Core Version:    0.7.0.1
 */