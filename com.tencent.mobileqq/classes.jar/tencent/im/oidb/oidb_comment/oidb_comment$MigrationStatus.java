package tencent.im.oidb.oidb_comment;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class oidb_comment$MigrationStatus
  extends MessageMicro<MigrationStatus>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "status" }, new Object[] { Integer.valueOf(0) }, MigrationStatus.class);
  public final PBInt32Field status = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.oidb_comment.oidb_comment.MigrationStatus
 * JD-Core Version:    0.7.0.1
 */