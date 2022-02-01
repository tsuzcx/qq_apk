package com.tencent.mobileqq.kandian.repo.video.entity;

import android.text.TextUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.oidb.articlesummary.articlesummary.PGCVideoInfo;

public class PGCVideoInfo
{
  public String a;
  public String b;
  public String c;
  public String d;
  public String e;
  public int f;
  public int g;
  public long h;
  public boolean i;
  public String j;
  public String k;
  public String l;
  
  public PGCVideoInfo() {}
  
  public PGCVideoInfo(articlesummary.PGCVideoInfo paramPGCVideoInfo)
  {
    if (paramPGCVideoInfo.bytes_pic_md5.has()) {
      this.c = paramPGCVideoInfo.bytes_pic_md5.get().toStringUtf8();
    }
    if (paramPGCVideoInfo.bytes_pic_url.has()) {
      this.d = paramPGCVideoInfo.bytes_pic_url.get().toStringUtf8();
    }
    if (paramPGCVideoInfo.bytes_vid.has()) {
      this.e = paramPGCVideoInfo.bytes_vid.get().toStringUtf8();
    }
    if (paramPGCVideoInfo.bytes_video_url.has()) {
      this.b = paramPGCVideoInfo.bytes_video_url.get().toStringUtf8();
    }
    if (paramPGCVideoInfo.bytes_video_md5.has()) {
      this.a = paramPGCVideoInfo.bytes_video_md5.get().toStringUtf8();
    }
    if (paramPGCVideoInfo.uint32_duration.has()) {
      this.f = paramPGCVideoInfo.uint32_duration.get();
    }
    if (paramPGCVideoInfo.uint32_busi_type.has()) {
      this.g = paramPGCVideoInfo.uint32_busi_type.get();
    }
    if (paramPGCVideoInfo.uint64_play_num.has()) {
      this.h = paramPGCVideoInfo.uint64_play_num.get();
    }
    if (paramPGCVideoInfo.video_auto_play.has()) {
      this.i = paramPGCVideoInfo.video_auto_play.get();
    }
    if (paramPGCVideoInfo.title.has()) {
      this.k = paramPGCVideoInfo.title.get();
    }
    if (paramPGCVideoInfo.rowkey.has()) {
      this.j = paramPGCVideoInfo.rowkey.get();
    }
    if (paramPGCVideoInfo.jump_url.has()) {
      this.l = paramPGCVideoInfo.jump_url.get();
    }
  }
  
  public articlesummary.PGCVideoInfo a()
  {
    articlesummary.PGCVideoInfo localPGCVideoInfo = new articlesummary.PGCVideoInfo();
    if (this.l != null) {
      localPGCVideoInfo.jump_url.set(this.l);
    }
    if (!TextUtils.isEmpty(this.a)) {
      localPGCVideoInfo.bytes_video_md5.set(ByteStringMicro.copyFromUtf8(this.a));
    }
    if (!TextUtils.isEmpty(this.e)) {
      localPGCVideoInfo.bytes_vid.set(ByteStringMicro.copyFromUtf8(this.e));
    }
    if (!TextUtils.isEmpty(this.j)) {
      localPGCVideoInfo.rowkey.set(this.j);
    }
    if (!TextUtils.isEmpty(this.k)) {
      localPGCVideoInfo.title.set(this.k);
    }
    localPGCVideoInfo.video_auto_play.set(this.i);
    localPGCVideoInfo.uint64_play_num.set(this.h);
    localPGCVideoInfo.uint32_busi_type.set(this.g);
    if (!TextUtils.isEmpty(this.c)) {
      localPGCVideoInfo.bytes_pic_md5.set(ByteStringMicro.copyFromUtf8(this.c));
    }
    if (!TextUtils.isEmpty(this.d)) {
      localPGCVideoInfo.bytes_pic_url.set(ByteStringMicro.copyFromUtf8(this.d));
    }
    if (!TextUtils.isEmpty(this.b)) {
      localPGCVideoInfo.bytes_video_url.set(ByteStringMicro.copyFromUtf8(this.b));
    }
    localPGCVideoInfo.uint32_duration.set(this.f);
    return localPGCVideoInfo;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("PGCVideoInfo{video_md5='");
    localStringBuilder.append(this.a);
    localStringBuilder.append('\'');
    localStringBuilder.append(", video_url='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append(", picMd5='");
    localStringBuilder.append(this.c);
    localStringBuilder.append('\'');
    localStringBuilder.append(", picUrl='");
    localStringBuilder.append(this.d);
    localStringBuilder.append('\'');
    localStringBuilder.append(", vid='");
    localStringBuilder.append(this.e);
    localStringBuilder.append('\'');
    localStringBuilder.append(", duration='");
    localStringBuilder.append(this.f);
    localStringBuilder.append('\'');
    localStringBuilder.append(", busi_type='");
    localStringBuilder.append(this.g);
    localStringBuilder.append('\'');
    localStringBuilder.append(", playCount='");
    localStringBuilder.append(this.h);
    localStringBuilder.append('\'');
    localStringBuilder.append(", isVideoAutoPlay='");
    localStringBuilder.append(this.i);
    localStringBuilder.append('\'');
    localStringBuilder.append(", rowkey='");
    localStringBuilder.append(this.j);
    localStringBuilder.append('\'');
    localStringBuilder.append(", title='");
    localStringBuilder.append(this.k);
    localStringBuilder.append('\'');
    localStringBuilder.append(", jumpUrl='");
    localStringBuilder.append(this.l);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.video.entity.PGCVideoInfo
 * JD-Core Version:    0.7.0.1
 */