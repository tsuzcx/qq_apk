package tencent.im.oidb.cmd0x686;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class Oidb_0x686$CharmEvent
  extends MessageMicro<CharmEvent>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField str_tips_content = PBField.initString("");
  public final PBUInt32Field uint32_cur_level_threshold = PBField.initUInt32(0);
  public final PBUInt32Field uint32_new_charm = PBField.initUInt32(0);
  public final PBUInt32Field uint32_new_charm_level = PBField.initUInt32(0);
  public final PBUInt32Field uint32_next_level_threshold = PBField.initUInt32(0);
  public final PBUInt32Field uint32_old_charm = PBField.initUInt32(0);
  public final PBUInt32Field uint32_old_charm_level = PBField.initUInt32(0);
  public final PBUInt32Field uint32_pop_flag = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 58, 64 }, new String[] { "uint32_pop_flag", "uint32_old_charm", "uint32_old_charm_level", "uint32_new_charm", "uint32_new_charm_level", "uint32_next_level_threshold", "str_tips_content", "uint32_cur_level_threshold" }, new Object[] { localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, "", localInteger }, CharmEvent.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0x686.Oidb_0x686.CharmEvent
 * JD-Core Version:    0.7.0.1
 */