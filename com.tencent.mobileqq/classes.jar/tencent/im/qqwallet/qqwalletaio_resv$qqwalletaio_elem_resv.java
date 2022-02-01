package tencent.im.qqwallet;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class qqwalletaio_resv$qqwalletaio_elem_resv
  extends MessageMicro<qqwalletaio_elem_resv>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_idiom_alpha = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_subject_image = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBInt32Field int32_special_pop_id = PBField.initInt32(0);
  public final PBRepeatMessageField<qqwalletaio_resv.Payer> rpt_payer = PBField.initRepeatMessage(qqwalletaio_resv.Payer.class);
  public final PBUInt32Field sound_record_duration = PBField.initUInt32(0);
  public final PBBytesField transaction_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_effects_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_hb_from = PBField.initUInt32(0);
  public final PBUInt32Field uint32_resource_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_skin_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_song_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_song_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_subjectid = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 40, 48, 56, 66, 72, 80, 88, 96, 106 }, new String[] { "bytes_subject_image", "transaction_id", "sound_record_duration", "uint32_resource_type", "uint32_skin_id", "uint32_effects_id", "int32_special_pop_id", "rpt_payer", "uint32_subjectid", "uint32_hb_from", "uint32_song_id", "uint32_song_flag", "bytes_idiom_alpha" }, new Object[] { localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro3 }, qqwalletaio_elem_resv.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.qqwallet.qqwalletaio_resv.qqwalletaio_elem_resv
 * JD-Core Version:    0.7.0.1
 */