package tencent.im.oidb.cmd0x6c3;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class oidb_0x6c3$ImgShowConfig
  extends MessageMicro<ImgShowConfig>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "msg_imgshow_item" }, new Object[] { null }, ImgShowConfig.class);
  public final PBRepeatMessageField<oidb_0x6c3.ImgShowItem> msg_imgshow_item = PBField.initRepeatMessage(oidb_0x6c3.ImgShowItem.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0x6c3.oidb_0x6c3.ImgShowConfig
 * JD-Core Version:    0.7.0.1
 */