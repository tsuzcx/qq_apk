package tencent.im.troop.activity;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class troopactivity$ActSSORsp
  extends MessageMicro<ActSSORsp>
{
  public static final int BODY_FIELD_NUMBER = 4;
  public static final int CMD_FIELD_NUMBER = 3;
  public static final int ERR_CODE_FIELD_NUMBER = 1;
  public static final int ERR_MSG_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField body = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBEnumField cmd = PBField.initEnum(0);
  public final PBEnumField err_code = PBField.initEnum(10000);
  public final PBStringField err_msg = PBField.initString("");
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34 }, new String[] { "err_code", "err_msg", "cmd", "body" }, new Object[] { Integer.valueOf(10000), "", Integer.valueOf(0), localByteStringMicro }, ActSSORsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.troop.activity.troopactivity.ActSSORsp
 * JD-Core Version:    0.7.0.1
 */