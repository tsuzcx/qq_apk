package tencent.im.oidb.cmd0xbe0;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import tencent.im.oidb.gallery.gallery.GalleryInfo;

public final class cmd0xbe0$MoreGallery
  extends MessageMicro<MoreGallery>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_msg_gallery_info" }, new Object[] { null }, MoreGallery.class);
  public final PBRepeatMessageField<gallery.GalleryInfo> rpt_msg_gallery_info = PBField.initRepeatMessage(gallery.GalleryInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xbe0.cmd0xbe0.MoreGallery
 * JD-Core Version:    0.7.0.1
 */