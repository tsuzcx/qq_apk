package com.tencent.mobileqq.kandian.repo.feeds.entity;

import com.tencent.mobileqq.kandian.base.utils.RIJPBFieldUtils;
import com.tencent.mobileqq.kandian.repo.video.entity.PGCVideoInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.articlesummary.articlesummary.GalleryPGCFeedsInfo;
import tencent.im.oidb.articlesummary.articlesummary.PGCFeedsInfo;
import tencent.im.oidb.articlesummary.articlesummary.PGCPicInfo;
import tencent.im.oidb.articlesummary.articlesummary.PGCVideoInfo;

public class PGCFeedsInfo
{
  public ArrayList<PGCPicInfo> a = new ArrayList();
  public ArrayList<PGCVideoInfo> b = new ArrayList();
  public String c;
  public int d;
  public int e;
  public boolean f = false;
  public int g = 0;
  public GalleryPGCFeedsInfo h;
  
  public static PGCFeedsInfo a(articlesummary.PGCFeedsInfo paramPGCFeedsInfo)
  {
    PGCFeedsInfo localPGCFeedsInfo = new PGCFeedsInfo();
    if (paramPGCFeedsInfo.bytes_pgc_comments.has()) {
      localPGCFeedsInfo.c = paramPGCFeedsInfo.bytes_pgc_comments.get().toStringUtf8();
    }
    if (paramPGCFeedsInfo.uint32_myself_follow_status.has()) {
      localPGCFeedsInfo.e = paramPGCFeedsInfo.uint32_myself_follow_status.get();
    }
    if (paramPGCFeedsInfo.uint32_follow_counts.has()) {
      localPGCFeedsInfo.d = paramPGCFeedsInfo.uint32_follow_counts.get();
    }
    if (paramPGCFeedsInfo.uint32_article_type.has()) {
      localPGCFeedsInfo.f = true;
    }
    if (paramPGCFeedsInfo.msg_pgc_pic_info_list.has()) {
      b(paramPGCFeedsInfo, localPGCFeedsInfo);
    }
    if (paramPGCFeedsInfo.msg_pgc_video_info_list.has()) {
      a(paramPGCFeedsInfo, localPGCFeedsInfo);
    }
    if (paramPGCFeedsInfo.msg_gallery_feeds_info.has())
    {
      localPGCFeedsInfo.h = new GalleryPGCFeedsInfo();
      paramPGCFeedsInfo = (articlesummary.GalleryPGCFeedsInfo)paramPGCFeedsInfo.msg_gallery_feeds_info.get();
      if (paramPGCFeedsInfo.uint64_pic_count.has()) {
        localPGCFeedsInfo.h.a = paramPGCFeedsInfo.uint64_pic_count.get();
      }
    }
    return localPGCFeedsInfo;
  }
  
