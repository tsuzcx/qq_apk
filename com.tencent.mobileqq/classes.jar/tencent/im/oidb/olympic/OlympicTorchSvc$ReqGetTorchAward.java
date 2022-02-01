package tencent.im.oidb.olympic;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class OlympicTorchSvc$ReqGetTorchAward
  extends MessageMicro<ReqGetTorchAward>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_pack_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_sig = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatField<Long> rpt_city_pic_id_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  public final PBUInt32Field uint32_business = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 82 }, new String[] { "bytes_pack_id", "uint32_business", "rpt_city_pic_id_list", "bytes_sig" }, new Object[] { localByteStringMicro1, Integer.valueOf(0), Long.valueOf(0L), localByteStringMicro2 }, ReqGetTorchAward.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.olympic.OlympicTorchSvc.ReqGetTorchAward
 * JD-Core Version:    0.7.0.1
 */