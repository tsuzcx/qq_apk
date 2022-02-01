package com.tencent.mobileqq.kandian.repo.db.struct;

import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsType;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.persistence.Entity;

public class ArticleExposureInfo
  extends Entity
  implements Comparable<ArticleExposureInfo>
{
  public static final String TABLE_NAME = "ArticleExposureInfo";
  public long algorithmID;
  public long articleID;
  public long channelID;
  public long exposureTime;
  public int feedsType;
  public String rowkey;
  public String title;
  
  public static ArticleExposureInfo createExposureInfoFromArticle(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (paramAbsBaseArticleInfo == null) {
      return null;
    }
    ArticleExposureInfo localArticleExposureInfo = new ArticleExposureInfo();
    localArticleExposureInfo.rowkey = paramAbsBaseArticleInfo.innerUniqueID;
    localArticleExposureInfo.algorithmID = paramAbsBaseArticleInfo.mAlgorithmID;
    localArticleExposureInfo.articleID = paramAbsBaseArticleInfo.mArticleID;
    localArticleExposureInfo.exposureTime = NetConnInfoCenter.getServerTimeMillis();
    localArticleExposureInfo.feedsType = RIJFeedsType.a(paramAbsBaseArticleInfo);
    localArticleExposureInfo.channelID = paramAbsBaseArticleInfo.mChannelID;
    localArticleExposureInfo.title = paramAbsBaseArticleInfo.mTitle;
    return localArticleExposureInfo;
  }
  
  public int compareTo(ArticleExposureInfo paramArticleExposureInfo)
  {
    if (paramArticleExposureInfo == null) {
      return -1;
    }
    return this.exposureTime < paramArticleExposureInfo.exposureTime;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ArticleExposureInfo{channelID=");
    localStringBuilder.append(this.channelID);
    localStringBuilder.append(", exposureTime=");
    localStringBuilder.append(this.exposureTime);
    localStringBuilder.append(", rowkey='");
    localStringBuilder.append(this.rowkey);
    localStringBuilder.append('\'');
    localStringBuilder.append(", articleID='");
    localStringBuilder.append(this.articleID);
    localStringBuilder.append('\'');
    localStringBuilder.append(", feedsType=");
    localStringBuilder.append(this.feedsType);
    localStringBuilder.append(", algorithmID=");
    localStringBuilder.append(this.algorithmID);
    localStringBuilder.append(", title=");
    localStringBuilder.append(this.title);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.db.struct.ArticleExposureInfo
 * JD-Core Version:    0.7.0.1
 */