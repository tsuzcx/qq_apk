import android.text.TextUtils;
import com.tencent.av.business.handler.NetAddr;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.audiotrans.AudioTransClientTransInfo.IntC2SChangeSessionReq;
import com.tencent.mobileqq.audiotrans.AudioTransClientTransInfo.IntC2SChangeSessionRsp;
import com.tencent.mobileqq.audiotrans.AudioTransClientTransInfo.IntC2SExitSessionReq;
import com.tencent.mobileqq.audiotrans.AudioTransClientTransInfo.IntC2SFailedRsp;
import com.tencent.mobileqq.audiotrans.AudioTransClientTransInfo.IntC2SJoinSessionReq;
import com.tencent.mobileqq.audiotrans.AudioTransClientTransInfo.IntC2SJoinSessionRsp;
import com.tencent.mobileqq.audiotrans.AudioTransClientTransInfo.IntC2SRawDataReq;
import com.tencent.mobileqq.audiotrans.AudioTransClientTransInfo.IntHead;
import com.tencent.mobileqq.audiotrans.AudioTransClientTransInfo.IntReqBody;
import com.tencent.mobileqq.audiotrans.AudioTransClientTransInfo.IntRspBody;
import com.tencent.mobileqq.audiotrans.AudioTransClientTransInfo.IntS2CNotifyExitReq;
import com.tencent.mobileqq.audiotrans.AudioTransClientTransInfo.IntS2CPushDataReq;
import com.tencent.mobileqq.audiotrans.AudioTransCommon.NetAddr;
import com.tencent.mobileqq.audiotrans.AudioTransCommon.TranslateResult;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import mqq.app.MobileQQ;

