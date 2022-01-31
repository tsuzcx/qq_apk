package tencent.im.oidb.cmd0xb2d;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import tencent.im.oidb.gallery.gallery.GalleryInfo;
import tencent.im.oidb.gallery.gallery.GalleryList;

public final class cmd0xb2d$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "msg_gallery_info", "msg_gallery_list" }, new Object[] { null, null }, RspBody.class);
  public gallery.GalleryInfo msg_gallery_info = new gallery.GalleryInfo();
  public gallery.GalleryList msg_gallery_list = new gallery.GalleryList();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.cmd0xb2d.cmd0xb2d.RspBody
 * JD-Core Version:    0.7.0.1
 */