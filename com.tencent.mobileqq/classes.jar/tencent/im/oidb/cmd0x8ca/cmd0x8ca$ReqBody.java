package tencent.im.oidb.cmd0x8ca;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0x8ca$ReqBody
  extends MessageMicro<ReqBody>
{
  public static final int OPT_BYTES_GROUP_SIG_FIELD_NUMBER = 3;
  public static final int OPT_INT32_OPR_NUM_ALBUM_FIELD_NUMBER = 11;
  public static final int OPT_INT32_OPR_NUM_FIELD_NUMBER = 5;
  public static final int OPT_MSG_APP_TIP_NOTIFY_FIELD_NUMBER = 10;
  public static final int OPT_MSG_APP_UIN_FIELD_NUMBER = 12;
  public static final int OPT_UINT32_GA_OWNER_FIELD_NUMBER = 8;
  public static final int OPT_UINT32_SUB_CMD_FIELD_NUMBER = 1;
  public static final int OPT_UINT64_APPID_FIELD_NUMBER = 6;
  public static final int OPT_UINT64_FROM_UIN_FIELD_NUMBER = 2;
  public static final int OPT_UINT64_GA_CODE_FIELD_NUMBER = 9;
  public static final int OPT_UINT64_GROUP_CODE_FIELD_NUMBER = 4;
  public static final int RPT_UINT64_OPR_UIN_FIELD_NUMBER = 7;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField opt_bytes_group_sig = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBInt32Field opt_int32_opr_num = PBField.initInt32(0);
  public final PBInt32Field opt_int32_opr_num_album = PBField.initInt32(0);
  public cmd0x8ca.AppTipNotify opt_msg_app_tip_notify = new cmd0x8ca.AppTipNotify();
  public cmd0x8ca.AppUinSpecial opt_msg_app_uin = new cmd0x8ca.AppUinSpecial();
  public final PBUInt32Field opt_uint32_ga_owner = PBField.initUInt32(0);
  public final PBUInt64Field opt_uint32_sub_cmd = PBField.initUInt64(0L);
  public final PBUInt64Field opt_uint64_appid = PBField.initUInt64(0L);
  public final PBUInt64Field opt_uint64_from_uin = PBField.initUInt64(0L);
  public final PBUInt64Field opt_uint64_ga_code = PBField.initUInt64(0L);
  public final PBUInt64Field opt_uint64_group_code = PBField.initUInt64(0L);
  public final PBRepeatField<Long> rpt_uint64_opr_uin = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 40, 48, 56, 64, 72, 82, 88, 98 }, new String[] { "opt_uint32_sub_cmd", "opt_uint64_from_uin", "opt_bytes_group_sig", "opt_uint64_group_code", "opt_int32_opr_num", "opt_uint64_appid", "rpt_uint64_opr_uin", "opt_uint32_ga_owner", "opt_uint64_ga_code", "opt_msg_app_tip_notify", "opt_int32_opr_num_album", "opt_msg_app_uin" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), localByteStringMicro, Long.valueOf(0L), Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Long.valueOf(0L), null, Integer.valueOf(0), null }, ReqBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0x8ca.cmd0x8ca.ReqBody
 * JD-Core Version:    0.7.0.1
 */