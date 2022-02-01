package com.tencent.pb.scupdate;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;

public final class SCUpdatePB$SCUpdateRsp
  extends MessageMicro<SCUpdateRsp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt32Field cmd = PBField.initInt32(0);
  public SCUpdatePB.SCUpdateRspComm comm = new SCUpdatePB.SCUpdateRspComm();
  public final PBBytesField msg = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBInt64Field ret = PBField.initInt64(0L);
  public SCUpdatePB.SyncVCRRsp rsp0x01 = new SCUpdatePB.SyncVCRRsp();
  public SCUpdatePB.GetUrlRsp rsp0x02 = new SCUpdatePB.GetUrlRsp();
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34, 42, 50 }, new String[] { "ret", "msg", "cmd", "comm", "rsp0x01", "rsp0x02" }, new Object[] { Long.valueOf(0L), localByteStringMicro, Integer.valueOf(0), null, null, null }, SCUpdateRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.pb.scupdate.SCUpdatePB.SCUpdateRsp
 * JD-Core Version:    0.7.0.1
 */