package com.tencent.pb.vas.uni_gray_tip;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class UniGrayTip$UniAIOTipsReq
  extends MessageMicro<UniAIOTipsReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt32Field cmd = PBField.initInt32(0);
  public final PBBytesField exInfo = PBField.initBytes(ByteStringMicro.EMPTY);
  public UniGrayTip.FromChannel from = new UniGrayTip.FromChannel();
  public UniGrayTip.PlatformComm platInfo = new UniGrayTip.PlatformComm();
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34 }, new String[] { "cmd", "from", "platInfo", "exInfo" }, new Object[] { Integer.valueOf(0), null, null, localByteStringMicro }, UniAIOTipsReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.pb.vas.uni_gray_tip.UniGrayTip.UniAIOTipsReq
 * JD-Core Version:    0.7.0.1
 */