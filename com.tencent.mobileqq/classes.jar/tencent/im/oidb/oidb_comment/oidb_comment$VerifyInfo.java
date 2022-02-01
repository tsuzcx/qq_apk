package tencent.im.oidb.oidb_comment;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_comment$VerifyInfo
  extends MessageMicro<VerifyInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field is_verified = PBField.initUInt32(0);
  public final PBInt64Field result_version = PBField.initInt64(0L);
  public final PBUInt32Field update_time = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "is_verified", "update_time", "result_version" }, new Object[] { localInteger, localInteger, Long.valueOf(0L) }, VerifyInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.oidb_comment.oidb_comment.VerifyInfo
 * JD-Core Version:    0.7.0.1
 */