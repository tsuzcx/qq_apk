import android.os.Handler;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyDianDianEntranceModule.1;
import com.tencent.biz.pubaccount.readinjoy.view.RecommendFeedsDiandianEntranceManager;
import com.tencent.biz.pubaccount.readinjoy.view.RecommendFeedsDiandianEntranceManager.EntranceIconInfo;
import com.tencent.biz.pubaccount.readinjoy.view.RecommendFeedsDiandianEntranceManager.ExtraInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
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

public class pqd
  extends pqj
{
  private long a;
  
  public pqd(AppInterface paramAppInterface, EntityManager paramEntityManager, ExecutorService paramExecutorService, qfo paramqfo, Handler paramHandler)
  {
    super(paramAppInterface, paramEntityManager, paramExecutorService, paramqfo, paramHandler);
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (bduy.a()) {}
    int i;
    do
    {
      return;
      paramToServiceMsg = new oidb_0x6cf.RspBody();
      i = qfq.a(paramFromServiceMsg, paramObject, paramToServiceMsg);
      QLog.d("ReadInJoyDianDianEntranceModule", 1, "handleColumn0x6cf, result=" + i);
    } while ((i != 0) || (!paramToServiceMsg.msg_entrance_download_info.has()) || (paramToServiceMsg.msg_entrance_download_info.get() == null));
    paramFromServiceMsg = (oidb_0x6cf.EntranceDownloadInfo)paramToServiceMsg.msg_entrance_download_info.get();
    paramObject = new taz();
    if (paramToServiceMsg.req_article_summary.has())
    {
      paramToServiceMsg = (oidb_0x6cf.ArticleSummary)paramToServiceMsg.req_article_summary.get();
      if ((paramToServiceMsg != null) && (paramToServiceMsg.bytes_video_report_info.has())) {
        paramObject.e = paramToServiceMsg.bytes_video_report_info.get().toStringUtf8();
      }
    }
    paramObject.a(paramFromServiceMsg);
    bkdz.a().post(new ReadInJoyDianDianEntranceModule.1(this, paramObject));
  }
  
  public void a()
  {
    if (bnrf.e() != 6) {}
    while (bduy.a()) {
      return;
    }
    if (System.currentTimeMillis() - this.a < 5000L)
    {
      QLog.d("ReadInJoyDianDianEntranceModule", 1, "requestColumn0x6cf ignore! too frequently");
      return;
    }
    oidb_0x6cf.ReqBody localReqBody = new oidb_0x6cf.ReqBody();
    localReqBody.uint32_req_source.set(30);
    localReqBody.uint32_req_sim_type.set(bnrf.c());
    int i = ((Integer)bnrf.a("key_sp_is_readinjoy_youngster", Integer.valueOf(0))).intValue();
    localReqBody.uint32_youngster_status.set(i);
    localReqBody.uint32_req_recommend_flag.set(odp.a());
    localReqBody.uint64_uin.set(ozs.a());
    String str = (String)bnrf.a(taz.f, "");
    if (!TextUtils.isEmpty(str)) {
      localReqBody.bytes_entrance_cookie.set(ByteStringMicro.copyFromUtf8(str));
    }
    a(qfq.a("OidbSvc.0x6cf", 1743, 1, localReqBody.toByteArray()));
    this.a = System.currentTimeMillis();
    QLog.d("ReadInJoyDianDianEntranceModule", 1, "requestColumn0x6cf");
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0xdcb")) {
      b(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
    while (!paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0x6cf")) {
      return;
    }
    c(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
  
  public void b(int paramInt)
  {
    QLog.d("ReadInJoyDianDianEntranceModule", 1, "requestIconRefreshInfo | reqFeedType " + paramInt);
    Object localObject = new oidb_cmd0xdcb.ReqBody();
    oidb_cmd0xdcb.ReqParam localReqParam = new oidb_cmd0xdcb.ReqParam();
    localReqParam.uint32_req_type.set(paramInt);
    ((oidb_cmd0xdcb.ReqBody)localObject).msg_req_param.set(localReqParam);
    localObject = qfq.a("OidbSvc.0xdcb", 3531, 0, ((oidb_cmd0xdcb.ReqBody)localObject).toByteArray());
    ((ToServiceMsg)localObject).getAttributes().put("req_feed_type", Integer.valueOf(paramInt));
    a((ToServiceMsg)localObject);
  }
  
  public void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    oidb_cmd0xdcb.RspBody localRspBody = new oidb_cmd0xdcb.RspBody();
    int i = ((Integer)paramToServiceMsg.getAttributes().get("req_feed_type")).intValue();
    int j = qfq.a(paramFromServiceMsg, paramObject, localRspBody);
    QLog.d("ReadInJoyDianDianEntranceModule", 1, "handleIconRefreshInfoRsp | retCode " + j + " ; reqFeedsType " + i);
    paramToServiceMsg = new RecommendFeedsDiandianEntranceManager.EntranceIconInfo();
    paramToServiceMsg.jdField_a_of_type_Int = i;
    paramFromServiceMsg = new RecommendFeedsDiandianEntranceManager.ExtraInfo();
    if ((j == 0) && (localRspBody.msg_icon_info.has()))
    {
      paramObject = (oidb_cmd0xdcb.IconInfo)localRspBody.msg_icon_info.get();
      if (paramObject.feeds_msg_icon_url.has()) {
        paramToServiceMsg.jdField_a_of_type_JavaLangString = paramObject.feeds_msg_icon_url.get();
      }
      if (paramObject.feeds_default_icon_url.has()) {
        paramToServiceMsg.b = paramObject.feeds_default_icon_url.get();
      }
      if (paramObject.uint32_is_use_gif.has()) {
        if (paramObject.uint32_is_use_gif.get() == 0) {
          break label296;
        }
      }
    }
    label296:
    for (boolean bool = true;; bool = false)
    {
      paramToServiceMsg.jdField_a_of_type_Boolean = bool;
      if (paramObject.str_jump_schema.has()) {
        paramToServiceMsg.c = paramObject.str_jump_schema.get();
      }
      paramToServiceMsg.jdField_a_of_type_Int = i;
      if ((localRspBody.msg_extra_info.has()) && (localRspBody.msg_extra_info.str_report_json.has())) {
        paramFromServiceMsg.jdField_a_of_type_JavaLangString = localRspBody.msg_extra_info.str_report_json.get();
      }
      QLog.d("ReadInJoyDianDianEntranceModule", 1, "handleIconRefreshInfoRsp | EntranceIconInfo " + paramToServiceMsg);
      RecommendFeedsDiandianEntranceManager.a().a(paramToServiceMsg);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pqd
 * JD-Core Version:    0.7.0.1
 */