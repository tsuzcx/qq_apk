package cooperation.vip.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class vac_adv_get$VacFeedsAdvReq
  extends MessageMicro<VacFeedsAdvReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBEnumField adv_pos = PBField.initEnum(1);
  public final PBStringField attach_info = PBField.initString("");
  public final PBInt32Field page_num = PBField.initInt32(0);
  public final PBInt32Field pre_feed_index = PBField.initInt32(0);
  public final PBUInt64Field qq = PBField.initUInt64(0L);
  public final PBRepeatField<String> recom_adv_pos = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBBytesField req_buffer = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 40, 50, 58 }, new String[] { "qq", "adv_pos", "req_buffer", "page_num", "pre_feed_index", "recom_adv_pos", "attach_info" }, new Object[] { Long.valueOf(0L), Integer.valueOf(1), localByteStringMicro, localInteger, localInteger, "", "" }, VacFeedsAdvReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.vip.pb.vac_adv_get.VacFeedsAdvReq
 * JD-Core Version:    0.7.0.1
 */