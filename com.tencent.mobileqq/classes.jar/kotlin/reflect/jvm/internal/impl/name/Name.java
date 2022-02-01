package kotlin.reflect.jvm.internal.impl.name;

import org.jetbrains.annotations.NotNull;

public final class Name
  implements Comparable<Name>
{
  @NotNull
  private final String name;
  private final boolean special;
  
  private Name(@NotNull String paramString, boolean paramBoolean)
  {
    this.name = paramString;
    this.special = paramBoolean;
  }
  
  @NotNull
  public static Name guessByFirstCharacter(@NotNull String paramString)
  {
    if (paramString == null) {
      $$$reportNull$$$0(6);
    }
    if (paramString.startsWith("<")) {
      return special(paramString);
    }
    return identifier(paramString);
  }
  
  @NotNull
  public static Name identifier(@NotNull String paramString)
  {
    if (paramString == null) {
      $$$reportNull$$$0(3);
    }
    return new Name(paramString, false);
  }
  
  public static boolean isValidIdentifier(@NotNull String paramString)
  {
    if (paramString == null) {
      $$$reportNull$$$0(4);
    }
    if (!paramString.isEmpty())
    {
      if (paramString.startsWith("<")) {
        return false;
      }
      int i = 0;
      while (i < paramString.length())
      {
        int j = paramString.charAt(i);
        if ((j != 46) && (j != 47))
        {
          if (j == 92) {
            return false;
          }
          i += 1;
        }
        else
        {
          return false;
        }
      }
      return true;
    }
    return false;
  }
  
  @NotNull
  public static Name special(@NotNull String paramString)
  {
    if (paramString == null) {
      $$$reportNull$$$0(5);
    }
    if (paramString.startsWith("<")) {
      return new Name(paramString, true);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("special name must start with '<': ");
    localStringBuilder.append(paramString);
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  @NotNull
  public String asString()
  {
    String str = this.name;
    if (str == null) {
      $$$reportNull$$$0(1);
    }
    return str;
  }
  
  public int compareTo(Name paramName)
  {
    return this.name.compareTo(paramName.name);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof Name)) {
      return false;
    }
    paramObject = (Name)paramObject;
    if (this.special != paramObject.special) {
      return false;
    }
    return this.name.equals(paramObject.name);
  }
  
  @NotNull
  public String getIdentifier()
  {
    if (!this.special)
    {
      localObject = asString();
      if (localObject == null) {
        $$$reportNull$$$0(2);
      }
      return localObject;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("not identifier: ");
    ((StringBuilder)localObject).append(this);
    throw new IllegalStateException(((StringBuilder)localObject).toString());
  }
  
  public int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:632)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public boolean isSpecial()
  {
    return this.special;
  }
  
  public String toString()
  {
    return this.name;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.name.Name
 * JD-Core Version:    0.7.0.1
 */