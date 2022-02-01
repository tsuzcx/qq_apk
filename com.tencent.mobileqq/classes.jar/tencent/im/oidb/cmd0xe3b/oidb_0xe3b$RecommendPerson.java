package tencent.im.oidb.cmd0xe3b;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0xe3b$RecommendPerson
  extends MessageMicro<RecommendPerson>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_reason = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_title = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatMessageField<oidb_0xe3b.Label> rpt_msg_label = PBField.initRepeatMessage(oidb_0xe3b.Label.class);
  public final PBUInt32Field uint32_age = PBField.initUInt32(0);
  public final PBUInt32Field uint32_gender = PBField.initUInt32(0);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 40, 48 }, new String[] { "uint64_uin", "bytes_reason", "rpt_msg_label", "bytes_title", "uint32_age", "uint32_gender" }, new Object[] { Long.valueOf(0L), localByteStringMicro1, null, localByteStringMicro2, Integer.valueOf(0), Integer.valueOf(0) }, RecommendPerson.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0xe3b.oidb_0xe3b.RecommendPerson
 * JD-Core Version:    0.7.0.1
 */