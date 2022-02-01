package tencent.im.group_pro_proto.msgpush;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class servtype$UpdateCategory
  extends MessageMicro<UpdateCategory>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "rpt_msg_category_info", "msg_no_classify_category_info" }, new Object[] { null, null }, UpdateCategory.class);
  public servtype.CategoryInfo msg_no_classify_category_info = new servtype.CategoryInfo();
  public final PBRepeatMessageField<servtype.CategoryInfo> rpt_msg_category_info = PBField.initRepeatMessage(servtype.CategoryInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.group_pro_proto.msgpush.servtype.UpdateCategory
 * JD-Core Version:    0.7.0.1
 */