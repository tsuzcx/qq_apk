class oov
{
  final String jdField_a_of_type_JavaLangString;
  final boolean jdField_a_of_type_Boolean;
  boolean b;
  
  oov(boolean paramBoolean, String paramString)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  static oov a()
  {
    return new oov(false, "");
  }
  
  static oov a(Process paramProcess)
  {
    if (a(Integer.valueOf(paramProcess.exitValue()))) {}
    for (String str = opi.a(paramProcess.getInputStream());; str = opi.a(paramProcess.getErrorStream())) {
      return new oov(a(Integer.valueOf(paramProcess.exitValue())), str);
    }
  }
  
  static boolean a(Integer paramInteger)
  {
    return (paramInteger != null) && (paramInteger.intValue() == 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     oov
 * JD-Core Version:    0.7.0.1
 */