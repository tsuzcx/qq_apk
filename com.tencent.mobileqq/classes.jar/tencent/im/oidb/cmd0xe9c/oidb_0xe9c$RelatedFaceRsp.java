package tencent.im.oidb.cmd0xe9c;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class oidb_0xe9c$RelatedFaceRsp
  extends MessageMicro<RelatedFaceRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "rpt_img_info", "img_num" }, new Object[] { null, Integer.valueOf(0) }, RelatedFaceRsp.class);
  public final PBInt32Field img_num = PBField.initInt32(0);
  public final PBRepeatMessageField<oidb_0xe9c.ImgInfo> rpt_img_info = PBField.initRepeatMessage(oidb_0xe9c.ImgInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0xe9c.oidb_0xe9c.RelatedFaceRsp
 * JD-Core Version:    0.7.0.1
 */