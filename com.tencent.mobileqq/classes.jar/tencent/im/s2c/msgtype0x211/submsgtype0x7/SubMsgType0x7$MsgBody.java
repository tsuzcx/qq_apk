package tencent.im.s2c.msgtype0x211.submsgtype0x7;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class SubMsgType0x7$MsgBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 50, 58, 66, 74, 82, 90, 98, 106 }, new String[] { "uint32_sub_cmd", "msg_header", "rpt_msg_subcmd_0x1_ftn_notify", "rpt_msg_subcmd_0x2_nfc_notify", "rpt_msg_subcmd_0x3_filecontrol", "msg_subcmd_0x4_generic", "rpt_msg_subcmd_0x5_molo_notify", "rpt_msg_subcmd_0x8_rnfc_notify", "rpt_msg_subcmd_0x9_ftn_thumb_notify", "rpt_msg_subcmd_0xa_nfc_thumb_notify", "rpt_msg_subcmd_0xb_mpfile_notify", "msg_subcmd_0xc_progress_req", "msg_subcmd_0xd_progress_rsp" }, new Object[] { Integer.valueOf(0), null, null, null, null, null, null, null, null, null, null, null, null }, MsgBody.class);
  public SubMsgType0x7.MsgBody.MsgHeader msg_header = new SubMsgType0x7.MsgBody.MsgHeader();
  public SubMsgType0x7.MsgBody.GenericSubCmd msg_subcmd_0x4_generic = new SubMsgType0x7.MsgBody.GenericSubCmd();
  public SubMsgType0x7.MsgBody.ProgressReq msg_subcmd_0xc_progress_req = new SubMsgType0x7.MsgBody.ProgressReq();
  public SubMsgType0x7.MsgBody.ProgressRsp msg_subcmd_0xd_progress_rsp = new SubMsgType0x7.MsgBody.ProgressRsp();
  public final PBRepeatMessageField rpt_msg_subcmd_0x1_ftn_notify = PBField.initRepeatMessage(SubMsgType0x7.MsgBody.FTNNotify.class);
  public final PBRepeatMessageField rpt_msg_subcmd_0x2_nfc_notify = PBField.initRepeatMessage(SubMsgType0x7.MsgBody.NFCNotify.class);
  public final PBRepeatMessageField rpt_msg_subcmd_0x3_filecontrol = PBField.initRepeatMessage(SubMsgType0x7.MsgBody.FileControl.class);
  public final PBRepeatMessageField rpt_msg_subcmd_0x5_molo_notify = PBField.initRepeatMessage(SubMsgType0x7.MsgBody.MoloNotify.class);
  public final PBRepeatMessageField rpt_msg_subcmd_0x8_rnfc_notify = PBField.initRepeatMessage(SubMsgType0x7.MsgBody.RNFCNotify.class);
  public final PBRepeatMessageField rpt_msg_subcmd_0x9_ftn_thumb_notify = PBField.initRepeatMessage(SubMsgType0x7.MsgBody.FTNNotify.class);
  public final PBRepeatMessageField rpt_msg_subcmd_0xa_nfc_thumb_notify = PBField.initRepeatMessage(SubMsgType0x7.MsgBody.NFCNotify.class);
  public final PBRepeatMessageField rpt_msg_subcmd_0xb_mpfile_notify = PBField.initRepeatMessage(SubMsgType0x7.MsgBody.MpFileNotify.class);
  public final PBUInt32Field uint32_sub_cmd = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x211.submsgtype0x7.SubMsgType0x7.MsgBody
 * JD-Core Version:    0.7.0.1
 */