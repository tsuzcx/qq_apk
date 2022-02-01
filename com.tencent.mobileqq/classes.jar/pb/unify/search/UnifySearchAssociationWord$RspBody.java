package pb.unify.search;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class UnifySearchAssociationWord$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42 }, new String[] { "result_code", "error_msg", "association_items", "suggest_url_items", "completed_url_item" }, new Object[] { Integer.valueOf(0), "", null, null, null }, RspBody.class);
  public final PBRepeatMessageField<UnifySearchAssociationWord.AssociationItem> association_items = PBField.initRepeatMessage(UnifySearchAssociationWord.AssociationItem.class);
  public UnifySearchAssociationWord.SuggestUrlItem completed_url_item = new UnifySearchAssociationWord.SuggestUrlItem();
  public final PBStringField error_msg = PBField.initString("");
  public final PBUInt32Field result_code = PBField.initUInt32(0);
  public final PBRepeatMessageField<UnifySearchAssociationWord.SuggestUrlItem> suggest_url_items = PBField.initRepeatMessage(UnifySearchAssociationWord.SuggestUrlItem.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     pb.unify.search.UnifySearchAssociationWord.RspBody
 * JD-Core Version:    0.7.0.1
 */