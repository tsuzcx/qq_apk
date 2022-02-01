package tencent.im.msg.hummer.servtype;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class hummer_commelem$MsgElemInfo_servtype21
  extends MessageMicro<MsgElemInfo_servtype21>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_confessor_nick = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_topic = PBField.initBytes(ByteStringMicro.EMPTY);
  public hummer_commelem.MsgElemInfo_servtype21.C2CConfessContext c2c_confess_ctx = new hummer_commelem.MsgElemInfo_servtype21.C2CConfessContext();
  public hummer_commelem.MsgElemInfo_servtype21.GroupConfessContext group_confess_ctx = new hummer_commelem.MsgElemInfo_servtype21.GroupConfessContext();
  public hummer_commelem.MsgElemInfo_servtype21.GroupConfessMsg group_confess_msg = new hummer_commelem.MsgElemInfo_servtype21.GroupConfessMsg();
  public final PBUInt32Field uint32_confessor_sex = PBField.initUInt32(0);
  public final PBUInt32Field uint32_sysmsg_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_topic_id = PBField.initUInt32(0);
  public final PBUInt64Field uint64_confess_time = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_confessor_uin = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    Long localLong = Long.valueOf(0L);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 40, 50, 58, 64, 74, 82 }, new String[] { "uint32_topic_id", "uint64_confessor_uin", "bytes_confessor_nick", "uint32_confessor_sex", "uint32_sysmsg_flag", "c2c_confess_ctx", "bytes_topic", "uint64_confess_time", "group_confess_msg", "group_confess_ctx" }, new Object[] { localInteger, localLong, localByteStringMicro1, localInteger, localInteger, null, localByteStringMicro2, localLong, null, null }, MsgElemInfo_servtype21.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype21
 * JD-Core Version:    0.7.0.1
 */