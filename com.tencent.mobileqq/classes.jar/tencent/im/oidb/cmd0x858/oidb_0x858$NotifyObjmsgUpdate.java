package tencent.im.oidb.cmd0x858;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0x858$NotifyObjmsgUpdate
  extends MessageMicro<NotifyObjmsgUpdate>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_ext_msg = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_objmsg_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_update_type = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26 }, new String[] { "bytes_objmsg_id", "uint32_update_type", "bytes_ext_msg" }, new Object[] { localByteStringMicro1, Integer.valueOf(0), localByteStringMicro2 }, NotifyObjmsgUpdate.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0x858.oidb_0x858.NotifyObjmsgUpdate
 * JD-Core Version:    0.7.0.1
 */