import android.os.Handler;
import com.tencent.biz.pubaccount.readinjoy.view.RecommendFeedsDiandianEntranceManager;
import com.tencent.biz.pubaccount.readinjoy.view.RecommendFeedsDiandianEntranceManager.EntranceIconInfo;
import com.tencent.biz.pubaccount.readinjoy.view.RecommendFeedsDiandianEntranceManager.ExtraInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import tencent.im.oidb.cmd0xdcb.oidb_cmd0xdcb.ExtraInfo;
import tencent.im.oidb.cmd0xdcb.oidb_cmd0xdcb.IconInfo;
import tencent.im.oidb.cmd0xdcb.oidb_cmd0xdcb.ReqBody;
import tencent.im.oidb.cmd0xdcb.oidb_cmd0xdcb.ReqParam;
import tencent.im.oidb.cmd0xdcb.oidb_cmd0xdcb.RspBody;

public class pgk
  extends pgp
{
  public pgk(AppInterface paramAppInterface, awgf paramawgf, ExecutorService paramExecutorService, puz parampuz, Handler paramHandler)
  {
    super(paramAppInterface, paramawgf, paramExecutorService, parampuz, paramHandler);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0xdcb")) {
      b(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
  
  public void b(int paramInt)
  {
    QLog.d("ReadInJoyDianDianEntranceModule", 1, "requestIconRefreshInfo | reqFeedType " + paramInt);
    Object localObject = new oidb_cmd0xdcb.ReqBody();
    oidb_cmd0xdcb.ReqParam localReqParam = new oidb_cmd0xdcb.ReqParam();
    localReqParam.uint32_req_type.set(paramInt);
    ((oidb_cmd0xdcb.ReqBody)localObject).msg_req_param.set(localReqParam);
    localObject = pvb.a("OidbSvc.0xdcb", 3531, 0, ((oidb_cmd0xdcb.ReqBody)localObject).toByteArray());
    ((ToServiceMsg)localObject).getAttributes().put("req_feed_type", Integer.valueOf(paramInt));
    a((ToServiceMsg)localObject);
  }
  
  public void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    oidb_cmd0xdcb.RspBody localRspBody = new oidb_cmd0xdcb.RspBody();
    int i = ((Integer)paramToServiceMsg.getAttributes().get("req_feed_type")).intValue();
    int j = pvb.a(paramFromServiceMsg, paramObject, localRspBody);
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
          break label292;
        }
      }
    }
    label292:
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     pgk
 * JD-Core Version:    0.7.0.1
 */