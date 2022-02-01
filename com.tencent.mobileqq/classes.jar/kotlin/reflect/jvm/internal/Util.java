package kotlin.reflect.jvm.internal;

class Util
{
  public static Object getEnumConstantByName(Class<? extends Enum<?>> paramClass, String paramString)
  {
    return Enum.valueOf(paramClass, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.Util
 * JD-Core Version:    0.7.0.1
 */