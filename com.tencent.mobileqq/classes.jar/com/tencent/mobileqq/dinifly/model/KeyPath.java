package com.tencent.mobileqq.dinifly.model;

import android.support.annotation.CheckResult;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KeyPath
{
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
    return ((String)this.keys.get(this.keys.size() - 1)).equals("**");
  }
  
  private boolean isContainer(String paramString)
  {
    return "__container".equals(paramString);
  }
  
  @CheckResult
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY})
  public KeyPath addKey(String paramString)
  {
    KeyPath localKeyPath = new KeyPath(this);
    localKeyPath.keys.add(paramString);
    return localKeyPath;
  }
  
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY})
  public boolean fullyResolvesTo(String paramString, int paramInt)
  {
    if (paramInt >= this.keys.size()) {}
    label117:
    label121:
    do
    {
      int i;
      for (;;)
      {
        return false;
        if (paramInt == this.keys.size() - 1)
        {
          i = 1;
          String str = (String)this.keys.get(paramInt);
          if (str.equals("**")) {
            break;
          }
          if ((!str.equals(paramString)) && (!str.equals("*"))) {
            break label117;
          }
        }
        for (j = 1;; j = 0)
        {
          if (((i == 0) && ((paramInt != this.keys.size() - 2) || (!endsWithGlobstar()))) || (j == 0)) {
            break label121;
          }
          return true;
          i = 0;
          break;
        }
      }
      if ((i == 0) && (((String)this.keys.get(paramInt + 1)).equals(paramString))) {}
      for (int j = 1;; j = 0)
      {
        if (j == 0) {
          break label202;
        }
        if ((paramInt != this.keys.size() - 2) && ((paramInt != this.keys.size() - 3) || (!endsWithGlobstar()))) {
          break;
        }
        return true;
      }
      if (i != 0) {
        return true;
      }
    } while (paramInt + 1 < this.keys.size() - 1);
    label202:
    return ((String)this.keys.get(paramInt + 1)).equals(paramString);
  }
  
  @Nullable
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY})
  public KeyPathElement getResolvedElement()
  {
    return this.resolvedElement;
  }
  
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY})
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
  
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY})
  public boolean matches(String paramString, int paramInt)
  {
    if (isContainer(paramString)) {
      return true;
    }
    if (paramInt >= this.keys.size()) {
      return false;
    }
    return (((String)this.keys.get(paramInt)).equals(paramString)) || (((String)this.keys.get(paramInt)).equals("**")) || (((String)this.keys.get(paramInt)).equals("*"));
  }
  
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY})
  public boolean propagateToChildren(String paramString, int paramInt)
  {
    if ("__container".equals(paramString)) {
      return true;
    }
    if ((paramInt < this.keys.size() - 1) || (((String)this.keys.get(paramInt)).equals("**"))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY})
  public KeyPath resolve(KeyPathElement paramKeyPathElement)
  {
    KeyPath localKeyPath = new KeyPath(this);
    localKeyPath.resolvedElement = paramKeyPathElement;
    return localKeyPath;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("KeyPath{keys=").append(this.keys).append(",resolved=");
    if (this.resolvedElement != null) {}
    for (boolean bool = true;; bool = false) {
      return bool + '}';
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.model.KeyPath
 * JD-Core Version:    0.7.0.1
 */