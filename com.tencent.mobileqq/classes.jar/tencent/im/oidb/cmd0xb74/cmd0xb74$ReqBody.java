package tencent.im.oidb.cmd0xb74;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class cmd0xb74$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBRepeatField<ByteStringMicro> rpt_bytes_rowkey = PBField.initRepeat(PBBytesField.__repeatHelper__);
  public final PBUInt32Field uint32_need_fusion_biu_info = PBField.initUInt32(0);
  public final PBUInt32Field uint32_need_like_count = PBField.initUInt32(0);
  public final PBUInt32Field uint32_need_like_status = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32 }, new String[] { "rpt_bytes_rowkey", "uint32_need_like_count", "uint32_need_like_status", "uint32_need_fusion_biu_info" }, new Object[] { localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, ReqBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0xb74.cmd0xb74.ReqBody
 * JD-Core Version:    0.7.0.1
 */