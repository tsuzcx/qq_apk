package tencent.im.oidb.hotchat;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

public final class oidb_0xa8b$DeletePoid
  extends MessageMicro<DeletePoid>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_poid = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "bytes_poid" }, new Object[] { localByteStringMicro }, DeletePoid.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.hotchat.oidb_0xa8b.DeletePoid
 * JD-Core Version:    0.7.0.1
 */