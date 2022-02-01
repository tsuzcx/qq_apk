package com.tencent.mobileqq.highway.protocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class CSDataHighwayHead$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "msg_query_hole_rsp" }, new Object[] { null }, RspBody.class);
  public CSDataHighwayHead.QueryHoleRsp msg_query_hole_rsp = new CSDataHighwayHead.QueryHoleRsp();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.highway.protocol.CSDataHighwayHead.RspBody
 * JD-Core Version:    0.7.0.1
 */