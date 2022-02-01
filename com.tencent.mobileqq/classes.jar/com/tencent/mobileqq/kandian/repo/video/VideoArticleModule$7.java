package com.tencent.mobileqq.kandian.repo.video;

import com.tencent.mobileqq.kandian.repo.video.entity.WeiShiVideoArticleInfo;
import java.util.Comparator;

class VideoArticleModule$7
  implements Comparator<WeiShiVideoArticleInfo>
{
  VideoArticleModule$7(VideoArticleModule paramVideoArticleModule) {}
  
  public int a(WeiShiVideoArticleInfo paramWeiShiVideoArticleInfo1, WeiShiVideoArticleInfo paramWeiShiVideoArticleInfo2)
  {
    if (paramWeiShiVideoArticleInfo1.recommendSeq == paramWeiShiVideoArticleInfo2.recommendSeq) {
      return 0;
    }
    if (paramWeiShiVideoArticleInfo1.recommendSeq > paramWeiShiVideoArticleInfo2.recommendSeq) {
      return -1;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.video.VideoArticleModule.7
 * JD-Core Version:    0.7.0.1
 */