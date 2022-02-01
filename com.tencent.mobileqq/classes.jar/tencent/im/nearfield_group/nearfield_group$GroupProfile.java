package tencent.im.nearfield_group;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class nearfield_group$GroupProfile
  extends MessageMicro<GroupProfile>
{
  public static final int BYTES_DISTANCE_FIELD_NUMBER = 5;
  public static final int BYTES_GROUP_NAME_FIELD_NUMBER = 2;
  public static final int BYTES_OWNER_NICK_FIELD_NUMBER = 4;
  public static final int UINT64_GROUP_CODE_FIELD_NUMBER = 1;
  public static final int UINT64_OWNER_UIN_FIELD_NUMBER = 3;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_distance = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_group_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_owner_nick = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_owner_uin = PBField.initUInt64(0L);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34, 42 }, new String[] { "uint64_group_code", "bytes_group_name", "uint64_owner_uin", "bytes_owner_nick", "bytes_distance" }, new Object[] { localLong, localByteStringMicro1, localLong, localByteStringMicro2, localByteStringMicro3 }, GroupProfile.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.nearfield_group.nearfield_group.GroupProfile
 * JD-Core Version:    0.7.0.1
 */