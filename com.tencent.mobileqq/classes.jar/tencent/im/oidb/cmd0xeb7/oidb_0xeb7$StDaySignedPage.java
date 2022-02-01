package tencent.im.oidb.cmd0xeb7;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class oidb_0xeb7$StDaySignedPage
  extends MessageMicro<StDaySignedPage>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "infos", "offset", "total" }, new Object[] { null, Integer.valueOf(0), Integer.valueOf(0) }, StDaySignedPage.class);
  public final PBRepeatMessageField<oidb_0xeb7.StDaySignedInfo> infos = PBField.initRepeatMessage(oidb_0xeb7.StDaySignedInfo.class);
  public final PBInt32Field offset = PBField.initInt32(0);
  public final PBInt32Field total = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.cmd0xeb7.oidb_0xeb7.StDaySignedPage
 * JD-Core Version:    0.7.0.1
 */