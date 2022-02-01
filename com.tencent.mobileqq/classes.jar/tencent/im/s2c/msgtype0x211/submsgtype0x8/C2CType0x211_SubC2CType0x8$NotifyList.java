package tencent.im.s2c.msgtype0x211.submsgtype0x8;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class C2CType0x211_SubC2CType0x8$NotifyList
  extends MessageMicro<NotifyList>
{
  public static final int NOTIFY_TYPE_FIELD_NUMBER = 1;
  public static final int RPT_MSG_UPDATE_LIST_FIELD_NUMBER = 2;
  public static final int UINT32_SESSION_ID_FIELD_NUMBER = 3;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBEnumField notify_type = PBField.initEnum(0);
  public final PBRepeatMessageField<C2CType0x211_SubC2CType0x8.UpdateInfo> rpt_msg_update_list = PBField.initRepeatMessage(C2CType0x211_SubC2CType0x8.UpdateInfo.class);
  public final PBUInt32Field uint32_session_id = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "notify_type", "rpt_msg_update_list", "uint32_session_id" }, new Object[] { localInteger, null, localInteger }, NotifyList.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x211.submsgtype0x8.C2CType0x211_SubC2CType0x8.NotifyList
 * JD-Core Version:    0.7.0.1
 */