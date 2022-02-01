package com.tencent.mobileqq.kandian.repo.feeds.entity;

import android.text.TextUtils;
import com.tencent.mobileqq.kandian.repo.handler.BiuInfo;
import com.tencent.mobileqq.kandian.repo.handler.UGCVoiceInfo;
import com.tencent.mobileqq.kandian.repo.video.entity.UGCVideoInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.articlesummary.articlesummary.BiuMultiLevel;
import tencent.im.oidb.articlesummary.articlesummary.UGCFeedsInfo;
import tencent.im.oidb.articlesummary.articlesummary.UGCPicInfo;
import tencent.im.oidb.articlesummary.articlesummary.UGCVideoInfo;
import tencent.im.oidb.articlesummary.articlesummary.UGCVoiceInfo;
import tencent.im.oidb.articlesummary.feeds_info.AccountProfile;

public class UGCFeedsInfo
{
  public int a;
  public ArrayList<UGCPicInfo> b = new ArrayList();
  public ArrayList<UGCVideoInfo> c = new ArrayList();
  public ArrayList<UGCVoiceInfo> d = new ArrayList();
  public long e;
  public String f;
  public String g;
  public BiuInfo h;
  public int i;
  public String j;
  public AccountProfileInfo k;
  
  public static articlesummary.UGCFeedsInfo a(UGCFeedsInfo paramUGCFeedsInfo)
  {
    articlesummary.UGCFeedsInfo localUGCFeedsInfo = new articlesummary.UGCFeedsInfo();
    d(paramUGCFeedsInfo, localUGCFeedsInfo);
    c(paramUGCFeedsInfo, localUGCFeedsInfo);
    b(paramUGCFeedsInfo, localUGCFeedsInfo);
    a(paramUGCFeedsInfo, localUGCFeedsInfo);
    return localUGCFeedsInfo;
  }
  
