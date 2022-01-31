package tencent.im.oidb.cmd0xbd3;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

public final class oidb_cmd0xbd3$ShareInfo
  extends MessageMicro<ShareInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_share_json = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "bytes_share_json" }, new Object[] { localByteStringMicro }, ShareInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.cmd0xbd3.oidb_cmd0xbd3.ShareInfo
 * JD-Core Version:    0.7.0.1
 */