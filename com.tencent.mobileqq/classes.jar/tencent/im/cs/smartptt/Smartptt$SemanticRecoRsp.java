package tencent.im.cs.smartptt;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class Smartptt$SemanticRecoRsp
  extends MessageMicro<SemanticRecoRsp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBRepeatMessageField<Smartptt.Slot> slot_info = PBField.initRepeatMessage(Smartptt.Slot.class);
  public final PBStringField str_ans_node_name = PBField.initString("");
  public final PBStringField str_answer = PBField.initString("");
  public final PBStringField str_title = PBField.initString("");
  public final PBStringField str_voice_id = PBField.initString("");
  public final PBUInt32Field uint32_ans_node_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_is_final = PBField.initUInt32(0);
  public final PBUInt32Field uint32_ret_code = PBField.initUInt32(0);
  public final PBUInt32Field uint32_title_id = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34, 40, 56, 66, 74, 82 }, new String[] { "uint32_ret_code", "str_voice_id", "uint32_ans_node_id", "str_ans_node_name", "uint32_is_final", "uint32_title_id", "str_title", "slot_info", "str_answer" }, new Object[] { localInteger, "", localInteger, "", localInteger, localInteger, "", null, "" }, SemanticRecoRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.cs.smartptt.Smartptt.SemanticRecoRsp
 * JD-Core Version:    0.7.0.1
 */