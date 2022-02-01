package com.tencent.mobileqq.kandian.repo.feeds.entity;

import android.text.TextUtils;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.ArrayList;
import java.util.Iterator;
import tencent.im.oidb.articlesummary.articlesummary.ArticleBasicInfo;
import tencent.im.oidb.articlesummary.articlesummary.PGCPicInfo;

public class ArticleBasicInfo
{
  public String a;
  public String b;
  public ArrayList<articlesummary.PGCPicInfo> c;
  public String d;
  
  public ArticleBasicInfo(articlesummary.ArticleBasicInfo paramArticleBasicInfo)
  {
    if (paramArticleBasicInfo.rowkey.has()) {
      this.a = paramArticleBasicInfo.rowkey.get();
    }
    if (paramArticleBasicInfo.title.has()) {
      this.b = paramArticleBasicInfo.title.get();
    }
    if (paramArticleBasicInfo.jump_url.has()) {
      this.d = paramArticleBasicInfo.jump_url.get();
    }
    this.c = new ArrayList();
    if (paramArticleBasicInfo.msg_pgc_pic_info_list.has()) {
      this.c.addAll(paramArticleBasicInfo.msg_pgc_pic_info_list.get());
    }
  }
  
  public articlesummary.ArticleBasicInfo a()
  {
    articlesummary.ArticleBasicInfo localArticleBasicInfo = new articlesummary.ArticleBasicInfo();
    if (!TextUtils.isEmpty(this.a)) {
      localArticleBasicInfo.rowkey.set(this.a);
    }
    if (!TextUtils.isEmpty(this.b)) {
      localArticleBasicInfo.title.set(this.b);
    }
    if (!TextUtils.isEmpty(this.d)) {
      localArticleBasicInfo.jump_url.set(this.d);
    }
    Object localObject = this.c;
    if (localObject != null)
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        articlesummary.PGCPicInfo localPGCPicInfo1 = (articlesummary.PGCPicInfo)((Iterator)localObject).next();
        articlesummary.PGCPicInfo localPGCPicInfo2 = new articlesummary.PGCPicInfo();
        localPGCPicInfo2.setHasFlag(true);
        localPGCPicInfo2.bytes_pic_md5.set(localPGCPicInfo1.bytes_pic_md5.get());
        localPGCPicInfo2.bytes_pic_desc.set(localPGCPicInfo1.bytes_pic_desc.get());
        localPGCPicInfo2.bytes_pic_url.set(localPGCPicInfo1.bytes_pic_url.get());
        localPGCPicInfo2.bytes_thumbnail_url.set(localPGCPicInfo1.bytes_thumbnail_url.get());
        localPGCPicInfo2.is_animation.set(localPGCPicInfo1.is_animation.get());
        localPGCPicInfo2.uint32_pic_height.set(localPGCPicInfo1.uint32_pic_height.get());
        localPGCPicInfo2.uint32_pic_width.set(localPGCPicInfo1.uint32_pic_width.get());
        localArticleBasicInfo.msg_pgc_pic_info_list.add(localPGCPicInfo1);
      }
    }
    return localArticleBasicInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.feeds.entity.ArticleBasicInfo
 * JD-Core Version:    0.7.0.1
 */