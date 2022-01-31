package com.tencent.pb.apollo;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class STCheckGame$STAVCtrlParamRsp
  extends MessageMicro<STAVCtrlParamRsp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField ctrlParam = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field svrVer = PBField.initUInt32(0);
  public final PBUInt32Field updateFlag = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "updateFlag", "svrVer", "ctrlParam" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro }, STAVCtrlParamRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.pb.apollo.STCheckGame.STAVCtrlParamRsp
 * JD-Core Version:    0.7.0.1
 */