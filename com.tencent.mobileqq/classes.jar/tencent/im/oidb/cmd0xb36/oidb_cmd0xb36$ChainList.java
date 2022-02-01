package tencent.im.oidb.cmd0xb36;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_cmd0xb36$ChainList
  extends MessageMicro<ChainList>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field group_role = PBField.initUInt32(0);
  public final PBUInt32Field homework_role = PBField.initUInt32(0);
  public final PBRepeatMessageField<oidb_cmd0xb36.ChainInfo> infos = PBField.initRepeatMessage(oidb_cmd0xb36.ChainInfo.class);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "infos", "group_role", "homework_role" }, new Object[] { null, localInteger, localInteger }, ChainList.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0xb36.oidb_cmd0xb36.ChainList
 * JD-Core Version:    0.7.0.1
 */