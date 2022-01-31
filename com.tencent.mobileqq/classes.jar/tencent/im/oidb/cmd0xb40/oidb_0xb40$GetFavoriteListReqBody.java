package tencent.im.oidb.cmd0xb40;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0xb40$GetFavoriteListReqBody
  extends MessageMicro<GetFavoriteListReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_sync_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_page_size = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "bytes_sync_cookie", "uint32_page_size" }, new Object[] { localByteStringMicro, Integer.valueOf(0) }, GetFavoriteListReqBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.cmd0xb40.oidb_0xb40.GetFavoriteListReqBody
 * JD-Core Version:    0.7.0.1
 */