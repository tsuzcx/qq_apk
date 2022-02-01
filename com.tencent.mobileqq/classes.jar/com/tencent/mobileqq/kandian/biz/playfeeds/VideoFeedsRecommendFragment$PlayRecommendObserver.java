package com.tencent.mobileqq.kandian.biz.playfeeds;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.tencent.biz.pubaccount.SoftAdExpoStatManager;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.ad.api.IRIJVideoAdService;
import com.tencent.mobileqq.kandian.ad.api.entity.IVideoAdExposureManager;
import com.tencent.mobileqq.kandian.ad.api.entity.IVideoAdTimeLoadManager;
import com.tencent.mobileqq.kandian.ad.api.entity.IVideoAdVVAdloadStrategyManager;
import com.tencent.mobileqq.kandian.ad.api.entity.IVideoFeedsGameAdComManager;
import com.tencent.mobileqq.kandian.ad.api.entity.IVideoFeedsSoftAdBarController;
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.mobileqq.kandian.base.utils.ValueJudgeUtil;
import com.tencent.mobileqq.kandian.base.view.widget.LifeCycleCallBack;
import com.tencent.mobileqq.kandian.biz.ad.entity.VideoAdInfo;
import com.tencent.mobileqq.kandian.biz.comment.data.ReadInJoyCommentDataManager;
import com.tencent.mobileqq.kandian.biz.video.column.VideoColumnDataManager;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo.AdTagInfo;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo.ECommerceEntranceInfo;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoPlayParam;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.view.VideoFeedsRecyclerView;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.viewholder.VideoItemHolder;
import com.tencent.mobileqq.kandian.glue.video.VideoFullPlayController;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

