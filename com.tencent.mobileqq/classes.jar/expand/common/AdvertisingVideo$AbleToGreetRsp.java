package expand.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class AdvertisingVideo$AbleToGreetRsp
  extends MessageMicro<AbleToGreetRsp>
{
  public static final int GREET_HOT_PROTECT = 2;
  public static final int GREET_INVALID_UIN = 4;
  public static final int GREET_SUCCESS = 0;
  public static final int GREET_SUM_FORBIDDEN = 3;
  public static final int GREET_SUM_LIMIT = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "code", "need_report", "tips_wording" }, new Object[] { Integer.valueOf(0), Boolean.valueOf(false), "" }, AbleToGreetRsp.class);
  public final PBEnumField code = PBField.initEnum(0);
  public final PBBoolField need_report = PBField.initBool(false);
  public final PBStringField tips_wording = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     expand.common.AdvertisingVideo.AbleToGreetRsp
 * JD-Core Version:    0.7.0.1
 */