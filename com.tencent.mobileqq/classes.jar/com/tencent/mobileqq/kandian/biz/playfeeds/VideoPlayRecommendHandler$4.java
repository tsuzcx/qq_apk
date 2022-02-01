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
      ((oidb_0x6cf.ReqBody)localObject).uint64_uin.set(this.jdField_a_of_type_Long);
      ((oidb_0x6cf.ReqBody)localObject).uint32_req_source.set(this.jdField_a_of_type_Int);
      ((oidb_0x6cf.ReqBody)localObject).uint32_req_times.set(this.jdField_b_of_type_Int);
      ((oidb_0x6cf.ReqBody)localObject).uint32_req_network.set(VideoPlayRecommendHandler.a(this.this$0));
      ((oidb_0x6cf.ReqBody)localObject).uint32_req_os.set(1);
      ((oidb_0x6cf.ReqBody)localObject).uint32_req_sim_type.set(RIJCUKingCardUtils.a());
      ((oidb_0x6cf.ReqBody)localObject).uint32_req_sub_source.set(4);
      ByteStringMicro localByteStringMicro;
      if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
      {
        localByteStringMicro = ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_JavaLangString);
        ((oidb_0x6cf.ReqBody)localObject).bytes_inner_id.set(localByteStringMicro);
      }
      if (this.jdField_b_of_type_Long != -1L) {
        ((oidb_0x6cf.ReqBody)localObject).uint32_req_topic_id.set((int)this.jdField_b_of_type_Long);
      }
      if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
      {
        localByteStringMicro = ByteStringMicro.copyFromUtf8(this.jdField_b_of_type_JavaLangString);
        ((oidb_0x6cf.ReqBody)localObject).bytes_req_web.set(localByteStringMicro);
      }
      if (!TextUtils.isEmpty(this.c))
      {
        localByteStringMicro = ByteStringMicro.copyFromUtf8(this.c);
        ((oidb_0x6cf.ReqBody)localObject).bytes_cookie.set(localByteStringMicro);
      }
      localObject = this.this$0.makeOIDBPkg("OidbSvc.0x6cf", 1743, 2, ((oidb_0x6cf.ReqBody)localObject).toByteArray());
      ((ToServiceMsg)localObject).addAttribute("VALUE_OBSERVER_TAG", Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoPlayRecommendObserver.hashCode()));
      this.this$0.sendPbReq((ToServiceMsg)localObject);
      if (!QLog.isColorLevel()) {
        break label376;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getPolymericRecommendVideo: videoFromType: ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
      ((StringBuilder)localObject).append(", polymericTopicId: ");
      ((StringBuilder)localObject).append(this.jdField_b_of_type_Long);
      ((StringBuilder)localObject).append(", requestTime: ");
      ((StringBuilder)localObject).append(this.jdField_b_of_type_Int);
      ((StringBuilder)localObject).append(", cookie: ");
      ((StringBuilder)localObject).append(this.c);
      ((StringBuilder)localObject).append(", commonWebData: ");
      ((StringBuilder)localObject).append(this.jdField_b_of_type_JavaLangString);
      ((StringBuilder)localObject).append("articleId: ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject).append(", uin: ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Long);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoPlayRecommendHandler.4
 * JD-Core Version:    0.7.0.1
 */