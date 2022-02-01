package tencent.im.oidb.gallery.ad;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.oidb.cmd0x885.oidb_0x885.PhoneInfo;
import tencent.im.oidb.cmd0x885.oidb_0x885.VideoFloatInfo;

public final class galleryAd$ReqAdvertisePara
  extends MessageMicro<ReqAdvertisePara>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
  public oidb_0x885.PhoneInfo msg_phone_info = new oidb_0x885.PhoneInfo();
  public oidb_0x885.VideoFloatInfo msg_video_float_info = new oidb_0x885.VideoFloatInfo();
  public final PBUInt64Field uint64_last_time = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34 }, new String[] { "msg_phone_info", "uint64_last_time", "msg_video_float_info", "bytes_cookie" }, new Object[] { null, Long.valueOf(0L), null, localByteStringMicro }, ReqAdvertisePara.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.gallery.ad.galleryAd.ReqAdvertisePara
 * JD-Core Version:    0.7.0.1
 */