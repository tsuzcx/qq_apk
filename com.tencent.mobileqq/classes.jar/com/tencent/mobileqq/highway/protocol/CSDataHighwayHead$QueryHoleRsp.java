package com.tencent.mobileqq.highway.protocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class CSDataHighwayHead$QueryHoleRsp
  extends MessageMicro<QueryHoleRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "uint32_result", "rpt_data_hole", "bool_comp_flag" }, new Object[] { Integer.valueOf(0), null, Boolean.valueOf(false) }, QueryHoleRsp.class);
  public final PBBoolField bool_comp_flag = PBField.initBool(false);
  public final PBRepeatMessageField<CSDataHighwayHead.DataHole> rpt_data_hole = PBField.initRepeatMessage(CSDataHighwayHead.DataHole.class);
  public final PBUInt32Field uint32_result = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.highway.protocol.CSDataHighwayHead.QueryHoleRsp
 * JD-Core Version:    0.7.0.1
 */