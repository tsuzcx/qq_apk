package tencent.im.s2c.msgtype0x210.submsgtype0x6f;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class SubMsgType0x6f$AddQimNotLoginFrdNotifyToQQ
  extends MessageMicro<AddQimNotLoginFrdNotifyToQQ>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_coverstory = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_nick = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_wording = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatMessageField<SubMsgType0x6f.VideoInfo> rpt_msg_video_info = PBField.initRepeatMessage(SubMsgType0x6f.VideoInfo.class);
  public final PBUInt32Field uint32_age = PBField.initUInt32(0);
  public final PBUInt32Field uint32_gender = PBField.initUInt32(0);
  public final PBUInt64Field uint64_qq_uin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_storys_total_num = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    Long localLong = Long.valueOf(0L);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 42, 48, 58, 66, 72 }, new String[] { "uint64_uin", "bytes_nick", "uint32_gender", "uint32_age", "bytes_coverstory", "uint64_storys_total_num", "rpt_msg_video_info", "bytes_wording", "uint64_qq_uin" }, new Object[] { localLong, localByteStringMicro1, localInteger, localInteger, localByteStringMicro2, localLong, null, localByteStringMicro3, localLong }, AddQimNotLoginFrdNotifyToQQ.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0x6f.SubMsgType0x6f.AddQimNotLoginFrdNotifyToQQ
 * JD-Core Version:    0.7.0.1
 */