package tencent.im.oidb.cmd0xe95;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0xe95$SendWriteTogetherMsgRsp
  extends MessageMicro<SendWriteTogetherMsgRsp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt32Field int32_result = PBField.initInt32(0);
  public final PBUInt32Field uint32_msg_seq = PBField.initUInt32(0);
  public final PBUInt32Field uint32_rand_num = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "int32_result", "uint32_msg_seq", "uint32_rand_num" }, new Object[] { localInteger, localInteger, localInteger }, SendWriteTogetherMsgRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xe95.oidb_0xe95.SendWriteTogetherMsgRsp
 * JD-Core Version:    0.7.0.1
 */