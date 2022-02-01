package cooperation.weiyun.channel.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class WeiyunPB$WeiyunShareAuthInfo
  extends MessageMicro<WeiyunShareAuthInfo>
{
  public static final int AUTH_LEVEL_FIELD_NUMBER = 10;
  public static final int EXPIRED_TIME_FIELD_NUMBER = 20;
  public static final int LIMIT_VISIT_COUNT_FIELD_NUMBER = 30;
  public static final int PASS_WORD_FIELD_NUMBER = 40;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 80, 160, 240, 322 }, new String[] { "auth_level", "expired_time", "limit_visit_count", "pass_word" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "" }, WeiyunShareAuthInfo.class);
  public final PBInt32Field auth_level = PBField.initInt32(0);
  public final PBUInt32Field expired_time = PBField.initUInt32(0);
  public final PBInt32Field limit_visit_count = PBField.initInt32(0);
  public final PBStringField pass_word = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.weiyun.channel.pb.WeiyunPB.WeiyunShareAuthInfo
 * JD-Core Version:    0.7.0.1
 */