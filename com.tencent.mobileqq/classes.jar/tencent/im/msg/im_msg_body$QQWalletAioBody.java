package tencent.im.msg;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBSInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class im_msg_body$QQWalletAioBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_authkey = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_billno = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_pb_reserve = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_pc_body = PBField.initBytes(ByteStringMicro.EMPTY);
  public im_msg_body.QQWalletAioElem receiver = new im_msg_body.QQWalletAioElem();
  public im_msg_body.QQWalletAioElem sender = new im_msg_body.QQWalletAioElem();
  public final PBSInt32Field sint32_channelid = PBField.initSInt32(0);
  public final PBSInt32Field sint32_conftype = PBField.initSInt32(0);
  public final PBSInt32Field sint32_envelopeid = PBField.initSInt32(0);
  public final PBSInt32Field sint32_msg_from = PBField.initSInt32(0);
  public final PBSInt32Field sint32_msgtype = PBField.initSInt32(0);
  public final PBSInt32Field sint32_redtype = PBField.initSInt32(0);
  public final PBSInt32Field sint32_sessiontype = PBField.initSInt32(0);
  public final PBSInt32Field sint32_templateid = PBField.initSInt32(0);
  public final PBBytesField string_index = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_msg_priority = PBField.initUInt32(0);
  public final PBUInt32Field uint32_redchannel = PBField.initUInt32(0);
  public final PBUInt32Field uint32_resend = PBField.initUInt32(0);
  public final PBRepeatField uint64_grap_uin = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  public final PBUInt64Field uint64_senduin = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro6 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 40, 48, 56, 64, 74, 82, 88, 96, 104, 114, 120, 128, 138, 146, 152, 160, 170 }, new String[] { "uint64_senduin", "sender", "receiver", "sint32_channelid", "sint32_templateid", "uint32_resend", "uint32_msg_priority", "sint32_redtype", "bytes_billno", "bytes_authkey", "sint32_sessiontype", "sint32_msgtype", "sint32_envelopeid", "bytes_name", "sint32_conftype", "sint32_msg_from", "bytes_pc_body", "string_index", "uint32_redchannel", "uint64_grap_uin", "bytes_pb_reserve" }, new Object[] { Long.valueOf(0L), null, null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro3, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro4, localByteStringMicro5, Integer.valueOf(0), Long.valueOf(0L), localByteStringMicro6 }, QQWalletAioBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.msg.im_msg_body.QQWalletAioBody
 * JD-Core Version:    0.7.0.1
 */