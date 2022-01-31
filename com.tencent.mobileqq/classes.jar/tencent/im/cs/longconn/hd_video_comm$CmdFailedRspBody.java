package tencent.im.cs.longconn;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class hd_video_comm$CmdFailedRspBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_error_code", "str_error_info" }, new Object[] { Integer.valueOf(0), "" }, CmdFailedRspBody.class);
  public final PBStringField str_error_info = PBField.initString("");
  public final PBUInt32Field uint32_error_code = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.cs.longconn.hd_video_comm.CmdFailedRspBody
 * JD-Core Version:    0.7.0.1
 */