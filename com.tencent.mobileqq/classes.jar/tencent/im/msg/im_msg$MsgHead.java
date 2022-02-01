package tencent.im.msg;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

public final class im_msg$MsgHead
  extends MessageMicro<MsgHead>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public im_msg.ContentHead content_head = new im_msg.ContentHead();
  public final PBBytesField gbk_tmp_msg_body = PBField.initBytes(ByteStringMicro.EMPTY);
  public im_msg.RoutingHead routing_head = new im_msg.RoutingHead();
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "routing_head", "content_head", "gbk_tmp_msg_body" }, new Object[] { null, null, localByteStringMicro }, MsgHead.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.msg.im_msg.MsgHead
 * JD-Core Version:    0.7.0.1
 */