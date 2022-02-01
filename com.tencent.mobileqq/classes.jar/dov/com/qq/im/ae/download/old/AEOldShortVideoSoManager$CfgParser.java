package dov.com.qq.im.ae.download.old;

public class AEOldShortVideoSoManager$CfgParser
{
  private String jdField_a_of_type_JavaLangString;
  private String[] jdField_a_of_type_ArrayOfJavaLangString;
  
  AEOldShortVideoSoManager$CfgParser(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public int a()
  {
    Object localObject = this.jdField_a_of_type_JavaLangString;
    if ((localObject != null) && (!"".equals(localObject)))
    {
      this.jdField_a_of_type_ArrayOfJavaLangString = this.jdField_a_of_type_JavaLangString.split("\\_");
      localObject = this.jdField_a_of_type_ArrayOfJavaLangString;
      if (localObject == null) {
        return -1;
      }
      if (localObject.length < 2) {
        return -2;
      }
      return 0;
    }
    return -3;
  }
  
  public int a(char paramChar)
  {
    Object localObject = this.jdField_a_of_type_JavaLangString;
    if ((localObject != null) && (!"".equals(localObject)))
    {
      localObject = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("\\");
      localStringBuilder.append(paramChar);
      this.jdField_a_of_type_ArrayOfJavaLangString = ((String)localObject).split(localStringBuilder.toString());
      localObject = this.jdField_a_of_type_ArrayOfJavaLangString;
      if (localObject == null) {
        return -1;
      }
      if (localObject.length < 2) {
        return -2;
      }
      return 0;
    }
    return -3;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_ArrayOfJavaLangString[1].trim();
  }
  
  public String b()
  {
    return this.jdField_a_of_type_ArrayOfJavaLangString[0].trim();
  }
  
  public String c()
  {
    return this.jdField_a_of_type_ArrayOfJavaLangString[1].trim();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.download.old.AEOldShortVideoSoManager.CfgParser
 * JD-Core Version:    0.7.0.1
 */