package tencent.im.msg.resv21;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class hummer_resv_21$ResvAttr
  extends MessageMicro<ResvAttr>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "file_image_info", "forward_ext_file_info" }, new Object[] { null, null }, ResvAttr.class);
  public hummer_resv_21.FileImgInfo file_image_info = new hummer_resv_21.FileImgInfo();
  public hummer_resv_21.ForwardExtFileInfo forward_ext_file_info = new hummer_resv_21.ForwardExtFileInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.msg.resv21.hummer_resv_21.ResvAttr
 * JD-Core Version:    0.7.0.1
 */