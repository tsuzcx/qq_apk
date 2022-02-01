package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class oidb_0xebe$CleanSessionRsp
  extends MessageMicro<CleanSessionRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "int32_ret_code" }, new Object[] { Integer.valueOf(0) }, CleanSessionRsp.class);
  public final PBInt32Field int32_ret_code = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.oidb_0xebe.CleanSessionRsp
 * JD-Core Version:    0.7.0.1
 */