package tencent.im.oidb.inner.cmd0xca05;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class cmd0xca05$Result
  extends MessageMicro<Result>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field uint32_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_res = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint32_id", "uint32_res" }, new Object[] { localInteger, localInteger }, Result.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.inner.cmd0xca05.cmd0xca05.Result
 * JD-Core Version:    0.7.0.1
 */