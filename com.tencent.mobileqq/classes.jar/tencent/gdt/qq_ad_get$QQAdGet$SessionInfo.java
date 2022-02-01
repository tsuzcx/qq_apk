package tencent.gdt;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class qq_ad_get$QQAdGet$SessionInfo
  extends MessageMicro<SessionInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field session_num = PBField.initUInt32(0);
  public final PBUInt32Field session_time = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "session_num", "session_time" }, new Object[] { localInteger, localInteger }, SessionInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.gdt.qq_ad_get.QQAdGet.SessionInfo
 * JD-Core Version:    0.7.0.1
 */