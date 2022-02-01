package com.tencent.pb.profilecard;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class VaProfileGate$PrivilegeInfo
  extends MessageMicro<PrivilegeInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt32Field iFeeType = PBField.initInt32(0);
  public final PBInt32Field iFlag = PBField.initInt32(0);
  public final PBInt32Field iIsBig = PBField.initInt32(0);
  public final PBInt32Field iIsRemind = PBField.initInt32(0);
  public final PBInt32Field iLevel = PBField.initInt32(0);
  public final PBUInt32Field iRemindTime = PBField.initUInt32(0);
  public final PBInt32Field iSort = PBField.initInt32(0);
  public final PBUInt32Field iTipsTimes = PBField.initUInt32(0);
  public final PBInt32Field iType = PBField.initInt32(0);
  public final PBBytesField strDeluxeIconUrl = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField strIconUrl = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField strJumpUrl = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBStringField strTipsIconUrl = PBField.initString("");
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 50, 58, 66, 72, 80, 88, 98, 104 }, new String[] { "iType", "iSort", "iFeeType", "iLevel", "iFlag", "strIconUrl", "strDeluxeIconUrl", "strJumpUrl", "iIsBig", "iIsRemind", "iRemindTime", "strTipsIconUrl", "iTipsTimes" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0) }, PrivilegeInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.pb.profilecard.VaProfileGate.PrivilegeInfo
 * JD-Core Version:    0.7.0.1
 */