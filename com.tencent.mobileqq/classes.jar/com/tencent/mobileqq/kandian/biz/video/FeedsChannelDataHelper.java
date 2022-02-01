package com.tencent.mobileqq.kandian.biz.video;

import android.text.TextUtils;
import com.tencent.mobileqq.kandian.base.image.api.impl.PublicAccountHttpDownloaderImpl;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;
import com.tencent.mobileqq.kandian.repo.common.RIJItemViewTypeUtils;
import com.tencent.mobileqq.kandian.repo.db.struct.BaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.dislike.DislikeInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SocializeFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.UGCFeedsInfo;
import com.tencent.mobileqq.kandian.repo.handler.BiuInfo;
import com.tencent.mobileqq.kandian.repo.video.entity.UGCVideoInfo;
import java.net.URL;
import java.util.ArrayList;

public class FeedsChannelDataHelper
{
  public static VideoInfo a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    VideoInfo localVideoInfo = new VideoInfo();
    localVideoInfo.l = paramAbsBaseArticleInfo.getInnerUniqueID();
    localVideoInfo.t = RIJItemViewTypeUtils.m(paramAbsBaseArticleInfo);
    localVideoInfo.E = paramAbsBaseArticleInfo.mFeedId;
    localVideoInfo.F = paramAbsBaseArticleInfo.mFeedType;
    return localVideoInfo;
  }
  
  public static AbsBaseArticleInfo a(VideoInfo paramVideoInfo)
  {
    if ((paramVideoInfo != null) && (paramVideoInfo.a != 0))
    {
      BaseArticleInfo localBaseArticleInfo = new BaseArticleInfo();
      try
      {
        localBaseArticleInfo.rawkey = paramVideoInfo.l;
        localBaseArticleInfo.mArticleID = paramVideoInfo.u;
        localBaseArticleInfo.innerUniqueID = paramVideoInfo.l;
        localBaseArticleInfo.mTitle = paramVideoInfo.g;
        localBaseArticleInfo.mSubscribeName = paramVideoInfo.r;
        localBaseArticleInfo.mSubscribeID = paramVideoInfo.q;
        localBaseArticleInfo.mFirstPagePicUrl = paramVideoInfo.f;
        localBaseArticleInfo.mVideoDuration = paramVideoInfo.e;
        localBaseArticleInfo.mVideoCoverUrl = new PublicAccountHttpDownloaderImpl().makeURL(paramVideoInfo.f, paramVideoInfo.a);
        localBaseArticleInfo.mVideoVid = paramVideoInfo.b;
        localBaseArticleInfo.mFeedType = paramVideoInfo.F;
        localBaseArticleInfo.mFeedId = paramVideoInfo.E;
        localBaseArticleInfo.mXGFileSize = paramVideoInfo.n;
        localBaseArticleInfo.busiType = paramVideoInfo.a;
        localBaseArticleInfo.mJsonVideoList = paramVideoInfo.v;
        localBaseArticleInfo.mVideoCommentCount = paramVideoInfo.p;
        localBaseArticleInfo.mVideoJsonWidth = paramVideoInfo.c;
        localBaseArticleInfo.mVideoJsonHeight = paramVideoInfo.d;
        localBaseArticleInfo.mArticleContentUrl = paramVideoInfo.k;
        localBaseArticleInfo.aioShareUrl = paramVideoInfo.y;
        localBaseArticleInfo.thirdIcon = paramVideoInfo.B;
        localBaseArticleInfo.thirdName = paramVideoInfo.r;
        localBaseArticleInfo.thirdAction = paramVideoInfo.A;
        localBaseArticleInfo.thirdUin = paramVideoInfo.q;
        localBaseArticleInfo.thirdUinName = paramVideoInfo.C;
        localBaseArticleInfo.mVideoPlayCount = paramVideoInfo.aj;
        localBaseArticleInfo.mRecommentdReason = paramVideoInfo.m;
        localBaseArticleInfo.videoReportInfo = paramVideoInfo.ao;
        localBaseArticleInfo.mSummary = paramVideoInfo.h;
        localBaseArticleInfo.mTime = paramVideoInfo.j;
        localBaseArticleInfo.mAlgorithmID = paramVideoInfo.ah;
        localBaseArticleInfo.mDiskLikeInfoString = DislikeInfo.a(paramVideoInfo.ax);
        localBaseArticleInfo.mRecommendSeq = paramVideoInfo.N;
        localBaseArticleInfo.mVideoLogoUrl = paramVideoInfo.X;
        if (paramVideoInfo.t)
        {
          paramVideoInfo.a = 6;
          localBaseArticleInfo.mSocialFeedInfo = new SocializeFeedsInfo();
          localBaseArticleInfo.mSocialFeedInfo.s = new UGCFeedsInfo();
          if (!TextUtils.isEmpty(paramVideoInfo.q)) {
            localBaseArticleInfo.mSocialFeedInfo.s.e = Long.valueOf(paramVideoInfo.q).longValue();
          }
          localBaseArticleInfo.mSocialFeedInfo.s.a = paramVideoInfo.F;
          localBaseArticleInfo.mSocialFeedInfo.s.g = paramVideoInfo.r;
          localBaseArticleInfo.mSocialFeedInfo.j = paramVideoInfo.p;
          localBaseArticleInfo.mSocialFeedInfo.s.c = new ArrayList();
          UGCVideoInfo localUGCVideoInfo = new UGCVideoInfo();
          localUGCVideoInfo.d = paramVideoInfo.f;
          localUGCVideoInfo.e = paramVideoInfo.g;
          localUGCVideoInfo.g = (paramVideoInfo.e * 1000);
          localUGCVideoInfo.h = paramVideoInfo.c;
          localUGCVideoInfo.i = paramVideoInfo.d;
          localUGCVideoInfo.l = paramVideoInfo.l;
          if (paramVideoInfo.i != null) {
            localUGCVideoInfo.m = Integer.parseInt(paramVideoInfo.i);
          }
          localUGCVideoInfo.n = paramVideoInfo.k;
          localUGCVideoInfo.o = paramVideoInfo.a;
          localUGCVideoInfo.p = paramVideoInfo.b;
          localBaseArticleInfo.mSocialFeedInfo.s.c.add(localUGCVideoInfo);
          localBaseArticleInfo.mSocialFeedInfo.c.a = Long.parseLong(paramVideoInfo.q);
          paramVideoInfo = new BiuInfo();
          paramVideoInfo.b = Long.valueOf(localBaseArticleInfo.mFeedId);
          paramVideoInfo.c = Long.valueOf(localBaseArticleInfo.mFeedType);
          localBaseArticleInfo.mSocialFeedInfo.n = paramVideoInfo;
          return localBaseArticleInfo;
        }
      }
      catch (Throwable paramVideoInfo)
      {
        paramVideoInfo.printStackTrace();
      }
      return localBaseArticleInfo;
    }
    return null;
  }
  
  public static String a(URL paramURL)
  {
    if (paramURL != null)
    {
      if (TextUtils.isEmpty(paramURL.toString())) {
        return "";
      }
      return paramURL.toString().replace("pubaccountimage:", "");
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.FeedsChannelDataHelper
 * JD-Core Version:    0.7.0.1
 */