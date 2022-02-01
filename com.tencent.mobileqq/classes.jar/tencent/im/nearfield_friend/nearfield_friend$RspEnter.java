package tencent.im.nearfield_friend;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class nearfield_friend$RspEnter
  extends MessageMicro<RspEnter>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field expire_time = PBField.initUInt32(0);
  public final PBUInt32Field heartbeat_time = PBField.initUInt32(0);
  public nearfield_friend.ResultInfo result = new nearfield_friend.ResultInfo();
  public final PBUInt32Field security_level = PBField.initUInt32(0);
  public final PBBytesField verify_url = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 32, 40 }, new String[] { "result", "security_level", "verify_url", "heartbeat_time", "expire_time" }, new Object[] { null, Integer.valueOf(0), localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0) }, RspEnter.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.nearfield_friend.nearfield_friend.RspEnter
 * JD-Core Version:    0.7.0.1
 */