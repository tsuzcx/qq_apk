package tencent.im.oidb.location;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class qq_lbs_share$C2CRelationInfo
  extends MessageMicro<C2CRelationInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt64Field id1 = PBField.initUInt64(0L);
  public final PBUInt64Field id2 = PBField.initUInt64(0L);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "id1", "id2" }, new Object[] { localLong, localLong }, C2CRelationInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.location.qq_lbs_share.C2CRelationInfo
 * JD-Core Version:    0.7.0.1
 */