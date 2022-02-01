package tencent.im.oidb.nowlive;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class nowlive$LiveInfo
  extends MessageMicro<LiveInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field audience = PBField.initUInt32(0);
  public final PBUInt32Field live_statue = PBField.initUInt32(0);
  public final PBStringField live_url = PBField.initString("");
  public final PBStringField room_cover = PBField.initString("");
  public final PBStringField room_name = PBField.initString("");
  public final PBBytesField vid = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 40, 50 }, new String[] { "live_url", "room_name", "room_cover", "live_statue", "audience", "vid" }, new Object[] { "", "", "", localInteger, localInteger, localByteStringMicro }, LiveInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.nowlive.nowlive.LiveInfo
 * JD-Core Version:    0.7.0.1
 */