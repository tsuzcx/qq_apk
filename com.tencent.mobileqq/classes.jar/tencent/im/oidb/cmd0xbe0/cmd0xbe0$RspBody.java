package tencent.im.oidb.cmd0xbe0;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class cmd0xbe0$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "msg_more_gallery", "msg_next_gallery", "uint32_is_end" }, new Object[] { null, null, Integer.valueOf(0) }, RspBody.class);
  public cmd0xbe0.MoreGallery msg_more_gallery = new cmd0xbe0.MoreGallery();
  public cmd0xbe0.NextGallery msg_next_gallery = new cmd0xbe0.NextGallery();
  public final PBUInt32Field uint32_is_end = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.cmd0xbe0.cmd0xbe0.RspBody
 * JD-Core Version:    0.7.0.1
 */