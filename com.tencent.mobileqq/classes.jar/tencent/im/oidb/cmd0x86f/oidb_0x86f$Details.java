package tencent.im.oidb.cmd0x86f;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import nearby_interact_state.interact_value.FreshThing;
import nearby_interact_state.interact_value.Tribe;

public final class oidb_0x86f$Details
  extends MessageMicro<Details>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_back_color2 = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_back_color3 = PBField.initBytes(ByteStringMicro.EMPTY);
  public oidb_0x86f.CommonDetails msg_common_details = new oidb_0x86f.CommonDetails();
  public interact_value.FreshThing msg_fresh_thing = new interact_value.FreshThing();
  public interact_value.Tribe msg_tribe = new interact_value.Tribe();
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42 }, new String[] { "msg_common_details", "msg_tribe", "msg_fresh_thing", "bytes_back_color2", "bytes_back_color3" }, new Object[] { null, null, null, localByteStringMicro1, localByteStringMicro2 }, Details.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0x86f.oidb_0x86f.Details
 * JD-Core Version:    0.7.0.1
 */