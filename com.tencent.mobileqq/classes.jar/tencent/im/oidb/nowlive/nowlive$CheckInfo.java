package tencent.im.oidb.nowlive;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class nowlive$CheckInfo
  extends MessageMicro<CheckInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField live_url = PBField.initString("");
  public final PBUInt64Field uin = PBField.initUInt64(0L);
  public final PBBytesField vid = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "uin", "live_url", "vid" }, new Object[] { Long.valueOf(0L), "", localByteStringMicro }, CheckInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.nowlive.nowlive.CheckInfo
 * JD-Core Version:    0.7.0.1
 */