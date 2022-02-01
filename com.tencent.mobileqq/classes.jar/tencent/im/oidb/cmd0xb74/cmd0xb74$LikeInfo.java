package tencent.im.oidb.cmd0xb74;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class cmd0xb74$LikeInfo
  extends MessageMicro<LikeInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_rowkey = PBField.initBytes(ByteStringMicro.EMPTY);
  public cmd0xb74.FusionBiuInfo msg_fusion_biu_info = new cmd0xb74.FusionBiuInfo();
  public final PBUInt32Field uint32_is_like = PBField.initUInt32(0);
  public final PBUInt32Field uint32_like_count = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34 }, new String[] { "bytes_rowkey", "uint32_like_count", "uint32_is_like", "msg_fusion_biu_info" }, new Object[] { localByteStringMicro, localInteger, localInteger, null }, LikeInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xb74.cmd0xb74.LikeInfo
 * JD-Core Version:    0.7.0.1
 */