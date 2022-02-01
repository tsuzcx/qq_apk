package localpb.richMsg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class RichMsg$ForwardExtra
  extends MessageMicro<ForwardExtra>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt32Field foward_orgFileSizeType = PBField.initInt32(0);
  public final PBUInt64Field foward_orgId = PBField.initUInt64(0L);
  public final PBStringField foward_orgUin = PBField.initString("");
  public final PBInt32Field foward_orgUinType = PBField.initInt32(0);
  public final PBStringField foward_orgUrl = PBField.initString("");
  public final PBStringField foward_thumbPath = PBField.initString("");
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34, 42, 48 }, new String[] { "foward_orgId", "foward_orgUin", "foward_orgUinType", "foward_orgUrl", "foward_thumbPath", "foward_orgFileSizeType" }, new Object[] { Long.valueOf(0L), "", localInteger, "", "", localInteger }, ForwardExtra.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     localpb.richMsg.RichMsg.ForwardExtra
 * JD-Core Version:    0.7.0.1
 */