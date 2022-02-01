import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.now_proxy.pb_now_proxy.ForwardReq;
import com.tencent.now_proxy.pb_now_proxy.ForwardRsp;
import com.tencent.pb.now.ilive_get_record_info_svr.GetRoomStateReq;
import com.tencent.pb.now.ilive_get_record_info_svr.GetRoomStateRsp;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;

public class nrx
  extends BusinessHandler
{
  public static String a;
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long = 0L;
  nry jdField_a_of_type_Nry;
  boolean jdField_a_of_type_Boolean = false;
  String b;
  
  static
  {
    jdField_a_of_type_JavaLangString = "NowRecordInfo";
  }
  
  public nrx(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int j = 0;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Long = 0L;
    int i = j;
    if (paramFromServiceMsg.isSuccess())
    {
      i = j;
      if (paramObject != null) {
        i = 1;
      }
    }
    if (i == 0)
    {
      this.jdField_a_of_type_Int = paramFromServiceMsg.getBusinessFailCode();
      this.b = paramFromServiceMsg.getBusinessFailMsg();
      a(true, "", "", System.currentTimeMillis() - this.jdField_a_of_type_Long, "");
      return;
    }
    paramToServiceMsg = new pb_now_proxy.ForwardRsp();
    try
    {
      paramToServiceMsg.mergeFrom((byte[])paramObject);
      if ((paramToServiceMsg.busi_error_code.get() != 0) || (paramToServiceMsg.busi_buf.get() == null))
      {
        this.jdField_a_of_type_Int = paramToServiceMsg.busi_error_code.get();
        a(true, "", "", System.currentTimeMillis() - this.jdField_a_of_type_Long, "");
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramToServiceMsg)
    {
      a(true, "", "", System.currentTimeMillis() - this.jdField_a_of_type_Long, "");
      return;
    }
    a(paramToServiceMsg.busi_error_code.get(), paramToServiceMsg.busi_buf.get().toByteArray());
  }
  
  private void a(byte[] paramArrayOfByte, String paramString)
  {
    if (this.app == null) {
      return;
    }
    paramString = new ToServiceMsg("mobileqq.service", paramString, "NowGetRecordInfoSvr.get_record_info");
    paramString.putWupBuffer(paramArrayOfByte);
    sendPbReq(paramString);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public String a()
  {
    return this.b;
  }
  
  public void a(int paramInt, byte[] paramArrayOfByte)
  {
    boolean bool = false;
    QLog.i(jdField_a_of_type_JavaLangString, 0, "拉取录播信息成功");
    this.jdField_a_of_type_Int = 0;
    this.b = "";
    try
    {
      Object localObject = new ilive_get_record_info_svr.GetRoomStateRsp();
      ((ilive_get_record_info_svr.GetRoomStateRsp)localObject).mergeFrom(paramArrayOfByte);
      paramInt = ((ilive_get_record_info_svr.GetRoomStateRsp)localObject).is_on_live.get();
      paramArrayOfByte = ((ilive_get_record_info_svr.GetRoomStateRsp)localObject).vid.get();
      String str = ((ilive_get_record_info_svr.GetRoomStateRsp)localObject).recorded_share_url.get();
      localObject = ((ilive_get_record_info_svr.GetRoomStateRsp)localObject).another_live_mqq.get();
      if (paramInt != 0) {
        bool = true;
      }
      a(bool, paramArrayOfByte, str, System.currentTimeMillis() - this.jdField_a_of_type_Long, (String)localObject);
      return;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "NowRecordObserver InvalidProtocolBufferMicroException! ");
    }
  }
  
  public void a(String paramString1, long paramLong, String paramString2, nry paramnry)
  {
    this.jdField_a_of_type_Nry = null;
    this.jdField_a_of_type_Nry = paramnry;
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    if (this.app == null)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "getRecordInfo fail,app is null ");
      a(true, "", "", 0L, "");
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    paramnry = new ilive_get_record_info_svr.GetRoomStateReq();
    paramnry.source.set(paramString1);
    paramnry.roomid.set((int)paramLong);
    paramString1 = new pb_now_proxy.ForwardReq();
    paramString1.cmd.set(26182);
    paramString1.subcmd.set(2);
    paramString1.uid.set(Long.valueOf(paramString2).longValue());
    paramString1.platform.set(1);
    paramString1.codec.set(0);
    paramString1.busi_buf.set(ByteStringMicro.copyFrom(((ilive_get_record_info_svr.GetRoomStateReq)paramnry.get()).toByteArray()));
    paramString1.original_id_type.set(1);
    paramString1.original_id.set(paramString2);
    a(paramString1.toByteArray(), paramString2);
  }
  
  protected void a(boolean paramBoolean, String paramString1, String paramString2, long paramLong, String paramString3)
  {
    if (this.jdField_a_of_type_Nry != null) {
      this.jdField_a_of_type_Nry.a(paramBoolean, paramString2, paramString1, paramLong, paramString3);
    }
  }
  
  public Class<? extends BusinessObserver> observerClass()
  {
    return null;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ("NowGetRecordInfoSvr.get_record_info".equals(paramFromServiceMsg.getServiceCmd()))
    {
      QLog.i(jdField_a_of_type_JavaLangString, 1, "onReceive called.");
      a(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nrx
 * JD-Core Version:    0.7.0.1
 */