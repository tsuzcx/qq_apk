package tencent.im.oidb.nowlive;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class nowlive$CheckLiveStatusRsp
  extends MessageMicro<CheckLiveStatusRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "err_code", "err_msg", "mix_info" }, new Object[] { Integer.valueOf(0), "", null }, CheckLiveStatusRsp.class);
  public final PBUInt32Field err_code = PBField.initUInt32(0);
  public final PBStringField err_msg = PBField.initString("");
  public final PBRepeatMessageField<nowlive.MixInfo> mix_info = PBField.initRepeatMessage(nowlive.MixInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.nowlive.nowlive.CheckLiveStatusRsp
 * JD-Core Version:    0.7.0.1
 */