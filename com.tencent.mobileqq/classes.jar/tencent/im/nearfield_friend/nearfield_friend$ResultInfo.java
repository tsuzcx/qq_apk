package tencent.im.nearfield_friend;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class nearfield_friend$ResultInfo
  extends MessageMicro<ResultInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field errcode = PBField.initUInt32(0);
  public final PBBytesField errmsg = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "errcode", "errmsg" }, new Object[] { Integer.valueOf(0), localByteStringMicro }, ResultInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     tencent.im.nearfield_friend.nearfield_friend.ResultInfo
 * JD-Core Version:    0.7.0.1
 */