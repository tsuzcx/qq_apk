package kotlin.reflect.jvm.internal.impl.name;

import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ClassId
{
  private final boolean local;
  private final FqName packageFqName;
  private final FqName relativeClassName;
  
  public ClassId(@NotNull FqName paramFqName1, @NotNull FqName paramFqName2, boolean paramBoolean)
  {
    this.packageFqName = paramFqName1;
    this.relativeClassName = paramFqName2;
    this.local = paramBoolean;
  }
  
  public ClassId(@NotNull FqName paramFqName, @NotNull Name paramName)
  {
    this(paramFqName, FqName.topLevel(paramName), false);
  }
  
  @NotNull
  public static ClassId fromString(@NotNull String paramString)
  {
    if (paramString == null) {
      $$$reportNull$$$0(11);
    }
    return fromString(paramString, false);
  }
  
  @NotNull
  public static ClassId fromString(@NotNull String paramString, boolean paramBoolean)
  {
    if (paramString == null) {
      $$$reportNull$$$0(12);
    }
    String str = StringsKt.substringBeforeLast(paramString, '/', "").replace('/', '.');
    paramString = StringsKt.substringAfterLast(paramString, '/', paramString);
    return new ClassId(new FqName(str), new FqName(paramString), paramBoolean);
  }
  
  @NotNull
  public static ClassId topLevel(@NotNull FqName paramFqName)
  {
    if (paramFqName == null) {
      $$$reportNull$$$0(0);
    }
    return new ClassId(paramFqName.parent(), paramFqName.shortName());
  }
  
  @NotNull
  public FqName asSingleFqName()
  {
    if (this.packageFqName.isRoot())
    {
      localObject = this.relativeClassName;
      if (localObject == null) {
        $$$reportNull$$$0(9);
      }
      return localObject;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.packageFqName.asString());
    ((StringBuilder)localObject).append(".");
    ((StringBuilder)localObject).append(this.relativeClassName.asString());
    return new FqName(((StringBuilder)localObject).toString());
  }
  
  @NotNull
  public String asString()
  {
    if (this.packageFqName.isRoot())
    {
      localObject = this.relativeClassName.asString();
      if (localObject == null) {
        $$$reportNull$$$0(13);
      }
      return localObject;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.packageFqName.asString().replace('.', '/'));
    ((StringBuilder)localObject).append("/");
    ((StringBuilder)localObject).append(this.relativeClassName.asString());
    localObject = ((StringBuilder)localObject).toString();
    if (localObject == null) {
      $$$reportNull$$$0(14);
    }
    return localObject;
  }
  
  @NotNull
  public ClassId createNestedClassId(@NotNull Name paramName)
  {
    if (paramName == null) {
      $$$reportNull$$$0(8);
    }
    return new ClassId(getPackageFqName(), this.relativeClassName.child(paramName), this.local);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject != null)
    {
      if (getClass() != paramObject.getClass()) {
        return false;
      }
      paramObject = (ClassId)paramObject;
      return (this.packageFqName.equals(paramObject.packageFqName)) && (this.relativeClassName.equals(paramObject.relativeClassName)) && (this.local == paramObject.local);
    }
    return false;
  }
  
  @Nullable
  public ClassId getOuterClassId()
  {
    FqName localFqName = this.relativeClassName.parent();
    if (localFqName.isRoot()) {
      return null;
    }
    return new ClassId(getPackageFqName(), localFqName, this.local);
  }
  
  @NotNull
  public FqName getPackageFqName()
  {
    FqName localFqName = this.packageFqName;
    if (localFqName == null) {
      $$$reportNull$$$0(5);
    }
    return localFqName;
  }
  
  @NotNull
  public FqName getRelativeClassName()
  {
    FqName localFqName = this.relativeClassName;
    if (localFqName == null) {
      $$$reportNull$$$0(6);
    }
    return localFqName;
  }
  
  @NotNull
  public Name getShortClassName()
  {
    Name localName = this.relativeClassName.shortName();
    if (localName == null) {
      $$$reportNull$$$0(7);
    }
    return localName;
  }
  
  public int hashCode()
  {
    return (this.packageFqName.hashCode() * 31 + this.relativeClassName.hashCode()) * 31 + Boolean.valueOf(this.local).hashCode();
  }
  
  public boolean isLocal()
  {
    return this.local;
  }
  
  public boolean isNestedClass()
  {
    return this.relativeClassName.parent().isRoot() ^ true;
  }
  
  public String toString()
  {
    if (this.packageFqName.isRoot())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("/");
      localStringBuilder.append(asString());
      return localStringBuilder.toString();
    }
    return asString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.name.ClassId
 * JD-Core Version:    0.7.0.1
 */