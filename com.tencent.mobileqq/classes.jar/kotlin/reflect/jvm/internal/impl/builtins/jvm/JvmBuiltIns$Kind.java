package kotlin.reflect.jvm.internal.impl.builtins.jvm;

public enum JvmBuiltIns$Kind
{
  static
  {
    Kind localKind1 = new Kind("FROM_DEPENDENCIES", 0);
    FROM_DEPENDENCIES = localKind1;
    Kind localKind2 = new Kind("FROM_CLASS_LOADER", 1);
    FROM_CLASS_LOADER = localKind2;
    Kind localKind3 = new Kind("FALLBACK", 2);
    FALLBACK = localKind3;
    $VALUES = new Kind[] { localKind1, localKind2, localKind3 };
  }
  
  private JvmBuiltIns$Kind() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltIns.Kind
 * JD-Core Version:    0.7.0.1
 */