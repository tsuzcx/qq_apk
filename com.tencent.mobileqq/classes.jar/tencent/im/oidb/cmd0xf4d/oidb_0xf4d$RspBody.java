package tencent.im.oidb.cmd0xf4d;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0xf4d$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBRepeatMessageField<oidb_0xf4d.DanmuDetail> danmu_detail_list = PBField.initRepeatMessage(oidb_0xf4d.DanmuDetail.class);
  public final PBStringField err_message = PBField.initString("");
  public oidb_0xf4d.ExtraInfo extra_info = new oidb_0xf4d.ExtraInfo();
  public final PBUInt32Field is_forbid = PBField.initUInt32(0);
  public final PBUInt32Field pull_interval = PBField.initUInt32(0);
  public final PBUInt32Field ret = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 42, 802 }, new String[] { "ret", "err_message", "pull_interval", "is_forbid", "extra_info", "danmu_detail_list" }, new Object[] { localInteger, "", localInteger, localInteger, null, null }, RspBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0xf4d.oidb_0xf4d.RspBody
 * JD-Core Version:    0.7.0.1
 */