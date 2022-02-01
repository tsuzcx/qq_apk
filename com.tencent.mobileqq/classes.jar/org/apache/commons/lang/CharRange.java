package org.apache.commons.lang;

import java.io.Serializable;
import java.util.Iterator;
import org.apache.commons.lang.text.StrBuilder;

public final class CharRange
  implements Serializable
{
  private static final long serialVersionUID = 8270183163158333422L;
  private final char end;
  private transient String iToString;
  private final boolean negated;
  private final char start;
  
  public CharRange(char paramChar)
  {
    this(paramChar, paramChar, false);
  }
  
  public CharRange(char paramChar1, char paramChar2)
  {
    this(paramChar1, paramChar2, false);
  }
  
  public CharRange(char paramChar1, char paramChar2, boolean paramBoolean)
  {
    char c2 = paramChar1;
    char c1 = paramChar2;
    if (paramChar1 > paramChar2)
    {
      c1 = paramChar1;
      c2 = paramChar2;
    }
    this.start = c2;
    this.end = c1;
    this.negated = paramBoolean;
  }
  
  public CharRange(char paramChar, boolean paramBoolean)
  {
    this(paramChar, paramChar, paramBoolean);
  }
  
  public static CharRange is(char paramChar)
  {
    return new CharRange(paramChar, paramChar, false);
  }
  
  public static CharRange isIn(char paramChar1, char paramChar2)
  {
    return new CharRange(paramChar1, paramChar2, false);
  }
  
  public static CharRange isNot(char paramChar)
  {
    return new CharRange(paramChar, paramChar, true);
  }
  
  public static CharRange isNotIn(char paramChar1, char paramChar2)
  {
    return new CharRange(paramChar1, paramChar2, true);
  }
  
  public boolean contains(char paramChar)
  {
    int i;
    if ((paramChar >= this.start) && (paramChar <= this.end)) {
      i = 1;
    } else {
      i = 0;
    }
    return i != this.negated;
  }
  
  public boolean contains(CharRange paramCharRange)
  {
    if (paramCharRange != null)
    {
      boolean bool2 = this.negated;
      boolean bool1 = true;
      if (bool2)
      {
        if (paramCharRange.negated) {
          return (this.start >= paramCharRange.start) && (this.end <= paramCharRange.end);
        }
        if (paramCharRange.end >= this.start)
        {
          if (paramCharRange.start > this.end) {
            return true;
          }
          bool1 = false;
        }
        return bool1;
      }
      if (paramCharRange.negated) {
        return (this.start == 0) && (this.end == 65535);
      }
      return (this.start <= paramCharRange.start) && (this.end >= paramCharRange.end);
    }
    throw new IllegalArgumentException("The Range must not be null");
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof CharRange)) {
      return false;
    }
    paramObject = (CharRange)paramObject;
    return (this.start == paramObject.start) && (this.end == paramObject.end) && (this.negated == paramObject.negated);
  }
  
  public char getEnd()
  {
    return this.end;
  }
  
  public char getStart()
  {
    return this.start;
  }
  
  public int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:632)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public boolean isNegated()
  {
    return this.negated;
  }
  
  public Iterator iterator()
  {
    return new CharRange.CharacterIterator(this, null);
  }
  
  public String toString()
  {
    if (this.iToString == null)
    {
      StrBuilder localStrBuilder = new StrBuilder(4);
      if (isNegated()) {
        localStrBuilder.append('^');
      }
      localStrBuilder.append(this.start);
      if (this.start != this.end)
      {
        localStrBuilder.append('-');
        localStrBuilder.append(this.end);
      }
      this.iToString = localStrBuilder.toString();
    }
    return this.iToString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     org.apache.commons.lang.CharRange
 * JD-Core Version:    0.7.0.1
 */