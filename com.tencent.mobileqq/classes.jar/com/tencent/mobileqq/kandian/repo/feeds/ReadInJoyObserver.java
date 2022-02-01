package com.tencent.mobileqq.kandian.repo.feeds;

import android.content.res.Configuration;
import android.util.SparseArray;
import android.view.View;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.kandian.repo.comment.CommentReportInfo;
import com.tencent.mobileqq.kandian.repo.comment.entity.DiandianTopConfig;
import com.tencent.mobileqq.kandian.repo.diandian.IEntranceButtonDataSource;
import com.tencent.mobileqq.kandian.repo.feeds.api.IInsertArticleCallback;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ChannelBannerInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ChannelCoverInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ChannelInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.FastWebArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.PositionData;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SubscriptionFeed;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TabChannelCoverInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TopBannerInfo;
import com.tencent.mobileqq.kandian.repo.follow.FollowingMember;
import com.tencent.mobileqq.kandian.repo.follow.RecommendFollowInfo;
import com.tencent.mobileqq.kandian.repo.handler.TagInfo;
import com.tencent.mobileqq.kandian.repo.handler.TopicInfo;
import com.tencent.mobileqq.kandian.repo.reward.UserCoinInfo;
import com.tencent.mobileqq.kandian.repo.share.KingMomentInfo;
import com.tencent.widget.AbsListView;
import java.util.ArrayList;
import java.util.List;
import tencent.im.oidb.cmd0xbd6.oidb_cmd0xbd6.RspBody;
import tencent.im.oidb.cmd0xe7e.oidb_cmd0xe7e.ModuleInfo;
import tencent.im.oidb.cmd0xe7e.oidb_cmd0xe7e.TextCardInfo;
import tencent.im.oidb.cmd0xef9.oidb_cmd0xef9.PrivilegeRspBody;

