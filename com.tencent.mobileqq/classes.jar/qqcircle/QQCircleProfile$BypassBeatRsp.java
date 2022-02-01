package qqcircle;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class QQCircleProfile$BypassBeatRsp
  extends MessageMicro<BypassBeatRsp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField errormsg = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBInt32Field ret = PBField.initInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "ret", "errormsg" }, new Object[] { Integer.valueOf(0), localByteStringMicro }, BypassBeatRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     qqcircle.QQCircleProfile.BypassBeatRsp
 * JD-Core Version:    0.7.0.1
 */