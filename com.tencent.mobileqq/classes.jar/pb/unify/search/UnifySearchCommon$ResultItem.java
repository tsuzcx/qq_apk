package pb.unify.search;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class UnifySearchCommon$ResultItem
  extends MessageMicro<ResultItem>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField dbg_msg = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField extension = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBFloatField final_score = PBField.initFloat(0.0F);
  public final PBUInt64Field group_mask = PBField.initUInt64(0L);
  public final PBUInt32Field is_bottom = PBField.initUInt32(0);
  public final PBUInt32Field is_multi_pic = PBField.initUInt32(0);
  public final PBUInt32Field is_top = PBField.initUInt32(0);
  public final PBBytesField jmp_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField layout_content = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field layout_id = PBField.initUInt32(0);
  public final PBBytesField layout_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField ml_formula = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField pic_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField report_ext_data = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField result_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt64Field result_item_type = PBField.initUInt64(0L);
  public final PBRepeatMessageField<UnifySearchCommon.Meaning> rpt_meaning = PBField.initRepeatMessage(UnifySearchCommon.Meaning.class);
  public final PBUInt32Field seporator_type = PBField.initUInt32(0);
  public final PBRepeatMessageField<UnifySearchCommon.SubItem> sub_item_list = PBField.initRepeatMessage(UnifySearchCommon.SubItem.class);
  public final PBRepeatMessageField<ResultItem> sub_result_items = PBField.initRepeatMessage(ResultItem.class);
  public final PBBytesField word = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro6 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro7 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro8 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro9 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro10 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro11 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 58, 64, 74, 80, 90, 96, 104, 114, 125, 130, 170, 176, 184, 194, 800, 810 }, new String[] { "result_id", "name", "pic_url", "jmp_url", "word", "extension", "rpt_meaning", "group_mask", "sub_item_list", "layout_id", "layout_content", "is_top", "is_bottom", "dbg_msg", "final_score", "ml_formula", "sub_result_items", "result_item_type", "seporator_type", "report_ext_data", "is_multi_pic", "layout_name" }, new Object[] { localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, localByteStringMicro5, localByteStringMicro6, null, Long.valueOf(0L), null, Integer.valueOf(0), localByteStringMicro7, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro8, Float.valueOf(0.0F), localByteStringMicro9, null, Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro10, Integer.valueOf(0), localByteStringMicro11 }, ResultItem.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     pb.unify.search.UnifySearchCommon.ResultItem
 * JD-Core Version:    0.7.0.1
 */