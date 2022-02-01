package tencent.im.oidb.cmd0xe89;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_cmd0xe89$ReqGetDocContent
  extends MessageMicro<ReqGetDocContent>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_global_padid = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_get_rev = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "bytes_global_padid", "uint32_get_rev" }, new Object[] { localByteStringMicro, Integer.valueOf(0) }, ReqGetDocContent.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.cmd0xe89.oidb_cmd0xe89.ReqGetDocContent
 * JD-Core Version:    0.7.0.1
 */