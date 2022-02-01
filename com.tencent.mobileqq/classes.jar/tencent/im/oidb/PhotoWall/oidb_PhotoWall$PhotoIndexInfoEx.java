package tencent.im.oidb.PhotoWall;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_PhotoWall$PhotoIndexInfoEx
  extends MessageMicro<PhotoIndexInfoEx>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34, 42, 50 }, new String[] { "filekey", "ctime", "ourl", "murl", "surl", "burl" }, new Object[] { "", Integer.valueOf(0), "", "", "", "" }, PhotoIndexInfoEx.class);
  public final PBStringField burl = PBField.initString("");
  public final PBUInt32Field ctime = PBField.initUInt32(0);
  public final PBStringField filekey = PBField.initString("");
  public final PBStringField murl = PBField.initString("");
  public final PBStringField ourl = PBField.initString("");
  public final PBStringField surl = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.PhotoWall.oidb_PhotoWall.PhotoIndexInfoEx
 * JD-Core Version:    0.7.0.1
 */