public class ReadInJoyObserver
  implements BusinessObserver
{
  public void a(float paramFloat, int paramInt) {}
  
  public void a(int paramInt) {}
  
  public void a(int paramInt1, int paramInt2, int paramInt3) {}
  
  public void a(int paramInt1, int paramInt2, Object paramObject) {}
  
  public void a(int paramInt, long paramLong, String paramString) {}
  
  public void a(int paramInt1, long paramLong, String paramString1, int paramInt2, String paramString2, String paramString3) {}
  
  public void a(int paramInt1, long paramLong, List<Long> paramList, int paramInt2, int paramInt3, boolean paramBoolean) {}
  
  public void a(int paramInt, AbsBaseArticleInfo paramAbsBaseArticleInfo, String paramString1, String paramString2) {}
  
  public void a(int paramInt, PositionData paramPositionData) {}
  
  public void a(int paramInt, KingMomentInfo paramKingMomentInfo) {}
  
  public void a(int paramInt, Object paramObject) {}
  
  public void a(int paramInt, String paramString, List<AbsBaseArticleInfo> paramList, IInsertArticleCallback paramIInsertArticleCallback) {}
  
  public void a(int paramInt, List<Long> paramList) {}
  
  public void a(int paramInt, boolean paramBoolean, List<ChannelCoverInfo> paramList) {}
  
  public void a(int paramInt, boolean paramBoolean, Object... paramVarArgs) {}
  
  public void a(long paramLong, int paramInt, String paramString) {}
  
  public void a(long paramLong, boolean paramBoolean) {}
  
  public void a(Configuration paramConfiguration) {}
  
  public void a(View paramView) {}
  
  public void a(View paramView, AbsBaseArticleInfo paramAbsBaseArticleInfo, FastWebArticleInfo paramFastWebArticleInfo, int paramInt) {}
  
  public void a(IEntranceButtonDataSource paramIEntranceButtonDataSource) {}
  
  public void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, FastWebArticleInfo paramFastWebArticleInfo) {}
  
  public void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, FastWebArticleInfo paramFastWebArticleInfo, int paramInt) {}
  
  public void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, boolean paramBoolean) {}
  
  public void a(TabChannelCoverInfo paramTabChannelCoverInfo) {}
  
  public void a(TopBannerInfo paramTopBannerInfo) {}
  
  public void a(AbsListView paramAbsListView) {}
  
  public void a(Long paramLong) {}
  
  public void a(Object paramObject, int paramInt, boolean paramBoolean, String... paramVarArgs) {}
  
  public void a(String paramString) {}
  
  public void a(String paramString, int paramInt) {}
  
  public void a(String paramString, int paramInt1, int paramInt2) {}
  
  public void a(String paramString1, int paramInt1, long paramLong, String paramString2, int paramInt2, String paramString3, String paramString4) {}
  
  public void a(String paramString1, int paramInt, oidb_cmd0xbd6.RspBody paramRspBody, String paramString2) {}
  
  public void a(String paramString1, String paramString2, int paramInt) {}
  
  public void a(ArrayList<String> paramArrayList) {}
  
  public void a(List<oidb_cmd0xe7e.ModuleInfo> paramList, List<oidb_cmd0xe7e.TextCardInfo> paramList1) {}
  
  public void a(oidb_cmd0xef9.PrivilegeRspBody paramPrivilegeRspBody, long paramLong, int paramInt) {}
  
  public void a(boolean paramBoolean) {}
  
  public void a(boolean paramBoolean, int paramInt, long paramLong, List<Long> paramList, List<AbsBaseArticleInfo> paramList1) {}
  
  public void a(boolean paramBoolean, int paramInt, SparseArray<ChannelInfo> paramSparseArray) {}
  
  public void a(boolean paramBoolean, int paramInt, String paramString) {}
  
  public void a(boolean paramBoolean, int paramInt, String paramString, CommentReportInfo paramCommentReportInfo) {}
  
  public void a(boolean paramBoolean, int paramInt, String paramString, UserCoinInfo paramUserCoinInfo) {}
  
  public void a(boolean paramBoolean, int paramInt1, String paramString1, String paramString2, int paramInt2) {}
  
  public void a(boolean paramBoolean1, int paramInt, String paramString1, String paramString2, boolean paramBoolean2) {}
  
  public void a(boolean paramBoolean1, int paramInt, List<Long> paramList, boolean paramBoolean2) {}
  
  public void a(boolean paramBoolean, long paramLong, List<RecommendFollowInfo> paramList) {}
  
  public void a(boolean paramBoolean, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2) {}
  
  public void a(boolean paramBoolean, String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, int paramInt2, String paramString5) {}
  
  public void a(boolean paramBoolean, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt) {}
  
  public void a(boolean paramBoolean, List<ChannelInfo> paramList) {}
  
  public void a(boolean paramBoolean1, List<FollowingMember> paramList, long paramLong, boolean paramBoolean2) {}
  
  public void a(boolean paramBoolean, List<Long> paramList, List<AbsBaseArticleInfo> paramList1) {}
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt) {}
  
  public void aE_() {}
  
  public void aF_() {}
  
  public void a_(AbsBaseArticleInfo paramAbsBaseArticleInfo) {}
  
  public void a_(List<SubscriptionFeed> paramList) {}
  
  public void a_(boolean paramBoolean, String paramString) {}
  
  public void aq_() {}
  
  public void ar_() {}
  
  public void as_() {}
  
  public void b(int paramInt, List<Long> paramList) {}
  
  public void b(long paramLong, boolean paramBoolean) {}
  
  public void b(String paramString, int paramInt) {}
  
  public void b(List<TagInfo> paramList) {}
  
  public void b(List<String> paramList, List<TopicInfo> paramList1) {}
  
  public void b(boolean paramBoolean) {}
  
  public void b(boolean paramBoolean1, int paramInt, List<Long> paramList, boolean paramBoolean2) {}
  
  public void b(boolean paramBoolean, List<ChannelCoverInfo> paramList) {}
  
  public void b(boolean paramBoolean1, List<FollowingMember> paramList, long paramLong, boolean paramBoolean2) {}
  
  public void b_(int paramInt1, int paramInt2) {}
  
  public void c() {}
  
  public void c(int paramInt) {}
  
  public void c(int paramInt, List<Long> paramList) {}
  
  public void c(String paramString, int paramInt) {}
  
  public void c(boolean paramBoolean, List<ChannelCoverInfo> paramList) {}
  
  public void c(boolean paramBoolean1, List<FollowingMember> paramList, long paramLong, boolean paramBoolean2) {}
  
  public void d(int paramInt) {}
  
  public void d(int paramInt, List<ChannelBannerInfo> paramList) {}
  
  public void d(String paramString) {}
  
  public void d(boolean paramBoolean, List<DiandianTopConfig> paramList) {}
  
  public void d_(String paramString) {}
  
  public void e() {}
  
  public void e(int paramInt) {}
  
  public void e(boolean paramBoolean, List<TabChannelCoverInfo> paramList) {}
  
  public void e_(String paramString) {}
  
  public void f(int paramInt) {}
  
  public void f(boolean paramBoolean, List<ChannelInfo> paramList) {}
  
  public void g() {}
  
  public void g(int paramInt) {}
  
  public void g(boolean paramBoolean, List<Integer> paramList) {}
  
  public void h() {}
  
  public void h(boolean paramBoolean, List<ChannelCoverInfo> paramList) {}
  
  public void i() {}
  
  public void j_(int paramInt) {}
  
  public void k() {}
  
  public void l() {}
  
  public void o() {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt == 1)
    {
      if (paramObject == null) {
        return;
      }
      if (paramBoolean)
      {
        paramObject = (Object[])paramObject;
        if (paramObject.length >= 2) {
          a(true, ((Boolean)paramObject[0]).booleanValue(), ((Integer)paramObject[1]).intValue());
        }
      }
      else
      {
        a(false, false, -1);
      }
    }
  }
  
  public void p() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyObserver
 * JD-Core Version:    0.7.0.1
 */