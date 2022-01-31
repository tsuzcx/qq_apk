package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

public final class FeedCloudCertibase$StaffInfo
  extends MessageMicro<StaffInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32 }, new String[] { "companyInfo", "email", "evidencePicturies", "entryYear" }, new Object[] { null, "", "", Long.valueOf(0L) }, StaffInfo.class);
  public FeedCloudCertibase.CompanyBaseInfo companyInfo = new FeedCloudCertibase.CompanyBaseInfo();
  public final PBStringField email = PBField.initString("");
  public final PBInt64Field entryYear = PBField.initInt64(0L);
  public final PBRepeatField<String> evidencePicturies = PBField.initRepeat(PBStringField.__repeatHelper__);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     feedcloud.FeedCloudCertibase.StaffInfo
 * JD-Core Version:    0.7.0.1
 */