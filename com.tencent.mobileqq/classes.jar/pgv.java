import android.os.Handler;
import com.tencent.biz.pubaccount.readinjoy.model.RecommendFollowForChangeModule.1;
import com.tencent.biz.pubaccount.readinjoy.struct.RecommendFollowInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import tencent.im.oidb.cmd0xbbe.oidb_cmd0xbbe.GetRecommendAccountRsp;
import tencent.im.oidb.cmd0xbbe.oidb_cmd0xbbe.RecommendAccountInfo;
import tencent.im.oidb.cmd0xbbe.oidb_cmd0xbbe.ReqBody;
import tencent.im.oidb.cmd0xbbe.oidb_cmd0xbbe.RspBody;

public class pgv
  extends pgp
{
  public static final String a;
  
  static
  {
    jdField_a_of_type_JavaLangString = pgv.class.getSimpleName();
  }
  
  public pgv(AppInterface paramAppInterface, awbw paramawbw, ExecutorService paramExecutorService, puz parampuz, Handler paramHandler)
  {
    super(paramAppInterface, paramawbw, paramExecutorService, parampuz, paramHandler);
  }
  
  private void a(boolean paramBoolean, long paramLong, List<RecommendFollowInfo> paramList)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new RecommendFollowForChangeModule.1(this, paramBoolean, paramLong, paramList));
  }
  
  public void a() {}
  
  public void a(long paramLong, byte[] paramArrayOfByte)
  {
    oidb_cmd0xbbe.ReqBody localReqBody = new oidb_cmd0xbbe.ReqBody();
    localReqBody.uint64_article_id.set(paramLong);
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0)) {
      localReqBody.bytes_info_cookie.set(ByteStringMicro.copyFrom(paramArrayOfByte));
    }
    a(pvb.a("OidbSvc.0xbbe", 3006, 1, localReqBody.toByteArray()));
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = paramFromServiceMsg.getResultCode();
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onReceive response cmd = " + paramFromServiceMsg.getServiceCmd() + ", code = " + i);
    }
    if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0xbbe"))
    {
      if (i != 1000) {
        a(false, -1L, null);
      }
    }
    else {
      return;
    }
    for (;;)
    {
      try
      {
        Object localObject = new oidb_cmd0xbbe.RspBody();
        if (pvb.a(paramFromServiceMsg, paramObject, (MessageMicro)localObject) != 0) {
          break label525;
        }
        if ((!((oidb_cmd0xbbe.RspBody)localObject).msg_get_recommend_account_rsp.has()) || (!((oidb_cmd0xbbe.GetRecommendAccountRsp)((oidb_cmd0xbbe.RspBody)localObject).msg_get_recommend_account_rsp.get()).rpt_msg_recommend_account_info.has())) {
          break;
        }
        paramToServiceMsg = new ArrayList();
        if (!((oidb_cmd0xbbe.RspBody)localObject).uint64_article_id.has()) {
          break label535;
        }
        l = ((oidb_cmd0xbbe.RspBody)localObject).uint64_article_id.get();
        paramFromServiceMsg = ((oidb_cmd0xbbe.GetRecommendAccountRsp)((oidb_cmd0xbbe.RspBody)localObject).msg_get_recommend_account_rsp.get()).rpt_msg_recommend_account_info.get().iterator();
        if (!paramFromServiceMsg.hasNext()) {
          break label507;
        }
        paramObject = (oidb_cmd0xbbe.RecommendAccountInfo)paramFromServiceMsg.next();
        localObject = new RecommendFollowInfo();
        if (paramObject.uint64_uin.has()) {
          ((RecommendFollowInfo)localObject).uin = paramObject.uint64_uin.get();
        }
        if (paramObject.uint32_account_type.has()) {
          ((RecommendFollowInfo)localObject).type = paramObject.uint32_account_type.get();
        }
        if (paramObject.bytes_recommend_reason.has()) {
          ((RecommendFollowInfo)localObject).recommendReason = paramObject.bytes_recommend_reason.get().toStringUtf8();
        }
        if (paramObject.bytes_nick_name.has()) {
          ((RecommendFollowInfo)localObject).nickName = paramObject.bytes_nick_name.get().toStringUtf8();
        }
        if (paramObject.bytes_head_img_url.has()) {
          ((RecommendFollowInfo)localObject).headUrl = paramObject.bytes_head_img_url.get().toStringUtf8();
        }
        if (paramObject.uint32_is_vip.has())
        {
          if (paramObject.uint32_is_vip.get() == 1)
          {
            bool = true;
            ((RecommendFollowInfo)localObject).isVip = bool;
          }
        }
        else
        {
          if (paramObject.uint32_is_star.has())
          {
            if (paramObject.uint32_is_star.get() != 1) {
              break label501;
            }
            bool = true;
            ((RecommendFollowInfo)localObject).isStar = bool;
          }
          if (paramObject.uint64_algorithm_id.has()) {
            ((RecommendFollowInfo)localObject).algorithmId = paramObject.uint64_algorithm_id.get();
          }
          if (paramObject.uint32_strategy_id.has()) {
            ((RecommendFollowInfo)localObject).strategyId = paramObject.uint32_strategy_id.get();
          }
          paramToServiceMsg.add(localObject);
          continue;
        }
        bool = false;
      }
      catch (Exception paramToServiceMsg)
      {
        if (QLog.isColorLevel()) {
          QLog.e(jdField_a_of_type_JavaLangString, 2, "onReceive e = " + QLog.getStackTraceString(paramToServiceMsg));
        }
        a(false, -1L, null);
        return;
      }
      continue;
      label501:
      boolean bool = false;
      continue;
      label507:
      if (paramToServiceMsg.size() <= 0) {
        break;
      }
      a(true, l, paramToServiceMsg);
      return;
      label525:
      a(false, -1L, null);
      return;
      label535:
      long l = 0L;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     pgv
 * JD-Core Version:    0.7.0.1
 */