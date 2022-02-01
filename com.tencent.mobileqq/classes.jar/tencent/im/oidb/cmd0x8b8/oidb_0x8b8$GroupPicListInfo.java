package tencent.im.oidb.cmd0x8b8;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0x8b8$GroupPicListInfo
  extends MessageMicro<GroupPicListInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field uint32_left_x = PBField.initUInt32(0);
  public final PBUInt32Field uint32_left_y = PBField.initUInt32(0);
  public final PBUInt32Field uint32_pic_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_right_x = PBField.initUInt32(0);
  public final PBUInt32Field uint32_right_y = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40 }, new String[] { "uint32_pic_id", "uint32_left_x", "uint32_left_y", "uint32_right_x", "uint32_right_y" }, new Object[] { localInteger, localInteger, localInteger, localInteger, localInteger }, GroupPicListInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0x8b8.oidb_0x8b8.GroupPicListInfo
 * JD-Core Version:    0.7.0.1
 */