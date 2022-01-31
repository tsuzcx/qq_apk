package com.tencent.viola.core;

import android.text.TextUtils;
import com.tencent.viola.ui.dom.DomObject;
import java.util.HashMap;
import java.util.Map;

public class ViolaDomObjectManager
{
  private static Map<String, Class<? extends DomObject>> sDomObj = new HashMap();
  
  public static Class<? extends DomObject> getDomObjClz(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      paramString = null;
    }
    Class localClass;
    do
    {
      return paramString;
      localClass = (Class)sDomObj.get(paramString);
      paramString = localClass;
    } while (localClass != null);
    return DomObject.class;
  }
  
  public static boolean registerDomObj(String paramString, Class<? extends DomObject> paramClass)
  {
    if ((paramClass == null) || (TextUtils.isEmpty(paramString))) {}
    while (sDomObj.containsKey(paramString)) {
      return false;
    }
    sDomObj.put(paramString, paramClass);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.viola.core.ViolaDomObjectManager
 * JD-Core Version:    0.7.0.1
 */