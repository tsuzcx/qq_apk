package tencent.im.new_year_2014;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class PackServer$QueryBusinessResp
  extends MessageMicro<QueryBusinessResp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "business", "pack" }, new Object[] { Integer.valueOf(0), null }, QueryBusinessResp.class);
  public final PBUInt32Field business = PBField.initUInt32(0);
  public PackData.Pack pack = new PackData.Pack();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     tencent.im.new_year_2014.PackServer.QueryBusinessResp
 * JD-Core Version:    0.7.0.1
 */