package com.tencent.mobileqq.kandian.biz.playfeeds;

import android.text.TextUtils;
import com.tencent.mobileqq.kandian.repo.common.RIJCUKingCardUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.ReqBody;

class VideoPlayRecommendHandler$4
  implements Runnable
{
  public void run()
  {
    try
    {
      Object localObject = new oidb_0x6cf.ReqBody();
      ((oidb_0x6cf.ReqBody)localObject).uint64_uin.set(this.a);
      ((oidb_0x6cf.ReqBody)localObject).uint32_req_source.set(this.b);
      ((oidb_0x6cf.ReqBody)localObject).uint32_req_times.set(this.c);
      ((oidb_0x6cf.ReqBody)localObject).uint32_req_network.set(VideoPlayRecommendHandler.a(this.this$0));
      ((oidb_0x6cf.ReqBody)localObject).uint32_req_os.set(1);
      ((oidb_0x6cf.ReqBody)localObject).uint32_req_sim_type.set(RIJCUKingCardUtils.a());
      ((oidb_0x6cf.ReqBody)localObject).uint32_req_sub_source.set(4);
      ByteStringMicro localByteStringMicro;
      if (!TextUtils.isEmpty(this.d))
      {
        localByteStringMicro = ByteStringMicro.copyFromUtf8(this.d);
        ((oidb_0x6cf.ReqBody)localObject).bytes_inner_id.set(localByteStringMicro);
      }
      if (this.e != -1L) {
        ((oidb_0x6cf.ReqBody)localObject).uint32_req_topic_id.set((int)this.e);
      }
      if (!TextUtils.isEmpty(this.f))
      {
        localByteStringMicro = ByteStringMicro.copyFromUtf8(this.f);
        ((oidb_0x6cf.ReqBody)localObject).bytes_req_web.set(localByteStringMicro);
      }
      if (!TextUtils.isEmpty(this.g))
      {
        localByteStringMicro = ByteStringMicro.copyFromUtf8(this.g);
        ((oidb_0x6cf.ReqBody)localObject).bytes_cookie.set(localByteStringMicro);
      }
      localObject = this.this$0.makeOIDBPkg("OidbSvc.0x6cf", 1743, 2, ((oidb_0x6cf.ReqBody)localObject).toByteArray());
      ((ToServiceMsg)localObject).addAttribute("VALUE_OBSERVER_TAG", Integer.valueOf(this.h.hashCode()));
      this.this$0.sendPbReq((ToServiceMsg)localObject);
      if (!QLog.isColorLevel()) {
        break label376;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getPolymericRecommendVideo: videoFromType: ");
      ((StringBuilder)localObject).append(this.b);
      ((StringBuilder)localObject).append(", polymericTopicId: ");
      ((StringBuilder)localObject).append(this.e);
      ((StringBuilder)localObject).append(", requestTime: ");
      ((StringBuilder)localObject).append(this.c);
      ((StringBuilder)localObject).append(", cookie: ");
      ((StringBuilder)localObject).append(this.g);
      ((StringBuilder)localObject).append(", commonWebData: ");
      ((StringBuilder)localObject).append(this.f);
      ((StringBuilder)localObject).append("articleId: ");
      ((StringBuilder)localObject).append(this.d);
      ((StringBuilder)localObject).append(", uin: ");
      ((StringBuilder)localObject).append(this.a);
      QLog.d("Q.pubaccount.video.VideoPlayRecommendHandler", 2, ((StringBuilder)localObject).toString());
      return;
    }
    catch (Exception localException)
    {
      label362:
      label376:
      break label362;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.VideoPlayRecommendHandler", 2, "error in making packing, service type is 2");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoPlayRecommendHandler.4
 * JD-Core Version:    0.7.0.1
 */