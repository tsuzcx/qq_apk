package com.tencent.mobileqq.uftransfer.task.upload;

import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferUploaderRp;

public class UFTUploadTaskCompParam
{
  public long a;
  public Object a;
  public final String a;
  public boolean a;
  public long b;
  public String b;
  public final int h;
  
  public UFTUploadTaskCompParam(int paramInt, String paramString)
  {
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Long = 0L;
    this.h = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public UFTUploadTaskCompParam(int paramInt, String paramString1, String paramString2, boolean paramBoolean, Object paramObject)
  {
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Long = 0L;
    this.h = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_JavaLangObject = paramObject;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public ExcitingTransferUploaderRp a()
  {
    Object localObject = this.jdField_a_of_type_JavaLangObject;
    if ((localObject != null) && ((localObject instanceof ExcitingTransferUploaderRp))) {
      return (ExcitingTransferUploaderRp)localObject;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.task.upload.UFTUploadTaskCompParam
 * JD-Core Version:    0.7.0.1
 */