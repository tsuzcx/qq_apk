package com.tencent.trpcprotocol.gift.channel_gift_list.gift_list;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class giftList$GroupGiftItem
  extends MessageMicro<GroupGiftItem>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField ArkBgImage = PBField.initString("");
  public final PBStringField BackgroundImage = PBField.initString("");
  public final PBUInt32Field GiftId = PBField.initUInt32(0);
  public final PBStringField GiftName = PBField.initString("");
  public final PBEnumField GiftType = PBField.initEnum(0);
  public final PBUInt32Field Price = PBField.initUInt32(0);
  public final PBStringField SendAnimation = PBField.initString("");
  public final PBStringField SendIosAnimation = PBField.initString("");
  public final PBStringField Thumbnail = PBField.initString("");
  public final PBEnumField dynamiclevel = PBField.initEnum(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 42, 50, 56, 66, 74, 82 }, new String[] { "GiftId", "GiftName", "GiftType", "Price", "Thumbnail", "BackgroundImage", "dynamiclevel", "SendAnimation", "ArkBgImage", "SendIosAnimation" }, new Object[] { localInteger, "", localInteger, localInteger, "", "", localInteger, "", "", "" }, GroupGiftItem.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.trpcprotocol.gift.channel_gift_list.gift_list.giftList.GroupGiftItem
 * JD-Core Version:    0.7.0.1
 */