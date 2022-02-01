package com.tencent.mobileqq.kandian.repo.diandian;

import android.os.Handler;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.kandian.base.msf.ReadInJoyMSFService;
import com.tencent.mobileqq.kandian.base.msf.ReadInJoyOidbHelper;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.mobileqq.kandian.glue.video.VideoPlayRecommendHelper;
import com.tencent.mobileqq.kandian.repo.common.RIJCUKingCardUtils;
import com.tencent.mobileqq.kandian.repo.common.ReadInJoyEngineModule;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.qav.thread.ThreadManager;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.ArticleSummary;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.EntranceDownloadInfo;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.ReqBody;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.RspBody;
import tencent.im.oidb.cmd0xdcb.oidb_cmd0xdcb.ExtraInfo;
import tencent.im.oidb.cmd0xdcb.oidb_cmd0xdcb.IconInfo;
import tencent.im.oidb.cmd0xdcb.oidb_cmd0xdcb.ReqBody;
import tencent.im.oidb.cmd0xdcb.oidb_cmd0xdcb.ReqParam;
import tencent.im.oidb.cmd0xdcb.oidb_cmd0xdcb.RspBody;

public class ReadInJoyDianDianEntranceModule
  extends ReadInJoyEngineModule
{
  private ReadInJoyDianDianEntranceModule.OnIconRefreshCallback a = null;
  private long b;
  
  public ReadInJoyDianDianEntranceModule(AppInterface paramAppInterface, EntityManager paramEntityManager, ExecutorService paramExecutorService, ReadInJoyMSFService paramReadInJoyMSFService, Handler paramHandler)
  {
    super(paramAppInterface, paramEntityManager, paramExecutorService, paramReadInJoyMSFService, paramHandler);
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (StudyModeManager.h()) {
      return;
    }
    paramToServiceMsg = new oidb_0x6cf.RspBody();
    int i = ReadInJoyOidbHelper.a(paramFromServiceMsg, paramObject, paramToServiceMsg);
    paramFromServiceMsg = new StringBuilder();
    paramFromServiceMsg.append("handleColumn0x6cf, result=");
    paramFromServiceMsg.append(i);
    QLog.d("ReadInJoyDianDianEntranceModule", 1, paramFromServiceMsg.toString());
    if ((i == 0) && (paramToServiceMsg.msg_entrance_download_info.has()) && (paramToServiceMsg.msg_entrance_download_info.get() != null))
    {
      paramFromServiceMsg = (oidb_0x6cf.EntranceDownloadInfo)paramToServiceMsg.msg_entrance_download_info.get();
      paramObject = new RIJColumnDataSource();
      if (paramToServiceMsg.req_article_summary.has())
      {
        paramToServiceMsg = (oidb_0x6cf.ArticleSummary)paramToServiceMsg.req_article_summary.get();
        if ((paramToServiceMsg != null) && (paramToServiceMsg.bytes_video_report_info.has())) {
          paramObject.g = paramToServiceMsg.bytes_video_report_info.get().toStringUtf8();
        }
      }
      paramObject.a(paramFromServiceMsg);
      ThreadManager.a().post(new ReadInJoyDianDianEntranceModule.1(this, paramObject));
    }
  }
  
  public void a(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("requestIconRefreshInfo | reqFeedType ");
    ((StringBuilder)localObject).append(paramInt);
    QLog.d("ReadInJoyDianDianEntranceModule", 1, ((StringBuilder)localObject).toString());
    localObject = new oidb_cmd0xdcb.ReqBody();
    oidb_cmd0xdcb.ReqParam localReqParam = new oidb_cmd0xdcb.ReqParam();
    localReqParam.uint32_req_type.set(paramInt);
    ((oidb_cmd0xdcb.ReqBody)localObject).msg_req_param.set(localReqParam);
    localObject = ReadInJoyOidbHelper.a("OidbSvc.0xdcb", 3531, 0, ((oidb_cmd0xdcb.ReqBody)localObject).toByteArray());
    ((ToServiceMsg)localObject).getAttributes().put("req_feed_type", Integer.valueOf(paramInt));
    sendPbReq((ToServiceMsg)localObject);
  }
  
  public void a(ReadInJoyDianDianEntranceModule.OnIconRefreshCallback paramOnIconRefreshCallback)
  {
    this.a = paramOnIconRefreshCallback;
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    oidb_cmd0xdcb.RspBody localRspBody = new oidb_cmd0xdcb.RspBody();
    int i = ((Integer)paramToServiceMsg.getAttributes().get("req_feed_type")).intValue();
    int j = ReadInJoyOidbHelper.a(paramFromServiceMsg, paramObject, localRspBody);
    paramToServiceMsg = new StringBuilder();
    paramToServiceMsg.append("handleIconRefreshInfoRsp | retCode ");
    paramToServiceMsg.append(j);
    paramToServiceMsg.append(" ; reqFeedsType ");
    paramToServiceMsg.append(i);
    QLog.d("ReadInJoyDianDianEntranceModule", 1, paramToServiceMsg.toString());
    paramToServiceMsg = new EntranceIconInfo();
    paramToServiceMsg.a = i;
    paramFromServiceMsg = new ExtraInfo();
    if ((j == 0) && (localRspBody.msg_icon_info.has()))
    {
      paramObject = (oidb_cmd0xdcb.IconInfo)localRspBody.msg_icon_info.get();
      if (paramObject.feeds_msg_icon_url.has()) {
        paramToServiceMsg.b = paramObject.feeds_msg_icon_url.get();
      }
      if (paramObject.feeds_default_icon_url.has()) {
        paramToServiceMsg.c = paramObject.feeds_default_icon_url.get();
      }
      if (paramObject.uint32_is_use_gif.has())
      {
        boolean bool;
        if (paramObject.uint32_is_use_gif.get() != 0) {
          bool = true;
        } else {
          bool = false;
        }
        paramToServiceMsg.e = bool;
      }
      if (paramObject.str_jump_schema.has()) {
        paramToServiceMsg.d = paramObject.str_jump_schema.get();
      }
      if (paramObject.str_nickname.has()) {
        paramToServiceMsg.g = paramObject.str_nickname.get();
      }
      if (paramObject.uint32_op_type.has()) {
        paramToServiceMsg.h = paramObject.uint32_op_type.get();
      }
      paramToServiceMsg.a = i;
      if ((localRspBody.msg_extra_info.has()) && (localRspBody.msg_extra_info.str_report_json.has())) {
        paramFromServiceMsg.a = localRspBody.msg_extra_info.str_report_json.get();
      }
    }
    paramFromServiceMsg = new StringBuilder();
    paramFromServiceMsg.append("handleIconRefreshInfoRsp | EntranceIconInfo ");
    paramFromServiceMsg.append(paramToServiceMsg);
    QLog.d("ReadInJoyDianDianEntranceModule", 1, paramFromServiceMsg.toString());
    paramFromServiceMsg = this.a;
    if (paramFromServiceMsg != null) {
      paramFromServiceMsg.a(paramToServiceMsg);
    }
  }
  
  public void b(int paramInt)
  {
    if (paramInt != 6) {
      return;
    }
    if (StudyModeManager.h()) {
      return;
    }
    if (System.currentTimeMillis() - this.b < 5000L)
    {
      QLog.d("ReadInJoyDianDianEntranceModule", 1, "requestColumn0x6cf ignore! too frequently");
      return;
    }
    oidb_0x6cf.ReqBody localReqBody = new oidb_0x6cf.ReqBody();
    localReqBody.uint32_req_source.set(30);
    localReqBody.uint32_req_sim_type.set(RIJCUKingCardUtils.a());
    paramInt = ((Integer)RIJSPUtils.b("key_sp_is_readinjoy_youngster", Integer.valueOf(0))).intValue();
    localReqBody.uint32_youngster_status.set(paramInt);
    localReqBody.uint32_req_recommend_flag.set(VideoPlayRecommendHelper.a());
    localReqBody.uint64_uin.set(RIJQQAppInterfaceUtil.c());
    String str = (String)RIJSPUtils.b(RIJColumnDataSource.h, "");
    if (!TextUtils.isEmpty(str)) {
      localReqBody.bytes_entrance_cookie.set(ByteStringMicro.copyFromUtf8(str));
    }
    sendPbReq(ReadInJoyOidbHelper.a("OidbSvc.0x6cf", 1743, 1, localReqBody.toByteArray()));
    this.b = System.currentTimeMillis();
    QLog.d("ReadInJoyDianDianEntranceModule", 1, "requestColumn0x6cf");
  }
  
  public void b(ReadInJoyDianDianEntranceModule.OnIconRefreshCallback paramOnIconRefreshCallback)
  {
    this.a = null;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0xdcb"))
    {
      a(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0x6cf")) {
      b(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
  
  public void unInitialize() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.diandian.ReadInJoyDianDianEntranceModule
 * JD-Core Version:    0.7.0.1
 */