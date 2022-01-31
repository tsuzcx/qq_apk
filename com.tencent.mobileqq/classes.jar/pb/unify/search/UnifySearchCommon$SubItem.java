package pb.unify.search;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class UnifySearchCommon$SubItem
  extends MessageMicro<SubItem>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField backgroud_color = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField jump_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field layout_id = PBField.initUInt32(0);
  public final PBRepeatMessageField<UnifySearchCommon.SubItemMedia> media_list = PBField.initRepeatMessage(UnifySearchCommon.SubItemMedia.class);
  public final PBUInt32Field media_total_count = PBField.initUInt32(0);
  public final PBUInt32Field show_arrow = PBField.initUInt32(0);
  public final PBRepeatMessageField<UnifySearchCommon.SubItemText> summary = PBField.initRepeatMessage(UnifySearchCommon.SubItemText.class);
  public final PBRepeatMessageField<UnifySearchCommon.SubItemText> title = PBField.initRepeatMessage(UnifySearchCommon.SubItemText.class);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 42, 50, 56, 66 }, new String[] { "layout_id", "title", "summary", "media_total_count", "media_list", "jump_url", "show_arrow", "backgroud_color" }, new Object[] { Integer.valueOf(0), null, null, Integer.valueOf(0), null, localByteStringMicro1, Integer.valueOf(0), localByteStringMicro2 }, SubItem.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     pb.unify.search.UnifySearchCommon.SubItem
 * JD-Core Version:    0.7.0.1
 */