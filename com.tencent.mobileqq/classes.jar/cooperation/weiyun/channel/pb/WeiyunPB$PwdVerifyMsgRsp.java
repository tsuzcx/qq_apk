package cooperation.weiyun.channel.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

public final class WeiyunPB$PwdVerifyMsgRsp
  extends MessageMicro<PwdVerifyMsgRsp>
{
  public static final int CS_SIG_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField cs_sig = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "cs_sig" }, new Object[] { localByteStringMicro }, PwdVerifyMsgRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.weiyun.channel.pb.WeiyunPB.PwdVerifyMsgRsp
 * JD-Core Version:    0.7.0.1
 */