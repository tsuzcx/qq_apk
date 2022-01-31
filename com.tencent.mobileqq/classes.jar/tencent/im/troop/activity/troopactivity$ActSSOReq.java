package tencent.im.troop.activity;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class troopactivity$ActSSOReq
  extends MessageMicro<ActSSOReq>
{
  public static final int BODY_FIELD_NUMBER = 3;
  public static final int CMD_FIELD_NUMBER = 1;
  public static final int GROUP_CODE_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField body = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBEnumField cmd = PBField.initEnum(0);
  public final PBUInt64Field group_code = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "cmd", "group_code", "body" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), localByteStringMicro }, ActSSOReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     tencent.im.troop.activity.troopactivity.ActSSOReq
 * JD-Core Version:    0.7.0.1
 */