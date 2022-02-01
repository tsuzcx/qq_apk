package tencent.im.oidb.cmd0x43c;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;

public final class Oidb_0x43c$RequestAdd
  extends MessageMicro<RequestAdd>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "card_info", "isMine" }, new Object[] { null, Boolean.valueOf(false) }, RequestAdd.class);
  public Oidb_0x43c.CardInfo card_info = new Oidb_0x43c.CardInfo();
  public final PBBoolField isMine = PBField.initBool(false);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0x43c.Oidb_0x43c.RequestAdd
 * JD-Core Version:    0.7.0.1
 */