package com.tencent.trpcprotocol.qqva.post.post;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class GestureGiftCoordinateBean$GetPostRsp
  extends MessageMicro<GetPostRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "ret", "msg", "points" }, new Object[] { Integer.valueOf(0), "", null }, GetPostRsp.class);
  public final PBStringField msg = PBField.initString("");
  public final PBRepeatMessageField<GestureGiftCoordinateBean.Coordinate> points = PBField.initRepeatMessage(GestureGiftCoordinateBean.Coordinate.class);
  public final PBInt32Field ret = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.trpcprotocol.qqva.post.post.GestureGiftCoordinateBean.GetPostRsp
 * JD-Core Version:    0.7.0.1
 */