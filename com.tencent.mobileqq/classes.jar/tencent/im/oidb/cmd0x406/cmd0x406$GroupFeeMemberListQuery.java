package tencent.im.oidb.cmd0x406;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class cmd0x406$GroupFeeMemberListQuery
  extends MessageMicro<GroupFeeMemberListQuery>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField string_project_id = PBField.initString("");
  public final PBUInt32Field uint32_member_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_page_index = PBField.initUInt32(0);
  public final PBUInt32Field uint32_page_size = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32 }, new String[] { "string_project_id", "uint32_member_type", "uint32_page_index", "uint32_page_size" }, new Object[] { "", localInteger, localInteger, localInteger }, GroupFeeMemberListQuery.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0x406.cmd0x406.GroupFeeMemberListQuery
 * JD-Core Version:    0.7.0.1
 */