package tencent.im.new_year_2014;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class PackServer$GetNewPackResp
  extends MessageMicro<GetNewPackResp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 40, 80 }, new String[] { "promotion_id", "seq", "data", "empty_url", "follow", "is_bingo_limit" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), null, "", Boolean.valueOf(false), Integer.valueOf(0) }, GetNewPackResp.class);
  public PackData.Pack data = new PackData.Pack();
  public final PBStringField empty_url = PBField.initString("");
  public final PBBoolField follow = PBField.initBool(false);
  public final PBUInt32Field is_bingo_limit = PBField.initUInt32(0);
  public final PBUInt32Field promotion_id = PBField.initUInt32(0);
  public final PBUInt32Field seq = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.new_year_2014.PackServer.GetNewPackResp
 * JD-Core Version:    0.7.0.1
 */