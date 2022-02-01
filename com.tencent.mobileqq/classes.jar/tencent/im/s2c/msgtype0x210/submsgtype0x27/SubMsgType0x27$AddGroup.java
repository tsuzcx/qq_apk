package tencent.im.s2c.msgtype0x210.submsgtype0x27;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class SubMsgType0x27$AddGroup
  extends MessageMicro<AddGroup>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_groupname = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_groupid = PBField.initUInt32(0);
  public final PBUInt32Field uint32_sortid = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "uint32_groupid", "uint32_sortid", "bytes_groupname" }, new Object[] { localInteger, localInteger, localByteStringMicro }, AddGroup.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.AddGroup
 * JD-Core Version:    0.7.0.1
 */