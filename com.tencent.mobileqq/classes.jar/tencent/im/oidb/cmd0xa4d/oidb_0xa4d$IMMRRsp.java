package tencent.im.oidb.cmd0xa4d;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;

public final class oidb_0xa4d$IMMRRsp
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_rsp_data = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBInt32Field int32_ret = PBField.initInt32(0);
  public final PBInt64Field int64_last_modified = PBField.initInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 810 }, new String[] { "int32_ret", "int64_last_modified", "bytes_rsp_data" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), localByteStringMicro }, IMMRRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0xa4d.oidb_0xa4d.IMMRRsp
 * JD-Core Version:    0.7.0.1
 */