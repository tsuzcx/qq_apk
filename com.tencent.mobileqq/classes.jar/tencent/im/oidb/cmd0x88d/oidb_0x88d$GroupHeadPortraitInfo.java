package tencent.im.oidb.cmd0x88d;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0x88d$GroupHeadPortraitInfo
  extends MessageMicro<GroupHeadPortraitInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field rpt_uint32_pic_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_left_x = PBField.initUInt32(0);
  public final PBUInt32Field uint32_left_y = PBField.initUInt32(0);
  public final PBUInt32Field uint32_right_x = PBField.initUInt32(0);
  public final PBUInt32Field uint32_right_y = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40 }, new String[] { "rpt_uint32_pic_id", "uint32_left_x", "uint32_left_y", "uint32_right_x", "uint32_right_y" }, new Object[] { localInteger, localInteger, localInteger, localInteger, localInteger }, GroupHeadPortraitInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0x88d.oidb_0x88d.GroupHeadPortraitInfo
 * JD-Core Version:    0.7.0.1
 */