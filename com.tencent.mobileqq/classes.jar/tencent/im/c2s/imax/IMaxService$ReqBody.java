package tencent.im.c2s.imax;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class IMaxService$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "int32_type", "msg_exposure", "msg_ignoreAD" }, new Object[] { Integer.valueOf(0), null, null }, ReqBody.class);
  public final PBInt32Field int32_type = PBField.initInt32(0);
  public IMaxService.ExposureMsg msg_exposure = new IMaxService.ExposureMsg();
  public IMaxService.IgnoreADMsg msg_ignoreAD = new IMaxService.IgnoreADMsg();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     tencent.im.c2s.imax.IMaxService.ReqBody
 * JD-Core Version:    0.7.0.1
 */