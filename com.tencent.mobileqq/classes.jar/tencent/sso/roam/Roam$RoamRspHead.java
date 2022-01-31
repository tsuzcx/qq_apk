package tencent.sso.roam;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class Roam$RoamRspHead
  extends MessageMicro<RoamRspHead>
{
  public static final int MSG_FIELD_NUMBER = 2;
  public static final int RESULT_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "result", "msg" }, new Object[] { Integer.valueOf(0), "" }, RoamRspHead.class);
  public final PBStringField msg = PBField.initString("");
  public final PBInt32Field result = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     tencent.sso.roam.Roam.RoamRspHead
 * JD-Core Version:    0.7.0.1
 */