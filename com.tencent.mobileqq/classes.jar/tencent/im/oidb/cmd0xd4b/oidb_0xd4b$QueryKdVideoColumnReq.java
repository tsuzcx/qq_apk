package tencent.im.oidb.cmd0xd4b;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0xd4b$QueryKdVideoColumnReq
  extends MessageMicro<QueryKdVideoColumnReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint32_query_sub_status", "rpt_video_column_id" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, QueryKdVideoColumnReq.class);
  public final PBRepeatField<Integer> rpt_video_column_id = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  public final PBUInt32Field uint32_query_sub_status = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0xd4b.oidb_0xd4b.QueryKdVideoColumnReq
 * JD-Core Version:    0.7.0.1
 */