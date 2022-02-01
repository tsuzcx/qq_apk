package tencent.im.longconn.multimsg;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class MultiMsg$MultiMsgApplyDownRsp
  extends MessageMicro<MultiMsgApplyDownRsp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_msg_key = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_msg_resid = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_thumb_down_para = PBField.initBytes(ByteStringMicro.EMPTY);
  public MultiMsg.ExternMsg msg_extern_info = new MultiMsg.ExternMsg();
  public final PBRepeatField<ByteStringMicro> rpt_bytes_down_ip_v6 = PBField.initRepeat(PBBytesField.__repeatHelper__);
  public final PBRepeatField<Integer> rpt_uint32_down_ip = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  public final PBRepeatField<Integer> rpt_uint32_down_port = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  public final PBRepeatField<Integer> rpt_uint32_down_v6_port = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  public final PBUInt32Field uint32_apply_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_result = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 40, 50, 58, 66, 72, 80 }, new String[] { "uint32_result", "bytes_thumb_down_para", "bytes_msg_key", "rpt_uint32_down_ip", "rpt_uint32_down_port", "bytes_msg_resid", "msg_extern_info", "rpt_bytes_down_ip_v6", "rpt_uint32_down_v6_port", "uint32_apply_id" }, new Object[] { localInteger, localByteStringMicro1, localByteStringMicro2, localInteger, localInteger, localByteStringMicro3, null, localByteStringMicro4, localInteger, localInteger }, MultiMsgApplyDownRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.longconn.multimsg.MultiMsg.MultiMsgApplyDownRsp
 * JD-Core Version:    0.7.0.1
 */