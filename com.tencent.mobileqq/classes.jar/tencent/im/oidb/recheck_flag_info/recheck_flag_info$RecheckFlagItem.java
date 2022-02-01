package tencent.im.oidb.recheck_flag_info;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class recheck_flag_info$RecheckFlagItem
  extends MessageMicro<RecheckFlagItem>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uint32_flag", "uint32_cur_level", "uint32_lst_level" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, RecheckFlagItem.class);
  public final PBInt32Field uint32_cur_level = PBField.initInt32(0);
  public final PBInt32Field uint32_flag = PBField.initInt32(0);
  public final PBInt32Field uint32_lst_level = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.recheck_flag_info.recheck_flag_info.RecheckFlagItem
 * JD-Core Version:    0.7.0.1
 */