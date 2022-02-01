package tencent.im.oidb.cmd0xeac;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0xeac$MsgElem
  extends MessageMicro<MsgElem>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 90, 98, 106, 114, 122, 130, 138 }, new String[] { "msg_type", "text_msg", "face_msg", "image_msg", "group_file_msg", "share_msg", "rich_msg", "ark_msg" }, new Object[] { Integer.valueOf(0), null, null, null, null, null, null, null }, MsgElem.class);
  public oidb_0xeac.ArkMsg ark_msg = new oidb_0xeac.ArkMsg();
  public oidb_0xeac.FaceMsg face_msg = new oidb_0xeac.FaceMsg();
  public oidb_0xeac.GroupFileMsg group_file_msg = new oidb_0xeac.GroupFileMsg();
  public oidb_0xeac.ImageMsg image_msg = new oidb_0xeac.ImageMsg();
  public final PBUInt32Field msg_type = PBField.initUInt32(0);
  public oidb_0xeac.RichMsg rich_msg = new oidb_0xeac.RichMsg();
  public oidb_0xeac.ShareMsg share_msg = new oidb_0xeac.ShareMsg();
  public oidb_0xeac.TextMsg text_msg = new oidb_0xeac.TextMsg();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0xeac.oidb_0xeac.MsgElem
 * JD-Core Version:    0.7.0.1
 */