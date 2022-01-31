package fudai;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class fd_comm$VideoInfo
  extends MessageMicro<VideoInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "cover_info", "video_url" }, new Object[] { null, "" }, VideoInfo.class);
  public fd_comm.PicInfo cover_info = new fd_comm.PicInfo();
  public final PBStringField video_url = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     fudai.fd_comm.VideoInfo
 * JD-Core Version:    0.7.0.1
 */