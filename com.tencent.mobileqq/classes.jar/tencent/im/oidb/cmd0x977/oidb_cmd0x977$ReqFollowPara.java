package tencent.im.oidb.cmd0x977;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0x977$ReqFollowPara
  extends MessageMicro<ReqFollowPara>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBEnumField op_type = PBField.initEnum(1);
  public final PBRepeatField<Long> rpt_subscribe_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  public final PBRepeatField<Long> rpt_uin_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  public final PBEnumField uint32_follow_list_type = PBField.initEnum(1);
  public final PBUInt32Field uint32_need_kd_user_info = PBField.initUInt32(0);
  public final PBUInt32Field uint32_no_check_friends = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_count = PBField.initUInt32(0);
  public final PBUInt64Field uint64_dst_uin = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 80, 90, 96, 104, 112, 120, 128, 136 }, new String[] { "op_type", "uint32_req_count", "bytes_cookie", "uint64_dst_uin", "uint32_follow_list_type", "rpt_uin_list", "rpt_subscribe_list", "uint32_need_kd_user_info", "uint32_no_check_friends" }, new Object[] { Integer.valueOf(1), Integer.valueOf(0), localByteStringMicro, Long.valueOf(0L), Integer.valueOf(1), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0) }, ReqFollowPara.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0x977.oidb_cmd0x977.ReqFollowPara
 * JD-Core Version:    0.7.0.1
 */