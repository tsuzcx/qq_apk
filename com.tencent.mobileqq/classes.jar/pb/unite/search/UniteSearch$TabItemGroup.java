package pb.unite.search;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class UniteSearch$TabItemGroup
  extends MessageMicro<TabItemGroup>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBRepeatField<Long> rpt_group_mask = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  public final PBBytesField tab_name = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 18, 24 }, new String[] { "tab_name", "rpt_group_mask" }, new Object[] { localByteStringMicro, Long.valueOf(0L) }, TabItemGroup.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     pb.unite.search.UniteSearch.TabItemGroup
 * JD-Core Version:    0.7.0.1
 */