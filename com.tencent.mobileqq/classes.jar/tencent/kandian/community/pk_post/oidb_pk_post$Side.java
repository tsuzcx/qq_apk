package tencent.kandian.community.pk_post;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class oidb_pk_post$Side
  extends MessageMicro<Side>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "string_content", "pic" }, new Object[] { "", null }, Side.class);
  public oidb_pk_post.Pic pic = new oidb_pk_post.Pic();
  public final PBStringField string_content = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.kandian.community.pk_post.oidb_pk_post.Side
 * JD-Core Version:    0.7.0.1
 */