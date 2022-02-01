package tencent.im.oidb.oidb_0x783;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x783$DiscussGroup
  extends MessageMicro<DiscussGroup>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field uint32_confseq = PBField.initUInt32(0);
  public final PBFixed32Field uint32_time = PBField.initFixed32(0);
  public final PBUInt64Field uint64_confid = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 29 }, new String[] { "uint64_confid", "uint32_confseq", "uint32_time" }, new Object[] { Long.valueOf(0L), localInteger, localInteger }, DiscussGroup.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.oidb_0x783.oidb_0x783.DiscussGroup
 * JD-Core Version:    0.7.0.1
 */