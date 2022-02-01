package tencent.im.oidb.cmd0xd4b;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class oidb_0xd4b$QueryKdVideoColumnRsp
  extends MessageMicro<QueryKdVideoColumnRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_kd_video_column" }, new Object[] { null }, QueryKdVideoColumnRsp.class);
  public final PBRepeatMessageField<oidb_0xd4b.KdVideoColumnInfo> rpt_kd_video_column = PBField.initRepeatMessage(oidb_0xd4b.KdVideoColumnInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xd4b.oidb_0xd4b.QueryKdVideoColumnRsp
 * JD-Core Version:    0.7.0.1
 */