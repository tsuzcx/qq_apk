package tencent.im.oidb.cmd0xf35;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_cmd0xf35$BlockUserRsp
  extends MessageMicro<BlockUserRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "ret", "err_message", "over_times" }, new Object[] { Integer.valueOf(0), "", Integer.valueOf(0) }, BlockUserRsp.class);
  public final PBStringField err_message = PBField.initString("");
  public final PBUInt32Field over_times = PBField.initUInt32(0);
  public final PBUInt32Field ret = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0xf35.oidb_cmd0xf35.BlockUserRsp
 * JD-Core Version:    0.7.0.1
 */