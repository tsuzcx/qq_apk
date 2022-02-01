package tencent.im.new_year_2014;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class PackServer$QueryRemainPackResp
  extends MessageMicro<QueryRemainPackResp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "promotion_id", "pack_count", "interval_time" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, QueryRemainPackResp.class);
  public final PBUInt32Field interval_time = PBField.initUInt32(0);
  public final PBUInt32Field pack_count = PBField.initUInt32(0);
  public final PBUInt32Field promotion_id = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.new_year_2014.PackServer.QueryRemainPackResp
 * JD-Core Version:    0.7.0.1
 */