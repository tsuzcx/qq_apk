package tencent.im.s2c.msgtype0x210.submsgtype0x76;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class SubMsgType0x76$GeoGraphicNotify
  extends MessageMicro<GeoGraphicNotify>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_local_city = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatMessageField<SubMsgType0x76.OneGeoGraphicFriend> rpt_msg_one_friend = PBField.initRepeatMessage(SubMsgType0x76.OneGeoGraphicFriend.class);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "bytes_local_city", "rpt_msg_one_friend" }, new Object[] { localByteStringMicro, null }, GeoGraphicNotify.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0x76.SubMsgType0x76.GeoGraphicNotify
 * JD-Core Version:    0.7.0.1
 */