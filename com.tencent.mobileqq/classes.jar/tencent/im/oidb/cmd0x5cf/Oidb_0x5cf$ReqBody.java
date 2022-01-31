package tencent.im.oidb.cmd0x5cf;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class Oidb_0x5cf$ReqBody
  extends MessageMicro<ReqBody>
{
  public static final int FIXED32_SEQUENCE_FIELD_NUMBER = 2;
  public static final int MSG_CLR_MSG_INFO_FIELD_NUMBER = 16;
  public static final int MSG_DEL_MSG_INFO_FIELD_NUMBER = 15;
  public static final int STR_RESERVE_FIELD_NUMBER = 7;
  public static final int UINT32_CLEARTIME_FIELD_NUMBER = 10;
  public static final int UINT32_GETFLAG_FIELD_NUMBER = 8;
  public static final int UINT32_NEED_COMM_FRIEND_FIELD_NUMBER = 12;
  public static final int UINT32_NEED_GROUP_UIN_FIELD_NUMBER = 14;
  public static final int UINT32_NEED_UNREAD_NOAGREE_COUNT_FIELD_NUMBER = 13;
  public static final int UINT32_NEED_UNREAD_UNDECIDE_NUM_FIELD_NUMBER = 11;
  public static final int UINT32_REQNUM_FIELD_NUMBER = 6;
  public static final int UINT32_STARTINDEX_FIELD_NUMBER = 5;
  public static final int UINT32_STARTTIME_FIELD_NUMBER = 9;
  public static final int UINT32_TYPE_FIELD_NUMBER = 3;
  public static final int UINT32_VERSION_FIELD_NUMBER = 1;
  public static final int UINT64_TOUIN_FIELD_NUMBER = 4;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 21, 24, 32, 40, 48, 58, 64, 72, 80, 88, 96, 104, 112, 122, 130 }, new String[] { "uint32_version", "fixed32_sequence", "uint32_type", "uint64_touin", "uint32_startindex", "uint32_reqnum", "str_reserve", "uint32_getFlag", "uint32_starttime", "uint32_cleartime", "uint32_need_unread_undecide_num", "uint32_need_comm_friend", "uint32_need_unread_noagree_count", "uint32_need_group_uin", "msg_del_msg_info", "msg_clr_msg_info" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, null }, ReqBody.class);
  public final PBFixed32Field fixed32_sequence = PBField.initFixed32(0);
  public Oidb_0x5cf.ClrMsgInfo msg_clr_msg_info = new Oidb_0x5cf.ClrMsgInfo();
  public Oidb_0x5cf.DelMsgInfo msg_del_msg_info = new Oidb_0x5cf.DelMsgInfo();
  public final PBStringField str_reserve = PBField.initString("");
  public final PBUInt32Field uint32_cleartime = PBField.initUInt32(0);
  public final PBUInt32Field uint32_getFlag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_need_comm_friend = PBField.initUInt32(0);
  public final PBUInt32Field uint32_need_group_uin = PBField.initUInt32(0);
  public final PBUInt32Field uint32_need_unread_noagree_count = PBField.initUInt32(0);
  public final PBUInt32Field uint32_need_unread_undecide_num = PBField.initUInt32(0);
  public final PBUInt32Field uint32_reqnum = PBField.initUInt32(0);
  public final PBUInt32Field uint32_startindex = PBField.initUInt32(0);
  public final PBUInt32Field uint32_starttime = PBField.initUInt32(0);
  public final PBUInt32Field uint32_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_version = PBField.initUInt32(0);
  public final PBUInt64Field uint64_touin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0x5cf.Oidb_0x5cf.ReqBody
 * JD-Core Version:    0.7.0.1
 */