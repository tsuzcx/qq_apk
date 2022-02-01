package tencent.im.cs.doutu;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class Doutu$GetImgInfoReq
  extends MessageMicro<GetImgInfoReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBEnumField chat_type = PBField.initEnum(1);
  public final PBUInt32Field uin32_gender = PBField.initUInt32(0);
  public final PBUInt32Field uint32_age = PBField.initUInt32(0);
  public final PBUInt32Field uint32_src_term = PBField.initUInt32(0);
  public final PBUInt64Field uint64_src_uin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_to_uin = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48 }, new String[] { "uint64_src_uin", "uint32_src_term", "uint32_age", "uin32_gender", "uint64_to_uin", "chat_type" }, new Object[] { localLong, localInteger, localInteger, localInteger, localLong, Integer.valueOf(1) }, GetImgInfoReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.cs.doutu.Doutu.GetImgInfoReq
 * JD-Core Version:    0.7.0.1
 */