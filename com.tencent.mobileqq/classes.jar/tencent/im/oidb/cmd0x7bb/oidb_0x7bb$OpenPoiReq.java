package tencent.im.oidb.cmd0x7bb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x7bb$OpenPoiReq
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField idfv = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBInt32Field lat = PBField.initInt32(0);
  public final PBInt32Field lng = PBField.initInt32(0);
  public final PBUInt32Field mode = PBField.initUInt32(0);
  public oidb_0x7bb.LBSSig msg_lbs_sig = new oidb_0x7bb.LBSSig();
  public final PBBytesField pic_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt64Field poi_id = PBField.initUInt64(0L);
  public final PBUInt64Field task_id = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 40, 48, 82, 90 }, new String[] { "task_id", "poi_id", "mode", "pic_id", "lat", "lng", "msg_lbs_sig", "idfv" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro1, Integer.valueOf(0), Integer.valueOf(0), null, localByteStringMicro2 }, OpenPoiReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x7bb.oidb_0x7bb.OpenPoiReq
 * JD-Core Version:    0.7.0.1
 */