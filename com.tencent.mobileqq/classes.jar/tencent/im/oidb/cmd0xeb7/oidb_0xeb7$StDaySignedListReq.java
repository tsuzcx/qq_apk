package tencent.im.oidb.cmd0xeb7;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class oidb_0xeb7$StDaySignedListReq
  extends MessageMicro<StDaySignedListReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField dayYmd = PBField.initString("");
  public final PBStringField groupId = PBField.initString("");
  public final PBInt32Field limit = PBField.initInt32(0);
  public final PBInt32Field offset = PBField.initInt32(0);
  public final PBStringField uid = PBField.initString("");
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 40 }, new String[] { "dayYmd", "uid", "groupId", "offset", "limit" }, new Object[] { "", "", "", localInteger, localInteger }, StDaySignedListReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xeb7.oidb_0xeb7.StDaySignedListReq
 * JD-Core Version:    0.7.0.1
 */