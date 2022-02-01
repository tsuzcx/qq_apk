package tencent.im.oidb.cmd0xebd;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0xebd$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uint32_set_is_searched_by_mobile" }, new Object[] { Integer.valueOf(0) }, ReqBody.class);
  public final PBUInt32Field uint32_set_is_searched_by_mobile = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.cmd0xebd.oidb_0xebd.ReqBody
 * JD-Core Version:    0.7.0.1
 */