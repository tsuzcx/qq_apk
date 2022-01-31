package tencent.im.oidb.cmd0x68b;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0x68b$SocialLeaderInfoData
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 25 }, new String[] { "ddwLeaderUin", "dwCircleId", "dCentrality" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Double.valueOf(0.0D) }, SocialLeaderInfoData.class);
  public final PBDoubleField dCentrality = PBField.initDouble(0.0D);
  public final PBUInt64Field ddwLeaderUin = PBField.initUInt64(0L);
  public final PBUInt32Field dwCircleId = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.SocialLeaderInfoData
 * JD-Core Version:    0.7.0.1
 */