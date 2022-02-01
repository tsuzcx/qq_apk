package tencent.im.oidb.cmd0xe34;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class cmd0xe34$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "rpt_unread_info", "ReqInterval" }, new Object[] { null, Integer.valueOf(0) }, RspBody.class);
  public final PBUInt32Field ReqInterval = PBField.initUInt32(0);
  public final PBRepeatMessageField<cmd0xe34.UnReadInfo> rpt_unread_info = PBField.initRepeatMessage(cmd0xe34.UnReadInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xe34.cmd0xe34.RspBody
 * JD-Core Version:    0.7.0.1
 */