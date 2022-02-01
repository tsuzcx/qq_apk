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
  public ArrayList<articlesummary.PGCPicInfo> a;
  public String b;
  public String c;
  
  public ArticleBasicInfo(articlesummary.ArticleBasicInfo paramArticleBasicInfo)
  {
    if (paramArticleBasicInfo.rowkey.has()) {
      this.jdField_a_of_type_JavaLangString = paramArticleBasicInfo.rowkey.get();
    }
    if (paramArticleBasicInfo.title.has()) {
      this.b = paramArticleBasicInfo.title.get();
    }
    if (paramArticleBasicInfo.jump_url.has()) {
      this.c = paramArticleBasicInfo.jump_url.get();
    }
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    if (paramArticleBasicInfo.msg_pgc_pic_info_list.has()) {
      this.jdField_a_of_type_JavaUtilArrayList.addAll(paramArticleBasicInfo.msg_pgc_pic_info_list.get());
    }
  }
  
  public articlesummary.ArticleBasicInfo a()
  {
    articlesummary.ArticleBasicInfo localArticleBasicInfo = new articlesummary.ArticleBasicInfo();
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      localArticleBasicInfo.rowkey.set(this.jdField_a_of_type_JavaLangString);
    }
    if (!TextUtils.isEmpty(this.b)) {
      localArticleBasicInfo.title.set(this.b);
    }
    if (!TextUtils.isEmpty(this.c)) {
      localArticleBasicInfo.jump_url.set(this.c);
    }
    Object localObject = this.jdField_a_of_type_JavaUtilArrayList;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.feeds.entity.ArticleBasicInfo
 * JD-Core Version:    0.7.0.1
 */