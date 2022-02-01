package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

public enum TypeComponentPosition
{
  static
  {
    TypeComponentPosition localTypeComponentPosition1 = new TypeComponentPosition("FLEXIBLE_LOWER", 0);
    FLEXIBLE_LOWER = localTypeComponentPosition1;
    TypeComponentPosition localTypeComponentPosition2 = new TypeComponentPosition("FLEXIBLE_UPPER", 1);
    FLEXIBLE_UPPER = localTypeComponentPosition2;
    TypeComponentPosition localTypeComponentPosition3 = new TypeComponentPosition("INFLEXIBLE", 2);
    INFLEXIBLE = localTypeComponentPosition3;
    $VALUES = new TypeComponentPosition[] { localTypeComponentPosition1, localTypeComponentPosition2, localTypeComponentPosition3 };
  }
  
  private TypeComponentPosition() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeComponentPosition
 * JD-Core Version:    0.7.0.1
 */