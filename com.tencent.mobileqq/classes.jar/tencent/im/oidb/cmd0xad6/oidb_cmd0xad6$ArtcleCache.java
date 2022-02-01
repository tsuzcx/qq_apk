package tencent.im.oidb.cmd0xad6;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0xad6$ArtcleCache
  extends MessageMicro<ArtcleCache>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_zip_html = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBFixed32Field fixed32_modify_time = PBField.initFixed32(0);
  public oidb_cmd0xad6.RspBody msg_rsp_body = new oidb_cmd0xad6.RspBody();
  public final PBUInt32Field uint32_compatible = PBField.initUInt32(0);
  public final PBUInt32Field uint32_use_webview = PBField.initUInt32(0);
  public final PBUInt64Field uint64_expired_time = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_low_version = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_under = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 13, 16, 26, 32, 40, 50, 56, 80 }, new String[] { "fixed32_modify_time", "uint32_use_webview", "msg_rsp_body", "uint64_low_version", "uint64_under", "bytes_zip_html", "uint32_compatible", "uint64_expired_time" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), null, Long.valueOf(0L), Long.valueOf(0L), localByteStringMicro, Integer.valueOf(0), Long.valueOf(0L) }, ArtcleCache.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.cmd0xad6.oidb_cmd0xad6.ArtcleCache
 * JD-Core Version:    0.7.0.1
 */