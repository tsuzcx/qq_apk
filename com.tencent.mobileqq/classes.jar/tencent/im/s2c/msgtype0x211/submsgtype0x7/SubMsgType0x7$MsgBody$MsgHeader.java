package tencent.im.s2c.msgtype0x211.submsgtype0x7;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class SubMsgType0x7$MsgBody$MsgHeader
  extends MessageMicro<MsgHeader>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56, 64, 72, 80 }, new String[] { "uint32_src_app_id", "uint32_src_inst_id", "uint32_dst_app_id", "uint32_dst_inst_id", "uint64_dst_uin", "uint64_src_uin", "uint32_src_uin_type", "uint32_dst_uin_type", "uint32_src_ter_type", "uint32_dst_ter_type" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, MsgHeader.class);
  public final PBUInt32Field uint32_dst_app_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_dst_inst_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_dst_ter_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_dst_uin_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_src_app_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_src_inst_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_src_ter_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_src_uin_type = PBField.initUInt32(0);
  public final PBUInt64Field uint64_dst_uin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_src_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x211.submsgtype0x7.SubMsgType0x7.MsgBody.MsgHeader
 * JD-Core Version:    0.7.0.1
 */