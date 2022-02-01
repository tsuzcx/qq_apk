package tencent.im.msgsync.cmd0x100;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class Submsgtype0x8a$MsgInfo
  extends MessageMicro<MsgInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56, 64, 72, 96, 106 }, new String[] { "uint64_from_uin", "uint64_to_uin", "uint32_msg_seq", "uint64_msg_uid", "uint64_msg_time", "uint32_msg_random", "uint32_pkg_num", "uint32_pkg_index", "uint32_div_seq", "uint32_flag", "msg_wording_info" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null }, MsgInfo.class);
  public Submsgtype0x8a.WithDrawWordingInfo msg_wording_info = new Submsgtype0x8a.WithDrawWordingInfo();
  public final PBUInt32Field uint32_div_seq = PBField.initUInt32(0);
  public final PBUInt32Field uint32_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_msg_random = PBField.initUInt32(0);
  public final PBUInt32Field uint32_msg_seq = PBField.initUInt32(0);
  public final PBUInt32Field uint32_pkg_index = PBField.initUInt32(0);
  public final PBUInt32Field uint32_pkg_num = PBField.initUInt32(0);
  public final PBUInt64Field uint64_from_uin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_msg_time = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_msg_uid = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_to_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.msgsync.cmd0x100.Submsgtype0x8a.MsgInfo
 * JD-Core Version:    0.7.0.1
 */