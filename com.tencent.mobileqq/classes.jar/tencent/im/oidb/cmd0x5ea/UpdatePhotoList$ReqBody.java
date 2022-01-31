package tencent.im.oidb.cmd0x5ea;

import appoint.define.appoint_define.LBSInfo;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class UpdatePhotoList$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34, 42, 50 }, new String[] { "rpt_uint32_headids", "str_upload_url", "uint32_copy_count_from_qzone", "msg_lbs_info", "rpt_msg_rich_headids", "msg_verify_video_info" }, new Object[] { Integer.valueOf(0), "", Integer.valueOf(0), null, null, null }, ReqBody.class);
  public appoint_define.LBSInfo msg_lbs_info = new appoint_define.LBSInfo();
  public UpdatePhotoList.RichHead msg_verify_video_info = new UpdatePhotoList.RichHead();
  public final PBRepeatMessageField<UpdatePhotoList.RichHead> rpt_msg_rich_headids = PBField.initRepeatMessage(UpdatePhotoList.RichHead.class);
  public final PBRepeatField<Integer> rpt_uint32_headids = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  public final PBStringField str_upload_url = PBField.initString("");
  public final PBUInt32Field uint32_copy_count_from_qzone = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0x5ea.UpdatePhotoList.ReqBody
 * JD-Core Version:    0.7.0.1
 */