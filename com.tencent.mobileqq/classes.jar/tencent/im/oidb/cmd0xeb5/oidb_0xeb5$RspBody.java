package tencent.im.oidb.cmd0xeb5;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0xeb5$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBRepeatMessageField<oidb_0xeb5.App> app = PBField.initRepeatMessage(oidb_0xeb5.App.class);
  public final PBUInt32Field cache_ts = PBField.initUInt32(0);
  public final PBBytesField cookies = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field expose_id = PBField.initUInt32(0);
  public final PBUInt32Field max_show_app_num = PBField.initUInt32(0);
  public final PBUInt32Field redpoint_cache_ts = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34, 40, 48 }, new String[] { "cache_ts", "app", "redpoint_cache_ts", "cookies", "max_show_app_num", "expose_id" }, new Object[] { localInteger, null, localInteger, localByteStringMicro, localInteger, localInteger }, RspBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0xeb5.oidb_0xeb5.RspBody
 * JD-Core Version:    0.7.0.1
 */