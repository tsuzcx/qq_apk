package tencent.im.msg.hummer.servtype;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class hummer_commelem$MsgElemInfo_servtype4
  extends MessageMicro<MsgElemInfo_servtype4>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 34 }, new String[] { "uint32_imsg_type", "st_story_aio_obj_msg" }, new Object[] { Integer.valueOf(0), null }, MsgElemInfo_servtype4.class);
  public hummer_commelem.StoryAioObjMsg st_story_aio_obj_msg = new hummer_commelem.StoryAioObjMsg();
  public final PBUInt32Field uint32_imsg_type = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype4
 * JD-Core Version:    0.7.0.1
 */