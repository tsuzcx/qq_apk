package tencent.im.oidb.cmd0xeb7;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class oidb_0xeb7$StSignInRecordKing
  extends MessageMicro<StSignInRecordKing>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "yesterdayFirst", "topSignedTotal", "topSignedContinue", "kingUrl" }, new Object[] { null, null, null, "" }, StSignInRecordKing.class);
  public final PBStringField kingUrl = PBField.initString("");
  public oidb_0xeb7.StKingSignedInfo topSignedContinue = new oidb_0xeb7.StKingSignedInfo();
  public oidb_0xeb7.StKingSignedInfo topSignedTotal = new oidb_0xeb7.StKingSignedInfo();
  public oidb_0xeb7.StKingSignedInfo yesterdayFirst = new oidb_0xeb7.StKingSignedInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.cmd0xeb7.oidb_0xeb7.StSignInRecordKing
 * JD-Core Version:    0.7.0.1
 */