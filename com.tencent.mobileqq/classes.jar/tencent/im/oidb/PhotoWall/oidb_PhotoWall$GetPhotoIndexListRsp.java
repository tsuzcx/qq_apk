package tencent.im.oidb.PhotoWall;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_PhotoWall$GetPhotoIndexListRsp
  extends MessageMicro<GetPhotoIndexListRsp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt64Field base_time_photo_count = PBField.initUInt64(0L);
  public oidb_PhotoWall.CommRsp comm_rsp = new oidb_PhotoWall.CommRsp();
  public final PBInt32Field next_offset = PBField.initInt32(0);
  public final PBRepeatMessageField<oidb_PhotoWall.PhotoIndexInfoEx> photo_list = PBField.initRepeatMessage(oidb_PhotoWall.PhotoIndexInfoEx.class);
  public final PBInt32Field total = PBField.initInt32(0);
  public final PBUInt32Field uptime = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 40, 80080 }, new String[] { "comm_rsp", "photo_list", "uptime", "next_offset", "total", "base_time_photo_count" }, new Object[] { null, null, localInteger, localInteger, localInteger, Long.valueOf(0L) }, GetPhotoIndexListRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.PhotoWall.oidb_PhotoWall.GetPhotoIndexListRsp
 * JD-Core Version:    0.7.0.1
 */