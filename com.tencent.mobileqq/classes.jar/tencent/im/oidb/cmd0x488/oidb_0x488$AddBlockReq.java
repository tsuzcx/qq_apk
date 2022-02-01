package tencent.im.oidb.cmd0x488;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class oidb_0x488$AddBlockReq
  extends MessageMicro<AddBlockReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "msg_one_block_data" }, new Object[] { null }, AddBlockReq.class);
  public oidb_0x488.OneAddBlockData msg_one_block_data = new oidb_0x488.OneAddBlockData();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0x488.oidb_0x488.AddBlockReq
 * JD-Core Version:    0.7.0.1
 */