package tencent.im.oidb.cmd0x7df;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x7df$FriendScore
  extends MessageMicro<FriendScore>
{
  public static final int BYTES_NICK_FIELD_NUMBER = 5;
  public static final int BYTES_RELATION_NAME_FIELD_NUMBER = 3;
  public static final int UINT32_FRIEND_SCORE_FIELD_NUMBER = 2;
  public static final int UINT32_RANK_FIELD_NUMBER = 4;
  public static final int UINT64_FRIEND_UIN_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_nick = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_relation_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_friend_score = PBField.initUInt32(0);
  public final PBUInt32Field uint32_rank = PBField.initUInt32(0);
  public final PBUInt64Field uint64_friend_uin = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 42 }, new String[] { "uint64_friend_uin", "uint32_friend_score", "bytes_relation_name", "uint32_rank", "bytes_nick" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro1, Integer.valueOf(0), localByteStringMicro2 }, FriendScore.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.cmd0x7df.oidb_0x7df.FriendScore
 * JD-Core Version:    0.7.0.1
 */