package tencent.im.msg;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class im_common$Signature
  extends MessageMicro<Signature>
{
  public static final int KEY_TYPE_FIELD_NUMBER = 1;
  public static final int SESSION_APP_ID_FIELD_NUMBER = 2;
  public static final int SESSION_KEY_FIELD_NUMBER = 3;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field key_type = PBField.initUInt32(0);
  public final PBUInt32Field session_app_id = PBField.initUInt32(0);
  public final PBBytesField session_key = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "key_type", "session_app_id", "session_key" }, new Object[] { localInteger, localInteger, localByteStringMicro }, Signature.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.msg.im_common.Signature
 * JD-Core Version:    0.7.0.1
 */