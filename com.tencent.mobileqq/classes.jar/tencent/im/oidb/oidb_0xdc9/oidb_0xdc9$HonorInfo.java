package tencent.im.oidb.oidb_0xdc9;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0xdc9$HonorInfo
  extends MessageMicro<HonorInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field achieve = PBField.initUInt32(0);
  public final PBUInt32Field day_count = PBField.initUInt32(0);
  public final PBUInt32Field id = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "id", "achieve", "day_count" }, new Object[] { localInteger, localInteger, localInteger }, HonorInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.oidb_0xdc9.oidb_0xdc9.HonorInfo
 * JD-Core Version:    0.7.0.1
 */