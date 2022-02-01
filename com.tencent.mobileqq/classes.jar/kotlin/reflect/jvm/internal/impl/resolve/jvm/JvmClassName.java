package kotlin.reflect.jvm.internal.impl.resolve.jvm;

import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import org.jetbrains.annotations.NotNull;

public class JvmClassName
{
  private FqName fqName;
  private final String internalName;
  
  private JvmClassName(@NotNull String paramString)
  {
    this.internalName = paramString;
  }
  
  @NotNull
  public static JvmClassName byClassId(@NotNull ClassId paramClassId)
  {
    if (paramClassId == null) {
      $$$reportNull$$$0(1);
    }
    FqName localFqName = paramClassId.getPackageFqName();
    paramClassId = paramClassId.getRelativeClassName().asString().replace('.', '$');
    if (localFqName.isRoot()) {
      return new JvmClassName(paramClassId);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(localFqName.asString().replace('.', '/'));
    localStringBuilder.append("/");
    localStringBuilder.append(paramClassId);
    return new JvmClassName(localStringBuilder.toString());
  }
  
  @NotNull
  public static JvmClassName byFqNameWithoutInnerClasses(@NotNull FqName paramFqName)
  {
    if (paramFqName == null) {
      $$$reportNull$$$0(2);
    }
    JvmClassName localJvmClassName = new JvmClassName(paramFqName.asString().replace('.', '/'));
    localJvmClassName.fqName = paramFqName;
    return localJvmClassName;
  }
  
  @NotNull
  public static JvmClassName byInternalName(@NotNull String paramString)
  {
    if (paramString == null) {
      $$$reportNull$$$0(0);
    }
    return new JvmClassName(paramString);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if ((paramObject != null) && (getClass() == paramObject.getClass())) {
      return this.internalName.equals(((JvmClassName)paramObject).internalName);
    }
    return false;
  }
  
  @NotNull
  public FqName getFqNameForTopLevelClassMaybeWithDollars()
  {
    return new FqName(this.internalName.replace('/', '.'));
  }
  
  @NotNull
  public String getInternalName()
  {
    String str = this.internalName;
    if (str == null) {
      $$$reportNull$$$0(8);
    }
    return str;
  }
  
  @NotNull
  public FqName getPackageFqName()
  {
    int i = this.internalName.lastIndexOf("/");
    if (i == -1)
    {
      FqName localFqName = FqName.ROOT;
      if (localFqName == null) {
        $$$reportNull$$$0(7);
      }
      return localFqName;
    }
    return new FqName(this.internalName.substring(0, i).replace('/', '.'));
  }
  
  public int hashCode()
  {
    return this.internalName.hashCode();
  }
  
  public String toString()
  {
    return this.internalName;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmClassName
 * JD-Core Version:    0.7.0.1
 */