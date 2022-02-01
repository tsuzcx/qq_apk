package tencent.im.qim.trans.QIMVideoUpload;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class QIMVideoUpload$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 80, 88, 98 }, new String[] { "msg_err", "uint64_uin", "uint64_service_type", "str_uuid" }, new Object[] { null, Long.valueOf(0L), Long.valueOf(0L), "" }, RspBody.class);
  public QIMVideoUpload.ErrorInfo msg_err = new QIMVideoUpload.ErrorInfo();
  public final PBStringField str_uuid = PBField.initString("");
  public final PBUInt64Field uint64_service_type = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.qim.trans.QIMVideoUpload.QIMVideoUpload.RspBody
 * JD-Core Version:    0.7.0.1
 */