class VideoFeedsRecommendFragment$PlayRecommendObserver
  extends VideoPlayRecommendObserver
{
  private boolean b = false;
  
  public VideoFeedsRecommendFragment$PlayRecommendObserver(VideoFeedsRecommendFragment paramVideoFeedsRecommendFragment, boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  private void a()
  {
    VideoFeedsAdapter localVideoFeedsAdapter = VideoFeedsRecommendFragment.d(this.a);
    int i;
    if (VideoFeedsRecommendFragment.n(this.a)) {
      i = 3;
    } else {
      i = 2;
    }
    localVideoFeedsAdapter.f(i);
    if (VideoFeedsRecommendFragment.L(this.a)) {
      VideoFeedsRecommendFragment.d(this.a).b(false);
    }
    if (VideoFeedsRecommendFragment.e(this.a).size() > 0) {
      VideoFeedsRecommendFragment.d(this.a).a((VideoInfo)VideoFeedsRecommendFragment.e(this.a).get(0));
    }
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    paramInt1 = VideoFeedsRecommendFragment.e(this.a).size() - paramInt1;
    if (paramInt1 > 0)
    {
      if ((VideoFeedsRecommendFragment.c(this.a).getCurrentAdpaterPosition() >= 0) && (VideoFeedsRecommendFragment.c(this.a).getCurrentAdpaterPosition() == paramInt2))
      {
        VideoFeedsRecommendFragment.d(this.a).notifyItemChanged(paramInt2);
        int i = paramInt1 - 1;
        if (i > 0) {
          VideoFeedsRecommendFragment.d(this.a).notifyItemRangeInserted(paramInt2 + 1, i);
        }
        if (QLog.isColorLevel()) {
          QLog.d("VideoFeedsRecommendFragment", 2, "notifyItemChanged: ");
        }
      }
      else
      {
        VideoFeedsRecommendFragment.d(this.a).notifyItemRangeInserted(paramInt2, paramInt1);
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("notifyItemChanged: footerPosition=");
        localStringBuilder.append(paramInt2);
        localStringBuilder.append(", currentPosition=");
        localStringBuilder.append(VideoFeedsRecommendFragment.c(this.a).getCurrentAdpaterPosition());
        localStringBuilder.append(", newVideoSize=");
        localStringBuilder.append(paramInt1);
        QLog.d("VideoFeedsRecommendFragment", 2, localStringBuilder.toString());
      }
    }
    SoftAdExpoStatManager.a().b(paramInt1);
  }
  
  private void a(Bundle paramBundle)
  {
    if (paramBundle.getBoolean("VALUE_REQUEST_GAME_DATA", false))
    {
      c(paramBundle);
      return;
    }
    b(paramBundle);
  }
  
  private void a(Bundle paramBundle, int paramInt, VideoInfo paramVideoInfo)
  {
    for (;;)
    {
      try
      {
        if ((VideoFeedsRecommendFragment.w(this.a) != null) && (VideoFeedsRecommendFragment.h(this.a) != null) && (VideoFeedsRecommendFragment.h(this.a).t() != null))
        {
          ArrayList localArrayList1 = paramBundle.getParcelableArrayList("value_msg_kd_tag_info");
          paramInt = Math.max(paramInt - 1, 0);
          a(paramVideoInfo, localArrayList1);
          if ((localArrayList1 != null) && (!localArrayList1.isEmpty()))
          {
            paramBundle = localArrayList1.iterator();
            if (paramBundle.hasNext())
            {
              ((VideoInfo.AdTagInfo)paramBundle.next()).d = paramInt;
              paramInt += 1;
              continue;
            }
            long l2 = VideoFeedsRecommendFragment.x(this.a);
            paramBundle = VideoFeedsRecommendFragment.y(this.a);
            long l1 = l2;
            if (l2 == 0L)
            {
              l1 = l2;
              if (paramBundle != null) {
                try
                {
                  l1 = Long.parseLong(paramBundle.getCurrentAccountUin());
                }
                catch (Exception paramBundle)
                {
                  QLog.e("VideoFeedsRecommendFragment", 2, paramBundle, new Object[0]);
                  l1 = l2;
                }
              }
            }
            if ((VideoFeedsRecommendFragment.z(this.a) == null) || (VideoFeedsRecommendFragment.A(this.a) == null)) {
              break label492;
            }
            paramBundle = VideoFeedsRecommendFragment.z(this.a).a(VideoFeedsRecommendFragment.A(this.a).l);
            VideoFeedsRecommendFragment.d(this.a, true);
            paramVideoInfo = VideoFeedsRecommendFragment.w(this.a);
            PlayRecommendObserver localPlayRecommendObserver = VideoFeedsRecommendFragment.B(this.a);
            VideoInfo localVideoInfo = (VideoInfo)VideoFeedsRecommendFragment.e(this.a).get(0);
            int i = VideoFeedsRecommendFragment.C(this.a);
            ArrayList localArrayList2 = VideoFeedsRecommendFragment.e(this.a);
            String str1 = ((VideoInfo)VideoFeedsRecommendFragment.e(this.a).get(0)).o;
            l2 = VideoFeedsRecommendFragment.D(this.a);
            String str2 = VideoFeedsRecommendFragment.E(this.a);
            String str3 = VideoFeedsRecommendFragment.F(this.a);
            int j = VideoFeedsRecommendFragment.G(this.a);
            byte[] arrayOfByte = VideoFeedsRecommendFragment.H(this.a);
            int k = VideoFeedsRecommendFragment.h(this.a).b();
            int m = VideoFeedsRecommendFragment.h(this.a).c();
            ArrayList localArrayList3 = new ArrayList(VideoFeedsRecommendFragment.I(this.a));
            if (VideoFeedsRecommendFragment.g(this.a) == null) {
              paramInt = 0;
            } else {
              paramInt = VideoFeedsRecommendFragment.g(this.a).Z;
            }
            paramVideoInfo.a(localPlayRecommendObserver, l1, localVideoInfo, i, localArrayList2, str1, l2, true, 0, str2, str3, null, j, paramBundle, arrayOfByte, localArrayList1, k, m, 0, localArrayList3, paramInt);
            return;
          }
        }
      }
      catch (Exception paramBundle)
      {
        if (QLog.isColorLevel())
        {
          paramVideoInfo = new StringBuilder();
          paramVideoInfo.append("onGetRecommend: to get game ad info error,e=");
          paramVideoInfo.append(paramBundle.getMessage());
          QLog.d("VideoFeedsRecommendFragment", 2, paramVideoInfo.toString());
        }
      }
      return;
      label492:
      paramBundle = null;
    }
  }
  
  private void a(Bundle paramBundle, int paramInt, VideoInfo paramVideoInfo1, VideoInfo paramVideoInfo2)
  {
    if ((paramVideoInfo1 != null) && (!this.b) && (paramVideoInfo2 != null))
    {
      a(paramVideoInfo1, paramVideoInfo2, paramBundle);
      paramVideoInfo1.a(paramVideoInfo2);
      this.b = true;
      if ((paramInt == 1) && (VideoFeedsRecommendFragment.m(this.a) != null))
      {
        paramBundle = new StringBuilder();
        paramBundle.append(HardCodeUtil.a(2131913356));
        paramBundle.append(paramVideoInfo1.q());
        VideoFeedsPlayActivity.a(paramBundle.toString());
      }
      if (VideoFeedsRecommendFragment.u(this.a) != null) {
        VideoFeedsRecommendFragment.u(this.a).a(VideoFeedsRecommendFragment.e(this.a));
      }
      VideoFeedsDiversionHandler.a.a(paramVideoInfo1);
      VideoFeedsRecommendFragment.d(this.a).a(paramVideoInfo1);
      ThreadManager.excute(new VideoFeedsRecommendFragment.PlayRecommendObserver.1(this, paramVideoInfo1), 16, null, true);
      if (VideoFeedsRecommendFragment.v(this.a) != null) {
        VideoFeedsRecommendFragment.v(this.a).a(paramVideoInfo1);
      }
    }
  }
  
  private void a(@Nullable VideoInfo paramVideoInfo)
  {
    if ((paramVideoInfo != null) && (paramVideoInfo.aB != null)) {
      ReadInJoyCommentDataManager.a(paramVideoInfo.aB.innerUniqueID, paramVideoInfo.ad);
    }
  }
  
  private void a(VideoInfo paramVideoInfo1, VideoInfo paramVideoInfo2, Bundle paramBundle)
  {
    if ((!VideoFeedsRecommendFragment.L(this.a)) && (!TextUtils.isEmpty(paramVideoInfo1.g)))
    {
      paramVideoInfo2.g = paramVideoInfo1.g;
    }
    else
    {
      if ((TextUtils.isEmpty(paramVideoInfo2.g)) && (!TextUtils.isEmpty(paramVideoInfo1.g))) {
        paramVideoInfo2.g = paramVideoInfo1.g;
      }
      VideoFeedsRecommendFragment.d(this.a).b(false);
    }
    if ((paramVideoInfo1.ax != null) && (paramVideoInfo1.ax.size() > 0))
    {
      if (paramVideoInfo2.ax == null) {
        paramVideoInfo2.ax = new ArrayList();
      }
      paramVideoInfo2.ax.addAll(paramVideoInfo1.ax);
    }
    paramVideoInfo2.n = ValueJudgeUtil.a.a(paramVideoInfo2.n, paramVideoInfo1.n);
    if ((paramVideoInfo1.aQ != null) && (paramVideoInfo2.aQ == null))
    {
      paramVideoInfo2.aQ = paramVideoInfo1.aQ;
      paramVideoInfo2.a = paramVideoInfo1.a;
    }
    paramVideoInfo2.ai = paramVideoInfo1.ai;
    paramVideoInfo2.ah = paramVideoInfo1.ah;
    paramVideoInfo2.c = ValueJudgeUtil.a.a(paramVideoInfo2.c, paramVideoInfo1.c);
    paramVideoInfo2.d = ValueJudgeUtil.a.a(paramVideoInfo2.d, paramVideoInfo1.d);
    paramVideoInfo2.e = ValueJudgeUtil.a.a(paramVideoInfo2.e, paramVideoInfo1.e);
    paramVideoInfo2.aj = ValueJudgeUtil.a.a(paramVideoInfo2.aj, paramVideoInfo1.aj);
    paramVideoInfo2.ak = ValueJudgeUtil.a.a(paramVideoInfo2.ak, paramVideoInfo1.ak);
    paramVideoInfo2.o = paramVideoInfo1.o;
    paramVideoInfo2.r = ValueJudgeUtil.a.a(paramVideoInfo2.r, paramVideoInfo1.r);
    paramVideoInfo2.q = ValueJudgeUtil.a.a(paramVideoInfo2.q, paramVideoInfo1.q);
    paramVideoInfo2.l = ValueJudgeUtil.a.a(paramVideoInfo2.l, paramVideoInfo1.l);
    if ((TextUtils.isEmpty(paramVideoInfo2.b)) && (!TextUtils.isEmpty(paramVideoInfo1.b)))
    {
      paramVideoInfo2.b = paramVideoInfo1.b;
      paramVideoInfo2.a = paramVideoInfo1.a;
    }
    paramVideoInfo2.k = ValueJudgeUtil.a.a(paramVideoInfo2.k, paramVideoInfo1.k);
    paramVideoInfo2.h = ValueJudgeUtil.a.a(paramVideoInfo2.h, paramVideoInfo1.h);
    paramVideoInfo2.g = ValueJudgeUtil.a.a(paramVideoInfo2.g, paramVideoInfo1.g);
    paramVideoInfo2.B = ValueJudgeUtil.a.a(paramVideoInfo2.B, paramVideoInfo1.B);
    paramVideoInfo2.A = ValueJudgeUtil.a.a(paramVideoInfo2.A, paramVideoInfo1.A);
    paramVideoInfo2.D = ValueJudgeUtil.a.a(paramVideoInfo2.D, paramVideoInfo1.D);
    paramVideoInfo2.m = ValueJudgeUtil.a.a(paramVideoInfo2.m, paramVideoInfo1.m);
    if (!paramVideoInfo2.t) {
      paramVideoInfo2.al = paramVideoInfo1.al;
    }
    paramVideoInfo2.f = ValueJudgeUtil.a.a(paramVideoInfo1.f, paramVideoInfo2.f);
    if (VideoFeedsRecommendFragment.M(this.a) != null) {
      VideoFeedsRecommendFragment.M(this.a).a(paramVideoInfo2.aE);
    }
    paramVideoInfo1 = (VideoInfo.ECommerceEntranceInfo)paramBundle.getParcelable("VALUE_ECOMMERCE_ENTRANCE_INFO");
    if (VideoFeedsRecommendFragment.u(this.a) != null) {
      VideoFeedsRecommendFragment.u(this.a).a(paramVideoInfo1);
    }
    paramVideoInfo2.O = 0;
    VideoFeedsHelper.a(paramVideoInfo2);
    if (((Integer)RIJSPUtils.b("SP_VIDEOFEEDS_LOOP_PLAYCONFIG", Integer.valueOf(-1))).intValue() == -1)
    {
      paramVideoInfo1 = this.a;
      int i = ((Integer)RIJSPUtils.b("SP_VIDEOFEEDS_LOOP_PLAYCONFIG", Integer.valueOf(paramBundle.getInt("value_autoplay_mode")))).intValue();
      boolean bool = true;
      if (i == 1) {
        bool = false;
      }
      VideoFeedsRecommendFragment.e(paramVideoInfo1, bool);
      VideoFeedsRecommendFragment.O(this.a).f(VideoFeedsRecommendFragment.N(this.a));
    }
  }
  
  private void a(VideoInfo paramVideoInfo, ArrayList<VideoInfo.AdTagInfo> paramArrayList)
  {
    if (paramVideoInfo != null)
    {
      paramVideoInfo = paramVideoInfo.aC;
      if ((paramArrayList != null) && (paramVideoInfo != null) && (paramVideoInfo.c == 0)) {
        paramArrayList.add(0, paramVideoInfo);
      }
    }
  }
  
  private void a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("VideoPlayRecommendObserver() logRecommendVideoInfo");
    localStringBuilder.append(paramString);
    VideoFeedsPlayActivity.a(localStringBuilder.toString());
  }
  
  private void a(ArrayList<AdvertisementInfo> paramArrayList)
  {
    Iterator localIterator = VideoFeedsRecommendFragment.e(this.a).iterator();
    label120:
    while (localIterator.hasNext())
    {
      VideoInfo localVideoInfo = (VideoInfo)localIterator.next();
      if ((localVideoInfo.aC != null) && (paramArrayList != null))
      {
        String str = localVideoInfo.aC.a;
        int i = 0;
        for (;;)
        {
          if (i >= paramArrayList.size()) {
            break label120;
          }
          AdvertisementInfo localAdvertisementInfo = (AdvertisementInfo)paramArrayList.get(i);
          if (localAdvertisementInfo.mRowKey.equals(str))
          {
            ((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).setAdvertisementInfo(localVideoInfo, localAdvertisementInfo);
            VideoFeedsDiversionHandler.a.a(localVideoInfo);
            break;
          }
          i += 1;
        }
      }
    }
  }
  
  private void a(ArrayList<VideoInfo> paramArrayList, boolean paramBoolean)
  {
    int i;
    if (paramArrayList != null) {
      i = paramArrayList.size();
    } else {
      i = 0;
    }
    if ((1 == VideoFeedsRecommendFragment.e(this.a).size() - i) && (paramBoolean) && (VideoFeedsRecommendFragment.e(this.a).get(1) != null))
    {
      paramArrayList = (VideoInfo)VideoFeedsRecommendFragment.e(this.a).get(1);
      VideoFeedsRecommendFragment.a(this.a, paramArrayList);
    }
  }
  
  private boolean a(List<VideoInfo> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    boolean bool = false;
    if (paramList == null)
    {
      a("articleList为空");
      return false;
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("articleList.size()=: ");
    ((StringBuilder)localObject1).append(paramList.size());
    a(((StringBuilder)localObject1).toString());
    localObject1 = paramList.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      VideoInfo localVideoInfo = (VideoInfo)((Iterator)localObject1).next();
      Object localObject2;
      if (localVideoInfo.aq)
      {
        VideoFeedsRecommendFragment.e(this.a).add(localVideoInfo);
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("info.adType=");
        ((StringBuilder)localObject2).append(localVideoInfo.ar);
        ((StringBuilder)localObject2).append(", info.title=");
        ((StringBuilder)localObject2).append(localVideoInfo.g);
        ((StringBuilder)localObject2).append(", adInfo.aid=");
        ((StringBuilder)localObject2).append(localVideoInfo.as.G);
        ((StringBuilder)localObject2).append(", adInfo.traceid=");
        ((StringBuilder)localObject2).append(localVideoInfo.as.m);
        ((StringBuilder)localObject2).append(" add to videoDataList");
        a(((StringBuilder)localObject2).toString());
      }
      else
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(localVideoInfo.b);
        ((StringBuilder)localObject2).append(" ");
        ((StringBuilder)localObject2).append(localVideoInfo.l);
        localObject2 = ((StringBuilder)localObject2).toString();
        if (VideoFeedsRecommendFragment.P(this.a).contains(localObject2))
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("info.vid=");
          ((StringBuilder)localObject2).append(localVideoInfo.b);
          ((StringBuilder)localObject2).append(", info.title=");
          ((StringBuilder)localObject2).append(localVideoInfo.g);
          ((StringBuilder)localObject2).append(", info.articleID=");
          ((StringBuilder)localObject2).append(localVideoInfo.l);
          ((StringBuilder)localObject2).append(" has exist");
          a(((StringBuilder)localObject2).toString());
          continue;
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("info.vid=");
        localStringBuilder.append(localVideoInfo.b);
        localStringBuilder.append(", info.title=");
        localStringBuilder.append(localVideoInfo.g);
        localStringBuilder.append(", info.articleID=");
        localStringBuilder.append(localVideoInfo.l);
        localStringBuilder.append(" add to videoDataList");
        a(localStringBuilder.toString());
        if ((localVideoInfo.t) && (TextUtils.isEmpty(localVideoInfo.r))) {
          localVideoInfo.r = ContactUtils.a(VideoFeedsRecommendFragment.y(this.a), localVideoInfo.q, true);
        }
        VideoFeedsHelper.a(localVideoInfo);
        localVideoInfo.O = VideoFeedsRecommendFragment.G(this.a);
        localArrayList.add(localVideoInfo.l);
        VideoFeedsRecommendFragment.e(this.a).add(localVideoInfo);
        VideoFeedsRecommendFragment.P(this.a).add(localObject2);
        a(localVideoInfo);
      }
      bool = true;
    }
    if (VideoFeedsRecommendFragment.u(this.a) != null) {
      VideoFeedsRecommendFragment.u(this.a).a(VideoFeedsRecommendFragment.e(this.a));
    }
    VideoFeedsRecommendFragment.a(this.a, paramList);
    VideoFeedsRecommendFragment.b(this.a, paramList);
    paramList = new StringBuilder();
    paramList.append("hasNewVideo = ");
    paramList.append(bool);
    a(paramList.toString());
    return bool;
  }
  
  private void b(Bundle paramBundle)
  {
    int i = VideoFeedsRecommendFragment.e(this.a).size();
    if (i == 1) {
      SoftAdExpoStatManager.a().a(-1);
    }
    ArrayList localArrayList = paramBundle.getParcelableArrayList("VIDEO_RECOMMEND_LIST");
    String str = paramBundle.getString("VALUE_REQUEST_VIDEO_ARTICLE_ID");
    Object localObject = this.a;
    VideoInfo localVideoInfo = null;
    VideoFeedsRecommendFragment.a((VideoFeedsRecommendFragment)localObject, paramBundle.getString("VALUE_COOKIE", null));
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("VideoPlayRecommendObserver() reqArticleID = ");
    ((StringBuilder)localObject).append(str);
    ((StringBuilder)localObject).append(", mLastRequestArticleID = ");
    ((StringBuilder)localObject).append(VideoFeedsRecommendFragment.p(this.a));
    VideoFeedsPlayActivity.a(((StringBuilder)localObject).toString());
    if (VideoFeedsRecommendFragment.e(this.a).size() > 0) {
      localVideoInfo = (VideoInfo)VideoFeedsRecommendFragment.e(this.a).get(0);
    }
    localObject = (VideoInfo)paramBundle.getParcelable("VALUE_REQUEST_VIDEO_DETAIL_INFO");
    a((VideoInfo)localObject);
    a(paramBundle, i, localVideoInfo, (VideoInfo)localObject);
    boolean bool = a(localArrayList);
    a(localArrayList, bool);
    VideoFeedsRecommendFragment.d(this.a).f(3);
    if ((!VideoFeedsRecommendFragment.k(this.a)) && (i == 1) && (bool)) {
      VideoFeedsRecommendFragment.q(this.a);
    }
    VideoFeedsRecommendFragment.b(this.a, str);
    int j = VideoFeedsRecommendFragment.e(this.a).size();
    if (VideoFeedsRecommendFragment.r(this.a) != null) {
      VideoFeedsRecommendFragment.r(this.a).a(bool, j - i, VideoFeedsRecommendFragment.e(this.a));
    }
    if (VideoFeedsRecommendFragment.s(this.a) != null) {
      VideoFeedsRecommendFragment.s(this.a).a();
    }
    if ((((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).isNotTimeStrategy()) && (((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).isNotMixStrategy()) && (VideoFeedsRecommendFragment.t(this.a) != null)) {
      VideoFeedsRecommendFragment.t(this.a).e();
    }
    a(i, i);
    a(paramBundle, i, (VideoInfo)localObject);
  }
  
  private void c(Bundle paramBundle)
  {
    paramBundle = paramBundle.getParcelableArrayList("value_msg_game_ad_info");
    if ((paramBundle != null) && (!paramBundle.isEmpty()))
    {
      a(paramBundle);
      if ((VideoFeedsRecommendFragment.g(this.a) != null) && (VideoFeedsRecommendFragment.g(this.a).az != null) && (VideoFeedsRecommendFragment.g(this.a).az.c != null))
      {
        if (VideoFeedsRecommendFragment.h(this.a) != null) {
          VideoFeedsRecommendFragment.h(this.a).a(VideoFeedsRecommendFragment.g(this.a), VideoFeedsRecommendFragment.J(this.a));
        }
        if (VideoFeedsRecommendFragment.K(this.a) != null) {
          VideoFeedsRecommendFragment.K(this.a).a(VideoFeedsRecommendFragment.g(this.a), VideoFeedsRecommendFragment.J(this.a), 0.0D, 0L);
        }
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("VideoFeedsRecommendFragment", 2, "get gameAdComData isEmpty");
    }
  }
  
  protected void a(boolean paramBoolean, Bundle paramBundle)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(HardCodeUtil.a(2131913418));
    ((StringBuilder)localObject).append("isSuccess = ");
    ((StringBuilder)localObject).append(paramBoolean);
    VideoFeedsPlayActivity.a(((StringBuilder)localObject).toString());
    VideoFeedsRecommendFragment.b(this.a, paramBundle.getBoolean("VALUE_USER_IN_BLACK", false));
    localObject = this.a;
    if ((!VideoFeedsRecommendFragment.k((VideoFeedsRecommendFragment)localObject)) && (!VideoFeedsRecommendFragment.n(this.a))) {
      bool = false;
    } else {
      bool = true;
    }
    VideoFeedsRecommendFragment.c((VideoFeedsRecommendFragment)localObject, bool);
    boolean bool = paramBundle.getBoolean("VALUE_REQUEST_GAME_DATA", false);
    if (paramBoolean) {
      a(paramBundle);
    } else {
      a();
    }
    if (!bool) {
      VideoFeedsRecommendFragment.o(this.a);
    }
    if ((!VideoFeedsRecommendFragment.k(this.a)) && (!VideoFeedsRecommendFragment.n(this.a)))
    {
      if ((VideoFeedsRecommendFragment.f(this.a) != null) && (VideoFeedsRecommendFragment.f(this.a).k())) {
        VideoFeedsRecommendFragment.c(this.a).setScrollable(false);
      } else {
        VideoFeedsRecommendFragment.c(this.a).setScrollable(true);
      }
      if (VideoFeedsRecommendFragment.m(this.a) != null) {
        VideoFeedsRecommendFragment.m(this.a).a(VideoFeedsRecommendFragment.k(this.a), VideoFeedsRecommendFragment.n(this.a));
      }
    }
    VideoFeedsRecommendFragment.d(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsRecommendFragment.PlayRecommendObserver
 * JD-Core Version:    0.7.0.1
 */