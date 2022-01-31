package tencent.im.oidb.cmd0x69f;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_cmd0x69f$RichTips
  extends MessageMicro<RichTips>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_tips_text = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_latest_sticky_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_tips_type = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "uint32_tips_type", "bytes_tips_text", "uint32_latest_sticky_time" }, new Object[] { Integer.valueOf(0), localByteStringMicro, Integer.valueOf(0) }, RichTips.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0x69f.oidb_cmd0x69f.RichTips
 * JD-Core Version:    0.7.0.1
 */