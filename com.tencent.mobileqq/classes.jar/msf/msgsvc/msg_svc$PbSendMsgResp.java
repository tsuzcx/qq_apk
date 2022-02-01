package msf.msgsvc;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import tencent.im.msg.im_receipt.ReceiptResp;

public final class msg_svc$PbSendMsgResp
  extends MessageMicro<PbSendMsgResp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField errmsg = PBField.initString("");
  public final PBUInt32Field errtype = PBField.initUInt32(0);
  public msg_svc.MsgSendInfo msg_send_info = new msg_svc.MsgSendInfo();
  public final PBBytesField msgeleminfo_servtype37 = PBField.initBytes(ByteStringMicro.EMPTY);
  public im_receipt.ReceiptResp receipt_resp = new im_receipt.ReceiptResp();
  public final PBUInt32Field result = PBField.initUInt32(0);
  public final PBUInt32Field send_time = PBField.initUInt32(0);
  public final PBUInt32Field text_analysis_result = PBField.initUInt32(0);
  public msg_svc.TransSvrInfo trans_svr_info = new msg_svc.TransSvrInfo();
  public final PBUInt32Field uint32_msg_info_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_svrbusy_wait_time = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 42, 48, 58, 66, 72, 80, 106 }, new String[] { "result", "errmsg", "send_time", "uint32_svrbusy_wait_time", "msg_send_info", "errtype", "trans_svr_info", "receipt_resp", "text_analysis_result", "uint32_msg_info_flag", "msgeleminfo_servtype37" }, new Object[] { localInteger, "", localInteger, localInteger, null, localInteger, null, null, localInteger, localInteger, localByteStringMicro }, PbSendMsgResp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     msf.msgsvc.msg_svc.PbSendMsgResp
 * JD-Core Version:    0.7.0.1
 */