package tencent.im.oidb.cmd0x489;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class oidb_0x489$DelBlockRsp
  extends MessageMicro<DelBlockRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "msg_one_block_data" }, new Object[] { null }, DelBlockRsp.class);
  public oidb_0x489.OneDelBlockData msg_one_block_data = new oidb_0x489.OneDelBlockData();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.cmd0x489.oidb_0x489.DelBlockRsp
 * JD-Core Version:    0.7.0.1
 */