  private String a()
  {
    Object localObject1 = this.a;
    if (localObject1 == null) {
      return null;
    }
    Object localObject2 = ((ArrayList)localObject1).iterator();
    StringBuilder localStringBuilder;
    for (localObject1 = "["; ((Iterator)localObject2).hasNext(); localObject1 = localStringBuilder.toString())
    {
      PGCPicInfo localPGCPicInfo = (PGCPicInfo)((Iterator)localObject2).next();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append("{");
      localStringBuilder.append(localPGCPicInfo.toString());
      localStringBuilder.append("},");
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append("]");
    return ((StringBuilder)localObject2).toString();
  }
  
  public static articlesummary.PGCFeedsInfo a(PGCFeedsInfo paramPGCFeedsInfo)
  {
    articlesummary.PGCFeedsInfo localPGCFeedsInfo = new articlesummary.PGCFeedsInfo();
    RIJPBFieldUtils.b(localPGCFeedsInfo.bytes_pgc_comments, paramPGCFeedsInfo.c);
    if (paramPGCFeedsInfo.f) {
      localPGCFeedsInfo.uint32_article_type.set(1);
    }
    RIJPBFieldUtils.b(localPGCFeedsInfo.uint32_myself_follow_status, paramPGCFeedsInfo.e);
    RIJPBFieldUtils.b(localPGCFeedsInfo.uint32_follow_counts, paramPGCFeedsInfo.d);
    Object localObject1;
    Object localObject2;
    Object localObject3;
    Object localObject4;
    if (a(paramPGCFeedsInfo.a))
    {
      localObject1 = new ArrayList();
      localObject2 = paramPGCFeedsInfo.a.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (PGCPicInfo)((Iterator)localObject2).next();
        localObject4 = new articlesummary.PGCPicInfo();
        RIJPBFieldUtils.b(((articlesummary.PGCPicInfo)localObject4).bytes_pic_md5, ((PGCPicInfo)localObject3).c);
        RIJPBFieldUtils.b(((articlesummary.PGCPicInfo)localObject4).bytes_pic_url, ((PGCPicInfo)localObject3).d);
        ((articlesummary.PGCPicInfo)localObject4).uint32_pic_height.set(((PGCPicInfo)localObject3).b);
        ((articlesummary.PGCPicInfo)localObject4).uint32_pic_width.set(((PGCPicInfo)localObject3).a);
        RIJPBFieldUtils.b(((articlesummary.PGCPicInfo)localObject4).bytes_thumbnail_url, ((PGCPicInfo)localObject3).e);
        RIJPBFieldUtils.b(((articlesummary.PGCPicInfo)localObject4).bytes_pic_desc, ((PGCPicInfo)localObject3).g);
        RIJPBFieldUtils.b(((articlesummary.PGCPicInfo)localObject4).uint64_gallery_index, ((PGCPicInfo)localObject3).h);
        if (((PGCPicInfo)localObject3).i != null)
        {
          articlesummary.PGCVideoInfo localPGCVideoInfo = new articlesummary.PGCVideoInfo();
          RIJPBFieldUtils.b(localPGCVideoInfo.bytes_vid, ((PGCPicInfo)localObject3).i.e);
          RIJPBFieldUtils.b(localPGCVideoInfo.bytes_video_url, ((PGCPicInfo)localObject3).i.b);
          RIJPBFieldUtils.b(localPGCVideoInfo.bytes_video_md5, ((PGCPicInfo)localObject3).i.a);
          RIJPBFieldUtils.b(localPGCVideoInfo.bytes_pic_md5, ((PGCPicInfo)localObject3).i.c);
          RIJPBFieldUtils.b(localPGCVideoInfo.bytes_pic_url, ((PGCPicInfo)localObject3).i.d);
          localPGCVideoInfo.uint32_duration.set(((PGCPicInfo)localObject3).i.f);
          localPGCVideoInfo.uint32_busi_type.set(((PGCPicInfo)localObject3).i.g);
          ((articlesummary.PGCPicInfo)localObject4).msg_video_info.set(localPGCVideoInfo);
        }
        ((articlesummary.PGCPicInfo)localObject4).is_animation.set(((PGCPicInfo)localObject3).f);
        ((List)localObject1).add(localObject4);
      }
      localPGCFeedsInfo.msg_pgc_pic_info_list.set((List)localObject1);
    }
    if (b(paramPGCFeedsInfo.b))
    {
      localObject1 = new ArrayList();
      localObject2 = paramPGCFeedsInfo.b.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (PGCVideoInfo)((Iterator)localObject2).next();
        localObject4 = new articlesummary.PGCVideoInfo();
        RIJPBFieldUtils.b(((articlesummary.PGCVideoInfo)localObject4).bytes_video_url, ((PGCVideoInfo)localObject3).b);
        RIJPBFieldUtils.b(((articlesummary.PGCVideoInfo)localObject4).bytes_video_md5, ((PGCVideoInfo)localObject3).a);
        RIJPBFieldUtils.b(((articlesummary.PGCVideoInfo)localObject4).bytes_pic_md5, ((PGCVideoInfo)localObject3).c);
        RIJPBFieldUtils.b(((articlesummary.PGCVideoInfo)localObject4).bytes_pic_url, ((PGCVideoInfo)localObject3).d);
        ((List)localObject1).add(localObject4);
      }
      localPGCFeedsInfo.msg_pgc_video_info_list.set((List)localObject1);
    }
    localPGCFeedsInfo.enum_pgc_feeds_type.set(paramPGCFeedsInfo.g);
    if (paramPGCFeedsInfo.h != null)
    {
      localObject1 = new articlesummary.GalleryPGCFeedsInfo();
      RIJPBFieldUtils.b(((articlesummary.GalleryPGCFeedsInfo)localObject1).uint64_pic_count, paramPGCFeedsInfo.h.a);
      RIJPBFieldUtils.b(((articlesummary.GalleryPGCFeedsInfo)localObject1).uint64_source, paramPGCFeedsInfo.h.c);
      RIJPBFieldUtils.b(((articlesummary.GalleryPGCFeedsInfo)localObject1).uint64_sub_source, paramPGCFeedsInfo.h.d);
      RIJPBFieldUtils.b(((articlesummary.GalleryPGCFeedsInfo)localObject1).bytes_gallery_url, paramPGCFeedsInfo.h.e);
      if (a(paramPGCFeedsInfo.h.b))
      {
        localObject2 = new ArrayList();
        paramPGCFeedsInfo = paramPGCFeedsInfo.h.b.iterator();
        while (paramPGCFeedsInfo.hasNext())
        {
          localObject3 = (PGCPicInfo)paramPGCFeedsInfo.next();
          localObject4 = new articlesummary.PGCPicInfo();
          RIJPBFieldUtils.b(((articlesummary.PGCPicInfo)localObject4).uint32_pic_width, ((PGCPicInfo)localObject3).a);
          RIJPBFieldUtils.b(((articlesummary.PGCPicInfo)localObject4).uint32_pic_height, ((PGCPicInfo)localObject3).b);
          RIJPBFieldUtils.b(((articlesummary.PGCPicInfo)localObject4).bytes_pic_md5, ((PGCPicInfo)localObject3).c);
          RIJPBFieldUtils.b(((articlesummary.PGCPicInfo)localObject4).bytes_pic_url, ((PGCPicInfo)localObject3).d);
          RIJPBFieldUtils.b(((articlesummary.PGCPicInfo)localObject4).bytes_thumbnail_url, ((PGCPicInfo)localObject3).e);
          RIJPBFieldUtils.b(((articlesummary.PGCPicInfo)localObject4).is_animation, ((PGCPicInfo)localObject3).f);
          RIJPBFieldUtils.b(((articlesummary.PGCPicInfo)localObject4).bytes_pic_desc, ((PGCPicInfo)localObject3).g);
          RIJPBFieldUtils.b(((articlesummary.PGCPicInfo)localObject4).uint64_gallery_index, ((PGCPicInfo)localObject3).h);
          ((List)localObject2).add(localObject4);
        }
      }
      localPGCFeedsInfo.msg_gallery_feeds_info.set((MessageMicro)localObject1);
    }
    return localPGCFeedsInfo;
  }
  
  private static void a(articlesummary.PGCFeedsInfo paramPGCFeedsInfo, PGCFeedsInfo paramPGCFeedsInfo1)
  {
    paramPGCFeedsInfo = paramPGCFeedsInfo.msg_pgc_video_info_list.get().iterator();
    while (paramPGCFeedsInfo.hasNext())
    {
      articlesummary.PGCVideoInfo localPGCVideoInfo = (articlesummary.PGCVideoInfo)paramPGCFeedsInfo.next();
      PGCVideoInfo localPGCVideoInfo1 = new PGCVideoInfo();
      if (localPGCVideoInfo.bytes_pic_md5.has()) {
        localPGCVideoInfo1.c = localPGCVideoInfo.bytes_pic_md5.get().toStringUtf8();
      }
      if (localPGCVideoInfo.bytes_pic_url.has()) {
        localPGCVideoInfo1.d = localPGCVideoInfo.bytes_pic_url.get().toStringUtf8();
      }
      if (localPGCVideoInfo.bytes_video_md5.has()) {
        localPGCVideoInfo1.a = localPGCVideoInfo.bytes_video_md5.get().toStringUtf8();
      }
      if (localPGCVideoInfo.bytes_video_url.has()) {
        localPGCVideoInfo1.b = localPGCVideoInfo.bytes_video_url.get().toStringUtf8();
      }
      paramPGCFeedsInfo1.b.add(localPGCVideoInfo1);
    }
  }
  
  private static boolean a(List<PGCPicInfo> paramList)
  {
    return (paramList != null) && (paramList.size() > 0);
  }
  
  private String b()
  {
    Object localObject1 = this.b;
    if (localObject1 == null) {
      return null;
    }
    Object localObject2 = ((ArrayList)localObject1).iterator();
    StringBuilder localStringBuilder;
    for (localObject1 = "["; ((Iterator)localObject2).hasNext(); localObject1 = localStringBuilder.toString())
    {
      PGCVideoInfo localPGCVideoInfo = (PGCVideoInfo)((Iterator)localObject2).next();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append("{");
      localStringBuilder.append(localPGCVideoInfo.toString());
      localStringBuilder.append("},");
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append("]");
    return ((StringBuilder)localObject2).toString();
  }
  
  private static void b(articlesummary.PGCFeedsInfo paramPGCFeedsInfo, PGCFeedsInfo paramPGCFeedsInfo1)
  {
    paramPGCFeedsInfo = paramPGCFeedsInfo.msg_pgc_pic_info_list.get().iterator();
    while (paramPGCFeedsInfo.hasNext())
    {
      Object localObject = (articlesummary.PGCPicInfo)paramPGCFeedsInfo.next();
      PGCPicInfo localPGCPicInfo = new PGCPicInfo();
      if (((articlesummary.PGCPicInfo)localObject).bytes_pic_md5.has()) {
        localPGCPicInfo.c = ((articlesummary.PGCPicInfo)localObject).bytes_pic_md5.get().toStringUtf8();
      }
      if (((articlesummary.PGCPicInfo)localObject).bytes_pic_url.has()) {
        localPGCPicInfo.d = ((articlesummary.PGCPicInfo)localObject).bytes_pic_url.get().toStringUtf8();
      }
      if (((articlesummary.PGCPicInfo)localObject).uint32_pic_height.has()) {
        localPGCPicInfo.b = ((articlesummary.PGCPicInfo)localObject).uint32_pic_height.get();
      }
      if (((articlesummary.PGCPicInfo)localObject).uint32_pic_width.has()) {
        localPGCPicInfo.a = ((articlesummary.PGCPicInfo)localObject).uint32_pic_width.get();
      }
      if (((articlesummary.PGCPicInfo)localObject).is_animation.has()) {
        localPGCPicInfo.f = ((articlesummary.PGCPicInfo)localObject).is_animation.get();
      }
      if (((articlesummary.PGCPicInfo)localObject).bytes_thumbnail_url.has()) {
        localPGCPicInfo.e = ((articlesummary.PGCPicInfo)localObject).bytes_thumbnail_url.get().toStringUtf8();
      }
      if (((articlesummary.PGCPicInfo)localObject).bytes_pic_desc.has()) {
        localPGCPicInfo.g = ((articlesummary.PGCPicInfo)localObject).bytes_pic_desc.get().toStringUtf8();
      }
      if (((articlesummary.PGCPicInfo)localObject).uint64_gallery_index.has()) {
        localPGCPicInfo.h = ((articlesummary.PGCPicInfo)localObject).uint64_gallery_index.get();
      }
      if (((articlesummary.PGCPicInfo)localObject).msg_video_info.has())
      {
        PGCVideoInfo localPGCVideoInfo = new PGCVideoInfo();
        localObject = (articlesummary.PGCVideoInfo)((articlesummary.PGCPicInfo)localObject).msg_video_info.get();
        if (((articlesummary.PGCVideoInfo)localObject).bytes_pic_md5.has()) {
          localPGCVideoInfo.c = ((articlesummary.PGCVideoInfo)localObject).bytes_pic_md5.get().toStringUtf8();
        }
        if (((articlesummary.PGCVideoInfo)localObject).bytes_pic_url.has()) {
          localPGCVideoInfo.d = ((articlesummary.PGCVideoInfo)localObject).bytes_pic_url.get().toStringUtf8();
        }
        if (((articlesummary.PGCVideoInfo)localObject).bytes_vid.has()) {
          localPGCVideoInfo.e = ((articlesummary.PGCVideoInfo)localObject).bytes_vid.get().toStringUtf8();
        }
        if (((articlesummary.PGCVideoInfo)localObject).uint32_duration.has()) {
          localPGCVideoInfo.f = ((articlesummary.PGCVideoInfo)localObject).uint32_duration.get();
        }
        if (((articlesummary.PGCVideoInfo)localObject).uint32_busi_type.has()) {
          localPGCVideoInfo.g = ((articlesummary.PGCVideoInfo)localObject).uint32_busi_type.get();
        }
        localPGCPicInfo.i = localPGCVideoInfo;
      }
      paramPGCFeedsInfo1.a.add(localPGCPicInfo);
    }
  }
  
  private static boolean b(List<PGCVideoInfo> paramList)
  {
    return (paramList != null) && (paramList.size() > 0);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("PGCFeedsInfo{pGCPicInfos=");
    localStringBuilder.append(a());
    localStringBuilder.append(", pGCVideoInfos=");
    localStringBuilder.append(b());
    localStringBuilder.append(", pgcComments='");
    localStringBuilder.append(this.c);
    localStringBuilder.append('\'');
    localStringBuilder.append(", followCount=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", followStatus=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", isShortContent=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", pgcFeedsType=");
    localStringBuilder.append(this.g);
    localStringBuilder.append(", galleryPGCFeedsInfo=");
    localStringBuilder.append(this.h);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.feeds.entity.PGCFeedsInfo
 * JD-Core Version:    0.7.0.1
 */