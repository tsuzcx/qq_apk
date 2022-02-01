package tencent.im.oidb.cmd0x7df;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x7df$ReqBody
  extends MessageMicro<ReqBody>
{
  public static final int RPT_UINT64_UINLIST_FIELD_NUMBER = 4;
  public static final int UINT32_NICK_FIELD_NUMBER = 6;
  public static final int UINT32_REQ_NUM_FIELD_NUMBER = 3;
  public static final int UINT32_SEQ_FIELD_NUMBER = 1;
  public static final int UINT32_SORT_FIELD_NUMBER = 5;
  public static final int UINT32_START_INDEX_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48 }, new String[] { "uint32_seq", "uint32_start_index", "uint32_req_num", "rpt_uint64_uinlist", "uint32_sort", "uint32_nick" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0) }, ReqBody.class);
  public final PBRepeatField<Long> rpt_uint64_uinlist = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  public final PBUInt32Field uint32_nick = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_num = PBField.initUInt32(0);
  public final PBUInt32Field uint32_seq = PBField.initUInt32(0);
  public final PBUInt32Field uint32_sort = PBField.initUInt32(0);
  public final PBUInt32Field uint32_start_index = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0x7df.oidb_0x7df.ReqBody
 * JD-Core Version:    0.7.0.1
 */