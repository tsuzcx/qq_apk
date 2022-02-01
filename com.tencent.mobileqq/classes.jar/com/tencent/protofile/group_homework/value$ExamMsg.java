package com.tencent.protofile.group_homework;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class value$ExamMsg
  extends MessageMicro<ExamMsg>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field difficulty = PBField.initUInt32(0);
  public final PBStringField difficulty_desc = PBField.initString("");
  public final PBStringField grade = PBField.initString("");
  public final PBBytesField key_point = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBStringField material_id = PBField.initString("");
  public final PBBytesField question_list = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBStringField sp_hw_id = PBField.initString("");
  public final PBUInt32Field sp_id = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 42, 50, 58, 66 }, new String[] { "sp_id", "sp_hw_id", "material_id", "difficulty", "key_point", "question_list", "difficulty_desc", "grade" }, new Object[] { Integer.valueOf(0), "", "", Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, "", "" }, ExamMsg.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.protofile.group_homework.value.ExamMsg
 * JD-Core Version:    0.7.0.1
 */