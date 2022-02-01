package com.tencent.mobileqq.kandian.repo.db.struct;

import com.tencent.mobileqq.persistence.Entity;

public class ArticleReadInfo
  extends Entity
  implements Cloneable
{
  public static final String TABLE_NAME = "ArticleReadInfo";
  public long mArticleID = -1L;
  public boolean mIsRead;
  public long mLastReadTime;
  
  public ArticleReadInfo clone()
  {
    try
    {
      ArticleReadInfo localArticleReadInfo = (ArticleReadInfo)super.clone();
      return localArticleReadInfo;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      localCloneNotSupportedException.printStackTrace();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.db.struct.ArticleReadInfo
 * JD-Core Version:    0.7.0.1
 */