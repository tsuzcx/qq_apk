package tencent.im.cs.longconn;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class c2c_av_terminate_msg_ext$C2CAVTerminateMsgExt
  extends MessageMicro<C2CAVTerminateMsgExt>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBEnumField buss_flag = PBField.initEnum(1);
  public final PBBoolField has_switched = PBField.initBool(false);
  public final PBUInt32Field logout_ts = PBField.initUInt32(0);
  public final PBEnumField reason = PBField.initEnum(1);
  public final PBUInt64Field room_id = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(1);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40 }, new String[] { "room_id", "reason", "logout_ts", "buss_flag", "has_switched" }, new Object[] { Long.valueOf(0L), localInteger, Integer.valueOf(0), localInteger, Boolean.valueOf(false) }, C2CAVTerminateMsgExt.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.cs.longconn.c2c_av_terminate_msg_ext.C2CAVTerminateMsgExt
 * JD-Core Version:    0.7.0.1
 */