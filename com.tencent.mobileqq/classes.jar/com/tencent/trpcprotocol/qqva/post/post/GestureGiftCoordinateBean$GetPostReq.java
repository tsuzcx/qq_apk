package com.tencent.trpcprotocol.qqva.post.post;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class GestureGiftCoordinateBean$GetPostReq
  extends MessageMicro<GetPostReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "orderNum" }, new Object[] { "" }, GetPostReq.class);
  public final PBStringField orderNum = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.trpcprotocol.qqva.post.post.GestureGiftCoordinateBean.GetPostReq
 * JD-Core Version:    0.7.0.1
 */