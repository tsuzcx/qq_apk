import android.os.Bundle;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Set;
import msf.msgsvc.msg_svc.PbSendMsgReq;
import msf.msgsvc.msg_svc.RoutingHead;
import msf.msgsvc.msg_svc.Trans0x211;
import tencent.im.msg.im_msg_head.InstCtrl;
import tencent.im.msg.im_msg_head.InstInfo;
import tencent.im.s2c.msgtype0x211.submsgtype0xb.C2CType0x211_SubC2CType0xb.MsgBody;
import tencent.im.s2c.msgtype0x211.submsgtype0xb.C2CType0x211_SubC2CType0xb.MsgBody.MsgHeader;

public class mui
  extends anii
{
  static String a;
  public long a;
  public C2CType0x211_SubC2CType0xb.MsgBody.MsgHeader a;
  public String b;
  
  static
  {
    jdField_a_of_type_JavaLangString = "VideoC2CHandler";
  }
  
  public mui(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_TencentImS2cMsgtype0x211Submsgtype0xbC2CType0x211_SubC2CType0xb$MsgBody$MsgHeader = new C2CType0x211_SubC2CType0xb.MsgBody.MsgHeader();
  }
  
  private msg_svc.PbSendMsgReq a(int paramInt1, String paramString, bbzm parambbzm, long paramLong1, int paramInt2, long paramLong2)
  {
    return bbzf.a(this.app, paramInt1, paramString, parambbzm, paramLong1, paramInt2);
  }
  
  private void a(C2CType0x211_SubC2CType0xb.MsgBody.MsgHeader paramMsgHeader)
  {
    if (this.b != null)
    {
      long l = mqu.a(this.b);
      paramMsgHeader.uint64_to_uin.set(l);
    }
    if (this.jdField_a_of_type_Long != 0L) {
      paramMsgHeader.uint64_room_id.set(this.jdField_a_of_type_Long);
    }
    paramMsgHeader.setHasFlag(true);
  }
  
  public ToServiceMsg a(long paramLong1, int paramInt, C2CType0x211_SubC2CType0xb.MsgBody paramMsgBody, long paramLong2)
  {
    paramMsgBody = paramMsgBody.toByteArray();
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "send0x211C2CQavMsg QavMsgRecord:" + paramLong2);
    }
    return a(paramLong1, this.b, 529, 11, paramInt, paramMsgBody, paramLong2);
  }
  
  public ToServiceMsg a(long paramLong1, String paramString, int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte, long paramLong2)
  {
    ToServiceMsg localToServiceMsg = createToServiceMsg("MessageSvc.PbSendMsg");
    localToServiceMsg.extraData.putInt("SEND_MSG_CMD_MSG_TYPE", 1);
    localToServiceMsg.extraData.putInt("ROUNTING_TYPE", 13);
    localToServiceMsg.extraData.putBoolean("ISFROM_QAV", true);
    localToServiceMsg.addAttribute("cookie", Long.valueOf(paramLong1));
    paramLong1 = atvo.b();
    long l = atvo.a();
    Object localObject = new bbzm();
    ((bbzm)localObject).jdField_a_of_type_Int = paramInt2;
    ((bbzm)localObject).jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
    paramString = a(13, paramString, (bbzm)localObject, l, bbzj.b(paramLong1), paramLong2);
    paramArrayOfByte = new im_msg_head.InstInfo();
    paramArrayOfByte.uint32_apppid.set(AppSetting.a());
    paramArrayOfByte.uint32_instid.set(AppSetting.a());
    paramArrayOfByte.setHasFlag(true);
    paramString.routing_head.trans_0x211.inst_ctrl.rpt_msg_send_to_inst.add(paramArrayOfByte);
    localObject = new im_msg_head.InstInfo();
    paramArrayOfByte.uint32_apppid.set(AppSetting.a());
    paramArrayOfByte.uint32_instid.set(AppSetting.a());
    ((im_msg_head.InstInfo)localObject).setHasFlag(true);
    paramString.routing_head.trans_0x211.inst_ctrl.msg_from_inst = ((im_msg_head.InstInfo)localObject);
    paramString.routing_head.trans_0x211.inst_ctrl.setHasFlag(true);
    localToServiceMsg.putWupBuffer(paramString.toByteArray());
    sendPbReq(localToServiceMsg);
    return localToServiceMsg;
  }
  
  public void a()
  {
    C2CType0x211_SubC2CType0xb.MsgBody localMsgBody = new C2CType0x211_SubC2CType0xb.MsgBody();
    a(this.jdField_a_of_type_TencentImS2cMsgtype0x211Submsgtype0xbC2CType0x211_SubC2CType0xb$MsgBody$MsgHeader);
    this.jdField_a_of_type_TencentImS2cMsgtype0x211Submsgtype0xbC2CType0x211_SubC2CType0xb$MsgBody$MsgHeader.uint32_body_type.set(102);
    this.jdField_a_of_type_TencentImS2cMsgtype0x211Submsgtype0xbC2CType0x211_SubC2CType0xb$MsgBody$MsgHeader.uint32_session_type.set(0);
    localMsgBody.msg_msg_header.set(this.jdField_a_of_type_TencentImS2cMsgtype0x211Submsgtype0xbC2CType0x211_SubC2CType0xb$MsgBody$MsgHeader);
    localMsgBody.setHasFlag(true);
    a(1L, 102, localMsgBody, 1L);
  }
  
  protected boolean msgCmdFilter(String paramString)
  {
    if (this.allowCmdSet == null)
    {
      this.allowCmdSet = new HashSet();
      this.allowCmdSet.add("MessageSvc.PbSendMsg");
    }
    return !this.allowCmdSet.contains(paramString);
  }
  
  protected Class<? extends anil> observerClass()
  {
    return null;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mui
 * JD-Core Version:    0.7.0.1
 */