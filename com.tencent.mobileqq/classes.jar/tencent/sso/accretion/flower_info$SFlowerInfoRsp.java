package tencent.sso.accretion;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class flower_info$SFlowerInfoRsp
  extends MessageMicro<SFlowerInfoRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34, 42, 48 }, new String[] { "flowers", "num", "ret", "rpt_flower_url", "flower_msg_tips", "flower_flag" }, new Object[] { null, Integer.valueOf(0), Integer.valueOf(0), "", "", Integer.valueOf(0) }, SFlowerInfoRsp.class);
  public final PBUInt32Field flower_flag = PBField.initUInt32(0);
  public final PBStringField flower_msg_tips = PBField.initString("");
  public final PBRepeatMessageField<flower_info.SFlowerInfo> flowers = PBField.initRepeatMessage(flower_info.SFlowerInfo.class);
  public final PBUInt32Field num = PBField.initUInt32(0);
  public final PBInt32Field ret = PBField.initInt32(0);
  public final PBRepeatField<String> rpt_flower_url = PBField.initRepeat(PBStringField.__repeatHelper__);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.sso.accretion.flower_info.SFlowerInfoRsp
 * JD-Core Version:    0.7.0.1
 */