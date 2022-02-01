package tencent.im;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class PasswdUrlReport$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "upload_type", "upload_req_item" }, new Object[] { Integer.valueOf(0), null }, ReqBody.class);
  public PasswdUrlReport.UploadReqItem upload_req_item = new PasswdUrlReport.UploadReqItem();
  public final PBInt32Field upload_type = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.PasswdUrlReport.ReqBody
 * JD-Core Version:    0.7.0.1
 */