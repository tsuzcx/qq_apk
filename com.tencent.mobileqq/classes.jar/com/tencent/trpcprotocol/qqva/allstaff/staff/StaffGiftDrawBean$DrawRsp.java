package com.tencent.trpcprotocol.qqva.allstaff.staff;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class StaffGiftDrawBean$DrawRsp
  extends MessageMicro<DrawRsp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt32Field FreeCoins = PBField.initInt32(0);
  public final PBStringField GiftName = PBField.initString("");
  public final PBStringField Msg = PBField.initString("");
  public final PBInt32Field RetCode = PBField.initInt32(0);
  public final PBEnumField state = PBField.initEnum(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 42 }, new String[] { "RetCode", "Msg", "state", "FreeCoins", "GiftName" }, new Object[] { localInteger, "", localInteger, localInteger, "" }, DrawRsp.class);
  }
  
  public boolean isAlreadyDraw()
  {
    return this.RetCode.get() == -2992;
  }
  
  public boolean isNotRemained()
  {
    return this.RetCode.get() == -2997;
  }
  
  public boolean isNotValid()
  {
    return this.RetCode.get() == -3000;
  }
  
  public boolean isPumpCoin()
  {
    return (isWin()) && (this.state.get() == 3);
  }
  
  public boolean isPumpGift()
  {
    return (isWin()) && (this.state.get() == 4);
  }
  
  public boolean isWin()
  {
    return this.RetCode.get() == 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.trpcprotocol.qqva.allstaff.staff.StaffGiftDrawBean.DrawRsp
 * JD-Core Version:    0.7.0.1
 */