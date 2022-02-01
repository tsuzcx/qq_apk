package dov.com.tencent.mobileqq.shortvideo;

public class ShortVideoUploadInfo
  extends ShortVideoBaseInfo
{
  public ShortVideoUploadInfo.RetryInfo a;
  public Object a;
  public boolean b = true;
  public int c;
  public boolean c;
  public int d;
  public boolean d;
  public int e;
  public boolean e;
  public int f;
  public boolean f;
  public int g;
  public boolean g = true;
  public int h;
  public String h;
  public boolean h;
  public int i;
  public String i;
  public String j;
  public String k;
  
  public ShortVideoUploadInfo()
  {
    this.jdField_e_of_type_Boolean = false;
    this.jdField_f_of_type_Boolean = false;
    this.jdField_h_of_type_Boolean = false;
  }
  
  public String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("\nShortVideoUploadInfo");
    localStringBuilder.append("\n |-").append("localPath:").append(this.jdField_h_of_type_JavaLangString);
    localStringBuilder.append("\n |-").append("md5:").append(this.jdField_e_of_type_JavaLangString);
    localStringBuilder.append("\n |-").append("thumbPath:").append(this.jdField_i_of_type_JavaLangString);
    localStringBuilder.append("\n |-").append("thumbWidth:").append(this.jdField_c_of_type_Int);
    localStringBuilder.append("\n |-").append("thumbHeight:").append(this.d);
    localStringBuilder.append("\n |-").append("sendSizeSpec:").append(this.jdField_e_of_type_Int);
    localStringBuilder.append("\n |-").append("fileTime:").append(this.jdField_f_of_type_Int);
    localStringBuilder.append("\n |-").append("fileSource:").append(this.k);
    localStringBuilder.append("\n |-").append("supportProgressive:").append(this.jdField_c_of_type_Boolean);
    localStringBuilder.append("\n |-").append("fileWidth:").append(this.jdField_h_of_type_Int);
    localStringBuilder.append("\n |-").append("fileHeight:").append(this.jdField_i_of_type_Int);
    localStringBuilder.append("\n |-").append("isQIM:").append(this.jdField_h_of_type_Boolean);
    return localStringBuilder.toString();
  }
  
  public boolean a()
  {
    return super.a();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a());
    localStringBuilder.append(super.toString());
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.mobileqq.shortvideo.ShortVideoUploadInfo
 * JD-Core Version:    0.7.0.1
 */