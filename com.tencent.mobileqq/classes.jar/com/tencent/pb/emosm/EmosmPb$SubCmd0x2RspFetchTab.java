package com.tencent.pb.emosm;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class EmosmPb$SubCmd0x2RspFetchTab
  extends MessageMicro<SubCmd0x2RspFetchTab>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBFixed32Field fixed32_timestamp = PBField.initFixed32(0);
  public final PBInt32Field int32_segment_flag = PBField.initInt32(0);
  public final PBRepeatMessageField<EmosmPb.SubCmd0x2RspFetchTab.TabInfo> rpt_magic_tabinfo = PBField.initRepeatMessage(EmosmPb.SubCmd0x2RspFetchTab.TabInfo.class);
  public final PBRepeatMessageField<EmosmPb.SubCmd0x2RspFetchTab.TabInfo> rpt_msg_tabinfo = PBField.initRepeatMessage(EmosmPb.SubCmd0x2RspFetchTab.TabInfo.class);
  public final PBRepeatMessageField<EmosmPb.SubCmd0x2RspFetchTab.TabInfo> rpt_smallbq_tabinfo = PBField.initRepeatMessage(EmosmPb.SubCmd0x2RspFetchTab.TabInfo.class);
  public final PBRepeatField<Integer> uint32_tab_id = PBField.initRepeat(PBInt32Field.__repeatHelper__);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 13, 16, 26, 34, 42, 48 }, new String[] { "fixed32_timestamp", "int32_segment_flag", "rpt_msg_tabinfo", "rpt_magic_tabinfo", "rpt_smallbq_tabinfo", "uint32_tab_id" }, new Object[] { localInteger, localInteger, null, null, null, localInteger }, SubCmd0x2RspFetchTab.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.pb.emosm.EmosmPb.SubCmd0x2RspFetchTab
 * JD-Core Version:    0.7.0.1
 */