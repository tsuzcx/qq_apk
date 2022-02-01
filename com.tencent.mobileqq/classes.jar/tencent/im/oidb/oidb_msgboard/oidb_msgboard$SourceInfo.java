package tencent.im.oidb.oidb_msgboard;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_msgboard$SourceInfo
  extends MessageMicro<SourceInfo>
{
  public static final int TYPE_COMMUNITY = 2;
  public static final int TYPE_HOMEPAGE = 3;
  public static final int TYPE_TAG_TOPIC = 1;
  public static final int TYPE_UNKNOWN = 0;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "type", "key" }, new Object[] { Integer.valueOf(0), "" }, SourceInfo.class);
  public final PBStringField key = PBField.initString("");
  public final PBUInt32Field type = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.oidb_msgboard.oidb_msgboard.SourceInfo
 * JD-Core Version:    0.7.0.1
 */