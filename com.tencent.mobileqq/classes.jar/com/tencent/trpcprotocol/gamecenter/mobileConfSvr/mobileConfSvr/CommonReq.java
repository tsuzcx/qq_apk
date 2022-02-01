package com.tencent.trpcprotocol.gamecenter.mobileConfSvr.mobileConfSvr;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class CommonReq
  extends MessageMicro<CommonReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt32Field cpuCoreCount = PBField.initInt32(0);
  public final PBInt64Field lastPreDownloadTime = PBField.initInt64(0L);
  public final PBInt64Field lastUpdateTime = PBField.initInt64(0L);
  public final PBStringField manufacturer = PBField.initString("");
  public final PBStringField model = PBField.initString("");
  public final PBInt32Field osVersionCode = PBField.initInt32(0);
  public final PBStringField qqVersion = PBField.initString("");
  public final PBInt32Field totalMemory = PBField.initInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 40, 48, 56, 64 }, new String[] { "qqVersion", "manufacturer", "model", "osVersionCode", "totalMemory", "cpuCoreCount", "lastPreDownloadTime", "lastUpdateTime" }, new Object[] { "", "", "", localInteger, localInteger, localInteger, localLong, localLong }, CommonReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.trpcprotocol.gamecenter.mobileConfSvr.mobileConfSvr.CommonReq
 * JD-Core Version:    0.7.0.1
 */