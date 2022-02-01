package com.tencent.pb.apollo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class GetTinyID$STTinyID2UserAccInfoRsp
  extends MessageMicro<STTinyID2UserAccInfoRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "user_acc_info" }, new Object[] { null }, STTinyID2UserAccInfoRsp.class);
  public final PBRepeatMessageField<GetTinyID.STUserAccInfo> user_acc_info = PBField.initRepeatMessage(GetTinyID.STUserAccInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.pb.apollo.GetTinyID.STTinyID2UserAccInfoRsp
 * JD-Core Version:    0.7.0.1
 */