package tencent.im.cs.longconn.putinfo;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class hd_video_putinfo$AudioSwitchPointInfo
  extends MessageMicro<AudioSwitchPointInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_nowifi_words = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_wifi_words = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_nowifi_pack_loss = PBField.initUInt32(0);
  public final PBUInt32Field uint32_nowifi_pack_loss_rate = PBField.initUInt32(0);
  public final PBUInt32Field uint32_nowifi_shake = PBField.initUInt32(0);
  public final PBUInt32Field uint32_nowifi_time_delay = PBField.initUInt32(0);
  public final PBUInt32Field uint32_wifi_pack_loss = PBField.initUInt32(0);
  public final PBUInt32Field uint32_wifi_pack_loss_rate = PBField.initUInt32(0);
  public final PBUInt32Field uint32_wifi_shake = PBField.initUInt32(0);
  public final PBUInt32Field uint32_wifi_time_delay = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 50, 56, 64, 72, 80, 98 }, new String[] { "uint32_wifi_shake", "uint32_wifi_time_delay", "uint32_wifi_pack_loss", "uint32_wifi_pack_loss_rate", "bytes_wifi_words", "uint32_nowifi_shake", "uint32_nowifi_time_delay", "uint32_nowifi_pack_loss", "uint32_nowifi_pack_loss_rate", "bytes_nowifi_words" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro1, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro2 }, AudioSwitchPointInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.cs.longconn.putinfo.hd_video_putinfo.AudioSwitchPointInfo
 * JD-Core Version:    0.7.0.1
 */