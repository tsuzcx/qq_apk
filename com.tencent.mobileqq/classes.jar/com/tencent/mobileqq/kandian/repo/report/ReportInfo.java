package com.tencent.mobileqq.kandian.repo.report;

import com.tencent.mobileqq.persistence.Entity;
import java.util.Arrays;
import tencent.im.oidb.cmd0x64e.oidb_cmd0x64e.SRTClickInfo;

public class ReportInfo
  extends Entity
  implements Cloneable
{
  public ReportInfo.DynamicInsertReportData dynamicInsertReportData;
  public String firstVideoRowkey;
  public int mAlgorithmId;
  public int mArticleLength = -1;
  public int mChannelId;
  public String mCollectUrl;
  public int mColumnID = -1;
  public FeedsReportData mFeedsReportData;
  public int mFolderStatus;
  public String mGWCommonData;
  public byte[] mGalleryReportInfo;
  public String mHotWord;
  public String mInnerId;
  public boolean mIsGallery;
  public int mOpSource;
  public int mOperation;
  public int mPlayTimeLength;
  public long mPuin;
  public int mReadArticleLength = -1;
  public int mReadTimeLength;
  public String mSearchTagName;
  public byte[] mServerContext;
  public int mSource;
  public long mSourceArticleId;
  public int mStrategyId;
  public long mUin;
  public ReportInfo.VideoExtraRepoerData mVideoExtraRepoerData;
  public int noDifferenceJump = 0;
  public String replyID;
  public long replyUin = -1L;
  public oidb_cmd0x64e.SRTClickInfo srtClickInfo;
  public String videoReportInfo;
  
  public ReportInfo clone()
  {
    try
    {
      ReportInfo localReportInfo = (ReportInfo)super.clone();
      return localReportInfo;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      localCloneNotSupportedException.printStackTrace();
    }
    return null;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ReportInfo{mUin=");
    localStringBuilder.append(this.mUin);
    localStringBuilder.append(", mSource=");
    localStringBuilder.append(this.mSource);
    localStringBuilder.append(", mSourceArticleId=");
    localStringBuilder.append(this.mSourceArticleId);
    localStringBuilder.append(", mChannelId=");
    localStringBuilder.append(this.mChannelId);
    localStringBuilder.append(", mAlgorithmId=");
    localStringBuilder.append(this.mAlgorithmId);
    localStringBuilder.append(", mStrategyId=");
    localStringBuilder.append(this.mStrategyId);
    localStringBuilder.append(", mOperation=");
    localStringBuilder.append(this.mOperation);
    localStringBuilder.append(", mOpSource=");
    localStringBuilder.append(this.mOpSource);
    localStringBuilder.append(", mInnerId='");
    localStringBuilder.append(this.mInnerId);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mFolderStatus=");
    localStringBuilder.append(this.mFolderStatus);
    localStringBuilder.append(", mServerContext=");
    localStringBuilder.append(Arrays.toString(this.mServerContext));
    localStringBuilder.append(", mSearchTagName='");
    localStringBuilder.append(this.mSearchTagName);
    localStringBuilder.append('\'');
    localStringBuilder.append(", replyUin='");
    localStringBuilder.append(this.replyUin);
    localStringBuilder.append('\'');
    localStringBuilder.append(", replyID='");
    localStringBuilder.append(this.replyID);
    localStringBuilder.append('\'');
    localStringBuilder.append(", videoReportInfo=");
    localStringBuilder.append(this.videoReportInfo);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.report.ReportInfo
 * JD-Core Version:    0.7.0.1
 */