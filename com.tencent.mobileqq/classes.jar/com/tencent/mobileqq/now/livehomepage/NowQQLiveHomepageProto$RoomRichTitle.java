package com.tencent.mobileqq.now.livehomepage;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class NowQQLiveHomepageProto$RoomRichTitle
  extends MessageMicro<RoomRichTitle>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "elements" }, new Object[] { null }, RoomRichTitle.class);
  public final PBRepeatMessageField<NowQQLiveHomepageProto.RichTitleElement> elements = PBField.initRepeatMessage(NowQQLiveHomepageProto.RichTitleElement.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.now.livehomepage.NowQQLiveHomepageProto.RoomRichTitle
 * JD-Core Version:    0.7.0.1
 */