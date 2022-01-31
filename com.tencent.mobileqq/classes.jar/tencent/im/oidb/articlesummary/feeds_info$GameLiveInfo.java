package tencent.im.oidb.articlesummary;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class feeds_info$GameLiveInfo
  extends MessageMicro<GameLiveInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_game_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_play_bill_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_play_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_status = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_status_icon_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_tips_wording = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_audience_count = PBField.initUInt32(0);
  public final PBUInt32Field uint32_status = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro6 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34, 42, 50, 58, 66 }, new String[] { "bytes_play_bill_id", "uint32_status", "uint32_audience_count", "bytes_play_url", "bytes_game_name", "bytes_tips_wording", "bytes_status", "bytes_status_icon_url" }, new Object[] { localByteStringMicro1, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, localByteStringMicro5, localByteStringMicro6 }, GameLiveInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.articlesummary.feeds_info.GameLiveInfo
 * JD-Core Version:    0.7.0.1
 */