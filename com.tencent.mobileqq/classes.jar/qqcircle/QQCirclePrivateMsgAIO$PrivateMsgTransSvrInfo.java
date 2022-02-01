package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class QQCirclePrivateMsgAIO$PrivateMsgTransSvrInfo
  extends MessageMicro<PrivateMsgTransSvrInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "int32_ret_code", "str_err_msg" }, new Object[] { Integer.valueOf(0), "" }, PrivateMsgTransSvrInfo.class);
  public final PBInt32Field int32_ret_code = PBField.initInt32(0);
  public final PBStringField str_err_msg = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     qqcircle.QQCirclePrivateMsgAIO.PrivateMsgTransSvrInfo
 * JD-Core Version:    0.7.0.1
 */