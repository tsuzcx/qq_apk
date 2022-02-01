package tencent.im.oidb.cmd0x858;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.apollo_game_status.STCMGameMessage;
import tencent.im.apollo_push_msgInfo.STPushMsgElem;

public final class oidb_0x858$NotifyMsgBody
  extends MessageMicro<NotifyMsgBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public apollo_push_msgInfo.STPushMsgElem apllo_msg_push = new apollo_push_msgInfo.STPushMsgElem();
  public final PBEnumField opt_enum_type = PBField.initEnum(5);
  public oidb_0x858.GoldMsgTipsElem opt_msg_goldtips = new oidb_0x858.GoldMsgTipsElem();
  public oidb_0x858.NotifyObjmsgUpdate opt_msg_obj_update = new oidb_0x858.NotifyObjmsgUpdate();
  public oidb_0x858.MessageRecallReminder opt_msg_recall_reminder = new oidb_0x858.MessageRecallReminder();
  public oidb_0x858.RedGrayTipsInfo opt_msg_redtips = new oidb_0x858.RedGrayTipsInfo();
  public apollo_game_status.STCMGameMessage opt_stcm_game_state = new apollo_game_status.STCMGameMessage();
  public final PBUInt64Field opt_uint64_conf_uin = PBField.initUInt64(0L);
  public final PBUInt64Field opt_uint64_msg_expires = PBField.initUInt64(0L);
  public final PBUInt64Field opt_uint64_msg_time = PBField.initUInt64(0L);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42, 50, 58, 66, 74, 82 }, new String[] { "opt_enum_type", "opt_uint64_msg_time", "opt_uint64_msg_expires", "opt_uint64_conf_uin", "opt_msg_redtips", "opt_msg_recall_reminder", "opt_msg_obj_update", "opt_stcm_game_state", "apllo_msg_push", "opt_msg_goldtips" }, new Object[] { Integer.valueOf(5), localLong, localLong, localLong, null, null, null, null, null, null }, NotifyMsgBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0x858.oidb_0x858.NotifyMsgBody
 * JD-Core Version:    0.7.0.1
 */