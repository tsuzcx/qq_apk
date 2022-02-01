package tencent.im;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class PasswdUrlReport$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "result", "upload_rsp_item" }, new Object[] { Integer.valueOf(0), null }, RspBody.class);
  public final PBInt32Field result = PBField.initInt32(0);
  public PasswdUrlReport.UploadRespItem upload_rsp_item = new PasswdUrlReport.UploadRespItem();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.PasswdUrlReport.RspBody
 * JD-Core Version:    0.7.0.1
 */