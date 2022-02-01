package com.tencent.mobileqq.kandian.repo.report;

import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TabChannelCoverInfo;

public abstract class BaseReportData
{
  public long A = 0L;
  public int B = 0;
  public TabChannelCoverInfo C;
  public int D;
  public int E;
  public String F;
  public ReportInfo.DynamicInsertReportData G;
  public boolean a;
  public boolean b;
  public boolean c;
  public boolean d;
  public boolean e;
  public int f;
  public Long g;
  public int h;
  public long i;
  public int j;
  public String k;
  public AbsBaseArticleInfo l;
  public AbsBaseArticleInfo m;
  public String n;
  public int o;
  public int p;
  public byte[] q;
  public String r;
  public String s;
  public String t;
  public int u;
  public int v;
  public int w = 0;
  public boolean x = false;
  public int y = 0;
  public int z = 0;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("BaseReportData{mIsReported=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", mReportID=");
    localStringBuilder.append(this.g);
    localStringBuilder.append(", mStrategyId=");
    localStringBuilder.append(this.h);
    localStringBuilder.append(", mAlgorithmID=");
    localStringBuilder.append(this.i);
    localStringBuilder.append(", mArticleType=");
    localStringBuilder.append(this.j);
    localStringBuilder.append(", mFeedsSource='");
    localStringBuilder.append(this.k);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mVideoVid='");
    localStringBuilder.append(this.n);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mFeedsChannelEntrance=");
    localStringBuilder.append(this.o);
    localStringBuilder.append(", mFeedsFriendsInteraction=");
    localStringBuilder.append(this.p);
    localStringBuilder.append(", mStrCircleId='");
    localStringBuilder.append(this.r);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mPuin='");
    localStringBuilder.append(this.s);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mInnerUniqueID='");
    localStringBuilder.append(this.t);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mKandianTabSource=");
    localStringBuilder.append(this.u);
    localStringBuilder.append(", mKandianMode=");
    localStringBuilder.append(this.v);
    localStringBuilder.append(", mVideoRecommendStrategyID=");
    localStringBuilder.append(this.w);
    localStringBuilder.append(", mVideoIsDynamicRecommend=");
    localStringBuilder.append(this.x);
    localStringBuilder.append(", adsSource=");
    localStringBuilder.append(this.y);
    localStringBuilder.append(", adsJump=");
    localStringBuilder.append(this.z);
    localStringBuilder.append(", mExposeTime=");
    localStringBuilder.append(this.A);
    localStringBuilder.append(", mPosition=");
    localStringBuilder.append(this.B);
    localStringBuilder.append(", location=");
    localStringBuilder.append(this.D);
    localStringBuilder.append(", entryPath=");
    localStringBuilder.append(this.E);
    localStringBuilder.append(", dailyCookie='");
    localStringBuilder.append(this.F);
    localStringBuilder.append('\'');
    localStringBuilder.append(", dynamicInsertReportData=");
    localStringBuilder.append(this.G);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.report.BaseReportData
 * JD-Core Version:    0.7.0.1
 */