package tencent.im.cs.longconn;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class hd_video_comm$PstnAudioSrtpSdpInfo
  extends MessageMicro<PstnAudioSrtpSdpInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_raw_key = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBEnumField enum_crypto_method = PBField.initEnum(0);
  public final PBUInt32Field uint32_crypto_tag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_key_derivation_rate = PBField.initUInt32(0);
  public final PBUInt32Field uint32_life_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_mki_len = PBField.initUInt32(0);
  public final PBUInt32Field uint32_mki_value = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 40, 48, 56 }, new String[] { "enum_crypto_method", "uint32_crypto_tag", "bytes_raw_key", "uint32_life_time", "uint32_mki_value", "uint32_mki_len", "uint32_key_derivation_rate" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, PstnAudioSrtpSdpInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.cs.longconn.hd_video_comm.PstnAudioSrtpSdpInfo
 * JD-Core Version:    0.7.0.1
 */