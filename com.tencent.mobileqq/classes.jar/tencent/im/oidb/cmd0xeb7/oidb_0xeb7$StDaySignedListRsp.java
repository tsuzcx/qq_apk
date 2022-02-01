package tencent.im.oidb.cmd0xeb7;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class oidb_0xeb7$StDaySignedListRsp
  extends MessageMicro<StDaySignedListRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "ret", "page" }, new Object[] { null, null }, StDaySignedListRsp.class);
  public final PBRepeatMessageField<oidb_0xeb7.StDaySignedPage> page = PBField.initRepeatMessage(oidb_0xeb7.StDaySignedPage.class);
  public oidb_0xeb7.Ret ret = new oidb_0xeb7.Ret();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.cmd0xeb7.oidb_0xeb7.StDaySignedListRsp
 * JD-Core Version:    0.7.0.1
 */