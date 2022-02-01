package tencent.im.oidb.cmd0xe2a;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0xe2a$AddVideoReq
  extends MessageMicro<AddVideoReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "rpt_video_list", "uint32_add_video_type" }, new Object[] { null, Integer.valueOf(0) }, AddVideoReq.class);
  public final PBRepeatMessageField<oidb_0xe2a.UgcVideoInfo> rpt_video_list = PBField.initRepeatMessage(oidb_0xe2a.UgcVideoInfo.class);
  public final PBUInt32Field uint32_add_video_type = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0xe2a.oidb_0xe2a.AddVideoReq
 * JD-Core Version:    0.7.0.1
 */