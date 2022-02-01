package com.tencent.mobileqq.kandian.repo.video.entity;

import com.tencent.mobileqq.kandian.repo.feeds.entity.UrlJumpInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.articlesummary.articlesummary.SubVideoInfo;
import tencent.im.oidb.articlesummary.articlesummary.UrlJumpInfo;
import tencent.im.oidb.articlesummary.articlesummary.VideoColumnInfo;

public class MultiVideoColumnInfo
{
  public int a;
  public String b;
  public String c;
  public String d;
  public String e;
  public int f;
  public long g;
  public int h;
  public int i;
  public boolean j;
  public String k;
  public String l;
  public String m;
  public String n;
  public int o;
  public List<SubVideoInfo> p = new ArrayList(6);
  public UrlJumpInfo q;
  public UrlJumpInfo r;
  
  public static MultiVideoColumnInfo a(articlesummary.VideoColumnInfo paramVideoColumnInfo)
  {
    MultiVideoColumnInfo localMultiVideoColumnInfo = new MultiVideoColumnInfo();
    localMultiVideoColumnInfo.a = paramVideoColumnInfo.uint32_column_id.get();
    localMultiVideoColumnInfo.b = paramVideoColumnInfo.bytes_column_name.get().toStringUtf8();
    localMultiVideoColumnInfo.c = paramVideoColumnInfo.bytes_column_icon_url.get().toStringUtf8();
    localMultiVideoColumnInfo.e = paramVideoColumnInfo.bytes_sub_title.get().toStringUtf8();
    localMultiVideoColumnInfo.d = paramVideoColumnInfo.bytes_column_card_icon_url.get().toStringUtf8();
    localMultiVideoColumnInfo.f = paramVideoColumnInfo.uint32_update_count.get();
    localMultiVideoColumnInfo.g = paramVideoColumnInfo.uint64_last_update_time.get();
    localMultiVideoColumnInfo.h = paramVideoColumnInfo.uint32_video_count.get();
    localMultiVideoColumnInfo.i = paramVideoColumnInfo.uint32_subscribe_count.get();
    int i1 = paramVideoColumnInfo.uint32_is_subscribed.get();
    boolean bool = true;
    if (i1 != 1) {
      bool = false;
    }
    localMultiVideoColumnInfo.j = bool;
    localMultiVideoColumnInfo.k = paramVideoColumnInfo.bytes_column_card_bg_url.get().toStringUtf8();
    localMultiVideoColumnInfo.l = paramVideoColumnInfo.bytes_column_card_bg_color.get().toStringUtf8();
    localMultiVideoColumnInfo.m = paramVideoColumnInfo.bytes_app_name.get().toStringUtf8();
    localMultiVideoColumnInfo.n = paramVideoColumnInfo.bytes_app_icon_url.get().toStringUtf8();
    localMultiVideoColumnInfo.o = paramVideoColumnInfo.uin32_column_card_bg_style.get();
    Iterator localIterator = paramVideoColumnInfo.rpt_sub_video_info.get().iterator();
    while (localIterator.hasNext())
    {
      articlesummary.SubVideoInfo localSubVideoInfo = (articlesummary.SubVideoInfo)localIterator.next();
      SubVideoInfo localSubVideoInfo1 = new SubVideoInfo();
      localSubVideoInfo1.a = localSubVideoInfo.uint64_article_id.get();
      localSubVideoInfo1.b = localSubVideoInfo.bytes_inner_uniq_id.get().toStringUtf8();
      localSubVideoInfo1.c = localSubVideoInfo.bytes_article_title.get().toStringUtf8();
      localSubVideoInfo1.d = localSubVideoInfo.bytes_first_page_pic_url.get().toStringUtf8();
      localSubVideoInfo1.f = localSubVideoInfo.uint32_video_play_count.get();
      localSubVideoInfo1.e = UrlJumpInfo.a((articlesummary.UrlJumpInfo)localSubVideoInfo.bytes_jum_url.get());
      localSubVideoInfo1.g = localSubVideoInfo.uint32_duration.get();
      localMultiVideoColumnInfo.p.add(localSubVideoInfo1);
    }
    localMultiVideoColumnInfo.q = UrlJumpInfo.a(paramVideoColumnInfo.default_jump_info);
    localMultiVideoColumnInfo.r = UrlJumpInfo.a(paramVideoColumnInfo.app_jump_info);
    return localMultiVideoColumnInfo;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("\n");
    localStringBuilder.append("columnId=");
    localStringBuilder.append(this.a);
    localStringBuilder.append("\n");
    localStringBuilder.append("columnName=");
    localStringBuilder.append(this.b);
    localStringBuilder.append("\n");
    localStringBuilder.append("columnIconUrl=");
    localStringBuilder.append(this.c);
    localStringBuilder.append("\n");
    localStringBuilder.append("cardIconUrl=");
    localStringBuilder.append(this.d);
    localStringBuilder.append("\n");
    localStringBuilder.append("subTitle=");
    localStringBuilder.append(this.e);
    localStringBuilder.append("\n");
    localStringBuilder.append("updateCount=");
    localStringBuilder.append(this.f);
    localStringBuilder.append("\n");
    localStringBuilder.append("updateTime=");
    localStringBuilder.append(this.g);
    localStringBuilder.append("\n");
    localStringBuilder.append("videoCount=");
    localStringBuilder.append(this.h);
    localStringBuilder.append("\n");
    localStringBuilder.append("subscribeCount=");
    localStringBuilder.append(this.i);
    localStringBuilder.append("\n");
    localStringBuilder.append("isSubscribed=");
    localStringBuilder.append(this.j);
    localStringBuilder.append("\n");
    localStringBuilder.append("cardBgUrl=");
    localStringBuilder.append(this.k);
    localStringBuilder.append("\n");
    localStringBuilder.append("color=");
    localStringBuilder.append(this.l);
    localStringBuilder.append("\n");
    localStringBuilder.append("appName=");
    localStringBuilder.append(this.m);
    localStringBuilder.append("\n");
    localStringBuilder.append("appIconUrl");
    localStringBuilder.append(this.n);
    localStringBuilder.append("\n");
    localStringBuilder.append("cardBgStyle");
    localStringBuilder.append(this.o);
    localStringBuilder.append("\n");
    localStringBuilder.append("subVideoInfoList={");
    Iterator localIterator = this.p.iterator();
    while (localIterator.hasNext())
    {
      SubVideoInfo localSubVideoInfo = (SubVideoInfo)localIterator.next();
      localStringBuilder.append("\n[");
      localStringBuilder.append(localSubVideoInfo.toString());
      localStringBuilder.append("]");
    }
    localStringBuilder.append("}");
    localStringBuilder.append("\n");
    localStringBuilder.append("defaultJumpUrl=");
    localStringBuilder.append(this.q.toString());
    localStringBuilder.append("\n");
    localStringBuilder.append("appJumpUrl=");
    localStringBuilder.append(this.r.toString());
    localStringBuilder.append("\n");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.video.entity.MultiVideoColumnInfo
 * JD-Core Version:    0.7.0.1
 */