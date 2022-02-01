package tencent.im.sso2sns.cmd0x3;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class sso2sns_0x3_blocklist$ReqBodyDelBlockList
  extends MessageMicro<ReqBodyDelBlockList>
{
  public static final int RPT_UINT64_DEL_UIN_FIELD_NUMBER = 2;
  public static final int UINT64_UIN_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBRepeatField<Long> rpt_uint64_del_uin = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint64_uin", "rpt_uint64_del_uin" }, new Object[] { localLong, localLong }, ReqBodyDelBlockList.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.sso2sns.cmd0x3.sso2sns_0x3_blocklist.ReqBodyDelBlockList
 * JD-Core Version:    0.7.0.1
 */