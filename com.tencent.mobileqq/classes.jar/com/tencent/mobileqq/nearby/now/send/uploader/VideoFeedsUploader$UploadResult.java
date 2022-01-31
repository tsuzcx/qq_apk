package com.tencent.mobileqq.nearby.now.send.uploader;

public class VideoFeedsUploader$UploadResult
{
  public int a;
  public long a;
  public String a;
  public int b;
  public long b;
  public String b;
  public int c;
  public long c;
  public String c;
  public int d;
  public long d;
  public String d;
  public int e;
  public long e;
  public String e;
  public long f;
  public String f;
  public long g;
  public String g;
  public String h;
  public String i;
  
  public VideoFeedsUploader$UploadResult()
  {
    this.jdField_a_of_type_JavaLangString = "";
    a();
  }
  
  public VideoFeedsUploader$UploadResult(UploadResult paramUploadResult)
  {
    this.jdField_a_of_type_JavaLangString = "";
    if (paramUploadResult == null)
    {
      a();
      return;
    }
    this.jdField_a_of_type_JavaLangString = paramUploadResult.jdField_a_of_type_JavaLangString;
    this.jdField_a_of_type_Int = paramUploadResult.jdField_a_of_type_Int;
    this.jdField_b_of_type_Int = paramUploadResult.jdField_b_of_type_Int;
    this.jdField_c_of_type_Int = paramUploadResult.jdField_c_of_type_Int;
    this.jdField_d_of_type_Int = paramUploadResult.jdField_d_of_type_Int;
    this.jdField_a_of_type_Long = paramUploadResult.jdField_a_of_type_Long;
    this.jdField_b_of_type_Long = paramUploadResult.jdField_b_of_type_Long;
    if (paramUploadResult.jdField_b_of_type_JavaLangString == null)
    {
      str = "";
      this.jdField_b_of_type_JavaLangString = str;
      if (paramUploadResult.jdField_c_of_type_JavaLangString != null) {
        break label285;
      }
      str = "";
      label100:
      this.jdField_c_of_type_JavaLangString = new String(str);
      if (paramUploadResult.jdField_d_of_type_JavaLangString != null) {
        break label293;
      }
      str = "";
      label122:
      this.jdField_d_of_type_JavaLangString = new String(str);
      if (paramUploadResult.jdField_e_of_type_JavaLangString != null) {
        break label301;
      }
      str = "";
      label144:
      this.jdField_e_of_type_JavaLangString = new String(str);
      if (paramUploadResult.jdField_f_of_type_JavaLangString != null) {
        break label309;
      }
      str = "";
      label166:
      this.jdField_f_of_type_JavaLangString = new String(str);
      if (paramUploadResult.jdField_g_of_type_JavaLangString != null) {
        break label317;
      }
      str = "";
      label188:
      this.jdField_g_of_type_JavaLangString = new String(str);
      if (paramUploadResult.h != null) {
        break label325;
      }
      str = "";
      label210:
      this.h = new String(str);
      if (paramUploadResult.i != null) {
        break label333;
      }
    }
    label285:
    label293:
    label301:
    label309:
    label317:
    label325:
    label333:
    for (String str = "";; str = paramUploadResult.i)
    {
      this.i = new String(str);
      this.jdField_e_of_type_Long = paramUploadResult.jdField_e_of_type_Long;
      this.jdField_f_of_type_Long = paramUploadResult.jdField_f_of_type_Long;
      this.jdField_e_of_type_Int = paramUploadResult.jdField_e_of_type_Int;
      this.jdField_g_of_type_Long = paramUploadResult.jdField_g_of_type_Long;
      return;
      str = paramUploadResult.jdField_b_of_type_JavaLangString;
      break;
      str = paramUploadResult.jdField_c_of_type_JavaLangString;
      break label100;
      str = paramUploadResult.jdField_d_of_type_JavaLangString;
      break label122;
      str = paramUploadResult.jdField_e_of_type_JavaLangString;
      break label144;
      str = paramUploadResult.jdField_f_of_type_JavaLangString;
      break label166;
      str = paramUploadResult.jdField_g_of_type_JavaLangString;
      break label188;
      str = paramUploadResult.h;
      break label210;
    }
  }
  
  public String a()
  {
    String str = "errorCode=" + this.jdField_a_of_type_Int;
    str = str + ";flowStep=" + this.jdField_b_of_type_Int;
    str = str + ";errorMsg=" + this.i;
    str = str + ";videoCreatedSeq=" + this.jdField_a_of_type_Long;
    str = str + ";networkErrorCode=" + this.jdField_c_of_type_Int;
    str = str + ";logoErrorCode=" + this.jdField_d_of_type_Int;
    str = str + ";fileId=" + this.jdField_c_of_type_JavaLangString;
    str = str + ";feedId=" + this.jdField_d_of_type_JavaLangString;
    str = str + ";logoUrl=" + this.jdField_e_of_type_JavaLangString;
    str = str + ";doodlePicUrl=" + this.jdField_f_of_type_JavaLangString;
    str = str + ";videoUrl=" + this.jdField_g_of_type_JavaLangString;
    return str + ";autoRetryTotalNum=" + this.jdField_e_of_type_Int;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = -1;
    this.jdField_c_of_type_Int = 0;
    this.jdField_d_of_type_Int = 0;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_e_of_type_Int = 0;
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_d_of_type_JavaLangString = "";
    this.jdField_e_of_type_JavaLangString = "";
    this.jdField_f_of_type_JavaLangString = "";
    this.jdField_g_of_type_JavaLangString = "";
    this.jdField_e_of_type_JavaLangString = "";
    this.i = "";
    this.jdField_f_of_type_Long = 0L;
    this.jdField_g_of_type_Long = 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.send.uploader.VideoFeedsUploader.UploadResult
 * JD-Core Version:    0.7.0.1
 */