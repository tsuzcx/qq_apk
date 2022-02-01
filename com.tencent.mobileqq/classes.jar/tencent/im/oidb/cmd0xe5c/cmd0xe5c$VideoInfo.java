package tencent.im.oidb.cmd0xe5c;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class cmd0xe5c$VideoInfo
  extends MessageMicro<VideoInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34, 42 }, new String[] { "cover", "title", "type", "schema", "rowkey" }, new Object[] { "", "", Integer.valueOf(0), "", "" }, VideoInfo.class);
  public final PBStringField cover = PBField.initString("");
  public final PBStringField rowkey = PBField.initString("");
  public final PBStringField schema = PBField.initString("");
  public final PBStringField title = PBField.initString("");
  public final PBUInt32Field type = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xe5c.cmd0xe5c.VideoInfo
 * JD-Core Version:    0.7.0.1
 */