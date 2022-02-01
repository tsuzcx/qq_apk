package tencent.im.oidb.cmd0xdcc;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_cmd0xdcc$RecommendCard
  extends MessageMicro<RecommendCard>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_main_title = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_sub_title = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBEnumField enum_card_id = PBField.initEnum(101);
  public final PBRepeatMessageField<oidb_cmd0xdcc.RecommendPerson> rpt_msg_person = PBField.initRepeatMessage(oidb_cmd0xdcc.RecommendPerson.class);
  public final PBUInt32Field uint32_show_max = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 42 }, new String[] { "enum_card_id", "bytes_main_title", "bytes_sub_title", "uint32_show_max", "rpt_msg_person" }, new Object[] { Integer.valueOf(101), localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), null }, RecommendCard.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xdcc.oidb_cmd0xdcc.RecommendCard
 * JD-Core Version:    0.7.0.1
 */