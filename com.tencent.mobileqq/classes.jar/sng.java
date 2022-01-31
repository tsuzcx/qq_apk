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

class sng
  extends soe
{
  sng(snf paramsnf) {}
  
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
    case 2131304703: 
    case 2131304701: 
    case 2131307553: 
    case 2131298912: 
    case 2131304704: 
      int i;
      do
      {
        return;
        if (!badq.d(this.a.jdField_a_of_type_AndroidContentContext))
        {
          bbmy.a(BaseApplication.getContext(), 1, ajjy.a(2131638614), 0).a();
          return;
        }
        if ((this.a.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem != null) && (this.a.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem.type == 2))
        {
          if (txl.a(this.a.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem)) {
            bbmy.a(this.a.jdField_a_of_type_AndroidContentContext, 1, ajjy.a(2131638634), 1).a();
          }
        }
        else if ((this.a.jdField_a_of_type_Uio != null) && (txl.a()))
        {
          i = this.a.jdField_a_of_type_Uio.a().type;
          if ((i == 3) || (i == 5))
          {
            bbmy.a(this.a.jdField_a_of_type_AndroidContentContext, 1, ajjy.a(2131638605), 1).a();
            return;
          }
        }
        this.a.e();
        return;
        if (!badq.d(this.a.jdField_a_of_type_AndroidContentContext))
        {
          bbmy.a(BaseApplication.getContext(), 1, ajjy.a(2131638628), 0).a();
          return;
        }
        if (this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.isFakeFeedItem())
        {
          bbmy.a(BaseApplication.getContext(), 1, ajjy.a(2131638612), 0).a();
          return;
        }
        if ((this.a.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem != null) && (this.a.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem.type == 2))
        {
          if (txl.a(this.a.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem)) {
            bbmy.a(this.a.jdField_a_of_type_AndroidContentContext, 1, ajjy.a(2131638619), 1).a();
          }
        }
        else if ((this.a.jdField_a_of_type_Uio != null) && (txl.a()))
        {
          i = this.a.jdField_a_of_type_Uio.a().type;
          if ((i == 3) || (i == 5))
          {
            bbmy.a(this.a.jdField_a_of_type_AndroidContentContext, 1, ajjy.a(2131638629), 1).a();
            return;
          }
        }
        i = urp.b(this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem);
        if ((this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner() instanceof ShareGroupItem)) {}
        for (localObject1 = this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner().getUnionId();; localObject1 = "")
        {
          urp.a("home_page", "clk_reply", urp.a(this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem), 0, new String[] { String.valueOf(i), urp.a(this.a.jdField_a_of_type_Int), this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId, localObject1 });
          if (this.a.jdField_a_of_type_Smv == null) {
            break;
          }
          localObject1 = (smz)this.a.a("commentLego");
          this.a.jdField_a_of_type_Smv.a((smz)localObject1, paramView, this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId);
          return;
        }
        if (snf.a(this.a) != null)
        {
          if ((this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner() instanceof QQUserUIItem))
          {
            paramView = (QQUserUIItem)this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner();
            snf.a(this.a).a(Long.parseLong(paramView.qq), this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.ownerId, this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem);
          }
        }
        else
        {
          i = urp.b(this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem);
          if (!(this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner() instanceof ShareGroupItem)) {
            break label781;
          }
        }
        for (paramView = this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner().getUnionId();; paramView = "")
        {
          urp.a("home_page", "clk_play", urp.a(this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem), 0, new String[] { String.valueOf(i), urp.a(this.a.jdField_a_of_type_Int), this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId, paramView });
          return;
          snf.a(this.a).a(0L, this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.ownerId, this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem);
          break;
        }
        if (this.a.jdField_a_of_type_Int == 11) {
          i = 211;
        }
        for (;;)
        {
          StoryDetailActivity.a(this.a.jdField_a_of_type_AndroidAppActivity, this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId, i, 0);
          urp.a("home_page", "clk_reply_mini", urp.a(this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem), 0, new String[] { String.valueOf(urp.b(this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem)), urp.a(this.a.jdField_a_of_type_Int), "", this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId });
          return;
          if (this.a.jdField_a_of_type_Int == 12) {
            i = 222;
          } else {
            i = 210;
          }
        }
        if (!badq.d(this.a.jdField_a_of_type_AndroidContentContext))
        {
          bbmy.a(BaseApplication.getContext(), 1, ajjy.a(2131638613), 0).a();
          return;
        }
      } while (vms.b());
      if ((this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner() instanceof ShareGroupItem)) {}
      for (paramView = this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner().getUnionId();; paramView = "")
      {
        urp.a("home_page", "clk_share", urp.a(this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem), 0, new String[] { urp.b(this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem) + "", urp.a(this.a.jdField_a_of_type_Int), this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId, paramView });
        if ((this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem != null) && (this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner() != null)) {
          break label1117;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("FeedCommentLikeLego", 2, "can't share, commentLikeFeedItem not ready");
        return;
      }
      if (this.a.jdField_a_of_type_Uin != null)
      {
        if (snf.a(this.a) == null) {
          snf.a(this.a, tci.a(this.a.jdField_a_of_type_AndroidAppActivity));
        }
        snf.a(this.a).a(this.a.jdField_a_of_type_AndroidContentContext.getString(2131653614)).a(new snh(this)).a(new tdh((BannerFeedItem)this.a.jdField_a_of_type_Uin.a())).b();
        return;
      }
      localObject1 = null;
      paramView = null;
      localList = this.a.jdField_a_of_type_Uio.a();
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
            if (!vlf.c(((StoryVideoItem)localObject3).mCreateTime)) {
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
        bbmy.a(BaseApplication.getContext(), 1, ajjy.a(2131638642), 0).a();
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
        if (snf.a(this.a) == null) {
          snf.a(this.a, tci.a(this.a.jdField_a_of_type_AndroidAppActivity));
        }
        localObject3 = snf.a(this.a);
        if (bool3)
        {
          localObject2 = ajjy.a(2131638639);
          localObject1 = ((tci)localObject3).a((String)localObject2).a(new sni(this)).a(tdl.a(this.a.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem, paramView, this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId, paramView.mCreateTime, ((List)localObject1).size()));
          if (!bool1) {
            break label1692;
          }
          paramView = "1";
          label1613:
          localObject1 = ((tci)localObject1).a("vote", paramView);
          if (!bool2) {
            break label1699;
          }
        }
        label1692:
        label1699:
        for (paramView = "1";; paramView = "0")
        {
          ((tci)localObject1).a("grade", paramView).b();
          urp.a("share_story", "share_day", 0, 0, new String[] { this.a.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem.getReportUserType() });
          return;
          localObject2 = this.a.jdField_a_of_type_AndroidContentContext.getString(2131653614);
          break;
          paramView = "0";
          break label1613;
        }
      }
      if (snf.a(this.a) == null) {
        snf.a(this.a, tci.a(this.a.jdField_a_of_type_AndroidAppActivity));
      }
      localObject3 = snf.a(this.a);
      if (bool3)
      {
        localObject2 = ajjy.a(2131638623);
        localObject1 = ((tci)localObject3).a((String)localObject2).a(new snj(this)).a(new tdi(paramView, this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId, ((List)localObject1).size()));
        if (!bool1) {
          break label1863;
        }
        paramView = "1";
        label1812:
        localObject1 = ((tci)localObject1).a("vote", paramView);
        if (!bool2) {
          break label1870;
        }
      }
      label1863:
      label1870:
      for (paramView = "1";; paramView = "0")
      {
        ((tci)localObject1).a("grade", paramView).b();
        return;
        localObject2 = this.a.jdField_a_of_type_AndroidContentContext.getString(2131653614);
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
 * Qualified Name:     sng
 * JD-Core Version:    0.7.0.1
 */