package tencent.im.groupvideo.s2c;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class gv_pstn_bill$S2CNotifyBillReq
  extends MessageMicro<S2CNotifyBillReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField str_bill_detail = PBField.initString("");
  public final PBStringField str_bill_msg = PBField.initString("");
  public final PBUInt32Field uint32_authmode = PBField.initUInt32(0);
  public final PBUInt32Field uint32_busstype = PBField.initUInt32(0);
  public final PBUInt64Field uint32_close_time = PBField.initUInt64(0L);
  public final PBUInt32Field uint32_create_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_groupcode = PBField.initUInt32(0);
  public final PBUInt32Field uint32_room_num = PBField.initUInt32(0);
  public final PBUInt32Field uint32_seq = PBField.initUInt32(0);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56, 64, 90, 98 }, new String[] { "uint32_seq", "uint32_busstype", "uint32_authmode", "uint32_groupcode", "uint64_uin", "uint32_room_num", "uint32_create_time", "uint32_close_time", "str_bill_msg", "str_bill_detail" }, new Object[] { localInteger, localInteger, localInteger, localInteger, localLong, localInteger, localInteger, localLong, "", "" }, S2CNotifyBillReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.groupvideo.s2c.gv_pstn_bill.S2CNotifyBillReq
 * JD-Core Version:    0.7.0.1
 */