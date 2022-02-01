package com.tencent.mobileqq.kandian.repo.feeds.entity;

import com.tencent.mobileqq.kandian.repo.video.entity.PGCVideoInfo;
import com.tencent.mobileqq.pb.PBEnumField;
import tencent.im.oidb.articlesummary.articlesummary.ArticleBasicInfo;
import tencent.im.oidb.articlesummary.articlesummary.LongContentInfo;
import tencent.im.oidb.articlesummary.articlesummary.OutsideLinkInfo;
import tencent.im.oidb.articlesummary.articlesummary.PGCVideoInfo;

public class LongContentInfo
{
  public int a;
  public ArticleBasicInfo b;
  public PGCVideoInfo c;
  public OutsideLinkInfo d;
  
  public LongContentInfo() {}
  
  public LongContentInfo(articlesummary.LongContentInfo paramLongContentInfo)
  {
    this.a = paramLongContentInfo.enum_long_content_card_type.get();
    this.b = new ArticleBasicInfo(paramLongContentInfo.msg_article_basic_ingo);
    this.d = new OutsideLinkInfo(paramLongContentInfo.msg_outside_link_info);
    this.c = new PGCVideoInfo(paramLongContentInfo.msg_pgc_video_info);
  }
  
  public articlesummary.LongContentInfo a()
  {
    articlesummary.LongContentInfo localLongContentInfo = new articlesummary.LongContentInfo();
    localLongContentInfo.enum_long_content_card_type.set(this.a);
    localLongContentInfo.msg_article_basic_ingo.set(this.b.a());
    localLongContentInfo.msg_outside_link_info.set(this.d.a());
    localLongContentInfo.msg_pgc_video_info.set(this.c.a());
    localLongContentInfo.setHasFlag(true);
    return localLongContentInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.feeds.entity.LongContentInfo
 * JD-Core Version:    0.7.0.1
 */