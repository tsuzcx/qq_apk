package tencent.im.oidb.cmd0xe2a;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class oidb_0xe2a$AddVideoReq
  extends MessageMicro<AddVideoReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_video_list" }, new Object[] { null }, AddVideoReq.class);
  public final PBRepeatMessageField<oidb_0xe2a.UgcVideoInfo> rpt_video_list = PBField.initRepeatMessage(oidb_0xe2a.UgcVideoInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.cmd0xe2a.oidb_0xe2a.AddVideoReq
 * JD-Core Version:    0.7.0.1
 */