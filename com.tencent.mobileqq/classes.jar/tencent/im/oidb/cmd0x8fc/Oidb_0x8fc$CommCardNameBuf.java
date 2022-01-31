package tencent.im.oidb.cmd0x8fc;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class Oidb_0x8fc$CommCardNameBuf
  extends MessageMicro<CommCardNameBuf>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_rich_card_name" }, new Object[] { null }, CommCardNameBuf.class);
  public final PBRepeatMessageField<Oidb_0x8fc.RichCardNameElem> rpt_rich_card_name = PBField.initRepeatMessage(Oidb_0x8fc.RichCardNameElem.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0x8fc.Oidb_0x8fc.CommCardNameBuf
 * JD-Core Version:    0.7.0.1
 */