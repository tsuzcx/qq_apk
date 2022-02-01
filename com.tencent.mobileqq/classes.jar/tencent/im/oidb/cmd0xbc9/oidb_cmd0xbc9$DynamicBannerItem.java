package tencent.im.oidb.cmd0xbc9;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

public final class oidb_cmd0xbc9$DynamicBannerItem
  extends MessageMicro<DynamicBannerItem>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_dynamic_json = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "bytes_dynamic_json" }, new Object[] { localByteStringMicro }, DynamicBannerItem.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.cmd0xbc9.oidb_cmd0xbc9.DynamicBannerItem
 * JD-Core Version:    0.7.0.1
 */