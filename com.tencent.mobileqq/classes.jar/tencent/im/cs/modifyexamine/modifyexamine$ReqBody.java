package tencent.im.cs.modifyexamine;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class modifyexamine$ReqBody
  extends MessageMicro<ReqBody>
{
  public static final int SKEY_FIELD_NUMBER = 2;
  public static final int UINT64_GC_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint64_gc", "skey" }, new Object[] { Long.valueOf(0L), "" }, ReqBody.class);
  public final PBStringField skey = PBField.initString("");
  public final PBUInt64Field uint64_gc = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.cs.modifyexamine.modifyexamine.ReqBody
 * JD-Core Version:    0.7.0.1
 */