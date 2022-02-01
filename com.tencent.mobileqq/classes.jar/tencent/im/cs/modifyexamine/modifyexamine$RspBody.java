package tencent.im.cs.modifyexamine;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class modifyexamine$RspBody
  extends MessageMicro<RspBody>
{
  public static final int STR_ERRMSG_FIELD_NUMBER = 4;
  public static final int UINT32_LIMIT_TIMES_FIELD_NUMBER = 2;
  public static final int UINT32_MODIFY_TIMES_FIELD_NUMBER = 3;
  public static final int UINT32_RESULT_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34 }, new String[] { "uint32_result", "uint32_limit_times", "uint32_modify_times", "str_errmsg" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "" }, RspBody.class);
  public final PBStringField str_errmsg = PBField.initString("");
  public final PBUInt32Field uint32_limit_times = PBField.initUInt32(0);
  public final PBUInt32Field uint32_modify_times = PBField.initUInt32(0);
  public final PBUInt32Field uint32_result = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.cs.modifyexamine.modifyexamine.RspBody
 * JD-Core Version:    0.7.0.1
 */