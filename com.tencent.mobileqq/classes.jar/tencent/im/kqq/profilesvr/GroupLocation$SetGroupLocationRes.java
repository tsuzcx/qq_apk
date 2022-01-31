package tencent.im.kqq.profilesvr;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class GroupLocation$SetGroupLocationRes
  extends MessageMicro<SetGroupLocationRes>
{
  public static final int GROUPLOCATION_FIELD_NUMBER = 2;
  public static final int RESULT_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "result", "grouplocation" }, new Object[] { Integer.valueOf(-1), "" }, SetGroupLocationRes.class);
  public final PBStringField grouplocation = PBField.initString("");
  public final PBInt32Field result = PBField.initInt32(-1);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     tencent.im.kqq.profilesvr.GroupLocation.SetGroupLocationRes
 * JD-Core Version:    0.7.0.1
 */