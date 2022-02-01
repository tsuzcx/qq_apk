package tencent.im.oidb.search;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class DynamicTabSearch$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField cookie = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field dont_need_merge = PBField.initUInt32(0);
  public final PBStringField error_msg = PBField.initString("");
  public final PBBytesField extension = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatMessageField<DynamicTabSearch.SubHotWord> hot_words = PBField.initRepeatMessage(DynamicTabSearch.SubHotWord.class);
  public final PBUInt32Field is_end = PBField.initUInt32(0);
  public final PBRepeatMessageField<DynamicSearch.ResultItemGroup> item_groups = PBField.initRepeatMessage(DynamicSearch.ResultItemGroup.class);
  public final PBUInt32Field result_code = PBField.initUInt32(0);
  public final PBBytesField search_ver = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField sub_hot_top_wording = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 42, 50, 58, 66, 72, 810 }, new String[] { "result_code", "error_msg", "item_groups", "is_end", "cookie", "search_ver", "hot_words", "sub_hot_top_wording", "dont_need_merge", "extension" }, new Object[] { localInteger, "", null, localInteger, localByteStringMicro1, localByteStringMicro2, null, localByteStringMicro3, localInteger, localByteStringMicro4 }, RspBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.search.DynamicTabSearch.RspBody
 * JD-Core Version:    0.7.0.1
 */