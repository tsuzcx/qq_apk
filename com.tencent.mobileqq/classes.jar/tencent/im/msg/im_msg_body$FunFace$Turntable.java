package tencent.im.msg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class im_msg_body$FunFace$Turntable
  extends MessageMicro<Turntable>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBRepeatField<Long> rpt_uint64_uin_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  public final PBStringField str_hit_uin_nick = PBField.initString("");
  public final PBUInt64Field uint64_hit_uin = PBField.initUInt64(0L);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "rpt_uint64_uin_list", "uint64_hit_uin", "str_hit_uin_nick" }, new Object[] { localLong, localLong, "" }, Turntable.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.msg.im_msg_body.FunFace.Turntable
 * JD-Core Version:    0.7.0.1
 */