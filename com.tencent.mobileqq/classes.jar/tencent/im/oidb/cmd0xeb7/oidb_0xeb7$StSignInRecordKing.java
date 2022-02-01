package tencent.im.oidb.cmd0xeb7;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class oidb_0xeb7$StSignInRecordKing
  extends MessageMicro<StSignInRecordKing>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "yesterdayFirst", "topSignedTotal", "topSignedContinue", "kingUrl" }, new Object[] { null, null, null, "" }, StSignInRecordKing.class);
  public final PBStringField kingUrl = PBField.initString("");
  public final PBRepeatMessageField<oidb_0xeb7.StKingSignedInfo> topSignedContinue = PBField.initRepeatMessage(oidb_0xeb7.StKingSignedInfo.class);
  public final PBRepeatMessageField<oidb_0xeb7.StKingSignedInfo> topSignedTotal = PBField.initRepeatMessage(oidb_0xeb7.StKingSignedInfo.class);
  public oidb_0xeb7.StKingSignedInfo yesterdayFirst = new oidb_0xeb7.StKingSignedInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0xeb7.oidb_0xeb7.StSignInRecordKing
 * JD-Core Version:    0.7.0.1
 */