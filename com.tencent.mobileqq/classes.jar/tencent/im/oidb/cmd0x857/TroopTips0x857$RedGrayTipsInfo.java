package tencent.im.oidb.cmd0x857;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBSInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class TroopTips0x857$RedGrayTipsInfo
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_authkey = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_pc_body = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_receiver_rich_content = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_sender_rich_content = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field opt_uint32_show_lastest = PBField.initUInt32(0);
  public final PBSInt32Field sint32_msgtype = PBField.initSInt32(0);
  public final PBUInt32Field uint32_hide_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_icon = PBField.initUInt32(0);
  public final PBUInt32Field uint32_lucky_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_random = PBField.initUInt32(0);
  public final PBUInt32Field uint32_time = PBField.initUInt32(0);
  public final PBUInt64Field uint64_lucky_uin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_receiver_uin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_sender_uin = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42, 50, 56, 64, 72, 82, 88, 96, 104, 112 }, new String[] { "opt_uint32_show_lastest", "uint64_sender_uin", "uint64_receiver_uin", "bytes_sender_rich_content", "bytes_receiver_rich_content", "bytes_authkey", "sint32_msgtype", "uint32_lucky_flag", "uint32_hide_flag", "bytes_pc_body", "uint32_icon", "uint64_lucky_uin", "uint32_time", "uint32_random" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro4, Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0) }, RedGrayTipsInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x857.TroopTips0x857.RedGrayTipsInfo
 * JD-Core Version:    0.7.0.1
 */