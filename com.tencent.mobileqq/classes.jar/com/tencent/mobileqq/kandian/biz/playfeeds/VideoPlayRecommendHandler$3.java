package com.tencent.mobileqq.kandian.biz.playfeeds;

import android.text.TextUtils;
import com.tencent.mobileqq.kandian.base.msf.ReadInJoyOidbHelper;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;
import com.tencent.mobileqq.kandian.repo.common.RIJCUKingCardUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.ToServiceMsg;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.ReqBody;

class VideoPlayRecommendHandler$3
  implements Runnable
{
  VideoPlayRecommendHandler$3(VideoPlayRecommendHandler paramVideoPlayRecommendHandler, long paramLong, int paramInt, String paramString, VideoPlayRecommendObserver paramVideoPlayRecommendObserver, VideoInfo paramVideoInfo) {}
  
  public void run()
  {
    Object localObject = new oidb_0x6cf.ReqBody();
    ((oidb_0x6cf.ReqBody)localObject).uint64_uin.set(this.a);
    ((oidb_0x6cf.ReqBody)localObject).uint32_req_source.set(this.b);
    ((oidb_0x6cf.ReqBody)localObject).uint32_req_sub_source.set(6);
    ((oidb_0x6cf.ReqBody)localObject).uint32_req_sim_type.set(RIJCUKingCardUtils.a());
    if (!TextUtils.isEmpty(this.c)) {
      ((oidb_0x6cf.ReqBody)localObject).bytes_req_range_cookie.set(ByteStringMicro.copyFromUtf8(this.c));
    }
    localObject = ReadInJoyOidbHelper.a("OidbSvc.0x6cf", 1743, 3, ((oidb_0x6cf.ReqBody)localObject).toByteArray());
    ((ToServiceMsg)localObject).addAttribute("VALUE_OBSERVER_TAG", Integer.valueOf(this.d.hashCode()));
    ((ToServiceMsg)localObject).addAttribute("VALUE_REQUEST_VIDEO_ARTICLE_ID", this.e.l);
    this.this$0.sendPbReq((ToServiceMsg)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoPlayRecommendHandler.3
 * JD-Core Version:    0.7.0.1
 */