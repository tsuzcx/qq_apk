package cooperation.weiyun.channel.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

public final class WeiyunPB$PwdVerifyMsgReq
  extends MessageMicro<PwdVerifyMsgReq>
{
  public static final int CS_SIG_FIELD_NUMBER = 2;
  public static final int PWD_MD5_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField cs_sig = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField pwd_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "pwd_md5", "cs_sig" }, new Object[] { localByteStringMicro1, localByteStringMicro2 }, PwdVerifyMsgReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.weiyun.channel.pb.WeiyunPB.PwdVerifyMsgReq
 * JD-Core Version:    0.7.0.1
 */