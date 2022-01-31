package tencent.im.oidb.cmd0x935;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class oidb_0x935$RecommendInfo
  extends MessageMicro<RecommendInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_woring = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatMessageField<oidb_0x935.RgroupInfo> msg_groups = PBField.initRepeatMessage(oidb_0x935.RgroupInfo.class);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "bytes_woring", "msg_groups" }, new Object[] { localByteStringMicro, null }, RecommendInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0x935.oidb_0x935.RecommendInfo
 * JD-Core Version:    0.7.0.1
 */