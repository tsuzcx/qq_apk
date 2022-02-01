package tencent.im.oidb.cmd0xc46;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_cmd0xc46$AdReqInfo
  extends MessageMicro<AdReqInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uint64_ad_channel_id" }, new Object[] { Integer.valueOf(0) }, AdReqInfo.class);
  public final PBUInt32Field uint64_ad_channel_id = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0xc46.oidb_cmd0xc46.AdReqInfo
 * JD-Core Version:    0.7.0.1
 */