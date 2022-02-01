package cooperation.weiyun.channel.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class WeiyunPB$MusicDetailItem
  extends MessageMicro<MusicDetailItem>
{
  public static final int SINGER_LOGO_FIELD_NUMBER = 40;
  public static final int SINGER_NAME_FIELD_NUMBER = 30;
  public static final int SPECIAL_ISSUE_LOGO_FIELD_NUMBER = 60;
  public static final int SPECIAL_ISSUE_NAME_FIELD_NUMBER = 50;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 242, 322, 402, 482 }, new String[] { "singer_name", "singer_logo", "special_issue_name", "special_issue_logo" }, new Object[] { "", "", "", "" }, MusicDetailItem.class);
  public final PBStringField singer_logo = PBField.initString("");
  public final PBStringField singer_name = PBField.initString("");
  public final PBStringField special_issue_logo = PBField.initString("");
  public final PBStringField special_issue_name = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.weiyun.channel.pb.WeiyunPB.MusicDetailItem
 * JD-Core Version:    0.7.0.1
 */