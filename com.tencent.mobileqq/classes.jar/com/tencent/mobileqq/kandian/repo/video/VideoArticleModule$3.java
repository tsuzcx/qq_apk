package com.tencent.mobileqq.kandian.repo.video;

import android.text.TextUtils;
import com.tencent.mobileqq.kandian.base.msf.ReadInJoyOidbHelper;
import com.tencent.mobileqq.kandian.base.utils.RIJLogUtil;
import com.tencent.mobileqq.kandian.repo.common.RIJCUKingCardUtils;
import com.tencent.mobileqq.kandian.repo.feeds.ArticleInfoModuleUtils;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ReadInJoyRequestParams.Request0xbedParams;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ReadInJoyRequestParams.Request0xbedParams.InnerMsg;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.cmd0xbed.oidb_cmd0xbed.InnerMsg;
import tencent.im.oidb.cmd0xbed.oidb_cmd0xbed.ReqBody;
import tencent.im.oidb.cmd0xbed.oidb_cmd0xbed.ReqChannelPara;

class VideoArticleModule$3
  implements Runnable
{
  public void run()
  {
    try
    {
      Object localObject1 = new oidb_cmd0xbed.ReqBody();
      localObject2 = new oidb_cmd0xbed.ReqChannelPara();
      ((oidb_cmd0xbed.ReqChannelPara)localObject2).uint32_channel_id.set(this.a.a);
      ((oidb_cmd0xbed.ReqChannelPara)localObject2).uint32_channel_type.set(this.a.b);
      if (this.a.c != -1L) {
        ((oidb_cmd0xbed.ReqChannelPara)localObject2).uint64_begin_recommend_seq.set(this.a.c);
      }
      if (this.a.d != -1L) {
        ((oidb_cmd0xbed.ReqChannelPara)localObject2).uint64_end_recommend_seq.set(this.a.d);
      }
      if (!TextUtils.isEmpty(this.a.e)) {
        ((oidb_cmd0xbed.ReqChannelPara)localObject2).bytes_begin_recommend_rowkey.set(ByteStringMicro.copyFromUtf8(this.a.e));
      }
      if (!TextUtils.isEmpty(this.a.f)) {
        ((oidb_cmd0xbed.ReqChannelPara)localObject2).bytes_end_recommend_rowkey.set(ByteStringMicro.copyFromUtf8(this.a.f));
      }
      ((oidb_cmd0xbed.ReqChannelPara)localObject2).uint64_begin_collection_id.set(this.a.g);
      ((oidb_cmd0xbed.ReqChannelPara)localObject2).uint64_end_collection_id.set(this.a.h);
      localObject3 = DeviceInfoUtil.b();
      if (!TextUtils.isEmpty((CharSequence)localObject3)) {
        ((oidb_cmd0xbed.ReqChannelPara)localObject2).bytes_device_id.set(ByteStringMicro.copyFromUtf8((String)localObject3));
      }
      ((oidb_cmd0xbed.ReqChannelPara)localObject2).uint32_update_times.set(this.a.i);
      ((oidb_cmd0xbed.ReqChannelPara)localObject2).uint32_sim_type.set(RIJCUKingCardUtils.a());
      ((oidb_cmd0xbed.ReqChannelPara)localObject2).uint32_network_type.set(ArticleInfoModuleUtils.a());
      if (this.a.j != null) {
        ((oidb_cmd0xbed.ReqChannelPara)localObject2).bytes_business_info.set(ByteStringMicro.copyFrom(this.a.j));
      }
      if ((this.a.k != null) && (this.a.k.size() > 0))
      {
        ((oidb_cmd0xbed.ReqChannelPara)localObject2).rpt_subscription_article_list.set(this.a.k);
        localObject3 = new ArrayList();
        Iterator localIterator = this.a.k.iterator();
        while (localIterator.hasNext())
        {
          Object localObject4 = (Long)localIterator.next();
          oidb_cmd0xbed.InnerMsg localInnerMsg = new oidb_cmd0xbed.InnerMsg();
          if (this.a.l > 0) {
            localInnerMsg.uint32_jump_src_type.set(this.a.l);
          } else {
            localInnerMsg.uint32_jump_src_type.set(1);
          }
          localInnerMsg.bytes_inner_uniq_id.set(ByteStringMicro.copyFromUtf8(String.valueOf(localObject4)));
          if (!TextUtils.isEmpty(this.a.m.f))
          {
            localInnerMsg.bytes_push_context.set(ByteStringMicro.copyFromUtf8(this.a.m.f));
            if (QLog.isColorLevel())
            {
              localObject4 = VideoArticleModule.a;
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("add push contenxt:");
              localStringBuilder.append(this.a.m.f);
              QLog.d((String)localObject4, 2, localStringBuilder.toString());
            }
          }
          localInnerMsg.uint64_algorithm_id.set(this.a.m.c);
          localInnerMsg.uint32_strategy_id.set(this.a.m.d);
          ((List)localObject3).add(localInnerMsg);
        }
        ((oidb_cmd0xbed.ReqChannelPara)localObject2).rpt_inner_msg_list.set((List)localObject3);
      }
      ((oidb_cmd0xbed.ReqBody)localObject1).reqChannelPara.set((MessageMicro)localObject2);
      localObject1 = ReadInJoyOidbHelper.a("OidbSvc.0xbed", 3053, 1, ((oidb_cmd0xbed.ReqBody)localObject1).toByteArray());
      if (localObject1 != null)
      {
        ((ToServiceMsg)localObject1).getAttributes().put("channelID", Integer.valueOf(this.a.a));
        ((ToServiceMsg)localObject1).getAttributes().put("BeginSeq", Long.valueOf(this.a.c));
        ((ToServiceMsg)localObject1).getAttributes().put("EndSeq", Long.valueOf(this.a.d));
        ((ToServiceMsg)localObject1).getAttributes().put("CountOfRequest_0xbed", Integer.valueOf(1));
      }
      this.this$0.sendPbReq((ToServiceMsg)localObject1);
      return;
    }
    catch (Throwable localThrowable)
    {
      Object localObject2;
      Object localObject3;
      if (QLog.isColorLevel())
      {
        localObject2 = VideoArticleModule.a;
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("request0xbedSendWeiShiArticleInfoList makeParams:");
        ((StringBuilder)localObject3).append(RIJLogUtil.a(localThrowable));
        QLog.e((String)localObject2, 2, ((StringBuilder)localObject3).toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.video.VideoArticleModule.3
 * JD-Core Version:    0.7.0.1
 */