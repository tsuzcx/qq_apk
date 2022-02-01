package tencent.im.oidb.cmd0xd4b;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0xd4b$SubscribeVideoColumnReq
  extends MessageMicro<SubscribeVideoColumnReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field uint32_oper_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_video_column_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_visibility = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uint32_video_column_id", "uint32_oper_type", "uint32_visibility" }, new Object[] { localInteger, localInteger, localInteger }, SubscribeVideoColumnReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xd4b.oidb_0xd4b.SubscribeVideoColumnReq
 * JD-Core Version:    0.7.0.1
 */