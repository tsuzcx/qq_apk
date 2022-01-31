package tencent.im.oidb.cmd0x86f;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x86f$UserInteractState
  extends MessageMicro<UserInteractState>
{
  public static final int STATE_TYPE_AWARD_POST = 3;
  public static final int STATE_TYPE_FACE_SCORE_DOT_LIKE = 1001;
  public static final int STATE_TYPE_FACE_SCORE_INVITE_PIC = 1002;
  public static final int STATE_TYPE_FOLLOW = 9;
  public static final int STATE_TYPE_LIKE_COMMENT = 5;
  public static final int STATE_TYPE_LIKE_POST = 2;
  public static final int STATE_TYPE_NEARBY_LIKE_POST = 7;
  public static final int STATE_TYPE_NEARBY_REPLY_COMMENT = 8;
  public static final int STATE_TYPE_NEARBY_REPLY_POST = 6;
  public static final int STATE_TYPE_REPLY_COMMENT = 4;
  public static final int STATE_TYPE_REPLY_POST = 1;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_heap_jump_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_icon_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_jump_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_jump_url2 = PBField.initBytes(ByteStringMicro.EMPTY);
  public oidb_0x86f.Details msg_details = new oidb_0x86f.Details();
  public oidb_0x86f.UserInfo msg_userinfo = new oidb_0x86f.UserInfo();
  public final PBUInt32Field uint32_state_type = PBField.initUInt32(0);
  public final PBUInt64Field uint64_seq = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_time = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42, 50, 58, 66, 802 }, new String[] { "uint32_state_type", "uint64_time", "uint64_seq", "msg_userinfo", "msg_details", "bytes_icon_url", "bytes_jump_url", "bytes_heap_jump_url", "bytes_jump_url2" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), null, null, localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4 }, UserInteractState.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.cmd0x86f.oidb_0x86f.UserInteractState
 * JD-Core Version:    0.7.0.1
 */