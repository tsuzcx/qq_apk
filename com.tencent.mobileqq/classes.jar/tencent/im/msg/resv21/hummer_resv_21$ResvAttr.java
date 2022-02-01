package tencent.im.msg.resv21;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class hummer_resv_21$ResvAttr
  extends MessageMicro<ResvAttr>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 42 }, new String[] { "file_image_info", "forward_ext_file_info", "file_apk_info", "device_type", "file_assist_info" }, new Object[] { null, null, null, Integer.valueOf(0), null }, ResvAttr.class);
  public final PBUInt32Field device_type = PBField.initUInt32(0);
  public hummer_resv_21.FileApkInfo file_apk_info = new hummer_resv_21.FileApkInfo();
  public hummer_resv_21.FileAssitInfo file_assist_info = new hummer_resv_21.FileAssitInfo();
  public hummer_resv_21.FileImgInfo file_image_info = new hummer_resv_21.FileImgInfo();
  public hummer_resv_21.ForwardExtFileInfo forward_ext_file_info = new hummer_resv_21.ForwardExtFileInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.msg.resv21.hummer_resv_21.ResvAttr
 * JD-Core Version:    0.7.0.1
 */