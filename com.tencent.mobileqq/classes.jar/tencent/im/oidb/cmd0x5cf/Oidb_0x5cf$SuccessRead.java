package tencent.im.oidb.cmd0x5cf;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class Oidb_0x5cf$SuccessRead
  extends MessageMicro<SuccessRead>
{
  public static final int FIXED32_SEQUENCE_FIELD_NUMBER = 1;
  public static final int RPT_MSG_ALL_FIELD_NUMBER = 7;
  public static final int RPT_MSG_DECIDED_FIELD_NUMBER = 5;
  public static final int RPT_MSG_UNDECIDE_FIELD_NUMBER = 4;
  public static final int RPT_UINT64_UNREAD_UNDECIDE_UIN_FIELD_NUMBER = 12;
  public static final int UINT32_FIRST_UPDATE_FIELD_NUMBER = 10;
  public static final int UINT32_OVER_FIELD_NUMBER = 2;
  public static final int UINT32_TOTLE_FIELD_NUMBER = 3;
  public static final int UINT32_UNREAD_UNDECIDE_NUM_FIELD_NUMBER = 11;
  public static final int UINT32_UN_READ_COUNT2_FIELD_NUMBER = 9;
  public static final int UINT32_UN_READ_COUNT_FIELD_NUMBER = 6;
  public static final int UINT64_UPDATETIME_FIELD_NUMBER = 8;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 13, 16, 24, 34, 42, 48, 58, 64, 72, 80, 88, 96 }, new String[] { "fixed32_sequence", "uint32_over", "uint32_totle", "rpt_msg_undecide", "rpt_msg_decided", "uint32_un_read_count", "rpt_msg_all", "uint64_updatetime", "uint32_un_read_count2", "uint32_first_update", "uint32_unread_undecide_num", "rpt_uint64_unread_undecide_uin" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, null, Integer.valueOf(0), null, Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L) }, SuccessRead.class);
  public final PBFixed32Field fixed32_sequence = PBField.initFixed32(0);
  public final PBRepeatMessageField<Oidb_0x5cf.All> rpt_msg_all = PBField.initRepeatMessage(Oidb_0x5cf.All.class);
  public final PBRepeatMessageField<Oidb_0x5cf.Decided> rpt_msg_decided = PBField.initRepeatMessage(Oidb_0x5cf.Decided.class);
  public final PBRepeatMessageField<Oidb_0x5cf.UnDecide> rpt_msg_undecide = PBField.initRepeatMessage(Oidb_0x5cf.UnDecide.class);
  public final PBRepeatField<Long> rpt_uint64_unread_undecide_uin = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  public final PBUInt32Field uint32_first_update = PBField.initUInt32(0);
  public final PBUInt32Field uint32_over = PBField.initUInt32(0);
  public final PBUInt32Field uint32_totle = PBField.initUInt32(0);
  public final PBUInt32Field uint32_un_read_count = PBField.initUInt32(0);
  public final PBUInt32Field uint32_un_read_count2 = PBField.initUInt32(0);
  public final PBUInt32Field uint32_unread_undecide_num = PBField.initUInt32(0);
  public final PBUInt64Field uint64_updatetime = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0x5cf.Oidb_0x5cf.SuccessRead
 * JD-Core Version:    0.7.0.1
 */