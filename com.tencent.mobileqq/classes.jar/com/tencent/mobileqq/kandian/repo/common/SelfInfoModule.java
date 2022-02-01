package com.tencent.mobileqq.kandian.repo.common;

import android.os.Handler;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.kandian.base.msf.ReadInJoyMSFService;
import com.tencent.mobileqq.kandian.base.msf.ReadInJoyOidbHelper;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.KandianMergeManager;
import com.tencent.mobileqq.kandian.repo.aladdin.RIJKanDianMessageAladdinConfig;
import com.tencent.mobileqq.kandian.repo.aladdin.RIJRedDotAladdinConfig;
import com.tencent.mobileqq.kandian.repo.db.struct.KandianMsgBoxRedPntInfoUtils;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ReadInJoyMedalInfo;
import com.tencent.mobileqq.kandian.repo.reddot.KandianMsgBoxRedPntInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt64Field;
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
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import mqq.app.AppRuntime;
import tencent.im.oidb.cmd0x97b.oidb_cmd0x97b.CountDetailInfo;
import tencent.im.oidb.cmd0x97b.oidb_cmd0x97b.FollowCountInfo;
import tencent.im.oidb.cmd0x97b.oidb_cmd0x97b.LimitInfo;
import tencent.im.oidb.cmd0x97b.oidb_cmd0x97b.MedalInfo;
import tencent.im.oidb.cmd0x97b.oidb_cmd0x97b.RspBody;
import tencent.im.oidb.cmd0x97b.oidb_cmd0x97b.SignIn;
import tencent.im.oidb.cmd0x97b.oidb_cmd0x97b.SimpleInfo;
import tencent.im.oidb.cmd0xbe4.oidb_cmd0xbe4.MsgGetReq;
import tencent.im.oidb.cmd0xbe4.oidb_cmd0xbe4.MsgGetRsp;
import tencent.im.oidb.cmd0xbe4.oidb_cmd0xbe4.ReqBody;
import tencent.im.oidb.cmd0xbe4.oidb_cmd0xbe4.RspBody;

