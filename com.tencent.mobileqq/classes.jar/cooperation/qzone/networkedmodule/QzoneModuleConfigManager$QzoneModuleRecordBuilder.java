package cooperation.qzone.networkedmodule;

import android.text.TextUtils;

public class QzoneModuleConfigManager$QzoneModuleRecordBuilder
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private QzoneModuleConfigManager.QzoneModuleRecord jdField_a_of_type_CooperationQzoneNetworkedmoduleQzoneModuleConfigManager$QzoneModuleRecord;
  private String jdField_a_of_type_JavaLangString;
  private String b;
  private String c;
  private String d;
  private String e = "";
  private String f = "";
  private String g;
  
  public QzoneModuleConfigManager.QzoneModuleRecord a()
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      throw new IllegalArgumentException("moduleId can not be null");
    }
    return new QzoneModuleConfigManager.QzoneModuleRecord(this.jdField_a_of_type_JavaLangString, this.b, this.c, this.d, this.e, this.f, this.g, this.jdField_a_of_type_Int, this.jdField_a_of_type_Long, this.jdField_a_of_type_CooperationQzoneNetworkedmoduleQzoneModuleConfigManager$QzoneModuleRecord);
  }
  
  public QzoneModuleRecordBuilder a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    return this;
  }
  
  public QzoneModuleRecordBuilder a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
    return this;
  }
  
  public QzoneModuleRecordBuilder a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    return this;
  }
  
  public QzoneModuleRecordBuilder b(String paramString)
  {
    this.b = paramString;
    return this;
  }
  
  public QzoneModuleRecordBuilder c(String paramString)
  {
    this.c = paramString;
    return this;
  }
  
  public QzoneModuleRecordBuilder d(String paramString)
  {
    this.d = paramString;
    return this;
  }
  
  public QzoneModuleRecordBuilder e(String paramString)
  {
    this.e = paramString;
    return this;
  }
  
  public QzoneModuleRecordBuilder f(String paramString)
  {
    this.f = paramString;
    return this;
  }
  
  public QzoneModuleRecordBuilder g(String paramString)
  {
    this.g = paramString;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     cooperation.qzone.networkedmodule.QzoneModuleConfigManager.QzoneModuleRecordBuilder
 * JD-Core Version:    0.7.0.1
 */