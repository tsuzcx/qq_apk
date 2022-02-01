package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class FeedCloudQwebcal$StEncryption
  extends MessageMicro<StEncryption>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "method", "iv" }, new Object[] { Integer.valueOf(0), "" }, StEncryption.class);
  public final PBStringField iv = PBField.initString("");
  public final PBUInt32Field method = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     feedcloud.FeedCloudQwebcal.StEncryption
 * JD-Core Version:    0.7.0.1
 */