package tencent.im.oidb.cmd0xbd2;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_cmd0xbd2$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBRepeatMessageField<oidb_cmd0xbd2.DiscoverBanner> rpt_banner_list = PBField.initRepeatMessage(oidb_cmd0xbd2.DiscoverBanner.class);
  public final PBBytesField rpt_bytes_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatMessageField<oidb_cmd0xbd2.DiscoverTopic> rpt_topic_list = PBField.initRepeatMessage(oidb_cmd0xbd2.DiscoverTopic.class);
  public final PBUInt32Field uint32_has_more = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32 }, new String[] { "rpt_banner_list", "rpt_topic_list", "rpt_bytes_cookie", "uint32_has_more" }, new Object[] { null, null, localByteStringMicro, Integer.valueOf(0) }, RspBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0xbd2.oidb_cmd0xbd2.RspBody
 * JD-Core Version:    0.7.0.1
 */