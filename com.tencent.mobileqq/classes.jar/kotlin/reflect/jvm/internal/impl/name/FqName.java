package kotlin.reflect.jvm.internal.impl.name;

import java.util.List;
import org.jetbrains.annotations.NotNull;

public final class FqName
{
  public static final FqName ROOT = new FqName("");
  @NotNull
  private final FqNameUnsafe fqName;
  private transient FqName parent;
  
  public FqName(@NotNull String paramString)
  {
    this.fqName = new FqNameUnsafe(paramString, this);
  }
  
  public FqName(@NotNull FqNameUnsafe paramFqNameUnsafe)
  {
    this.fqName = paramFqNameUnsafe;
  }
  
  private FqName(@NotNull FqNameUnsafe paramFqNameUnsafe, FqName paramFqName)
  {
    this.fqName = paramFqNameUnsafe;
    this.parent = paramFqName;
  }
  
  @NotNull
  public static FqName topLevel(@NotNull Name paramName)
  {
    if (paramName == null) {
      $$$reportNull$$$0(13);
    }
    return new FqName(FqNameUnsafe.topLevel(paramName));
  }
  
  @NotNull
  public String asString()
  {
    String str = this.fqName.asString();
    if (str == null) {
      $$$reportNull$$$0(4);
    }
    return str;
  }
  
  @NotNull
  public FqName child(@NotNull Name paramName)
  {
    if (paramName == null) {
      $$$reportNull$$$0(8);
    }
    return new FqName(this.fqName.child(paramName), this);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof FqName)) {
      return false;
    }
    paramObject = (FqName)paramObject;
    return this.fqName.equals(paramObject.fqName);
  }
  
  public int hashCode()
  {
    return this.fqName.hashCode();
  }
  
  public boolean isRoot()
  {
    return this.fqName.isRoot();
  }
  
  @NotNull
  public FqName parent()
  {
    FqName localFqName = this.parent;
    if (localFqName != null)
    {
      if (localFqName == null) {
        $$$reportNull$$$0(6);
      }
      return localFqName;
    }
    if (!isRoot())
    {
      this.parent = new FqName(this.fqName.parent());
      localFqName = this.parent;
      if (localFqName == null) {
        $$$reportNull$$$0(7);
      }
      return localFqName;
    }
    throw new IllegalStateException("root");
  }
  
  @NotNull
  public List<Name> pathSegments()
  {
    List localList = this.fqName.pathSegments();
    if (localList == null) {
      $$$reportNull$$$0(11);
    }
    return localList;
  }
  
  @NotNull
  public Name shortName()
  {
    Name localName = this.fqName.shortName();
    if (localName == null) {
      $$$reportNull$$$0(9);
    }
    return localName;
  }
  
  @NotNull
  public Name shortNameOrSpecial()
  {
    Name localName = this.fqName.shortNameOrSpecial();
    if (localName == null) {
      $$$reportNull$$$0(10);
    }
    return localName;
  }
  
  public boolean startsWith(@NotNull Name paramName)
  {
    if (paramName == null) {
      $$$reportNull$$$0(12);
    }
    return this.fqName.startsWith(paramName);
  }
  
  public String toString()
  {
    return this.fqName.toString();
  }
  
  @NotNull
  public FqNameUnsafe toUnsafe()
  {
    FqNameUnsafe localFqNameUnsafe = this.fqName;
    if (localFqNameUnsafe == null) {
      $$$reportNull$$$0(5);
    }
    return localFqNameUnsafe;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.name.FqName
 * JD-Core Version:    0.7.0.1
 */