package dov.com.qq.im.ae.download.old;

class AEOldShortVideoSoManager$CfgParser
{
  private String jdField_a_of_type_JavaLangString;
  private String[] jdField_a_of_type_ArrayOfJavaLangString;
  
  AEOldShortVideoSoManager$CfgParser(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  int a()
  {
    if ((this.jdField_a_of_type_JavaLangString == null) || ("".equals(this.jdField_a_of_type_JavaLangString))) {
      return -3;
    }
    this.jdField_a_of_type_ArrayOfJavaLangString = this.jdField_a_of_type_JavaLangString.split("\\_");
    if (this.jdField_a_of_type_ArrayOfJavaLangString == null) {
      return -1;
    }
    if (this.jdField_a_of_type_ArrayOfJavaLangString.length < 2) {
      return -2;
    }
    return 0;
  }
  
  int a(char paramChar)
  {
    if ((this.jdField_a_of_type_JavaLangString == null) || ("".equals(this.jdField_a_of_type_JavaLangString))) {
      return -3;
    }
    this.jdField_a_of_type_ArrayOfJavaLangString = this.jdField_a_of_type_JavaLangString.split("\\" + paramChar);
    if (this.jdField_a_of_type_ArrayOfJavaLangString == null) {
      return -1;
    }
    if (this.jdField_a_of_type_ArrayOfJavaLangString.length < 2) {
      return -2;
    }
    return 0;
  }
  
  String a()
  {
    return this.jdField_a_of_type_ArrayOfJavaLangString[1].trim();
  }
  
  String b()
  {
    return this.jdField_a_of_type_ArrayOfJavaLangString[0].trim();
  }
  
  String c()
  {
    return this.jdField_a_of_type_ArrayOfJavaLangString[1].trim();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.download.old.AEOldShortVideoSoManager.CfgParser
 * JD-Core Version:    0.7.0.1
 */