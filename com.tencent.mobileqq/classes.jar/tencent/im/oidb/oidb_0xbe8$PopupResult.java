package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0xbe8$PopupResult
  extends MessageMicro<PopupResult>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field uint32_popup_fieldid = PBField.initUInt32(0);
  public final PBUInt32Field uint32_popup_result = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint32_popup_result", "uint32_popup_fieldid" }, new Object[] { localInteger, localInteger }, PopupResult.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.oidb_0xbe8.PopupResult
 * JD-Core Version:    0.7.0.1
 */