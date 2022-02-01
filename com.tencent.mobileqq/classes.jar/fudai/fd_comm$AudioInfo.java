package fudai;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class fd_comm$AudioInfo
  extends MessageMicro<AudioInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "cover_info", "audio_url" }, new Object[] { null, "" }, AudioInfo.class);
  public final PBStringField audio_url = PBField.initString("");
  public fd_comm.PicInfo cover_info = new fd_comm.PicInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     fudai.fd_comm.AudioInfo
 * JD-Core Version:    0.7.0.1
 */