package pb.unite.search;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class UniteSearch$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField cookie_topic = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBStringField error_msg = PBField.initString("");
  public final PBUInt32Field is_end_topic = PBField.initUInt32(0);
  public final PBRepeatMessageField<DynamicSearch.ResultItemGroup> item_groups = PBField.initRepeatMessage(DynamicSearch.ResultItemGroup.class);
  public final PBUInt32Field result_code = PBField.initUInt32(0);
  public final PBBytesField search_ver = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatMessageField<UniteSearch.TabItemGroup> tab_groups = PBField.initRepeatMessage(UniteSearch.TabItemGroup.class);
  public final PBUInt32Field trigger_netword_num = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 40, 50, 58, 64 }, new String[] { "result_code", "error_msg", "item_groups", "tab_groups", "is_end_topic", "cookie_topic", "search_ver", "trigger_netword_num" }, new Object[] { Integer.valueOf(0), "", null, null, Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0) }, RspBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pb.unite.search.UniteSearch.RspBody
 * JD-Core Version:    0.7.0.1
 */