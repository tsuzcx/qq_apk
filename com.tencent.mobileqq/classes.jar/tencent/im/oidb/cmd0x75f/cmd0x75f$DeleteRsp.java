package tencent.im.oidb.cmd0x75f;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

public final class cmd0x75f$DeleteRsp
  extends MessageMicro<DeleteRsp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_msg_id = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "bytes_msg_id" }, new Object[] { localByteStringMicro }, DeleteRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0x75f.cmd0x75f.DeleteRsp
 * JD-Core Version:    0.7.0.1
 */