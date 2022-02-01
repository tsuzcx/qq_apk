package com.tencent.pb.vas.uni_gray_tip;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class UniGrayTip$UniAIOTipsRsp
  extends MessageMicro<UniAIOTipsRsp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField exInfo = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBStringField msg = PBField.initString("");
  public final PBInt64Field ret = PBField.initInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "ret", "msg", "exInfo" }, new Object[] { Long.valueOf(0L), "", localByteStringMicro }, UniAIOTipsRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.pb.vas.uni_gray_tip.UniGrayTip.UniAIOTipsRsp
 * JD-Core Version:    0.7.0.1
 */