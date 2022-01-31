package tencent.im.msg.hummer.servtype;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class hummer_commelem$StoryAioObjMsg
  extends MessageMicro<StoryAioObjMsg>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "str_ui_url", "str_jmp_url" }, new Object[] { "", "" }, StoryAioObjMsg.class);
  public final PBStringField str_jmp_url = PBField.initString("");
  public final PBStringField str_ui_url = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.msg.hummer.servtype.hummer_commelem.StoryAioObjMsg
 * JD-Core Version:    0.7.0.1
 */