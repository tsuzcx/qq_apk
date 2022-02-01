package tencent.im.oidb.cmd0xd51;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class Oidb_0xd51$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field add_direction = PBField.initUInt32(0);
  public final PBUInt64Field appid = PBField.initUInt64(0L);
  public final PBBytesField bytes_aio_quick_app = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_avgame = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_boat = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_buddy = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_chat = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_close_frd = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_confidante = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_dont_forget_me = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_frd_online_status_visible_to_me = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_frd_steal_record = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_frd_tree = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_lovers = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_music_switch = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_mutualmark_alienation = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_mutualmark_score = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_my_online_status_visible_to_frd = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_my_steal_record = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_poke_friend = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_praise = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_qzone_house = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_qzone_love = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_unread_message = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_visitor_record = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBEnumField ext_sns_type = PBField.initEnum(1);
  public final PBUInt64Field frd_uin = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro6 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro7 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro8 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro9 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro10 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro11 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro12 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro13 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro14 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro15 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro16 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro17 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro18 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro19 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro20 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro21 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro22 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro23 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 88010, 168010, 248010, 328010, 408010, 488010, 568010, 648010, 728010, 808010, 888010, 968010, 1048010, 1128010, 1688010, 1768010, 1768018, 1848010, 1848018, 1848026, 1928010, 2008010, 2168010 }, new String[] { "appid", "frd_uin", "add_direction", "ext_sns_type", "bytes_lovers", "bytes_confidante", "bytes_buddy", "bytes_frd_tree", "bytes_chat", "bytes_praise", "bytes_qzone_love", "bytes_qzone_house", "bytes_music_switch", "bytes_mutualmark_alienation", "bytes_unread_message", "bytes_boat", "bytes_close_frd", "bytes_mutualmark_score", "bytes_dont_forget_me", "bytes_my_online_status_visible_to_frd", "bytes_frd_online_status_visible_to_me", "bytes_visitor_record", "bytes_frd_steal_record", "bytes_my_steal_record", "bytes_avgame", "bytes_aio_quick_app", "bytes_poke_friend" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(1), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, localByteStringMicro5, localByteStringMicro6, localByteStringMicro7, localByteStringMicro8, localByteStringMicro9, localByteStringMicro10, localByteStringMicro11, localByteStringMicro12, localByteStringMicro13, localByteStringMicro14, localByteStringMicro15, localByteStringMicro16, localByteStringMicro17, localByteStringMicro18, localByteStringMicro19, localByteStringMicro20, localByteStringMicro21, localByteStringMicro22, localByteStringMicro23 }, ReqBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xd51.Oidb_0xd51.ReqBody
 * JD-Core Version:    0.7.0.1
 */