class onb
{
  final String jdField_a_of_type_JavaLangString;
  final boolean jdField_a_of_type_Boolean;
  boolean b;
  
  onb(boolean paramBoolean, String paramString)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  static onb a()
  {
    return new onb(false, "");
  }
  
  static onb a(Process paramProcess)
  {
    if (a(Integer.valueOf(paramProcess.exitValue()))) {}
    for (String str = ono.a(paramProcess.getInputStream());; str = ono.a(paramProcess.getErrorStream())) {
      return new onb(a(Integer.valueOf(paramProcess.exitValue())), str);
    }
  }
  
  static boolean a(Integer paramInteger)
  {
    return (paramInteger != null) && (paramInteger.intValue() == 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     onb
 * JD-Core Version:    0.7.0.1
 */