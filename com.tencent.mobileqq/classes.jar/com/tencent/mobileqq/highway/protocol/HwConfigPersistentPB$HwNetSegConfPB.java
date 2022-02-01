package com.tencent.mobileqq.highway.protocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;

public final class HwConfigPersistentPB$HwNetSegConfPB
  extends MessageMicro<HwNetSegConfPB>
{
  public static final int INT64_CUR_CONN_NUM_FIELD_NUMBER = 4;
  public static final int INT64_NET_TYPE_FIELD_NUMBER = 1;
  public static final int INT64_SEG_NUM_FIELD_NUMBER = 3;
  public static final int INT64_SEG_SIZE_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt64Field int64_cur_conn_num = PBField.initInt64(0L);
  public final PBInt64Field int64_net_type = PBField.initInt64(0L);
  public final PBInt64Field int64_seg_num = PBField.initInt64(0L);
  public final PBInt64Field int64_seg_size = PBField.initInt64(0L);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "int64_net_type", "int64_seg_size", "int64_seg_num", "int64_cur_conn_num" }, new Object[] { localLong, localLong, localLong, localLong }, HwNetSegConfPB.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.highway.protocol.HwConfigPersistentPB.HwNetSegConfPB
 * JD-Core Version:    0.7.0.1
 */