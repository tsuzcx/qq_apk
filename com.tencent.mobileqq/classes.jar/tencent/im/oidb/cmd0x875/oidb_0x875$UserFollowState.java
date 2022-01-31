package tencent.im.oidb.cmd0x875;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x875$UserFollowState
  extends MessageMicro<UserFollowState>
{
  public static final int STATE_TYPE_CREATE_HOTCHAT = 13;
  public static final int STATE_TYPE_NEARBY_POST = 12;
  public static final int STATE_TYPE_NEW_POST = 11;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_from = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_jump_schema = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_op_txt = PBField.initBytes(ByteStringMicro.EMPTY);
  public oidb_0x875.Details msg_details = new oidb_0x875.Details();
  public oidb_0x875.UserInfo msg_userinfo = new oidb_0x875.UserInfo();
  public final PBUInt32Field uint32_state_type = PBField.initUInt32(0);
  public final PBUInt64Field uint64_seq = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_time = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 50, 56, 64, 74 }, new String[] { "uint32_state_type", "msg_userinfo", "msg_details", "bytes_from", "bytes_jump_schema", "uint64_time", "uint64_seq", "bytes_op_txt" }, new Object[] { Integer.valueOf(0), null, null, localByteStringMicro1, localByteStringMicro2, Long.valueOf(0L), Long.valueOf(0L), localByteStringMicro3 }, UserFollowState.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.cmd0x875.oidb_0x875.UserFollowState
 * JD-Core Version:    0.7.0.1
 */