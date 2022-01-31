import android.os.Handler;
import com.tencent.biz.pubaccount.readinjoy.model.InterestLabelInfoModule.1;
import com.tencent.biz.pubaccount.readinjoy.model.InterestLabelInfoModule.3;
import com.tencent.biz.pubaccount.readinjoy.model.InterestLabelInfoModule.4;
import com.tencent.biz.pubaccount.readinjoy.model.InterestLabelInfoModule.5;
import com.tencent.biz.pubaccount.readinjoy.struct.InterestLabelInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutorService;
import tencent.im.oidb.cmd0x6e4.oidb_cmd0x6e4.RspBody;
import tencent.im.oidb.cmd0x6e5.oidb_cmd0x6e5.ReqBody;
import tencent.im.oidb.cmd0x6e5.oidb_cmd0x6e5.RspBody;

public class pay
  extends pbh
{
  private HashMap<Integer, InterestLabelInfo> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private List<InterestLabelInfo> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  
  public pay(AppInterface paramAppInterface, aukn paramaukn, ExecutorService paramExecutorService, pou parampou, Handler paramHandler)
  {
    super(paramAppInterface, paramaukn, paramExecutorService, parampou, paramHandler);
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Object localObject = null;
    oidb_cmd0x6e5.RspBody localRspBody = new oidb_cmd0x6e5.RspBody();
    boolean bool = false;
    if (pow.a(paramFromServiceMsg, paramObject, localRspBody) == 0)
    {
      if (localRspBody.uint64_uin.has()) {
        localRspBody.uint64_uin.get();
      }
      if ((!localRspBody.rpt_uint32_default_interest_label_id_list.has()) || (localRspBody.rpt_uint32_default_interest_label_id_list.get() == null)) {
        break label195;
      }
    }
    label195:
    for (paramFromServiceMsg = localRspBody.rpt_uint32_default_interest_label_id_list.get();; paramFromServiceMsg = null)
    {
      paramToServiceMsg = localObject;
      if (localRspBody.rpt_interest_label_list.has())
      {
        paramToServiceMsg = localObject;
        if (localRspBody.rpt_interest_label_list.get() != null) {
          paramToServiceMsg = pot.a(localRspBody.rpt_interest_label_list.get(), paramFromServiceMsg);
        }
      }
      if ((this.jdField_a_of_type_Boolean) && ((!localRspBody.rpt_uint64_last_interest_label_id_list.has()) || (localRspBody.rpt_uint64_last_interest_label_id_list.get() == null) || (localRspBody.rpt_uint64_last_interest_label_id_list.get().size() <= 0)))
      {
        osm.a().a(true);
        bool = true;
      }
      for (;;)
      {
        a(bool, paramToServiceMsg);
        return;
        paramToServiceMsg = pot.a(null, null);
        continue;
        bool = true;
      }
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    oidb_cmd0x6e5.ReqBody localReqBody = new oidb_cmd0x6e5.ReqBody();
    long l = Long.valueOf(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin()).longValue();
    localReqBody.uint64_uin.set(l);
    localReqBody.uint32_req_all_interest_label_list.set(paramInt1);
    localReqBody.uint32_req_default_interest_label_id_list.set(paramInt2);
    localReqBody.uint32_req_last_interest_label_id_list.set(paramInt3);
    this.jdField_a_of_type_Boolean = paramBoolean;
    a(pow.a("OidbSvc.0x6e5", 1765, 0, localReqBody.toByteArray()));
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0x6e5")) {
      c(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
    while (!paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0x6e4")) {
      return;
    }
    b(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
  
  public void a(List<InterestLabelInfo> paramList)
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.post(new InterestLabelInfoModule.5(this, paramList));
    }
  }
  
  public void a(boolean paramBoolean, List<InterestLabelInfo> paramList)
  {
    if (paramList != null) {
      this.jdField_a_of_type_AndroidOsHandler.post(new InterestLabelInfoModule.3(this, paramList));
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_JavaUtilConcurrentExecutorService.execute(new InterestLabelInfoModule.1(this));
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new InterestLabelInfoModule.4(this, paramInt));
  }
  
  public void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    b(pow.a(paramFromServiceMsg, paramObject, new oidb_cmd0x6e4.RspBody()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pay
 * JD-Core Version:    0.7.0.1
 */