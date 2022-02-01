package tencent.im.oidb.cmd0xed1;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0xed1$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field uint32_can_join_group = PBField.initUInt32(0);
  public final PBUInt32Field uint32_can_search = PBField.initUInt32(0);
  public final PBUInt32Field uint32_learn_mode = PBField.initUInt32(0);
  public final PBUInt32Field uint32_need_verify = PBField.initUInt32(0);
  public final PBUInt32Field uint32_other_can_search = PBField.initUInt32(0);
  public final PBUInt32Field uint32_simple_mode = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 338280, 338896, 339424, 339432, 339440, 339920 }, new String[] { "uint32_simple_mode", "uint32_learn_mode", "uint32_other_can_search", "uint32_can_join_group", "uint32_can_search", "uint32_need_verify" }, new Object[] { localInteger, localInteger, localInteger, localInteger, localInteger, localInteger }, ReqBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xed1.oidb_0xed1.ReqBody
 * JD-Core Version:    0.7.0.1
 */