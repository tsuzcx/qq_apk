package tencent.im.oidb.cmd0x8dd;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class oidb_0x8dd$CkvValue
  extends MessageMicro<CkvValue>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "msg_people_cache", "msg_anchor_cache" }, new Object[] { null, null }, CkvValue.class);
  public oidb_0x8dd.AnchorCache msg_anchor_cache = new oidb_0x8dd.AnchorCache();
  public oidb_0x8dd.PeopleCache msg_people_cache = new oidb_0x8dd.PeopleCache();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0x8dd.oidb_0x8dd.CkvValue
 * JD-Core Version:    0.7.0.1
 */