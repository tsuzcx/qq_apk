package tencent.im.new_year_2014;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class PackServer$QueryPackResp
  extends MessageMicro<QueryPackResp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "data" }, new Object[] { null }, QueryPackResp.class);
  public PackData.Pack data = new PackData.Pack();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.new_year_2014.PackServer.QueryPackResp
 * JD-Core Version:    0.7.0.1
 */