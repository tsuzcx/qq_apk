package com.tencent.qcircle.shadow.core.runtime;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;

public abstract class FixedContextLayoutInflater
  extends LayoutInflater
{
  private static final String[] sClassPrefixList = { "android.widget.", "android.webkit.", "android.app." };
  
  public FixedContextLayoutInflater(Context paramContext)
  {
    super(paramContext);
  }
  
  public FixedContextLayoutInflater(LayoutInflater paramLayoutInflater, Context paramContext)
  {
    super(paramLayoutInflater, paramContext);
  }
  
  abstract Pair<String, String> changeViewNameAndPrefix(String paramString1, String paramString2);
  
  public LayoutInflater cloneInContext(Context paramContext)
  {
    return createNewContextLayoutInflater(paramContext);
  }
  
  abstract LayoutInflater createNewContextLayoutInflater(Context paramContext);
  
  protected View onCreateView(String paramString, AttributeSet paramAttributeSet)
  {
    String[] arrayOfString = sClassPrefixList;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = arrayOfString[i];
      try
      {
        localObject = changeViewNameAndPrefix((String)localObject, paramString);
        localObject = createView((String)((Pair)localObject).first, (String)((Pair)localObject).second, paramAttributeSet);
        if (localObject != null) {
          return localObject;
        }
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        label64:
        break label64;
      }
      i += 1;
    }
    return super.onCreateView(paramString, paramAttributeSet);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.shadow.core.runtime.FixedContextLayoutInflater
 * JD-Core Version:    0.7.0.1
 */