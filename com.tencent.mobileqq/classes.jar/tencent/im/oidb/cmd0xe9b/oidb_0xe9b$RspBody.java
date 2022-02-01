package tencent.im.oidb.cmd0xe9b;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0xe9b$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public oidb_0xe9b.BasicProfileData msg_basic_profile = new oidb_0xe9b.BasicProfileData();
  public oidb_0xe9b.QZoneInfo msg_qzone_info = new oidb_0xe9b.QZoneInfo();
  public final PBRepeatField<ByteStringMicro> rpt_bytes_longnick = PBField.initRepeat(PBBytesField.__repeatHelper__);
  public final PBRepeatMessageField<oidb_0xe9b.LabelInfo> rpt_msg_label = PBField.initRepeatMessage(oidb_0xe9b.LabelInfo.class);
  public final PBRepeatMessageField<oidb_0xe9b.Quest> rpt_msg_quests = PBField.initRepeatMessage(oidb_0xe9b.Quest.class);
  public final PBRepeatMessageField<oidb_0xe9b.SelectedPicInfo> rpt_msg_selected_pic = PBField.initRepeatMessage(oidb_0xe9b.SelectedPicInfo.class);
  public final PBUInt64Field uint64_next_req_interval = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 50, 58 }, new String[] { "uint64_next_req_interval", "msg_basic_profile", "rpt_msg_label", "msg_qzone_info", "rpt_msg_selected_pic", "rpt_bytes_longnick", "rpt_msg_quests" }, new Object[] { Long.valueOf(0L), null, null, null, null, localByteStringMicro, null }, RspBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0xe9b.oidb_0xe9b.RspBody
 * JD-Core Version:    0.7.0.1
 */