package tencent.im.oidb.cmd0xcdd;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;

public final class oidb_cmd0xcdd$QueryStateRsp
  extends MessageMicro<QueryStateRsp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBEnumField biz_type = PBField.initEnum(1);
  public final PBBytesField encrypt_key = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBEnumField state = PBField.initEnum(1);
  public final PBBytesField token = PBField.initBytes(ByteStringMicro.EMPTY);
  public oidb_cmd0xcdd.UserData user_data = new oidb_cmd0xcdd.UserData();
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 40 }, new String[] { "state", "token", "encrypt_key", "user_data", "biz_type" }, new Object[] { Integer.valueOf(1), localByteStringMicro1, localByteStringMicro2, null, Integer.valueOf(1) }, QueryStateRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.cmd0xcdd.oidb_cmd0xcdd.QueryStateRsp
 * JD-Core Version:    0.7.0.1
 */