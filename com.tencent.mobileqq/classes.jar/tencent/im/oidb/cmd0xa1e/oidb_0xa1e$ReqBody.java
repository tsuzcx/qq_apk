package tencent.im.oidb.cmd0xa1e;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0xa1e$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field platform = PBField.initUInt32(0);
  public final PBUInt32Field position = PBField.initUInt32(0);
  public final PBRepeatMessageField<oidb_0xa1e.AppClick> rpt_app_click = PBField.initRepeatMessage(oidb_0xa1e.AppClick.class);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "rpt_app_click", "platform", "position" }, new Object[] { null, localInteger, localInteger }, ReqBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xa1e.oidb_0xa1e.ReqBody
 * JD-Core Version:    0.7.0.1
 */