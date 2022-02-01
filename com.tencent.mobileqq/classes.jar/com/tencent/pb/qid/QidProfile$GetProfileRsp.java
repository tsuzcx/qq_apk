package com.tencent.pb.qid;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class QidProfile$GetProfileRsp
  extends MessageMicro<GetProfileRsp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField imgurl = PBField.initString("");
  public final PBInt32Field qid_type = PBField.initInt32(0);
  public final PBInt32Field res_id = PBField.initInt32(0);
  public final PBStringField resource = PBField.initString("");
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 32 }, new String[] { "imgurl", "qid_type", "resource", "res_id" }, new Object[] { "", localInteger, "", localInteger }, GetProfileRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.pb.qid.QidProfile.GetProfileRsp
 * JD-Core Version:    0.7.0.1
 */