package tencent.im.oidb.gallery;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class gallery$GalleryList
  extends MessageMicro<GalleryList>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_msg_gallery_info" }, new Object[] { null }, GalleryList.class);
  public final PBRepeatMessageField<gallery.GalleryInfo> rpt_msg_gallery_info = PBField.initRepeatMessage(gallery.GalleryInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.gallery.gallery.GalleryList
 * JD-Core Version:    0.7.0.1
 */