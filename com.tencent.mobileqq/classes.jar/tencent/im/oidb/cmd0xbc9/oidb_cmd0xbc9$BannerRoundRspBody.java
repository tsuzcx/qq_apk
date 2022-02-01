package tencent.im.oidb.cmd0xbc9;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_cmd0xbc9$BannerRoundRspBody
  extends MessageMicro<BannerRoundRspBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
  public oidb_cmd0xbc9.MoreChannelItem msg_more_channel_item = new oidb_cmd0xbc9.MoreChannelItem();
  public final PBRepeatMessageField<oidb_cmd0xbc9.BannerItem> rpt_msg_banner_list = PBField.initRepeatMessage(oidb_cmd0xbc9.BannerItem.class);
  public final PBRepeatMessageField<oidb_cmd0xbc9.DynamicBannerItem> rpt_msg_dynamic_banner_list = PBField.initRepeatMessage(oidb_cmd0xbc9.DynamicBannerItem.class);
  public final PBUInt32Field uint32_channel_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_need_update = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34, 42, 50 }, new String[] { "uint32_need_update", "rpt_msg_banner_list", "uint32_channel_id", "bytes_cookie", "rpt_msg_dynamic_banner_list", "msg_more_channel_item" }, new Object[] { Integer.valueOf(0), null, Integer.valueOf(0), localByteStringMicro, null, null }, BannerRoundRspBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.cmd0xbc9.oidb_cmd0xbc9.BannerRoundRspBody
 * JD-Core Version:    0.7.0.1
 */