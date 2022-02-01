package kotlin.reflect.jvm.internal.impl.name;

import kotlin.jvm.functions.Function1;

final class FqNameUnsafe$1
  implements Function1<String, Name>
{
  public Name invoke(String paramString)
  {
    return Name.guessByFirstCharacter(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe.1
 * JD-Core Version:    0.7.0.1
 */