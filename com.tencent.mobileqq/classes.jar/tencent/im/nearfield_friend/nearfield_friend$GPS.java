package tencent.im.nearfield_friend;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class nearfield_friend$GPS
  extends MessageMicro<GPS>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt32Field lat = PBField.initInt32(0);
  public final PBInt32Field lng = PBField.initInt32(0);
  public final PBUInt32Field type = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "lat", "lng", "type" }, new Object[] { localInteger, localInteger, localInteger }, GPS.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.nearfield_friend.nearfield_friend.GPS
 * JD-Core Version:    0.7.0.1
 */