package tencent.im.ilive.photo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class NowLiveGallary$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "errCode", "photo_info_list" }, new Object[] { Integer.valueOf(0), null }, RspBody.class);
  public final PBUInt32Field errCode = PBField.initUInt32(0);
  public final PBRepeatMessageField<NowLiveGallary.RspBody.PhotoInfo> photo_info_list = PBField.initRepeatMessage(NowLiveGallary.RspBody.PhotoInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.ilive.photo.NowLiveGallary.RspBody
 * JD-Core Version:    0.7.0.1
 */