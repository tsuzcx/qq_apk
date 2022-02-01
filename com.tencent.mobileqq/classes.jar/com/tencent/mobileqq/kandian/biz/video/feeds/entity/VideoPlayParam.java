package com.tencent.mobileqq.kandian.biz.video.feeds.entity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.kandian.base.video.player.api.IVideoView;
import com.tencent.mobileqq.kandian.base.video.player.data.AbsReadInJoyVideoReportData;
import com.tencent.mobileqq.kandian.biz.video.api.IFeedsChannelDataHelper;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.Map;

public class VideoPlayParam
  extends BaseVideoPlayParam
{
  public String A;
  public long B = -1L;
  public int C;
  public AbsBaseArticleInfo D;
  public String E;
  public String F;
  boolean G = false;
  public String H;
  public int I;
  public int J;
  public int K;
  public int L;
  public boolean M;
  public int N;
  public int O;
  public int P = 1;
  public boolean Q;
  public int R;
  public int S;
  public int T;
  public int U;
  public Map<String, Object> V;
  public Bundle W = new Bundle();
  public ViewGroup g;
  public View h;
  public IVideoView i;
  public long j;
  public long k;
  public int l;
  public long m;
  public int n;
  public int o;
  public int p = -1;
  public String q;
  public String r;
  public String s;
  public String t;
  public long u;
  public String v;
  public String w;
  public int x;
  public String y;
  public AbsReadInJoyVideoReportData z;
  
  public String a()
  {
    AbsBaseArticleInfo localAbsBaseArticleInfo = this.D;
    if (localAbsBaseArticleInfo != null) {
      return localAbsBaseArticleInfo.getInnerUniqueID();
    }
    return "";
  }
  
  public VideoInfo b()
  {
    return ((IFeedsChannelDataHelper)QRoute.api(IFeedsChannelDataHelper.class)).getVideoInfoReq(this.D);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if ((paramObject instanceof VideoPlayParam)) {
      return a().equals(((VideoPlayParam)paramObject).a());
    }
    return super.equals(paramObject);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("VideoPlayParam[");
    localStringBuilder.append(" articleID:");
    localStringBuilder.append(this.j);
    localStringBuilder.append(", videoVid:");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", busitype:");
    localStringBuilder.append(this.x);
    localStringBuilder.append(", videoDuration:");
    localStringBuilder.append(this.l);
    localStringBuilder.append(", position:");
    localStringBuilder.append(this.e);
    if (this.D != null)
    {
      localStringBuilder.append(", title:");
      localStringBuilder.append(this.D.mTitle);
    }
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.feeds.entity.VideoPlayParam
 * JD-Core Version:    0.7.0.1
 */