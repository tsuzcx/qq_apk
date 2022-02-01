package com.tencent.mobileqq.vashealth.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class QQSportsOrbit$OrbitRsp
  extends MessageMicro<OrbitRsp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt32Field isOver = PBField.initInt32(0);
  public final PBInt32Field lastNum = PBField.initInt32(0);
  public final PBInt32Field retCode = PBField.initInt32(0);
  public QQSportsOrbit.OrbitHeader rspHeader = new QQSportsOrbit.OrbitHeader();
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34 }, new String[] { "retCode", "lastNum", "isOver", "rspHeader" }, new Object[] { localInteger, localInteger, localInteger, null }, OrbitRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vashealth.pb.QQSportsOrbit.OrbitRsp
 * JD-Core Version:    0.7.0.1
 */