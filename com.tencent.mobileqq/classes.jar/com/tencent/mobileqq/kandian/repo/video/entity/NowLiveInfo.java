package com.tencent.mobileqq.kandian.repo.video.entity;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.oidb.articlesummary.feeds_info.NowLiveInfo;
import tencent.im.oidb.nowlive.nowlive.AnchorInfo;
import tencent.im.oidb.nowlive.nowlive.LiveInfo;
import tencent.im.oidb.nowlive.nowlive.MixInfo;
import tencent.im.oidb.nowlive.nowlive.VideoInfo;

public class NowLiveInfo
{
  private int a;
  private NowLiveInfo.MixInfo b = new NowLiveInfo.MixInfo();
  private int c;
  
  public feeds_info.NowLiveInfo a()
  {
    feeds_info.NowLiveInfo localNowLiveInfo = new feeds_info.NowLiveInfo();
    localNowLiveInfo.msg_type.set(this.a);
    localNowLiveInfo.uint32_timestamp.set(this.c);
    nowlive.MixInfo localMixInfo = new nowlive.MixInfo();
    Object localObject = new nowlive.AnchorInfo();
    ((nowlive.AnchorInfo)localObject).fans.set(NowLiveInfo.MixInfo.AnchorInfo.a(NowLiveInfo.MixInfo.a(this.b)));
    ((nowlive.AnchorInfo)localObject).status.set(NowLiveInfo.MixInfo.AnchorInfo.b(NowLiveInfo.MixInfo.a(this.b)));
    ((nowlive.AnchorInfo)localObject).uin.set(NowLiveInfo.MixInfo.AnchorInfo.c(NowLiveInfo.MixInfo.a(this.b)));
    localMixInfo.anchor_info.set((MessageMicro)localObject);
    localObject = new nowlive.LiveInfo();
    if (NowLiveInfo.MixInfo.LiveInfo.a(NowLiveInfo.MixInfo.b(this.b)) != null) {
      ((nowlive.LiveInfo)localObject).live_url.set(NowLiveInfo.MixInfo.LiveInfo.a(NowLiveInfo.MixInfo.b(this.b)));
    }
    if (NowLiveInfo.MixInfo.LiveInfo.b(NowLiveInfo.MixInfo.b(this.b)) != null) {
      ((nowlive.LiveInfo)localObject).room_name.set(NowLiveInfo.MixInfo.LiveInfo.b(NowLiveInfo.MixInfo.b(this.b)));
    }
    if (NowLiveInfo.MixInfo.LiveInfo.c(NowLiveInfo.MixInfo.b(this.b)) != null) {
      ((nowlive.LiveInfo)localObject).room_cover.set(NowLiveInfo.MixInfo.LiveInfo.c(NowLiveInfo.MixInfo.b(this.b)));
    }
    ((nowlive.LiveInfo)localObject).live_statue.set(NowLiveInfo.MixInfo.LiveInfo.d(NowLiveInfo.MixInfo.b(this.b)));
    ((nowlive.LiveInfo)localObject).audience.set(NowLiveInfo.MixInfo.LiveInfo.e(NowLiveInfo.MixInfo.b(this.b)));
    if (NowLiveInfo.MixInfo.LiveInfo.f(NowLiveInfo.MixInfo.b(this.b)) != null) {
      ((nowlive.LiveInfo)localObject).vid.set(ByteStringMicro.copyFromUtf8(NowLiveInfo.MixInfo.LiveInfo.f(NowLiveInfo.MixInfo.b(this.b))));
    } else {
      ((nowlive.LiveInfo)localObject).vid.set(ByteStringMicro.EMPTY);
    }
    localMixInfo.live_info.set((MessageMicro)localObject);
    localObject = new nowlive.VideoInfo();
    if (NowLiveInfo.MixInfo.VideoInfo.a(NowLiveInfo.MixInfo.c(this.b)) != null) {
      ((nowlive.VideoInfo)localObject).video_url.set(NowLiveInfo.MixInfo.VideoInfo.a(NowLiveInfo.MixInfo.c(this.b)));
    }
    if (NowLiveInfo.MixInfo.VideoInfo.b(NowLiveInfo.MixInfo.c(this.b)) != null) {
      ((nowlive.VideoInfo)localObject).video_cover_url.set(NowLiveInfo.MixInfo.VideoInfo.b(NowLiveInfo.MixInfo.c(this.b)));
    }
    if (NowLiveInfo.MixInfo.VideoInfo.c(NowLiveInfo.MixInfo.c(this.b)) != null) {
      ((nowlive.VideoInfo)localObject).vid.set(ByteStringMicro.copyFromUtf8(NowLiveInfo.MixInfo.VideoInfo.c(NowLiveInfo.MixInfo.c(this.b))));
    } else {
      ((nowlive.VideoInfo)localObject).vid.set(ByteStringMicro.EMPTY);
    }
    localMixInfo.video_info.set((MessageMicro)localObject);
    localNowLiveInfo.mix_info.set(localMixInfo);
    return localNowLiveInfo;
  }
  
  public void a(NowLiveInfo.MixInfo paramMixInfo)
  {
    this.b = paramMixInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.video.entity.NowLiveInfo
 * JD-Core Version:    0.7.0.1
 */