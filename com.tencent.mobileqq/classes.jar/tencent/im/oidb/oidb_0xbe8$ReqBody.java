package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0xbe8$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBEnumField enum_op_code = PBField.initEnum(1);
  public final PBRepeatMessageField<oidb_0xbe8.PopupResult> rpt_msg_popup_result = PBField.initRepeatMessage(oidb_0xbe8.PopupResult.class);
  public final PBUInt32Field uint32_mqq808_welcomepage_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_of_popup_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_rst_of_popup_flag = PBField.initUInt32(0);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 50 }, new String[] { "uint64_uin", "enum_op_code", "uint32_req_of_popup_flag", "uint32_rst_of_popup_flag", "uint32_mqq808_welcomepage_flag", "rpt_msg_popup_result" }, new Object[] { Long.valueOf(0L), Integer.valueOf(1), localInteger, localInteger, localInteger, null }, ReqBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.oidb_0xbe8.ReqBody
 * JD-Core Version:    0.7.0.1
 */