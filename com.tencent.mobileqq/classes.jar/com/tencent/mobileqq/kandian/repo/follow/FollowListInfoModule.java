package com.tencent.mobileqq.kandian.repo.follow;

import android.os.Handler;
import com.tencent.TMG.utils.QLog;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.kandian.base.msf.ReadInJoyMSFService;
import com.tencent.mobileqq.kandian.base.msf.ReadInJoyOidbHelper;
import com.tencent.mobileqq.kandian.base.utils.CollectionUtils;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.repo.common.ReadInJoyEngineModule;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
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

public class FollowListInfoModule
  extends ReadInJoyEngineModule
{
  private String a = "";
  private boolean b = true;
  private List<FollowingMember> c = new ArrayList();
  private String d = "";
  private boolean e = false;
  private Map<Long, FollowingMember> f = new HashMap();
  private final CopyOnWriteArrayList<IFollowStatusObserver> g = new CopyOnWriteArrayList();
  
  public FollowListInfoModule(AppInterface paramAppInterface, EntityManager paramEntityManager, ExecutorService paramExecutorService, ReadInJoyMSFService paramReadInJoyMSFService, Handler paramHandler)
  {
    super(paramAppInterface, paramEntityManager, paramExecutorService, paramReadInJoyMSFService, paramHandler);
  }
  
  private List<FollowingMember> a(List<oidb_cmd0x977.FollowStatusInfo> paramList)
  {
    return CollectionUtils.a(paramList, new FollowListInfoModule.6(this));
  }
  
  public static List<FollowingMember> a(List<Long> paramList, IFollowStatusObserver paramIFollowStatusObserver)
  {
    FollowListInfoModule localFollowListInfoModule = ReadInJoyLogicEngine.a().W();
    ArrayList localArrayList = new ArrayList();
    if (localFollowListInfoModule != null) {
      localArrayList.addAll(localFollowListInfoModule.b(paramList, paramIFollowStatusObserver));
    }
    return localArrayList;
  }
  
  private void a(int paramInt, Integer paramInteger)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[handleGetFollowMemberListFromServer] result = ");
    localStringBuilder.append(paramInt);
    QLog.e("FollowingInfoModule", 1, localStringBuilder.toString());
    if (paramInteger.intValue() == 3)
    {
      this.mMainThreadHandler.post(new FollowListInfoModule.1(this));
      return;
    }
    if (paramInteger.intValue() == 2) {
      this.mMainThreadHandler.post(new FollowListInfoModule.2(this));
    }
  }
  
  private void a(int paramInt, List<oidb_cmd0x977.FollowStatusInfo> paramList, long paramLong, boolean paramBoolean)
  {
    paramList = a(paramList).iterator();
    while (paramList.hasNext())
    {
      FollowingMember localFollowingMember = (FollowingMember)paramList.next();
      if (localFollowingMember != null) {
        this.f.put(localFollowingMember.a(), localFollowingMember);
      }
    }
    this.mMainThreadHandler.post(new FollowListInfoModule.3(this, paramInt));
  }
  
  private void a(int paramInt, Map<Long, FollowingMember> paramMap)
  {
    synchronized (this.g)
    {
      Iterator localIterator = this.g.iterator();
      while (localIterator.hasNext()) {
        ((IFollowStatusObserver)localIterator.next()).a(paramInt, paramMap);
      }
      return;
    }
    for (;;)
    {
      throw paramMap;
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
    boolean bool;
    if (paramRspBody.msg_rsp_follow_data.uint32_is_no_more_data.get() == 0) {
      bool = true;
    } else {
      bool = false;
    }
    if (paramBoolean)
    {
      a(paramInt, localList, l, bool);
      return;
    }
    a(localFollowListInfo, localList, str, l, bool);
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Integer localInteger = (Integer)paramToServiceMsg.getAttribute("attr_follow_list_type");
    paramToServiceMsg = (Boolean)paramToServiceMsg.getAttribute("attr_request_follow_status");
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[handleGetFollowMemberListFromServer] reqType=");
    ((StringBuilder)localObject).append(localInteger);
    QLog.i("FollowingInfoModule", 1, ((StringBuilder)localObject).toString());
    localObject = new oidb_cmd0x977.RspBody();
    int i = ReadInJoyOidbHelper.a(paramFromServiceMsg, paramObject, (MessageMicro)localObject);
    if ((i != 0) && (!paramToServiceMsg.booleanValue()))
    {
      a(i, localInteger);
      return;
    }
    if (((oidb_cmd0x977.RspBody)localObject).msg_rsp_follow_data.has()) {
      a(i, (oidb_cmd0x977.RspBody)localObject, paramToServiceMsg.booleanValue());
    }
  }
  
  private void a(List<oidb_cmd0x977.FollowStatusInfo> paramList, String paramString, long paramLong, boolean paramBoolean)
  {
    paramList = a(paramList);
    this.a = paramString;
    this.b = paramBoolean;
    a(this.c, paramList);
    this.mMainThreadHandler.post(new FollowListInfoModule.4(this, paramList, paramLong, paramBoolean));
  }
  
  private void a(List<FollowingMember> paramList1, List<FollowingMember> paramList2)
  {
    if (paramList1 != null)
    {
      if (paramList2 == null) {
        return;
      }
      if (paramList1.size() <= 0)
      {
        paramList1.addAll(paramList2);
        return;
      }
      paramList2 = paramList2.iterator();
      while (paramList2.hasNext())
      {
        FollowingMember localFollowingMember1 = (FollowingMember)paramList2.next();
        int j = paramList1.size();
        int i = 0;
        while (i < j)
        {
          FollowingMember localFollowingMember2 = (FollowingMember)paramList1.get(i);
          if (localFollowingMember1.a().equals(localFollowingMember2.a())) {
            break label110;
          }
          i += 1;
        }
        i = -1;
        label110:
        if (i != -1) {
          paramList1.set(i, localFollowingMember1);
        } else {
          paramList1.add(localFollowingMember1);
        }
      }
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
    if (paramInt == 2) {
      paramReqFollowPara = this.a;
    } else {
      paramReqFollowPara = this.d;
    }
    localPBBytesField.set(ByteStringMicro.copyFromUtf8(paramReqFollowPara));
  }
  
  private void a(oidb_cmd0x977.ReqFollowPara paramReqFollowPara, int paramInt1, List<Long> paramList, int paramInt2)
  {
    b(paramReqFollowPara, paramInt2, paramList, paramInt1);
  }
  
  private boolean a(int paramInt)
  {
    boolean bool = true;
    if ((paramInt == 1) || (paramInt == 0)) {
      bool = false;
    }
    return bool;
  }
  
  private boolean a(long paramLong)
  {
    new ArrayList().add(Long.valueOf(paramLong));
    FollowingMember localFollowingMember = (FollowingMember)this.f.get(Long.valueOf(paramLong));
    return (localFollowingMember != null) && (localFollowingMember.d());
  }
  
  public static boolean a(long paramLong, IFollowStatusObserver paramIFollowStatusObserver)
  {
    FollowListInfoModule localFollowListInfoModule = ReadInJoyLogicEngine.a().W();
    if (localFollowListInfoModule != null) {
      return localFollowListInfoModule.b(paramLong, paramIFollowStatusObserver);
    }
    return false;
  }
  
  public static boolean a(String paramString)
  {
    FollowListInfoModule localFollowListInfoModule = ReadInJoyLogicEngine.a().W();
    if (localFollowListInfoModule != null)
    {
      long l1 = 0L;
      try
      {
        long l2 = Long.parseLong(paramString);
        l1 = l2;
      }
      catch (NumberFormatException paramString)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("queryNativeFollowStatus error! msg=");
        localStringBuilder.append(paramString);
        QLog.d("FollowingInfoModule", 1, localStringBuilder.toString());
      }
      return localFollowListInfoModule.a(l1);
    }
    return false;
  }
  
  public static boolean a(String paramString, IFollowStatusObserver paramIFollowStatusObserver)
  {
    try
    {
      boolean bool = a(Long.parseLong(paramString), paramIFollowStatusObserver);
      return bool;
    }
    catch (Exception paramString)
    {
      paramIFollowStatusObserver = new StringBuilder();
      paramIFollowStatusObserver.append("queryFollowStatus error! msg=");
      paramIFollowStatusObserver.append(paramString);
      QLog.d("FollowingInfoModule", 1, paramIFollowStatusObserver.toString());
    }
    return false;
  }
  
  private List<FollowingMember> b(List<Long> paramList, IFollowStatusObserver paramIFollowStatusObserver)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList != null)
    {
      if (paramList.isEmpty()) {
        return localArrayList;
      }
      a(paramIFollowStatusObserver);
      paramIFollowStatusObserver = paramList.iterator();
      while (paramIFollowStatusObserver.hasNext())
      {
        Object localObject = (Long)paramIFollowStatusObserver.next();
        localObject = (FollowingMember)this.f.get(localObject);
        if (localObject != null) {
          localArrayList.add(localObject);
        }
      }
      a(true, paramList.size(), 1, true, 5, paramList);
    }
    return localArrayList;
  }
  
  private void b(List<oidb_cmd0x977.FollowStatusInfo> paramList, String paramString, long paramLong, boolean paramBoolean)
  {
    paramList = a(paramList);
    this.d = paramString;
    this.mMainThreadHandler.post(new FollowListInfoModule.5(this, paramList, paramLong, paramBoolean));
  }
  
  private void b(oidb_cmd0x977.ReqFollowPara paramReqFollowPara, int paramInt1, List<Long> paramList, int paramInt2)
  {
    if (paramList != null)
    {
      if (paramList.isEmpty()) {
        return;
      }
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
      if (2 == paramInt1)
      {
        paramReqFollowPara.uint32_follow_list_type.set(paramInt2);
        a(paramReqFollowPara, paramInt2);
      }
    }
  }
  
  private boolean b()
  {
    return this.b;
  }
  
  private boolean b(long paramLong, IFollowStatusObserver paramIFollowStatusObserver)
  {
    a(paramIFollowStatusObserver);
    paramIFollowStatusObserver = new ArrayList();
    paramIFollowStatusObserver.add(Long.valueOf(paramLong));
    a(true, 1, 1, true, 1, paramIFollowStatusObserver);
    paramIFollowStatusObserver = (FollowingMember)this.f.get(Long.valueOf(paramLong));
    return (paramIFollowStatusObserver != null) && (paramIFollowStatusObserver.d());
  }
  
  private void c(List<oidb_cmd0x977.FollowStatusInfo> paramList, String paramString, long paramLong, boolean paramBoolean)
  {
    paramList = a(paramList);
    this.mMainThreadHandler.post(new FollowListInfoModule.7(this, paramList, paramLong, paramBoolean));
  }
  
  public List<FollowingMember> a()
  {
    return this.c;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if ((b()) || (!this.e))
    {
      a(paramInt1, paramInt2, false);
      this.e = true;
    }
  }
  
  @Deprecated
  public void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    a(false, paramInt1, paramInt2, paramBoolean, 2, new ArrayList());
  }
  
  public void a(long paramLong, int paramInt)
  {
    FollowingMember localFollowingMember2 = (FollowingMember)this.f.get(Long.valueOf(paramLong));
    FollowingMember localFollowingMember1 = localFollowingMember2;
    if (localFollowingMember2 == null)
    {
      localFollowingMember1 = new FollowingMember();
      localFollowingMember1.a(Long.valueOf(paramLong));
    }
    localFollowingMember1.a(a(paramInt));
    this.f.put(Long.valueOf(paramLong), localFollowingMember1);
  }
  
  public void a(IFollowStatusObserver paramIFollowStatusObserver)
  {
    if (paramIFollowStatusObserver == null) {
      return;
    }
    synchronized (this.g)
    {
      if (!this.g.contains(paramIFollowStatusObserver)) {
        this.g.add(paramIFollowStatusObserver);
      }
      return;
    }
  }
  
  public void a(boolean paramBoolean1, int paramInt1, int paramInt2, boolean paramBoolean2, int paramInt3, List<Long> paramList)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[requestFollowersListFromServer] mFollowingList=");
      ((StringBuilder)localObject).append(this.c);
      ((StringBuilder)localObject).append(", mFollowingListCookie=");
      ((StringBuilder)localObject).append(this.a);
      ((StringBuilder)localObject).append(", listType=");
      ((StringBuilder)localObject).append(paramInt2);
      QLog.d("FollowingInfoModule", 0, ((StringBuilder)localObject).toString());
    }
    Object localObject = new oidb_cmd0x977.ReqBody();
    ((oidb_cmd0x977.ReqBody)localObject).uint64_uin.set(RIJQQAppInterfaceUtil.c());
    oidb_cmd0x977.ReqFollowPara localReqFollowPara = new oidb_cmd0x977.ReqFollowPara();
    localReqFollowPara.op_type.set(paramInt3);
    localReqFollowPara.uint32_req_count.set(paramInt1);
    a(localReqFollowPara, paramInt2, paramList, paramInt3);
    localReqFollowPara.uint32_need_kd_user_info.set(paramBoolean2 ^ true);
    localReqFollowPara.uint32_no_check_friends.set(1);
    ((oidb_cmd0x977.ReqBody)localObject).msg_req_follow_para.set(localReqFollowPara);
    paramList = ReadInJoyOidbHelper.a("OidbSvc.0x977", 2423, 5, ((oidb_cmd0x977.ReqBody)localObject).toByteArray());
    paramList.addAttribute("attr_follow_list_type", Integer.valueOf(paramInt2));
    paramList.addAttribute("attr_request_follow_status", Boolean.valueOf(paramBoolean1));
    sendPbReq(paramList);
  }
  
  public void b(IFollowStatusObserver paramIFollowStatusObserver)
  {
    if (paramIFollowStatusObserver == null) {
      return;
    }
    synchronized (this.g)
    {
      this.g.remove(paramIFollowStatusObserver);
      return;
    }
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0x977")) {
      a(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
  
  public void unInitialize() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.follow.FollowListInfoModule
 * JD-Core Version:    0.7.0.1
 */