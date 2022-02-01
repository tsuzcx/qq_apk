package tencent.im.nearfield_friend;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class nearfield_friend$ReqEnter
  extends MessageMicro<ReqEnter>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public nearfield_friend.GPS gps_info = new nearfield_friend.GPS();
  public final PBStringField number = PBField.initString("");
  public final PBStringField session_id = PBField.initString("");
  public final PBBytesField verify_sig = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "session_id", "gps_info", "number", "verify_sig" }, new Object[] { "", null, "", localByteStringMicro }, ReqEnter.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.nearfield_friend.nearfield_friend.ReqEnter
 * JD-Core Version:    0.7.0.1
 */