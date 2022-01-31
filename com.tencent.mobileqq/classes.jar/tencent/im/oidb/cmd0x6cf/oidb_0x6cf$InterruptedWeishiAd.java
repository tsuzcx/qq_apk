package tencent.im.oidb.cmd0x6cf;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0x6cf$InterruptedWeishiAd
  extends MessageMicro<InterruptedWeishiAd>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public oidb_0x6cf.AppAdInfo appInfo = new oidb_0x6cf.AppAdInfo();
  public final PBBytesField bytes_ad_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_common_data = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_show_positon = PBField.initBytes(ByteStringMicro.EMPTY);
  public oidb_0x6cf.ECommerceEntranceInfo msg_ecommerce_entrance_info = new oidb_0x6cf.ECommerceEntranceInfo();
  public final PBUInt32Field uint32_interrupted_ad_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_is_show_in_play_end = PBField.initUInt32(0);
  public final PBUInt32Field uint32_is_show_in_switch = PBField.initUInt32(0);
  public final PBUInt32Field uint32_show_after_play_time = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 42, 50, 58, 64, 74 }, new String[] { "bytes_show_positon", "uint32_is_show_in_switch", "uint32_is_show_in_play_end", "uint32_show_after_play_time", "bytes_ad_url", "bytes_common_data", "msg_ecommerce_entrance_info", "uint32_interrupted_ad_type", "appInfo" }, new Object[] { localByteStringMicro1, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro2, localByteStringMicro3, null, Integer.valueOf(0), null }, InterruptedWeishiAd.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0x6cf.oidb_0x6cf.InterruptedWeishiAd
 * JD-Core Version:    0.7.0.1
 */