package tencent.im.oidb.cmd0xe95;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class oidb_0xe95$SendWriteTogetherMsgRsp
  extends MessageMicro<SendWriteTogetherMsgRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "int32_result" }, new Object[] { Integer.valueOf(0) }, SendWriteTogetherMsgRsp.class);
  public final PBInt32Field int32_result = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.cmd0xe95.oidb_0xe95.SendWriteTogetherMsgRsp
 * JD-Core Version:    0.7.0.1
 */