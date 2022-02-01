package tencent.im.oidb.cmd0x592;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0x592$ModifyUnreadCntReq
  extends MessageMicro<ModifyUnreadCntReq>
{
  public static final int CLEAR = 3;
  public static final int DECREASE = 2;
  public static final int INCREASE = 1;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBEnumField enum_modify_type = PBField.initEnum(1);
  public final PBUInt32Field uint32_notice_var = PBField.initUInt32(0);
  public final PBUInt32Field uint32_notice_version = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "enum_modify_type", "uint32_notice_var", "uint32_notice_version" }, new Object[] { Integer.valueOf(1), localInteger, localInteger }, ModifyUnreadCntReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0x592.oidb_0x592.ModifyUnreadCntReq
 * JD-Core Version:    0.7.0.1
 */