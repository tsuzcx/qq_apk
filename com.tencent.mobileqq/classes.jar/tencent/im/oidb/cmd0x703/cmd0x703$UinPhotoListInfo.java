package tencent.im.oidb.cmd0x703;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0x703$UinPhotoListInfo
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 34, 80, 90 }, new String[] { "uint64_uin", "uint32_timestamp", "rpt_msg_photo_info", "rpt_selected_id_list", "str_default_photo" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), null, Integer.valueOf(0), "" }, UinPhotoListInfo.class);
  public final PBRepeatMessageField rpt_msg_photo_info = PBField.initRepeatMessage(cmd0x703.PhotoInfo.class);
  public final PBRepeatField rpt_selected_id_list = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  public final PBStringField str_default_photo = PBField.initString("");
  public final PBUInt32Field uint32_timestamp = PBField.initUInt32(0);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x703.cmd0x703.UinPhotoListInfo
 * JD-Core Version:    0.7.0.1
 */