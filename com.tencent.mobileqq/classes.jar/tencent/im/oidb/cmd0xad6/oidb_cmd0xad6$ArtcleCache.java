package tencent.im.oidb.cmd0xad6;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0xad6$ArtcleCache
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 13, 16, 26, 32 }, new String[] { "fixed32_modify_time", "uint32_use_webview", "msg_rsp_body", "uint64_low_version" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), null, Long.valueOf(0L) }, ArtcleCache.class);
  public final PBFixed32Field fixed32_modify_time = PBField.initFixed32(0);
  public oidb_cmd0xad6.RspBody msg_rsp_body = new oidb_cmd0xad6.RspBody();
  public final PBUInt32Field uint32_use_webview = PBField.initUInt32(0);
  public final PBUInt64Field uint64_low_version = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0xad6.oidb_cmd0xad6.ArtcleCache
 * JD-Core Version:    0.7.0.1
 */