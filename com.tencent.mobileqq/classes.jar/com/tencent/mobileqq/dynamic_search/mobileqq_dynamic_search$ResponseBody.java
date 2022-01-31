package com.tencent.mobileqq.dynamic_search;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class mobileqq_dynamic_search$ResponseBody
  extends MessageMicro<ResponseBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field cmd = PBField.initUInt32(0);
  public final PBUInt32Field hotwords_cache_timeout = PBField.initUInt32(0);
  public final PBRepeatMessageField<mobileqq_dynamic_search.ResultItemGroup> item_groups = PBField.initRepeatMessage(mobileqq_dynamic_search.ResultItemGroup.class);
  public mobileqq_dynamic_search.JumpInfo jump_info = new mobileqq_dynamic_search.JumpInfo();
  public final PBBytesField key_word = PBField.initBytes(ByteStringMicro.EMPTY);
  public mobileqq_dynamic_search.MoreWordInfo more_word_info = new mobileqq_dynamic_search.MoreWordInfo();
  public final PBInt32Field retcode = PBField.initInt32(0);
  public final PBUInt64Field search_id = PBField.initUInt64(0L);
  public final PBBytesField search_ver = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatMessageField<mobileqq_dynamic_search.TabItemGroup> tab_groups = PBField.initRepeatMessage(mobileqq_dynamic_search.TabItemGroup.class);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 40, 48, 58, 66, 74, 82, 802 }, new String[] { "cmd", "retcode", "key_word", "item_groups", "search_id", "hotwords_cache_timeout", "more_word_info", "tab_groups", "jump_info", "bytes_cookie", "search_ver" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro1, null, Long.valueOf(0L), Integer.valueOf(0), null, null, null, localByteStringMicro2, localByteStringMicro3 }, ResponseBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.dynamic_search.mobileqq_dynamic_search.ResponseBody
 * JD-Core Version:    0.7.0.1
 */