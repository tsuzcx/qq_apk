package tencent.im.oidb.cmd0xe2a;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0xe2a$JudgeTopicVideoNumRsp
  extends MessageMicro<JudgeTopicVideoNumRsp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field uint32_is_overtimes = PBField.initUInt32(0);
  public final PBUInt32Field uint32_publish_num = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint32_is_overtimes", "uint32_publish_num" }, new Object[] { localInteger, localInteger }, JudgeTopicVideoNumRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0xe2a.oidb_0xe2a.JudgeTopicVideoNumRsp
 * JD-Core Version:    0.7.0.1
 */