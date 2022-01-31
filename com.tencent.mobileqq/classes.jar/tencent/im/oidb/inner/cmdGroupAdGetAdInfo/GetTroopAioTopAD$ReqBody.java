package tencent.im.oidb.inner.cmdGroupAdGetAdInfo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class GetTroopAioTopAD$ReqBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint64_groupcode", "msg_app_info" }, new Object[] { Long.valueOf(0L), null }, ReqBody.class);
  public GetTroopAioTopAD.AppInfo msg_app_info = new GetTroopAioTopAD.AppInfo();
  public final PBUInt64Field uint64_groupcode = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.inner.cmdGroupAdGetAdInfo.GetTroopAioTopAD.ReqBody
 * JD-Core Version:    0.7.0.1
 */