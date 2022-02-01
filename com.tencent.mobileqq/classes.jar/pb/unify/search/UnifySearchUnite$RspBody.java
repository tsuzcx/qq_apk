package pb.unify.search;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import unify.search.UnifySearchCommon.ResultItemGroup;

public final class UnifySearchUnite$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField cookie_topic = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBStringField error_msg = PBField.initString("");
  public final PBUInt32Field exhibition_flags = PBField.initUInt32(0);
  public final PBUInt32Field is_end_topic = PBField.initUInt32(0);
  public final PBRepeatMessageField<UnifySearchCommon.ResultItemGroup> item_groups = PBField.initRepeatMessage(UnifySearchCommon.ResultItemGroup.class);
  public final PBFloatField kw_timeliness = PBField.initFloat(0.0F);
  public final PBUInt32Field result_code = PBField.initUInt32(0);
  public final PBBytesField search_ver = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatMessageField<UnifySearchUnite.TabItemGroup> tab_groups = PBField.initRepeatMessage(UnifySearchUnite.TabItemGroup.class);
  public final PBUInt32Field trigger_netword_num = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 40, 50, 58, 64, 77, 80 }, new String[] { "result_code", "error_msg", "item_groups", "tab_groups", "is_end_topic", "cookie_topic", "search_ver", "trigger_netword_num", "kw_timeliness", "exhibition_flags" }, new Object[] { localInteger, "", null, null, localInteger, localByteStringMicro1, localByteStringMicro2, localInteger, Float.valueOf(0.0F), localInteger }, RspBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     pb.unify.search.UnifySearchUnite.RspBody
 * JD-Core Version:    0.7.0.1
 */