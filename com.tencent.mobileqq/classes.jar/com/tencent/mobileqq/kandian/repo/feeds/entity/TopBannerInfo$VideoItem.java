package com.tencent.mobileqq.kandian.repo.feeds.entity;

import android.text.TextUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.oidb.cmd0xbc9.oidb_cmd0xbc9.BannerItem;
import tencent.im.oidb.cmd0xbc9.oidb_cmd0xbc9.VideoBannerItem;

public class TopBannerInfo$VideoItem
  extends TopBannerInfo.BaseItem
{
  public String k = "";
  public int l;
  public int m;
  public int n;
  public String o = "";
  public int p;
  public String q = "";
  public String r = "";
  public long s;
  public int t;
  public long u;
  public int v;
  
  public TopBannerInfo$VideoItem()
  {
    super(2);
  }
  
  public static TopBannerInfo.BaseItem c(oidb_cmd0xbc9.BannerItem paramBannerItem)
  {
    if (!paramBannerItem.msg_video_banner_item.has()) {
      return null;
    }
    oidb_cmd0xbc9.VideoBannerItem localVideoBannerItem = (oidb_cmd0xbc9.VideoBannerItem)paramBannerItem.msg_video_banner_item.get();
    VideoItem localVideoItem = new VideoItem();
    if (localVideoBannerItem.bytes_share_url.has()) {
      localVideoItem.k = localVideoBannerItem.bytes_share_url.get().toStringUtf8();
    }
    if (localVideoBannerItem.uint32_video_duration.has()) {
      localVideoItem.l = localVideoBannerItem.uint32_video_duration.get();
    }
    if (localVideoBannerItem.uint32_video_width.has()) {
      localVideoItem.m = localVideoBannerItem.uint32_video_width.get();
    }
    if (localVideoBannerItem.uint32_video_height.has()) {
      localVideoItem.n = localVideoBannerItem.uint32_video_height.get();
    }
    if (localVideoBannerItem.bytes_video_vid.has()) {
      localVideoItem.o = localVideoBannerItem.bytes_video_vid.get().toStringUtf8();
    }
    if (localVideoBannerItem.bytes_video_cover.has()) {
      localVideoItem.e = localVideoBannerItem.bytes_video_cover.get().toStringUtf8();
    }
    if (localVideoBannerItem.bytes_inner_uinque_id.has()) {
      localVideoItem.g = localVideoBannerItem.bytes_inner_uinque_id.get().toStringUtf8();
    }
    if (localVideoBannerItem.uint32_busi_type.has()) {
      localVideoItem.p = localVideoBannerItem.uint32_busi_type.get();
    }
    if (localVideoBannerItem.bytes_title.has()) {
      localVideoItem.r = localVideoBannerItem.bytes_title.get().toStringUtf8();
    }
    if (localVideoBannerItem.bytes_account_name.has()) {
      localVideoItem.q = localVideoBannerItem.bytes_account_name.get().toStringUtf8();
    }
    if (localVideoBannerItem.uint64_account_uin.has()) {
      localVideoItem.s = localVideoBannerItem.uint64_account_uin.get();
    }
    if (localVideoBannerItem.uint32_is_ugc.has()) {
      localVideoItem.t = localVideoBannerItem.uint32_is_ugc.get();
    }
    if (localVideoBannerItem.uint64_feeds_id.has()) {
      localVideoItem.u = localVideoBannerItem.uint64_feeds_id.get();
    }
    if (localVideoBannerItem.uint32_feeds_type.has()) {
      localVideoItem.v = localVideoBannerItem.uint32_feeds_type.get();
    }
    a(localVideoItem, paramBannerItem);
    a(paramBannerItem, localVideoItem);
    return localVideoItem;
  }
  
  public oidb_cmd0xbc9.BannerItem a()
  {
    oidb_cmd0xbc9.BannerItem localBannerItem = super.a();
    oidb_cmd0xbc9.VideoBannerItem localVideoBannerItem = new oidb_cmd0xbc9.VideoBannerItem();
    if (!TextUtils.isEmpty(this.k)) {
      localVideoBannerItem.bytes_share_url.set(ByteStringMicro.copyFromUtf8(this.k));
    }
    localVideoBannerItem.uint32_video_duration.set(this.l);
    localVideoBannerItem.uint32_video_width.set(this.m);
    localVideoBannerItem.uint32_video_height.set(this.n);
    if (!TextUtils.isEmpty(this.o)) {
      localVideoBannerItem.bytes_video_vid.set(ByteStringMicro.copyFromUtf8(this.o));
    }
    if (!TextUtils.isEmpty(this.e)) {
      localVideoBannerItem.bytes_video_cover.set(ByteStringMicro.copyFromUtf8(this.e));
    }
    if (!TextUtils.isEmpty(this.g)) {
      localVideoBannerItem.bytes_inner_uinque_id.set(ByteStringMicro.copyFromUtf8(this.g));
    }
    localVideoBannerItem.uint32_busi_type.set(this.p);
    if (!TextUtils.isEmpty(this.r)) {
      localVideoBannerItem.bytes_title.set(ByteStringMicro.copyFromUtf8(this.r));
    }
    if (!TextUtils.isEmpty(this.q)) {
      localVideoBannerItem.bytes_account_name.set(ByteStringMicro.copyFromUtf8(this.q));
    }
    localVideoBannerItem.uint64_account_uin.set(this.s);
    localVideoBannerItem.uint32_is_ugc.set(this.t);
    localVideoBannerItem.uint64_feeds_id.set(this.u);
    localVideoBannerItem.uint32_feeds_type.set(this.v);
    localBannerItem.msg_video_banner_item.set(localVideoBannerItem);
    return localBannerItem;
  }
  
  public boolean b()
  {
    return this.t == 1;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(super.toString());
    localStringBuilder.append(" vid: ");
    localStringBuilder.append(this.o);
    localStringBuilder.append(" puin : ");
    localStringBuilder.append(this.s);
    localStringBuilder.append(" busitype ");
    localStringBuilder.append(this.p);
    localStringBuilder.append(" accountName : ");
    localStringBuilder.append(this.q);
    localStringBuilder.append("  shareUrl : ");
    localStringBuilder.append(this.k);
    localStringBuilder.append(" isUgc ");
    localStringBuilder.append(this.t);
    localStringBuilder.append(" feedsId ");
    localStringBuilder.append(this.u);
    localStringBuilder.append(" feedsType ");
    localStringBuilder.append(this.v);
    localStringBuilder.append(" videoTitle: ");
    localStringBuilder.append(this.r);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.feeds.entity.TopBannerInfo.VideoItem
 * JD-Core Version:    0.7.0.1
 */