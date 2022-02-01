package tencent.im.oidb.cmd0x9ab;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class oidb_0x9ab$RspBody
  extends MessageMicro<RspBody>
{
  public static final int ITEM_FIELD_NUMBER = 2;
  public static final int LIST_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "list", "item" }, new Object[] { null, null }, RspBody.class);
  public oidb_0x9ab.TabItem item = new oidb_0x9ab.TabItem();
  public oidb_0x9ab.GroupTabList list = new oidb_0x9ab.GroupTabList();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.cmd0x9ab.oidb_0x9ab.RspBody
 * JD-Core Version:    0.7.0.1
 */