import android.os.Handler;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.model.SelfInfoModule.1;
import com.tencent.biz.pubaccount.readinjoy.struct.KandianMsgBoxRedPntInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
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
import tencent.im.oidb.cmd0x97b.oidb_cmd0x97b.ReqBody;
import tencent.im.oidb.cmd0x97b.oidb_cmd0x97b.RspBody;
import tencent.im.oidb.cmd0x97b.oidb_cmd0x97b.SignIn;
import tencent.im.oidb.cmd0x97b.oidb_cmd0x97b.SimpleInfo;
import tencent.im.oidb.cmd0xbe4.oidb_cmd0xbe4.MsgGetReq;
import tencent.im.oidb.cmd0xbe4.oidb_cmd0xbe4.MsgGetRsp;
import tencent.im.oidb.cmd0xbe4.oidb_cmd0xbe4.ReqBody;
import tencent.im.oidb.cmd0xbe4.oidb_cmd0xbe4.RspBody;

public class pbn
  extends pbe
{
  private volatile long jdField_a_of_type_Long;
  private Map<Integer, pbp> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  private volatile long b;
  
  public pbn(AppInterface paramAppInterface, aukp paramaukp, ExecutorService paramExecutorService, por parampor, Handler paramHandler)
  {
    super(paramAppInterface, paramaukp, paramExecutorService, parampor, paramHandler);
    if (QLog.isColorLevel()) {
      QLog.d("SelfInfoModule", 2, "construct!");
    }
  }
  
  private ArrayList<ntz> a(List<oidb_cmd0x97b.MedalInfo> paramList, long paramLong)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        oidb_cmd0x97b.MedalInfo localMedalInfo = (oidb_cmd0x97b.MedalInfo)paramList.next();
        ntz localntz = new ntz();
        if (localMedalInfo.uint32_is_jump.has()) {
          localntz.jdField_b_of_type_Int = localMedalInfo.uint32_is_jump.get();
        }
        if (localMedalInfo.bytes_jump_url.has()) {
          localntz.jdField_c_of_type_JavaLangString = localMedalInfo.bytes_jump_url.get().toStringUtf8();
        }
        if (localMedalInfo.uint32_medal_type.has()) {
          localntz.jdField_a_of_type_Int = localMedalInfo.uint32_medal_type.get();
        }
        if (localMedalInfo.uint64_medal_id.has()) {
          localntz.jdField_a_of_type_Long = localMedalInfo.uint64_medal_id.get();
        }
        if (localMedalInfo.bytes_medal_name.has()) {
          localntz.jdField_a_of_type_JavaLangString = localMedalInfo.bytes_medal_name.get().toStringUtf8();
        }
        if (localMedalInfo.bytes_medal_url.has()) {
          localntz.jdField_b_of_type_JavaLangString = localMedalInfo.bytes_medal_url.get().toStringUtf8();
        }
        if (localMedalInfo.uint32_pic_width.has()) {
          localntz.jdField_c_of_type_Int = localMedalInfo.uint32_pic_width.get();
        }
        if (localMedalInfo.uint32_pic_height.has()) {
          localntz.d = localMedalInfo.uint32_pic_height.get();
        }
        localntz.h = String.valueOf(paramLong);
        localArrayList.add(localntz);
      }
    }
    QLog.d("SelfInfoModule", 1, "convertMedalInfo,count=" + localArrayList.size());
    return localArrayList;
  }
  
  private void a(String paramString, int paramInt, pbp parampbp)
  {
    oidb_cmd0xbe4.ReqBody localReqBody = new oidb_cmd0xbe4.ReqBody();
    localReqBody.client_version.set("8.3.0");
    oidb_cmd0xbe4.MsgGetReq localMsgGetReq = new oidb_cmd0xbe4.MsgGetReq();
    if (Aladdin.getConfig(215).getIntegerFromString("message_reddot_style", 0) == 2)
    {
      QLog.d("SelfInfoModule", 2, "send0xbe4Req cardMode add flag!");
      localMsgGetReq.uint32_msg_content.set(1);
      if (!paramString.isEmpty()) {
        localMsgGetReq.str_msgid.set(paramString);
      }
    }
    localReqBody.msg_get_req.set(localMsgGetReq);
    paramString = pot.a("OidbSvc.0xbe4", 3044, 1, localReqBody.toByteArray());
    paramString.addAttribute("from", Integer.toString(paramInt));
    if (parampbp != null) {
      this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(paramString.getRequestSsoSeq()), parampbp);
    }
    a(paramString);
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SelfInfoModule", 2, "handle0x97bGetFollowAndFansCount!");
    }
    oidb_cmd0x97b.RspBody localRspBody = new oidb_cmd0x97b.RspBody();
    int j = pot.a(paramFromServiceMsg, paramObject, localRspBody);
    int k = ((oidb_cmd0x97b.FollowCountInfo)localRspBody.msg_follow_count_info.get()).uint32_my_follow_count.get();
    int m = ((oidb_cmd0x97b.FollowCountInfo)localRspBody.msg_follow_count_info.get()).uint32_my_fans_count.get();
    paramFromServiceMsg = new ArrayList();
    Object localObject;
    if (((oidb_cmd0x97b.FollowCountInfo)localRspBody.msg_follow_count_info.get()).rpt_fans_detail_info.has())
    {
      paramToServiceMsg = ((oidb_cmd0x97b.FollowCountInfo)localRspBody.msg_follow_count_info.get()).rpt_fans_detail_info.get().iterator();
      while (paramToServiceMsg.hasNext())
      {
        paramObject = (oidb_cmd0x97b.CountDetailInfo)paramToServiceMsg.next();
        if (paramObject.enum_type.get() == 1)
        {
          localObject = new pbo();
          ((pbo)localObject).jdField_a_of_type_Int = paramObject.uint32_id.get();
          ((pbo)localObject).jdField_b_of_type_Int = 1;
          ((pbo)localObject).jdField_a_of_type_JavaLangString = paramObject.bytes_name.get().toStringUtf8();
          ((pbo)localObject).jdField_c_of_type_JavaLangString = paramObject.bytes_icon_url.get().toStringUtf8();
          ((pbo)localObject).jdField_b_of_type_JavaLangString = paramObject.bytes_url.get().toStringUtf8();
          ((pbo)localObject).jdField_c_of_type_Int = paramObject.uint32_count.get();
          ((oidb_cmd0x97b.FollowCountInfo)localRspBody.msg_follow_count_info.get()).toByteArray();
          paramFromServiceMsg.add(localObject);
        }
      }
    }
    if ((localRspBody.msg_limit_info.has()) && (((oidb_cmd0x97b.LimitInfo)localRspBody.msg_limit_info.get()).uint32_forbidden_flag.has())) {}
    for (int i = ((oidb_cmd0x97b.LimitInfo)localRspBody.msg_limit_info.get()).uint32_forbidden_flag.get();; i = 0)
    {
      boolean bool;
      label468:
      long l1;
      label507:
      long l2;
      label546:
      label587:
      long l3;
      if (i == 1)
      {
        bool = true;
        if (QLog.isColorLevel()) {
          QLog.d("SelfInfoModule", 1, "handle0x97bGetFollowAndFansCount result=" + j + ", followCnt=" + k + ", fansCnt=" + m + ", isForbidden=" + bool);
        }
        paramObject = ((oidb_cmd0x97b.SimpleInfo)localRspBody.msg_simpleinfo.get()).bytes_header_url.get().toStringUtf8();
        localObject = ((oidb_cmd0x97b.SimpleInfo)localRspBody.msg_simpleinfo.get()).bytes_nick.get().toStringUtf8();
        if (!((oidb_cmd0x97b.SimpleInfo)localRspBody.msg_simpleinfo.get()).uint32_is_vip.has()) {
          break label866;
        }
        i = ((oidb_cmd0x97b.SimpleInfo)localRspBody.msg_simpleinfo.get()).uint32_is_vip.get();
        if (!((oidb_cmd0x97b.SimpleInfo)localRspBody.msg_simpleinfo.get()).int64_like_total.has()) {
          break label872;
        }
        l1 = ((oidb_cmd0x97b.SimpleInfo)localRspBody.msg_simpleinfo.get()).int64_like_total.get();
        if (!((oidb_cmd0x97b.SimpleInfo)localRspBody.msg_simpleinfo.get()).int64_publish_feeds_total.has()) {
          break label880;
        }
        l2 = ((oidb_cmd0x97b.SimpleInfo)localRspBody.msg_simpleinfo.get()).int64_publish_feeds_total.get();
        if (!((oidb_cmd0x97b.SimpleInfo)localRspBody.msg_simpleinfo.get()).bytes_desc.has()) {
          break label888;
        }
        paramToServiceMsg = ((oidb_cmd0x97b.SimpleInfo)localRspBody.msg_simpleinfo.get()).bytes_desc.get().toStringUtf8();
        if (!((oidb_cmd0x97b.SimpleInfo)localRspBody.msg_simpleinfo.get()).msg_sign_in.has()) {
          break label895;
        }
        l3 = ((oidb_cmd0x97b.SignIn)((oidb_cmd0x97b.SimpleInfo)localRspBody.msg_simpleinfo.get()).msg_sign_in.get()).int64_status.get();
        label635:
        if (QLog.isColorLevel()) {
          QLog.d("SelfInfoModule", 1, "handle0x97bGetFollowAndFansCount result userinfo=" + j + ", signinStatus=" + l3 + ", userDesc=" + paramToServiceMsg + ",userTotalLike=" + l1 + ",userTotalFeeds=" + l2);
        }
        bhvy.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, k, m, paramFromServiceMsg);
        bhvy.k(this.jdField_a_of_type_ComTencentCommonAppAppInterface, bool);
        bhvy.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramObject, (String)localObject, i, l1, l2, paramToServiceMsg, l3);
        paramToServiceMsg = null;
        if (localRspBody.msg_simpleinfo.rpt_msg_medal_info.has())
        {
          l1 = 0L;
          if (localRspBody.uint64_uin.has()) {
            l1 = localRspBody.uint64_uin.get();
          }
          paramToServiceMsg = a(localRspBody.msg_simpleinfo.rpt_msg_medal_info.get(), l1);
        }
        if ((paramToServiceMsg == null) || (paramToServiceMsg.isEmpty())) {
          break label903;
        }
        bhvy.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, (ntz)paramToServiceMsg.get(0));
      }
      for (;;)
      {
        this.jdField_a_of_type_AndroidOsHandler.post(new SelfInfoModule.1(this, j, k, m, bool));
        return;
        bool = false;
        break;
        label866:
        i = -1;
        break label468;
        label872:
        l1 = -1L;
        break label507;
        label880:
        l2 = -1L;
        break label546;
        label888:
        paramToServiceMsg = "";
        break label587;
        label895:
        l3 = -1L;
        break label635;
        label903:
        bhvy.e(this.jdField_a_of_type_ComTencentCommonAppAppInterface);
      }
    }
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Object localObject = new oidb_cmd0xbe4.RspBody();
    int i = pot.a(paramFromServiceMsg, paramObject, (MessageMicro)localObject);
    paramObject = (pbp)this.jdField_a_of_type_JavaUtilMap.remove(Integer.valueOf(paramToServiceMsg.getRequestSsoSeq()));
    if (i == 0)
    {
      paramFromServiceMsg = (oidb_cmd0xbe4.MsgGetRsp)((oidb_cmd0xbe4.RspBody)localObject).msg_get_rsp.get();
      if (paramFromServiceMsg != null)
      {
        paramFromServiceMsg = KandianMsgBoxRedPntInfo.createFromPB(paramFromServiceMsg);
        if (paramFromServiceMsg != null)
        {
          localObject = onh.a();
          if (localObject != null)
          {
            localObject = (KandianMergeManager)((AppRuntime)localObject).getManager(162);
            if (localObject != null)
            {
              QLog.d("SelfInfoModule", 1, "update msgbox : " + paramFromServiceMsg);
              if ((paramToServiceMsg.getAttribute("from") != null) && (paramToServiceMsg.getAttribute("from").toString().equals(Integer.toString(2)))) {
                paramFromServiceMsg.isFromNotification = true;
              }
              ((KandianMergeManager)localObject).a(paramFromServiceMsg);
            }
          }
        }
      }
    }
    for (paramToServiceMsg = paramFromServiceMsg;; paramToServiceMsg = null)
    {
      if (paramObject != null) {
        paramObject.a(paramToServiceMsg);
      }
      QLog.d("SelfInfoModule", 1, "handleGetMsgBoxResp, retCode : " + i);
      return;
    }
  }
  
  public void a(int paramInt, String paramString, pbp parampbp)
  {
    if (paramString.isEmpty())
    {
      if ((Aladdin.getConfig(186).getIntegerFromString("use_new_route", 0) == 1) && (paramInt == 0))
      {
        QLog.d("SelfInfoModule", 2, "getMsgBoxRedPntInfoFromServer use new route, give up request!");
        return;
      }
      if (System.currentTimeMillis() - this.jdField_a_of_type_Long < 200L) {
        QLog.d("SelfInfoModule", 2, "getMsgBoxRedPntInfoFromServer has excute now, give up !");
      }
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      a("", paramInt, parampbp);
      QLog.d("SelfInfoModule", 1, "trigger get MsgRedPntReq, from " + paramInt);
      return;
    }
    if (System.currentTimeMillis() - this.b < 200L) {
      QLog.d("SelfInfoModule", 2, "getMsgBoxRedPntInfoFromServer has excute now, give up !");
    }
    this.b = System.currentTimeMillis();
    a(paramString, paramInt, parampbp);
    QLog.d("SelfInfoModule", 1, "getMsgBoxRedPntInfoFromServerWithMsgId: from = " + paramInt + ", messageId = " + paramString);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SelfInfoModule", 2, "onReceive response cmd=" + paramFromServiceMsg.getServiceCmd());
    }
    if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0x97b")) {
      b(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
    while (!paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0xbe4")) {
      return;
    }
    c(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SelfInfoModule", 2, "getSelfFollowAndFansCount uin=" + paramString);
    }
    oidb_cmd0x97b.ReqBody localReqBody = new oidb_cmd0x97b.ReqBody();
    long l1 = 0L;
    try
    {
      long l2 = Long.parseLong(paramString);
      l1 = l2;
    }
    catch (Exception paramString)
    {
      label52:
      break label52;
    }
    localReqBody.uint64_uin.set(l1);
    localReqBody.uint32_req_ctrl_bits.set(3);
    localReqBody.uint32_like_total.set(1);
    localReqBody.uint32_sign_in.set(1);
    localReqBody.uint32_publish_feeds_total.set(1);
    localReqBody.uint32_medal.set(1);
    a(pot.a("OidbSvc.0x97b", 2427, 1, localReqBody.toByteArray()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pbn
 * JD-Core Version:    0.7.0.1
 */