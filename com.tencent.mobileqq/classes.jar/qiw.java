import android.os.Handler;
import com.tencent.biz.pubaccount.readinjoy.model.handler.RIJGetPrivacyListHandler.1;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.concurrent.ExecutorService;
import tencent.im.oidb.cmd0xc32.oidb_cmd0xc32.GetVisibleListReqBody;
import tencent.im.oidb.cmd0xc32.oidb_cmd0xc32.GetVisibleListRspBody;
import tencent.im.oidb.cmd0xc32.oidb_cmd0xc32.ReqBody;
import tencent.im.oidb.cmd0xc32.oidb_cmd0xc32.RspBody;

public class qiw
  extends qii
{
  public qiw(qep paramqep, Handler paramHandler, AppInterface paramAppInterface, EntityManager paramEntityManager, qxn paramqxn, ExecutorService paramExecutorService)
  {
    super(paramqep, paramHandler, paramAppInterface, paramEntityManager, paramqxn, paramExecutorService);
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2)
  {
    QLog.d("RIJGetPrivacyListHandler", 1, " request0xc32GetPrivacyList | feedsid " + paramLong + " | startIndex " + paramInt1);
    Object localObject = new oidb_cmd0xc32.ReqBody();
    ((oidb_cmd0xc32.ReqBody)localObject).enum_op.set(2);
    oidb_cmd0xc32.GetVisibleListReqBody localGetVisibleListReqBody = new oidb_cmd0xc32.GetVisibleListReqBody();
    localGetVisibleListReqBody.uint64_feeds_id.set(paramLong);
    localGetVisibleListReqBody.uint32_start_ix.set(paramInt1);
    localGetVisibleListReqBody.uint32_want_num.set(paramInt2);
    ((oidb_cmd0xc32.ReqBody)localObject).msg_get_req_body.set(localGetVisibleListReqBody);
    localObject = qxp.a("OidbSvc.0xc32", 3122, 2, ((oidb_cmd0xc32.ReqBody)localObject).toByteArray());
    this.jdField_a_of_type_Qep.a((ToServiceMsg)localObject);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    long l = 0L;
    paramToServiceMsg = null;
    int i = -1;
    int k = 0;
    oidb_cmd0xc32.RspBody localRspBody = new oidb_cmd0xc32.RspBody();
    int m = qxp.a(paramFromServiceMsg, paramObject, localRspBody);
    QLog.d("RIJGetPrivacyListHandler", 1, "handle0x32GetPrivacyList | retCode " + m);
    int j;
    boolean bool;
    if ((m == 0) && (localRspBody.msg_get_rsp_body.has()))
    {
      paramFromServiceMsg = (oidb_cmd0xc32.GetVisibleListRspBody)localRspBody.msg_get_rsp_body.get();
      if (paramFromServiceMsg.rpt_uint64_visible_uins.has()) {
        paramToServiceMsg = paramFromServiceMsg.rpt_uint64_visible_uins.get();
      }
      if (paramFromServiceMsg.uint64_feeds_id.has()) {
        l = paramFromServiceMsg.uint64_feeds_id.get();
      }
      if (paramFromServiceMsg.uint32_next_ix.has()) {
        i = paramFromServiceMsg.uint32_next_ix.get();
      }
      if (paramFromServiceMsg.uint32_total_count.has())
      {
        j = paramFromServiceMsg.uint32_total_count.get();
        if ((!paramFromServiceMsg.uint32_is_end.has()) || (paramFromServiceMsg.uint32_is_end.get() != 0)) {
          break label295;
        }
        bool = true;
        label181:
        paramFromServiceMsg = new StringBuilder().append("handle0x32GetPrivacyList | feedsId ").append(l).append("| totalCnt ").append(j).append(" | nextPageStartIndex ").append(i).append(" | hasNextPage ").append(bool).append("| uinList size ");
        if (paramToServiceMsg != null) {
          k = paramToServiceMsg.size();
        }
        QLog.d("RIJGetPrivacyListHandler", 1, k);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidOsHandler.post(new RIJGetPrivacyListHandler.1(this, m, l, paramToServiceMsg, i, j, bool));
      return;
      j = 0;
      break;
      label295:
      bool = false;
      break label181;
      bool = false;
      j = 0;
      paramToServiceMsg = null;
      i = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qiw
 * JD-Core Version:    0.7.0.1
 */