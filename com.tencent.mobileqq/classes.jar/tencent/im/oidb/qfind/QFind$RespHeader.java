package tencent.im.oidb.qfind;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class QFind$RespHeader
  extends MessageMicro<RespHeader>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "result", "desc" }, new Object[] { Integer.valueOf(0), "" }, RespHeader.class);
  public final PBStringField desc = PBField.initString("");
  public final PBInt32Field result = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.qfind.QFind.RespHeader
 * JD-Core Version:    0.7.0.1
 */