package tencent.im.oidb.cmd0xd46;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

public final class oidb_cmd0xd46$KsGetSubscribedListRsp
  extends MessageMicro<KsGetSubscribedListRsp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_ks_subscribed_list = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "bytes_ks_subscribed_list" }, new Object[] { localByteStringMicro }, KsGetSubscribedListRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.cmd0xd46.oidb_cmd0xd46.KsGetSubscribedListRsp
 * JD-Core Version:    0.7.0.1
 */