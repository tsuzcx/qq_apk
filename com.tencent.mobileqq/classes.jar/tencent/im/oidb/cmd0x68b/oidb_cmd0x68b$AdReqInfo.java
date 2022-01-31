package tencent.im.oidb.cmd0x68b;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0x68b$AdReqInfo
  extends MessageMicro<AdReqInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uint64_ad_channel_id" }, new Object[] { Long.valueOf(0L) }, AdReqInfo.class);
  public final PBUInt64Field uint64_ad_channel_id = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.AdReqInfo
 * JD-Core Version:    0.7.0.1
 */