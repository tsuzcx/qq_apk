package tencent.im.oidb.cmd0xf4d;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class oidb_0xf4d$DanmuDetail
  extends MessageMicro<DanmuDetail>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "danmu_base_info", "post_account_info", "danmu_like_info" }, new Object[] { null, null, null }, DanmuDetail.class);
  public oidb_0xf4d.DanmuBaseInfo danmu_base_info = new oidb_0xf4d.DanmuBaseInfo();
  public oidb_0xf4d.DanmuLikeInfo danmu_like_info = new oidb_0xf4d.DanmuLikeInfo();
  public oidb_0xf4d.PostAccountInfo post_account_info = new oidb_0xf4d.PostAccountInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xf4d.oidb_0xf4d.DanmuDetail
 * JD-Core Version:    0.7.0.1
 */