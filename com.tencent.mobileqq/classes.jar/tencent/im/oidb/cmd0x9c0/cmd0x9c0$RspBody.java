package tencent.im.oidb.cmd0x9c0;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0x9c0$RspBody
  extends MessageMicro<RspBody>
{
  public static final int RPT_NEARBY_USER_LIST_FIELD_NUMBER = 2;
  public static final int UINT32_HEARTBEAT_INTERVAL_FIELD_NUMBER = 4;
  public static final int UINT32_REQ_INTERVAL_FIELD_NUMBER = 3;
  public static final int UINT64_UIN_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBRepeatMessageField<cmd0x9c0.NearbyUser> rpt_nearby_user_list = PBField.initRepeatMessage(cmd0x9c0.NearbyUser.class);
  public final PBUInt32Field uint32_heartbeat_interval = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_interval = PBField.initUInt32(0);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32 }, new String[] { "uint64_uin", "rpt_nearby_user_list", "uint32_req_interval", "uint32_heartbeat_interval" }, new Object[] { Long.valueOf(0L), null, localInteger, localInteger }, RspBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0x9c0.cmd0x9c0.RspBody
 * JD-Core Version:    0.7.0.1
 */