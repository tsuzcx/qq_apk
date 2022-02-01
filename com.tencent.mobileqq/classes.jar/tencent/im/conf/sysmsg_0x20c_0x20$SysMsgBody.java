package tencent.im.conf;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class sysmsg_0x20c_0x20$SysMsgBody
  extends MessageMicro<SysMsgBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34 }, new String[] { "u32_cmd", "msg_convert_to_group", "msg_mem_num_remind", "msg_upload_file_remind" }, new Object[] { Integer.valueOf(0), null, null, null }, SysMsgBody.class);
  public sysmsg_0x20c_0x20.Convert2Group msg_convert_to_group = new sysmsg_0x20c_0x20.Convert2Group();
  public sysmsg_0x20c_0x20.MemberNumRemind msg_mem_num_remind = new sysmsg_0x20c_0x20.MemberNumRemind();
  public sysmsg_0x20c_0x20.UploadFileRemind msg_upload_file_remind = new sysmsg_0x20c_0x20.UploadFileRemind();
  public final PBUInt32Field u32_cmd = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.conf.sysmsg_0x20c_0x20.SysMsgBody
 * JD-Core Version:    0.7.0.1
 */