package com.tencent.mobileqq.kandian.repo.feeds;

import android.os.Handler;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.kandian.base.msf.ReadInJoyMSFService;
import com.tencent.mobileqq.kandian.base.msf.ReadInJoyOidbHelper;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.glue.msf.ReadInJoyMSFHandlerUtils;
import com.tencent.mobileqq.kandian.repo.common.IFindRemovedEntity;
import com.tencent.mobileqq.kandian.repo.common.ReadInJoyEngineModule;
import com.tencent.mobileqq.kandian.repo.db.struct.ChannelSection;
import com.tencent.mobileqq.kandian.repo.feeds.constant.IChannelInfoModuleConst;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ChannelCoverInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ChannelInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ReadInJoyRequestParams.Request0x69fParams;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TabChannelCoverInfo;
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
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import tencent.im.oidb.cmd0x69e.oidb_cmd0x69e.ReqBody;
import tencent.im.oidb.cmd0x69e.oidb_cmd0x69e.RspBody;
import tencent.im.oidb.cmd0x69f.oidb_cmd0x69f.ReqBody;
import tencent.im.oidb.cmd0x69f.oidb_cmd0x69f.RspBody;
import tencent.im.oidb.cmd0x8f5.oidb_cmd0x8f5.ReqBody;
import tencent.im.oidb.cmd0x8f5.oidb_cmd0x8f5.RspBody;
import tencent.im.oidb.cmd0x908.oidb_cmd0x908.ChildChannelStatus;
import tencent.im.oidb.cmd0x908.oidb_cmd0x908.ReqBody;
import tencent.im.oidb.cmd0x908.oidb_cmd0x908.RspBody;

