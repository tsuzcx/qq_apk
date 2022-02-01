package msf.msgsvc;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import msf.msgcomm.msg_comm.AppShareInfo;
import msf.msgcomm.msg_comm.ContentHead;
import tencent.im.msg.im_msg_body.MsgBody;
import tencent.im.msg.im_receipt.ReceiptReq;

public final class msg_svc$PbSendMsgReq
  extends MessageMicro<PbSendMsgReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public msg_comm.AppShareInfo app_share = new msg_comm.AppShareInfo();
  public msg_comm.ContentHead content_head = new msg_comm.ContentHead();
  public final PBUInt32Field data_statist = PBField.initUInt32(0);
  public msg_svc.PbInputNotifyInfo input_notify_info = new msg_svc.PbInputNotifyInfo();
  public im_msg_body.MsgBody msg_body = new im_msg_body.MsgBody();
  public msg_ctrl.MsgCtrl msg_ctrl = new msg_ctrl.MsgCtrl();
  public final PBUInt32Field msg_rand = PBField.initUInt32(0);
  public final PBUInt32Field msg_seq = PBField.initUInt32(0);
  public final PBUInt32Field msg_via = PBField.initUInt32(0);
  public msg_svc.MultiMsgAssist multi_msg_assist = new msg_svc.MultiMsgAssist();
  public final PBUInt32Field multi_send_seq = PBField.initUInt32(0);
  public im_receipt.ReceiptReq receipt_req = new im_receipt.ReceiptReq();
  public msg_svc.RoutingHead routing_head = new msg_svc.RoutingHead();
  public final PBBytesField sync_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 40, 50, 58, 64, 72, 82, 90, 98, 106, 112 }, new String[] { "routing_head", "content_head", "msg_body", "msg_seq", "msg_rand", "sync_cookie", "app_share", "msg_via", "data_statist", "multi_msg_assist", "input_notify_info", "msg_ctrl", "receipt_req", "multi_send_seq" }, new Object[] { null, null, null, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro, null, Integer.valueOf(0), Integer.valueOf(0), null, null, null, null, Integer.valueOf(0) }, PbSendMsgReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     msf.msgsvc.msg_svc.PbSendMsgReq
 * JD-Core Version:    0.7.0.1
 */