package tencent.im.oidb.cmd0x802;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;

public final class oidb_0x802$JoinRoomAuthBufReq
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_identifier = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBInt32Field int32_roomID = PBField.initInt32(0);
  public final PBInt64Field int64_peerUin = PBField.initInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "int32_roomID", "bytes_identifier", "int64_peerUin" }, new Object[] { Integer.valueOf(0), localByteStringMicro, Long.valueOf(0L) }, JoinRoomAuthBufReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x802.oidb_0x802.JoinRoomAuthBufReq
 * JD-Core Version:    0.7.0.1
 */