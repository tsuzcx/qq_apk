package tencent.im.oidb.cmd0x7bb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x7bb$QueryPoiReq
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField map_sig = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt64Field poi_id = PBField.initUInt64(0L);
  public final PBUInt64Field task_id = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "task_id", "poi_id", "map_sig" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), localByteStringMicro }, QueryPoiReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x7bb.oidb_0x7bb.QueryPoiReq
 * JD-Core Version:    0.7.0.1
 */