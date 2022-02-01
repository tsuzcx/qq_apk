package tencent.qun.group_effect;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class group_effect_commu$TEntryNotifyRsp0x2000
  extends MessageMicro<TEntryNotifyRsp0x2000>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field notify_interval = PBField.initUInt32(0);
  public final PBInt32Field ret = PBField.initInt32(0);
  public group_effect_commu.TEffectDetail st_userconfig = new group_effect_commu.TEffectDetail();
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "ret", "st_userconfig", "notify_interval" }, new Object[] { localInteger, null, localInteger }, TEntryNotifyRsp0x2000.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.qun.group_effect.group_effect_commu.TEntryNotifyRsp0x2000
 * JD-Core Version:    0.7.0.1
 */