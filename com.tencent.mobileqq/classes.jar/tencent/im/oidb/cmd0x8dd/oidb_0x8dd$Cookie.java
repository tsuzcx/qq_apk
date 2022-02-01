package tencent.im.oidb.cmd0x8dd;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0x8dd$Cookie
  extends MessageMicro<Cookie>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_dcache_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
  public oidb_0x8dd.AnchorCookie msg_anchor_cookie = new oidb_0x8dd.AnchorCookie();
  public oidb_0x8dd.CkvCookie msg_ckv_cookie = new oidb_0x8dd.CkvCookie();
  public final PBUInt32Field page_cnt = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32 }, new String[] { "msg_ckv_cookie", "bytes_dcache_cookie", "msg_anchor_cookie", "page_cnt" }, new Object[] { null, localByteStringMicro, null, Integer.valueOf(0) }, Cookie.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.cmd0x8dd.oidb_0x8dd.Cookie
 * JD-Core Version:    0.7.0.1
 */