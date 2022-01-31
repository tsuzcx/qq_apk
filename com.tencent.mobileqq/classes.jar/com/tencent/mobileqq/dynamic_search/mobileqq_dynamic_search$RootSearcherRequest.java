package com.tencent.mobileqq.dynamic_search;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class mobileqq_dynamic_search$RootSearcherRequest
  extends MessageMicro<RootSearcherRequest>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 58 }, new String[] { "ver", "business", "start_index", "page_size", "busi_mask", "req_ctrl_type", "plugin_state" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(3), Long.valueOf(-1L), Integer.valueOf(0), null }, RootSearcherRequest.class);
  public final PBInt64Field busi_mask = PBField.initInt64(-1L);
  public final PBEnumField business = PBField.initEnum(0);
  public final PBInt32Field page_size = PBField.initInt32(3);
  public final PBRepeatMessageField<mobileqq_dynamic_search.PluginState> plugin_state = PBField.initRepeatMessage(mobileqq_dynamic_search.PluginState.class);
  public final PBEnumField req_ctrl_type = PBField.initEnum(0);
  public final PBInt32Field start_index = PBField.initInt32(0);
  public final PBUInt32Field ver = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dynamic_search.mobileqq_dynamic_search.RootSearcherRequest
 * JD-Core Version:    0.7.0.1
 */