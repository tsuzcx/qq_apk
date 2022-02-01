package tencent.im.oidb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0xc26$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_cookies = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBEnumField em_entry = PBField.initEnum(1);
  public final PBRepeatField<Long> rpt_expected_uins = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  public final PBRepeatField<Long> rpt_filter_uins = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  public final PBUInt32Field uint32_fetch_rgroup = PBField.initUInt32(0);
  public final PBUInt32Field uint32_phone_book = PBField.initUInt32(0);
  public final PBUInt32Field uint32_tab_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_want = PBField.initUInt32(80);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    Long localLong = Long.valueOf(0L);
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56, 66 }, new String[] { "rpt_filter_uins", "uint32_phone_book", "rpt_expected_uins", "em_entry", "uint32_fetch_rgroup", "uint32_tab_id", "uint32_want", "bytes_cookies" }, new Object[] { localLong, localInteger, localLong, Integer.valueOf(1), localInteger, localInteger, Integer.valueOf(80), localByteStringMicro }, ReqBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.oidb_0xc26.ReqBody
 * JD-Core Version:    0.7.0.1
 */