package com.tencent.mobileqq.wink.editor.music;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class FeedCloudCommon$Result
  extends MessageMicro<Result>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "retCode", "msg" }, new Object[] { Integer.valueOf(0), "" }, Result.class);
  public final PBStringField msg = PBField.initString("");
  public final PBInt32Field retCode = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.music.FeedCloudCommon.Result
 * JD-Core Version:    0.7.0.1
 */