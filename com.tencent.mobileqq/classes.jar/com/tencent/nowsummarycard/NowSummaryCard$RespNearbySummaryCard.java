package com.tencent.nowsummarycard;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class NowSummaryCard$RespNearbySummaryCard
  extends MessageMicro<RespNearbySummaryCard>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt32Field age = PBField.initInt32(0);
  public final PBInt64Field birthday = PBField.initInt64(0L);
  public final PBUInt64Field chat_id = PBField.initUInt64(0L);
  public final PBStringField city = PBField.initString("");
  public final PBBytesField common_label = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBStringField company = PBField.initString("");
  public final PBInt32Field constellation = PBField.initInt32(0);
  public final PBBytesField date_face = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBStringField distance = PBField.initString("");
  public final PBStringField elapse = PBField.initString("");
  public final PBUInt64Field gender = PBField.initUInt64(0L);
  public NowSummaryCard.GiftInfo gift_info = new NowSummaryCard.GiftInfo();
  public final PBUInt32Field home_city = PBField.initUInt32(0);
  public final PBUInt32Field home_country = PBField.initUInt32(0);
  public final PBUInt32Field home_province = PBField.initUInt32(0);
  public final PBUInt32Field home_zone = PBField.initUInt32(0);
  public final PBInt32Field iFace = PBField.initInt32(0);
  public NowSummaryCard.InterestTagInfo interest_tag = new NowSummaryCard.InterestTagInfo();
  public final PBUInt32Field is_friend = PBField.initUInt32(0);
  public final PBInt32Field marriage = PBField.initInt32(0);
  public final PBBytesField nearby_info = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField nearby_task_info = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBStringField nick = PBField.initString("");
  public final PBBytesField now_info = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field profession = PBField.initUInt32(0);
  public final PBStringField province = PBField.initString("");
  public final PBStringField remark = PBField.initString("");
  public final PBBytesField rich_sign = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBStringField school = PBField.initString("");
  public final PBUInt64Field school_id = PBField.initUInt64(0L);
  public final PBStringField sign = PBField.initString("");
  public final PBBytesField temp_chat_sig = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt64Field tiny_id = PBField.initUInt64(0L);
  public final PBUInt64Field uin = PBField.initUInt64(0L);
  public NowSummaryCard.VoteInfo vote_info = new NowSummaryCard.VoteInfo();
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro6 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro7 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42, 50, 58, 66, 72, 80, 90, 98, 104, 112, 120, 130, 138, 144, 152, 160, 168, 178, 186, 194, 202, 210, 216, 226, 234, 240, 250, 258, 266, 272, 280 }, new String[] { "iFace", "uin", "age", "nick", "remark", "province", "city", "sign", "constellation", "profession", "company", "school", "home_country", "home_province", "home_city", "distance", "elapse", "marriage", "home_zone", "tiny_id", "school_id", "nearby_task_info", "now_info", "common_label", "nearby_info", "date_face", "birthday", "rich_sign", "temp_chat_sig", "gender", "interest_tag", "gift_info", "vote_info", "is_friend", "chat_id" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), "", "", "", "", "", Integer.valueOf(0), Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, localByteStringMicro5, Long.valueOf(0L), localByteStringMicro6, localByteStringMicro7, Long.valueOf(0L), null, null, null, Integer.valueOf(0), Long.valueOf(0L) }, RespNearbySummaryCard.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.nowsummarycard.NowSummaryCard.RespNearbySummaryCard
 * JD-Core Version:    0.7.0.1
 */