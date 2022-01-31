package tencent.im.confess.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class RedpointInfo
  extends MessageMicro<RedpointInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 82 }, new String[] { "feedid", "data" }, new Object[] { "", "" }, RedpointInfo.class);
  public final PBStringField data = PBField.initString("");
  public final PBStringField feedid = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     tencent.im.confess.common.RedpointInfo
 * JD-Core Version:    0.7.0.1
 */