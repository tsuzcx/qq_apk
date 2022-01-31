package tencent.im.oidb.cmd0x43c;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class Oidb_0x43c$ResponseCardList
  extends MessageMicro<ResponseCardList>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34 }, new String[] { "seq", "next_flag", "others", "mine" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), null, null }, ResponseCardList.class);
  public Oidb_0x43c.CardInfo mine = new Oidb_0x43c.CardInfo();
  public final PBUInt32Field next_flag = PBField.initUInt32(0);
  public final PBRepeatMessageField<Oidb_0x43c.CardInfo> others = PBField.initRepeatMessage(Oidb_0x43c.CardInfo.class);
  public final PBUInt32Field seq = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.cmd0x43c.Oidb_0x43c.ResponseCardList
 * JD-Core Version:    0.7.0.1
 */