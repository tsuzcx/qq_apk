package com.tencent.qidian.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class mobileqq_qidian$GetNavigationMenuConfigRspBody
  extends MessageMicro<GetNavigationMenuConfigRspBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt32Field int32_is_show = PBField.initInt32(0);
  public mobileqq_qidian.RetInfo msg_ret = new mobileqq_qidian.RetInfo();
  public final PBUInt32Field uint32_is_show_graytip = PBField.initUInt32(0);
  public final PBUInt32Field uint32_ver_no = PBField.initUInt32(0);
  public final PBUInt64Field uint64_kf_uin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_puin = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 40, 48 }, new String[] { "msg_ret", "int32_is_show", "uint32_ver_no", "uint64_puin", "uint64_kf_uin", "uint32_is_show_graytip" }, new Object[] { null, localInteger, localInteger, localLong, localLong, localInteger }, GetNavigationMenuConfigRspBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qidian.proto.mobileqq_qidian.GetNavigationMenuConfigRspBody
 * JD-Core Version:    0.7.0.1
 */