public abstract class liy
  extends alpd
{
  private int jdField_a_of_type_Int;
  private Random jdField_a_of_type_JavaUtilRandom = new Random();
  private lit jdField_a_of_type_Lit = lit.a();
  private lix jdField_a_of_type_Lix = lix.a();
  private int b;
  
  public liy(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
  }
  
  private AudioTransClientTransInfo.IntHead a(int paramInt1, int paramInt2)
  {
    AudioTransClientTransInfo.IntHead localIntHead = new AudioTransClientTransInfo.IntHead();
    localIntHead.str_session_id.set(String.valueOf(this.jdField_a_of_type_Lix.jdField_a_of_type_Long));
    localIntHead.str_uin.set(this.mApp.getCurrentAccountUin());
    localIntHead.uint32_seq.set(paramInt2);
    localIntHead.enum_body_type.set(paramInt1);
    return localIntHead;
  }
  
  private AudioTransClientTransInfo.IntReqBody a(int paramInt1, boolean paramBoolean, int paramInt2, byte[] paramArrayOfByte)
  {
    AudioTransClientTransInfo.IntReqBody localIntReqBody = new AudioTransClientTransInfo.IntReqBody();
    if (paramInt1 == 1)
    {
      paramArrayOfByte = new AudioTransClientTransInfo.IntC2SJoinSessionReq();
      paramArrayOfByte.uint32_client_ver.set(mww.b());
      paramArrayOfByte.enum_term.set(4);
      paramArrayOfByte.enum_net_type.set(2);
      paramArrayOfByte.uint32_client_port.set(12331);
      paramArrayOfByte.enum_business_direction.set(paramInt2);
      paramArrayOfByte.enum_data_source.set(3);
      paramArrayOfByte.bool_translate.set(paramBoolean);
      localIntReqBody.msg_join_session_req.set(paramArrayOfByte);
    }
    do
    {
      return localIntReqBody;
      if (paramInt1 == 3)
      {
        paramArrayOfByte = new AudioTransClientTransInfo.IntC2SExitSessionReq();
        localIntReqBody.msg_exit_session_req.set(paramArrayOfByte);
        return localIntReqBody;
      }
      if (paramInt1 == 7)
      {
        AudioTransClientTransInfo.IntC2SRawDataReq localIntC2SRawDataReq = new AudioTransClientTransInfo.IntC2SRawDataReq();
        if (paramArrayOfByte != null) {
          localIntC2SRawDataReq.bytes_data.set(ByteStringMicro.copyFrom(paramArrayOfByte));
        }
        localIntC2SRawDataReq.str_key.set("str_key");
        localIntReqBody.msg_raw_data_req.set(localIntC2SRawDataReq);
        return localIntReqBody;
      }
    } while (paramInt1 != 5);
    paramArrayOfByte = new AudioTransClientTransInfo.IntC2SChangeSessionReq();
    paramArrayOfByte.bool_translate.set(paramBoolean);
    localIntReqBody.msg_change_session_req.set(paramArrayOfByte);
    return localIntReqBody;
  }
  
  protected abstract int a();
  
  public void a(int paramInt, byte[] paramArrayOfByte)
  {
    Object localObject1 = this.jdField_a_of_type_Lit;
    localObject1 = lit.a(paramArrayOfByte);
    paramArrayOfByte = ((liu)localObject1).a;
    localObject1 = ((liu)localObject1).b;
    Object localObject2 = new AudioTransClientTransInfo.IntHead();
    try
    {
      paramArrayOfByte = (AudioTransClientTransInfo.IntHead)((AudioTransClientTransInfo.IntHead)localObject2).mergeFrom(paramArrayOfByte);
      paramInt = paramArrayOfByte.enum_body_type.get();
      QLog.d("AudioTransClientInterfaceHandler", 2, "onReceivePush bodyType = " + paramInt + "|" + paramArrayOfByte.uint32_error_no.get());
      if (paramArrayOfByte.uint32_error_no.get() != 0) {
        return;
      }
      paramArrayOfByte = paramArrayOfByte.str_uin.get().toString();
      localObject1 = (AudioTransClientTransInfo.IntReqBody)new AudioTransClientTransInfo.IntReqBody().mergeFrom((byte[])localObject1);
      switch (paramInt)
      {
      case 11: 
        localObject1 = (AudioTransClientTransInfo.IntS2CPushDataReq)((AudioTransClientTransInfo.IntReqBody)localObject1).msg_push_data_req.get();
        ((AudioTransClientTransInfo.IntS2CPushDataReq)localObject1).str_key.get().toString();
        localObject2 = ((AudioTransClientTransInfo.IntS2CPushDataReq)localObject1).translate_result.get().toByteArray();
        localObject1 = new AudioTransCommon.TranslateResult();
        ((AudioTransCommon.TranslateResult)localObject1).mergeFrom((byte[])localObject2);
        localObject2 = new String(((AudioTransCommon.TranslateResult)localObject1).bytes_src_text.get().toByteArray());
        String str = new String(((AudioTransCommon.TranslateResult)localObject1).bytes_tar_text.get().toByteArray());
        paramInt = ((AudioTransCommon.TranslateResult)localObject1).int32_status.get();
        QLog.d("AudioTransClientInterfaceHandler", 2, "onReceivePush data:" + paramArrayOfByte + "|" + paramInt + "|" + (String)localObject2 + "|" + str);
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          return;
        }
        a(paramArrayOfByte, (String)localObject2, str, paramInt);
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
      QLog.e("AudioTransClientInterfaceHandler", 2, "onReceivePush exception = " + paramArrayOfByte.getMessage(), paramArrayOfByte);
      return;
    }
    paramInt = ((AudioTransClientTransInfo.IntS2CNotifyExitReq)((AudioTransClientTransInfo.IntReqBody)localObject1).msg_notify_exit_req.get()).uint32_reason.get();
    QLog.d("AudioTransClientInterfaceHandler", 2, "onReceivePush exit:" + paramArrayOfByte + "|" + paramInt);
    return;
  }
  
  protected abstract void a(long paramLong1, boolean paramBoolean, List<NetAddr> paramList, long paramLong2);
  
  public void a(String paramString1, long paramLong, String paramString2, byte[] paramArrayOfByte)
  {
    boolean bool2 = false;
    int m = this.jdField_a_of_type_Int;
    ToServiceMsg localToServiceMsg = createToServiceMsg(paramString2);
    int i = -1;
    int k = 4;
    boolean bool1;
    int j;
    if ("TransInfo.JoinSession".equals(paramString2))
    {
      this.jdField_a_of_type_Int = 0;
      bool1 = a();
      j = a();
      i = 1;
    }
    for (;;)
    {
      AudioTransClientTransInfo.IntHead localIntHead = a(i, (int)paramLong);
      paramArrayOfByte = a(i, bool1, j, paramArrayOfByte);
      lit locallit = this.jdField_a_of_type_Lit;
      localToServiceMsg.putWupBuffer(lit.a(localIntHead.toByteArray(), paramArrayOfByte.toByteArray()));
      if (bdin.g(this.mApp.getApplication().getApplicationContext())) {
        sendPbReq(localToServiceMsg);
      }
      QLog.w("AudioTransClientInterfaceHandler", 1, "sendCmdToServiceSSO, cmd[" + paramString2 + "], seq[" + paramLong + "], bodyType[" + i + "], trans_english[" + bool1 + "], bussiness_direction[" + j + "], mSendRawDataCount[" + m + "->" + this.jdField_a_of_type_Int + "], from[" + paramString1 + "]");
      return;
      if ("TransInfo.ExitSession".equals(paramString2))
      {
        i = 3;
        j = k;
        bool1 = bool2;
      }
      else if ("TransInfo.ChangeSession".equals(paramString2))
      {
        i = 5;
        bool1 = a();
        j = a();
      }
      else
      {
        j = k;
        bool1 = bool2;
        if ("TransInfo.RawData".equals(paramString2))
        {
          this.jdField_a_of_type_Int += 1;
          i = 7;
          j = k;
          bool1 = bool2;
        }
      }
    }
  }
  
  protected abstract void a(String paramString1, String paramString2, String paramString3, int paramInt);
  
  protected abstract boolean a();
  
  protected Class<? extends alpg> observerClass()
  {
    return null;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool = paramFromServiceMsg.isSuccess();
    paramToServiceMsg = paramFromServiceMsg.getServiceCmd();
    QLog.w("AudioTransClientInterfaceHandler", 1, "onReceive, getServiceCmd[" + paramToServiceMsg + "], isSuccess[" + bool + "], failMsg[" + paramFromServiceMsg.getBusinessFailMsg() + "]");
    if (bool)
    {
      paramObject = this.jdField_a_of_type_Lit;
      paramObject = lit.a(paramFromServiceMsg.getWupBuffer());
      paramFromServiceMsg = paramObject.a;
      paramObject = paramObject.b;
      AudioTransClientTransInfo.IntHead localIntHead = new AudioTransClientTransInfo.IntHead();
      int i;
      int j;
      for (;;)
      {
        long l1;
        int m;
        try
        {
          paramFromServiceMsg = (AudioTransClientTransInfo.IntHead)localIntHead.mergeFrom(paramFromServiceMsg);
          i = paramFromServiceMsg.uint32_seq.get();
          if (!paramFromServiceMsg.uint32_error_no.has()) {
            break label850;
          }
          paramObject = (AudioTransClientTransInfo.IntRspBody)new AudioTransClientTransInfo.IntRspBody().mergeFrom(paramObject);
          j = paramFromServiceMsg.uint32_error_no.get();
          if (j != 0) {
            break;
          }
          j = paramFromServiceMsg.enum_body_type.get();
          l1 = 0L;
          try
          {
            long l2 = Long.valueOf(paramFromServiceMsg.str_session_id.get()).longValue();
            l1 = l2;
          }
          catch (Exception localException)
          {
            int k;
            int n;
            QLog.w("AudioTransClientInterfaceHandler", 1, "onReceive, Exception, sessionid[" + paramFromServiceMsg.str_session_id.get() + "]");
            continue;
          }
          k = this.b;
          if (j == 2)
          {
            paramFromServiceMsg = (AudioTransClientTransInfo.IntC2SJoinSessionRsp)paramObject.msg_join_session_rsp.get();
            m = paramFromServiceMsg.uint32_combine_num.get();
            n = paramFromServiceMsg.uint32_heartbeat_duration.get();
            this.b = 0;
            QLog.d("AudioTransClientInterfaceHandler", 2, "combineNum = " + m + "\nheartBeatDuration = " + n);
            QLog.w("AudioTransClientInterfaceHandler", 1, "onReceive, cmd[" + paramToServiceMsg + "], seq[" + i + "], bodyType[" + j + "], sessionid[" + l1 + "], mReceiveRawDataCount[" + k + "->" + this.b + "]");
            return;
          }
        }
        catch (InvalidProtocolBufferMicroException paramToServiceMsg)
        {
          QLog.w("AudioTransClientInterfaceHandler", 1, "onReceive, Exception", paramToServiceMsg);
          return;
        }
        if (j == 4)
        {
          this.b = 0;
          a(i, false, null, l1);
        }
        else if (j == 8)
        {
          this.b += 1;
        }
        else if (j == 6)
        {
          paramFromServiceMsg = (AudioTransClientTransInfo.IntC2SChangeSessionRsp)paramObject.msg_change_session_rsp.get();
          this.jdField_a_of_type_Lix.jdField_a_of_type_Int = paramFromServiceMsg.enum_channel_type.get();
          if (AudioHelper.e())
          {
            m = paramFromServiceMsg.uint32_combine_num.get();
            QLog.d("AudioTransClientInterfaceHandler", 2, "enum_channel_type = " + this.jdField_a_of_type_Lix.jdField_a_of_type_Int);
            QLog.d("AudioTransClientInterfaceHandler", 2, "uint32_combine_num = " + m);
            paramFromServiceMsg = paramFromServiceMsg.rpt_msg_interface_list.get().iterator();
            while (paramFromServiceMsg.hasNext())
            {
              paramObject = (AudioTransCommon.NetAddr)paramFromServiceMsg.next();
              StringBuilder localStringBuilder = new StringBuilder().append("fixed32_IP = ");
              lit locallit = this.jdField_a_of_type_Lit;
              QLog.d("AudioTransClientInterfaceHandler", 2, lit.a(paramObject.fixed32_IP.get()));
              QLog.d("AudioTransClientInterfaceHandler", 2, "uint32_port = " + paramObject.uint32_port.get());
              QLog.d("AudioTransClientInterfaceHandler", 2, "enum_proto_type = " + paramObject.enum_proto_type.get());
              localStringBuilder = new StringBuilder().append("fixed32_inner_IP = ");
              locallit = this.jdField_a_of_type_Lit;
              QLog.d("AudioTransClientInterfaceHandler", 2, lit.a(paramObject.fixed32_inner_IP.get()));
            }
          }
        }
      }
      paramToServiceMsg = (AudioTransClientTransInfo.IntC2SFailedRsp)paramObject.msg_failed_rsp.get();
      QLog.w("AudioTransClientInterfaceHandler", 1, "onReceive, error, uint32_seq[" + i + "], uint32_error_no[" + j + "], uint32_errcode[" + paramToServiceMsg.uint32_errcode.get() + "], str_errmsg[" + paramToServiceMsg.str_errmsg.get() + "]");
      return;
      label850:
      QLog.w("AudioTransClientInterfaceHandler", 1, "onReceive, error, uint32_seq[" + i + "]");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     liy
 * JD-Core Version:    0.7.0.1
 */