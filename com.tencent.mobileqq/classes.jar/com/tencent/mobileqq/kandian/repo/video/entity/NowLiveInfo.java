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
  private int jdField_a_of_type_Int;
  private NowLiveInfo.MixInfo jdField_a_of_type_ComTencentMobileqqKandianRepoVideoEntityNowLiveInfo$MixInfo = new NowLiveInfo.MixInfo();
  private int b;
  
  public feeds_info.NowLiveInfo a()
  {
    feeds_info.NowLiveInfo localNowLiveInfo = new feeds_info.NowLiveInfo();
    localNowLiveInfo.msg_type.set(this.jdField_a_of_type_Int);
    localNowLiveInfo.uint32_timestamp.set(this.b);
    nowlive.MixInfo localMixInfo = new nowlive.MixInfo();
    Object localObject = new nowlive.AnchorInfo();
    ((nowlive.AnchorInfo)localObject).fans.set(NowLiveInfo.MixInfo.AnchorInfo.a(NowLiveInfo.MixInfo.a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoVideoEntityNowLiveInfo$MixInfo)));
    ((nowlive.AnchorInfo)localObject).status.set(NowLiveInfo.MixInfo.AnchorInfo.a(NowLiveInfo.MixInfo.a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoVideoEntityNowLiveInfo$MixInfo)));
    ((nowlive.AnchorInfo)localObject).uin.set(NowLiveInfo.MixInfo.AnchorInfo.b(NowLiveInfo.MixInfo.a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoVideoEntityNowLiveInfo$MixInfo)));
    localMixInfo.anchor_info.set((MessageMicro)localObject);
    localObject = new nowlive.LiveInfo();
    if (NowLiveInfo.MixInfo.LiveInfo.a(NowLiveInfo.MixInfo.a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoVideoEntityNowLiveInfo$MixInfo)) != null) {
      ((nowlive.LiveInfo)localObject).live_url.set(NowLiveInfo.MixInfo.LiveInfo.a(NowLiveInfo.MixInfo.a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoVideoEntityNowLiveInfo$MixInfo)));
    }
    if (NowLiveInfo.MixInfo.LiveInfo.b(NowLiveInfo.MixInfo.a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoVideoEntityNowLiveInfo$MixInfo)) != null) {
      ((nowlive.LiveInfo)localObject).room_name.set(NowLiveInfo.MixInfo.LiveInfo.b(NowLiveInfo.MixInfo.a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoVideoEntityNowLiveInfo$MixInfo)));
    }
    if (NowLiveInfo.MixInfo.LiveInfo.c(NowLiveInfo.MixInfo.a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoVideoEntityNowLiveInfo$MixInfo)) != null) {
      ((nowlive.LiveInfo)localObject).room_cover.set(NowLiveInfo.MixInfo.LiveInfo.c(NowLiveInfo.MixInfo.a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoVideoEntityNowLiveInfo$MixInfo)));
    }
    ((nowlive.LiveInfo)localObject).live_statue.set(NowLiveInfo.MixInfo.LiveInfo.a(NowLiveInfo.MixInfo.a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoVideoEntityNowLiveInfo$MixInfo)));
    ((nowlive.LiveInfo)localObject).audience.set(NowLiveInfo.MixInfo.LiveInfo.b(NowLiveInfo.MixInfo.a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoVideoEntityNowLiveInfo$MixInfo)));
    if (NowLiveInfo.MixInfo.LiveInfo.d(NowLiveInfo.MixInfo.a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoVideoEntityNowLiveInfo$MixInfo)) != null) {
      ((nowlive.LiveInfo)localObject).vid.set(ByteStringMicro.copyFromUtf8(NowLiveInfo.MixInfo.LiveInfo.d(NowLiveInfo.MixInfo.a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoVideoEntityNowLiveInfo$MixInfo))));
    } else {
      ((nowlive.LiveInfo)localObject).vid.set(ByteStringMicro.EMPTY);
    }
    localMixInfo.live_info.set((MessageMicro)localObject);
    localObject = new nowlive.VideoInfo();
    if (NowLiveInfo.MixInfo.VideoInfo.a(NowLiveInfo.MixInfo.a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoVideoEntityNowLiveInfo$MixInfo)) != null) {
      ((nowlive.VideoInfo)localObject).video_url.set(NowLiveInfo.MixInfo.VideoInfo.a(NowLiveInfo.MixInfo.a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoVideoEntityNowLiveInfo$MixInfo)));
    }
    if (NowLiveInfo.MixInfo.VideoInfo.b(NowLiveInfo.MixInfo.a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoVideoEntityNowLiveInfo$MixInfo)) != null) {
      ((nowlive.VideoInfo)localObject).video_cover_url.set(NowLiveInfo.MixInfo.VideoInfo.b(NowLiveInfo.MixInfo.a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoVideoEntityNowLiveInfo$MixInfo)));
    }
    if (NowLiveInfo.MixInfo.VideoInfo.c(NowLiveInfo.MixInfo.a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoVideoEntityNowLiveInfo$MixInfo)) != null) {
      ((nowlive.VideoInfo)localObject).vid.set(ByteStringMicro.copyFromUtf8(NowLiveInfo.MixInfo.VideoInfo.c(NowLiveInfo.MixInfo.a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoVideoEntityNowLiveInfo$MixInfo))));
    } else {
      ((nowlive.VideoInfo)localObject).vid.set(ByteStringMicro.EMPTY);
    }
    localMixInfo.video_info.set((MessageMicro)localObject);
    localNowLiveInfo.mix_info.set(localMixInfo);
    return localNowLiveInfo;
  }
  
  public void a(NowLiveInfo.MixInfo paramMixInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoVideoEntityNowLiveInfo$MixInfo = paramMixInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.video.entity.NowLiveInfo
 * JD-Core Version:    0.7.0.1
 */