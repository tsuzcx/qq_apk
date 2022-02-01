package tencent.im.oidb.hotchat;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0x8ab$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField hotnamecode = PBField.initBytes(ByteStringMicro.EMPTY);
  public LBS.LBSInfo lbs_info = new LBS.LBSInfo();
  public final PBUInt32Field req_flag = PBField.initUInt32(0);
  public final PBUInt32Field version_flag = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32 }, new String[] { "lbs_info", "hotnamecode", "req_flag", "version_flag" }, new Object[] { null, localByteStringMicro, localInteger, localInteger }, ReqBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.hotchat.oidb_0x8ab.ReqBody
 * JD-Core Version:    0.7.0.1
 */