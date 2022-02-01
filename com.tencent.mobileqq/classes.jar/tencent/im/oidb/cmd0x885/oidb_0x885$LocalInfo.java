package tencent.im.oidb.cmd0x885;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

public final class oidb_0x885$LocalInfo
  extends MessageMicro<LocalInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_corporate_image_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_distance_description = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_distance_limit = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_store_address = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_store_latitude = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_store_longitude = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_store_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_store_url = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro6 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro7 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro8 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 58, 66 }, new String[] { "bytes_store_name", "bytes_store_url", "bytes_store_address", "bytes_store_longitude", "bytes_store_latitude", "bytes_distance_description", "bytes_corporate_image_name", "bytes_distance_limit" }, new Object[] { localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, localByteStringMicro5, localByteStringMicro6, localByteStringMicro7, localByteStringMicro8 }, LocalInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0x885.oidb_0x885.LocalInfo
 * JD-Core Version:    0.7.0.1
 */