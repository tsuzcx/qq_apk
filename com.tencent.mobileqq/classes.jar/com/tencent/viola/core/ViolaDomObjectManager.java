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
      return null;
    }
    Class localClass = (Class)sDomObj.get(paramString);
    paramString = localClass;
    if (localClass == null) {
      paramString = DomObject.class;
    }
    return paramString;
  }
  
  public static boolean registerDomObj(String paramString, Class<? extends DomObject> paramClass)
  {
    if (paramClass != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return false;
      }
      if (sDomObj.containsKey(paramString)) {
        return false;
      }
      sDomObj.put(paramString, paramClass);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.viola.core.ViolaDomObjectManager
 * JD-Core Version:    0.7.0.1
 */