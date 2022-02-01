package kotlin.reflect.jvm.internal.impl.resolve.constants;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import org.jetbrains.annotations.NotNull;

public final class CharValue
  extends IntegerValueConstant<Character>
{
  public CharValue(char paramChar)
  {
    super(Character.valueOf(paramChar));
  }
  
  private final String getPrintablePart(char paramChar)
  {
    switch (paramChar)
    {
    case '\013': 
    default: 
      if (isPrintableUnicode(paramChar)) {
        return String.valueOf(paramChar);
      }
      break;
    case '\r': 
      return "\\r";
    case '\f': 
      return "\\f";
    case '\n': 
      return "\\n";
    case '\t': 
      return "\\t";
    case '\b': 
      return "\\b";
    }
    return "?";
  }
  
  private final boolean isPrintableUnicode(char paramChar)
  {
    int i = (byte)Character.getType(paramChar);
    return (i != 0) && (i != 13) && (i != 14) && (i != 15) && (i != 16) && (i != 18) && (i != 19);
  }
  
  @NotNull
  public SimpleType getType(@NotNull ModuleDescriptor paramModuleDescriptor)
  {
    Intrinsics.checkParameterIsNotNull(paramModuleDescriptor, "module");
    paramModuleDescriptor = paramModuleDescriptor.getBuiltIns().getCharType();
    Intrinsics.checkExpressionValueIsNotNull(paramModuleDescriptor, "module.builtIns.charType");
    return paramModuleDescriptor;
  }
  
  @NotNull
  public String toString()
  {
    Object localObject = new Object[2];
    localObject[0] = Integer.valueOf(((Character)getValue()).charValue());
    localObject[1] = getPrintablePart(((Character)getValue()).charValue());
    localObject = String.format("\\u%04X ('%s')", Arrays.copyOf((Object[])localObject, localObject.length));
    Intrinsics.checkExpressionValueIsNotNull(localObject, "java.lang.String.format(this, *args)");
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.resolve.constants.CharValue
 * JD-Core Version:    0.7.0.1
 */