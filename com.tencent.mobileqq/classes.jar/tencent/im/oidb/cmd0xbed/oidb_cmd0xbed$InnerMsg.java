package tencent.im.oidb.cmd0xbed;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0xbed$InnerMsg
  extends MessageMicro<InnerMsg>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBEnumField article_content_type = PBField.initEnum(1);
  public final PBBytesField bytes_inner_uniq_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_push_context = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_title = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBEnumField template_id = PBField.initEnum(70001);
  public final PBEnumField uint32_jump_src_type = PBField.initEnum(1);
  public final PBUInt32Field uint32_strategy_id = PBField.initUInt32(0);
  public final PBUInt64Field uint64_algorithm_id = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(1);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 40, 50, 56, 64 }, new String[] { "bytes_inner_uniq_id", "bytes_title", "uint64_algorithm_id", "uint32_strategy_id", "uint32_jump_src_type", "bytes_push_context", "template_id", "article_content_type" }, new Object[] { localByteStringMicro1, localByteStringMicro2, Long.valueOf(0L), Integer.valueOf(0), localInteger, localByteStringMicro3, Integer.valueOf(70001), localInteger }, InnerMsg.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xbed.oidb_cmd0xbed.InnerMsg
 * JD-Core Version:    0.7.0.1
 */