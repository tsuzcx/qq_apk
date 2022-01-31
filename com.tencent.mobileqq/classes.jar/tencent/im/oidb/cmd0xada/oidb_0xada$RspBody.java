package tencent.im.oidb.cmd0xada;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0xada$RspBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField busi_buf = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBStringField err_msg = PBField.initString("");
  public final PBUInt32Field proxy_code = PBField.initUInt32(0);
  public final PBUInt32Field report = PBField.initUInt32(0);
  public final PBUInt32Field stream_type = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 40 }, new String[] { "proxy_code", "err_msg", "busi_buf", "report", "stream_type" }, new Object[] { Integer.valueOf(0), "", localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0) }, RspBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0xada.oidb_0xada.RspBody
 * JD-Core Version:    0.7.0.1
 */