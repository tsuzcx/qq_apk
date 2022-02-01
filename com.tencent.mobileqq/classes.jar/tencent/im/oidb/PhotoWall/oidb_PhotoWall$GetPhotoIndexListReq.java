package tencent.im.oidb.PhotoWall;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_PhotoWall$GetPhotoIndexListReq
  extends MessageMicro<GetPhotoIndexListReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 58, 64, 80072 }, new String[] { "uin", "offset", "num", "photo_source", "uptime", "opuin", "last_filekey", "last_ctime", "base_time" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), "", Integer.valueOf(0), Long.valueOf(0L) }, GetPhotoIndexListReq.class);
  public final PBUInt64Field base_time = PBField.initUInt64(0L);
  public final PBUInt32Field last_ctime = PBField.initUInt32(0);
  public final PBStringField last_filekey = PBField.initString("");
  public final PBInt32Field num = PBField.initInt32(0);
  public final PBInt32Field offset = PBField.initInt32(0);
  public final PBUInt64Field opuin = PBField.initUInt64(0L);
  public final PBUInt32Field photo_source = PBField.initUInt32(0);
  public final PBUInt64Field uin = PBField.initUInt64(0L);
  public final PBUInt32Field uptime = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.PhotoWall.oidb_PhotoWall.GetPhotoIndexListReq
 * JD-Core Version:    0.7.0.1
 */