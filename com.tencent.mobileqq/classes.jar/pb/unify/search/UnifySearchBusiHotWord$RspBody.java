package pb.unify.search;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class UnifySearchBusiHotWord$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32 }, new String[] { "result_code", "error_msg", "rpt_item_groups", "expire_time" }, new Object[] { Integer.valueOf(0), "", null, Integer.valueOf(0) }, RspBody.class);
  public final PBStringField error_msg = PBField.initString("");
  public final PBUInt32Field expire_time = PBField.initUInt32(0);
  public final PBUInt32Field result_code = PBField.initUInt32(0);
  public final PBRepeatMessageField<UnifySearchBusiHotWord.GroupWord> rpt_item_groups = PBField.initRepeatMessage(UnifySearchBusiHotWord.GroupWord.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     pb.unify.search.UnifySearchBusiHotWord.RspBody
 * JD-Core Version:    0.7.0.1
 */