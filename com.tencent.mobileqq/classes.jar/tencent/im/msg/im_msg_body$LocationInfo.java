package tencent.im.msg;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBField;

public final class im_msg_body$LocationInfo
  extends MessageMicro<LocationInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_desc = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBDoubleField double_latitude = PBField.initDouble(0.0D);
  public final PBDoubleField double_longitude = PBField.initDouble(0.0D);
  
  static
  {
    Double localDouble = Double.valueOf(0.0D);
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 9, 17, 26 }, new String[] { "double_longitude", "double_latitude", "bytes_desc" }, new Object[] { localDouble, localDouble, localByteStringMicro }, LocationInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.msg.im_msg_body.LocationInfo
 * JD-Core Version:    0.7.0.1
 */