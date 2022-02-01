import android.os.Handler;
import com.tencent.TMG.utils.QLog;
import com.tencent.biz.pubaccount.readinjoy.model.FollowListInfoModule.1;
import com.tencent.biz.pubaccount.readinjoy.model.FollowListInfoModule.2;
import com.tencent.biz.pubaccount.readinjoy.model.FollowListInfoModule.3;
import com.tencent.biz.pubaccount.readinjoy.model.FollowListInfoModule.4;
import com.tencent.biz.pubaccount.readinjoy.model.FollowListInfoModule.5;
import com.tencent.biz.pubaccount.readinjoy.model.FollowListInfoModule.7;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import tencent.im.oidb.cmd0x977.oidb_cmd0x977.FollowListInfo;
import tencent.im.oidb.cmd0x977.oidb_cmd0x977.FollowStatusInfo;
import tencent.im.oidb.cmd0x977.oidb_cmd0x977.ReqBody;
import tencent.im.oidb.cmd0x977.oidb_cmd0x977.ReqFollowPara;
import tencent.im.oidb.cmd0x977.oidb_cmd0x977.RspBody;
import tencent.im.oidb.cmd0x977.oidb_cmd0x977.RspFollowData;

public class puw
  extends pwd
{
  private String jdField_a_of_type_JavaLangString = "";
  private List<rcz> jdField_a_of_type_JavaUtilList = new ArrayList();
  private Map<Long, rcz> jdField_a_of_type_JavaUtilMap = new HashMap();
  private final CopyOnWriteArrayList<puy> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  private boolean jdField_a_of_type_Boolean = true;
  private boolean b;
  private String j = "";
  
  public puw(AppInterface paramAppInterface, EntityManager paramEntityManager, ExecutorService paramExecutorService, qli paramqli, Handler paramHandler)
  {
    super(paramAppInterface, paramEntityManager, paramExecutorService, paramqli, paramHandler);
  }
  
  private List<rcz> a(List<oidb_cmd0x977.FollowStatusInfo> paramList)
  {
    return rgp.a(paramList, new pux(this));
  }
  
  public static List<rcz> a(List<Long> paramList, puy parampuy)
  {
    puw localpuw = pkm.a().a();
    ArrayList localArrayList = new ArrayList();
    if (localpuw != null) {
      localArrayList.addAll(localpuw.b(paramList, parampuy));
    }
    return localArrayList;
  }
  
  private void a(int paramInt, Integer paramInteger)
  {
    QLog.e("FollowingInfoModule", 1, "[handleGetFollowMemberListFromServer] result = " + paramInt);
    if (paramInteger.intValue() == 3) {
      this.jdField_a_of_type_AndroidOsHandler.post(new FollowListInfoModule.1(this));
    }
    while (paramInteger.intValue() != 2) {
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new FollowListInfoModule.2(this));
  }
  
  private void a(int paramInt, List<oidb_cmd0x977.FollowStatusInfo> paramList, long paramLong, boolean paramBoolean)
  {
    paramList = a(paramList).iterator();
    while (paramList.hasNext())
    {
      rcz localrcz = (rcz)paramList.next();
      if (localrcz != null) {
        this.jdField_a_of_type_JavaUtilMap.put(localrcz.a(), localrcz);
      }
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new FollowListInfoModule.3(this, paramInt));
  }
  
  private void a(int paramInt, Map<Long, rcz> paramMap)
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      if (localIterator.hasNext()) {
        ((puy)localIterator.next()).a(paramInt, paramMap);
      }
    }
  }
  
  private void a(int paramInt, oidb_cmd0x977.RspBody paramRspBody, boolean paramBoolean)
  {
    if (paramRspBody == null) {
      return;
    }
    oidb_cmd0x977.FollowListInfo localFollowListInfo = paramRspBody.msg_rsp_follow_data.msg_follow_list;
    List localList = localFollowListInfo.rpt_follow_status_info.get();
    String str = paramRspBody.msg_rsp_follow_data.bytes_cookie.get().toStringUtf8();
    long l = paramRspBody.msg_rsp_follow_data.uint64_total_count.get();
    if (paramRspBody.msg_rsp_follow_data.uint32_is_no_more_data.get() == 0) {}
    for (boolean bool = true; paramBoolean; bool = false)
    {
      a(paramInt, localList, l, bool);
      return;
    }
    a(localFollowListInfo, localList, str, l, bool);
  }
  
  private void a(List<oidb_cmd0x977.FollowStatusInfo> paramList, String paramString, long paramLong, boolean paramBoolean)
  {
    paramList = a(paramList);
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Boolean = paramBoolean;
    a(this.jdField_a_of_type_JavaUtilList, paramList);
    this.jdField_a_of_type_AndroidOsHandler.post(new FollowListInfoModule.4(this, paramList, paramLong, paramBoolean));
  }
  
  private void a(List<rcz> paramList1, List<rcz> paramList2)
  {
    if ((paramList1 == null) || (paramList2 == null)) {
      return;
    }
    if (paramList1.size() <= 0)
    {
      paramList1.addAll(paramList2);
      return;
    }
    paramList2 = paramList2.iterator();
    label34:
    rcz localrcz1;
    int i;
    if (paramList2.hasNext())
    {
      localrcz1 = (rcz)paramList2.next();
      int k = paramList1.size();
      i = 0;
      label64:
      if (i >= k) {
        break label135;
      }
      rcz localrcz2 = (rcz)paramList1.get(i);
      if (!localrcz1.a().equals(localrcz2.a())) {}
    }
    for (;;)
    {
      if (i != -1)
      {
        paramList1.set(i, localrcz1);
        break label34;
        i += 1;
        break label64;
      }
      paramList1.add(localrcz1);
      break label34;
      break;
      label135:
      i = -1;
    }
  }
  
  private void a(oidb_cmd0x977.FollowListInfo paramFollowListInfo, List<oidb_cmd0x977.FollowStatusInfo> paramList, String paramString, long paramLong, boolean paramBoolean)
  {
    if (paramFollowListInfo.uint32_follow_list_type.get() == 3)
    {
      c(paramList, paramString, paramLong, paramBoolean);
      return;
    }
    if (paramFollowListInfo.uint32_follow_list_type.get() == 1)
    {
      b(paramList, paramString, paramLong, paramBoolean);
      return;
    }
    a(paramList, paramString, paramLong, paramBoolean);
  }
  
  private void a(oidb_cmd0x977.ReqFollowPara paramReqFollowPara, int paramInt)
  {
    PBBytesField localPBBytesField = paramReqFollowPara.bytes_cookie;
    if (paramInt == 2) {}
    for (paramReqFollowPara = this.jdField_a_of_type_JavaLangString;; paramReqFollowPara = this.j)
    {
      localPBBytesField.set(ByteStringMicro.copyFromUtf8(paramReqFollowPara));
      return;
    }
  }
  
  private void a(oidb_cmd0x977.ReqFollowPara paramReqFollowPara, int paramInt1, List<Long> paramList, int paramInt2)
  {
    b(paramReqFollowPara, paramInt2, paramList, paramInt1);
  }
  
  private boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  private boolean a(int paramInt)
  {
    boolean bool = true;
    if ((paramInt == 1) || (paramInt == 0)) {
      bool = false;
    }
    return bool;
  }
  
  public static boolean a(long paramLong, puy parampuy)
  {
    boolean bool = false;
    puw localpuw = pkm.a().a();
    if (localpuw != null) {
      bool = localpuw.b(paramLong, parampuy);
    }
    return bool;
  }
  
  public static boolean a(String paramString, puy parampuy)
  {
    try
    {
      boolean bool = a(Long.parseLong(paramString), parampuy);
      return bool;
    }
    catch (Exception paramString)
    {
      QLog.d("FollowingInfoModule", 1, "queryFollowStatus error! msg=" + paramString);
    }
    return false;
  }
  
  private List<rcz> b(List<Long> paramList, puy parampuy)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramList == null) || (paramList.isEmpty())) {
      return localArrayList;
    }
    a(parampuy);
    parampuy = paramList.iterator();
    while (parampuy.hasNext())
    {
      Object localObject = (Long)parampuy.next();
      localObject = (rcz)this.jdField_a_of_type_JavaUtilMap.get(localObject);
      if (localObject != null) {
        localArrayList.add(localObject);
      }
    }
    a(true, paramList.size(), 1, true, 5, paramList);
    return localArrayList;
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Integer localInteger = (Integer)paramToServiceMsg.getAttribute("attr_follow_list_type");
    paramToServiceMsg = (Boolean)paramToServiceMsg.getAttribute("attr_request_follow_status");
    QLog.i("FollowingInfoModule", 1, "[handleGetFollowMemberListFromServer] reqType=" + localInteger);
    oidb_cmd0x977.RspBody localRspBody = new oidb_cmd0x977.RspBody();
    int i = qlk.a(paramFromServiceMsg, paramObject, localRspBody);
    if ((i != 0) && (!paramToServiceMsg.booleanValue())) {
      a(i, localInteger);
    }
    while (!localRspBody.msg_rsp_follow_data.has()) {
      return;
    }
    a(i, localRspBody, paramToServiceMsg.booleanValue());
  }
  
  private void b(List<oidb_cmd0x977.FollowStatusInfo> paramList, String paramString, long paramLong, boolean paramBoolean)
  {
    paramList = a(paramList);
    this.j = paramString;
    this.jdField_a_of_type_AndroidOsHandler.post(new FollowListInfoModule.5(this, paramList, paramLong, paramBoolean));
  }
  
  private void b(oidb_cmd0x977.ReqFollowPara paramReqFollowPara, int paramInt1, List<Long> paramList, int paramInt2)
  {
    if ((paramList == null) || (paramList.isEmpty())) {}
    do
    {
      return;
      if (1 == paramInt1)
      {
        paramReqFollowPara.uint64_dst_uin.set(((Long)paramList.get(0)).longValue());
        return;
      }
      if (paramInt1 == 5)
      {
        paramReqFollowPara.rpt_uin_list.set(paramList);
        paramReqFollowPara.rpt_subscribe_list.set(paramList);
        return;
      }
    } while (2 != paramInt1);
    paramReqFollowPara.uint32_follow_list_type.set(paramInt2);
    a(paramReqFollowPara, paramInt2);
  }
  
  private boolean b(long paramLong, puy parampuy)
  {
    a(parampuy);
    parampuy = new ArrayList();
    parampuy.add(Long.valueOf(paramLong));
    a(true, 1, 1, true, 1, parampuy);
    parampuy = (rcz)this.jdField_a_of_type_JavaUtilMap.get(Long.valueOf(paramLong));
    return (parampuy != null) && (parampuy.a());
  }
  
  private void c(List<oidb_cmd0x977.FollowStatusInfo> paramList, String paramString, long paramLong, boolean paramBoolean)
  {
    paramList = a(paramList);
    this.jdField_a_of_type_AndroidOsHandler.post(new FollowListInfoModule.7(this, paramList, paramLong, paramBoolean));
  }
  
  public List<rcz> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if ((a()) || (!this.b))
    {
      a(paramInt1, paramInt2, false);
      this.b = true;
    }
  }
  
  @Deprecated
  public void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    a(false, paramInt1, paramInt2, paramBoolean, 2, new ArrayList());
  }
  
  public void a(long paramLong, int paramInt)
  {
    rcz localrcz2 = (rcz)this.jdField_a_of_type_JavaUtilMap.get(Long.valueOf(paramLong));
    rcz localrcz1 = localrcz2;
    if (localrcz2 == null)
    {
      localrcz1 = new rcz();
      localrcz1.a(Long.valueOf(paramLong));
    }
    localrcz1.a(a(paramInt));
    this.jdField_a_of_type_JavaUtilMap.put(Long.valueOf(paramLong), localrcz1);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0x977")) {
      b(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
  
  public void a(puy parampuy)
  {
    if (parampuy == null) {}
    while (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.contains(parampuy)) {
      return;
    }
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(parampuy);
      return;
    }
  }
  
  public void a(boolean paramBoolean1, int paramInt1, int paramInt2, boolean paramBoolean2, int paramInt3, List<Long> paramList)
  {
    int i = 0;
    if (QLog.isColorLevel()) {
      QLog.d("FollowingInfoModule", 0, "[requestFollowersListFromServer] mFollowingList=" + this.jdField_a_of_type_JavaUtilList + ", mFollowingListCookie=" + this.jdField_a_of_type_JavaLangString + ", listType=" + paramInt2);
    }
    oidb_cmd0x977.ReqBody localReqBody = new oidb_cmd0x977.ReqBody();
    localReqBody.uint64_uin.set(pay.a());
    oidb_cmd0x977.ReqFollowPara localReqFollowPara = new oidb_cmd0x977.ReqFollowPara();
    localReqFollowPara.op_type.set(paramInt3);
    localReqFollowPara.uint32_req_count.set(paramInt1);
    a(localReqFollowPara, paramInt2, paramList, paramInt3);
    paramList = localReqFollowPara.uint32_need_kd_user_info;
    if (paramBoolean2) {}
    for (paramInt1 = i;; paramInt1 = 1)
    {
      paramList.set(paramInt1);
      localReqFollowPara.uint32_no_check_friends.set(1);
      localReqBody.msg_req_follow_para.set(localReqFollowPara);
      paramList = qlk.a("OidbSvc.0x977", 2423, 5, localReqBody.toByteArray());
      paramList.addAttribute("attr_follow_list_type", Integer.valueOf(paramInt2));
      paramList.addAttribute("attr_request_follow_status", Boolean.valueOf(paramBoolean1));
      a(paramList);
      return;
    }
  }
  
  public void b(puy parampuy)
  {
    if (parampuy == null) {
      return;
    }
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(parampuy);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     puw
 * JD-Core Version:    0.7.0.1
 */