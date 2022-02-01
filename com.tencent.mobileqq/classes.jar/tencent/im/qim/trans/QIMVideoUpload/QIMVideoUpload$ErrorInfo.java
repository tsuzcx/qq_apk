package tencent.im.qim.trans.QIMVideoUpload;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class QIMVideoUpload$ErrorInfo
  extends MessageMicro<ErrorInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_err_info = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt64Field uint64_err_code = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint64_err_code", "bytes_err_info" }, new Object[] { Long.valueOf(0L), localByteStringMicro }, ErrorInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.qim.trans.QIMVideoUpload.QIMVideoUpload.ErrorInfo
 * JD-Core Version:    0.7.0.1
 */