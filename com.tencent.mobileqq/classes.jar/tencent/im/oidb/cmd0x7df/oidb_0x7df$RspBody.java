package tencent.im.oidb.cmd0x7df;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0x7df$RspBody
  extends MessageMicro
{
  public static final int RPT_MSG_FRIEND_SCORE_FIELD_NUMBER = 4;
  public static final int UINT32_LOW_SCORE_FIELD_NUMBER = 6;
  public static final int UINT32_NEXT_START_FIELD_NUMBER = 3;
  public static final int UINT32_OVER_FIELD_NUMBER = 2;
  public static final int UINT32_SEQ_FIELD_NUMBER = 1;
  public static final int UINT32_TOTAL_FIELD_NUMBER = 5;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 40, 48 }, new String[] { "uint32_seq", "uint32_over", "uint32_next_start", "rpt_msg_friend_score", "uint32_total", "uint32_low_score" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(0), Integer.valueOf(0) }, RspBody.class);
  public final PBRepeatMessageField rpt_msg_friend_score = PBField.initRepeatMessage(oidb_0x7df.FriendScore.class);
  public final PBUInt32Field uint32_low_score = PBField.initUInt32(0);
  public final PBUInt32Field uint32_next_start = PBField.initUInt32(0);
  public final PBUInt32Field uint32_over = PBField.initUInt32(0);
  public final PBUInt32Field uint32_seq = PBField.initUInt32(0);
  public final PBUInt32Field uint32_total = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x7df.oidb_0x7df.RspBody
 * JD-Core Version:    0.7.0.1
 */