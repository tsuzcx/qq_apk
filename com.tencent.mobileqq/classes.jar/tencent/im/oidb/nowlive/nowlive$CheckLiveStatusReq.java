package tencent.im.oidb.nowlive;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class nowlive$CheckLiveStatusReq
  extends MessageMicro<CheckLiveStatusReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "check_info" }, new Object[] { null }, CheckLiveStatusReq.class);
  public final PBRepeatMessageField<nowlive.CheckInfo> check_info = PBField.initRepeatMessage(nowlive.CheckInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.nowlive.nowlive.CheckLiveStatusReq
 * JD-Core Version:    0.7.0.1
 */