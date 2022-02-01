package com.trunk.Qworkflow;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class Qworkflow$ContentElement
  extends MessageMicro<ContentElement>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_userdef = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatMessageField<Qworkflow.OrdinaryFile> rpt_file_list = PBField.initRepeatMessage(Qworkflow.OrdinaryFile.class);
  public final PBRepeatMessageField<Qworkflow.Picture> rpt_picture_list = PBField.initRepeatMessage(Qworkflow.Picture.class);
  public final PBRepeatMessageField<Qworkflow.Text> rpt_text_list = PBField.initRepeatMessage(Qworkflow.Text.class);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "rpt_text_list", "rpt_file_list", "rpt_picture_list", "bytes_userdef" }, new Object[] { null, null, null, localByteStringMicro }, ContentElement.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.trunk.Qworkflow.Qworkflow.ContentElement
 * JD-Core Version:    0.7.0.1
 */