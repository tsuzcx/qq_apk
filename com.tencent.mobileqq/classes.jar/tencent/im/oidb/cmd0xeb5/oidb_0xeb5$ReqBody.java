package tencent.im.oidb.cmd0xeb5;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0xeb5$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field aio_type = PBField.initUInt32(0);
  public final PBBytesField cookies = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt64Field friend_uin = PBField.initUInt64(0L);
  public final PBBoolField no_mini_app = PBField.initBool(false);
  public final PBUInt32Field num = PBField.initUInt32(0);
  public final PBBoolField redpoint = PBField.initBool(false);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42, 48 }, new String[] { "friend_uin", "aio_type", "redpoint", "num", "cookies", "no_mini_app" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Boolean.valueOf(false), Integer.valueOf(0), localByteStringMicro, Boolean.valueOf(false) }, ReqBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0xeb5.oidb_0xeb5.ReqBody
 * JD-Core Version:    0.7.0.1
 */