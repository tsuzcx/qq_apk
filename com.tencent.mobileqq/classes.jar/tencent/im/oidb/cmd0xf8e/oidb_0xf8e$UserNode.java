package tencent.im.oidb.cmd0xf8e;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0xf8e$UserNode
  extends MessageMicro<UserNode>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt64Field group_code = PBField.initUInt64(0L);
  public final PBUInt64Field seq = PBField.initUInt64(0L);
  public final PBUInt32Field status = PBField.initUInt32(0);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "group_code", "seq", "status" }, new Object[] { localLong, localLong, Integer.valueOf(0) }, UserNode.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xf8e.oidb_0xf8e.UserNode
 * JD-Core Version:    0.7.0.1
 */