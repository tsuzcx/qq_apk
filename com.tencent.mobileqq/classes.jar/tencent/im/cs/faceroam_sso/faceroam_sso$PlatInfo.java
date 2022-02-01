package tencent.im.cs.faceroam_sso;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class faceroam_sso$PlatInfo
  extends MessageMicro<PlatInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "implat", "osver", "mqqver" }, new Object[] { Long.valueOf(0L), "", "" }, PlatInfo.class);
  public final PBInt64Field implat = PBField.initInt64(0L);
  public final PBStringField mqqver = PBField.initString("");
  public final PBStringField osver = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.cs.faceroam_sso.faceroam_sso.PlatInfo
 * JD-Core Version:    0.7.0.1
 */