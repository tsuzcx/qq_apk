package tencent.im.oidb.cmd0xcd4;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBSInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class cmd0xcd4$InputNotifyRsp
  extends MessageMicro<InputNotifyRsp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_err_msg = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBSInt32Field sint32_result = PBField.initSInt32(0);
  public final PBUInt32Field uint32_interval = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "sint32_result", "bytes_err_msg", "uint32_interval" }, new Object[] { localInteger, localByteStringMicro, localInteger }, InputNotifyRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xcd4.cmd0xcd4.InputNotifyRsp
 * JD-Core Version:    0.7.0.1
 */