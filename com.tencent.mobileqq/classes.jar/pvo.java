import android.os.Handler;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import tencent.im.oidb.cmd0xee9.oidb_cmd0xee9.AccountInfo;
import tencent.im.oidb.cmd0xee9.oidb_cmd0xee9.ClientInfo;
import tencent.im.oidb.cmd0xee9.oidb_cmd0xee9.LiveStatus;
import tencent.im.oidb.cmd0xee9.oidb_cmd0xee9.ReqBody;
import tencent.im.oidb.cmd0xee9.oidb_cmd0xee9.RspBody;
import tencent.im.oidb.cmd0xee9.oidb_cmd0xee9.UserInfoItem;
import tencent.im.oidb.cmd0xee9.oidb_cmd0xee9.UserInfoOption;

public class pvo
  extends pwd
{
  private List<pvq> a;
  
  public pvo(AppInterface paramAppInterface, EntityManager paramEntityManager, ExecutorService paramExecutorService, qli paramqli, Handler paramHandler)
  {
    super(paramAppInterface, paramEntityManager, paramExecutorService, paramqli, paramHandler);
  }
  
  private ToServiceMsg a(List<Long> paramList)
  {
    oidb_cmd0xee9.ReqBody localReqBody = new oidb_cmd0xee9.ReqBody();
    Object localObject = new oidb_cmd0xee9.ClientInfo();
    ((oidb_cmd0xee9.ClientInfo)localObject).uint32_req_client_type.set(1);
    ((oidb_cmd0xee9.ClientInfo)localObject).str_version.set(AppSetting.f());
    localReqBody.client_info.set((MessageMicro)localObject);
    localObject = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Long localLong = (Long)paramList.next();
      oidb_cmd0xee9.AccountInfo localAccountInfo = new oidb_cmd0xee9.AccountInfo();
      localAccountInfo.uint64_uin.set(localLong.longValue());
      ((List)localObject).add(localAccountInfo);
    }
    localReqBody.rpt_acount_info.set((List)localObject);
    paramList = new oidb_cmd0xee9.UserInfoOption();
    paramList.uint32_live_status.set(1);
    localReqBody.msg_user_option.set(paramList);
    return qlk.a("OidbSvc.0xee9", 3817, 2, localReqBody.toByteArray());
  }
  
  private void a(int paramInt, List<pvr> paramList)
  {
    if (this.a != null)
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        ((pvq)localIterator.next()).a(paramInt, paramList);
      }
    }
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramToServiceMsg = new oidb_cmd0xee9.RspBody();
    int i = qlk.a(paramFromServiceMsg, paramObject, paramToServiceMsg);
    if (i != 0)
    {
      a(i, null);
      return;
    }
    paramFromServiceMsg = qlg.a(paramToServiceMsg.rpt_msg_user_info);
    if ((paramFromServiceMsg == null) || (paramFromServiceMsg.size() <= 0))
    {
      a(i, null);
      return;
    }
    paramToServiceMsg = new ArrayList();
    paramFromServiceMsg = paramFromServiceMsg.iterator();
    while (paramFromServiceMsg.hasNext())
    {
      paramObject = (oidb_cmd0xee9.UserInfoItem)paramFromServiceMsg.next();
      oidb_cmd0xee9.LiveStatus localLiveStatus = (oidb_cmd0xee9.LiveStatus)psy.a(paramObject.msg_live_status, null);
      pvr localpvr = new pvr();
      localpvr.jdField_a_of_type_Long = qlg.a(paramObject.uint64_uin, 0L);
      localpvr.jdField_a_of_type_Pvp = new pvp();
      if (localLiveStatus != null)
      {
        localpvr.jdField_a_of_type_Pvp.jdField_a_of_type_Int = qlg.a(localLiveStatus.uint32_liveing);
        localpvr.jdField_a_of_type_Pvp.jdField_a_of_type_Long = qlg.a(localLiveStatus.uint64_live_time, 0L);
        localpvr.jdField_a_of_type_Pvp.jdField_b_of_type_Int = qlg.a(localLiveStatus.uint32_source, 0);
        localpvr.jdField_a_of_type_Pvp.jdField_a_of_type_JavaLangString = qlg.a(localLiveStatus.str_account, null);
        localpvr.jdField_a_of_type_Pvp.jdField_b_of_type_JavaLangString = qlg.a(localLiveStatus.str_roomid, null);
        localpvr.jdField_a_of_type_Pvp.c = qlg.a(localLiveStatus.rowkey, null);
        localpvr.jdField_a_of_type_Pvp.d = qlg.a(localLiveStatus.str_url, null);
      }
      paramToServiceMsg.add(localpvr);
      if (QLog.isColorLevel()) {
        QLog.d("RIJLiveStatusModule", 2, "handleUGCAccountCreateResponsePkg: userInfoItem=" + localpvr);
      }
    }
    a(i, paramToServiceMsg);
  }
  
  public void a()
  {
    this.a = null;
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0xee9")) {
      b(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
  
  public void a(List<Long> paramList)
  {
    a(a(paramList));
  }
  
  public void a(pvq parampvq)
  {
    if (this.a == null) {
      this.a = new ArrayList();
    }
    this.a.add(parampvq);
  }
  
  public void b(pvq parampvq)
  {
    if (this.a != null) {
      this.a.remove(parampvq);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pvo
 * JD-Core Version:    0.7.0.1
 */