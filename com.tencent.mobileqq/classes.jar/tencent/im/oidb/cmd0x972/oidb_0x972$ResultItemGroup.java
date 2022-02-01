package tencent.im.oidb.cmd0x972;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x972$ResultItemGroup
  extends MessageMicro<ResultItemGroup>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt64Field group_mask = PBField.initUInt64(0L);
  public final PBBytesField group_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField more_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField more_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatMessageField<oidb_0x972.ResultItem> result_items = PBField.initRepeatMessage(oidb_0x972.ResultItem.class);
  public final PBRepeatField<ByteStringMicro> rpt_highlight_words = PBField.initRepeat(PBBytesField.__repeatHelper__);
  public final PBUInt64Field total_result_count = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 42, 50, 8002 }, new String[] { "group_mask", "group_name", "result_items", "total_result_count", "more_url", "more_name", "rpt_highlight_words" }, new Object[] { Long.valueOf(0L), localByteStringMicro1, null, Long.valueOf(0L), localByteStringMicro2, localByteStringMicro3, localByteStringMicro4 }, ResultItemGroup.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0x972.oidb_0x972.ResultItemGroup
 * JD-Core Version:    0.7.0.1
 */