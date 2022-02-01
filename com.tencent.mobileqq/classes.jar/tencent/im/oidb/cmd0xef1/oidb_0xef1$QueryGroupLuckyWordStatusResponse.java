package tencent.im.oidb.cmd0xef1;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class oidb_0xef1$QueryGroupLuckyWordStatusResponse
  extends MessageMicro<QueryGroupLuckyWordStatusResponse>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt32Field remain_times = PBField.initInt32(0);
  public final PBInt32Field status = PBField.initInt32(0);
  public final PBStringField wording = PBField.initString("");
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "wording", "status", "remain_times" }, new Object[] { "", localInteger, localInteger }, QueryGroupLuckyWordStatusResponse.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0xef1.oidb_0xef1.QueryGroupLuckyWordStatusResponse
 * JD-Core Version:    0.7.0.1
 */