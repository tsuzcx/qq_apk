package tencent.im.oidb.cmd0xeb7;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class oidb_0xeb7$StKingSignedInfo
  extends MessageMicro<StKingSignedInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32 }, new String[] { "uid", "groupNick", "signedTimeStamp", "signedCount" }, new Object[] { "", "", Long.valueOf(0L), Integer.valueOf(0) }, StKingSignedInfo.class);
  public final PBStringField groupNick = PBField.initString("");
  public final PBInt32Field signedCount = PBField.initInt32(0);
  public final PBInt64Field signedTimeStamp = PBField.initInt64(0L);
  public final PBStringField uid = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.cmd0xeb7.oidb_0xeb7.StKingSignedInfo
 * JD-Core Version:    0.7.0.1
 */