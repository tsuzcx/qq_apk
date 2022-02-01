package kotlin.reflect.jvm.internal.impl.name;

import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

public final class FqNameUnsafe
{
  private static final Name ROOT_NAME = Name.special("<root>");
  private static final Pattern SPLIT_BY_DOTS = Pattern.compile("\\.");
  private static final Function1<String, Name> STRING_TO_NAME = new FqNameUnsafe.1();
  @NotNull
  private final String fqName;
  private transient FqNameUnsafe parent;
  private transient FqName safe;
  private transient Name shortName;
  
  public FqNameUnsafe(@NotNull String paramString)
  {
    this.fqName = paramString;
  }
  
  FqNameUnsafe(@NotNull String paramString, @NotNull FqName paramFqName)
  {
    this.fqName = paramString;
    this.safe = paramFqName;
  }
  
  private FqNameUnsafe(@NotNull String paramString, FqNameUnsafe paramFqNameUnsafe, Name paramName)
  {
    this.fqName = paramString;
    this.parent = paramFqNameUnsafe;
    this.shortName = paramName;
  }
  
  private void compute()
  {
    int i = this.fqName.lastIndexOf('.');
    if (i >= 0)
    {
      this.shortName = Name.guessByFirstCharacter(this.fqName.substring(i + 1));
      this.parent = new FqNameUnsafe(this.fqName.substring(0, i));
      return;
    }
    this.shortName = Name.guessByFirstCharacter(this.fqName);
    this.parent = FqName.ROOT.toUnsafe();
  }
  
  @NotNull
  public static FqNameUnsafe topLevel(@NotNull Name paramName)
  {
    if (paramName == null) {
      $$$reportNull$$$0(16);
    }
    return new FqNameUnsafe(paramName.asString(), FqName.ROOT.toUnsafe(), paramName);
  }
  
  @NotNull
  public String asString()
  {
    String str = this.fqName;
    if (str == null) {
      $$$reportNull$$$0(4);
    }
    return str;
  }
  
  @NotNull
  public FqNameUnsafe child(@NotNull Name paramName)
  {
    if (paramName == null) {
      $$$reportNull$$$0(9);
    }
    Object localObject;
    if (isRoot())
    {
      localObject = paramName.asString();
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.fqName);
      ((StringBuilder)localObject).append(".");
      ((StringBuilder)localObject).append(paramName.asString());
      localObject = ((StringBuilder)localObject).toString();
    }
    return new FqNameUnsafe((String)localObject, this, paramName);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof FqNameUnsafe)) {
      return false;
    }
    paramObject = (FqNameUnsafe)paramObject;
    return this.fqName.equals(paramObject.fqName);
  }
  
  public int hashCode()
  {
    return this.fqName.hashCode();
  }
  
  public boolean isRoot()
  {
    return this.fqName.isEmpty();
  }
  
  public boolean isSafe()
  {
    return (this.safe != null) || (asString().indexOf('<') < 0);
  }
  
  @NotNull
  public FqNameUnsafe parent()
  {
    FqNameUnsafe localFqNameUnsafe = this.parent;
    if (localFqNameUnsafe != null)
    {
      if (localFqNameUnsafe == null) {
        $$$reportNull$$$0(7);
      }
      return localFqNameUnsafe;
    }
    if (!isRoot())
    {
      compute();
      localFqNameUnsafe = this.parent;
      if (localFqNameUnsafe == null) {
        $$$reportNull$$$0(8);
      }
      return localFqNameUnsafe;
    }
    throw new IllegalStateException("root");
  }
  
  @NotNull
  public List<Name> pathSegments()
  {
    List localList;
    if (isRoot()) {
      localList = Collections.emptyList();
    } else {
      localList = ArraysKt.map(SPLIT_BY_DOTS.split(this.fqName), STRING_TO_NAME);
    }
    if (localList == null) {
      $$$reportNull$$$0(14);
    }
    return localList;
  }
  
  @NotNull
  public Name shortName()
  {
    Name localName = this.shortName;
    if (localName != null)
    {
      if (localName == null) {
        $$$reportNull$$$0(10);
      }
      return localName;
    }
    if (!isRoot())
    {
      compute();
      localName = this.shortName;
      if (localName == null) {
        $$$reportNull$$$0(11);
      }
      return localName;
    }
    throw new IllegalStateException("root");
  }
  
  @NotNull
  public Name shortNameOrSpecial()
  {
    if (isRoot())
    {
      localName = ROOT_NAME;
      if (localName == null) {
        $$$reportNull$$$0(12);
      }
      return localName;
    }
    Name localName = shortName();
    if (localName == null) {
      $$$reportNull$$$0(13);
    }
    return localName;
  }
  
  public boolean startsWith(@NotNull Name paramName)
  {
    if (paramName == null) {
      $$$reportNull$$$0(15);
    }
    if (isRoot()) {
      return false;
    }
    int j = this.fqName.indexOf('.');
    String str = this.fqName;
    paramName = paramName.asString();
    int i = j;
    if (j == -1) {
      i = this.fqName.length();
    }
    return str.regionMatches(0, paramName, 0, i);
  }
  
  @NotNull
  public FqName toSafe()
  {
    FqName localFqName = this.safe;
    if (localFqName != null)
    {
      if (localFqName == null) {
        $$$reportNull$$$0(5);
      }
      return localFqName;
    }
    this.safe = new FqName(this);
    localFqName = this.safe;
    if (localFqName == null) {
      $$$reportNull$$$0(6);
    }
    return localFqName;
  }
  
  @NotNull
  public String toString()
  {
    String str;
    if (isRoot()) {
      str = ROOT_NAME.asString();
    } else {
      str = this.fqName;
    }
    if (str == null) {
      $$$reportNull$$$0(17);
    }
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe
 * JD-Core Version:    0.7.0.1
 */