  public static void a(UGCFeedsInfo paramUGCFeedsInfo, articlesummary.UGCFeedsInfo paramUGCFeedsInfo1)
  {
    ArrayList localArrayList = paramUGCFeedsInfo.d;
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      localArrayList = new ArrayList();
      paramUGCFeedsInfo = paramUGCFeedsInfo.d.iterator();
      while (paramUGCFeedsInfo.hasNext())
      {
        UGCVoiceInfo localUGCVoiceInfo = (UGCVoiceInfo)paramUGCFeedsInfo.next();
        articlesummary.UGCVoiceInfo localUGCVoiceInfo1 = new articlesummary.UGCVoiceInfo();
        localUGCVoiceInfo1.uint32_duration.set(localUGCVoiceInfo.duration);
        localUGCVoiceInfo1.uint32_file_size.set(localUGCVoiceInfo.fileSize);
        if (!TextUtils.isEmpty(localUGCVoiceInfo.voiceUrl)) {
          localUGCVoiceInfo1.bytes_voice_url.set(ByteStringMicro.copyFromUtf8(localUGCVoiceInfo.voiceUrl));
        }
        localArrayList.add(localUGCVoiceInfo1);
      }
      paramUGCFeedsInfo1.msg_ugc_voice_info_list.set(localArrayList);
    }
  }
  
  public static void b(UGCFeedsInfo paramUGCFeedsInfo, articlesummary.UGCFeedsInfo paramUGCFeedsInfo1)
  {
    ArrayList localArrayList = paramUGCFeedsInfo.c;
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      localArrayList = new ArrayList();
      paramUGCFeedsInfo = paramUGCFeedsInfo.c.iterator();
      while (paramUGCFeedsInfo.hasNext())
      {
        UGCVideoInfo localUGCVideoInfo = (UGCVideoInfo)paramUGCFeedsInfo.next();
        articlesummary.UGCVideoInfo localUGCVideoInfo1 = new articlesummary.UGCVideoInfo();
        localUGCVideoInfo1.uint64_duration.set(localUGCVideoInfo.g);
        if (!TextUtils.isEmpty(localUGCVideoInfo.b)) {
          localUGCVideoInfo1.bytes_video_url.set(ByteStringMicro.copyFromUtf8(localUGCVideoInfo.b));
        }
        if (!TextUtils.isEmpty(localUGCVideoInfo.a)) {
          localUGCVideoInfo1.bytes_video_md5.set(ByteStringMicro.copyFromUtf8(localUGCVideoInfo.a));
        }
        if (!TextUtils.isEmpty(localUGCVideoInfo.f)) {
          localUGCVideoInfo1.bytes_uuid.set(ByteStringMicro.copyFromUtf8(localUGCVideoInfo.f));
        }
        if (!TextUtils.isEmpty(localUGCVideoInfo.c)) {
          localUGCVideoInfo1.bytes_pic_md5.set(ByteStringMicro.copyFromUtf8(localUGCVideoInfo.c));
        }
        if (!TextUtils.isEmpty(localUGCVideoInfo.d)) {
          localUGCVideoInfo1.bytes_pic_url.set(ByteStringMicro.copyFromUtf8(localUGCVideoInfo.d));
        }
        if (!TextUtils.isEmpty(localUGCVideoInfo.e)) {
          localUGCVideoInfo1.bytes_title.set(ByteStringMicro.copyFromUtf8(localUGCVideoInfo.e));
        }
        if (!TextUtils.isEmpty(localUGCVideoInfo.l)) {
          localUGCVideoInfo1.bytes_uniq_id.set(ByteStringMicro.copyFromUtf8(localUGCVideoInfo.l));
        }
        if (!TextUtils.isEmpty(localUGCVideoInfo.n)) {
          localUGCVideoInfo1.bytes_share_url.set(ByteStringMicro.copyFromUtf8(localUGCVideoInfo.n));
        }
        if (!TextUtils.isEmpty(localUGCVideoInfo.p)) {
          localUGCVideoInfo1.bytes_vid.set(ByteStringMicro.copyFromUtf8(localUGCVideoInfo.p));
        }
        localUGCVideoInfo1.uint32_create_time.set(localUGCVideoInfo.m);
        localUGCVideoInfo1.uint32_busi_type.set(localUGCVideoInfo.o);
        localUGCVideoInfo1.uint32_pic_height.set(localUGCVideoInfo.k);
        localUGCVideoInfo1.uint32_pic_width.set(localUGCVideoInfo.j);
        localUGCVideoInfo1.uint32_video_height.set(localUGCVideoInfo.i);
        localUGCVideoInfo1.uint32_video_width.set(localUGCVideoInfo.h);
        localArrayList.add(localUGCVideoInfo1);
      }
      paramUGCFeedsInfo1.msg_ugc_video_info_list.set(localArrayList);
    }
  }
  
  private static void c(UGCFeedsInfo paramUGCFeedsInfo, articlesummary.UGCFeedsInfo paramUGCFeedsInfo1)
  {
    ArrayList localArrayList = paramUGCFeedsInfo.b;
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      localArrayList = new ArrayList();
      paramUGCFeedsInfo = paramUGCFeedsInfo.b.iterator();
      while (paramUGCFeedsInfo.hasNext())
      {
        UGCPicInfo localUGCPicInfo = (UGCPicInfo)paramUGCFeedsInfo.next();
        articlesummary.UGCPicInfo localUGCPicInfo1 = new articlesummary.UGCPicInfo();
        localUGCPicInfo1.uint32_pic_width.set(localUGCPicInfo.a);
        localUGCPicInfo1.uint32_pic_height.set(localUGCPicInfo.b);
        if (!TextUtils.isEmpty(localUGCPicInfo.d)) {
          localUGCPicInfo1.bytes_pic_url.set(ByteStringMicro.copyFromUtf8(localUGCPicInfo.d));
        }
        if (!TextUtils.isEmpty(localUGCPicInfo.c)) {
          localUGCPicInfo1.bytes_pic_md5.set(ByteStringMicro.copyFromUtf8(localUGCPicInfo.c));
        }
        if (!TextUtils.isEmpty(localUGCPicInfo.e)) {
          localUGCPicInfo1.bytes_thumbnail_url.set(ByteStringMicro.copyFromUtf8(localUGCPicInfo.e));
        }
        localUGCPicInfo1.is_animation.set(localUGCPicInfo.f);
        localArrayList.add(localUGCPicInfo1);
      }
      paramUGCFeedsInfo1.msg_ugc_pic_info_list.set(localArrayList);
    }
  }
  
  private static void d(UGCFeedsInfo paramUGCFeedsInfo, articlesummary.UGCFeedsInfo paramUGCFeedsInfo1)
  {
    paramUGCFeedsInfo1.enum_ugc_feeds_card_type.set(paramUGCFeedsInfo.a);
    paramUGCFeedsInfo1.enum_ugc_feeds_src.set(paramUGCFeedsInfo.i);
    paramUGCFeedsInfo1.uint64_cuin.set(paramUGCFeedsInfo.e);
    if (!TextUtils.isEmpty(paramUGCFeedsInfo.f)) {
      paramUGCFeedsInfo1.bytes_ugc_comments.set(ByteStringMicro.copyFromUtf8(paramUGCFeedsInfo.f));
    }
    if (paramUGCFeedsInfo.h != null) {
      paramUGCFeedsInfo1.msg_at_multi_level.set(paramUGCFeedsInfo.h.b());
    }
    if (paramUGCFeedsInfo.k != null) {
      paramUGCFeedsInfo1.account_profile.set(paramUGCFeedsInfo.k.a());
    }
    if (!TextUtils.isEmpty(paramUGCFeedsInfo.j)) {
      paramUGCFeedsInfo1.bytes_jump_url.set(ByteStringMicro.copyFromUtf8(paramUGCFeedsInfo.j));
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("UGCFeedsInfo{ugcFeedsCardType=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", ugcPicInfos=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", ugcVideoInfos=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", ugcVoiceInfos=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", cuin=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", ugcComments='");
    localStringBuilder.append(this.f);
    localStringBuilder.append('\'');
    localStringBuilder.append(", nickName='");
    localStringBuilder.append(this.g);
    localStringBuilder.append('\'');
    localStringBuilder.append(", ugcAtComments=");
    localStringBuilder.append(this.h);
    localStringBuilder.append(", ugcFeedsSrc=");
    localStringBuilder.append(this.i);
    localStringBuilder.append(", jumpUrl='");
    localStringBuilder.append(this.j);
    localStringBuilder.append('\'');
    localStringBuilder.append(", accountProfileInfo=");
    localStringBuilder.append(this.k);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.feeds.entity.UGCFeedsInfo
 * JD-Core Version:    0.7.0.1
 */