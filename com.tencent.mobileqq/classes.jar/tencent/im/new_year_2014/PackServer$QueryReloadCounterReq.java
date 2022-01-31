package tencent.im.new_year_2014;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class PackServer$QueryReloadCounterReq
  extends MessageMicro<QueryReloadCounterReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "now" }, new Object[] { Integer.valueOf(0) }, QueryReloadCounterReq.class);
  public final PBUInt32Field now = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     tencent.im.new_year_2014.PackServer.QueryReloadCounterReq
 * JD-Core Version:    0.7.0.1
 */