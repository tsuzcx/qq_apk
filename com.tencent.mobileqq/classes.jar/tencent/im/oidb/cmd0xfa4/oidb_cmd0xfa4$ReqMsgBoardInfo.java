package tencent.im.oidb.cmd0xfa4;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0xfa4$ReqMsgBoardInfo
  extends MessageMicro<ReqMsgBoardInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "type", "id", "lst_time_stamp" }, new Object[] { Integer.valueOf(0), null, Long.valueOf(0L) }, ReqMsgBoardInfo.class);
  public oidb_cmd0xfa4.SourceInfo id = new oidb_cmd0xfa4.SourceInfo();
  public final PBUInt64Field lst_time_stamp = PBField.initUInt64(0L);
  public final PBEnumField type = PBField.initEnum(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xfa4.oidb_cmd0xfa4.ReqMsgBoardInfo
 * JD-Core Version:    0.7.0.1
 */