public class SelfInfoModule
  extends ReadInJoyEngineModule
{
  private Map<Integer, SelfInfoModule.IGetMsgBoxRedDotInfoCallback> a = new ConcurrentHashMap();
  private volatile long b = 0L;
  private volatile long c = 0L;
  
  public SelfInfoModule(AppInterface paramAppInterface, EntityManager paramEntityManager, ExecutorService paramExecutorService, ReadInJoyMSFService paramReadInJoyMSFService, Handler paramHandler)
  {
    super(paramAppInterface, paramEntityManager, paramExecutorService, paramReadInJoyMSFService, paramHandler);
    if (QLog.isColorLevel()) {
      QLog.d("SelfInfoModule", 2, "construct!");
    }
  }
  
  private ArrayList<ReadInJoyMedalInfo> a(List<oidb_cmd0x97b.MedalInfo> paramList, long paramLong)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        oidb_cmd0x97b.MedalInfo localMedalInfo = (oidb_cmd0x97b.MedalInfo)paramList.next();
        ReadInJoyMedalInfo localReadInJoyMedalInfo = new ReadInJoyMedalInfo();
        if (localMedalInfo.uint32_is_jump.has()) {
          localReadInJoyMedalInfo.e = localMedalInfo.uint32_is_jump.get();
        }
        if (localMedalInfo.bytes_jump_url.has()) {
          localReadInJoyMedalInfo.f = localMedalInfo.bytes_jump_url.get().toStringUtf8();
        }
        if (localMedalInfo.uint32_medal_type.has()) {
          localReadInJoyMedalInfo.d = localMedalInfo.uint32_medal_type.get();
        }
        if (localMedalInfo.uint64_medal_id.has()) {
          localReadInJoyMedalInfo.a = localMedalInfo.uint64_medal_id.get();
        }
        if (localMedalInfo.bytes_medal_name.has()) {
          localReadInJoyMedalInfo.b = localMedalInfo.bytes_medal_name.get().toStringUtf8();
        }
        if (localMedalInfo.bytes_medal_url.has()) {
          localReadInJoyMedalInfo.c = localMedalInfo.bytes_medal_url.get().toStringUtf8();
        }
        if (localMedalInfo.uint32_pic_width.has()) {
          localReadInJoyMedalInfo.g = localMedalInfo.uint32_pic_width.get();
        }
        if (localMedalInfo.uint32_pic_height.has()) {
          localReadInJoyMedalInfo.h = localMedalInfo.uint32_pic_height.get();
        }
        localReadInJoyMedalInfo.m = String.valueOf(paramLong);
        localArrayList.add(localReadInJoyMedalInfo);
      }
    }
    paramList = new StringBuilder();
    paramList.append("convertMedalInfo,count=");
    paramList.append(localArrayList.size());
    QLog.d("SelfInfoModule", 1, paramList.toString());
    return localArrayList;
  }
  
  private void a(ToServiceMsg paramToServiceMsg, KandianMsgBoxRedPntInfo paramKandianMsgBoxRedPntInfo)
  {
    String str;
    if (paramToServiceMsg.getAttribute("from") != null) {
      str = paramToServiceMsg.getAttribute("from").toString();
    } else {
      str = "";
    }
    long l = ((Long)paramToServiceMsg.getAttribute("privateChatUin", Long.valueOf(0L))).longValue();
    if ((TextUtils.equals(str, Integer.toString(3))) && (l != 0L)) {
      KandianMsgBoxRedPntInfoUtils.a(paramKandianMsgBoxRedPntInfo, l);
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SelfInfoModule", 2, "handle0x97bGetFollowAndFansCount!");
    }
    oidb_cmd0x97b.RspBody localRspBody = new oidb_cmd0x97b.RspBody();
    int j = ReadInJoyOidbHelper.a(paramFromServiceMsg, paramObject, localRspBody);
    int k = ((oidb_cmd0x97b.FollowCountInfo)localRspBody.msg_follow_count_info.get()).uint32_my_follow_count.get();
    int m = ((oidb_cmd0x97b.FollowCountInfo)localRspBody.msg_follow_count_info.get()).uint32_my_fans_count.get();
    paramFromServiceMsg = new ArrayList();
    if (((oidb_cmd0x97b.FollowCountInfo)localRspBody.msg_follow_count_info.get()).rpt_fans_detail_info.has())
    {
      paramToServiceMsg = ((oidb_cmd0x97b.FollowCountInfo)localRspBody.msg_follow_count_info.get()).rpt_fans_detail_info.get().iterator();
      while (paramToServiceMsg.hasNext())
      {
        paramObject = (oidb_cmd0x97b.CountDetailInfo)paramToServiceMsg.next();
        if (paramObject.enum_type.get() == 1)
        {
          localObject = new SelfInfoModule.BusinessCountInfo();
          ((SelfInfoModule.BusinessCountInfo)localObject).a = paramObject.uint32_id.get();
          ((SelfInfoModule.BusinessCountInfo)localObject).b = 1;
          ((SelfInfoModule.BusinessCountInfo)localObject).c = paramObject.bytes_name.get().toStringUtf8();
          ((SelfInfoModule.BusinessCountInfo)localObject).e = paramObject.bytes_icon_url.get().toStringUtf8();
          ((SelfInfoModule.BusinessCountInfo)localObject).d = paramObject.bytes_url.get().toStringUtf8();
          ((SelfInfoModule.BusinessCountInfo)localObject).f = paramObject.uint32_count.get();
          ((oidb_cmd0x97b.FollowCountInfo)localRspBody.msg_follow_count_info.get()).toByteArray();
          paramFromServiceMsg.add(localObject);
        }
      }
    }
    int i;
    if ((localRspBody.msg_limit_info.has()) && (((oidb_cmd0x97b.LimitInfo)localRspBody.msg_limit_info.get()).uint32_forbidden_flag.has())) {
      i = ((oidb_cmd0x97b.LimitInfo)localRspBody.msg_limit_info.get()).uint32_forbidden_flag.get();
    } else {
      i = 0;
    }
    boolean bool;
    if (i == 1) {
      bool = true;
    } else {
      bool = false;
    }
    if (QLog.isColorLevel())
    {
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("handle0x97bGetFollowAndFansCount result=");
      paramToServiceMsg.append(j);
      paramToServiceMsg.append(", followCnt=");
      paramToServiceMsg.append(k);
      paramToServiceMsg.append(", fansCnt=");
      paramToServiceMsg.append(m);
      paramToServiceMsg.append(", isForbidden=");
      paramToServiceMsg.append(bool);
      QLog.d("SelfInfoModule", 1, paramToServiceMsg.toString());
    }
    paramObject = ((oidb_cmd0x97b.SimpleInfo)localRspBody.msg_simpleinfo.get()).bytes_header_url.get().toStringUtf8();
    Object localObject = ((oidb_cmd0x97b.SimpleInfo)localRspBody.msg_simpleinfo.get()).bytes_nick.get().toStringUtf8();
    if (((oidb_cmd0x97b.SimpleInfo)localRspBody.msg_simpleinfo.get()).uint32_is_vip.has()) {
      i = ((oidb_cmd0x97b.SimpleInfo)localRspBody.msg_simpleinfo.get()).uint32_is_vip.get();
    } else {
      i = -1;
    }
    long l1;
    if (((oidb_cmd0x97b.SimpleInfo)localRspBody.msg_simpleinfo.get()).int64_like_total.has()) {
      l1 = ((oidb_cmd0x97b.SimpleInfo)localRspBody.msg_simpleinfo.get()).int64_like_total.get();
    } else {
      l1 = -1L;
    }
    long l2;
    if (((oidb_cmd0x97b.SimpleInfo)localRspBody.msg_simpleinfo.get()).int64_publish_feeds_total.has()) {
      l2 = ((oidb_cmd0x97b.SimpleInfo)localRspBody.msg_simpleinfo.get()).int64_publish_feeds_total.get();
    } else {
      l2 = -1L;
    }
    if (((oidb_cmd0x97b.SimpleInfo)localRspBody.msg_simpleinfo.get()).bytes_desc.has()) {
      paramToServiceMsg = ((oidb_cmd0x97b.SimpleInfo)localRspBody.msg_simpleinfo.get()).bytes_desc.get().toStringUtf8();
    } else {
      paramToServiceMsg = "";
    }
    long l3;
    if (((oidb_cmd0x97b.SimpleInfo)localRspBody.msg_simpleinfo.get()).msg_sign_in.has()) {
      l3 = ((oidb_cmd0x97b.SignIn)((oidb_cmd0x97b.SimpleInfo)localRspBody.msg_simpleinfo.get()).msg_sign_in.get()).int64_status.get();
    } else {
      l3 = -1L;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handle0x97bGetFollowAndFansCount result userinfo=");
      localStringBuilder.append(j);
      localStringBuilder.append(", signinStatus=");
      localStringBuilder.append(l3);
      localStringBuilder.append(", userDesc=");
      localStringBuilder.append(paramToServiceMsg);
      localStringBuilder.append(",userTotalLike=");
      localStringBuilder.append(l1);
      localStringBuilder.append(",userTotalFeeds=");
      localStringBuilder.append(l2);
      QLog.d("SelfInfoModule", 1, localStringBuilder.toString());
    }
    RIJUserInfoSp.a(this.mApp, k, m, paramFromServiceMsg);
    RIJUserInfoSp.a(this.mApp, bool);
    RIJUserInfoSp.a(this.mApp, paramObject, (String)localObject, i, l1, l2, paramToServiceMsg, l3);
    paramToServiceMsg = null;
    if (localRspBody.msg_simpleinfo.rpt_msg_medal_info.has())
    {
      l1 = 0L;
      if (localRspBody.uint64_uin.has()) {
        l1 = localRspBody.uint64_uin.get();
      }
      paramToServiceMsg = a(localRspBody.msg_simpleinfo.rpt_msg_medal_info.get(), l1);
    }
    if ((paramToServiceMsg != null) && (!paramToServiceMsg.isEmpty()))
    {
      RIJUserInfoSp.a(this.mApp, (ReadInJoyMedalInfo)paramToServiceMsg.get(0));
      return;
    }
    RIJUserInfoSp.a(this.mApp);
  }
  
  private void a(String paramString, int paramInt, SelfInfoModule.IGetMsgBoxRedDotInfoCallback paramIGetMsgBoxRedDotInfoCallback, long paramLong)
  {
    oidb_cmd0xbe4.ReqBody localReqBody = new oidb_cmd0xbe4.ReqBody();
    localReqBody.client_version.set("8.8.17");
    oidb_cmd0xbe4.MsgGetReq localMsgGetReq = new oidb_cmd0xbe4.MsgGetReq();
    if (RIJKanDianMessageAladdinConfig.a.a() == 2)
    {
      QLog.d("SelfInfoModule", 2, "send0xbe4Req cardMode add flag!");
      localMsgGetReq.uint32_msg_content.set(1);
      if (!paramString.isEmpty()) {
        localMsgGetReq.str_msgid.set(paramString);
      }
    }
    localReqBody.msg_get_req.set(localMsgGetReq);
    paramString = ReadInJoyOidbHelper.a("OidbSvc.0xbe4", 3044, 1, localReqBody.toByteArray());
    paramString.addAttribute("from", Integer.toString(paramInt));
    paramString.addAttribute("privateChatUin", Long.valueOf(paramLong));
    if (paramIGetMsgBoxRedDotInfoCallback != null) {
      this.a.put(Integer.valueOf(paramString.getRequestSsoSeq()), paramIGetMsgBoxRedDotInfoCallback);
    }
    sendPbReq(paramString);
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Object localObject = new oidb_cmd0xbe4.RspBody();
    int i = ReadInJoyOidbHelper.a(paramFromServiceMsg, paramObject, (MessageMicro)localObject);
    SelfInfoModule.IGetMsgBoxRedDotInfoCallback localIGetMsgBoxRedDotInfoCallback = (SelfInfoModule.IGetMsgBoxRedDotInfoCallback)this.a.remove(Integer.valueOf(paramToServiceMsg.getRequestSsoSeq()));
    if (i == 0)
    {
      paramFromServiceMsg = (oidb_cmd0xbe4.MsgGetRsp)((oidb_cmd0xbe4.RspBody)localObject).msg_get_rsp.get();
      if (paramFromServiceMsg != null)
      {
        paramObject = KandianMsgBoxRedPntInfoUtils.a(paramFromServiceMsg);
        paramFromServiceMsg = paramObject;
        if (paramObject == null) {
          break label187;
        }
        localObject = RIJQQAppInterfaceUtil.e();
        paramFromServiceMsg = paramObject;
        if (localObject == null) {
          break label187;
        }
        localObject = (KandianMergeManager)((AppRuntime)localObject).getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER);
        paramFromServiceMsg = paramObject;
        if (localObject == null) {
          break label187;
        }
        paramFromServiceMsg = new StringBuilder();
        paramFromServiceMsg.append("update msgbox : ");
        paramFromServiceMsg.append(paramObject);
        QLog.d("SelfInfoModule", 1, paramFromServiceMsg.toString());
        if ((paramToServiceMsg.getAttribute("from") != null) && (paramToServiceMsg.getAttribute("from").toString().equals(Integer.toString(2)))) {
          paramObject.isFromNotification = true;
        }
        a(paramToServiceMsg, paramObject);
        ((KandianMergeManager)localObject).a(paramObject);
        paramFromServiceMsg = paramObject;
        break label187;
      }
    }
    paramFromServiceMsg = null;
    label187:
    if (localIGetMsgBoxRedDotInfoCallback != null) {
      localIGetMsgBoxRedDotInfoCallback.a(paramFromServiceMsg);
    }
    paramToServiceMsg = new StringBuilder();
    paramToServiceMsg.append("handleGetMsgBoxResp, retCode : ");
    paramToServiceMsg.append(i);
    QLog.d("SelfInfoModule", 1, paramToServiceMsg.toString());
  }
  
  public void a(int paramInt, String paramString, SelfInfoModule.IGetMsgBoxRedDotInfoCallback paramIGetMsgBoxRedDotInfoCallback, long paramLong)
  {
    if (!((Boolean)RIJSPUtils.b("sp_msg_box_80a_enable_receive", Boolean.valueOf(true))).booleanValue())
    {
      QLog.d("SelfInfoModule", 1, "unable to show msgbox redpnt, give up send req !");
      return;
    }
    if (paramString.isEmpty())
    {
      if ((RIJRedDotAladdinConfig.a.a() == 1) && (paramInt == 0))
      {
        QLog.d("SelfInfoModule", 2, "getMsgBoxRedPntInfoFromServer use new route, give up request!");
        return;
      }
      if (System.currentTimeMillis() - this.b < 200L) {
        QLog.d("SelfInfoModule", 2, "getMsgBoxRedPntInfoFromServer has excute now, give up !");
      }
      this.b = System.currentTimeMillis();
      a("", paramInt, paramIGetMsgBoxRedDotInfoCallback, paramLong);
      paramString = new StringBuilder();
      paramString.append("trigger get MsgRedPntReq, from ");
      paramString.append(paramInt);
      QLog.d("SelfInfoModule", 1, paramString.toString());
      return;
    }
    if (System.currentTimeMillis() - this.c < 200L) {
      QLog.d("SelfInfoModule", 2, "getMsgBoxRedPntInfoFromServer has excute now, give up !");
    }
    this.c = System.currentTimeMillis();
    a(paramString, paramInt, paramIGetMsgBoxRedDotInfoCallback, paramLong);
    paramIGetMsgBoxRedDotInfoCallback = new StringBuilder();
    paramIGetMsgBoxRedDotInfoCallback.append("getMsgBoxRedPntInfoFromServerWithMsgId: from = ");
    paramIGetMsgBoxRedDotInfoCallback.append(paramInt);
    paramIGetMsgBoxRedDotInfoCallback.append(", messageId = ");
    paramIGetMsgBoxRedDotInfoCallback.append(paramString);
    QLog.d("SelfInfoModule", 1, paramIGetMsgBoxRedDotInfoCallback.toString());
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onReceive response cmd=");
      localStringBuilder.append(paramFromServiceMsg.getServiceCmd());
      QLog.d("SelfInfoModule", 2, localStringBuilder.toString());
    }
    if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0x97b"))
    {
      a(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0xbe4")) {
      b(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
  
  public void unInitialize()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SelfInfoModule", 2, "unInitialize!");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.common.SelfInfoModule
 * JD-Core Version:    0.7.0.1
 */