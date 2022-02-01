package fudai;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class fd_comm$BusiElement
  extends MessageMicro<BusiElement>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 42, 50, 58, 66 }, new String[] { "busi_id", "biz_desc", "biz_logo", "ad_type", "pic_info", "video_info", "audio_info", "official_account_info" }, new Object[] { Integer.valueOf(0), "", "", Integer.valueOf(1), null, null, null, null }, BusiElement.class);
  public final PBEnumField ad_type = PBField.initEnum(1);
  public fd_comm.AudioInfo audio_info = new fd_comm.AudioInfo();
  public final PBStringField biz_desc = PBField.initString("");
  public final PBStringField biz_logo = PBField.initString("");
  public final PBUInt32Field busi_id = PBField.initUInt32(0);
  public fd_comm.OfficialAccountInfo official_account_info = new fd_comm.OfficialAccountInfo();
  public fd_comm.PicInfo pic_info = new fd_comm.PicInfo();
  public fd_comm.VideoInfo video_info = new fd_comm.VideoInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     fudai.fd_comm.BusiElement
 * JD-Core Version:    0.7.0.1
 */