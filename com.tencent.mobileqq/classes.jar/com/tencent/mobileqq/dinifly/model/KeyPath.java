package com.tencent.mobileqq.dinifly.model;

import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KeyPath
{
  public static final KeyPath COMPOSITION = new KeyPath(new String[] { "COMPOSITION" });
  private final List<String> keys;
  @Nullable
  private KeyPathElement resolvedElement;
  
  private KeyPath(KeyPath paramKeyPath)
  {
    this.keys = new ArrayList(paramKeyPath.keys);
    this.resolvedElement = paramKeyPath.resolvedElement;
  }
  
  public KeyPath(String... paramVarArgs)
  {
    this.keys = Arrays.asList(paramVarArgs);
  }
  
  private boolean endsWithGlobstar()
  {
    List localList = this.keys;
    return ((String)localList.get(localList.size() - 1)).equals("**");
  }
  
  private boolean isContainer(String paramString)
  {
    return "__container".equals(paramString);
  }
  
  @CheckResult
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
  public KeyPath addKey(String paramString)
  {
    KeyPath localKeyPath = new KeyPath(this);
    localKeyPath.keys.add(paramString);
    return localKeyPath;
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
  public boolean fullyResolvesTo(String paramString, int paramInt)
  {
    int i = this.keys.size();
    boolean bool3 = false;
    boolean bool2 = false;
    if (paramInt >= i) {
      return false;
    }
    if (paramInt == this.keys.size() - 1) {
      i = 1;
    } else {
      i = 0;
    }
    String str = (String)this.keys.get(paramInt);
    int j;
    boolean bool1;
    if (!str.equals("**"))
    {
      if ((!str.equals(paramString)) && (!str.equals("*"))) {
        j = 0;
      } else {
        j = 1;
      }
      if (i == 0)
      {
        bool1 = bool2;
        if (paramInt == this.keys.size() - 2)
        {
          bool1 = bool2;
          if (!endsWithGlobstar()) {}
        }
      }
      else
      {
        bool1 = bool2;
        if (j != 0) {
          bool1 = true;
        }
      }
      return bool1;
    }
    if ((i == 0) && (((String)this.keys.get(paramInt + 1)).equals(paramString))) {
      j = 1;
    } else {
      j = 0;
    }
    if (j != 0)
    {
      if (paramInt != this.keys.size() - 2)
      {
        bool1 = bool3;
        if (paramInt == this.keys.size() - 3)
        {
          bool1 = bool3;
          if (!endsWithGlobstar()) {}
        }
      }
      else
      {
        bool1 = true;
      }
      return bool1;
    }
    if (i != 0) {
      return true;
    }
    paramInt += 1;
    if (paramInt < this.keys.size() - 1) {
      return false;
    }
    return ((String)this.keys.get(paramInt)).equals(paramString);
  }
  
  @Nullable
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
  public KeyPathElement getResolvedElement()
  {
    return this.resolvedElement;
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
  public int incrementDepthBy(String paramString, int paramInt)
  {
    if (isContainer(paramString)) {
      return 0;
    }
    if (!((String)this.keys.get(paramInt)).equals("**")) {
      return 1;
    }
    if (paramInt == this.keys.size() - 1) {
      return 0;
    }
    if (((String)this.keys.get(paramInt + 1)).equals(paramString)) {
      return 2;
    }
    return 0;
  }
  
  public String keysToString()
  {
    return this.keys.toString();
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
  public boolean matches(String paramString, int paramInt)
  {
    if (isContainer(paramString)) {
      return true;
    }
    if (paramInt >= this.keys.size()) {
      return false;
    }
    if ((!((String)this.keys.get(paramInt)).equals(paramString)) && (!((String)this.keys.get(paramInt)).equals("**"))) {
      return ((String)this.keys.get(paramInt)).equals("*");
    }
    return true;
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
  public boolean propagateToChildren(String paramString, int paramInt)
  {
    boolean bool2 = "__container".equals(paramString);
    boolean bool1 = true;
    if (bool2) {
      return true;
    }
    if (paramInt >= this.keys.size() - 1)
    {
      if (((String)this.keys.get(paramInt)).equals("**")) {
        return true;
      }
      bool1 = false;
    }
    return bool1;
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
  public KeyPath resolve(KeyPathElement paramKeyPathElement)
  {
    KeyPath localKeyPath = new KeyPath(this);
    localKeyPath.resolvedElement = paramKeyPathElement;
    return localKeyPath;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("KeyPath{keys=");
    localStringBuilder.append(this.keys);
    localStringBuilder.append(",resolved=");
    boolean bool;
    if (this.resolvedElement != null) {
      bool = true;
    } else {
      bool = false;
    }
    localStringBuilder.append(bool);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.model.KeyPath
 * JD-Core Version:    0.7.0.1
 */