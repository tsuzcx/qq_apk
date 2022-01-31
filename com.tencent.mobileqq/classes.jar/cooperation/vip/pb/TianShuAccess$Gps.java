package cooperation.vip.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class TianShuAccess$Gps
  extends MessageMicro<Gps>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "lat", "lon", "accuracy" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, Gps.class);
  public final PBInt32Field accuracy = PBField.initInt32(0);
  public final PBInt32Field lat = PBField.initInt32(0);
  public final PBInt32Field lon = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.vip.pb.TianShuAccess.Gps
 * JD-Core Version:    0.7.0.1
 */