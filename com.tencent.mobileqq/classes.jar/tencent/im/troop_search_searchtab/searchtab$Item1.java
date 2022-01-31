package tencent.im.troop_search_searchtab;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.group.group_label.GroupLabel.Label;

public final class searchtab$Item1
  extends MessageMicro
{
  public static final int BYTES_GROUP_FINGER_MEMO_FIELD_NUMBER = 10;
  public static final int RPT_MSG_GROUP_LABEL_FIELD_NUMBER = 9;
  public static final int STR_IMG_URL_FIELD_NUMBER = 3;
  public static final int STR_LOC_FIELD_NUMBER = 4;
  public static final int STR_NAME_FIELD_NUMBER = 2;
  public static final int STR_OPER_DESC_FIELD_NUMBER = 6;
  public static final int STR_OPER_TRANSFER_URL_FIELD_NUMBER = 7;
  public static final int STR_TRANSFER_URL_FIELD_NUMBER = 8;
  public static final int UINT32_MEM_CNT_FIELD_NUMBER = 5;
  public static final int UINT64_GROUP_CODE_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_group_finger_memo = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatMessageField rpt_msg_group_label = PBField.initRepeatMessage(GroupLabel.Label.class);
  public final PBStringField str_img_url = PBField.initString("");
  public final PBStringField str_loc = PBField.initString("");
  public final PBStringField str_name = PBField.initString("");
  public final PBStringField str_oper_desc = PBField.initString("");
  public final PBStringField str_oper_transfer_url = PBField.initString("");
  public final PBStringField str_transfer_url = PBField.initString("");
  public final PBUInt32Field uint32_mem_cnt = PBField.initUInt32(0);
  public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 40, 50, 58, 66, 74, 82 }, new String[] { "uint64_group_code", "str_name", "str_img_url", "str_loc", "uint32_mem_cnt", "str_oper_desc", "str_oper_transfer_url", "str_transfer_url", "rpt_msg_group_label", "bytes_group_finger_memo" }, new Object[] { Long.valueOf(0L), "", "", "", Integer.valueOf(0), "", "", "", null, localByteStringMicro }, Item1.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.troop_search_searchtab.searchtab.Item1
 * JD-Core Version:    0.7.0.1
 */