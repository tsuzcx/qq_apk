package tencent.im.oidb.cmd0x98d;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import tencent.qun.group_effect.group_effect.EffectInfo;

public final class oidb_0x98d$GetRsp
  extends MessageMicro<GetRsp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public group_effect.EffectInfo effect_info = new group_effect.EffectInfo();
  public final PBUInt32Field group_level = PBField.initUInt32(0);
  public final PBUInt32Field svip_level = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "effect_info", "svip_level", "group_level" }, new Object[] { null, localInteger, localInteger }, GetRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0x98d.oidb_0x98d.GetRsp
 * JD-Core Version:    0.7.0.1
 */