package tencent.im.msg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class im_msg_body$BlessingMessage
  extends MessageMicro<BlessingMessage>
{
  public static final int ETypeBlessing = 1;
  public static final int ETypeNormal = 0;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field uint32_ex_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_msg_type = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint32_msg_type", "uint32_ex_flag" }, new Object[] { localInteger, localInteger }, BlessingMessage.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.msg.im_msg_body.BlessingMessage
 * JD-Core Version:    0.7.0.1
 */