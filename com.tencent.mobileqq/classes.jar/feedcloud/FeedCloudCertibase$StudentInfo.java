package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class FeedCloudCertibase$StudentInfo
  extends MessageMicro<StudentInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "eduExp", "certifiData" }, new Object[] { null, null }, StudentInfo.class);
  public FeedCloudCertibase.StudentCertification certifiData = new FeedCloudCertibase.StudentCertification();
  public FeedCloudCertibase.EducationExp eduExp = new FeedCloudCertibase.EducationExp();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     feedcloud.FeedCloudCertibase.StudentInfo
 * JD-Core Version:    0.7.0.1
 */