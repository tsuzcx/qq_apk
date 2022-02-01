package tencent.im.oidb.cmd0xeb7;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class oidb_0xeb7$StSignInRecordDaySigned
  extends MessageMicro<StSignInRecordDaySigned>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 13, 16, 26, 34 }, new String[] { "daySignedRatio", "dayTotalSignedUid", "daySignedPage", "daySignedUrl" }, new Object[] { Float.valueOf(0.0F), Integer.valueOf(0), null, "" }, StSignInRecordDaySigned.class);
  public oidb_0xeb7.StDaySignedPage daySignedPage = new oidb_0xeb7.StDaySignedPage();
  public final PBFloatField daySignedRatio = PBField.initFloat(0.0F);
  public final PBStringField daySignedUrl = PBField.initString("");
  public final PBInt32Field dayTotalSignedUid = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.cmd0xeb7.oidb_0xeb7.StSignInRecordDaySigned
 * JD-Core Version:    0.7.0.1
 */