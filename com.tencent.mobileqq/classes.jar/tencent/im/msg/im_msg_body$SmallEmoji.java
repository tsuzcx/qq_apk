package tencent.im.msg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class im_msg_body$SmallEmoji
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "packIdSum", "imageType" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, SmallEmoji.class);
  public final PBUInt32Field imageType = PBField.initUInt32(0);
  public final PBUInt32Field packIdSum = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.msg.im_msg_body.SmallEmoji
 * JD-Core Version:    0.7.0.1
 */