package tencent.im.oidb.cmd0x78f;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x78f$ReqBody
  extends MessageMicro
{
  public static final int ELEM_TYPE_LIST_FIELD_NUMBER = 14;
  public static final int GROUP_CODE_FIELD_NUMBER = 1;
  public static final int KEYWORD_LIST_FIELD_NUMBER = 2;
  public static final int MSG_LEN_MAX_FIELD_NUMBER = 9;
  public static final int MSG_LEN_MIN_FIELD_NUMBER = 8;
  public static final int MSG_SEQ_BEGIN_FIELD_NUMBER = 12;
  public static final int MSG_SEQ_END_FIELD_NUMBER = 13;
  public static final int NUM_PER_PAGE_FIELD_NUMBER = 3;
  public static final int PAGE_ID_FIELD_NUMBER = 4;
  public static final int RANK_TYPE_FIELD_NUMBER = 5;
  public static final int TIME_BEGIN_FIELD_NUMBER = 10;
  public static final int TIME_END_FIELD_NUMBER = 11;
  public static final int UIN_BLACK_LIST_FIELD_NUMBER = 7;
  public static final int UIN_WHITE_LIST_FIELD_NUMBER = 6;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 40, 48, 56, 64, 72, 80, 88, 96, 104, 112 }, new String[] { "group_code", "keyword_list", "num_per_page", "page_id", "rank_type", "uin_white_list", "uin_black_list", "msg_len_min", "msg_len_max", "time_begin", "time_end", "msg_seq_begin", "msg_seq_end", "elem_type_list" }, new Object[] { Long.valueOf(0L), "", Integer.valueOf(20), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(-1), Integer.valueOf(-1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, ReqBody.class);
  public static final ReqBody __repeatHelper__ = new ReqBody();
  public final PBRepeatField elem_type_list = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  public final PBUInt64Field group_code = PBField.initUInt64(0L);
  public final PBRepeatField keyword_list = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBInt32Field msg_len_max = PBField.initInt32(-1);
  public final PBInt32Field msg_len_min = PBField.initInt32(-1);
  public final PBUInt32Field msg_seq_begin = PBField.initUInt32(0);
  public final PBUInt32Field msg_seq_end = PBField.initUInt32(0);
  public final PBUInt32Field num_per_page = PBField.initUInt32(20);
  public final PBUInt32Field page_id = PBField.initUInt32(0);
  public final PBInt32Field rank_type = PBField.initInt32(0);
  public final PBInt32Field time_begin = PBField.initInt32(0);
  public final PBInt32Field time_end = PBField.initInt32(0);
  public final PBRepeatField uin_black_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  public final PBRepeatField uin_white_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x78f.oidb_0x78f.ReqBody
 * JD-Core Version:    0.7.0.1
 */