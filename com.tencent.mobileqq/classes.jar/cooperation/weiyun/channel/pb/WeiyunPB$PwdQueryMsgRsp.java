package cooperation.weiyun.channel.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;

public final class WeiyunPB$PwdQueryMsgRsp
  extends MessageMicro
{
  public static final int PWD_OPEN_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "pwd_open" }, new Object[] { Boolean.valueOf(false) }, PwdQueryMsgRsp.class);
  public final PBBoolField pwd_open = PBField.initBool(false);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.weiyun.channel.pb.WeiyunPB.PwdQueryMsgRsp
 * JD-Core Version:    0.7.0.1
 */