package tencent.im.oidb.cmd0xe33;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0xe33$TopicInfoSetRsp
  extends MessageMicro<TopicInfoSetRsp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField err_msg = PBField.initString("");
  public final PBEnumField ret_code = PBField.initEnum(0);
  public final PBUInt32Field topic_id = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "topic_id", "ret_code", "err_msg" }, new Object[] { localInteger, localInteger, "" }, TopicInfoSetRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xe33.oidb_0xe33.TopicInfoSetRsp
 * JD-Core Version:    0.7.0.1
 */