public class ChannelInfoModule
  extends ReadInJoyEngineModule
  implements IChannelInfoModuleConst
{
  private boolean a = false;
  private int b = 0;
  private boolean c = false;
  private LinkedHashMap<Integer, ChannelInfo> d = new LinkedHashMap();
  private LinkedHashMap<Integer, ChannelInfo> e = new LinkedHashMap();
  private int f = 0;
  private IFindRemovedEntity<ChannelInfo> g = new ChannelInfoModule.1(this);
  
  public ChannelInfoModule(AppInterface paramAppInterface, EntityManager paramEntityManager, ExecutorService paramExecutorService, ReadInJoyMSFService paramReadInJoyMSFService, Handler paramHandler)
  {
    super(paramAppInterface, paramEntityManager, paramExecutorService, paramReadInJoyMSFService, paramHandler);
    registerEntityFinder(ChannelInfo.class, this.g);
  }
  
  private void a()
  {
    if (this.c) {
      return;
    }
    Object localObject = this.mEntityManager.query(ChannelInfo.class, true, null, null, null, null, null, null);
    if (localObject == null)
    {
      this.c = true;
      return;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      a((ChannelInfo)((Iterator)localObject).next(), false);
    }
    this.c = true;
  }
  
  private void a(boolean paramBoolean1, List<ChannelInfo> paramList, List<Integer> paramList1, boolean paramBoolean2)
  {
    this.mMainThreadHandler.post(new ChannelInfoModule.5(this, paramBoolean1, paramBoolean2, paramList, paramList1));
  }
  
  private boolean a(ChannelInfo paramChannelInfo, boolean paramBoolean)
  {
    if (paramChannelInfo == null) {
      return false;
    }
    ChannelInfo localChannelInfo = paramChannelInfo.clone();
    this.d.put(Integer.valueOf(paramChannelInfo.mChannelID), localChannelInfo);
    if (paramBoolean) {
      this.mExecutorService.execute(new ChannelInfoModule.7(this, localChannelInfo));
    }
    return true;
  }
  
  private void b(Integer paramInteger)
  {
    ChannelInfo localChannelInfo = (ChannelInfo)this.d.get(paramInteger);
    if (localChannelInfo != null)
    {
      this.d.remove(paramInteger);
      this.mExecutorService.execute(new ChannelInfoModule.6(this, localChannelInfo));
    }
  }
  
  public ChannelInfo a(Integer paramInteger)
  {
    a();
    return (ChannelInfo)this.d.get(paramInteger);
  }
  
  protected ToServiceMsg a(ReadInJoyRequestParams.Request0x69fParams paramRequest0x69fParams)
  {
    Object localObject = new oidb_cmd0x69f.ReqBody();
    long l = Long.valueOf(RIJQQAppInterfaceUtil.d()).longValue();
    ((oidb_cmd0x69f.ReqBody)localObject).uint64_uin.set(l);
    if (paramRequest0x69fParams.b) {
      ((oidb_cmd0x69f.ReqBody)localObject).uint32_req_all_channel_list.set(1);
    }
    if (paramRequest0x69fParams.c) {
      ((oidb_cmd0x69f.ReqBody)localObject).uint32_req_my_channel_id_list.set(1);
    }
    if (paramRequest0x69fParams.k) {
      ((oidb_cmd0x69f.ReqBody)localObject).uint32_req_video_channel.set(1);
    }
    if (paramRequest0x69fParams.l) {
      ((oidb_cmd0x69f.ReqBody)localObject).uint32_req_local_channel_id.set(1);
    }
    if ((RIJQQAppInterfaceUtil.g()) && (!paramRequest0x69fParams.q))
    {
      ((oidb_cmd0x69f.ReqBody)localObject).uint32_req_search_channel.set(1);
      ((oidb_cmd0x69f.ReqBody)localObject).uint32_req_search_word.set(1);
      ((oidb_cmd0x69f.ReqBody)localObject).uint32_req_channel_jump_url.set(1);
    }
    else
    {
      ((oidb_cmd0x69f.ReqBody)localObject).uint32_req_search_channel.set(0);
    }
    if (paramRequest0x69fParams.j) {
      ((oidb_cmd0x69f.ReqBody)localObject).uint32_req_recomm_channel.set(1);
    }
    ((oidb_cmd0x69f.ReqBody)localObject).uint32_important.set(paramRequest0x69fParams.m);
    ((oidb_cmd0x69f.ReqBody)localObject).uint32_req_channel_id.set(paramRequest0x69fParams.n);
    ((oidb_cmd0x69f.ReqBody)localObject).uint32_req_channel_cover.set(paramRequest0x69fParams.o);
    ((oidb_cmd0x69f.ReqBody)localObject).uint32_req_channel_seq.set(paramRequest0x69fParams.p);
    localObject = ReadInJoyOidbHelper.a("OidbSvc.0x69f", 1695, 0, ((oidb_cmd0x69f.ReqBody)localObject).toByteArray());
    ((ToServiceMsg)localObject).getAttributes().put("NotifyType", Integer.valueOf(paramRequest0x69fParams.a));
    ((ToServiceMsg)localObject).getAttributes().put("debug", Boolean.valueOf(paramRequest0x69fParams.q));
    return localObject;
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    ArrayList localArrayList = new ArrayList(1);
    localArrayList.add(Integer.valueOf(paramInt3));
    a(paramInt1, paramInt2, localArrayList, true, true);
  }
  
  public void a(int paramInt1, int paramInt2, List<Integer> paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramList == null) {
      return;
    }
    Object localObject = new oidb_cmd0x908.ReqBody();
    ((oidb_cmd0x908.ReqBody)localObject).uint64_uin.set(Long.valueOf(RIJQQAppInterfaceUtil.d()).longValue());
    ((oidb_cmd0x908.ReqBody)localObject).uint32_parent_channel_id.set(paramInt1);
    if (paramBoolean1) {
      ((oidb_cmd0x908.ReqBody)localObject).uint32_req_channel_header_url.set(1);
    } else {
      ((oidb_cmd0x908.ReqBody)localObject).uint32_req_channel_header_url.set(0);
    }
    if (paramBoolean2) {
      ((oidb_cmd0x908.ReqBody)localObject).uint32_req_channel_subscription_count.set(1);
    } else {
      ((oidb_cmd0x908.ReqBody)localObject).uint32_req_channel_subscription_count.set(0);
    }
    if ((paramList != null) && (paramList.size() > 0)) {
      ((oidb_cmd0x908.ReqBody)localObject).rpt_child_channel_list.set(paramList);
    }
    localObject = ReadInJoyOidbHelper.a("OidbSvc.0x908", 2312, 0, ((oidb_cmd0x908.ReqBody)localObject).toByteArray());
    ((ToServiceMsg)localObject).getAttributes().put("channelType", Integer.valueOf(paramInt2));
    sendPbReq((ToServiceMsg)localObject);
    if (QLog.isColorLevel()) {
      QLog.d("ChannelInfoModule", 2, String.format("getSubChannelStatus(): send 0x908 req, parentChannelID =%s , childChannelIDList=%s", new Object[] { Integer.valueOf(paramInt1), Arrays.toString(paramList.toArray()) }));
    }
  }
  
  protected void a(ChannelCoverInfo paramChannelCoverInfo)
  {
    if ((paramChannelCoverInfo != null) && (!TextUtils.isEmpty(paramChannelCoverInfo.mChannelCoverName)) && (paramChannelCoverInfo.mChannelCoverName.contains("%#")))
    {
      String[] arrayOfString = paramChannelCoverInfo.mChannelCoverName.split("%#");
      if (!TextUtils.isEmpty(arrayOfString[0])) {
        paramChannelCoverInfo.mChannelCoverName = arrayOfString[0];
      }
    }
  }
  
  public void a(ChannelInfo paramChannelInfo)
  {
    a(paramChannelInfo, true);
  }
  
  protected void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject) {}
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    ArrayList localArrayList = new ArrayList(1);
    localArrayList.add(Integer.valueOf(paramInt2));
    a(paramBoolean, paramInt1, localArrayList);
  }
  
  public void a(boolean paramBoolean, int paramInt, SparseArray<ChannelInfo> paramSparseArray)
  {
    if (paramSparseArray != null)
    {
      int j = paramSparseArray.size();
      int i = 0;
      while (i < j)
      {
        ChannelInfo localChannelInfo = (ChannelInfo)paramSparseArray.get(paramSparseArray.keyAt(i));
        if (localChannelInfo != null) {
          a(localChannelInfo, true);
        }
        i += 1;
      }
    }
    this.mMainThreadHandler.post(new ChannelInfoModule.11(this, paramBoolean, paramInt, paramSparseArray));
  }
  
  public void a(boolean paramBoolean, int paramInt, List<Integer> paramList)
  {
    oidb_cmd0x8f5.ReqBody localReqBody = new oidb_cmd0x8f5.ReqBody();
    localReqBody.uint64_uin.set(Long.valueOf(RIJQQAppInterfaceUtil.d()).longValue());
    if (paramBoolean) {
      localReqBody.enum_follow_op.set(0);
    } else {
      localReqBody.enum_follow_op.set(1);
    }
    localReqBody.uint32_parent_channel_id.set(paramInt);
    if ((paramList != null) && (paramList.size() > 0)) {
      localReqBody.rpt_child_channel_list.set(paramList);
    }
    sendPbReq(ReadInJoyOidbHelper.a("OidbSvc.0x8f5", 2293, 0, localReqBody.toByteArray()));
    if (QLog.isColorLevel())
    {
      if (paramList == null) {
        paramList = "null";
      } else {
        paramList = Arrays.toString(paramList.toArray());
      }
      QLog.d("ChannelInfoModule", 2, String.format("followUnfollow(): send req, follow = %s, parentChannelID =%s , childChannelIDList=%s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt), paramList }));
    }
  }
  
  public void a(boolean paramBoolean, List<Integer> paramList)
  {
    this.mMainThreadHandler.post(new ChannelInfoModule.4(this, paramBoolean, paramList));
  }
  
  public boolean a(List<ChannelInfo> paramList, boolean paramBoolean)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      Object localObject1 = new HashMap(paramList.size());
      Object localObject2 = paramList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (ChannelInfo)((Iterator)localObject2).next();
        ((HashMap)localObject1).put(Integer.valueOf(((ChannelInfo)localObject3).mChannelID), localObject3);
      }
      localObject2 = new ArrayList();
      Object localObject3 = this.d.keySet().iterator();
      while (((Iterator)localObject3).hasNext())
      {
        Integer localInteger = (Integer)((Iterator)localObject3).next();
        if (((HashMap)localObject1).get(localInteger) == null)
        {
          ((List)localObject2).add(localInteger);
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("saveAllChannelInfoList, channel deleted, channelID=");
            localStringBuilder.append(localInteger);
            localStringBuilder.append("channelName=");
            localStringBuilder.append(((ChannelInfo)this.d.get(localInteger)).mChannelName);
            QLog.e("ChannelInfoModule", 2, localStringBuilder.toString());
          }
        }
      }
      localObject1 = ((List)localObject2).iterator();
      while (((Iterator)localObject1).hasNext()) {
        b((Integer)((Iterator)localObject1).next());
      }
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localObject1 = (ChannelInfo)paramList.next();
        localObject2 = (ChannelInfo)this.d.get(Integer.valueOf(((ChannelInfo)localObject1).mChannelID));
        if (localObject2 == null)
        {
          a((ChannelInfo)localObject1, paramBoolean);
        }
        else if ((!((ChannelInfo)localObject2).mChannelName.equals(((ChannelInfo)localObject1).mChannelName)) || (((ChannelInfo)localObject2).mFontColor != ((ChannelInfo)localObject1).mFontColor) || (((ChannelInfo)localObject2).mFrameColor != ((ChannelInfo)localObject1).mFrameColor) || (!TextUtils.equals(((ChannelInfo)localObject2).mJumpUrl, ((ChannelInfo)localObject1).mJumpUrl)))
        {
          ((ChannelInfo)localObject2).mChannelName = ((ChannelInfo)localObject1).mChannelName;
          ((ChannelInfo)localObject2).mFontColor = ((ChannelInfo)localObject1).mFontColor;
          ((ChannelInfo)localObject2).mFrameColor = ((ChannelInfo)localObject1).mFrameColor;
          ((ChannelInfo)localObject2).mJumpUrl = ((ChannelInfo)localObject1).mJumpUrl;
          a((ChannelInfo)localObject2, paramBoolean);
        }
      }
      return true;
    }
    return false;
  }
  
  protected void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject) {}
  
  public void b(List<Integer> paramList)
  {
    Object localObject = new oidb_cmd0x69e.ReqBody();
    ((oidb_cmd0x69e.ReqBody)localObject).rpt_uint32_channel_ids.set(paramList);
    localObject = ReadInJoyOidbHelper.a("OidbSvc.0x69e", 1694, 0, ((oidb_cmd0x69e.ReqBody)localObject).toByteArray());
    ((ToServiceMsg)localObject).getAttributes().put("channelIDList", paramList);
    sendPbReq((ToServiceMsg)localObject);
  }
  
  public void b(boolean paramBoolean)
  {
    Object localObject = new ReadInJoyRequestParams.Request0x69fParams();
    ((ReadInJoyRequestParams.Request0x69fParams)localObject).a = 4;
    ((ReadInJoyRequestParams.Request0x69fParams)localObject).b = true;
    ((ReadInJoyRequestParams.Request0x69fParams)localObject).c = true;
    ((ReadInJoyRequestParams.Request0x69fParams)localObject).d = false;
    ((ReadInJoyRequestParams.Request0x69fParams)localObject).e = true;
    ((ReadInJoyRequestParams.Request0x69fParams)localObject).k = true;
    ((ReadInJoyRequestParams.Request0x69fParams)localObject).l = true;
    ((ReadInJoyRequestParams.Request0x69fParams)localObject).f = false;
    ((ReadInJoyRequestParams.Request0x69fParams)localObject).g = false;
    ((ReadInJoyRequestParams.Request0x69fParams)localObject).h = false;
    ((ReadInJoyRequestParams.Request0x69fParams)localObject).i = false;
    ((ReadInJoyRequestParams.Request0x69fParams)localObject).m = 1;
    ((ReadInJoyRequestParams.Request0x69fParams)localObject).q = paramBoolean;
    localObject = a((ReadInJoyRequestParams.Request0x69fParams)localObject);
    ((ToServiceMsg)localObject).getAttributes().put("req_channellist_source", Integer.valueOf(1));
    sendPbReq((ToServiceMsg)localObject);
  }
  
  protected void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool2 = true;
    int i = ((Integer)paramToServiceMsg.getAttribute("req_channellist_source", Integer.valueOf(1))).intValue();
    oidb_cmd0x69f.RspBody localRspBody = new oidb_cmd0x69f.RspBody();
    int j = ReadInJoyOidbHelper.a(paramFromServiceMsg, paramObject, localRspBody);
    paramObject = null;
    paramFromServiceMsg = null;
    Object localObject = null;
    boolean bool1;
    FromServiceMsg localFromServiceMsg;
    if (j == 0)
    {
      if (i == 1)
      {
        if (localRspBody.uint64_uin.has()) {
          localRspBody.uint64_uin.get();
        }
        if (localRspBody.rpt_channel_list.has()) {
          paramFromServiceMsg = ReadInJoyMSFHandlerUtils.a(localRspBody.rpt_channel_list.get());
        } else {
          paramFromServiceMsg = null;
        }
        paramObject = localObject;
        if (localRspBody.rpt_uint32_my_channel_id_list.has())
        {
          paramObject = localObject;
          if (localRspBody.rpt_uint32_my_channel_id_list.get() != null)
          {
            paramObject = new ArrayList(localRspBody.rpt_uint32_my_channel_id_list.size());
            paramObject.addAll(localRspBody.rpt_uint32_my_channel_id_list.get());
          }
        }
        localObject = paramFromServiceMsg;
        paramFromServiceMsg = paramObject;
        paramObject = localObject;
      }
      else
      {
        paramFromServiceMsg = null;
      }
      bool1 = bool2;
      localFromServiceMsg = paramFromServiceMsg;
      localObject = paramObject;
      if (localRspBody.uint32_channel_seq.has())
      {
        this.f = localRspBody.uint32_channel_seq.get();
        bool1 = bool2;
        localFromServiceMsg = paramFromServiceMsg;
        localObject = paramObject;
      }
    }
    else
    {
      bool1 = false;
      localFromServiceMsg = null;
      localObject = paramFromServiceMsg;
    }
    if (QLog.isColorLevel())
    {
      paramFromServiceMsg = new StringBuilder();
      paramFromServiceMsg.append("handleGetChannelAndSubscribeList, result=");
      paramFromServiceMsg.append(j);
      QLog.d("ChannelInfoModule", 2, paramFromServiceMsg.toString());
    }
    if (((Integer)paramToServiceMsg.getAttributes().get("NotifyType")).intValue() != 4) {
      return;
    }
    a(bool1, (List)localObject, localFromServiceMsg, ((Boolean)paramToServiceMsg.getAttributes().get("debug")).booleanValue());
  }
  
  protected void c(List<ChannelSection> paramList)
  {
    if (paramList == null) {
      return;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Iterator localIterator = ((ChannelSection)paramList.next()).d.iterator();
      while (localIterator.hasNext())
      {
        TabChannelCoverInfo localTabChannelCoverInfo = (TabChannelCoverInfo)localIterator.next();
        if (localTabChannelCoverInfo.mChannelCoverName.contains("%#"))
        {
          String[] arrayOfString = localTabChannelCoverInfo.mChannelCoverName.split("%#");
          if (!TextUtils.isEmpty(arrayOfString[0])) {
            localTabChannelCoverInfo.mChannelCoverName = arrayOfString[0];
          }
        }
      }
    }
  }
  
  protected void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject) {}
  
  protected void d(List<ChannelCoverInfo> paramList)
  {
    if (paramList == null) {
      return;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      a((ChannelCoverInfo)paramList.next());
    }
  }
  
  public List<Integer> e(List<ChannelInfo> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      ArrayList localArrayList = new ArrayList(paramList.size());
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        localArrayList.add(Integer.valueOf(((ChannelInfo)paramList.next()).mChannelID));
      }
      return localArrayList;
    }
    return null;
  }
  
  public void e(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool;
    if (ReadInJoyOidbHelper.a(paramFromServiceMsg, paramObject, new oidb_cmd0x69e.RspBody()) == 0) {
      bool = true;
    } else {
      bool = false;
    }
    a(bool, (List)paramToServiceMsg.getAttributes().get("channelIDList"));
  }
  
  public void f(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = ReadInJoyOidbHelper.a(paramFromServiceMsg, paramObject, new oidb_cmd0x8f5.RspBody());
    if (QLog.isColorLevel())
    {
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("handle0x8f5FollowUnfollow():  result = ");
      paramToServiceMsg.append(i);
      QLog.e("ChannelInfoModule", 2, paramToServiceMsg.toString());
    }
    this.mMainThreadHandler.post(new ChannelInfoModule.10(this, i));
  }
  
  public void f(List<Integer> paramList)
  {
    if (paramList != null)
    {
      if (paramList.size() == 0) {
        return;
      }
      if (!this.a) {
        return;
      }
      paramList = new ArrayList(paramList);
      paramList.remove(Integer.valueOf(9999));
      g(paramList);
      b(paramList);
      ReadInJoyLogicEngineEventDispatcher.a().b(true, null);
    }
  }
  
  public void g(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Object localObject = new oidb_cmd0x908.RspBody();
    int j = ((Integer)paramToServiceMsg.getAttributes().get("channelType")).intValue();
    int k = ReadInJoyOidbHelper.a(paramFromServiceMsg, paramObject, (MessageMicro)localObject);
    if (k == 0)
    {
      int i;
      if (((oidb_cmd0x908.RspBody)localObject).uint32_parent_channel_id.has()) {
        i = ((oidb_cmd0x908.RspBody)localObject).uint32_parent_channel_id.get();
      } else {
        i = -1;
      }
      boolean bool1 = ((oidb_cmd0x908.RspBody)localObject).rpt_child_channel_status_list.has();
      boolean bool2 = true;
      if (bool1)
      {
        paramToServiceMsg = ((oidb_cmd0x908.RspBody)localObject).rpt_child_channel_status_list.get();
        if ((paramToServiceMsg != null) && (paramToServiceMsg.size() > 0))
        {
          paramFromServiceMsg = new SparseArray(paramToServiceMsg.size());
          paramObject = paramToServiceMsg.iterator();
          for (;;)
          {
            paramToServiceMsg = paramFromServiceMsg;
            if (!paramObject.hasNext()) {
              break;
            }
            paramToServiceMsg = (oidb_cmd0x908.ChildChannelStatus)paramObject.next();
            if (paramToServiceMsg != null)
            {
              localObject = new ChannelInfo();
              if (paramToServiceMsg.uint32_status.has())
              {
                if (paramToServiceMsg.uint32_status.get() > 0) {
                  bool1 = true;
                } else {
                  bool1 = false;
                }
                ((ChannelInfo)localObject).mIsFollowed = bool1;
              }
              if (paramToServiceMsg.uint32_subscription_count.has()) {
                ((ChannelInfo)localObject).mFollowNum = paramToServiceMsg.uint32_subscription_count.get();
              }
              if ((paramToServiceMsg.bytes_channel_header_url.has()) && (paramToServiceMsg.bytes_channel_header_url.get() != null)) {
                ((ChannelInfo)localObject).mHeaderPicUrl = paramToServiceMsg.bytes_channel_header_url.get().toStringUtf8();
              }
              if (paramToServiceMsg.uint32_system_recomm.has())
              {
                if (paramToServiceMsg.uint32_system_recomm.get() > 0) {
                  bool1 = true;
                } else {
                  bool1 = false;
                }
                ((ChannelInfo)localObject).mIsSystemRecomm = bool1;
              }
              if (paramToServiceMsg.uint32_child_channel_id.has())
              {
                ((ChannelInfo)localObject).mChannelID = paramToServiceMsg.uint32_child_channel_id.get();
                ((ChannelInfo)localObject).mChannelType = j;
                paramFromServiceMsg.append(((ChannelInfo)localObject).mChannelID, localObject);
              }
              if (paramToServiceMsg.uint32_is_topic.has())
              {
                if (paramToServiceMsg.uint32_is_topic.get() > 0) {
                  bool1 = true;
                } else {
                  bool1 = false;
                }
                ((ChannelInfo)localObject).mIsTopic = bool1;
              }
            }
          }
        }
      }
      paramToServiceMsg = null;
      if (QLog.isColorLevel())
      {
        if (paramToServiceMsg == null) {
          paramFromServiceMsg = "";
        } else {
          paramFromServiceMsg = paramToServiceMsg.toString();
        }
        QLog.d("ChannelInfoModule", 2, String.format("handle0x908GetChildChannelStatus(): parentChannelID = %s, childChannelType = %s, childChannelStatusArray = %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), paramFromServiceMsg }));
      }
      if (k == 0) {
        bool1 = bool2;
      } else {
        bool1 = false;
      }
      a(bool1, i, paramToServiceMsg);
      return;
    }
    if (QLog.isColorLevel())
    {
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("handle0x908GetChildChannelStatus(): failed, result = ");
      paramToServiceMsg.append(k);
      QLog.e("ChannelInfoModule", 2, paramToServiceMsg.toString());
    }
  }
  
  public void g(List<Integer> paramList)
  {
    if (paramList == null) {
      return;
    }
    Object localObject1 = this.d.keySet().iterator();
    int i;
    for (;;)
    {
      boolean bool = ((Iterator)localObject1).hasNext();
      i = 0;
      if (!bool) {
        break;
      }
      Object localObject2 = (Integer)((Iterator)localObject1).next();
      localObject2 = (ChannelInfo)this.d.get(localObject2);
      if (localObject2 != null)
      {
        ((ChannelInfo)localObject2).mShow = false;
        ((ChannelInfo)localObject2).mSortOrder = 0;
      }
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      int j = ((Integer)paramList.next()).intValue();
      localObject1 = (ChannelInfo)this.d.get(Integer.valueOf(j));
      if (localObject1 != null)
      {
        ((ChannelInfo)localObject1).mShow = true;
        ((ChannelInfo)localObject1).mSortOrder = i;
        i += 1;
      }
    }
    paramList = this.d.keySet().iterator();
    while (paramList.hasNext())
    {
      localObject1 = (Integer)paramList.next();
      localObject1 = (ChannelInfo)this.d.get(localObject1);
      if (localObject1 != null) {
        a((ChannelInfo)localObject1, true);
      }
    }
  }
  
  public List<ChannelInfo> i()
  {
    a();
    Object localObject1 = new ArrayList();
    Object localObject2 = this.d.keySet().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      Object localObject3 = (Integer)((Iterator)localObject2).next();
      localObject3 = (ChannelInfo)this.d.get(localObject3);
      if (((ChannelInfo)localObject3).mShow) {
        ((ArrayList)localObject1).add(localObject3);
      }
    }
    Collections.sort((List)localObject1, new ChannelInfoModule.2(this));
    localObject2 = new ArrayList(((ArrayList)localObject1).size());
    localObject1 = ((ArrayList)localObject1).iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((ArrayList)localObject2).add((ChannelInfo)((Iterator)localObject1).next());
    }
    return localObject2;
  }
  
  public List<ChannelInfo> j()
  {
    a();
    ArrayList localArrayList = new ArrayList(this.d.size());
    Iterator localIterator = this.d.keySet().iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      localArrayList.add((ChannelInfo)this.d.get(localInteger));
    }
    return localArrayList;
  }
  
  public int k()
  {
    List localList = j();
    if ((localList != null) && (!localList.isEmpty()))
    {
      this.mMainThreadHandler.post(new ChannelInfoModule.3(this, localList));
      return 0;
    }
    l();
    return 1;
  }
  
  public void l()
  {
    b(false);
  }
  
  public List<Integer> m()
  {
    a();
    Object localObject1 = new ArrayList();
    Object localObject2 = this.d.keySet().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      Object localObject3 = (Integer)((Iterator)localObject2).next();
      localObject3 = (ChannelInfo)this.d.get(localObject3);
      if (((ChannelInfo)localObject3).mShow) {
        ((ArrayList)localObject1).add(localObject3);
      }
    }
    Collections.sort((List)localObject1, new ChannelInfoModule.8(this));
    localObject2 = new ArrayList(((ArrayList)localObject1).size());
    localObject1 = ((ArrayList)localObject1).iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((ArrayList)localObject2).add(Integer.valueOf(((ChannelInfo)((Iterator)localObject1).next()).mChannelID));
    }
    return localObject2;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0x69f"))
    {
      c(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0x69e"))
    {
      e(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0x908"))
    {
      g(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0x8f5"))
    {
      f(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0xbbb"))
    {
      a(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0xbbc"))
    {
      b(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0xbe6")) {
      d(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
  
  public void unInitialize()
  {
    this.c = false;
    this.b = 0;
    this.d.clear();
    this.e.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.feeds.ChannelInfoModule
 * JD-Core Version:    0.7.0.1
 */