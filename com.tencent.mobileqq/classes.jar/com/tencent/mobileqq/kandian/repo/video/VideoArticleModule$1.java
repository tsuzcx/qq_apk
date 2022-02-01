package com.tencent.mobileqq.kandian.repo.video;

import com.tencent.mobileqq.kandian.repo.common.IFindRemovedEntity;
import com.tencent.mobileqq.kandian.repo.video.entity.WeiShiVideoArticleInfo;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;

class VideoArticleModule$1
  implements IFindRemovedEntity<WeiShiVideoArticleInfo>
{
  VideoArticleModule$1(VideoArticleModule paramVideoArticleModule) {}
  
  public Entity a(EntityManager paramEntityManager, WeiShiVideoArticleInfo paramWeiShiVideoArticleInfo)
  {
    if (VideoArticleModule.a(this.a).tabbleIsExist(WeiShiVideoArticleInfo.class.getSimpleName())) {
      return VideoArticleModule.b(this.a).find(WeiShiVideoArticleInfo.class, "articleID = ? and channelID = ?", new String[] { String.valueOf(paramWeiShiVideoArticleInfo.articleID), String.valueOf(paramWeiShiVideoArticleInfo.channelID) });
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.video.VideoArticleModule.1
 * JD-Core Version:    0.7.0.1
 */