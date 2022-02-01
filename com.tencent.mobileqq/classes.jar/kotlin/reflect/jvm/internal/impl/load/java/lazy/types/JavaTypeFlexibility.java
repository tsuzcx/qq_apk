package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

public enum JavaTypeFlexibility
{
  static
  {
    JavaTypeFlexibility localJavaTypeFlexibility1 = new JavaTypeFlexibility("INFLEXIBLE", 0);
    INFLEXIBLE = localJavaTypeFlexibility1;
    JavaTypeFlexibility localJavaTypeFlexibility2 = new JavaTypeFlexibility("FLEXIBLE_UPPER_BOUND", 1);
    FLEXIBLE_UPPER_BOUND = localJavaTypeFlexibility2;
    JavaTypeFlexibility localJavaTypeFlexibility3 = new JavaTypeFlexibility("FLEXIBLE_LOWER_BOUND", 2);
    FLEXIBLE_LOWER_BOUND = localJavaTypeFlexibility3;
    $VALUES = new JavaTypeFlexibility[] { localJavaTypeFlexibility1, localJavaTypeFlexibility2, localJavaTypeFlexibility3 };
  }
  
  private JavaTypeFlexibility() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeFlexibility
 * JD-Core Version:    0.7.0.1
 */