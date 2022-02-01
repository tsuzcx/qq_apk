package tencent.im.msg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class im_msg_body$SmallEmoji
  extends MessageMicro<SmallEmoji>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field imageType = PBField.initUInt32(0);
  public final PBUInt32Field packIdSum = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "packIdSum", "imageType" }, new Object[] { localInteger, localInteger }, SmallEmoji.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.msg.im_msg_body.SmallEmoji
 * JD-Core Version:    0.7.0.1
 */