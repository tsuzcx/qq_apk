package tencent.im.oidb.cmd0x972;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x972$ResultItem
  extends MessageMicro<ResultItem>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField extension = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt64Field group_mask = PBField.initUInt64(0L);
  public final PBBytesField jmp_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField pic_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField result_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatMessageField<oidb_0x972.Meaning> rpt_meaning = PBField.initRepeatMessage(oidb_0x972.Meaning.class);
  public final PBBytesField word = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro6 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 58, 64 }, new String[] { "result_id", "name", "pic_url", "jmp_url", "word", "extension", "rpt_meaning", "group_mask" }, new Object[] { localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, localByteStringMicro5, localByteStringMicro6, null, Long.valueOf(0L) }, ResultItem.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0x972.oidb_0x972.ResultItem
 * JD-Core Version:    0.7.0.1
 */